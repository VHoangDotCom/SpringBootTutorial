package com.file.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import com.file.ResponseData;
import com.file.entity.Attachment;
import com.file.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Map;

@RestController
public class AttachmentController {

    private AttachmentService attachmentService;

    @Autowired
    private Cloudinary cloudinary = Singleton.getCloudinary();

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        Attachment attachment = null;
        String downloadURL = "";
        attachment = attachmentService.saveAttachment(file);
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

//           this.cloudinary.uploader().upload(file.getBytes(),
//                ObjectUtils.emptyMap());
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String oldName = uploadResult.get("public_id").toString();
        uploadResult = cloudinary.uploader().rename(oldName, "My Girl", ObjectUtils.emptyMap());

        String url = uploadResult.get("url").toString();

        System.out.println(url);

        return new ResponseData(attachment.getFileName(),
                downloadURL,
                file.getContentType(),
                file.getSize());
    }

    @PostMapping("/destroy/{public_id}")
    public String destroyCloudFile(@PathVariable String public_id) throws IOException {
        String findID =  cloudinary.randomPublicId().getBytes(public_id).toString();

        Map destroyResult = cloudinary.uploader().destroy(public_id, ObjectUtils.emptyMap());

        if (!destroyResult.isEmpty()){
            return "Delete " + public_id + " successfully!";
        }
        return "Cannot find this file!";
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
}

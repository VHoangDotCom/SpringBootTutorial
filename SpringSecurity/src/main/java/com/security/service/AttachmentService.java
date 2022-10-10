package com.security.service;

import com.security.domain.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment (MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}

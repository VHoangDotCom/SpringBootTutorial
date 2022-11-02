package com.file.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import com.file.entity.Product;
import com.file.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @Autowired
    private Cloudinary cloudinary = Singleton.getCloudinary();

    @GetMapping("")
    public List<Product> getAllProducts() {
      return productService.getAllProducts();
    }

    @PostMapping("/uploadProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String urlImage = uploadResult.get("url").toString();
        System.out.println(urlImage);

        product.setFile(file);
        product.setImage(urlImage);

        System.out.println(product);

        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)  {

        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }
}

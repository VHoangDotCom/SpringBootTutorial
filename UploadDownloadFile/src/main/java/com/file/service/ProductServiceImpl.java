package com.file.service;

import com.file.entity.Product;
import com.file.exception.ResourceNotFoundException;
import com.file.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", id));
    }

    @Override
    public Product updateProduct(Product product, long id) {
        // check whether employee with given id is existed or not
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "Id", id));

        existingProduct.setName(product.getName());
        existingProduct.setFile(product.getFile());
        existingProduct.setImage(product.getImage());

        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(long id) {
        // check whether employee with given id is existed or not
        productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "Id", id));

        productRepository.deleteById(id);
    }
}

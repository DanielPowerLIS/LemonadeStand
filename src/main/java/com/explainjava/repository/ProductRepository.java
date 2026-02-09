package main.java.com.explainjava.repository;

import main.java.com.explainjava.domain.Product;
import main.java.com.explainjava.exceptions.IDNotUniqueException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<Integer, Product> products;

    public ProductRepository(){
        this.products = new HashMap<>();
    }

    public Product save(Product product)throws IDNotUniqueException {
        if(products.containsKey(product.getId())){
            throw new IDNotUniqueException("The id is not unique");
        }

        products.put(product.getId(), product);
        return product;
    }

    public Product update(Product updateProduct){
        if(products.containsKey(updateProduct.getId())){
            products.put(updateProduct.getId(), updateProduct);
        }

        return updateProduct;
    }

    public void delete(int productId){
        products.remove(productId);
    }

    public Iterable<Product> findAll(){
        return products.values();
    }

    public Product findById(int productId){
        return products.get(productId);
    }
}

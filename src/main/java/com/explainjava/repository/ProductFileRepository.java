package main.java.com.explainjava.repository;

import main.java.com.explainjava.domain.Product;
import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.IDNotUniqueException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFileRepository extends ProductRepository{
    private String filename;

    public ProductFileRepository(String filename)throws  IDNotUniqueException{
        super();
        this.filename  = filename;
        loadProductsFromFile();
    }

    @Override
    public Product save(Product product)throws IDNotUniqueException {
        Product savedProduct = super.save(product);
        writeToFile();
        return savedProduct;
    }

    @Override
    public Product update(Product product){
        Product updatedProduct = super.update(product);
        writeToFile();
        return updatedProduct;
    }

    @Override
    public void delete(int productId){
        super.delete(productId);
        writeToFile();
    }

    public List<Product> readProductsFromFile(){
        List<Product> products = new ArrayList<>();
        BufferedReader reader = null;
        try{
           reader = new BufferedReader(new FileReader(filename));
           String line;
           while((line = reader.readLine()) !=  null){
               String[] elems = line.split(",");

               int id = Integer.parseInt(elems[0]);
               String name = elems[1];
               String description = elems[2];
               int price = Integer.parseInt(elems[3]);
               int quantity = Integer.parseInt(elems[4]);
               int supplierID = Integer.parseInt(elems[5]);

               Supplier supplier = new Supplier();
               supplier.setId(supplierID);

               Product product = new Product(id, name, description, price, quantity, supplier);
               products.add(product);

           }

           reader.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return products;
    }

    public void loadProductsFromFile()throws IDNotUniqueException{
        List<Product> products = readProductsFromFile();
        for (Product product : products){
            this.save(product);
        }


    }

    public void writeToFile(){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(filename));
            Iterable<Product> products = findAll();
            for(Product product : products){
                String line = product.getId() + "," + product.getName() + "," + product.getDescription() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getSupplier().getId();
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

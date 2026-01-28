package main.java.com.explainjava.repository;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.IDNotUniqueException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierFileRepository extends SupplierRepository{

    private String filename;

    public SupplierFileRepository(String filename) throws IDNotUniqueException{
        super();
        this.filename = filename;
        loadSupplierFromFile();
    }

    @Override
    public Supplier save(Supplier supplier)throws IDNotUniqueException{
        Supplier savedSupplier = super.save(supplier);
        writeToFile();
        return savedSupplier;
    }

    @Override
    public Supplier update(Supplier supplier){
        Supplier updatedSupplier = super.update(supplier);
        writeToFile();
        return updatedSupplier;
    }

    @Override
    public void delete(int supplierId){
        super.delete(supplierId);
        writeToFile();
    }

    public List<Supplier> readSuppliersFromFile(){
        List<Supplier> suppliers = new ArrayList<>();
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null){
                String[] elems = line.split(",");

                int id = Integer.parseInt(elems[0]);
                String name = elems[1];
                String contactEmail = elems[2];

                Supplier supplier = new Supplier(id, name, contactEmail);
                suppliers.add(supplier);
            }

            reader.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return suppliers;
    }

    private void writeToFile(){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(filename));
            Iterable<Supplier> suppliers = findAll();

            for(Supplier supplier : suppliers){
                String line = supplier.getId() + "," + supplier.getName() + "," + supplier.getEmail();
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void loadSupplierFromFile()throws IDNotUniqueException{
        List<Supplier> suppliers = readSuppliersFromFile();
        for(Supplier supplier: suppliers){
            this.save(supplier);
        }

    }
}

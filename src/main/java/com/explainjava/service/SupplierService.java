package main.java.com.explainjava.service;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.IDNotUniqueException;
import main.java.com.explainjava.exceptions.ValidationException;
import main.java.com.explainjava.repository.SupplierRepository;
import main.java.com.explainjava.validators.SupplierValidator;

import java.util.Set;

public class SupplierService {
    private SupplierRepository supplierRepository;
    private SupplierValidator supplierValidator;

    public SupplierService(SupplierRepository supplierRepository, SupplierValidator supplierValidator){
        this.supplierRepository = supplierRepository;
        this.supplierValidator = supplierValidator;
    }

    public Supplier saveSupplier(String name, String contactEmail) throws IDNotUniqueException, ValidationException {
        Set<Integer> suppliersId = this.supplierRepository.getAllIds();
        int id = GenerateIdSupplier.generateID(suppliersId);

        Supplier supplier = new Supplier(id, name, contactEmail);
        return this.supplierRepository.save(supplier);
    }

    public void removeSupplier(int supplierId){
        this.supplierRepository.delete(supplierId);
    }

    public Supplier updateSupplier(int id, String newName, String newContactEmail){
        Supplier exist = findById(id);

        if(exist == null){
            throw new IllegalArgumentException("El proveedor no existe");
        }

        Supplier supplierToUpdate = new Supplier(id, newName, newContactEmail);
        Supplier updatedSupplier = this.supplierRepository.update(supplierToUpdate);
        return updatedSupplier;
    }

    public Iterable<Supplier> findAll(){
        return this.supplierRepository.findAll();
    }

    public Supplier findById(int id){
        return this.supplierRepository.findById(id);
    }


}

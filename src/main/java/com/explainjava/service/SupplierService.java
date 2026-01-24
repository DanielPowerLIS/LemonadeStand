package main.java.com.explainjava.service;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.repository.SupplierRepository;

import java.util.Set;

public class SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public Supplier saveSupplier(String name, String contacEmail){
        Set<Integer> suppliersId = this.supplierRepository.getAllIds();
        int id = GenerateIdSupplier.generateID(suppliersId);

        Supplier supplier = new Supplier(id, name, contacEmail);
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

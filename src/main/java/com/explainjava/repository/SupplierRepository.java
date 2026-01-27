package main.java.com.explainjava.repository;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.IDNotUniqueException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SupplierRepository {
    private Map<Integer, Supplier> suppliers;
    
    //Tabla hash, ID como clave y Proveedor como valor
    public SupplierRepository(){
        this.suppliers = new HashMap<>();
    }

    //Metodo utilizado para guardar un Proveedor
    public Supplier save(Supplier supplier) throws IDNotUniqueException {
        if(suppliers.containsKey(supplier.getId())){
            throw new IDNotUniqueException("The id is not unique ");
        }

        suppliers.put(supplier.getId(), supplier);
        return supplier;
    }

    //Metodo utilizado para actualizar un proveedor
    public Supplier update(Supplier supplier){
        if(this.suppliers.containsKey(supplier.getId())){
            this.suppliers.put(supplier.getId(), supplier);
        }

        return supplier;
    }

    //Metdod para eliminar un proveedor
    public void delete(int supplierId){
        this.suppliers.remove(supplierId);
    }

    //Metodo para leer todos los proveedores
    public Iterable<Supplier> findAll(){
        return this.suppliers.values();
    }

    //Metodo para leer a 1 solo proveedor
    public Supplier findById(int entityId){
        return this.suppliers.get(entityId);
    }

    public Set<Integer> getAllIds(){
        return this.suppliers.keySet();
    }
}

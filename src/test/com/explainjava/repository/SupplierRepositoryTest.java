package test.com.explainjava.repository;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.IDNotUniqueException;
import main.java.com.explainjava.exceptions.ValidationException;
import main.java.com.explainjava.repository.SupplierRepository;

import java.awt.*;

public class SupplierRepositoryTest {

    public void shouldSaveOneElement_whenSaveIsCalled()throws IDNotUniqueException{
        SupplierRepository supplierRepositoryTest = new SupplierRepository();
        Supplier firstSupplierToSave = new Supplier(1, "Lemonades", "contact@lemonadesTest.com");

        Supplier firstSaveSupplier = supplierRepositoryTest.save(firstSupplierToSave);

        assert firstSaveSupplier != null;
        assert firstSaveSupplier.getId() == 1;
        assert firstSaveSupplier.getName() == "Lemonades";
        assert supplierRepositoryTest.findById(2) == null;

    }

    public void shoulSaveTwoElements_whenSaveIsCalledTwice()throws IDNotUniqueException{
        SupplierRepository supplierRepositoryTest = new SupplierRepository();

        Supplier firstSupplierToSave = new Supplier(1, "Lemonades", "contact@lemonadesTest.com");
        Supplier firstSaveSupplier = supplierRepositoryTest.save(firstSupplierToSave);

        Supplier secondSupplierToSave = new Supplier(2, "Water", "contact@wwaterTest.com");
        Supplier secondSavedSupplier = supplierRepositoryTest.save(secondSupplierToSave);

        assert firstSaveSupplier.getId() == 1;
        assert firstSaveSupplier.getName().equals("Lemonades");
        assert supplierRepositoryTest.findById(3) == null;

        assert secondSavedSupplier != null;
        assert secondSavedSupplier.getId() == 2;
        assert secondSavedSupplier.getName().equals("Water");

        assert supplierRepositoryTest.findById(1) != null;
        assert supplierRepositoryTest.findById(2) != null;

    }

    public void shouldUpdateSupplier_whenUpdateMethodCalled() throws IDNotUniqueException{
        SupplierRepository supplierRepositoryTest = new SupplierRepository();

        Supplier supplierToUpdate = new Supplier(1, "Lemonades", "contact@lemonadesTest.com");
        supplierRepositoryTest.save(supplierToUpdate);

        supplierToUpdate.setName("Burger");
        supplierToUpdate.setEmail("contact@burgersTest.com");

        Supplier updatedSupplier = supplierRepositoryTest.update(supplierToUpdate);
        assert updatedSupplier != null;
        assert updatedSupplier.getId() == 1;
        assert updatedSupplier.getName().equals("Burger");
        assert updatedSupplier.getEmail().equals("contact@burgersTest.com");

    }

    public void shoulDeleteSupplier_whenDeletedMethodIsCalled() throws IDNotUniqueException{
        SupplierRepository supplierRepositoryTest = new SupplierRepository();

        Supplier supplierToDelete = new Supplier(1, "Lemonades", "contact@lemonades.com");
        supplierRepositoryTest.save(supplierToDelete);

        supplierRepositoryTest.delete(1);

        Supplier deletedSuppplier = supplierRepositoryTest.findById(1);

        assert deletedSuppplier == null;

    }

    public void shouldFindSupplier_whenFindMethodIsCalled() throws IDNotUniqueException {
        SupplierRepository supplierRepositoryTest = new SupplierRepository();

        Supplier firsSupplierToSave = new Supplier(1, "Lemonades", "contac@lemonades.com");
        supplierRepositoryTest.save(firsSupplierToSave);

        Supplier secondSupplierToSave = new Supplier(2, "Water", "contact@water.com");
        supplierRepositoryTest.save(secondSupplierToSave);

        Supplier firstSupplier = supplierRepositoryTest.findById(1);
        Supplier secondSupplier = supplierRepositoryTest.findById(2);

        assert firstSupplier.getId() == 1;
        assert secondSupplier.getId() == 2;
    }

    public void testAllRepository() throws ValidationException, IDNotUniqueException {
        shouldSaveOneElement_whenSaveIsCalled();
        shoulSaveTwoElements_whenSaveIsCalledTwice();
        shouldUpdateSupplier_whenUpdateMethodCalled();
        shoulDeleteSupplier_whenDeletedMethodIsCalled();
        shouldFindSupplier_whenFindMethodIsCalled();
    }
}

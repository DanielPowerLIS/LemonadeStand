package test.com.explainjava.service;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.IDNotUniqueException;
import main.java.com.explainjava.exceptions.ValidationException;
import main.java.com.explainjava.repository.SupplierRepository;
import main.java.com.explainjava.service.SupplierService;
import main.java.com.explainjava.validators.SupplierValidator;

public class SupplierServiceTest {
    private SupplierService supplierServiceTest;

    private void setUp(){
        SupplierRepository supplierRepositoryTest = new SupplierRepository();
        SupplierValidator supplierValidator = new SupplierValidator();
        supplierServiceTest = new SupplierService(supplierRepositoryTest, supplierValidator);

    }

    public void shouldSaveSupplier_whenSaveMethodIsCalled() throws IDNotUniqueException, ValidationException {
        setUp();

        Supplier savedSupplier = supplierServiceTest.saveSupplier("Lemonades,", "contact@lemonadesTest.com");

        assert savedSupplier != null;
        assert savedSupplier.getId() == 1;
        assert savedSupplier.getName().equals("Lemonades");
        assert supplierServiceTest.findById(1).getId() == 1;

    }

    public void shouldUpdateSupplier_whenUpdateMethodIsCalled() throws IDNotUniqueException, ValidationException {
        setUp();

        Supplier savedSupplier = supplierServiceTest.saveSupplier("Lemonades", "contact@lemonadesTest.com");
        Supplier updatedSupplier = supplierServiceTest.updateSupplier(1, "Burger", "contact@burgersTest,com");

        assert updatedSupplier != null;
        assert updatedSupplier.getId() == 1;
        assert updatedSupplier.getName().equals("Burger");
        assert updatedSupplier.getEmail().equals("contact@burgersTest.com");
    }

    public void shouldRemoveSupplier_whenRemoveMethodIsCalled() throws IDNotUniqueException, ValidationException {
        setUp();

        Supplier savedSupplier = supplierServiceTest.saveSupplier("Lemonades", "contact@lemonadesTest.com");
        supplierServiceTest.removeSupplier(1);

        Supplier deletedSupplier = supplierServiceTest.findById(1);
        assert deletedSupplier == null;
    }

    public void shouldFindSupplier_whenFindMethodIsCalled() throws IDNotUniqueException, ValidationException {
        setUp();

        supplierServiceTest.saveSupplier("Lemoandes", "contact@lemonadesTest.com");
        supplierServiceTest.saveSupplier("Water", "contact@waterTest.com");

        Supplier firstSupplier = supplierServiceTest.findById(1);
        Supplier secondSupplier = supplierServiceTest.findById(2);

        assert firstSupplier.getId() == 1;
        assert secondSupplier.getId() == 2;

    }

    public void testAllService() throws ValidationException, IDNotUniqueException {
        shouldSaveSupplier_whenSaveMethodIsCalled();
        shouldUpdateSupplier_whenUpdateMethodIsCalled();
        shouldRemoveSupplier_whenRemoveMethodIsCalled();
        shouldFindSupplier_whenFindMethodIsCalled();
    }
}

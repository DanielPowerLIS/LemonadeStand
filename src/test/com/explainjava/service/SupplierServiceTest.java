package test.com.explainjava.service;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.repository.SupplierRepository;
import main.java.com.explainjava.service.SupplierService;

public class SupplierServiceTest {
    private SupplierService supplierServiceTest;

    private void setUp(){
        SupplierRepository supplierRepositoryTest = new SupplierRepository();
        supplierServiceTest = new SupplierService(supplierRepositoryTest);

    }

    public void shouldSaveSupplier_whenSaveMethodIsCalled(){
        setUp();

        Supplier savedSupplier = supplierServiceTest.saveSupplier("Lemonades,", "contact@lemonadesTest.com");

        assert savedSupplier != null;
        assert savedSupplier.getId() == 1;
        assert savedSupplier.getName().equals("Lemonades");
        assert supplierServiceTest.findById(1).getId() == 1;

    }

    public void shouldUpdateSupplier_whenUpdateMethodIsCalled(){
        setUp();

        Supplier savedSupplier = supplierServiceTest.saveSupplier("Lemonades", "contact@lemonadesTest.com");
        Supplier updatedSupplier = supplierServiceTest.updateSupplier(1, "Burger", "contact@burgersTest,com");

        assert updatedSupplier != null;
        assert updatedSupplier.getId() == 1;
        assert updatedSupplier.getName().equals("Burger");
        assert updatedSupplier.getEmail().equals("contact@burgersTest.com");
    }

    public void shouldRemoveSupplier_whenRemoveMethodIsCalled(){
        setUp();

        Supplier savedSupplier = supplierServiceTest.saveSupplier("Lemonades", "contact@lemonadesTest.com");
        supplierServiceTest.removeSupplier(1);

        Supplier deletedSupplier = supplierServiceTest.findById(1);
        assert deletedSupplier == null;
    }

    public void shouldFindSupplier_whenFindMethodIsCalled(){
        setUp();

        supplierServiceTest.saveSupplier("Lemoandes", "contact@lemonadesTest.com");
        supplierServiceTest.saveSupplier("Water", "contact@waterTest.com");

        Supplier firstSupplier = supplierServiceTest.findById(1);
        Supplier secondSupplier = supplierServiceTest.findById(2);

        assert firstSupplier.getId() == 1;
        assert secondSupplier.getId() == 2;

    }

    public void testAllService(){
        shouldSaveSupplier_whenSaveMethodIsCalled();
        shouldUpdateSupplier_whenUpdateMethodIsCalled();
        shouldRemoveSupplier_whenRemoveMethodIsCalled();
        shouldFindSupplier_whenFindMethodIsCalled();
    }
}

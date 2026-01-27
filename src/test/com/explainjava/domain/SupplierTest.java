package test.com.explainjava.domain;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.IDNotUniqueException;
import main.java.com.explainjava.exceptions.ValidationException;
import main.java.com.explainjava.repository.SupplierRepository;

public class SupplierTest {


    public void shouldGetCorrectValues_whenConstructorIsCalled(){
        Supplier supplierTest = new Supplier(1, "Lemonades", "contact@lemonades.com");

        assert supplierTest.getId() == 1;
        assert supplierTest.getName().equals("Lemonades");
        assert supplierTest.getEmail().equals("contact@lemonades.com");
    }

    public void shouldSetCorrectVales_whenSettersAreUse(){
        Supplier supplierTest = new Supplier(1, "Lemonades", "contact@lemonades.com");

        supplierTest.setId(2);
        supplierTest.setName("Lemondaes Test");
        supplierTest.setEmail("contact@lemonadesTest.com");

        assert supplierTest.getId() == 2;
        assert supplierTest.getName().equals("Lemonades Test");
        assert supplierTest.getEmail().equals("contact@lemonadesTest.com");
    }

//  Este metodo solo fue agregado para probar las excepciones
//    public void shouldNotSaveTheElement_whenWeAddNotUniqueElement() throws IDNotUniqueException {
//        SupplierRepository supplierRepository = new SupplierRepository();
//        Supplier firstSupplierToSave = new Supplier(1, "Lemonades", "contact@lemonades.com");
//        Supplier secondSupplierToSave = new Supplier(1, "Lemonades", "contact@lemonades.com");
//
//        Supplier firstSavedSupplier = supplierRepository.save(firstSupplierToSave);
//        Supplier secondSavedSupplier = supplierRepository.save(secondSupplierToSave);
//        assert false;
//    }

    public void testAllDomain() throws ValidationException, IDNotUniqueException{
        shouldGetCorrectValues_whenConstructorIsCalled();
        shouldSetCorrectVales_whenSettersAreUse();
//        shouldNotSaveTheElement_whenWeAddNotUniqueElement();
    }
}

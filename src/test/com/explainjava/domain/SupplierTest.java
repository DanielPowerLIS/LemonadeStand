package test.com.explainjava.domain;

import main.java.com.explainjava.domain.Supplier;

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
        assert supplierTest.getName() == "Lemonades Test";
        assert supplierTest.getEmail() == "contact@lemonadesTest.com";
    }

    public void testAllDomain(){
        shouldGetCorrectValues_whenConstructorIsCalled();
        shouldSetCorrectVales_whenSettersAreUse();
    }
}

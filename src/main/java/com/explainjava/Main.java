package main.java.com.explainjava;

import main.java.com.explainjava.exceptions.IDNotUniqueException;
import main.java.com.explainjava.exceptions.ValidationException;
import main.java.com.explainjava.repository.ProductFileRepository;
import main.java.com.explainjava.repository.SupplierFileRepository;
import main.java.com.explainjava.service.ProductService;
import main.java.com.explainjava.service.SupplierService;
import main.java.com.explainjava.userinterface.UserInterface;
import main.java.com.explainjava.validators.ProductValidator;
import main.java.com.explainjava.validators.SupplierValidator;
import test.com.explainjava.MainTest;

public class Main {
    public static void main(String[] args) throws ValidationException, IDNotUniqueException {

        SupplierFileRepository supplierFileRepository = new SupplierFileRepository("supplier.csv");
        SupplierValidator supplierValidator = new SupplierValidator();
        SupplierService supplierService = new SupplierService(supplierFileRepository, supplierValidator);

        ProductFileRepository productFileRepository = new ProductFileRepository("products.csv");
        ProductValidator productValidator = new ProductValidator();
        ProductService productService = new ProductService(productFileRepository, productValidator, supplierService);

        UserInterface userInterface = new UserInterface(productService, supplierService);

        MainTest tests = new MainTest();
        tests.runAllTest();

        userInterface.runMenu();

    }
}
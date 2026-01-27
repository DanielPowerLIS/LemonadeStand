package test.com.explainjava;

import main.java.com.explainjava.exceptions.IDNotUniqueException;
import main.java.com.explainjava.exceptions.ValidationException;
import main.java.com.explainjava.service.SupplierService;
import test.com.explainjava.domain.SupplierTest;
import test.com.explainjava.repository.SupplierRepositoryTest;
import test.com.explainjava.service.SupplierServiceTest;

public class MainTest {

    public void runAllTest() {

        try{
            SupplierTest domainTests = new SupplierTest();
            domainTests.testAllDomain();

            SupplierRepositoryTest repositoryTests = new SupplierRepositoryTest();
            repositoryTests.testAllRepository();

            SupplierServiceTest serviceTests = new SupplierServiceTest();
            serviceTests.testAllService();

            System.out.println("All tests have run succesfully");
        }catch (ValidationException | IDNotUniqueException e){
            System.out.println("The test are failed, e=" + e.getMessage());
        }

    }
}

package main.java.com.explainjava.validators;

import main.java.com.explainjava.domain.Supplier;
import main.java.com.explainjava.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplierValidator {

    public void validateSupplier(Supplier supplierToValidate) throws ValidationException {
        StringBuilder stringBuilder = new StringBuilder();
        if(supplierToValidate.getName().length() < 3 || supplierToValidate.getName().length() > 100){
            stringBuilder.append("The name should be between 3 and 100 characters long. \n ");
        }

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(supplierToValidate.getEmail());
        if(supplierToValidate.getEmail().length()< 3 || supplierToValidate.getEmail().length() > 100){
            stringBuilder.append("The contact email should be between 3 and 100 characters long. \n");
        }

        if(!matcher.matches()){
            stringBuilder.append("The contact email should have this pattern: email@gmail.com \n");
        }

        if(!stringBuilder.isEmpty()){
            throw new ValidationException(stringBuilder.toString());
        }
    }
}

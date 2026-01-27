package main.java.com.explainjava.service;

import main.java.com.explainjava.exceptions.IDNotUniqueException;

import java.util.Set;

public class GenerateIdSupplier {

    public static int generateID(Set<Integer> existingIds) throws IDNotUniqueException{
        for (int id = 1; id <= 1000; id++){
            if(!existingIds.contains(id)){
                return id;
            }
        }

        throw new IDNotUniqueException("No hay ids válidos");
    }
}

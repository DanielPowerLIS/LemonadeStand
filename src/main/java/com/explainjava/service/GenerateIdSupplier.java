package main.java.com.explainjava.service;

import java.util.Set;

public class GenerateIdSupplier {

    public static int generateID(Set<Integer> existingIds){
        for (int id = 1; id <= 1000; id++){
            if(!existingIds.contains(id)){
                return id;
            }
        }

        throw new IllegalStateException("No hay ids válidos");
    }
}

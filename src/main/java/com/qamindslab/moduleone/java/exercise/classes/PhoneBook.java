package com.qamindslab.moduleone.java.exercise.classes;

import java.util.HashMap;
import java.util.Map;


public class PhoneBook {
    Map<String,String> PhoneBook;

    public static void main (String args []) {
        PhoneBook datos=new PhoneBook();
        datos.add("Belen","9711070620");
        datos.add("Juan","9711070629");
        datos.add("Teresa","9711070628");
        datos.delete("Sofia","9711070629");
        datos.update("Nestor","9711070628");
        for(Map.Entry<String,String>catalogo:datos.PhoneBook.entrySet()){
            System.out.println(catalogo);

        }
    }

public PhoneBook(){
        PhoneBook=new HashMap<>();
}

    public void add(String nombre, String telefono) {
        PhoneBook.put(nombre,telefono);
    }
    public void delete(String nombre, String telefono) {
        PhoneBook.remove(nombre,telefono);
    }

    public void update(String nombre, String telefono){
      PhoneBook.replace(nombre,telefono);
    }


}

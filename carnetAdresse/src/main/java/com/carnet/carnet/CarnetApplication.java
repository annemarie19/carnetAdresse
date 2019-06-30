package com.carnet.carnet;

import com.carnet.carnet.dao.ContactRepository;
import com.carnet.carnet.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarnetApplication implements CommandLineRunner {

    @Autowired
    private  ContactRepository contactRepository;
    public static void main(String[] args) {
        SpringApplication.run(CarnetApplication.class, args);

       // contactRepository.save(new Contact("feunjiep","anne marie", 14/12/2019, "feunjiepannemarie@gmail.com","rue 527", 52388,"yaounde",695836099));
    }

    @Override
    public  void  run(String... arg0) throws Exception{

         Contact cont1=contactRepository.save(new Contact("feunjiep","anne marie",  "feunjiepannemarie@gmail.com","rue 527", 52388,"yaounde",695836099));
         Contact cont2=contactRepository.save(new Contact("ngahe","orly", "orly@gmail.com","rue 527", 52388,"yaounde",655234456));

    }

}

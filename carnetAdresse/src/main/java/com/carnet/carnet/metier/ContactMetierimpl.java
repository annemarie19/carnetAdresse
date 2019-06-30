package com.carnet.carnet.metier;

import com.carnet.carnet.dao.ContactRepository;
import com.carnet.carnet.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMetierimpl {
    @Autowired
    ContactRepository contactRepository;

    public Contact getContact(Long id){
        return contactRepository.getOne(id);
    }

    public void addContact (Contact cont ){
        contactRepository.save(cont);

    }
    public  void  deleteContact(Long id){
        contactRepository.delete(id);
    }
    public Contact updateContact (Contact cont ){
        Contact con=this.getContact(cont.getId());
        if (con!=null){
            con.setId(cont.getId());
            con.setNom(cont.getNom());
            con.setPrenom(cont.getPrenom());
            con.setCodepostal(cont.getCodepostal());
            con.setAdressepostal(cont.getAdressepostal());
            con.setAdressemail(cont.getAdressemail());
            con.setTelephone(cont.getTelephone());
            con.setVille(cont.getVille());
        }
        return  con;
    }


}

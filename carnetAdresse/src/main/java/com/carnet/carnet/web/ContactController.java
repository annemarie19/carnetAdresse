package com.carnet.carnet.web;

import com.carnet.carnet.dao.ContactRepository;

import com.carnet.carnet.entities.Contact;
import com.carnet.carnet.metier.ContactMetierimpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller

public class ContactController {
    @Autowired
    ContactMetierimpl contactMetierimpl;
    @Autowired
    ContactRepository contactRepository;
     @RequestMapping( value = "/index" , method = RequestMethod.GET)
     public  String index(Model model,
                          @RequestParam (name = "page", defaultValue = "") String motCherche,
                          @RequestParam (name = "page", defaultValue = "0") int p,
                          @RequestParam(name = "size", defaultValue = "4") int s) {
         Page<Contact> pageCont = contactRepository.chercher("%"+motCherche+"%", new PageRequest(p, s));
         List<Contact> contacts=contactRepository.findAll();
         model.addAttribute("listContacts",contacts);

         return "carnet";
     }


    @RequestMapping(value = "/formContact")
    public  String  formContact(Model model){
        model.addAttribute("contact",new Contact());
         return "formContact";
    }

    @RequestMapping(value = "/saveContact")
    public  String  save(Model model, @Valid Contact c ,
                         BindingResult bindingResult){
         if(bindingResult.hasErrors() ) {
             return "formContact";
         }
       contactRepository.save(c);
        return "redirect:/index";
    }

    @RequestMapping(value = "/deleteContact")
    public  String  delete(@RequestParam Long id ,Model model){
        model.addAttribute("contact",new Contact());
        contactRepository.delete(id);
        return "redirect:/index";
    }
    @RequestMapping(value = "/updateContact")
    public  String update(@RequestParam Long id,Model model ){
        //model.addAttribute("contact",contactMetierimpl.getContact(id));
        model.addAttribute("contact",new Contact());
        return "redirect:/index";
    }

   /* @RequestMapping(value= "/updateContact")
    public Contact updateContact(@RequestBody Contact cont, @PathVariable Long id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update contact details by id is invoked.");

        Contact con =  contactMetierimpl.getContact(id);
        if (con!=null)
            throw new Exception("Could not find contact with id- " + id);
        con.setId(cont.getId());
        con.setNom(cont.getNom());
        con.setPrenom(cont.getPrenom());
        con.setCodepostal(cont.getCodepostal());
        con.setAdressepostal(cont.getAdressepostal());
        con.setAdressemail(cont.getAdressemail());
        con.setTelephone(cont.getTelephone());
        con.setVille(cont.getVille());
        cont.setId(id);
        return contactMetierimpl.updateContact(cont);
    }*/

}


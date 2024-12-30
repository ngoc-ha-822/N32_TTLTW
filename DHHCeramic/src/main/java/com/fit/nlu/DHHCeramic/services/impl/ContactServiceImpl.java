package com.fit.nlu.DHHCeramic.services.impl;


import com.fit.nlu.DHHCeramic.dao.ContactDao;
import com.fit.nlu.DHHCeramic.dao.impl.ContactDaoImpl;
import com.fit.nlu.DHHCeramic.model.Contact;
import com.fit.nlu.DHHCeramic.services.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDao contactDao = new ContactDaoImpl();

    @Override
    public void insert(Contact contact) {
        contactDao.insert(contact);
    }

    @Override
    public void edit(Contact newContact) {
        Contact oldContact = contactDao.get(newContact.getId());

        oldContact.setName(newContact.getName());
        oldContact.setEmail(newContact.getEmail());
        oldContact.setTitle(newContact.getTitle());
        oldContact.setMessage(newContact.getMessage());


        contactDao.edit(oldContact);

    }

    @Override
    public void delete(int id) {
        contactDao.delete(id);
    }

    @Override
    public Contact get(int id) {
        return contactDao.get(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    @Override
    public List<Contact> search(String name) {
        return contactDao.search(name);
    }
}

package com.fit.nlu.DHHCeramic.dao;

import com.fit.nlu.DHHCeramic.model.Contact;

import java.util.List;

public interface ContactDao {

    void insert(Contact contact);

    void edit(Contact contact);

    void delete(int id);

    Contact get(int id);

    List<Contact> getAll();

    List<Contact> search(String name);
}

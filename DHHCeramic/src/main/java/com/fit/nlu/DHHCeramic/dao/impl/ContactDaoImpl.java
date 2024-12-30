package com.fit.nlu.DHHCeramic.dao.impl;


import com.fit.nlu.DHHCeramic.dao.ContactDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl extends JDBCConnection implements ContactDao {
    @Override
    public void insert(Contact contact) {
        String sql = "INSERT INTO contacts (name, email,title,message) VALUES (?,?,?,?)";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getTitle());
            ps.setString(4, contact.getMessage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Contact contact) {
        String sql = "UPDATE Contact SET Contact.name = ? , email = ?,title=?, message = ? WHERE id = ?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getTitle());
            ps.setString(4, contact.getMessage());
            ps.setInt(5, contact.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Contact WHERE id=?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Contact get(int id) {
        String sql = "SELECT contact.id, contact.name AS p_name, contact.email AS p_email,contact.title, contact.message"
                + " FROM Contact  " + " WHERE contact.id=?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("p_name"));
                contact.setEmail(rs.getString("p_email"));
                contact.setTitle(rs.getString("title"));
                contact.setMessage(rs.getString("message"));
                return contact;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contactList = new ArrayList<Contact>();
        String sql = "SELECT contacts.id, contacts.name AS p_name, contacts.email AS p_email,contacts.title, contacts.message"
                + " FROM contacts  ";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("p_name"));
                contact.setEmail(rs.getString("p_email"));
                contact.setTitle(rs.getString("title"));
                contact.setMessage(rs.getString("message"));
                contactList.add(contact);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return contactList;
    }

    @Override
    public List<Contact> search(String name) {
        List<Contact> contactList = new ArrayList<Contact>();
        String sql = "SELECT * FROM Contact WHERE name LIKE ? ";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setEmail(rs.getString("email"));
                contact.setTitle(rs.getString("title"));
                contact.setMessage(rs.getString("message"));
                contactList.add(contact);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return contactList;
    }
}

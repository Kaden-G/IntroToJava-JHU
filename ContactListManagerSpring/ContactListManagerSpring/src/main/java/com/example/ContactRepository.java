package com.example.contactlistmanager.repository;

import com.example.contactlistmanager.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository extends JpaRepository<Contact, Long> {
}

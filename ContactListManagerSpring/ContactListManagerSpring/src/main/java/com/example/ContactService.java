package com.example;

package com.example.contactlistmanager.service;

import com.example.contactlistmanager.model.Contact;
import com.example.contactlistmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	public Optional<Contact> getContactById(Long id) {
		return contactRepository.findById(id);
	}

	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
	}
}

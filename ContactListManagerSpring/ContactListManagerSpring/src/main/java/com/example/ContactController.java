package com.example;

package com.example.contactlistmanager.controller;

import com.example.contactlistmanager.model.Contact;
import com.example.contactlistmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

package com.example.contactlistmanager.controller;

import com.example.contactlistmanager.model.Contact;
import com.example.contactlistmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
	@Autowired
	private ContactService contactService;

	@GetMapping(produces = {"application/json", "application/xml"})
	public List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}

	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public Optional<Contact> getContactById(@PathVariable Long id) {
		return contactService.getContactById(id);
	}

	@PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public Contact createContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);
	}

	@PutMapping(value = "/{id}", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
		contact.setId(id);
		return contactService.saveContact(contact);
	}

	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable Long id) {
		contactService.deleteContact(id);
	}
}

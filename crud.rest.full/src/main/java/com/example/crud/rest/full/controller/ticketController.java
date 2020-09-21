package com.example.crud.rest.full.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.rest.full.dao.ticketDao;
import com.example.crud.rest.full.model.ticket;

@RestController
@RequestMapping("/ticket")
public class ticketController {
	@Autowired
	private ticketDao dao;

	@PostMapping("/bookTicket")
	public ticket bookTicket(@RequestBody ticket ticket) {
		return dao.save(ticket);
	}
	
	@PostMapping("/bookTickets")
	public Iterable<ticket> bookTickest(@RequestBody List<ticket> tickets) {
		return dao.saveAll(tickets);
	}

	@GetMapping("/getTickets")
	public List<ticket> getTickets() {
		return (List<ticket>) dao.findAll();
	}
	
	@GetMapping("/getTickets/{id}")
	public Optional<ticket> getTicketById(@PathVariable("id") Integer id) {
		return dao.findById(id);
	}
	
	@PutMapping("/updateBookTicket/{id}")
	public ticket updateBookTicket(@PathVariable("id") Integer id, @RequestBody ticket ticket) {
		ticket.id = id;
		return dao.save(ticket);
	}
	
	@DeleteMapping("/deleteBookTicket/{id}")
	public String deleteBookTicket(@PathVariable("id") Integer id) {
		dao.deleteById(id);
		return "delete suscess";
	}
}
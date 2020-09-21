package com.example.crud.rest.full.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.rest.full.model.ticket;

public interface ticketDao extends CrudRepository<ticket, Integer>{

}

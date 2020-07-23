package com.springboot.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.models.dao.IClienteDao;
import com.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {
	
	@Autowired
	private IClienteDao em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) em.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		
		return em.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
		return em.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.deleteById(id);
	}

}

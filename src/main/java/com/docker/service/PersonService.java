package com.docker.service;

import com.docker.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAllPersons();
}

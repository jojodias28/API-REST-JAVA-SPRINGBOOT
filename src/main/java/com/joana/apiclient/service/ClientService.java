package com.joana.apiclient.service;

import com.joana.apiclient.entity.Client;
import com.joana.apiclient.entity.dto.ClientDto;
import com.joana.apiclient.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClientDto save(ClientDto clientDto){
        Client clientSave = clientRepository.save(modelMapper.map(clientDto, Client.class));
        return modelMapper.map(clientSave, ClientDto.class);
    }

    public ClientDto update(ClientDto clientDto){
        Client clientUpdate = clientRepository.save(modelMapper.map(clientDto, Client.class));
        return modelMapper.map(clientUpdate, ClientDto.class);
    }

    public List<ClientDto> getAll(){
        return clientRepository.findAll().stream().map(e -> modelMapper.map(e, ClientDto.class)).collect(Collectors.toList());

    }

    public ClientDto getById(Long id) {
        Client clientFound = clientRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Client not found"));
        return modelMapper.map(clientFound, ClientDto.class);
    }

    public void deleteById(Long id){
        log.info("Checking client's id");
        ClientDto clientDelete = getById(id);
        log.info("deleting client");
        clientRepository.deleteById(id);
    }

}

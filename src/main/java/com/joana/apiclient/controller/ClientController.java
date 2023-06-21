package com.joana.apiclient.controller;

import com.joana.apiclient.api.ClientApi;

import com.joana.apiclient.entity.dto.ClientDto;
import com.joana.apiclient.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class ClientController implements ClientApi {


    @Autowired  //Injetar dentro da classe controller todas as funções da service
    private ClientService clientService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto){
        ClientDto client = clientService.save(clientDto);
        log.info("Save: Creating a new Client");
       return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @Override
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto){
        clientDto.setId(id);
        return ResponseEntity.ok().body(clientService.update(clientDto));

    }

    @Override
    public ResponseEntity<List<ClientDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAll());
    }

    @Override
    public ResponseEntity<ClientDto> getById(@PathVariable Long id){
        log.info("GetById: searching clients by id: {}", id);
        return ResponseEntity.ok().body(clientService.getById(id));
    }


   @Override
    public void deleteById(@PathVariable Long id){
        clientService.deleteById(id);
    }


}

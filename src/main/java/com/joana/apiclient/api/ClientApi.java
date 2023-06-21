package com.joana.apiclient.api;

import com.joana.apiclient.entity.dto.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/client")
public interface ClientApi {

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto);

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto);

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll();

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id);

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id);


}

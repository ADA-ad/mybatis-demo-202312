package com.ada.mybatisdemo202312.controller;

import com.ada.mybatisdemo202312.controller.request.NameCreateRequest;
import com.ada.mybatisdemo202312.controller.request.NameUpdateRequest;
import com.ada.mybatisdemo202312.controller.response.NameCreateResponse;
import com.ada.mybatisdemo202312.entity.Name;
import com.ada.mybatisdemo202312.Service.NameService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController

public class NameController {
    private final NameService nameService;
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }
    @GetMapping("/names")

    public List<Name> names() {
        return nameService.findAll();
    }

//    public List<Name> findByNames(@RequestParam String startsWith) {
//        return nameMapper.findByNameStartingWith(startsWith);
//    }
    @GetMapping("/find")
    public List<Name> findByNames(NameSearchRequest request) {
        System.out.println(request.getStartsWith());
        System.out.println(request.getEndsWith());
        System.out.println(request.getContains());
        return nameService.findByName(request.getStartsWith(), request.getEndsWith(), request.getContains());
    }
    @GetMapping("/names/{id}")
    public Name getNames(@PathVariable("id") int id) {
        return nameService.findName(id);
    }

//    @ExceptionHandler(value = NameNotFoundException.class)
//    public ResponseEntity<Map<String, String>> handleUserNotFoundException(
//            NameNotFoundException e, HttpServletRequest request) {
//        Map<String, String> body = Map.of(
//                "timestamp", ZonedDateTime.now().toString(),
//                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
//                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
//                "message", e.getMessage(),
//                "path", request.getRequestURI());
//        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
//    }
    @PostMapping("/names")
    public ResponseEntity<NameCreateResponse> insert(@RequestBody @Validated NameCreateRequest nameRequest,
                                                     UriComponentsBuilder uriComponentsBuilder) {
        Name name = nameService.insert(nameRequest.getName(), nameRequest.getEmail());
        URI location = uriComponentsBuilder.path("/names/{id}").buildAndExpand(name.getId()).toUri();
        NameCreateResponse body = new NameCreateResponse("name created", "email created");
        return ResponseEntity.created(location).body(body);
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<NameCreateResponse> updateName(@PathVariable Integer id,
                                                         @RequestBody @Valid NameUpdateRequest nameUpdateRequest,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        Name name = nameService.updateName(id, nameUpdateRequest);
        URI location = uriComponentsBuilder.path("/names/{id}").buildAndExpand(name.getId()).toUri();
        NameCreateResponse body = new NameCreateResponse("name updated","email updated");
        return ResponseEntity.created(location).body(body);
    }
    @DeleteMapping("/names/delete/{id}")
    public ResponseEntity<NameCreateResponse> deleteName(@PathVariable Integer id) {
        Optional<Name> name = nameService.deleteName(id);
        NameCreateResponse body = new NameCreateResponse("name deleted","email deleted");
        return ResponseEntity.ok(body);
    }

}

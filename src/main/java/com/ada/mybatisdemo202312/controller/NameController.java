package com.ada.mybatisdemo202312.controller;

import com.ada.mybatisdemo202312.entity.Name;
import com.ada.mybatisdemo202312.Service.NameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}

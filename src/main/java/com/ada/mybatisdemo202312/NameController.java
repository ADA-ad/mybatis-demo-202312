package com.ada.mybatisdemo202312;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class NameController {
    private final NameMapper nameMapper;
    public NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }
    @GetMapping("/names")
    public List<Name> names() {
        return nameMapper.findAll();
    }

//    public List<Name> findByNames(@RequestParam String startsWith) {
//        return nameMapper.findByNameStartingWith(startsWith);
//    }
    public List<Name> findByNames(NameSearchRequest request) {
        System.out.println(request.getStartsWith());
        System.out.println(request.getEndsWith());
        System.out.println(request.getContains());
        return nameMapper.findByNameStartingWith(request.getStartsWith(), request.getEndsWith(), request.getContains());
    }


}

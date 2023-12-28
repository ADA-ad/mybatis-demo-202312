package com.ada.mybatisdemo202312;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class NameController {
    private final NameMapper nameMapper;
    public NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }
    @GetMapping("/names")
    public List<Name> names() {
        return nameMapper.findAll();

    }


}

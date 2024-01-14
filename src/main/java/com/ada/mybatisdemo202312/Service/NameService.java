package com.ada.mybatisdemo202312.Service;

import com.ada.mybatisdemo202312.Mapper.NameMapper;
import com.ada.mybatisdemo202312.entity.Name;
import com.ada.mybatisdemo202312.exception.NameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameService {
    private final NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }
    public List<Name> findAll() {
        return nameMapper.findAll();
    }

    public List<Name> findByName(String startsWith, String endsWith, String contains) {
        return nameMapper.findByName(startsWith, endsWith, contains);
    }

    public Name findName(int id) {
        Optional<Name> name = this.nameMapper.findById(id);

        return name.orElseThrow(() -> new NameNotFoundException("user could not be found"));
//        if (name.isPresent()) {
//            return name.get();
//        } else {
//            throw new NameNotFoundException("user could not be found");
//        }
    }
}
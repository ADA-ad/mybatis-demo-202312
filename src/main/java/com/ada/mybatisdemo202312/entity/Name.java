package com.ada.mybatisdemo202312.entity;

import lombok.Data;
import lombok.Getter;
@Data
public class Name {
    @Getter
    private Integer id;
    @Getter
    private String name;
    @Getter
    private String email;


    public Name(String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public static Name creatName(String name, String email) {
        return new Name(name, email);
    }

}

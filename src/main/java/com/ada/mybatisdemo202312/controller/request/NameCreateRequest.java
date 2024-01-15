package com.ada.mybatisdemo202312.controller.request;

import lombok.Data;

@Data
public class NameCreateRequest {
    private String name;
    private String email;

    public NameCreateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

package com.ada.mybatisdemo202312.controller.response;

import lombok.Data;

@Data
public class NameCreateResponse {
    private String name;
    private String email;

    public NameCreateResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

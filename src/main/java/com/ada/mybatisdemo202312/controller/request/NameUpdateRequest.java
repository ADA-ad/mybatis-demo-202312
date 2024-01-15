package com.ada.mybatisdemo202312.controller.request;

import lombok.Data;

@Data
public class NameUpdateRequest {
    private String name;
    private String email;

    public NameUpdateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

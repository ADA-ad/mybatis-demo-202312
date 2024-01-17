package com.ada.mybatisdemo202312.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NameUpdateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String email;

    public NameUpdateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

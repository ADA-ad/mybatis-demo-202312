package com.ada.mybatisdemo202312.controller.request;

import jakarta.validation.constraints.AssertTrue;
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

    @AssertTrue(message = "nameとemailの両方が空白です")
    public boolean isBothNameAndEmailNotBlank() {
        // nameとemailの全てがnullまたは空文字または半角スペースのときにfalseを返す
        if ((name == null || name.isBlank()) && (email == null || email.isBlank())) {
            return false;
        } else {
            return true;
        }
    }
}

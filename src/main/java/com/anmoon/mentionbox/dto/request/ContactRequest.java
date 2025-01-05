package com.anmoon.mentionbox.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactRequest {
    @NotBlank //empty
    private String username;

    @NotBlank
    @Email
    private String email;
}

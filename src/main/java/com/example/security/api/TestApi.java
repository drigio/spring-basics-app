package com.example.security.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestApi
 */
@RequestMapping("admin")
@RestController
public class TestApi {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String isAdmin() {
        return "Hello Admin";
    }
}
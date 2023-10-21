/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openapi.billing.controller;

import com.openapi.billing.entities.Invoice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.openapi.billing.respository.InvoiceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Optional;

/**
 *
 * @author sotobotero
 */
@Tag(name = "Billing API", description = "This APi serve all functionality for management Invoices")
@RestController
@RequestMapping("/billing")
public class InvoiceRestController {

    @Autowired
    InvoiceRepository billingRepository;

    @Operation(description = "Return all invoices bundled into Response", summary = "Return 204 if no data found")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Exito"),
        @ApiResponse(responseCode = "500", description = "Internal error")})
    @GetMapping()
    public List<Invoice> list() {
        return billingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable String id) {
        Optional<Invoice> findById = billingRepository.findById(Long.valueOf(id));
        return findById.get();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Invoice input) {
        Invoice save = null;
        Optional<Invoice> findById = billingRepository.findById(Long.valueOf(id));

        if (findById.isPresent()) {
            Invoice get = findById.get();
            save = billingRepository.save(get);
        }
        return ResponseEntity.ok(save);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Invoice input) {
        Invoice save = billingRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Invoice> findById = billingRepository.findById(Long.valueOf(id));
        if (findById.isPresent()) {
            Invoice get = findById.get();
            billingRepository.delete(get);
        }
        return ResponseEntity.ok().build();
    }
}

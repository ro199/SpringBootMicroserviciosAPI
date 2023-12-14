/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openapi.billing.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author sotobotero
 */
@Entity
@Data
@Schema(name = "Invoice", description = "Model represent a invoice on database")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Schema(name = "customerId", requiredMode = Schema.RequiredMode.REQUIRED, example = "2", defaultValue = "1", description = "Unique Id of customer that represent the owner of invoice")
    private long customerId;
    @Schema(name = "number", requiredMode = Schema.RequiredMode.REQUIRED, example = "3", defaultValue = "8", description = "Number given on fisical invoice")
    private String number;
    private String detail;
    private double amount;
}

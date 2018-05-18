package com.nopi.arminBetBackend.model.control;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ControlFinancialData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal outcome;

    private BigDecimal income;

    private BigDecimal chitanta;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private ControlData controlData;

    public ControlFinancialData() {}

    public Long getId() {
        return id;
    }

    public ControlFinancialData setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getOutcome() {
        return outcome;
    }

    public ControlFinancialData setOutcome(BigDecimal outcome) {
        this.outcome = outcome;
        return this;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public ControlFinancialData setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }

    public BigDecimal getChitanta() {
        return chitanta;
    }

    public ControlFinancialData setChitanta(BigDecimal chitanta) {
        this.chitanta = chitanta;
        return this;
    }

    public ControlData getControlData() {
        return controlData;
    }

    public ControlFinancialData setControlData(ControlData controlData) {
        this.controlData = controlData;
        return this;
    }
}

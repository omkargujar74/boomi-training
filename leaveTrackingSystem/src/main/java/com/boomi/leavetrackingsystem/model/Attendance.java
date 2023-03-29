// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import java.time.LocalDate;

/**
 * @author omkargujar.
 */
@Entity
@IdClass(AttendanceCompositePK.class)
@Table(name = "attendance")
public class Attendance {

    @Id
    private int _id;
    @Id
    private LocalDate _date;
    @Column(name = "name")
    private String _name;

    @Type(type = "yes_no")
    @Column(name = "power_system_II")
    private boolean _powerSystemII;
    @Type(type = "yes_no")
    @Column(name = "control_system_I")
    private boolean _controlSystemI;
    @Type(type = "yes_no")
    @Column(name = "utilization_of_electric_energy")
    private boolean _utilizationOfElectricEnergy;
    @Type(type = "yes_no")
    @Column(name = "design_of_electric_machines")
    private boolean _designOfElectricMachines;
    @Type(type = "yes_no")
    @Column(name = "energy_audit_and_management")
    private boolean _energyAuditAndManagement;

    public Attendance(int id, LocalDate date, boolean powerSystemII, boolean controlSystemI,
            boolean utilizationOfElectricEnergy, boolean designOfElectricMachines, boolean energyAuditAndManagement) {
        _id = id;
        _date = date;
        _powerSystemII = powerSystemII;
        _controlSystemI = controlSystemI;
        _utilizationOfElectricEnergy = utilizationOfElectricEnergy;
        _designOfElectricMachines = designOfElectricMachines;
        _energyAuditAndManagement = energyAuditAndManagement;
    }

    public Attendance() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public LocalDate getDate() {
        return _date;
    }

    public void setDate(LocalDate date) {
        _date = date;
    }

    public boolean isPowerSystemII() {
        return _powerSystemII;
    }

    public void setPowerSystemII(boolean powerSystemII) {
        _powerSystemII = powerSystemII;
    }

    public boolean isControlSystemI() {
        return _controlSystemI;
    }

    public void setControlSystemI(boolean controlSystemI) {
        _controlSystemI = controlSystemI;
    }

    public boolean isUtilizationOfElectricEnergy() {
        return _utilizationOfElectricEnergy;
    }

    public void setUtilizationOfElectricEnergy(boolean utilizationOfElectricEnergy) {
        _utilizationOfElectricEnergy = utilizationOfElectricEnergy;
    }

    public boolean isDesignOfElectricMachines() {
        return _designOfElectricMachines;
    }

    public void setDesignOfElectricMachines(boolean designOfElectricMachines) {
        _designOfElectricMachines = designOfElectricMachines;
    }

    public boolean isEnergyAuditAndManagement() {
        return _energyAuditAndManagement;
    }

    public void setEnergyAuditAndManagement(boolean energyAuditAndManagement) {
        _energyAuditAndManagement = energyAuditAndManagement;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}

package com.cacib.interview.demo.entity;

import com.cacib.interview.demo.entity.enums.Direction;
import com.cacib.interview.demo.entity.enums.ProceedFlowType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alias;
    private String type;
    private String description;
    private String application;
    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Enumerated(EnumType.STRING)
    private ProceedFlowType proceedFlowType;


    public Partner() {
    }

    public Partner(String alias, String type, String description, String application, Direction direction, ProceedFlowType proceedFlowType) {
        this.alias = alias;
        this.type = type;
        this.description = description;
        this.application = application;
        this.direction = direction;
        this.proceedFlowType = proceedFlowType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ProceedFlowType getProceedFlowType() {
        return proceedFlowType;
    }

    public void setProceedFlowType(ProceedFlowType proceedFlowType) {
        this.proceedFlowType = proceedFlowType;
    }
}

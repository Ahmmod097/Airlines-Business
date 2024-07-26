package com.airlines.business.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
    @Column(nullable = false, name = "CREATED_BY", columnDefinition = "varchar(100) default ''")
    private String createdBy;

    @Column(name = "UPDATED_BY", columnDefinition = "varchar(100) default ''")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "CREATED_DATE")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
}

package com.anmoon.mentionbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="contacts")
public class ContactEntity extends BaseEntity{
    private String name;
    private String email;
    private Date seenAt;
    private String message;

    //user usingauditable;
}
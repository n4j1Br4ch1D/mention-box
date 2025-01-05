package com.anmoon.mentionbox.entity;

import com.anmoon.mentionbox.enumeration.StatusEnum;
import jakarta.persistence.Column;

public class ReportEntity extends BaseEntity{
     @Column
     String description;
     @Column
     StatusEnum status;

     //item //subtitle //quote
     //user auditable
}

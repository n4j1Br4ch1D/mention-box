package com.anmoon.mentionbox.entity;

import com.anmoon.mentionbox.enumeration.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestEntity extends BaseEntity{
    @Id
    @Column
    String title;
    @Column
    String description;
    @Column
    StatusEnum status;

    //items
//    @ManyToOne
//    /user

}

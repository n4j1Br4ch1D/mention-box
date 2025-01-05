package com.anmoon.mentionbox.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookmarks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkEntity extends BaseEntity {
    @Column
    String title;
    @Column
    String quote;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(name = "item_id") // Reference to the Elasticsearch document identifier
    private String itemId;
}

package com.anmoon.mentionbox.activityLog;

import com.anmoon.mentionbox.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="activityLogs")
public class ActivityLogEntity extends BaseEntity {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "action")
    private ActivityLogActionEnum action;

    @Column(name = "action_message")
    private String actionMessage;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "entity_id")
    private Long entityId;

    @Column
    private String data;

//    @Column(name = "client_ip")
//    private String clientIp;
//    @Column(name = "user_agent")
//    private String userAgent;
//    browser

    @Column(name = "status")
    private String status;
    @Column(name = "outcome")
    private String outcome;
    private String previousState;
    @Column(name = "context", length = 1000) // Adjust length based on your needs
    private String context;

    private Date seenAt;
    private Date ReportedAt;
    @Column()
    private ActivityLogTypeEnum type;
}

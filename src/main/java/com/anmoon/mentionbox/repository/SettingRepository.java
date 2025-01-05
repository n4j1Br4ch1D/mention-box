package com.anmoon.mentionbox.repository;

import com.anmoon.mentionbox.entity.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<SettingEntity, String> {
}
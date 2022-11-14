package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.entity.Notifications;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {

}

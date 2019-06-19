package com.cnasurety.extagencyint.batches.ivans.purge.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cnasurety.extagencyint.batches.ivans.purge.model.Notification;



@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
    
    @Procedure( name = "deleteTransactionTables")
    void purgeTransactionTables();
   
}

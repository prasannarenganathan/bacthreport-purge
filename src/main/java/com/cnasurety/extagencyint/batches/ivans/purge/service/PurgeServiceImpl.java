package com.cnasurety.extagencyint.batches.ivans.purge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cnasurety.extagencyint.batches.ivans.purge.repository.NotificationRepository;

@Component
public class PurgeServiceImpl implements PurgeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    NotificationRepository notificationRepository;

	public void purgeTables(int days) {
		notificationRepository.purgeTransactionTables( days);
		
	}
}

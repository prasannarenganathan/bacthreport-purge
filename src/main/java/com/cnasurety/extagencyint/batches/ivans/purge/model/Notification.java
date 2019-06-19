package com.cnasurety.extagencyint.batches.ivans.purge.model;


import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"NOTIFICATION_TBL\"", schema = "workflow")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "deleteTransactionTables", 
	                              procedureName = "workflow.purgeTransactionTables")
	})
public class Notification {
	@Id
    @Column(name = "\"NOTIFICATION_KEY\"")
    private UUID notificationKey;
}

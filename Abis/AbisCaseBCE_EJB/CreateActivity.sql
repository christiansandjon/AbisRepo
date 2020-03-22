CREATE TABLE ACTIVITY (
		ID NUMBER NOT NULL,
		START_TIME TIMESTAMP NOT NULL,
		END_TIME TIMESTAMP NOT NULL,
		DESCRIPTION VARCHAR2(255),
		PERFORMERID NUMBER NOT NULL,
		PROJECTID NUMBER NOT NULL
	);

CREATE UNIQUE INDEX ACTIVITY_ID_INDEX ON ACTIVITY (ID ASC);

ALTER TABLE ACTIVITY ADD CONSTRAINT ACTIVITY_PK PRIMARY KEY (ID);

ALTER TABLE ACTIVITY ADD CONSTRAINT FK_PERFORMERID FOREIGN KEY (PERFORMERID)
	  REFERENCES PERSON (ID) ENABLE;

ALTER TABLE ACTIVITY ADD CONSTRAINT FK_PROJECTID FOREIGN KEY (PROJECTID)
	  REFERENCES PROJECT (ID) ENABLE;
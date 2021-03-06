
CREATE TABLE WORKINGDAY (
		ID NUMBER NOT NULL,
		START_TIME TIMESTAMP NOT NULL,
		END_TIME TIMESTAMP NOT NULL,
		WORKERID NUMBER NOT NULL
	);

CREATE UNIQUE INDEX WORKINGDAY_ID_INDEX ON WORKINGDAY (ID ASC);

ALTER TABLE WORKINGDAY ADD CONSTRAINT WORKINGDAY_PK PRIMARY KEY (ID);

ALTER TABLE WORKINGDAY ADD CONSTRAINT FK_WORKERID FOREIGN KEY (WORKERID)
	  REFERENCES PERSON (ID) ENABLE;
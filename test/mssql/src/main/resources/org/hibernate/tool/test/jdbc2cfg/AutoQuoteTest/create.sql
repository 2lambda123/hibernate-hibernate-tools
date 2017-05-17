CREATE SCHEMA HTT
CREATE TABLE HTT.[us-ers] ( USERID INTEGER NOT NULL, DEPARTMENT VARCHAR(3), PRIMARY KEY (USERID) )
CREATE TABLE HTT.TYP ( INDEXID INTEGER NOT NULL, TEXT VARCHAR(10) NOT NULL, KORR INTEGER NOT NULL, PRIMARY KEY (INDEXID) ) 
CREATE TABLE HTT.WORKLOGS ( INDEXID INTEGER NOT NULL, LOGGEDID INTEGER NOT NULL, USERID INTEGER NOT NULL, TYP INTEGER NOT NULL, PRIMARY KEY (INDEXID, USERID), FOREIGN KEY (USERID) REFERENCES HTT.[us-ers](USERID), FOREIGN KEY (TYP) REFERENCES HTT.TYP(INDEXID) )


/* Drop Tables */

DROP TABLE t_autocomplete CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE seq_autocomplete;




/* Create Sequences */

CREATE SEQUENCE seq_autocomplete;



/* Create Tables */

CREATE TABLE t_autocomplete
(
	no number NOT NULL,
	id varchar2(30) NOT NULL UNIQUE,
	label varchar2(300) NOT NULL,
	value varchar2(600) NOT NULL,
	PRIMARY KEY (no)
);




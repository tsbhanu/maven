CREATE TABLE USER_ENTITY (
    USER_ID VARCHAR(10) NOT NULL,
    PASSWORD VARCHAR (128) NOT NULL,
    LAST_NAME VARCHAR (32) ,
    FIRST_NAME VARCHAR (32) ,
    GENDER CHAR (1) ,
    DELETED_FLG CHAR(1) DEFAULT '0' NOT NULL,
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CREATED_BY VARCHAR(10) DEFAULT 'SYSTEM' NOT NULL,
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    UPDATED_BY VARCHAR(10) DEFAULT 'SYSTEM' NOT NULL,
    PRIMARY KEY (USER_ID)
);

CREATE TABLE GROUP_ENTITY (
    GROUP_CODE CHAR(8) NOT NULL,
    GROUP_NAME VARCHAR (64) ,
    DELETED_FLG CHAR(1) DEFAULT '0' NOT NULL,
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CREATED_BY VARCHAR(10) DEFAULT 'SYSTEM'  NOT NULL,
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    UPDATED_BY VARCHAR(10) DEFAULT 'SYSTEM' NOT NULL,
    PRIMARY KEY (GROUP_CODE)
);

CREATE TABLE user_group_relation (
    USER_ID VARCHAR(10) NOT NULL ,
    GROUP_CODE CHAR (8) NOT NULL,
    DELETED_FLG CHAR(1) DEFAULT '0' NOT NULL,
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CREATED_BY VARCHAR(10) DEFAULT 'SYSTEM' NOT NULL,
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
    UPDATED_BY VARCHAR(10) DEFAULT 'SYSTEM' NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USER_ENTITY (USER_ID) ,
    FOREIGN KEY (GROUP_CODE) REFERENCES GROUP_ENTITY (GROUP_CODE) ,
    PRIMARY KEY (USER_ID, GROUP_CODE)
);


CALL SYSCS_UTIL.SYSCS_IMPORT_DATA (null, 'USER_ENTITY', null, null, '${data}/user_entity.csv', ',', '"', 'Shift_JIS', 0);
CALL SYSCS_UTIL.SYSCS_IMPORT_DATA (null, 'GROUP_ENTITY', null, null, '${data}/group_entity.csv', ',', '"', 'Shift_JIS', 0);
CALL SYSCS_UTIL.SYSCS_IMPORT_DATA (null, 'USER_GROUP_RELATION', null, null, '${data}/user_group_relation.csv', ',', '"', 'Shift_JIS', 0);
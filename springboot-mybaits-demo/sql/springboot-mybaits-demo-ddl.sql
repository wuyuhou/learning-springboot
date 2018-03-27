/*==============================================================*/
/* TABLE: DEMO_ID_TABLE    ID生成表                                   */
/*==============================================================*/
DROP TABLE IF EXISTS DEMO_ID_TABLE;
CREATE TABLE DEMO_ID_TABLE
(
   `ID_NAME`       VARCHAR(255) NOT NULL COMMENT '唯一标识',
   `ID_VALUE`      NUMERIC(19,0) COMMENT 'ID值',
   PRIMARY KEY (ID_NAME)
) COMMENT='ID生成表' ENGINE=INNODB DEFAULT CHARSET=UTF8;

/*==============================================================*/
/* TABLE: DEMO_USER    用户表                                    */
/*==============================================================*/
DROP TABLE IF EXISTS DEMO_USER;
CREATE TABLE DEMO_USER
(
  `USER_ID`         VARCHAR(64) NOT NULL COMMENT '用户ID',
  `USER_NAME`       VARCHAR(64) NOT NULL COMMENT '用户名',
  `USER_EMAIL`      VARCHAR(256) COMMENT '电子邮箱',
  `USER_MOBILE`     VARCHAR(64) COMMENT '手机号',
  `USER_NICKNAME`   VARCHAR(64) COMMENT '用户昵称',
  `USER_AVATAR`     VARCHAR(1024) COMMENT '用户头像',
  `USER_PASSWORD`   VARCHAR(64) COMMENT '密码',
  `USER_GENDER`     VARCHAR(64) COMMENT '性别',
  `USER_BIRTHDATE`  DATETIME COMMENT '生日',
  `USER_ADDRESS`    VARCHAR(512) COMMENT '地址',
  `USER_NOTES`      VARCHAR(1024) COMMENT '备注',
  `LOGIN_TIME`      DATETIME COMMENT '登录时间',
  `LAST_LOGIN_TIME` DATETIME COMMENT '上次登录时间',
  `DEL_FLAG`        CHAR(1) COMMENT '是否删除（0未删除，1删除）默认为0',
  `CREATED_USER`    VARCHAR(64) COMMENT '创建人',
  `CREATED_TIME`    DATETIME COMMENT '创建时间',
  `UPDATED_USER`    VARCHAR(64) COMMENT '更新人',
  `UPDATED_TIME`    DATETIME COMMENT '更新时间',
  PRIMARY KEY (`USER_ID`)
) COMMENT='用户表' ENGINE=INNODB DEFAULT CHARSET=UTF8;

/*==============================================================*/
/* TABLE: DEMO_ROLE    角色表                                    */
/*==============================================================*/
DROP TABLE IF EXISTS DEMO_ROLE;
CREATE TABLE DEMO_ROLE
(
  `ROLE_ID`      VARCHAR(64) NOT NULL COMMENT '角色ID',
  `ROLE_CODE`    VARCHAR(64) NOT NULL COMMENT '角色编码',
  `ROLE_TYPE`    VARCHAR(64) DEFAULT NULL COMMENT '角色类型',
  `ROLE_NAME`    VARCHAR(256) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC`    VARCHAR(512) DEFAULT NULL COMMENT '角色描述',
  `DEL_FLAG`     CHAR(1) DEFAULT NULL COMMENT '是否删除（0未删除，1删除）默认为0',
  `CREATED_USER` VARCHAR(64) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` DATETIME DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` VARBINARY(64) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` DATETIME DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ROLE_ID`)
) COMMENT='角色表' ENGINE=INNODB DEFAULT CHARSET=UTF8;

/*==============================================================*/
/* TABLE: DEMO_R_ROLE_USER    角色用户关联表                      */
/*==============================================================*/
DROP TABLE IF EXISTS DEMO_R_ROLE_USER;
CREATE TABLE DEMO_R_ROLE_USER
(
  `R_ID`      VARCHAR(64) NOT NULL COMMENT '关联ID',
  `ROLE_ID`   VARCHAR(64) DEFAULT NULL COMMENT '角色ID',
  `ROLE_CODE` VARCHAR(64) DEFAULT NULL COMMENT '角色编码',
  `USER_ID`   VARCHAR(64) DEFAULT NULL COMMENT '用户ID',
  `USER_NAME` VARCHAR(64) DEFAULT NULL  COMMENT '用户名',
  PRIMARY KEY (`R_ID`)
) COMMENT='角色用户关联表'  ENGINE=INNODB DEFAULT CHARSET=UTF8;
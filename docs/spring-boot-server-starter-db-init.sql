DROP DATABASE IF EXISTS starter;
CREATE DATABASE starter DEFAULT CHARACTER SET utf8;
USE starter;

DROP TABLE IF EXISTS user_credit;
CREATE TABLE user_credit (
  id int NOT NULL AUTO_INCREMENT COMMENT '自增id',
  user_name varchar(255) DEFAULT NULL COMMENT '用户名',
  credit int DEFAULT NULL COMMENT '信用点',
  PRIMARY KEY (id),
  UNIQUE (user_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user_credit (user_name, credit) VALUES ('jiang', '100');

INSERT INTO user_credit (user_name, credit) VALUES ('ding', '200');

COMMIT;
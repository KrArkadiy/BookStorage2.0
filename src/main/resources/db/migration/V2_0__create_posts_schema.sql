CREATE TABLE IF NOT EXISTS posts (
  post_id int NOT NULL AUTO_INCREMENT,
  content varchar(255) NOT NULL,
  created int NOT NULL,
  updated int NOT NULL,
  writer int DEFAULT NULL,
  PRIMARY KEY (post_id)
);
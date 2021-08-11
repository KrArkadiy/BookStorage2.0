CREATE TABLE IF NOT EXISTS labels (
  label_id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  post int DEFAULT NULL,
  PRIMARY KEY (label_id)
);
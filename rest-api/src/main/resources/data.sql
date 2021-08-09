CREATE TABLE IF NOT EXISTS users (
  id_user INT AUTO_INCREMENT  PRIMARY KEY,
  login VARCHAR(256) NOT NULL,
  password VARCHAR(256) NOT NULL,
  lastname VARCHAR(256),
  firstname VARCHAR(256)
);

--test1:123
INSERT INTO users(id_user, login, password)
VALUES (1, 'test1', '$2a$10$ESlHoS4WSwTP.E108UVBR.X5pZxPwzpCD/su.InbzA6YtKNUfTnQW');
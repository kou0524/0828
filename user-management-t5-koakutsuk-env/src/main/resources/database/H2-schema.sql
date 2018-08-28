CREATE TABLE t_users(userID VARCHAR(36)
,userName VARCHAR(255),
birthday DATETIME,
address VARCHAR(255),
phoneNumber VARCHAR(36),
password VARCHAR(60),
state VARCHAR(36),
lastUpdateTime VARCHAR(36)
);

CREATE TABLE t_role(
userID VARCHAR(36),
role VARCHAR(36)
);commit;
COPY USR(
	userId,
	password,
	email,
	name,
	dateOfBirth)
FROM '/home/csmajs/jdo007/CS166_Project/data/User_Data'
WITH DELIMITER ';';

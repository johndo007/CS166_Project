COPY USR(
	userId,
	password,
	email,
	name,
	dateOfBirth)
FROM '/home/csmajs/jdo007/CS166_Project/data/USR'
WITH DELIMITER ';';

COPY WORK_EXPR(
	userId,
	company,
	role,	
	location,
	startDate,
	endDate)
FROM '/home/csmajs/jdo007/CS166_Project/data/WORK_EX'
WITH DELIMITER ';';

COPY EDUCATIONAL_DETAILS(
	userId,
	instituitionName,
	major,
	degree,
	startDate,
	endDate)
FROM '/home/csmajs/jdo007/CS166_Project/data/EDU_DET'
WITH DELIMITER ';';

COPY CONNECTION_USR(
        userId,
        connectionId,
        status)
FROM '/home/csmajs/jdo007/CS166_Project/data/CONNECTION'
WITH DELIMITER ';';

COPY MESSAGE(
        msgId,
        senderId,
        receiverId,
        contents, 
        sendTime,
        deleteStatus,
        status)
FROM '/home/csmajs/jdo007/CS166_Project/data/MESSAGES'
WITH DELIMITER '}';


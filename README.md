XASession2
==========

完成一个查询系统。

系统有两个输入文件deu.txt 和 user.txt，分别代表用户属性表和事件表：

    table DEU:
    	date, event, value, uid, time
    	
    table USER: 一个可扩展列的表。
    	uid, prop1, prop2, prop3, ....

系统可以接收SQL语句，执行查询并返回结果。

例如查询次日活跃用户数（2月1日注册的用户，在2月2日活跃的数量）：

    SELECT COUNT(DISTINCT(uid))
    	FROM event NATURAL JOIN user
    	WHERE user.register_time='2013-02-01'
    	AND event.date='2013-02-02' and event.event='visit'; 

### 目标

依次实现com.xingcloud.xa.session2.test.Tests里面的查询：

    select * from user;

    select event, uid from event where date='2013-02-01';

    SELECT COUNT(DISTINCT(uid))
    	FROM (event NATURAL JOIN user)
    	WHERE user.register_time='2013-02-01'
    	AND event.date='2013-02-02' AND event.event='visit';

    SELECT user.ref0, COUNT(DISTINCT(uid)), SUM(event.value)
    	FROM (event NATURAL JOIN user)
		WHERE user.register_time='2013-02-01'
		AND event.date='2013-02-02' AND event.event='visit'
		GROUP BY user.ref0;


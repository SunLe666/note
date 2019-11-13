--创建存储过程
create PROCEDURE test()
BEGIN
	
DECLARE i INT DEFAULT 1;
while i<3 do
INSERT INTO `philipsweb`.`cfg_budget_base` ( `activity_group_id`, `activity_group_code`, `activity_group_name`, `budget_id`, `budget_code`, `budget_name`, `channel_id`, `channel_code`, `channel_name`, `category_id`, `category_code`, `category_name`, `sd`, `fdate`, `totalAmount`, `actualAmount`, `balanceAmount`, `business_type`) VALUES ( '445', 'M01', 'Pricing', '225', 'BDS01', 'BIP MD', '912', 'CH441', 'Wholesales', '88', 'C0321', 'MG', '', CONCAT('2018-0',i), '0.00', '0.00', '0.00', 'Margin');

  set i = i + 1;
end while;
end

DROP PROCEDURE test
CALL test()
------------------
delimiter $
CREATE PROCEDURE merge_a_to_b() BEGIN
-- 定义需要插入从a表插入b表的过程变量
DECLARE _ID VARCHAR (16);
DECLARE _NAME VARCHAR (16);
-- 游标遍历数据结束标志 
DECLARE done INT DEFAULT FALSE;
-- 游标指向a表结果集第一条-1位置
DECLARE cur_account CURSOR FOR SELECT ID, NAME FROM test;
-- 游标指向a表结果集最后一条加1位置 设置结束标志
DECLARE CONTINUE HANDLER FOR NOT FOUND  SET done = TRUE;
-- 打开游标
OPEN cur_account;
-- 遍历游标
read_loop :
LOOP
--  取值a表当前位置数据到临时变量
	FETCH NEXT FROM cur_account INTO _ID,_NAME;
 
-- 如果取值结束 跳出循环
IF done THEN LEAVE read_loop; 
END IF;
 
-- 当前数据做 对比 如果b表存在则更新时间 不存在则插入
IF NOT EXISTS ( SELECT 1 FROM acl_user WHERE ID = _ID ) 
	THEN
		 INSERT INTO acl_user ( userNAME) VALUES (_NAME);
	ELSE 
		UPDATE acl_user  set updatedAt = now() WHERE ID = _ID;
END IF;
 
END LOOP;
CLOSE cur_account;
 
END $
----------
DROP PROCEDURE merge_a_to_b
CALL merge_a_to_b()
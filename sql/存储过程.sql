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

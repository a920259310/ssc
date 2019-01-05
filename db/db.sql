INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('1','a920259310','a19931006','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','2.65','1','1','建行','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('2','b920259310','a19931006','678b557478a23722cba4e963d48bd620','a123456','','1','1','建行','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('3','q10001','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0','1','1','建行','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('4','q10002','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0.745','1','1','建行','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('5','q10003','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0','1','0','','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('6','q10004','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0','1','0','','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('7','q10005','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0','1','0','','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('8','q10006','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0.7','1','1','建行','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('9','q10007','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0','1','0','','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('10','q10008','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0.65','1','1','建行','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('11','q10009','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0','1','0','','1');
INSERT INTO account(id,user_name,PASSWORD,MD5,take_password,yu_e,is_active,is_bang,card_no,is_regist) VALUES('12','q10010','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456','0','1','0','','1');

INSERT INTO account_sing(account_id,create_date_time,is_singe)
SELECT id AS account_id,NOW() AS create_date_time,0 AS is_singe FROM account;
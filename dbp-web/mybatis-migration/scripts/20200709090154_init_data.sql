-- // init_data
-- Migration SQL that makes the change goes here.
insert into `user_base` (`id`,`cellphone`) values (1,'13300000000');
insert into `user_account` (`uid`,`balance`) values(1,10000);
insert into `app` (`id`,`app_id`,`app_token`) values(1,10000,'2p3gfbc2vfa77xpu3nfvsvrr78wpc23b');

-- //@UNDO
-- SQL to undo the change goes here.
delete from `user_account` where uid = 1;
delete from `user_base` where cellphone='13300000000' and area_code='86';
delete from `app` where id=1;

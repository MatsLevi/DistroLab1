use store;

revoke all privileges, grant option from 'login_user'@'localhost';
drop user 'login_user'@'localhost'; 

revoke all privileges, grant option from 'item_user'@'localhost';
drop user 'item_user'@'localhost'; 

revoke all privileges, grant option from 'login'@'localhost';
drop user 'login'@'localhost'; 
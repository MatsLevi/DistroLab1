use store;

create user 'login_user'@'localhost' identified by '123456';
grant select, insert, update, delete on store.Login to 'login_user'@'localhost';

create user 'item_user'@'localhost' identified by '123';
grant select, insert, update, delete on store.Item to 'item_user'@'localhost';
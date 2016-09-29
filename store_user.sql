use store;

create user 'login'@'localhost' identified by '123456';
grant select, insert, update, delete on store.Login to 'login'@'localhost';
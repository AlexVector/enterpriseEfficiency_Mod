CREATE DATABASE `company_db` DEFAULT CHARACTER SET utf8;

create user 'company_app'@localhost
    identified by 'company_password';

GRANT SELECT,INSERT,UPDATE,DELETE
    ON `company_db`.*
    TO company_app@localhost;

GRANT SELECT,INSERT,UPDATE,DELETE
    ON `company_db`.*
    TO company_user@'%';
#IDENTIFIED BY 'company_password';

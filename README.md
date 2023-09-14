# Project0: Banking Application

# Description:

Project Zero is a Banking Application using JBDC, Javalin, and AWS RDS. It allows users to create, access, and control their financial means

### Database Structure
```SQL
create table users(
	user_id serial primary key,
	user_first_name text not null,
	user_last_name text not null
);

create table accounts(
	account_id serial primary key,
	account_title text not null,
	account_balance int,
	user_id_fk int references users(user_id)
);
```
### Mockdata in database
```SQL
INSERT INTO users(user_first_name, user_last_name)
VALUES
('Bobby', 'McBobby'),
('Hermione', 'Granger'),
('Ron', 'Weasley'),
('Luna', 'Lovegood'),
('Harry', 'Potter'),
('Sam', 'Willson'),
('Duncan', 'Idaho'),
('Paul', 'Atreides');

INSERT INTO accounts(account_title, account_balance, user_id_fk)
VALUES
('Bob Funds', 1, 1),
('Miss. Granger', 700, 2),
('rweasley', -10, 3),
('rweasley2', 0, 3),
('LunaLove', 0, 4),
('Vault 687 ', 50625, 5),
--('main', 7451, 6), No account for Sam Willson
('Royal Account', 300000, 7),
('Royal 2 Account', 500000, 7),
('Idaho Money', 2150, 8);
```

## Authors:
Caleb Mcolin, Yan Tao Zhu, Nick Onofrei

-- account table
create table accounts(
	account_id serial primary key,
	account_title text unique not null,
	account_balance int check(account_balance > 0)
);



-- user table
create table users(
	user_id serial primary key,
	user_first_name text not null,
	user_last_name text not null,
	user_id_fk int references accounts(account_id)
	-- this is a foreign key, and the primary key
);

create table bank_user( FirstName text,LastName text, Username text, Pass_word text , primary key (username));

create table Account_info(account_id int, Total decimal, AccountType text, username text references bank_user(username) ,primary key(account_id));



create or replace function insert_into_account()
	returns trigger as $$
	begin
		if(TG_OP = 'INSERT') then
			new.account_id = (select nextval('account_id_seq'));
		end if;
	return new;
	end;
$$ language plpgsql;

create sequence account_id_seq start 101;



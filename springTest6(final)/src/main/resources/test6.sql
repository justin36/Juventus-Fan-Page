create table member6 ( 
	id				varchar2(100)		not null
	,password		varchar2(100)		not null
	,name			varchar2(100)		not null
	,email			varchar2(100)
	,idno			varchar2(100)		unique
	,address		varchar2(100)		
	,joinDate		date				default sysdate);
	
	insert into member6(id,password,name,email,idno,address,joinDate) 
	values ('abc', '123', '1', '@gmail', '920306', '1', sysdate);

create table board6 (
	boardnum		number				primary key
	,id				varchar2(100)		not null
	,title			varchar2(100)		not null
	,content		varchar2(1000)		not null
	,inputDate		date				default sysdate
	,hits			number				default 0
	,originalfile	varchar2(200)		
	,savedfile		varchar2(100)		

);

create sequence board6_seq;

	insert into board6(boardnum, id, title, content, inputDate, hits)
	values (1, '1', '1', '1', sysdate, 1);
	
create table reply6 (
	replynum		number				primary key
	,boardnum		number				not null
	,id				varchar2(100)		not null
	,text			varchar2(100)		not null
	,inputDate		date				default sysdate
	
	constraint reply6_fk foreign key(boardnum)
		references board6(boardnum)	on delete cascade
);

create sequence reply6_seq;

	insert into reply6(replynum, boardnum, id, text, inputDate)
	values (1, 1, '1', '1', sysdate);
	

create table bulletin6 (
	bulletinnum		number				primary key
	,id				varchar2(100)		not null
	,title			varchar2(100)		not null
	,content		varchar2(1000)		not null
	,inputDate		date				default sysdate
	,hits			number				default 0		
);

create sequence bulletin6_seq;	






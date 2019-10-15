create table customers
(
cid int not null auto_increment,
cname varchar(20),
csex char(1),
cdob date,
cphone int(10) not null,
caddress varchar(75),
primary key(cid)
);


create table emps
(eid int primary key auto_increment,
e_firstname varchar(15),
e_lastname varchar(15),
birthday date,
strtdate date,
e_sex varchar(1),
e_email varchar(50),
ephone char(10),
eaddress varchar(50));


create table regis
(username varchar(20) primary key,
email varchar(50),
password varchar(20)
);

insert into regis values('admin','amin@gmail.com','password');

create table users
(
id int primary key auto_increment,
firstname varchar(20),
lastname varchar(20),
address varchar(50)
);



create table supplier
(
sid int not null auto_increment,
sname varchar(20),
ssex char(1),
sdob date,
sphone long,
location varchar(75),
primary key(sid)
);






create table feedback
(fid int not null auto_increment
,givenby int,
fdate date,
rate int(1),
remarks varchar(50),
primary key(fid),
foreign key(givenby) references customers(cid) on delete cascade
);













create table hotel
(
hid int not null auto_increment,
hname varchar(20),
haddress varchar(75),
hGSITN varchar(20),
primary key(hid)
);


create table expences
(
hid int,
expid int not null auto_increment,
expamount int,
expdate date,
foreign key(hid) references hotel(hid) on delete cascade,
primary key(expid)
);



create table htax
(
hid int,
returnid int not null auto_increment,
returnamount int,
returntype varchar(20),
returndate date,
foreign key(hid) references hotel(hid),
primary key(returnid)
);









create table item
(
iid int not null auto_increment,
iname varchar(20),
itype varchar(20),
iprice int,
istock BOOLEAN,
primary key(iid)
);







create table rawitem
(
rid int not null auto_increment,
suppliedby int,
rquantity varchar(20),
riprice int,
rstock BOOLEAN,
foreign key(suppliedby) references supplier(sid),
primary key(rid)
);



 create table raw_item_invoice
(
rid int,rrid int not null auto_increment,
riprice int,
rindate date,
riquantity int,
tax_gst int default 5,
total_price int,
foreign key(rid) references rawitem(rid),
primary key(rrid)
);







create table ctbooking
(
cid int,
hid int,
tbid int not null auto_increment,
tnum int,
tbdate date,
time TIME,
datealloted date,
foreign key(cid) references customers(cid),
foreign key(hid) references hotel(hid),
primary key(tbid)
);




create table discount
(
did int not null auto_increment,
per int,
validtill date,
primary key(did)
);







create table bill
(
billid int not null auto_increment,
billdate date,
primary key(billid)
);

create table oitems
(
oid int not null auto_increment,
billid int,
iid int,
quantity int,
iprice int,
igross int,
primary key(oid),
foreign key(billid) references bill(billid)
);


create table fbill
(
id int not null auto_increment,
billid int,
fbilldate date, 
totalgross int,
tax_gst int default 5,
totalamount int,
primary key(id),
foreign key(billid) references bill(billid)
);














create trigger t1 before insert on raw_item_invoice for each row set new.riprice= (select riprice from rawitem where rid=new.rid);




create trigger t2 before insert on raw_item_invoice for each row set new.total_price= (new.riprice*new.riquantity)+(new.riprice*new.riquantity*new.tax_gst/100);




create trigger t3 before insert on oitems for each row set new.iprice= (select iprice from item where iid=new.iid);



create trigger t4 before insert on oitems for each row set new.igross= (select iprice from item where iid=new.iid)*new.quantity; 


create trigger t5 before insert on fbill for each row set new.totalgross=(select sum(igross) from oitems where billid=new.billid);

create trigger t6 before insert on fbill for each row set new.totalamount= new.totalgross+(new.totalgross*new.tax_gst/100);

















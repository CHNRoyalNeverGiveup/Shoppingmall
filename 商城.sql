drop database shoppingmall;
create database shoppingmall;
use shoppingmall;
create table users(		#用户表
uid int primary key auto_increment,#编号
uLName varchar(20) not null,#用户名
uLPwd varchar(256) not null,#密码
uEmail varchar(60) ,#email
uName varchar(10) not null,#姓名
uTel varchar(11) ,#电话
ustatus varchar(10) not null #状态
);
insert into users(uLName,uLPwd,uEmail,uName,uTel,ustatus)values('123454','1121323',"","韦邦杠1","24612354651","可用");
insert into users(uLName,uLPwd,uEmail,uName,uTel,ustatus)values('456785','3211233',"","韦邦杠2","24651157651","可用");
insert into users(uLName,uLPwd,uEmail,uName,uTel,ustatus)values('123456','123123123',"","韦邦杠3","24651458751","可用");
insert into users(uLName,uLPwd,uEmail,uName,uTel,ustatus)values('123457','1231231456',"","韦邦杠4","2465125871","可用");
insert into users(uLName,uLPwd,uEmail,uName,uTel,ustatus)values('123458','121231233456',"","韦邦杠8","24648674651","可用");
create table admins(   #管理员表
aid int primary key auto_increment,#编号
alname varchar(10) not null,#账号
alpwd varchar(256) not null,#密码
astatus varchar(20) not null,#状态
aname varchar(10) not null#名字
);
insert into admins(alname,alpwd,astatus,aname)values('韦邦杠','123456','可用','韦邦爱迪生');
insert into admins(alname,alpwd,astatus,aname)values('梁光健','123456','可用','韦阿发');
insert into admins(alname,alpwd,astatus,aname)values('欧乐乐','123456','可用','沙发杠1');
insert into admins(alname,alpwd,astatus,aname)values('刘大仙','123456','可用','按时发生杠1');
insert into admins(alname,alpwd,astatus,aname)values('果果啊','123456','可用','阿发撒的杠1');
create table useraddress( #用户地址表
udid int primary key auto_increment,#编号
addressu varchar(256) not null,# 地址
uidu int,#用户编号
unameu varchar(20) not null,#收货人
uphoneu varchar(11) not null,#联系电话
foreign key(uidu) references users(uid)#用户编号外键
);
insert into useraddress(addressu,uidu,unameu,uphoneu) values
('广东省珠海市',1,'韦邦杠','18777620377'),
('广西省来宾市',1,'韦邦杠','18777620377'),
('广西省南宁市',1,'韦邦杠','18777620377');
create table ProductType(						#产品类型表
tid int primary key auto_increment,#编号
tname varchar(50) not null,#类型名称
tstatus varchar(20) #状态
);
insert into productType(tname,tstatus)values('手机','上架');
insert into productType(tname,tstatus)values('电脑','上架');
insert into productType(tname,tstatus)values('家居','上架');
insert into productType(tname,tstatus)values('男装','上架');
insert into productType(tname,tstatus)values('美妆','上架');
insert into productType(tname,tstatus)values('女鞋','上架');
insert into productType(tname,tstatus)values('女装','上架');
insert into productType(tname,tstatus)values('特产','上架');
insert into productType(tname,tstatus)values('家居','上架');
insert into productType(tname,tstatus)values('汽车','上架');
insert into productType(tname,tstatus)values('运动','上架');
create table Product(			#产品表
pid varchar(20) primary key,#编号
pname varchar(256),#名称
ptid int ,#类型
pimg varchar(256),#图片
pprice decimal(8,2),#价格
pstatus varchar(10),#状态
pnumber int,#库存数量
detailed text,#详细介绍
foreign key(ptid) references ProductType(tid)#品牌类型
);
insert into Product(pid,pname,ptid,pimg,pprice,pstatus,pnumber,detailed)values
('28245104630','华为（HUAWEI） 荣耀9i手机 幻夜黑 全网通4+64G标配版',1,'jpg',1399.00,'上架中',1388,null),
('562345439575','【现货当天发】送礼OnePlus/一加 5T 一加5T手机1加5t 一加手机5T',1,'jpg',2899.00,'上架中',269,null),
('560629457257','PROTRULY/保千里 V10S 保千里打令手机VR手机官方正品指纹电信',1,'jpg',4999.00,'上架中',1388,null),
('8485229','华为 HUAWEI nova 3i 全面屏高清四摄游戏手机4GB+128GB 亮黑色 全网通移动联通电信4G手机双卡双待',1,'jpg',1999.00,'上架中',17750,null),
('551821517028','GEMRY/詹姆士 R19 plus全网通4G双卡智能商务手机安全钛金威图',1,'jpg',11999.00,'上架中',1992,null),
('140105335569','【8+128G降100 低至3599】OnePlus/一加 A6000 一加6手机 一加六 一加5t a510一加6 一加5 官方旗舰店 1+6',1,'jpg',3099.00,'上架中',896,null),
('572442045322','OBXIN/欧博信OX2刘海屏全面屏8G+128G全网通4G千元智能无边框手机',1,'png',899.00,'上架中',38,null),
('572029563703','OnePlus/一加 5T 一加5T三网通4G手机一加五手机',1,'jpg',2080.00,'上架中',145,null),
('575966718885','一加5 全新OnePlus/一加A5000手机全屏一加5手机128G全网通4G128G',1,'jpg',1666.00,'上架中',138,null);

insert into Product(pid,pname,ptid,pimg,pprice,pstatus,pnumber,detailed)values
('10562093068','狄派 4G独显/绝地求生吃鸡台式机电脑酷睿i5-8400/i7六核',2,'jpg',3399.00,'上架中',300,null),
('5623454395','【Apple MacBook Air 13.3英寸笔记本电脑 银色',2,'jpg',6499.00,'上架中',2690,null),
('6888588','联想(Lenovo)小新潮7000 14英寸英特尔八代酷睿轻薄窄边框笔记本电脑(I5-8250U 8G 2T+128G PCIE R535 2G)银',2,'jpg',4999.00,'上架中',1000,null),
('7102519','联想(Lenovo)小新潮7000 14英寸超轻薄窄边框笔记本电脑(I7-8550U 8G 2T+128G PCIE R535 2G)极光银',2,'jpg',5799.00,'上架中',138,null);

create table OrderIndormation(  				 #订单信息表
oid varchar(100) primary key ,#订单编号
ouid int,#用户id
otime datetime default(now()),#下单时间
osuretime datetime,#付款时间
omoney decimal(8,2),#订单总价
ostatus varchar(20),#订单状态
address varchar(100),#订单地址
foreign key(ouid) references users(uid)	#用户id
);
insert into OrderIndormation(oid,ouid,omoney,ostatus,address)values('545615646531',1,500,'未付款',1);
select * from OrderIndormation;
create table shoppingCart(		 #购物车表
sid int primary key auto_increment,#编号
spid varchar(20) ,#商品编号
suid int ,#用户编号
sstatus varchar(10),#状态
sorder varchar(100) ,#订单编号
shoppingcount int ,#购物数量
smoney decimal(8,2),#总金额
foreign key(spid) references Product(pid),#引用商品表
foreign key(suid) references users(uid),#引用用户表
foreign key(sorder) references OrderIndormation(oid)#引用购物车表
);
insert into shoppingCart(spid,suid,sstatus,shoppingcount,smoney)values
('562345439575','1','否',1,2080);
select * from users;
select * from admins;
select * from productType;
select * from Product;
select * from shoppingCart;
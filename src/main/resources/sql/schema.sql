drop database if exists theDaleVilla;

create database theDaleVilla;

use theDaleVilla;

create table Admin(
                      UserId varchar(20)primary key,
                      UserName varchar(20)not null,
                      Password varchar(20)not null
);

create table Employee(
                         EmpID varchar(20)primary key,
                         Name varchar(20)not null,
                         Type varchar(20)not null,
                         Email varchar(30)not null,
                         DOB date,
                         UserID varchar(20),
                         FOREIGN KEY (UserID) REFERENCES Admin(UserID)on update cascade on delete cascade
);

create table Customer(
                         CusID varchar(20)primary key,
                         Name varchar(20)not null,
                         sex varchar(20),
                         NIC varchar(30)not null,
                         Contact int(20),
                         Email varchar(30)not null,
                         UserID varchar(20)not null,
                         foreign key(UserID) references Admin(UserID)on update cascade on delete cascade
);


create table Payment(
                        PayID varchar(20)primary key,
                        Date date,
                        Description varchar(30),
                        CusID varchar(20)not null,
                        foreign key(CusID) references Customer(CusID)on update cascade on delete cascade
);


create table Food(
                     FoodID varchar(20)primary key,
                     Description varchar(30)
);


create table FoodStock(
                          FoodID varchar(20)not null,
                          SupID varchar(20)not null,
                          Date date,
                          QtyOnHand int(30)not null,
                          foreign key(FoodID) references Food(FoodID)on update cascade on delete cascade
);



create table Room(
                     RoomID varchar(20)primary key,
                     Type varchar(30)not null,
                     Date date,
                     UnitPrice decimal(10,2),
                     Qty int not null ,
                     CusID varchar(20)not null,
                     foreign key(CusID) references Customer(CusID)on update cascade on delete cascade
);

create table RoomBooking(
       RoomBookingID varchar(20)primary key ,
       CusID varchar(20) not null ,
       date date not null ,
       foreign key (CusID)references customer(CusID)on update cascade on delete cascade

);

create table RentBooking(
      RentBookingID varchar(20)primary key ,
      CusID varchar(20) not null ,
      date date not null ,
     foreign key (CusID)references customer(CusID)on update cascade on delete cascade

);


create table Rent(
                     RentID varchar(20)primary key,
                     Qty int(20)not null,
                     Description varchar(30),
                     Type varchar(30),
                     UnitPrice decimal(10,2)

);



create table RentDetails(
                            RentID varchar(20)not null,
                            CusID varchar(20)not null,
                            Date date,
                            Description varchar(30),
                            foreign key(RentID) references Rent(RentID)on update cascade on delete cascade,
                            foreign key(CusID) references Customer(CusID)on update cascade on delete cascade
);

create table RoomDetails(
                            RoomBookingID varchar(20)not null,
                            RoomID varchar(20)not null,
                            Qty int not null ,
                            UnitPrice double not null ,
                            Type varchar(30),
                            foreign key(RoomBookingID) references RoomBooking(RoomBookingID)on update cascade on delete cascade,
                            foreign key(RoomID) references Room(RoomID)on update cascade on delete cascade
);
insert into admin values ('u001','admin','1234');






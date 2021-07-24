/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/7/25 1:32:54                            */
/*==============================================================*/


SET foreign_key_checks = 0;

drop table if exists commodity;

drop table if exists orders;

drop table if exists sims;

drop table if exists user;

SET foreign_key_checks = 0;

/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity
(
   id_commodity         int not null auto_increment,
   title                varchar(255),
   entity               int,
   hire                 varchar(20),
   timelimit            varchar(20),
   region               varchar(20),
   value                double,
   specification        varchar(255),
   primary key (id_commodity)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   id_order             varchar(20),
   id_commodity         int,
   num_commodity        int,
   amount_order         double,
   id_store             int,
   commission1          double,
   id_distributor1      int,
   commission2          double,
   id_distributor2      int,
   commission3          double,
   id_distributor3      int,
   uid                  int
);

/*==============================================================*/
/* Table: sims                                                  */
/*==============================================================*/
create table sims
(
   id_commodity1        int,
   id_commodity2        int,
   sim                  double,
   time                 timestamp
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  int not null auto_increment,
   password             varchar(20),
   primary key (uid)
);

alter table orders add constraint FK_Reference_1 foreign key (id_commodity)
      references commodity (id_commodity) on delete restrict on update restrict;

alter table orders add constraint FK_Reference_2 foreign key (uid)
      references user (uid) on delete restrict on update restrict;


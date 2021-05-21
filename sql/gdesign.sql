/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021-05-18 22:12:51                          */
/*==============================================================*/


SET foreign_key_checks = 0;

drop table if exists commodity;

drop table if exists orders;

SET foreign_key_checks = 1;

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

alter table orders add constraint FK_Reference_1 foreign key (id_commodity)
      references commodity (id_commodity) on delete restrict on update restrict;


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021-05-08 21:56:10                          */
/*==============================================================*/


drop table if exists commodity;

/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity
(
   id                   int not null,
   title                varchar(255),
   entity               varchar(2),
   hire1                varchar(20),
   timelimit            varchar(20),
   primary key (id)
);


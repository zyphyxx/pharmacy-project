create table remedio
(
    id          bigint       not null auto_increment,
    nome        varchar(30)  not null,
    Via         varchar(15)  not null,
    lote        varchar(30)  not null,
    quantidade  varchar(100) not null,
    validade    varchar(15)  not null,
    Laboratorio varchar(30)  not null,

    primary key (id)
);
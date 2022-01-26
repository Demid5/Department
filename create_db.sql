create table department
(
    id   int auto_increment,
    name varchar(50) not null,
    constraint department_id_uindex
        unique (id)
);

alter table department
    add primary key (id);

create table employee
(
    id            int auto_increment,
    last_name   varchar(50) not null,
    first_name  varchar(50) not null,
    middle_name varchar(50) null,
    id_depatrment int         not null,
    constraint employee_id_uindex
        unique (id),
    constraint employee_department_id_fk
        foreign key (id_depatrment) references department (id)
            on update cascade on delete cascade
);

alter table employee
    add primary key (id);


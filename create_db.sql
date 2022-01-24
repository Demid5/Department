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
    id             int auto_increment,
    `last-name`    varchar(50) not null,
    `first-name`   varchar(50) not null,
    `middle-name`  varchar(50) null,
    id_depatrament int         not null,
    constraint employee_id_uindex
        unique (id),
    constraint employee_department_id_fk
        foreign key (id_depatrament) references department (id)
            on update cascade on delete cascade
);

alter table employee
    add primary key (id);


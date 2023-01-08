    create table user (
        id bigint not null auto_increment,
        password varchar(64) not null,
        username varchar(64) not null,
        PRIMARY key (id)
    ) engine=MyISAM;

    create table todo (
        id bigint not null auto_increment,
        title varchar(64) not null,
        completed boolean not null,
        PRIMARY key (id)
    ) engine=MyISAM;


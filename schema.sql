
    create table Consultoras (
        id integer not null,
        cantidad_empleados integer,
        nombre varchar(255),
        primary key (id)
    )

    create table Proyectos (
        id bigint not null,
        costo_estimado numeric(19,2),
        nombre varchar(255),
        consultora_encargada integer,
        primary key (id)
    )

    alter table Proyectos 
        add constraint FK_9k1vuiwhv4c8jjbwasomybi7g 
        foreign key (consultora_encargada) 
        references Consultoras

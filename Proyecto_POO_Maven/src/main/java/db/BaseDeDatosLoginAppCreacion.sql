drop database loginapp;

CREATE DATABASE  IF NOT EXISTS  loginapp;

use loginapp;

create table departamento(
id int,
nombre varchar(20),
alias varchar(5),
primary key (id)
);


create table usuario (
login varchar(10),
password varchar(10),
id_departamento int,
primary key (login)
);

alter table usuario add FOREIGN KEY (id_departamento) references departamento(id);

Create table tarjetaVideo(

id int ,
nombre varchar(15),
PRIMARY KEY (id)
);

Create table componentes(

codigo int AUTO_INCREMENT,
procesador real,
marcaProce varchar(1),
placaMadre varchar(20),
fuentePoder bit(1),
fechaCreacion DATE,
Id_tarjetaVideo int,
PRIMARY KEY (codigo)
);

alter table componentes add FOREIGN KEY (Id_tarjetaVideo) references tarjetaVideo(id);


insert into  tarjetaVideo values (1, 'Nvidia gtx 2080');
insert into  tarjetaVideo values (2, 'AMD RX 580');

insert into componentes values ("1", "2.8" , "I", "Gigabyte B450", true , Date '2020-09-23',1);
insert into componentes values ("2", "3.6" , "A", "Aorus B550m", false ,Date '2022-05-12',2);
    

insert into  departamento values (1, 'Gerencia', 'Ger');
insert into  departamento values (2, 'Personal', 'Per');
insert into  departamento values (3, 'Marketing', 'Mkt');

insert into  usuario values ('lhernandez', 'leo', 3);
insert into  usuario values ('nicoGalaz', 'nico', 3);
insert into  usuario values ('eduRoa', 'lalo', 3);
insert into  usuario values ('martinY', 'pojito', 3);



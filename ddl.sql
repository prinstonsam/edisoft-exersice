create table type_body
(	id integer primary key,
	name varchar(32)
);
create table body
(
id integer primary key,
vin varchar(10),
body_type varchar(10),
color varchar(20),
count_doors integer,
type_body_id integer,
constraint body_type_body_fk foreign key(type_body_id) references type_body(id)
);

create table type_engine
(	id integer primary key,
	name varchar(32)
);

create table engine
(
	id integer primary key,
	serial_number varchar(16) unique,
	type_engine varchar(16),
	volume numeric(4,2),
	power numeric(8,4),
	type_engine_id integer,
	constraint engine_type_engine_fk foreign key(type_engine_id) references type_engine(id)
);
	
create table type_transmission
(	id integer primary key,
	name varchar(32)
);


create table transmission
(
	id integer primary key,
	serial_number varchar(16) unique,
	type_transmission_id integer,
	constraint transmission_type_transmission_fk foreign key(type_transmission_id) references type_transmission(id)
);

create table car(
id integer primary key,
transmission_id integer,
engine_id integer,
body_id integer,
constraint car_transmission_fk foreign key(transmission_id) references transmission(id),
constraint car_engine_fk foreign key(engine_id) references engine(id),
constraint car_body_fk foreign key(body_id) references body(id)
);


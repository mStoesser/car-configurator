create table car_product (
    id integer primary key auto_increment,
    car_type varchar(255),
    car_class varchar(255),
    price int
);
create table car_product_axis (
     id integer primary key auto_increment,
     product_id int,
     name varchar(255),
     default_value text,
     multiple bool,
     CONSTRAINT fk_car_product_axis_product_id FOREIGN KEY(product_id) REFERENCES car_product(id)
);
create table car_product_axis_value (
    id integer primary key auto_increment,
    product_id int,
    axis_id int,
    axis_value varchar(255),
    price int,
    CONSTRAINT fk_car_product_axis_value_product_id FOREIGN KEY(product_id) REFERENCES car_product(id),
    CONSTRAINT fk_car_product_axis_value_axis_id FOREIGN KEY(axis_id) REFERENCES car_product_axis(id)
);
create table car_configuration (
    id integer primary key auto_increment,
    product_id int,
    name varchar(255) NULL default NULL,
    price int not null default 0,
    CONSTRAINT fk_car_configuration_car_product_id FOREIGN KEY(product_id) REFERENCES car_product(id)
);

create table car_configuration_value (
    id integer primary key auto_increment,
    product_configuration_id int,
    axis_key varchar(255),
    axis_value varchar(255)
);

-- create table car_configuration_value (
--     id integer primary key auto_increment,
--     product_configuration_id int,
--     axis_value_id int,
--     CONSTRAINT fk_car_configuration_value_product_configuration_id FOREIGN KEY(product_configuration_id) REFERENCES car_configuration(id),
--     CONSTRAINT fk_car_configuration_value_axis_value_id FOREIGN KEY(axis_value_id) REFERENCES car_product_axis_value(id)
-- );



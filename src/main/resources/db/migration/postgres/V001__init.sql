create sequence product_id_seq;
create table product (
    id integer primary key default product_id_seq.nextval,
    car_type varchar(255),
    car_class varchar(255),
    color varchar(255),
    extras varchar(255),
    price int
);

-- create table product_axis (
--      id serrial primary key,
--      product_id int,
--      name varchar(255),
--      CONSTRAINT fk_product_axis_product_id FOREIGN KEY(product_id)REFERENCES product(id)
-- );

create sequence product_axis_value_id_seq;
create table product_axis_value (
    id integer primary key default product_axis_value_id_seq.nextval,
    product_id int,
--     axis_id int,
    axis_name varchar(255),
    axis_value varchar(255),
    price int,
    CONSTRAINT fk_product_axis_value_product_id FOREIGN KEY(product_id)REFERENCES product(id),
    CONSTRAINT uq_product_id_axis_name unique (product_id, axis_name)
--     ,CONSTRAINT fk_product_axis_value_axis_id FOREIGN KEY(axis_id)REFERENCES product_axis(id)
);






insert into car_product (id, car_class, car_type, price) VALUES
(1, 'CKlasse', 'Cabriolet', 5443000),
(2, 'EKlasse', 'Limousine', 5382300),
(3, 'EQB', 'SUV', 5555000),
(4, 'GKlasse', 'Geländewagen', 11825600),
(5, 'AMG', 'Coupé', 10251800);

insert into car_product_axis (id, product_id, name, default_value, multiple) VALUES
(1, 1, 'color', 'silber', false),
(2, 2, 'color', 'rot', false),
(3, 3, 'color', 'grün', false),
(4, 4, 'color', 'schwarz', false),
(5, 5, 'color', 'gelb', false),

(6, 1, 'engine', '150', false),
(7, 2, 'engine', '118', false),
(8, 3, 'engine', '385', false),
(9, 4, 'engine', '243', false),
(10, 5, 'engine', '287', false),

(11, 1, 'extras', '', true),
(12, 2, 'extras', '', true),
(13, 3, 'extras', '', true),
(14, 4, 'extras', '', true),
(15, 5, 'extras', '', true)
;

insert into car_product_axis_value (axis_id, product_id, axis_value, price) VALUES
    (1, 1, 'silber', 0),
    (1, 1, 'rot', 82000),
    (1, 1, 'grün', 82000),
    (1, 1, 'schwarz', 82000),
    (1, 1, 'gelb', 82000),

    (2, 2, 'silber', 82000),
    (2, 2, 'rot', 0),
    (2, 2, 'grün', 82000),
    (2, 2, 'schwarz', 82000),
    (2, 2, 'gelb', 82000),

    (3, 3, 'silber', 82000),
    (3, 3, 'grün', 0),
    (3, 3, 'schwarz', 82000),
    (3, 3, 'gelb', 82000),

    (4, 4, 'silber', 82000),
    (4, 4, 'rot', 82000),
    (4, 4, 'grün', 82000),
    (4, 4, 'schwarz', 0),


    (5, 5, 'silber', 82000),
    (5, 5, 'rot', 82000),
    (5, 5, 'grün', 82000),
    (5, 5, 'schwarz', 82000),
    (5, 5, 'gelb', 0),


    (6, 1, '90', 0),
    (6, 1, '118', 200000),
    (6, 1, '220', 300000),

    (7, 2, '118', 0),
    (7, 2, '287', 210000),
    (7, 2, '385', 300000),
    (7, 2, '243', 230000),

    (8, 3, '150', 200000),
    (8, 3, '118', 200000),
    (8, 3, '385', 0),
    (8, 3, '243', 230000),
    (8, 3, '287', 210000),

    (9, 4, '150', 200000),
    (9, 4, '118', 200000),
    (9, 4, '385', 300000),
    (9, 4, '243', 0),
    (9, 4, '287', 210000),

    (10, 5, '150', 190000),
    (10, 5, '118', 200000),
    (10, 5, '385', 300000),
    (10, 5, '243', 230000),
    (10, 5, '287', 0),


    (11, 1, 'Panoramadach', 5000),
    (11, 1, 'Lenkradheizung', 5000),
    (11, 1, 'Soundsystem', 5000),
    (11, 1, 'Klimaanlage', 5000),

    (12, 2, 'Panoramadach', 5000),
    (12, 2, 'Lenkradheizung', 5000),

    (12, 2, 'Soundsystem', 5000),
    (12, 2, 'Klimaanlage', 5000),

    (13, 3, 'Panoramadach', 5000),
    (13, 3, 'Soundsystem', 5000),
    (13, 3, 'Klimaanlage', 5000),

    (14, 4, 'Panoramadach', 5000),
    (14, 4, 'Lenkradheizung', 5000),
    (14, 4, 'Leder', 5000),
    (14, 4, 'Soundsystem', 5000),
    (14, 4, 'Klimaanlage', 5000),

    (15, 5, 'Panoramadach', 5000),
    (15, 5, 'Lenkradheizung', 5000),
    (15, 5, 'Leder', 5000),
    (15, 5, 'Klimaanlage', 5000)

;

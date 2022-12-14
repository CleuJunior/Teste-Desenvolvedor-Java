INSERT INTO costumer_entity (costumer_name, costumer_bd, costumer_email, drive_license, address, costumer_phone_number, created_at, update_at) VALUES ('Raimunda Regina Porto', '1974-03-05', 'raimundareginaporto@clinicasilhouette.com.br', '08493447718', 'Rua Astrogildo de Almeida, 328', '(73) 99362-1339', NOW(), NOW());
INSERT INTO costumer_entity (costumer_name, costumer_bd, costumer_email, drive_license, address, costumer_phone_number, created_at, update_at) VALUES ('Gustavo Rafael Elias da Mata', '1960-10-03', 'gustavo-damata84@vipsaude.com.br', '02911058331', 'Jardim Novo Niterói, 378', '(65) 98238-1865', NOW(), NOW());
INSERT INTO costumer_entity (costumer_name, costumer_bd, costumer_email, drive_license, address, costumer_phone_number, created_at, update_at) VALUES ('Heloisa Aurora Jéssica dos Santos', '1988-08-12', 'heloisaauroradossantos@sha.com.br', '18895846006', 'Rua Astrogildo de Almeida, 328', '(47) 98101-9804', NOW(), NOW());
INSERT INTO costumer_entity (costumer_name, costumer_bd, costumer_email, drive_license, address, costumer_phone_number, created_at, update_at) VALUES ('Julio Marcelo Nelson Melo', '1974-03-05', 'julio.marcelo.melo@attglobal.net', '90897130198', 'Praça Vereador Osvaldo Mendonça, 752', '(79) 99539-6592', NOW(), NOW());
INSERT INTO costumer_entity (costumer_name, costumer_bd, costumer_email, drive_license, address, costumer_phone_number, created_at, update_at) VALUES ('Hugo Benjamin Barbosa', '1980-11-02', 'hugo.benjamin.barbosa@cathedranet.com.br', '74091777742', 'Travessa Jasmim, 101', '(68) 99602-7578', NOW(), NOW());

INSERT INTO brand_entity (brand_name, created_at) VALUES ('BMW', NOW());
INSERT INTO brand_entity (brand_name, created_at) VALUES ('Chevrolet', NOW());
INSERT INTO brand_entity (brand_name, created_at) VALUES ('Yamaha', NOW());
INSERT INTO brand_entity (brand_name, created_at) VALUES ('Renault', NOW());
INSERT INTO brand_entity (brand_name, created_at) VALUES ('Nissan', NOW());


INSERT INTO category_entity (category_name, category_description, created_at) VALUES ('Categoria 01', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO category_entity (category_name, category_description, created_at) VALUES ('Categoria 02', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO category_entity (category_name, category_description, created_at) VALUES ('Categoria 03', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO category_entity (category_name, category_description, created_at) VALUES ('Categoria 04', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO category_entity (category_name, category_description, created_at) VALUES ('Categoria 05', 'Lorem ipsum dolor sit amet.', NOW());


INSERT INTO specification_entity (specification_name, specification_description, created_at) VALUES ('Especificacao 01', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO specification_entity (specification_name, specification_description, created_at) VALUES ('Especificacao 02', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO specification_entity (specification_name, specification_description, created_at) VALUES ('Especificacao 03', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO specification_entity (specification_name, specification_description, created_at) VALUES ('Especificacao 04', 'Lorem ipsum dolor sit amet.', NOW());
INSERT INTO specification_entity (specification_name, specification_description, created_at) VALUES ('Especificacao 05', 'Lorem ipsum dolor sit amet.', NOW());


INSERT INTO car_entity (car_name, car_description, daily_rate, car_avaliable, license_plate, brand_id, category_id, car_color, created_at) VALUES ('Carro Nome 01', 'Lorem ipsum dolor sit amet.', 98.77, true, 'XPT-1146', 1, 5, 'Preto' , NOW());
INSERT INTO car_entity (car_name, car_description, daily_rate, car_avaliable, license_plate, brand_id, category_id, car_color, created_at) VALUES ('Carro Nome 02', 'Lorem ipsum dolor sit amet.', 110.18, false, 'ABC-1456', 2, 3, 'Amarelo' , NOW());
INSERT INTO car_entity (car_name, car_description, daily_rate, car_avaliable, license_plate, brand_id, category_id, car_color, created_at) VALUES ('Carro Nome 03', 'Lorem ipsum dolor sit amet.', 69.33, false, 'XYZ-4944', 4, 4, 'Verde' , NOW());
INSERT INTO car_entity (car_name, car_description, daily_rate, car_avaliable, license_plate, brand_id, category_id, car_color, created_at) VALUES ('Carro Nome 04', 'Lorem ipsum dolor sit amet.', 88.99, true, 'KLC-0056', 5, 1, 'Azul' , NOW());
INSERT INTO car_entity (car_name, car_description, daily_rate, car_avaliable, license_plate, brand_id, category_id, car_color, created_at) VALUES ('Carro Nome 05', 'Lorem ipsum dolor sit amet.', 148.99, false, 'OPL-456', 3, 2, 'Abobora' , NOW());


INSERT INTO rental_entity (car_id, costumer_id, start_date, end_date, total, created_at, update_at) VALUES (1, 1, NOW(), NOW(), 199.88, NOW(), NOW());
INSERT INTO rental_entity (car_id, costumer_id, start_date, end_date, total, created_at, update_at) VALUES (2, 2, NOW(), NOW(), 98.66, NOW(), NOW());
INSERT INTO rental_entity (car_id, costumer_id, start_date, end_date, total, created_at, update_at) VALUES (3, 3, NOW(), NOW(), 88.33, NOW(), NOW());
INSERT INTO rental_entity (car_id, costumer_id, start_date, end_date, total, created_at, update_at) VALUES (4, 4, NOW(), NOW(), 99.77, NOW(), NOW());
INSERT INTO rental_entity (car_id, costumer_id, start_date, end_date, total, created_at, update_at) VALUES (5, 5, NOW(), NOW(), 53.33, NOW(), NOW());


INSERT INTO car_specification (car_id, specification_id) VALUES (1, 1);
INSERT INTO car_specification (car_id, specification_id) VALUES (2, 2);
INSERT INTO car_specification (car_id, specification_id) VALUES (3, 3);
INSERT INTO car_specification (car_id, specification_id) VALUES (4, 4);
INSERT INTO car_specification (car_id, specification_id) VALUES (5, 5);
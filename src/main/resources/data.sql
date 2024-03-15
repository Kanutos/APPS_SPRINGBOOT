-- insertar regiones
INSERT INTO REGION (nombre) VALUES ('Andalucia');
INSERT INTO REGION (nombre) VALUES ('asturias');
INSERT INTO REGION (nombre) VALUES ('Caceres');
INSERT INTO REGION (nombre) VALUES ('Cantabria');
INSERT INTO REGION (nombre) VALUES ('Aragon');
INSERT INTO REGION (nombre) VALUES ('Catalonia');
INSERT INTO REGION (nombre) VALUES ('Mandrid');
INSERT INTO REGION (nombre) VALUES ('Galicia');

--insertar entrenadores
INSERT INTO HUMANO (nombre, activo) VALUES ('Billy Eilish', false);
INSERT INTO HUMANO (nombre, activo) VALUES ('Jake gillenhal', false);
INSERT INTO HUMANO (nombre, activo) VALUES ('Steve Buscemi', false);
INSERT INTO HUMANO (nombre, activo) VALUES ('Profesor Bacterio', false);
INSERT INTO HUMANO (nombre, activo) VALUES ('Mandalorian', true);
INSERT INTO HUMANO (nombre, activo) VALUES ('James', true);
INSERT INTO HUMANO (nombre, activo) VALUES ('Giovanni Prestanucio', true);
INSERT INTO HUMANO (nombre, activo) VALUES ('Andrea Bochielli', true);
INSERT INTO HUMANO (nombre, activo) VALUES ('Steven Siegal', true);


--insertar pokemon con entrenador
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Mordisquitos', 1, 2);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('charlie', 1, 3);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Buzz', 1, 4);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Broly', 1, 5);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Lobo', 1, 6);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Wolf', 1, 7);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Kratos', 2, 2);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Lamban', 2, 3);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('BUBU', 2, 4);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Birdman', 2, 5);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Scrapy', 2, 6);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Irati', 2, 7);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Scooby', 2, 8);
INSERT INTO MASCOTA (nombre, region, humano_id) VALUES ('Nissa', 2, 9);



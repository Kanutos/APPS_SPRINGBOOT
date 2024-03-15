CREATE TABLE IF NOT EXISTS REGION(
    id bigint primary key auto_increment,
    nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS HUMANO(
    id bigint primary key auto_increment,
    nombre varchar(50),
    activo boolean
);

CREATE TABLE IF NOT EXISTS MASCOTA(
    id bigint primary key auto_increment,
    nombre varchar(50),
    region INT,
    humano_id bigint,
    FOREIGN KEY (region) REFERENCES REGION(id),
    FOREIGN KEY (humano_id) REFERENCES HUMANO(id)
);

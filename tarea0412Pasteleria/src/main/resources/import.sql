INSERT INTO categoria (id, nombre) VALUES (1, 'Tartas');
INSERT INTO categoria (id, nombre) VALUES (2, 'Galletas');
INSERT INTO categoria (id, nombre) VALUES (3, 'Bollería');

INSERT INTO producto (id, nombre, precio, descripcion, categoria_id)
VALUES (1, 'Tarta de queso', 12.50, 'Tarta muy cremosa que casi se derrite', 1);

INSERT INTO producto (id, nombre, precio, descripcion, categoria_id)
VALUES (2, 'Galletas de chocolate', 4.00, 'Galletas crujientes con chispas de chocolate', 2);

INSERT INTO producto (id, nombre, precio, descripcion, categoria_id)
VALUES (3, 'Croissant de mantequilla', 1.80, 'Bollería clásica de media luna.', 3);

INSERT INTO cliente (id, nombre, email) VALUES (1, 'Carmencita Fernández', 'carmenchu@gmail.com');
INSERT INTO cliente (id, nombre, email) VALUES (2, 'Jorge Chacón', 'jorgito@gmail.com');
INSERT INTO cliente (id, nombre, email) VALUES (3, 'María Pita', 'maria@gmail.com');

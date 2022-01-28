INSERT INTO categoria (
    id,
    descripcion,
    creado,
    actualizado,
    activo
)
VALUES
    (1,'Computacion', NOW(), NOW(), true),
    (2,'Telefonia', NOW(), NOW(), true),
    (3,'Videojuegos', NOW(), NOW(), true);

alter sequence categoria_id_seq restart with 4;


INSERT INTO proveedor (
    id,
    empresa,
    contacto,
    direccion,
    creado,
    actualizado,
    activo
)
VALUES
    (1,'Sony','Juan Gonzalez','Pje. Della Paolera 22 Piso 15', NOW(), NOW(), true),
    (2,'Dell','Carlos Graggero','Ing. Butty 214 Piso 3', NOW(), NOW(), true),
    (3,'Samsung','Francisco Heredia','Av. Ejercito de Salvacion 311', NOW(), NOW(), true),
    (4,'Microsoft','Gerardo Garcia','Bulnes 518 Piso 7', NOW(), NOW(), true);


alter sequence proveedor_id_seq restart with 5;

--
INSERT INTO proveedor_categoria (
    id_proveedor,
    id_categoria
)
VALUES
    (1,1), -- Sony/Computacion
    (1,3), -- Sony/Videojuegos
    (2,1), -- Dell/Computacion
    (3,1), -- Samsung/Computacion
    (3,2), -- Samgung/Telefonia
    (4,3); -- Microsoft/Videojuegos



INSERT INTO producto (
    id,
    descripcion,
    id_proveedor,
    id_categoria,
    precio_unitario,
    unidades_stock,
    unidades_reposicion,
    flg_discontinuo,
    creado,
    actualizado,
    url_imagen,
    activo
    )
VALUES
    (1,'Notebook Vaio SVN1445210',1,1,1300,5,2,false, NOW(), NOW(), '', true), -- notebook/sony
    (2,'Notebook Vaio SVN1562883',1,1,980,2,3,false, NOW(), NOW(), 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQo99E9azHbmljaRv2eURA8L5xd4JyQ6yRY7g&usqp=CAU', true), -- notebook/sony
    (3,'Ultrabook Slim Vaio SVUB15551',1,1,1800,1,1,false, NOW(), NOW(), 'https://i.blogs.es/408f1b/detras-1/1366_2000.jpg', true), -- notebook/sony
    (4,'Inspiron 14-55312',2,1,540,6,0,false, NOW(), NOW(), 'https://tejarra-media.s3.amazonaws.com/55311/item_XXL_132865270_fac74bcb13aba.jpg', true), -- notebook/dell
    (5,'Latitude 12-24411',2,1,1100,3,0,false, NOW(), NOW(), '', true), -- notebook/dell
    (6,'Chromebook 13KBE04',3,1,880,1,3,false, NOW(), NOW(), 'https://m.media-amazon.com/images/I/81mX-4s+guL._AC_SL1500_.jpg', true), -- notebook/samsung
    (7,'Xperia V6',1,2,660,3,1,false, NOW(), NOW(), 'https://m.media-amazon.com/images/I/81ktijeMGJL._AC_SL1500_.jpg', true), -- cel/sony
    (8,'Xperia V9',1,2,1200,1,0,false, NOW(), NOW(), 'https://m.media-amazon.com/images/I/71ctZEsl1vL._AC_SL1500_.jpg', true), -- cel/sony
    (9,'S8  64GB',3,2,990,4,3,false, NOW(), NOW(), 'https://m.media-amazon.com/images/I/71pjGN8WsoL._AC_SL1500_.jpg', true), -- cel/samsung
    (10,'S8 32GB',3,2,990,4,3,false, NOW(), NOW(), 'https://m.media-amazon.com/images/I/71pjGN8WsoL._AC_SL1500_.jpg', true), -- cel/samsung
    (11,'S8 mini',3,2,550,8,2,false, NOW(), NOW(), 'https://m.media-amazon.com/images/I/71JvbuEDhCL._AC_SL1500_.jpg', true), -- cel/samsung
    (12,'S9',3,2,1300,3,0,false, NOW(), NOW(), 'https://m.media-amazon.com/images/I/81+h9mpyQmL._AC_SL1500_.jpg', true), -- cel/samsung
    (13,'S9 mini',3,2,670,5,2,false, NOW(), NOW(), '', true), -- cel/samsung
    (14,'Playstation 4 500 MB',4,3,700,5,3,false, NOW(), NOW(), '', true), -- vj/ms
    (15,'Playstation 4 1000 MG',4,3,1100,3,1,false, NOW(), NOW(), '', true), -- vj/ms
    (16,'Mando Playstation XV3432',4,3,150,3,0,false, NOW(), NOW(), '', true), -- vj/ms
    (17,'Xbox One',1,3,1100,4,0,false, NOW(), NOW(), '', true), -- vj/Sony
    (18,'Mando Xbox Bateria VBB133123',1,3,170,3,0,false, NOW(), NOW(), '', true); -- vj/Sony


alter sequence producto_id_seq restart with 19;


INSERT INTO usuario (
    id,
    correo_electronico,
    contrasenia,
    nombre,
    apellido,
    direccion,
    rol,
    administrador,
    creado,
    actualizado,
    activo
    )
VALUES
    (1, 'admin', 'admin', 'Julian', 'Spinelli', null, 'MANAGER', null, NOW(), NOW(), true),
    (2, 'empleado@uno.com', 'empleado1', 'Empleado', 'Uno', null, 'SALESMAN', 1, NOW(), NOW(), true),
    (3, 'empleado@dos.com', 'empleado2', 'Empleado', 'Dos', null, 'SALESMAN', 1, NOW(), NOW(), true),
    (4, 'cliente@uno.com', 'cliente1', 'Cliente', 'Uno', 'Banfield', 'CLIENT', null, NOW(), NOW(), true),
    (5, 'cliente@dos.com', 'cliente2', 'Cliente', 'Dos', 'Mar del Plata', 'CLIENT', null, NOW(), NOW(), true);

alter sequence usuario_id_seq restart with 6;


INSERT INTO orden (
    id,
    id_cliente,
    id_empleado,
    fecha_entregada,
    esta_abierta,
    creado,
    actualizado,
    activo
    )
VALUES
    (1, 1, null, NOW(), false, NOW(), NOW(), true),
    (2, 2, 1, null, true, NOW(), NOW(), true),
    (3, 1, null, null, true, NOW(), NOW(), true),
    (4, 1, null, NOW(), false, NOW(), NOW(), true);


alter sequence orden_id_seq restart with 5;


INSERT INTO detalle_orden (
    id,
    id_orden,
    id_producto,
    cantidad,
    precio_venta,
    creado,
    actualizado,
    activo
    )
VALUES
    (1, 1, 1, 1, 123.45, NOW(), NOW(), true),
    (2, 1, 2, 2, 3254.21, NOW(), NOW(), true),
    (3, 1, 3, 1, 1588.21, NOW(), NOW(), true),
    (4, 2, 5, 3, 54788.21, NOW(), NOW(), true),
    (5, 3, 3, 1, 1588.21, NOW(), NOW(), true),
    (6, 3, 5, 3, 54788.21, NOW(), NOW(), true),
    (7, 4, 3, 1, 1588.21, NOW(), NOW(), true),
    (8, 3, 5, 3, 54788.21, NOW(), NOW(), true);

alter sequence detalle_orden_id_seq restart with 9;





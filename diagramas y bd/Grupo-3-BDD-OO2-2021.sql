create schema if not exists `Grupo-3-BDD-OO2-2021`;

-- Perfiles

INSERT INTO `Grupo-3-BDD-OO2-2021`.`perfil` (`id_perfil`, `activo`,`tipo_perfil`) VALUES (1,1,"ROLE_ADMIN");

INSERT INTO `Grupo-3-BDD-OO2-2021`.`perfil` (`id_perfil`, `activo`,`tipo_perfil`) VALUES (2,1,"ROLE_AUDIT");

INSERT INTO `Grupo-3-BDD-OO2-2021`.`perfil` (`id_perfil`, `activo`,`tipo_perfil`) VALUES (3,1,"ROLE_GUEST");

-- Usuarios

INSERT INTO `Grupo-3-BDD-OO2-2021`. `usuario` (`id_usuario`, `activo`, `apellido`, `dni`, `email`, `nombre`, `nombre_usuario`, `pass`, `tipo`, `perfil_id`) VALUES (1, 1, "Tello", 41806859, "leandrotello1632@gmail.com", "Leandro", "root", "$2a$10$cWjmVxROYTZtmg5RAJkp6.qgv3/9q6QsUYvBJBaCElysHJtEPXYoS", 0, 1);

INSERT INTO `Grupo-3-BDD-OO2-2021`. `usuario` (`id_usuario`, `activo`, `apellido`, `dni`, `email`, `nombre`, `nombre_usuario`, `pass`, `tipo`, `perfil_id`) VALUES (2, 1, "Roldan", 42355784, "nicolasroldan00@gmail.com", "Nicolas", "auditor", "$2a$10$BdhNW7fpkzkNSY7VNGqci..zD9GJZNPLyGapgxWTSllJWxs.mJpc.", 0, 2);

INSERT INTO `Grupo-3-BDD-OO2-2021`. `usuario` (`id_usuario`, `activo`, `apellido`, `dni`, `email`, `nombre`, `nombre_usuario`, `pass`, `tipo`, `perfil_id`) VALUES (3, 1, "Invitado", 42355666, "invitado@gmail.com", "Invitado", "invitado", "$2a$10$QvpZ/6Wdx4wKF2QqgLPOcu/cFYNQihRbKyKeiepG0H4Rv7wJqvZp.", 0, 3);

-- Lugares

INSERT INTO `Grupo-3-BDD-OO2-2021`.`lugar` (`id_lugar`, `codigo_postal`,`lugar`) VALUES (1,1824,"LANUS");

INSERT INTO `Grupo-3-BDD-OO2-2021`.`lugar` (`id_lugar`, `codigo_postal`,`lugar`) VALUES (2,1832,"LOMAS DE ZAMORA");

INSERT INTO `Grupo-3-BDD-OO2-2021`.`lugar` (`id_lugar`, `codigo_postal`,`lugar`) VALUES (3,1834,"TEMPERLEY");

INSERT INTO `Grupo-3-BDD-OO2-2021`.`lugar` (`id_lugar`, `codigo_postal`,`lugar`) VALUES (4,1827,"CABA");

INSERT INTO `Grupo-3-BDD-OO2-2021`.`lugar` (`id_lugar`, `codigo_postal`,`lugar`) VALUES (5,7600,"MAR DEL PLATA");

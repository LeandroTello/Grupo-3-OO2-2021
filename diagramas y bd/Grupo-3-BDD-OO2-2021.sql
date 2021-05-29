create schema if not exists `Grupo-3-BDD-OO2-2021`;

INSERT INTO `Grupo-3-BDD-OO2-2021`.`perfil` (`id_perfil`, `activo`,`tipo_perfil`) VALUES (1,1,"ROLE_ADMIN");

INSERT INTO `Grupo-3-BDD-OO2-2021`.`perfil` (`id_perfil`, `activo`,`tipo_perfil`) VALUES (2,1,"ROLE_AUDIT");

INSERT INTO `Grupo-3-BDD-OO2-2021`. `usuario` (`id_usuario`, `activo`, `apellido`, `dni`, `email`, `nombre`, `nombre_usuario`, `pass`, `tipo`, `perfil_id`) VALUES (1, 1, "Tello", 41806859, "leandrotello1632@gmail.com", "Leandro", "root", "$2a$10$cWjmVxROYTZtmg5RAJkp6.qgv3/9q6QsUYvBJBaCElysHJtEPXYoS", 0, 1);

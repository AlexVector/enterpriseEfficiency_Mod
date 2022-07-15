-- Filling users table
INSERT INTO `users` (`email`, `password`, `role`)
-- passwords 123456sS, Abcdef9, dwe54DSws, wdsad5wd5sWDsda652s
VALUES ('admin@gmail.com', '$31$14$Fs3Fi-2rlGMW3eCO2cw7F68p4NKVPVs4Al6N_7gu150', 0),
       ('slowman@yandex.ru', '$31$14$1a944_v9szD_A4yzg6QMcE5NhV9-w3OeFu82k64knlU',2),
       ('example@mail.ru', '$31$14$kD5S6aQM-ETST189g2HVODDrEnxgcmbrq8s1RREZgD8', 2),
       ('vadim.malynich@mail.ru', '$31$14$yAHS2sIdUHYlJJV5zDixYywuniTQrfT5q_P4Yh5mhrw', 1);


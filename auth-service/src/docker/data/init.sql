DROP schema IF EXISTS university;
CREATE SCHEMA university;
USE university;

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users`
(
    `id`        bigint       NOT NULL AUTO_INCREMENT,
    `firstname` varchar(36)  NOT NULL,
    `surname`   varchar(36)  NOT NULL,
    middlename  varchar(36) DEFAULT NULL,
    `password`  varchar(100) NOT NULL,
    `email`     varchar(36)  NOT NULL,
    `status`    varchar(36)  NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
);

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`
(
    `id`   bigint      NOT NULL AUTO_INCREMENT,
    `name` varchar(36) NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`
(
    `user_id` bigint NOT NULL,
    `role_id` bigint NOT NULL,
    KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
    KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
    CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);
DROP TABLE IF EXISTS `refreshtoken`;
CREATE TABLE `refreshtoken`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `expiry_date` datetime     NOT NULL,
    `token`       varchar(255) NOT NULL,
    `user_id`     bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_or156wbneyk8noo4jstv55ii3` (`token`),
    KEY `FKa652xrdji49m4isx38pp4p80p` (`user_id`),
    CONSTRAINT `FKa652xrdji49m4isx38pp4p80p` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

INSERT INTO `users` (`id`, `firstname`, `surname`, middlename, `password`, `email`, `status`)
VALUES (1, 'Admin', 'Adminov', 'Adminovich', '$2a$10$q7ReXzUuRwPtX9tHB9QrkunSjqFkkVmzeFU7vUa2a4vs6EfPxMfFG',
        'admin@admin.com', 'ACTIVE'),
       (2, 'Student', 'Studentov', 'Studentovich', '$2a$10$q7ReXzUuRwPtX9tHB9QrkunSjqFkkVmzeFU7vUa2a4vs6EfPxMfFG',
        'student@student.com', 'ACTIVE'),
       (3, 'Teacher', 'Teacherov', 'Teacherovich', '$2a$10$q7ReXzUuRwPtX9tHB9QrkunSjqFkkVmzeFU7vUa2a4vs6EfPxMfFG',
        'teacher@teacher.com', 'ACTIVE'),
       (4, 'Docker', 'Docker', 'Docker', '$2a$10$q7ReXzUuRwPtX9tHB9QrkunSjqFkkVmzeFU7vUa2a4vs6EfPxMfFG',
        'docker@docker.com', 'ACTIVE');

INSERT INTO `roles` (`id`, `name`)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_TEACHER'),
       (3, 'ROLE_STUDENT');

INSERT INTO `user_roles` (`user_id`, `role_id`)
VALUES (1, 1),
       (2, 3),
       (3, 2);

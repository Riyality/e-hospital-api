INSERT INTO `spti`.`login` (`id`, `username`, `password`, `role`) VALUES ('1', 'riya@yopmail.com', 'Demo_1234', 'HR');

INSERT INTO `spti`.`doctor_specialization` (`id`, `title`) VALUES ('1', 'Allergists');
INSERT INTO `spti`.`doctor_specialization` (`id`, `title`) VALUES ('2', 'Cardiologists');
INSERT INTO `spti`.`doctor_specialization` (`id`, `title`) VALUES ('3', 'Dermatologists');
INSERT INTO `spti`.`doctor_specialization` (`id`, `title`) VALUES ('4', 'Family Physicians');
INSERT INTO `spti`.`doctor_specialization` (`id`, `title`) VALUES ('5', 'Neurologists');
INSERT INTO `spti`.`doctor_specialization` (`id`, `title`) VALUES ('6', 'Psychiatrists');

INSERT INTO `spti`.`branch` (`id`, `name`, `address`) VALUES ('1', 'BhadGao', 'Jalgao');
INSERT INTO `spti`.`staff` (`id`, `first_name`, `last_name`, `role`, `email`, `phone_number`, `address`, `experience`, `status`, `branch`) VALUES ('1', 'Riya', 'Anuse', 'HR', 'riya@yopmail.com', '8080876765', 'Magarpatta', '3 years', 'Active', '1');


INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('1', 'Tab');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('2', 'Syrups');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('3', 'IV');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('4', 'Capsules');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('5', 'Injections');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('6', 'Topicals');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('7', 'Drops');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('8', 'Powders');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('9', 'Suppositories');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('10', 'Patches');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('11', 'Nebulizers');
INSERT INTO `spti`.`medicine_type` (`id`, `type`) VALUES ('12', 'Lozenges');

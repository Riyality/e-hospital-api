DROP SCHEMA IF EXISTS `spti`;
CREATE SCHEMA `spti` ;
use `spti`;

CREATE TABLE `spti`.`branch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
  
CREATE TABLE spti.`login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `role` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);


CREATE TABLE spti.`doctors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(16) NOT NULL,
  `specialization` varchar(32) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone_number` varchar(16) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `experience` varchar(16) DEFAULT NULL,
  `status` varchar(16) DEFAULT NULL,
  `branch` int NOT NULL,
  `consultation_fee` int DEFAULT NULL,
  `available_days` varchar(32) DEFAULT NULL,
  `available_time_slots` varchar(32) DEFAULT NULL,
  `joining_date` timestamp NULL DEFAULT NULL,
  `qualifications` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_doctors_branch` (`branch`),
  CONSTRAINT `fk_doctors_branch` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
);

CREATE TABLE spti.`insurance_details` (
  `insurance_id` int NOT NULL AUTO_INCREMENT,
  `policy_number` varchar(8) NOT NULL,
  `provider_name` varchar(64) DEFAULT NULL,
  `expiry_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`insurance_id`)
);
CREATE TABLE spti.`ward` (
  `ward_id` int NOT NULL AUTO_INCREMENT,
  `ward_name` varchar(32) NOT NULL,
  `max_capacity` int NOT NULL,
  `current_occupancy` int DEFAULT '0',
  `floor_number` int NOT NULL,
  `wing` varchar(16) NOT NULL,
  `branch` int NOT NULL,
  `status` varchar(16) DEFAULT 'Active',
  `charges` int DEFAULT NULL,
  PRIMARY KEY (`ward_id`),
  KEY `branch` (`branch`),
  CONSTRAINT `ward_ibfk_1` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
);

CREATE TABLE spti.`patients` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(16) NOT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `date_of_birth` timestamp NULL DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `phone_number` varchar(16) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `emergency_contact_name` varchar(64) DEFAULT NULL,
  `emergency_contact_number` varchar(16) DEFAULT NULL,
  `blood_type` varchar(4) DEFAULT NULL,
  `allergies` text,
  `medical_history` text,
  `occupation` varchar(32) DEFAULT NULL,
  `marital_status` varchar(16) DEFAULT NULL,
  `nationality` varchar(32) DEFAULT NULL,
  `language_spoken` varchar(32) DEFAULT NULL,
  `religion` varchar(64) DEFAULT NULL,
  `insurance_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `branch` int NOT NULL,
  `admission_status` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `insurance_id` (`insurance_id`),
  KEY `branch` (`branch`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `patients_ibfk_1` FOREIGN KEY (`insurance_id`) REFERENCES `insurance_details` (`insurance_id`),
  CONSTRAINT `patients_ibfk_2` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `patients_ibfk_3` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
);


CREATE TABLE spti.`cot` (
  `cot_id` int NOT NULL AUTO_INCREMENT,
  `cot_number` int NOT NULL,
  `ward_id` int NOT NULL,
  `status` varchar(16) DEFAULT 'Available',
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`cot_id`),
  UNIQUE KEY `patient_id` (`patient_id`),
  KEY `ward_id` (`ward_id`),
  CONSTRAINT `cot_ibfk_1` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`ward_id`),
  CONSTRAINT `cot_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`)
);

CREATE TABLE spti.`appointments` (
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `appointment_date` timestamp NOT NULL,
  `appointment_time` time NOT NULL,
  `status` varchar(16) DEFAULT 'Scheduled',
  `phone_number` varchar(16) DEFAULT NULL,
  `notes` text,
  `branch` int NOT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `fk_appointments_branch` (`branch`),
  CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`),
  CONSTRAINT `appointments_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `fk_appointments_branch` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
);

CREATE TABLE spti.`patient_admissions` (
  `admission_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int NOT NULL,
  `ward_id` int NOT NULL,
  `cot_id` int NOT NULL,
  `admission_date` timestamp NOT NULL,
  `discharge_date` timestamp NULL DEFAULT NULL,
  `doctor_id` int NOT NULL,
  `next_of_kin_name` varchar(64) DEFAULT NULL,
  `next_of_kin_relationship` varchar(64) DEFAULT NULL,
  `next_of_kin_phone_number` varchar(16) DEFAULT NULL,
  `branch` int NOT NULL,
  `admission_status` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`admission_id`),
  KEY `patient_id` (`patient_id`),
  KEY `ward_id` (`ward_id`),
  KEY `cot_id` (`cot_id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `branch` (`branch`),
  CONSTRAINT `patient_admissions_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`),
  CONSTRAINT `patient_admissions_ibfk_2` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`ward_id`),
  CONSTRAINT `patient_admissions_ibfk_3` FOREIGN KEY (`cot_id`) REFERENCES `cot` (`cot_id`),
  CONSTRAINT `patient_admissions_ibfk_4` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `patient_admissions_ibfk_5` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
);


CREATE TABLE spti.`doctor_specialization` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE spti.`prescriptions` (
  `prescription_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `prescription_date` date NOT NULL,
  `prescription` text,
  PRIMARY KEY (`prescription_id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `prescriptions_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`),
  CONSTRAINT `prescriptions_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
);


CREATE TABLE spti.`medicines` (
  `medicine_id` int NOT NULL AUTO_INCREMENT,
  `prescription_id` int NOT NULL,
  `medicine_name` varchar(64) NOT NULL,
  `medicine_type` varchar(32) DEFAULT NULL,
  `dosage` varchar(16) DEFAULT NULL,
  `instructions` text,
  `num_days` int DEFAULT NULL,
  `tablet_quantity` int DEFAULT NULL,
  PRIMARY KEY (`medicine_id`),
  KEY `prescription_id` (`prescription_id`),
  CONSTRAINT `medicines_ibfk_1` FOREIGN KEY (`prescription_id`) REFERENCES `prescriptions` (`prescription_id`)
);

CREATE TABLE spti.`staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(16) NOT NULL,
  `role` varchar(32) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone_number` varchar(16) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `experience` varchar(16) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `branch` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);

CREATE TABLE `spti`.`medicine_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

  

CREATE TABLE `spti`.`treatments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `medicine_type` varchar(32) DEFAULT NULL,
  `medicine` varchar(64) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `treatment_date` timestamp NULL DEFAULT NULL,
  `admission_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `admission_id` (`admission_id`),
  CONSTRAINT `treatments_ibfk_1` FOREIGN KEY (`admission_id`) REFERENCES `patient_admissions` (`admission_id`)
);
  
  CREATE TABLE `spti`.`bills` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admission_id` int NOT NULL,
  `amount` int DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `final_bill` int DEFAULT NULL,
  `paid_amount` int DEFAULT NULL,
  `pending_amount` int DEFAULT NULL,
  `status` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `admission_id` (`admission_id`),
  CONSTRAINT `bills_ibfk_1` FOREIGN KEY (`admission_id`) REFERENCES `patient_admissions` (`admission_id`)
);

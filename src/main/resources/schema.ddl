DROP SCHEMA IF EXISTS `spti`;
CREATE SCHEMA `spti` ;
use `spti`;

CREATE TABLE `spti`.`branch` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NULL,
  `address` VARCHAR(128) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `role`  VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    specialization VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255),
    experience VARCHAR(20),
    status VARCHAR(20),
    branch INT NOT NULL,
    consultation_fee INT,
    available_days VARCHAR(255),
    available_time_slots VARCHAR(255),
    joining_date TIMESTAMP,
    qualifications VARCHAR(255)
);


ALTER TABLE spti.doctors
ADD CONSTRAINT fk_doctors_branch
FOREIGN KEY (branch)
REFERENCES spti.branch(id);

CREATE TABLE spti.insurance_details (
    insurance_id INT AUTO_INCREMENT PRIMARY KEY,
    policy_number VARCHAR(50),
    provider_name VARCHAR(100),
    expiry_date TIMESTAMP
);
CREATE TABLE spti.ward (
    ward_id INT AUTO_INCREMENT PRIMARY KEY,
    ward_name VARCHAR(50) NOT NULL,
    max_capacity INT NOT NULL,
    current_occupancy INT DEFAULT 0,
    floor_number INT NOT NULL,
    wing VARCHAR(20) NOT NULL,
    branch INT NOT NULL,
    status VARCHAR(20) DEFAULT 'Active',
    `charges` INT NULL,
    FOREIGN KEY (branch) REFERENCES spti.branch(id)
);

CREATE TABLE spti.patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    gender VARCHAR(8),
    date_of_birth TIMESTAMP,
    address VARCHAR(255),
    phone_number VARCHAR(15),
    email VARCHAR(100),
    emergency_contact_name VARCHAR(100),
    emergency_contact_number VARCHAR(15),
    blood_type VARCHAR(5),
    allergies TEXT,
    medical_history TEXT,
    occupation VARCHAR(50),
    marital_status VARCHAR(32),
    nationality VARCHAR(50),
    language_spoken VARCHAR(50),
    religion VARCHAR(50),
    insurance_id INT,
    doctor_id INT NULL,
    branch INT NOT NULL,
    FOREIGN KEY (insurance_id) REFERENCES spti.insurance_details(insurance_id),
    FOREIGN KEY (branch) REFERENCES spti.branch(id),
    FOREIGN KEY (doctor_id) REFERENCES spti.doctors(id)
);


CREATE TABLE spti.cot (
    cot_id INT AUTO_INCREMENT PRIMARY KEY,
    cot_number INT NOT NULL,
    ward_id INT NOT NULL,
    status VARCHAR(20) DEFAULT 'Available',
    patient_id INT UNIQUE,
    FOREIGN KEY (ward_id) REFERENCES spti.ward(ward_id),
    FOREIGN KEY (patient_id) REFERENCES spti.patients(patient_id)
);

CREATE TABLE spti.appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date TIMESTAMP NOT NULL,
    appointment_time TIME NOT NULL,
    status VARCHAR(20) DEFAULT 'Scheduled',
    phone_number VARCHAR(15),
    notes TEXT,
     branch INT NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
ALTER TABLE spti.appointments
ADD CONSTRAINT fk_appointments_branch
FOREIGN KEY (branch)
REFERENCES spti.branch(id);

CREATE TABLE spti.patient_admissions (
    admission_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    ward_id INT NOT NULL,
    cot_id INT NOT NULL,
    admission_date TIMESTAMP NOT NULL,
    discharge_date TIMESTAMP,
    doctor_id INT NOT NULL, 
    next_of_kin_name VARCHAR(100),
    next_of_kin_relationship VARCHAR(50),
    next_of_kin_phone_number VARCHAR(15),
    branch INT NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES spti.patients(patient_id),
    FOREIGN KEY (ward_id) REFERENCES spti.ward(ward_id),
    FOREIGN KEY (cot_id) REFERENCES spti.cot(cot_id),
    FOREIGN KEY (doctor_id) REFERENCES spti.doctors(id),
    FOREIGN KEY (branch) REFERENCES spti.branch(id)
);


CREATE TABLE `doctor_specialization` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE spti.prescriptions (
    prescription_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    prescription_date DATE NOT NULL,
    prescription TEXT,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);


CREATE TABLE spti.medicines (
    medicine_id INT AUTO_INCREMENT PRIMARY KEY,
    prescription_id INT NOT NULL,
    medicine_name VARCHAR(100) NOT NULL,
    medicine_type VARCHAR(50),
    dosage VARCHAR(50),
    instructions TEXT,
    num_days INT,
    tablet_quantity INT,
    FOREIGN KEY (prescription_id) REFERENCES prescriptions(prescription_id)
);

CREATE TABLE `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `experience` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `branch` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);

CREATE TABLE `spti`.`medicine_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  
  ALTER TABLE `spti`.`patients` 
ADD COLUMN `admission_status` VARCHAR(45) NULL AFTER `branch`;

ALTER TABLE `spti`.`patient_admissions` 
ADD COLUMN `admission_status` VARCHAR(45) NULL AFTER `branch`;

CREATE TABLE `spti`.`treatments` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `medicine_type` VARCHAR(45) NULL,
  `medicine` VARCHAR(45) NULL,
  `quantity` INT NULL,
  `price` INT NULL,
  `treatment_date` TIMESTAMP NULL,
  `admission_id` INT NULL,
   FOREIGN KEY (admission_id) REFERENCES patient_admissions(admission_id)
  PRIMARY KEY (`id`));
  
  CREATE TABLE `spti`.`bills` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `admission_id` INT NOT NULL,
  `amount` INT NULL,
  `discount` INT NULL,
  `final_bill` INT NULL,
  `paid_amount` INT NULL,
  `pending_amount` INT NULL,
  `status` VARCHAR(45) NULL,
   FOREIGN KEY (admission_id) REFERENCES patient_admissions(admission_id),
  PRIMARY KEY (`id`));
  
  CREATE TABLE `treatment` (
  `treatment_id` int NOT NULL AUTO_INCREMENT,
  `medicine_type` varchar(45) DEFAULT NULL,
  `medicine` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `treatment_date` date DEFAULT NULL,
  `payment` varchar(45) DEFAULT NULL,
  `admission` int DEFAULT NULL,
  PRIMARY KEY (`treatment_id`),
  KEY `Treatment_byky_1_idx` (`admission`),
  CONSTRAINT `Treatment_byky_1` FOREIGN KEY (`admission`) REFERENCES `patient_admissions` (`admission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

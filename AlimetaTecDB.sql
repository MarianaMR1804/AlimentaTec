/*
username = alimentador
password = 6X6[Q&W6pKsw
*/
CREATE DATABASE IF NOT EXISTS AlimetaTecDB;

-- Usar la base de datos
USE AlimetaTecDB;

-- Eliminar tablas si existen (en orden inverso debido a las relaciones foráneas)
DROP TABLE IF EXISTS Journal;
DROP TABLE IF EXISTS UserPatient;
DROP TABLE IF EXISTS Nutritionist;
DROP TABLE IF EXISTS PhysicalActivity;
DROP TABLE IF EXISTS Saucer;
DROP TABLE IF EXISTS Goal;
DROP TABLE IF EXISTS Login;

/*Creating a Login table*/
CREATE TABLE Login (
    idUser INT auto_increment NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    passwordUser VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PRIMARY KEY idUser_PK (idUser)
	);
/*Inserting data into the Login table*/
INSERT INTO Login (username, passwordUser, email) VALUES
    ('juan_perez', 'contraseña123', 'juan.perez@email.com'),
    ('maria_garcia', 'clave456', 'maria.garcia@email.com'),
    ('carlos_rodriguez', 'pass789', 'carlos.rodriguez@email.com'),
    ('ana_martinez', 'secreto2024', 'ana.martinez@email.com'),
    ('pedro_sanchez', 'clave2024', 'pedro.sanchez@email.com'),
    ('laura_lopez', 'mipass123', 'laura.lopez@email.com'),
    ('miguel_torres', 'segura456', 'miguel.torres@email.com'),
    ('sofia_ramirez', 'acceso789', 'sofia.ramirez@email.com'),
    ('diego_morales', 'usuario2024', 'diego.morales@email.com'),
    ('carmen_ruiz', 'miclave555', 'carmen.ruiz@email.com');
    
/*Creating a Nutritionist table*/
    CREATE TABLE Nutritionist(
	idNutritionist int auto_increment,
	nutritionistName VARCHAR (15) NOT NULL,
	paternalSurnameN VARCHAR (20) NOT NULL,
	maternalSurnameN VARCHAR (20) NOT NULL,
	ageN INT NOT NULL,
    genderN VARCHAR (20) NOT NULL,
    nutritionistRegistration VARCHAR (100) NOT NULL,
    idUser INT,
    CONSTRAINT PRIMARY KEY idNutritionist_PK (idNutritionist), 
    constraint idUser_N_FK foreign key (idUser) references Login (idUser)
    );
/*Inserting data into the Nutritionist table*/
INSERT INTO Nutritionist (nutritionistName, paternalSurnameN, maternalSurnameN, ageN, genderN, nutritionistRegistration,idUser) VALUES
    ('Ana', 'Martínez', 'García', 32, 'Femenino','NUT-2024-001', 1),
    ('Carlos', 'Rodríguez', 'López', 45, 'Masculino', 'NUT-2024-002', 2),
    ('María', 'Sánchez', 'Torres', 29, 'Femenino', 'NUT-2024-003', 3),
    ('José', 'Hernández', 'Ruiz', 38, 'Masculino', 'NUT-2024-004', 4),
    ('Laura', 'González', 'Flores', 35, 'Femenino', 'NUT-2024-005', 5),
    ('Miguel', 'Pérez', 'Castro', 41, 'Masculino', 'NUT-2024-006', 6),
    ('Sofia', 'Ramírez', 'Morales', 33, 'Femenino', 'NUT-2024-007', 7),
    ('Daniel', 'Torres', 'Vargas', 37, 'Masculino', 'NUT-2024-008', 8),
    ('Carmen', 'López', 'Mendoza', 31, 'Femenino', 'NUT-2024-009', 9),
    ('Roberto', 'Morales', 'Silva', 43, 'Masculino', 'NUT-2024-010', 10);
    
/*Creating a Patient table*/
    CREATE TABLE UserPatient(
	userPatientId int auto_increment,
    UserName VARCHAR (15) NOT NULL,
	paternalSurname VARCHAR (20) NOT NULL,
	maternalSurname VARCHAR (20) NOT NULL,
	age INT NOT NULL,
	gender VARCHAR (20) NOT NULL,
	height FLOAT NOT NULL,
	weight float (50) NOT NULL,
	suffering VARCHAR (50) NOT NULL,
    idUser INT,
	CONSTRAINT PRIMARY KEY userPatientId_PK (userPatientId),
    constraint idUser_UP_FK foreign key (idUser) references Login (idUser)
	);
/*Inserting data into the Patient table*/
INSERT INTO UserPatient (UserName, paternalSurname, maternalSurname, age, gender, height, weight, suffering,idUser) VALUES
    ('Luis', 'Mendoza', 'Vega', 28, 'Masculino', 1.75, 80.5, 'Diabetes tipo 2', 1),
    ('Patricia', 'Jiménez', 'Ortiz', 35, 'Femenino', 1.65, 65.3, 'Hipertensión', 2),
    ('Ricardo', 'Vargas', 'Luna', 42, 'Masculino', 1.78, 90.2, 'Colesterol alto', 3),
    ('Isabel', 'Castro', 'Rojas', 31, 'Femenino', 1.62, 58.7, 'Intolerancia lactosa', 4),
    ('Fernando', 'Díaz', 'Soto', 45, 'Masculino', 1.82, 88.4, 'Gastritis crónica', 5),
    ('Mariana', 'Torres', 'Pinto', 29, 'Femenino', 1.68, 72.1, 'Celiaquía', 6),
    ('Gabriel', 'Ruiz', 'Mora', 38, 'Masculino', 1.71, 75.8, 'Presión alta', 7),
    ('Valentina', 'López', 'Cruz', 33, 'Femenino', 1.70, 63.5, 'Anemia', 8),
    ('Andrés', 'Morales', 'Ríos', 40, 'Masculino', 1.76, 82.3, 'Reflujo gástrico', 9),
    ('Carolina', 'Flores', 'Silva', 36, 'Femenino', 1.63, 67.9, 'Hipotiroidismo', 10);
/*Creating a Goals table*/
CREATE TABLE Goal (
    idGoal INT auto_increment,
    nameGoal VARCHAR(255),
    descriptionGoal VARCHAR(255),
    startGoal BOOLEAN,
    endGoal BOOLEAN,
    statusGoal VARCHAR(255),
    CONSTRAINT PRIMARY KEY idGoal_PK(idGoal)
	);
/*Creating a Goal table*/
INSERT INTO Goal (nameGoal, descriptionGoal, startGoal, endGoal, statusGoal) VALUES
    ('Weight Loss', 'Lose 20 pounds in 4 months through diet and exercise', true, false, 'In Progress'),
    ('Muscle Gain', 'Gain 10 pounds of lean muscle mass in 6 months', true, false, 'In Progress'),
    ('Better Hydration', 'Drink 2 liters of water daily for 30 days', true, true, 'Completed'),
    ('Cholesterol Reduction', 'Lower LDL cholesterol by 20% in 3 months', true, false, 'In Progress'),
    ('Sugar Control', 'Maintain blood sugar levels within normal range for 6 months', true, false, 'In Progress'),
    ('Healthy Eating', 'Follow Mediterranean diet plan for 2 months', true, true, 'Completed'),
    ('Protein Intake', 'Increase daily protein intake to 100g for muscle recovery', false, false, 'Not Started'),
    ('Meal Planning', 'Prepare weekly meal plans for 3 months', true, false, 'In Progress'),
    ('Food Journal', 'Keep detailed food diary for 60 days', true, false, 'On Hold'),
    ('Balanced Diet', 'Achieve balanced macronutrient ratio in daily meals', true, true, 'Completed');
    
/*Creating a saucer table*/
CREATE TABLE Saucer (
    idSaucer INT AUTO_INCREMENT,
    nameSaucer VARCHAR(255),
    category VARCHAR(255),
    preparation VARCHAR(255),
    CONSTRAINT PRIMARY KEY idSaucer_PK (idSaucer)
	);
/*Inserting data into the Saucer table*/
INSERT INTO Saucer (nameSaucer, category, preparation) VALUES
    ('Mediterranean Salad', 'Salads', 'Mix lettuce, tomato, cucumber, olives, feta cheese and dress with olive oil'),
    ('Grilled Chicken', 'Meat', 'Marinate chicken with spices and grill for 15 minutes'),
    ('Baked Salmon', 'Fish', 'Bake salmon with lemon and herbs at 180°C for 20 minutes'),
    ('Quinoa with Vegetables', 'Vegetarian', 'Cook quinoa and stir-fry with mixed vegetables and spices'),
    ('Vegetable Soup', 'Soups', 'Cook mixed vegetables in low-sodium broth for 30 minutes'),
    ('Roasted Turkey Breast', 'Meat', 'Roast marinated breast with herbs for 25 minutes'),
    ('Tuna Bowl', 'Fish', 'Combine fresh tuna with brown rice, avocado and vegetables'),
    ('Whole Wheat Pasta', 'Carbohydrates', 'Cook whole wheat pasta and mix with homemade tomato sauce'),
    ('Vegetable Wrap', 'Vegetarian', 'Fill whole wheat tortilla with hummus and fresh vegetables'),
    ('Egg White Omelette', 'Breakfast', 'Beat egg whites with spinach and cook in non-stick pan');

/*Creating a Activity table*/
create table PhysicalActivity(
	idActivity INT AUTO_INCREMENT,
    nameActivity VARCHAR(100) NOT NULL,
    duration time not null,
    caloriesBurned  int ,
    intensity ENUM('low', 'medium', 'high'),
    primary key idActivity_AF_PK (idActivity)
	);
/*Inserting data into the PhysicalActivity table*/
INSERT INTO PhysicalActivity (nameActivity, duration, caloriesBurned, intensity) VALUES
    ('Running', '00:45:00', 450, 'high'),
    ('Swimming', '01:00:00', 400, 'medium'),
    ('Yoga', '00:30:00', 150, 'low'),
    ('Cycling', '01:15:00', 600, 'high'),
    ('Walking', '00:45:00', 200, 'low'),
    ('Weight Training', '01:00:00', 350, 'medium'),
    ('HIIT Workout', '00:30:00', 400, 'high'),
    ('Pilates', '00:45:00', 250, 'medium'),
    ('Jump Rope', '00:20:00', 250, 'high'),
    ('Stretching', '00:15:00', 100, 'low');

CREATE TABLE Journal(
	idJournal INT not null AUTO_INCREMENT,
    idSaucer int not null,
	idActivity int not null,
	idGoal int not null, 
	idUser int not null,
    constraint idJournal_PK primary key(idJournal),
    constraint idSaucer_J_FK foreign key (idSaucer) references Saucer(idSaucer),
    constraint idActivity_J_FK foreign key (idActivity) references PhysicalActivity(idActivity),
    constraint idGoal_J_FK foreign key (idGoal) references Goal(idGoal),
    constraint idUser_J_FK foreign key (idUser) references Login(idUser)
);

/*Inserting data into the Journal table*/
INSERT INTO Journal (idSaucer,idActivity,idGoal,idUser) VALUES
    (1, 1, 1, 1),    -- Mediterranean Salad + Running + Goal 1 + User 1
    (2, 3, 2, 2),    -- Grilled Chicken + Yoga + Goal 2 + User 2
    (3, 2, 3, 3),    -- Baked Salmon + Swimming + Goal 3 + User 3
    (4, 4, 1, 4),    -- Quinoa with Vegetables + Cycling + Goal 1 + User 4
    (5, 5, 4, 5),    -- Vegetable Soup + Walking + Goal 4 + User 5
    (6, 6, 5, 6),    -- Roasted Turkey Breast + Weight Training + Goal 5 + User 6
    (7, 7, 6, 7),    -- Tuna Bowl + HIIT Workout + Goal 6 + User 7
    (8, 8, 7, 8),    -- Whole Wheat Pasta + Pilates + Goal 7 + User 8
    (9, 9, 8, 9),    -- Vegetable Wrap + Jump Rope + Goal 8 + User 9
    (10, 10, 9, 10); -- Egg White Omelette + Stretching + Goal 9 + User 10


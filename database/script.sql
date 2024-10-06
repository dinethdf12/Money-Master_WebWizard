REATE DATABASE studentdb;
USE studentdb;
drop table Student;
CREATE TABLE Student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
drop table Grades;
CREATE TABLE Grades (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    subject VARCHAR(255),
    grade VARCHAR(5),
    student_id BIGINT NOT NULL,
    CONSTRAINT FK_Student_Grades FOREIGN KEY (student_id) REFERENCES Student(id)
);

INSERT INTO Student (first_name, last_name, email)
VALUES
('John', 'Doe', 'john.doe@example.com'),
('Jane', 'Smith', 'jane.smith@example.com'),
('Alice', 'Johnson', 'alice.johnson@example.com');


INSERT INTO Grades (subject, grade, student_id)
VALUES
('Math', 'A', 1),  -- John Doe
('Science', 'B+', 1),  -- John Doe
('Math', 'B', 2),  -- Jane Smith
('English', 'A-', 2),  -- Jane Smith
('Math', 'A+', 3);  -- Alice Johnson
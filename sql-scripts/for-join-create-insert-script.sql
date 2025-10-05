CREATE TABLE project (
    id SERIAL PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL
);

CREATE TABLE department (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES department(id)
);

-- Join table for Many-to-Many relationship between Employee and Project
CREATE TABLE person_project (
    person_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    PRIMARY KEY (person_id, project_id),
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);

-- Sample Insert Script

-- Projects
INSERT INTO project (project_name) VALUES ('Apollo');
INSERT INTO project (project_name) VALUES ('Zeus');
INSERT INTO project (project_name) VALUES ('Hermes');
INSERT INTO project (project_name) VALUES ('Tombola');
INSERT INTO project (project_name) VALUES ('Tandana');
INSERT INTO project (project_name) VALUES ('Air Lift');

-- Departments
INSERT INTO department (name) VALUES ('IT');
INSERT INTO department (name) VALUES ('HR');
INSERT INTO department (name) VALUES ('FINANCE');
INSERT INTO department (name) VALUES ('HEALTH');
INSERT INTO department (name) VALUES ('LEGAL');


-- Employees
INSERT INTO person (name, department_id) VALUES ('Alice', 1);
INSERT INTO person (name, department_id) VALUES ('Bob', 1);
INSERT INTO person (name, department_id) VALUES ('Charlie', 2);
INSERT INTO person (name, department_id) VALUES ('Samir', 3);
INSERT INTO person (name, department_id) VALUES ('Satyabrata', 3);
INSERT INTO person (name, department_id) VALUES ('Saket', 4);
INSERT INTO person (name, department_id) VALUES ('Abhinab', 4);
INSERT INTO person (name, department_id) VALUES ('Rumpa', 4);
INSERT INTO person (name, department_id) VALUES ('Niharika', 5);
INSERT INTO person (name, department_id) VALUES ('Jihn', 1);

INSERT INTO person (name, department_id) VALUES ('Vidya Balan', 1);


-- person_project
INSERT INTO person_project (person_id, project_id) VALUES (1, 2);
INSERT INTO person_project (person_id, project_id) VALUES (2, 3);
INSERT INTO person_project (person_id, project_id) VALUES (7, 2);
INSERT INTO person_project (person_id, project_id) VALUES (3, 4);

INSERT INTO person_project (person_id, project_id) VALUES (7, 1);
INSERT INTO person_project (person_id, project_id) VALUES (5, 1);

INSERT INTO person_project (person_id, project_id) VALUES (10, 1);
INSERT INTO person_project (person_id, project_id) VALUES (11, 1);

-------------
-- person_projects
INSERT INTO person_projects (persons_id, projects_id) VALUES (1, 2);
INSERT INTO person_projects (persons_id, projects_id) VALUES (2, 3);
INSERT INTO person_projects (persons_id, projects_id) VALUES (7, 2);
INSERT INTO person_projects (persons_id, projects_id) VALUES (3, 4);

INSERT INTO person_projects (persons_id, projects_id) VALUES (7, 1);
INSERT INTO person_projects (persons_id, projects_id) VALUES (5, 1);

INSERT INTO person_projects (persons_id, projects_id) VALUES (10, 1);
INSERT INTO person_projects (persons_id, projects_id) VALUES (11, 1);
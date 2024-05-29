-- Skills
CREATE TABLE skills
(
    id                 serial PRIMARY KEY,
    name               varchar(255),
    category           varchar(255),
    level               int
);
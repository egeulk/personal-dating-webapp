CREATE TYPE pronouns AS ENUM ('he/him', 'she/her', 'other');
CREATE TYPE genders AS ENUM ('women', 'men', 'non-binary');

CREATE TABLE  users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    --location POINT,
    user_pronoun pronouns,
    user_gender genders
);

CREATE TABLE  tags (
    id SERIAL PRIMARY KEY,
    tag_name VARCHAR(60)
);

CREATE TABLE  users_tags(
    user_id INT REFERENCES users (id) ON UPDATE CASCADE,
    tag_id INT REFERENCES tags (id) ON UPDATE CASCADE,
    PRIMARY KEY (user_id, tag_id)
);

CREATE TABLE  questions (
    id SERIAL PRIMARY KEY,
    question_content VARCHAR(50)
);

CREATE TABLE answers (
    question_id INT REFERENCES questions (id),
    answer_id INT,
    answer_content VARCHAR(50),
    PRIMARY KEY (question_id, answer_id)
);

CREATE TABLE  answered_questions (
    question_id INT REFERENCES questions (id) ON UPDATE CASCADE ON DELETE CASCADE,
    user_id INT REFERENCES users (id) ON UPDATE CASCADE,
    answer_id INT,
    PRIMARY KEY (question_id, user_id)
);

CREATE TABLE  personal_images (
    image varchar(64),
    user_id INT REFERENCES users (id) ON UPDATE CASCADE,
    PRIMARY KEY (question_id, image)
);
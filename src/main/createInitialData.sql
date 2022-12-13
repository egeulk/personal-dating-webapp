INSERT INTO tags(id, tag_name)
VALUES (0, 'guitar Playing');

INSERT INTO tags(id, tag_name)
VALUES (1, 'camping');

INSERT INTO tags(id, tag_name)
VALUES (2,'dancing');

INSERT INTO users(id, name, surname, user_pronoun, user_gender)
VALUES (0, 'ilkIsim', 'Surname', 0, 0);


INSERT INTO users_tags(user_id, tag_id)
VALUES (0, 1);

INSERT INTO questions(id, question_content)
VALUES (0, 'Do you prefer mayo or ketchup');


INSERT INTO answers(question_id, answer_id, answer_content)
VALUES (0, 0, 'mayo');

INSERT INTO answers(question_id, answer_id, answer_content)
VALUES (0, 1, 'ketchup');

INSERT INTO answered_questions(id, question_id, user_id, answer_id, importance)
VALUES (0, 0, 0, 1,3);

INSERT INTO users_login(user_id, user_email, user_password) VALUES (0, 'testing@test.com', '{bcrypt}$2a$12$0tS/hSgTzzDePo8jn4dxsudF..BtiQagebtXmdAM6ppoyc1DOQFky');
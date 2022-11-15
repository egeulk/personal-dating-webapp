INSERT INTO tags(id, tag_name)
VALUES (0, 'guitar Playing');

INSERT INTO tags(id, tag_name)
VALUES (1, 'camping');

INSERT INTO tags(id, tag_name)
VALUES (2,'dancing');

INSERT INTO users(id, name, surname, user_pronoun, user_gender)
VALUES (0, 'ilkIsim', 'Surname', 'he/him', 'men');


INSERT INTO users_tags(user_id, tag_id)
VALUES (0, 1);

INSERT INTO questions(id, question_content)
VALUES (0, 'Do you prefer mayo or ketchup');


INSERT INTO answers(question_id, answer_id, answer_content)
VALUES (0, 0, 'mayo');

INSERT INTO answers(question_id, answer_id, answer_content)
VALUES (0, 1, 'ketchup');

INSERT INTO answered_questions(id, question_id, user_id, answer_id)
VALUES (0, 0, 0, 1);
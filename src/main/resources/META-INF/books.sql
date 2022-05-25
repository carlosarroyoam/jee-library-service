INSERT INTO authors(id, name) VALUES (1, 'Douglas Adams');
INSERT INTO authors(id, name) VALUES (2, 'Sebastian Daschner');
INSERT INTO authors(id, name) VALUES (3, 'David R. Heffelfinger');
INSERT INTO authors(id, name) VALUES (4, 'Kapila Bogahapitiya');

INSERT INTO books(isbn, title, author_id) VALUES ('0345391802', 'The Hitchhiker''s Guide to the Galaxy', 1)
INSERT INTO books(isbn, title, author_id) VALUES ('1788393856', 'Architecting Modern Java EE Applications', 2)
INSERT INTO books(isbn, title, author_id) VALUES ('1788293673', 'Java EE 8 Application Development', 3)
INSERT INTO books(isbn, title, author_id) VALUES ('1786469200', 'Mastering Java EE 8 Application Development', 4)

INSERT INTO loans(id, username, book_id) VALUES ('31d8dbdc-82c0-4c19-ab9b-b830b87472c4', 'mario-leander.reimer@qaware.de', '0345391802')
INSERT INTO loans(id, username, book_id) VALUES ('b35bb799-19a3-4246-8f8c-44e1b07a5eeb', 'mario-leander.reimer@qaware.de', '1788393856')
INSERT INTO loans(id, username, book_id) VALUES ('897a894a-7a61-47ea-ba31-0889d13a67be', 'mario-leander.reimer@qaware.de', '1788293673')
INSERT INTO loans(id, username, book_id) VALUES ('44adb4ec-3263-4477-b182-d3107019d3d9', 'mario-leander.reimer@qaware.de', '1786469200')
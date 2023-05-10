CREATE TABLE post (
    post_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title VARCHAR(255),
    content VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE comments (
    comment_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    body VARCHAR(255),
    post_id INTEGER,
    FOREIGN KEY (post_id) REFERENCES post(post_id)
);

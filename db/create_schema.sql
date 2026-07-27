-- We are using PostgreSQL for this schema creation script
-- CSV header is below, so we can use it to create the table structure
-- bookId,title,author,rating,description,language,isbn,bookFormat,edition,pages,publisher,publishDate,firstPublishDate,likedPercent,price


-- Create the books table
CREATE TABLE books (
    book_Id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    rating DECIMAL(3,2),
    description TEXT,
    language VARCHAR(100),
    isbn VARCHAR(20),
    book_format VARCHAR(100),
    edition VARCHAR(100),
    pages INTEGER,
    publisher VARCHAR(255),
    publish_date DATE,
    first_publish_date DATE,
    liked_percent DECIMAL(5,2),
    price DECIMAL(10,2)
);

-- Create the authors table
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);



-- Create the book_authors table to handle many-to-many relationship between books and authors
CREATE TABLE book_authors (
    book_id INT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);

# Library System CRC Cards

## Part 1: Identify Classes

### 1. Book
**Explanation:** The Book class is needed to represent individual books in the library's collection. It serves as the fundamental entity that members borrow and return, and that librarians manage.

### 2. Member
**Explanation:** The Member class is necessary to represent library users who borrow books. This class tracks individual borrowing limits and currently borrowed books.

### 3. Librarian
**Explanation:** The Librarian class is needed to represent staff who manage the library collection. They have special privileges to add, remove, and monitor books in the system.

### 4. Library
**Explanation:** The Library class is needed as a central management system that coordinates books, members, and librarians. It maintains the overall collection and facilitates interactions between the other classes.

## Part 2: Define Responsibilities

### Book
1. Store book information (title, author, ISBN, availability status)
2. Update its availability status when borrowed or returned

### Member
1. Borrow books (up to 3) from the library
2. Return books to the library

### Librarian
1. Add new books to the library collection
2. Remove outdated or lost books from the collection
3. View lists of available books and checked-out books

### Library
1. Maintain the complete collection of books
2. Track which books are checked out and by whom

## Part 3: Identify Collaborators

### Book
- **Library:** Collaborates with the Library class because books are part of the library's collection and the Library needs to know each book's status.
- **Member:** Collaborates with Member class because Members borrow books, changing their availability status.

### Member
- **Book:** Collaborates with Book class to borrow and return specific book instances.
- **Library:** Collaborates with Library class to access the collection of available books and to record borrowing activity.

### Librarian
- **Book:** Collaborates with Book class to add new books and remove existing ones.
- **Library:** Collaborates with Library class to view and manage the entire collection.
- **Member:** Collaborates with Member class to see which members have borrowed which books.

### Library
- **Book:** Collaborates with Book class to maintain the collection of all books.
- **Member:** Collaborates with Member class to track borrowing activities and enforce borrowing limits.
- **Librarian:** Collaborates with Librarian class to provide management functions and reports.

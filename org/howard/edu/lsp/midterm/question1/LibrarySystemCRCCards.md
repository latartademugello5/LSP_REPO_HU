# Library System CRC Cards

## Part 1: Identify Classes

### 1. Book
**Explanation:** Represents individual books in the library’s collection. This class holds details about each book and tracks its availability.

### 2. Member
**Explanation:** Represents library users who can borrow books. Tracks how many books a member has checked out and enforces the borrowing limit.

### 3. Librarian
**Explanation:** Represents staff responsible for managing the book collection. Librarians can add and remove books and monitor borrowed books.

### 4. Library
**Explanation:** Acts as the central system that manages books, members, and librarians. It keeps track of the collection and borrowing activities.

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
2. Track borrowing records and enforce borrowing limits.

## Part 3: Identify Collaborators

### Book
- **Library:**The Library manages books, so it must track their status.

### Member
- **Library:** Members interact with the Library to borrow and return books.

### Librarian
- **Library:**  Librarians manage books through the Library system.

### Library
- **Book:** Collaborates with Book class to maintain the collection of all books.
- **Member:** Collaborates with Member class to track borrowing activities and enforce borrowing limits.
- **Librarian:** Collaborates with Librarian class to provide management functions and reports.

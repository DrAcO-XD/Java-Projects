import java.util.Scanner;

    class Library {
        static String[] books = new String[50];
        static String[] authors = new String[50];
        static int[] bookCounts = new int[50];
        static int totalBooks = 0;
    
        static {
            books[0] = "Java Programming";
            authors[0] = "James Gosling";
            bookCounts[0] = 5;
            books[1] = "Data Structures";
            authors[1] = "Cormen";
            bookCounts[1] = 3;
            books[2] = "Algorithms";
            authors[2] = "Knuth";
            bookCounts[2] = 4;
            books[3] = "Operating Systems";
            authors[3] = "Silberschatz";
            bookCounts[3] = 2;
            books[4] = "Database Systems";
            authors[4] = "Elmasri";
            bookCounts[4] = 3;
            books[5] = "Networking";
            authors[5] = "Tanenbaum";
            bookCounts[5] = 2;
            books[6] = "Artificial Intelligence";
            authors[6] = "Russell";
            bookCounts[6] = 3;
            books[7] = "Machine Learning";
            authors[7] = "Goodfellow";
            bookCounts[7] = 4;
            books[8] = "Cloud Computing";
            authors[8] = "Buyya";
            bookCounts[8] = 3;
            books[9] = "Cyber Security";
            authors[9] = "Stallings";
            bookCounts[9] = 2;
            books[10] = "Web Development";
            authors[10] = "Flanagan";
            bookCounts[10] = 3;
            books[11] = "Mobile App Development";
            authors[11] = "Meier";
            bookCounts[11] = 2;
            books[12] = "Game Development";
            authors[12] = "Gregory";
            bookCounts[12] = 3;
            books[13] = "Python Programming";
            authors[13] = "Lutz";
            bookCounts[13] = 4;
            books[14] = "C++ Programming";
            authors[14] = "Stroustrup";
            bookCounts[14] = 3;
            books[15] = "JavaScript";
            authors[15] = "Zakas";
            bookCounts[15] = 2;
            books[16] = "HTML & CSS";
            authors[16] = "Duckett";
            bookCounts[16] = 3;
            books[17] = "ReactJS";
            authors[17] = "Freeman";
            bookCounts[17] = 2;
            books[18] = "NodeJS";
            authors[18] = "Cantelon";
            bookCounts[18] = 3;
            books[19] = "Blockchain";
            authors[19] = "Narayanan";
            bookCounts[19] = 2;
            totalBooks = 20;
        }
    
        void printBookRecords() {
            System.out.println("Library Book Records:");
            for (int i = 0; i < totalBooks; i++) {
                System.out.println((i + 1) + ". " + books[i] + " by " + authors[i] + " - Available: " + bookCounts[i]);
            }
        }
    
        void addBook(String bookName, String author, int count) {
            books[totalBooks] = bookName;
            authors[totalBooks] = author;
            bookCounts[totalBooks] = count;
            totalBooks++;
            System.out.println(bookName + " added successfully.");
        }
    
        void removeBook(String bookName) {
            boolean found = false;
            for (int i = 0; i < totalBooks; i++) {
                if (books[i].equalsIgnoreCase(bookName)) {
                    for (int j = i; j < totalBooks - 1; j++) {
                        books[j] = books[j + 1];
                        authors[j] = authors[j + 1];
                        bookCounts[j] = bookCounts[j + 1];
                    }
                    totalBooks--;
                    found = true;
                    System.out.println(bookName + " removed successfully.");
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found in the library.");
            }
        }
    
        void searchBook(String keyword) {
            boolean found = false;
            System.out.println("Search Results:");
            for (int i = 0; i < totalBooks; i++) {
                if (books[i].toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(books[i] + " by " + authors[i] + " - Available: " + bookCounts[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No matching books found.");
            }
        }
    
        void listBooksByCategory(String category) {
            boolean found = false;
            System.out.println("Books in Category: " + category);
            for (int i = 0; i < totalBooks; i++) {
                if (books[i].toLowerCase().contains(category.toLowerCase())) {
                    System.out.println(books[i] + " by " + authors[i] + " - Available: " + bookCounts[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found in this category.");
            }
        }
    
        void displayMostPopularBook() {
            int maxCount = 0;
            String popularBook = "";
            for (int i = 0; i < totalBooks; i++) {
                if (bookCounts[i] > maxCount) {
                    maxCount = bookCounts[i];
                    popularBook = books[i];
                }
            }
            if (!popularBook.isEmpty()) {
                System.out.println("Most Popular Book: " + popularBook + " - Available: " + maxCount);
            } else {
                System.out.println("No books available.");
            }
        }
    
        void updateBookDetails(String bookName, String newAuthor, int newCount) {
            boolean found = false;
            for (int i = 0; i < totalBooks; i++) {
                if (books[i].equalsIgnoreCase(bookName)) {
                    authors[i] = newAuthor;
                    bookCounts[i] = newCount;
                    found = true;
                    System.out.println("Updated details for " + bookName + ": Author = " + newAuthor + ", Count = " + newCount);
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found in the library.");
            }
        }
    
        void displayBookAvailability(String bookName) {
            boolean found = false;
            for (int i = 0; i < totalBooks; i++) {
                if (books[i].equalsIgnoreCase(bookName)) {
                    System.out.println("Book: " + books[i] + " - Available: " + bookCounts[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found in the library.");
            }
        }
    
        void recommendBooksByPopularity(int topN) {
            System.out.println("Top " + topN + " Most Popular Books:");
            for (int i = 0; i < Math.min(topN, totalBooks); i++) {
                System.out.println((i + 1) + ". " + books[i] + " by " + authors[i] + " - Available: " + bookCounts[i]);
            }
        }
    
        void recommendBooksByCategory(String category, int topN) {
            System.out.println("Top " + topN + " Recommended Books in Category: " + category);
            int count = 0;
            for (int i = 0; i < totalBooks && count < topN; i++) {
                if (books[i].toLowerCase().contains(category.toLowerCase())) {
                    System.out.println((count + 1) + ". " + books[i] + " by " + authors[i] + " - Available: " + bookCounts[i]);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No books found in this category.");
            }
        }
    }
    
    class Registrar {
        String name;
        String type;
    
        Registrar(String name, String type) {
            this.name = name;
            this.type = type;
        }
    
        void displayInfo() {
            System.out.println("Name: " + name);
            System.out.println("Type: " + type);
        }
    }
    
    class Student extends Registrar {
        String[] borrowedBooks = new String[20];
        String[] borrowedAuthors = new String[20];
        int[] borrowedDays = new int[20];
        double[] borrowedCharges = new double[20];
        int borrowedCount = 0;
    
        Student(String name) {
            super(name, "Student");
        }
    
        void borrowBook(String bookName, String author, int days, Library lib) {
            boolean found = false;
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.books[i].equalsIgnoreCase(bookName) && lib.bookCounts[i] > 0) {
                    borrowedBooks[borrowedCount] = bookName;
                    borrowedAuthors[borrowedCount] = author;
                    borrowedDays[borrowedCount] = days;
                    borrowedCharges[borrowedCount] = calculateCharge(days);
                    borrowedCount++;
                    lib.bookCounts[i]--;
                    found = true;
                    System.out.println(bookName + " borrowed successfully for " + days + " days at $" + borrowedCharges[borrowedCount - 1]);
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not available for borrowing.");
            }
        }   
        void returnBook(String bookName, Library lib) {
            Scanner sc = new Scanner(System.in);
            boolean found = false;
            for (int i = 0; i < borrowedCount; i++) {
                if (borrowedBooks[i].equalsIgnoreCase(bookName)) {
                    for (int j = i; j < borrowedCount - 1; j++) {
                        borrowedBooks[j] = borrowedBooks[j + 1];
                        borrowedAuthors[j] = borrowedAuthors[j + 1];
                        borrowedDays[j] = borrowedDays[j + 1];
                        borrowedCharges[j] = borrowedCharges[j + 1];
                    }
                    borrowedCount--;
                    for (int k = 0; k < lib.totalBooks; k++) {
                        if (lib.books[k].equalsIgnoreCase(bookName)) {
                            lib.bookCounts[k]++;
                            break;
                        }
                    }
                    found = true;
                    System.out.println(bookName + " returned successfully.");
                    System.out.print("Enter the number of days the book was borrowed: ");
                    int days = sc.nextInt();
                    sc.nextLine();
                    checkPenalty(i);
                    break;
                }
            }

            if (!found) {
                System.out.println("You have not borrowed this book.");
            }
        }
    
        void checkPenalty(int index) {
            if (borrowedDays[index] > 7) {
                double penalty = (borrowedDays[index] - 7) * 5;
                System.out.println("Penalty for late return: $" + penalty);
            } else {
                System.out.println("No penalty for this book.");
            }
        }
    
        void printUserData() {
            System.out.println("User Data:");
            System.out.println("Name: " + name);
            System.out.println("Type: " + type);
            System.out.println("Borrowed Books:");
            if (borrowedCount == 0) {
                System.out.println("No books borrowed.");
            } else {
                for (int i = 0; i < borrowedCount; i++) {
                    System.out.println((i + 1) + ". " + borrowedBooks[i] + " by " + borrowedAuthors[i] +
                            " - Duration: " + borrowedDays[i] + " days - Charge: Rs" + borrowedCharges[i]+"/-");
                    checkPenalty(i);
                }
            }
        }
    
        double calculateCharge(int days) {
            if (days <= 1) return 10;
            else if (days <= 7) return 50;
            else return 100;
        }
    
        void recommendBooks(Library lib) {
            System.out.println("Recommended Books:");
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                }
            }
        }
    
        void recommendBooksByCategory(Library lib, String category) {
            System.out.println("Recommended Books in Category: " + category);
            boolean found = false;
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.books[i].toLowerCase().contains(category.toLowerCase()) && lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found in this category.");
            }
        }
    }
    
    class Faculty extends Registrar {
        Faculty(String name) {
            super(name, "Faculty");
        }
    
        void manageMembership(Library lib) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Manage Membership:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
    
            if (choice == 1) {
                System.out.print("Enter student name to add: ");
                String studentName = sc.nextLine();
                // Logic to add student
                System.out.println(studentName + " has been added.");
            } else if (choice == 2) {
                System.out.print("Enter student name to remove: ");
                String studentName = sc.nextLine();
                // Logic to remove student 
                System.out.println(studentName + " has been removed.");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    
        void printStudentData(Student student) {
            student.printUserData();
        }
    
        void recommendBooks(Library lib) {
            System.out.println("Recommended Books for Faculty:");
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                }
            }
        }
    
        void recommendBooksByCategory(Library lib, String category) {
            System.out.println("Recommended Books for Faculty in Category: " + category);
            boolean found = false;
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.books[i].toLowerCase().contains(category.toLowerCase()) && lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found in this category.");
            }
        }
    }
    
    class Admin extends Registrar {
        Admin(String name) {
            super(name, "Admin");
        }
    
        void addBook(Library lib, String bookName, String author, int count) {
            lib.addBook(bookName, author, count);
        }
    
        void removeBook(Library lib, String bookName) {
            lib.removeBook(bookName);
        }
    
        void updateBookDetails(Library lib, String bookName, String newAuthor, int newCount) {
            lib.updateBookDetails(bookName, newAuthor, newCount);
        }
    
        void displayBookAvailability(Library lib, String bookName) {
            lib.displayBookAvailability(bookName);
        }
    
        void recommendBooks(Library lib) {
            System.out.println("Recommended Books for Admin:");
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                }
            }
        }
    
          void recommendBooksByCategory(Library lib, String category) {
            System.out.println("Recommended Books for Admin in Category: " + category);
            boolean found = false;
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.books[i].toLowerCase().contains(category.toLowerCase()) && lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found in this category.");
            }
        }
    }
    
    class Librarian extends Registrar {
          Librarian(String name) {
            super(name, "Librarian");
        }
    
          void searchBook(Library lib, String keyword) {
            lib.searchBook(keyword);
        }
    
          void recommendBooks(Library lib) {
            System.out.println("Recommended Books for Librarian:");
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                }
            }
        }
    
          void recommendBooksByCategory(Library lib, String category) {
            System.out.println("Recommended Books for Librarian in Category: " + category);
            boolean found = false;
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.books[i].toLowerCase().contains(category.toLowerCase()) && lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found in this category.");
            }
        }
    }
    
    class Guest extends Registrar {
          Guest(String name) {
            super(name, "Guest");
        }
    
          void viewBooks(Library lib) {
            lib.printBookRecords();
        }
    
          void recommendBooks(Library lib) {
            System.out.println("Recommended Books for Guest:");
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                }
            }
        }
    
          void recommendBooksByCategory(Library lib, String category) {
            System.out.println("Recommended Books for Guest in Category: " + category);
            boolean found = false;
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.books[i].toLowerCase().contains(category.toLowerCase()) && lib.bookCounts[i] > 0) {
                    System.out.println(lib.books[i] + " by " + lib.authors[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found in this category.");
            }
        }
    }
    
      class LibraryManagementSystem {
          static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Library library = new Library();
            Student[] students = new Student[100];
            Faculty[] faculties = new Faculty[100];
            Admin[] admins = new Admin[100];
            Librarian[] librarians = new Librarian[100];
            Guest[] guests = new Guest[100];
            int totalStudents = 0, totalFaculties = 0, totalAdmins = 0, totalLibrarians = 0, totalGuests = 0;
    
            while (true) {
                System.out.println("\nWelcome to the Library Management System");
                System.out.println("1. Register as a new user");
                System.out.println("2. Login as an existing user");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
    
                if (choice == 1) {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Are you a Student, Faculty, Admin, Librarian, or Guest? (S/F/A/L/G): ");
                    String userType = sc.nextLine();
                    if (userType.equalsIgnoreCase("S")) {
                        students[totalStudents] = new Student(name);
                        totalStudents++;
                        System.out.println("Registration successful!");
                    } else if (userType.equalsIgnoreCase("F")) {
                        faculties[totalFaculties] = new Faculty(name);
                        totalFaculties++;
                        System.out.println("Registration successful!");
                    } else if (userType.equalsIgnoreCase("A")) {
                        admins[totalAdmins] = new Admin(name);
                        totalAdmins++;
                        System.out.println("Registration successful!");
                    } else if (userType.equalsIgnoreCase("L")) {
                        librarians[totalLibrarians] = new Librarian(name);
                        totalLibrarians++;
                        System.out.println("Registration successful!");
                    } else if (userType.equalsIgnoreCase("G")) {
                        guests[totalGuests] = new Guest(name);
                        totalGuests++;
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Invalid user type.");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Are you a Student, Faculty, Admin, Librarian, or Guest? (S/F/A/L/G): ");
                    String userType = sc.nextLine();
                    if (userType.equalsIgnoreCase("S")) {
                        Student currentUser = null;
                        for (int i = 0; i < totalStudents; i++) {
                            if (students[i].name.equalsIgnoreCase(name)) {
                                currentUser = students[i];
                                break;
                            }
                        }
                        if (currentUser == null) {
                            System.out.println("User not found. Please register first.");
                            continue;
                        }
                        System.out.println("Logged in as " + currentUser.type + ": " + currentUser.name);
                        studentMenu(currentUser, library);
                    } else if (userType.equalsIgnoreCase("F")) {
                        Faculty currentUser = null;
                        for (int i = 0; i < totalFaculties; i++) {
                            if (faculties[i].name.equalsIgnoreCase(name)) {
                                currentUser = faculties[i];
                                break;
                            }
                        }
                        if (currentUser == null) {
                            System.out.println("User not found. Please register first.");
                            continue;
                        }
                        System.out.println("Logged in as " + currentUser.type + ": " + currentUser.name);
                        facultyMenu(currentUser, library);
                    } else if (userType.equalsIgnoreCase("A")) {
                        Admin currentUser = null;
                        for (int i = 0; i < totalAdmins; i++) {
                            if (admins[i].name.equalsIgnoreCase(name)) {
                                currentUser = admins[i];
                                break;
                            }
                        }
                        if (currentUser == null) {
                            System.out.println("User not found. Please register first.");
                            continue;
                        }
                        System.out.println("Logged in as " + currentUser.type + ": " + currentUser.name);
                        adminMenu(currentUser, library);
                    } else if (userType.equalsIgnoreCase("L")) {
                        Librarian currentUser = null;
                        for (int i = 0; i < totalLibrarians; i++) {
                            if (librarians[i].name.equalsIgnoreCase(name)) {
                                currentUser = librarians[i];
                                break;
                            }
                        }
                        if (currentUser == null) {
                            System.out.println("User not found. Please register first.");
                            continue;
                        }
                        System.out.println("Logged in as " + currentUser.type + ": " + currentUser.name);
                        librarianMenu(currentUser, library);
                    } else if (userType.equalsIgnoreCase("G")) {
                        Guest currentUser = null;
                        for (int i = 0; i < totalGuests; i++) {
                            if (guests[i].name.equalsIgnoreCase(name)) {
                                currentUser = guests[i];
                                break;
                            }
                        }
                        if (currentUser == null) {
                            System.out.println("User not found. Please register first.");
                            continue;
                        }
                        System.out.println("Logged in as " + currentUser.type + ": " + currentUser.name);
                        guestMenu(currentUser, library);
                    } else {
                        System.out.println("Invalid user type.");
                    }
                } else if (choice == 3) {
                    System.out.println("Thank you for using the Library Management System.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    
          static void studentMenu(Student student, Library lib) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\nStudent Menu:");
                System.out.println("1. Borrow a Book");
                System.out.println("2. Return a Book");
                System.out.println("3. Print My Data");
                System.out.println("4. Recommend Books");
                System.out.println("5. Recommend Books by Category");
                System.out.println("6. Logout");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
    
                if (choice == 1) {
                    System.out.print("Enter the name of the book to borrow: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter the number of days (1, 7, or 30): ");
                    int days = sc.nextInt();
                    sc.nextLine();
                    student.borrowBook(bookName, getAuthor(lib, bookName), days, lib);
                } else if (choice == 2) {
                    System.out.print("Enter the name of the book to return: ");
                    String bookName = sc.nextLine();
                    student.returnBook(bookName, lib);
                } else if (choice == 3) {
                    student.printUserData();
                } else if (choice == 4) {
                    student.recommendBooks(lib);
                } else if (choice == 5) {
                    System.out.print("Enter the category to recommend books: ");
                    String category = sc.nextLine();
                    student.recommendBooksByCategory(lib, category);
                } else if (choice == 6) {
                    System.out.println("Logging out...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    
          static void facultyMenu(Faculty faculty, Library lib) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\nFaculty Menu:");
                System.out.println("1. Manage Membership");
                System.out.println("2. Print Student Data");
                System.out.println("3. Recommend Books");
                System.out.println("4. Recommend Books by Category");
                System.out.println("5. Logout");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
    
                if (choice == 1) {
                    faculty.manageMembership(lib);
                } else if (choice == 2) {
                    System.out.print("Enter student name: ");
                    String studentName = sc.nextLine();
                    boolean found = false;
                    for (Student student : students) {
                        if (student != null && student.name.equalsIgnoreCase(studentName)) {
                            faculty.printStudentData(student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                } else if (choice == 3) {
                    faculty.recommendBooks(lib);
                } else if (choice == 4) {
                    System.out.print("Enter the category to recommend books: ");
                    String category = sc.nextLine();
                    faculty.recommendBooksByCategory(lib, category);
                } else if (choice == 5) {
                    System.out.println("Logging out...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    
          static void adminMenu(Admin admin, Library lib) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Add a Book");
                System.out.println("2. Remove a Book");
                System.out.println("3. Update Book Details");
                System.out.println("4. Display Book Availability");
                System.out.println("5. Recommend Books");
                System.out.println("6. Recommend Books by Category");
                System.out.println("7. Logout");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
    
                if (choice == 1) {
                    System.out.print("Enter the name of the book to add: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = sc.nextLine();
                    System.out.print("Enter the number of copies: ");
                    int count = sc.nextInt();
                    admin.addBook(lib, bookName, author, count);
                } else if (choice == 2) {
                    System.out.print("Enter the name of the book to remove: ");
                    String bookName = sc.nextLine();
                    admin.removeBook(lib, bookName);
                } else if (choice == 3) {
                    System.out.print("Enter the name of the book to update: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter the new author: ");
                    String newAuthor = sc.nextLine();
                    System.out.print("Enter the new count: ");
                    int newCount = sc.nextInt();
                    admin.updateBookDetails(lib, bookName, newAuthor, newCount);
                } else if (choice == 4) {
                    System.out.print("Enter the name of the book to check availability: ");
                    String bookName = sc.nextLine();
                    admin.displayBookAvailability(lib, bookName);
                } else if (choice == 5) {
                    admin.recommendBooks(lib);
                } else if (choice == 6) {
                    System.out.print("Enter the category to recommend books: ");
                    String category = sc.nextLine();
                    admin.recommendBooksByCategory(lib, category);
                } else if (choice == 7) {
                    System.out.println("Logging out...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    
          static void librarianMenu(Librarian librarian, Library lib) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\nLibrarian Menu:");
                System.out.println("1. Search for a Book");
                System.out.println("2. Recommend Books");
                System.out.println("3. Recommend Books by Category");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
    
                if (choice == 1) {
                    System.out.print("Enter a keyword to search: ");
                    String keyword = sc.nextLine();
                    librarian.searchBook(lib, keyword);
                } else if (choice == 2) {
                    librarian.recommendBooks(lib);
                } else if (choice == 3) {
                    System.out.print("Enter the category to recommend books: ");
                    String category = sc.nextLine();
                    librarian.recommendBooksByCategory(lib, category);
                } else if (choice == 4) {
                    System.out.println("Logging out...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    
          static void guestMenu(Guest guest, Library lib) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\nGuest Menu:");
                System.out.println("1. View Books");
                System.out.println("2. Recommend Books");
                System.out.println("3. Recommend Books by Category");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
    
                if (choice == 1) {
                    guest.viewBooks(lib);
                } else if (choice == 2) {
                    guest.recommendBooks(lib);
                } else if (choice == 3) {
                    System.out.print("Enter the category to recommend books: ");
                    String category = sc.nextLine();
                    guest.recommendBooksByCategory(lib, category);
                } else if (choice == 4) {
                    System.out.println("Logging out...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    
         static String getAuthor(Library lib, String bookName) {
            for (int i = 0; i < lib.totalBooks; i++) {
                if (lib.books[i].equalsIgnoreCase(bookName)) {
                    return lib.authors[i];
                }
            }
            return "Unknown";
        }
    
        static Student[] students = new Student[100];
        static Faculty[] faculties = new Faculty[100];
        static Admin[] admins = new Admin[100];
        static Librarian[] librarians = new Librarian[100];
        static Guest[] guests = new Guest[100];
    }

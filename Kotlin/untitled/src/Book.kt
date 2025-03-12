data class Book(val name: String, var status: Boolean = true)
data class Student(val id: Int, val name: String, val className: String, val borrowedBooks: MutableList<Pair<Book, String>> = mutableListOf())

fun main() {
    val books = mutableListOf(
        Book("Book1"),
        Book("Book2"),
        Book("Book3"),
        Book("Book4")
    )

    val student = Student(1, "anrye", "oke123")

    println("Welcome, ${student.name}! Here is the list of books:")
    books.forEachIndexed { index, book ->
        println("${index + 1}. ${book.name} - Available: ${book.status}")
    }

    println("\nEnter the number of the book you want to borrow:")
    val choice = readLine()?.toIntOrNull() ?: 0

    if (choice in 1..books.size && books[choice - 1].status) {
        val selectedBook = books[choice - 1]
        selectedBook.status = false

        println("Enter the borrowed day (e.g., 2025-01-08):")
        val borrowedDay = readLine() ?: "Unknown"

        student.borrowedBooks.add(Pair(selectedBook, borrowedDay))

        println("\nYou have successfully borrowed '${selectedBook.name}' on $borrowedDay.")
    } else {
        println("\nInvalid choice or the book is not available.")
    }
    println("\nStudent Information:")
    println("ID: ${student.id}, Name: ${student.name}, Class: ${student.className}")
    println("Borrowed Books:")
    student.borrowedBooks.forEach { (book, date) ->
        println("- ${book.name} (Borrowed on: $date)")
    }
}
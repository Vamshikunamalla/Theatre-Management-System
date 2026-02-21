# 🎭 Theatre Management System

A Java-based theatre management application developed using **Java, JSP, and Servlets** to manage theatre operations such as movies, shows, seats, tickets, payments, food, reviews, staff, and more.

This project demonstrates the **MVC (Model-View-Controller)** architecture and is useful as a learning tool or as a starting point for a more feature-rich theatre booking system.

---

## 📌 Features

This system covers a wide range of theatre management functions:

✅ User/Viewer management  
✅ Movie & Show scheduling  
✅ Seat selection & Ticket booking  
✅ Payment processing  
✅ Food ordering  
✅ Reviews & Ratings  
✅ Staff & Manager operations  
✅ Theatre branch and address management  
✅ Owner administration  

---

## 📁 Project Structure

porject_theatre_management_system/
├── src/main/java/com/jsp/theatre_management_system/
│ ├── controller/ ← Handles HTTP requests (Servlets)
│ │ ├── AddressController.java
│ │ ├── BranchController.java
│ │ ├── FoodController.java
│ │ ├── ManagerController.java
│ │ ├── MovieController.java
│ │ ├── OwnerController.java
│ │ ├── PaymentController.java
│ │ ├── ReviewController.java
│ │ ├── ScreenController.java
│ │ ├── SeatController.java
│ │ ├── StaffController.java
│ │ ├── TheatreController.java
│ │ ├── TicketController.java
│ │ └── ViewerController.java
│ ├── dao/ ← Database access logic
│ ├── dto/ ← Data model classes
│ ├── service/ ← Business logic
│ └── util/ ← Utilities (DB connection, helpers)
├── src/main/webapp/
│ ├── WEB-INF/views/ ← JSP pages
│ └── assets/ ← CSS / JS / images
├── .gitignore
└── README.md


---

## 🧠 Controllers Overview

Each controller in the `com.jsp.theatre_management_system.controller` package is a **Servlet** that handles a specific part of the system.

| Controller | Function |
|------------|----------|
| **AddressController** | Manage theatre addresses |
| **BranchController** | Handle theatre branches |
| **FoodController** | Handle food menu & orders |
| **ManagerController** | Manage manager operations |
| **MovieController** | Add / update movie data |
| **OwnerController** | Admin/owner tasks |
| **PaymentController** | Process booking payments |
| **ReviewController** | Handle user reviews/ratings |
| **ScreenController** | Manage screens in a theatre |
| **SeatController** | Seat selection & availability |
| **StaffController** | Staff user management |
| **TheatreController** | Add / edit theatre info |
| **TicketController** | Handle ticket creation |
| **ViewerController** | User login / viewer actions |

Each controller processes HTTP requests, interacts with services/DAOs, and forwards data to JSP views.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Application logic |
| Servlet | Server controllers |
| JSP | Dynamic UI pages |
| JDBC | Database communication |
| MVC pattern | Architecture design |
| MySQL (optional) | Database (if used) |

---

## 🏁 Getting Started

### 🔧 Prerequisites

Before running the project:

✔ Java JDK 8 or higher  
✔ Apache Tomcat (or another servlet container)  
✔ (Optional) MySQL database  

---

### 📥 Setup Instructions

1. **Clone the repository**

git clone https://github.com/Vamshikunamalla/Theatre-Management-System.git

2.  **Import into IDE**
.Use Eclipse, IntelliJ IDEA, or similar
.Import as Maven / Dynamic Web Project

3.**Database Configuration**
.Create database schema (e.g., theatre_db)
.Update DB credentials in your DBUtility.java

**##Example:**
String URL = "jdbc:mysql://localhost:3306/theatre_db";
String USER = "root";
String PASS = "password";

4.**Deploy on Tomcat**
.Run the project via IDE
.Or export WAR and deploy on Tomcat

5.**Access in Browser**
http://localhost:8080/porject_theatre_management_system/

**🎯Typical Workflow**

1.Viewer Registration / Login
  .New users can register with personal details
  .Existing users can log in to access the system
  
2.Browse Movies & Shows
  .View available movies and showtimes
  .Filter by theatre, date, or genre

3.Select Seats
  .Choose available seats for a selected show
  .Seat availability is updated in real-time

4.View Tickets & Proceed to Payment
  .Review selected seats and booking details
  .Complete payment to confirm booking

5.Order Food
  .Select food items from theatre menu
  .Add to order and process payment if required

6.Submit Review
  .Give feedback or rating for the movie or theatre experience

**  📦 Contribution Guidelines**
  Contributions are welcome! To contribute:
    1.Fork the repository
    2.Create a new branch (feature/xyz)
    3.Make changes
    4.Submit a Pull Request


**   📝 License**

This project is open-source and released under the MIT License.

**🙌 Acknowledgements**

Thanks to all Java web tutorials and MVC design pattern resources that helped shape and structure this project.

---

If you want, I can also generate:

✅ A **diagram** of how controllers interact with services/DAOs  
✅ A **database schema (ER-diagram)** for this project  
✅ A **list of JSP pages** and what each one does

Just tell me!
::contentReference[oaicite:0]{index=0}

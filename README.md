# Hibernate CRUD Application with HQL

## 📌 Project Overview

This project is a simple **Java Hibernate application** that demonstrates how to perform **CRUD (Create, Read, Update, Delete)** operations using Hibernate ORM.
It also includes **complex queries written using HQL (Hibernate Query Language)** to interact with the database in an object-oriented way.

The project is designed to help developers understand how Hibernate works with entities, sessions, and queries.

---

## 🚀 Features

* Perform **Create, Read, Update, Delete (CRUD)** operations
* Use **Hibernate ORM** for database interaction
* Execute **complex queries using HQL**
* Demonstrates **entity relationships and session management**
* Clean and simple project structure for learning Hibernate

---

## 🛠️ Technologies Used

* Java
* Hibernate ORM
* HQL (Hibernate Query Language)
* Maven
* Oracle / MySQL Database
* JUnit (for testing)

---

## 📂 Project Structure

```
src
 ├── main
 │   ├── java
 │   │   ├── entities
 │   │   ├── util
 │   │   └── App.java
 │   └── resources
 │       └── hibernate.cfg.xml
 └── test
     └── AppTest.java
```

---

## ⚙️ Setup and Installation

1. Clone the repository

```
git clone https://github.com/your-username/your-repository-name.git
```

2. Navigate to the project directory

```
cd your-repository-name
```

3. Configure database connection in:

```
hibernate.cfg.xml
```

4. Run the application using your IDE or Maven.

---

## 📊 Example HQL Queries

### Fetch All Students

```
from Student
```

### Fetch Student by Name

```
from Student where studentName = :name
```

### Update Student

```
update Student set studentName = :name where studentId = :id
```

### Delete Student

```
delete from Student where studentId = :id
```

---

## 🎯 Learning Objectives

* Understand **Hibernate SessionFactory and Session**
* Learn **HQL queries**
* Implement **database operations using ORM**
* Practice **Java persistence concepts**

---

## 👨‍💻 Author

Aamir
Java Full Stack Developer

# Advanced Java Lab Experiments (1–10) – Complete Guide

## 📘 Overview

This repository/document contains **10 Advanced Java practical experiments** implemented using one continuous project theme: **Carbon Footprint Management System**.

Each experiment upgrades the same application using newer Java technologies:

```text
Console Java → Client/Server → Servlet → JSP → JSF → Custom Tags
→ Hibernate ORM → Hibernate CRUD → Spring MVC → JSF vs Spring
```

This helps learners understand how Java enterprise applications evolve from basic programming to modern frameworks.

---

# 🧪 Experiment 1

# Create Databases Related to Project and Query Them from Console Based Java Applications

## 🎯 Aim

Create a database and perform CRUD operations using Java console application with JDBC.

## 🛠 Technologies

* Java
* JDBC
* MySQL
* Console Application

## 📁 Main Files

* `CarbonConsoleApp.java`
* `DBConnection.java`

## 🗄 Database

```sql
create database carbon_db;

use carbon_db;

create table carbon_data(
id int primary key auto_increment,
electricity double,
distance double,
lpg double,
water double,
waste double,
total double
);
```

## ⚙️ Features

* Insert record
* View all records
* Update record
* Delete record

## 💡 Learning Outcome

Understand JDBC connection, SQL queries, PreparedStatement, ResultSet.

---

# 🧪 Experiment 2

# Create Client Application Connected to Practical 1

## 🎯 Aim

Create client-server application where client sends search text and server returns matching database results.

## 🛠 Technologies

* Java Socket Programming
* JDBC
* Client/Server Model

## 📁 Files

* `Client.java`
* `Server.java`

## ⚙️ Working

```text
Client sends keyword → Server receives request →
Database searched → Matching result sent back to client
```

## 💡 Learning Outcome

Understand networking, sockets, request-response model.

---

# 🧪 Experiment 3

# Replace Console UI with Web UI using Servlet

## 🎯 Aim

Convert console CRUD application into web application using Servlet.

## 🛠 Technologies

* Servlet
* HTML
* Tomcat 9
* JDBC

## 📁 Files

* `InsertServlet.java`
* `ViewServlet.java`
* `EditServlet.java`
* `UpdateServlet.java`
* `DeleteServlet.java`
* `web.xml`

## ⚙️ URLs

```text
/insert
/view
/edit?id=1
/update
/delete?id=1
```

## 💡 Learning Outcome

Understand request/response lifecycle and deployment on Tomcat.

---

# 🧪 Experiment 4

# Modify Servlet Project to JSP

## 🎯 Aim

Use JSP pages instead of printing HTML from servlet.

## 🛠 Technologies

* JSP
* JSTL
* EL
* JDBC

## 📁 Files

* `index.jsp`
* `view.jsp`
* `edit.jsp`

## ⚙️ Benefits Over Servlet

```text
Cleaner UI code
Easy HTML writing
JSTL loops
Expression Language
```

## 💡 Learning Outcome

Separation of presentation and business logic.

---

# 🧪 Experiment 5

# Use JSF Framework to Replace JSP

## 🎯 Aim

Create CRUD system using JavaServer Faces (JSF).

## 🛠 Technologies

* JSF
* Facelets (`.xhtml`)
* CDI Bean
* MySQL
* Tomcat 9

## 📁 Files

* `index.xhtml`
* `edit.xhtml`
* `CarbonBean.java`
* `beans.xml`
* `web.xml`

## ⚙️ Features

* Insert
* View
* Edit
* Update
* Delete

## 💡 Why JSF?

* Component-based UI
* Built-in validation
* Managed bean binding
* Navigation handling

## 💡 Learning Outcome

Understand MVC + component-based frameworks.

---

# 🧪 Experiment 6

# Custom Tag for Add/View/Delete/Modify Records

## 🎯 Aim

Create reusable JSP custom tag to avoid scriptlets.

## 🛠 Technologies

* JSP Custom Tags
* TagSupport
* TLD File

## 📁 Files

* `CrudTag.java`
* `crud.tld`
* `index.jsp`

## ⚙️ Benefits

* Reusability
* Clean JSP pages
* Separation of logic and UI

## 💡 Learning Outcome

Understand custom JSP tags and TLD structure.

---

# 🧪 Experiment 7

# Use ORM and Replace SQL with HQL

## 🎯 Aim

Use Hibernate ORM with mapping file and config file.

## 🛠 Technologies

* Hibernate
* HQL
* MySQL

## 📁 Files

* `Carbon.java`
* `Carbon.hbm.xml`
* `hibernate.cfg.xml`
* `App.java`

## ⚙️ Example HQL

```java
from Carbon
```

## 💡 Benefits

* Object-table mapping
* Less SQL code
* DB independent queries

## 💡 Learning Outcome

Understand ORM concepts.

---

# 🧪 Experiment 8

# Replace JDBC Calls with Hibernate

## 🎯 Aim

Use Hibernate to perform full CRUD instead of JDBC.

## 🛠 Technologies

* Hibernate
* SessionFactory
* Session
* Transaction

## 📁 Files

* `Carbon.java`
* `HibernateUtil.java`
* `Main.java`

## ⚙️ Features

Console menu based CRUD:

* Insert
* View
* Update
* Delete

## 💡 Benefits

```text
Less boilerplate code
Easy updates
Cleaner code
```

## 💡 Learning Outcome

Hibernate practical CRUD experience.

---

# 🧪 Experiment 9

# Use Spring MVC Architecture

## 🎯 Aim

Create multi-tier architecture using Spring MVC.

## 🛠 Technologies

* Spring MVC
* JSP
* DAO Layer
* Model Layer
* Controller Layer

## 📁 Files

* `CarbonController.java`
* `CarbonDao.java`
* `Carbon.java`
* `view.jsp`
* `index.jsp`
* `spring-servlet.xml`

## ⚙️ Layers

```text
Controller → DAO → Database
View (JSP) ← Model Data
```

## 💡 Benefits

* Structured architecture
* Easy maintenance
* Reusable components

## 💡 Learning Outcome

Understand enterprise MVC design.

---

# 🧪 Experiment 10

# Compare JSF with Spring Framework

## 🎯 Aim

Compare frameworks and evaluate development effort.

## ⚔️ Comparison Table

| Feature       | JSF             | Spring MVC          |
| ------------- | --------------- | ------------------- |
| Type          | Component Based | Request Based       |
| View          | XHTML           | JSP/Thymeleaf       |
| Validation    | Built-in        | Annotation Based    |
| UI Components | Rich            | Flexible            |
| Best For      | Form apps       | Large scalable apps |

## 🧠 Conclusion

```text
JSF is faster for UI-heavy form systems.
Spring MVC is stronger for scalable enterprise systems.
```

## 💡 Learning Outcome

Framework selection based on project needs.

---

# 📦 Common Tools Used Across All Experiments

* JDK 17
* Apache NetBeans
* Apache Tomcat 9
* Maven
* MySQL
* GitHub

---

# 🧯 Common Errors Solved During Development

## Tomcat 9 Namespace Issue

Use:

```java
javax.servlet.*
```

Not:

```java
jakarta.servlet.*
```

## Hibernate Config Not Found

Place XML files in:

```text
src/main/resources
```

## JSF Update Not Working

Use proper bean scope and hidden ID handling.

---

# 📁 Suggested GitHub Repository Structure

```text
Advanced-Java-Lab
│── Exp-01-JDBC-CRUD
│── Exp-02-Client-Server
│── Exp-03-Servlet
│── Exp-04-JSP
│── Exp-05-JSF
│── Exp-06-Custom-Tag
│── Exp-07-Hibernate-ORM
│── Exp-08-Hibernate-CRUD
│── Exp-09-Spring-MVC
│── Exp-10-Framework-Comparison
```

---

# 🏁 Final Result

All 10 experiments completed successfully using one progressive Carbon Footprint Management project.

---

# 👨‍💻 Maintainer Note

This guide helps students understand:

* What was built
* Why technology changed
* How implementation evolved
* How Java enterprise stack works end-to-end

---

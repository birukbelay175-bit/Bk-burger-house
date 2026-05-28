[biruks_burger_house_readme.md](https://github.com/user-attachments/files/28332104/biruks_burger_house_readme.md)[U# Biruk's Burger House 🍔

## Project Description
Biruk’s Burger House is a console-based restaurant ordering application built in Java. The application allows customers to create custom burger orders, add drinks and sides, review their orders before payment, and generate receipt files automatically.

This project was developed using Object-Oriented Programming (OOP) principles and includes professional restaurant-style features such as order validation, payment review, customizable toppings, receipt generation, and colorful console formatting.

---

# Features

## 🍔 Burger Customization
- Multiple burger sizes
  - Small
  - Medium
  - Large
- Multiple burger types
  - Beef
  - Chicken
  - Veggie
- Double patty option
- Premium toppings
- Extra toppings option

## 🥤 Drink System
- Coke
- Sprite
- Fanta
- Water (free)

## 🍟 Side System
- Fries
- Onion Rings
- Salad

## 🧾 Order Review & Payment
- Review order before payment
- Cancel payment confirmation
- Cancel order confirmation
- Order total calculation
- Automatic order number generation
- Customer name support

## 📁 Receipt Generation
- Receipts are automatically saved as `.txt` files
- Receipt includes:
  - Customer name
  - Order number
  - Ordered items
  - Prices
  - Total amount
  - Date and time

## ✅ Validation System
- Prevents invalid menu selections
- Prevents invalid y/n inputs
- Prevents empty checkout
- Handles invalid numeric entries safely

## 🎨 Console UI Improvements
- Styled console headers
- ANSI color formatting
- Professional menu flow
- Restaurant-style ordering experience

---

# Technologies Used
- Java
- IntelliJ IDEA
- Object-Oriented Programming (OOP)
- ArrayLists
- File Handling
- Java Scanner
- LocalDateTime

---

# Project Structure

## Main Classes
| Class | Purpose |
|---|---|
| `App` | Starts the application |
| `UserInterface` | Handles menus and user interaction |
| `Order` | Stores customer orders |
| `Burger` | Represents burger objects |
| `Drink` | Represents drink objects |
| `Side` | Represents side objects |
| `Topping` | Represents burger toppings |
| `ReceiptFileManager` | Saves receipt files |

---

# OOP Concepts Used

## Encapsulation
Each class manages its own data and behavior.

## Constructors
Constructors are used to create objects with specific values.

Example:

```java
Burger burger = new Burger(size, type, doublePatty);
```

## ArrayLists
Used to store:
- Burgers
- Drinks
- Sides

inside each order.

## Methods
The project uses many reusable methods such as:
- `addBurger()`
- `addDrink()`
- `chooseSize()`
- `reviewOrderBeforePayment()`

---

# How to Run the Program

1. Open the project in IntelliJ IDEA
2. Run the `App.java` file
3. Follow the console menu instructions

---

# Sample Features Demonstrated
- Restaurant-style ordering flow
- Professional receipt generation
- Input validation
- Order review before payment
- Console color formatting

---

# Future Improvements
- GUI version using JavaFX
- Database integration
- Online ordering support
- Employee/admin system
- Delivery system

---

# Author
**Biruk Tafese**  
Application Development Student  
Year Up United

ploading biruks_burger_house_readme.md…]()

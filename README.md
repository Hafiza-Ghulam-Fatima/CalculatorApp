# 📱 Android Calculator App

A simple and user-friendly calculator application built using Android (Java).
This app performs basic arithmetic operations with a clean UI and smooth user experience.

---

## 🚀 Features

* ➕ Addition
* ➖ Subtraction
* ✖️ Multiplication
* ➗ Division
* 🔢 Decimal support (with validation)
* 🧹 Clear button to reset input
* ⚡ Fast and responsive UI
* ❌ Error handling (invalid expressions, divide by zero)

---

## 🛠️ Technologies Used

* **Java (Android)**
* **XML (UI Design)**
* **exp4j Library** (for expression evaluation)

---

## 📂 Project Structure

```
CalculatorApp/
│── app/
│   ├── java/com/example/calculator/
│   │   └── MainActivity.java
│   ├── res/layout/
│   │   └── activity_main.xml
│   ├── res/values/
│   │   └── styles.xml
│── build.gradle
│── AndroidManifest.xml
```

---

## 📸 UI Overview

* Clean dark theme interface
* Large display for input and result
* Grid layout buttons for easy use

---

## ⚙️ How It Works

* User inputs numbers and operators
* Expression is stored as a string
* Using **ExpressionBuilder (exp4j)**:

  * Expression is parsed
  * Result is calculated
* Output is displayed on screen
* Handles errors like:

  * Invalid expressions
  * Infinite or undefined results

---

## 🧠 Logic Highlights

* ✔ Max input length control (16 characters)
* ✔ Only one decimal allowed per number
* ✔ Automatic `0.` handling for decimals
* ✔ Clean result formatting (removes unnecessary decimals)

---

## ▶️ How to Run

1. Clone the repository:

```
git clone https://github.com/your-username/CalculatorApp.git
```

2. Open in **Android Studio**

3. Sync Gradle

4. Run the app on:

   * Emulator OR
   * Physical device

---

## 📦 Dependency

Add this to your `build.gradle`:

```
implementation 'net.objecthunter:exp4j:0.4.8'
```

---

## 📌 Future Improvements

* Scientific calculator functions (sin, cos, log)
* History of calculations
* Better UI animations
* Dark/Light theme toggle

---

## 👨‍💻 Author

**Hafiza Ghulam Fatima**

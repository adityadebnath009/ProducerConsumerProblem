# Producer–Consumer Problem (Java)

This repository contains a Java implementation of the classic **Producer–Consumer problem** using **multithreading** and **inter-thread communication**.

The goal is to demonstrate how multiple producer and consumer threads coordinate access to a shared resource without causing race conditions or data inconsistency.

---

## Problem Statement

- **Producers** generate data and put it into a shared buffer.
- **Consumers** take data from the same buffer.
- The buffer has a limited capacity.
- Producers must wait if the buffer is full.
- Consumers must wait if the buffer is empty.

This coordination is achieved using Java’s intrinsic locks and `wait()` / `notifyAll()`.

---

## Core Concepts Used

- Java Threads (`Runnable`)
- Synchronization (`synchronized`)
- Inter-thread communication (`wait`, `notifyAll`)
- Shared resource protection
- Avoiding race conditions

---

## Project Structure
src/

└─ producerConsumer/

  ├─ Buffer.java // Shared resource with synchronization logic

  ├─ Producer.java // Producer thread implementation

  ├─ Consumer.java // Consumer thread implementation

  └─ Main.java // Entry point to start threads

---

## How It Works

1. `Buffer` maintains a shared data structure with a fixed capacity.
2. `Producer` threads:
   - Produce data
   - Wait if the buffer is full
3. `Consumer` threads:
   - Consume data
   - Wait if the buffer is empty
4. `wait()` releases the lock and suspends execution.
5. `notifyAll()` wakes up waiting threads when state changes.

This ensures **thread safety** and **correct sequencing**.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/<adityadebnath009>/ProducerConsumerProblem.git
2. Open in IntelliJ IDEA (or any Java IDE)
3. Run Main.java

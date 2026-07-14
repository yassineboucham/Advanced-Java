# ☕ Advanced Java — Complete Mastery Guide

> A structured reference covering every major topic you need to go from intermediate to expert-level Java developer.

---

## 📚 Table of Contents

1. [Object-Oriented Programming (OOP) Deep Dive](#1-object-oriented-programming-oop-deep-dive)
2. [Generics](#2-generics)
3. [Collections Framework](#3-collections-framework)
4. [Functional Programming & Lambda Expressions](#4-functional-programming--lambda-expressions)
5. [Streams API](#5-streams-api)
6. [Exception Handling (Advanced)](#6-exception-handling-advanced)
7. [Multithreading & Concurrency](#7-multithreading--concurrency)
8. [Java Memory Model (JMM)](#8-java-memory-model-jmm)
9. [Java I/O and NIO](#9-java-io-and-nio)
10. [Reflection API](#10-reflection-api)
11. [Annotations](#11-annotations)
12. [Design Patterns](#12-design-patterns)
13. [Java Modules (JPMS)](#13-java-modules-jpms)
14. [JDBC & Database Access](#14-jdbc--database-access)
15. [Networking in Java](#15-networking-in-java)
16. [JVM Internals & Performance Tuning](#16-jvm-internals--performance-tuning)
17. [Unit Testing with JUnit & Mockito](#17-unit-testing-with-junit--mockito)
18. [Build Tools (Maven & Gradle)](#18-build-tools-maven--gradle)
19. [Java 9–21 Modern Features](#19-java-921-modern-features)
20. [Best Practices & Clean Code](#20-best-practices--clean-code)

---

## 1. Object-Oriented Programming (OOP) Deep Dive

### Core Pillars
- **Encapsulation** — hiding internal state via `private` fields and getters/setters
- **Inheritance** — reusing behavior via `extends`; single inheritance only for classes
- **Polymorphism** — method overriding (runtime) vs overloading (compile-time)
- **Abstraction** — using `abstract` classes and `interface` to define contracts

### Advanced OOP Concepts
- **Abstract classes vs Interfaces** — when to use each; default methods in interfaces (Java 8+)
- **Covariant return types** — overriding with a more specific return type
- **Constructor chaining** — `this()` and `super()` calls
- **Static vs instance members** — class-level behavior and state
- **Inner classes** — static nested, inner, local, and anonymous classes
- **`final` keyword** — on variables, methods, and classes

```java
// Example: Abstract class vs Interface
abstract class Animal {
    abstract void makeSound();
    void breathe() { System.out.println("Breathing..."); }
}

interface Trainable {
    default void train() { System.out.println("Training..."); }
}

class Dog extends Animal implements Trainable {
    @Override
    public void makeSound() { System.out.println("Woof!"); }
}
```

---

## 2. Generics

### Why Generics?
Generics provide **type safety at compile time** and eliminate the need for unsafe casting.

### Key Concepts
- **Generic classes** — `class Box<T> { T value; }`
- **Generic methods** — `<T> T getFirst(List<T> list)`
- **Bounded type parameters** — `<T extends Number>`, `<T super Integer>`
- **Wildcards** — `<?>`, `<? extends T>`, `<? super T>`
- **Type erasure** — how generics work at runtime (JVM erases type info)
- **PECS Principle** — Producer Extends, Consumer Super

```java
// Bounded wildcard example
public double sumList(List<? extends Number> list) {
    return list.stream().mapToDouble(Number::doubleValue).sum();
}
```

---

## 3. Collections Framework

### Main Interfaces
| Interface | Key Implementations |
|-----------|-------------------|
| `List` | `ArrayList`, `LinkedList`, `Vector`, `Stack` |
| `Set` | `HashSet`, `LinkedHashSet`, `TreeSet` |
| `Map` | `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable` |
| `Queue` | `PriorityQueue`, `ArrayDeque`, `LinkedList` |
| `Deque` | `ArrayDeque`, `LinkedList` |

### Advanced Topics
- **Choosing the right collection** — performance characteristics (O(1) vs O(log n))
- **`Collections` utility class** — sort, shuffle, synchronizedList, unmodifiableList
- **`Comparable` vs `Comparator`** — natural ordering vs custom sorting
- **Fail-fast vs Fail-safe iterators** — `ConcurrentModificationException`
- **Concurrent collections** — `ConcurrentHashMap`, `CopyOnWriteArrayList`, `BlockingQueue`
- **`EnumSet` and `EnumMap`** — highly optimized for enum keys

```java
// Custom sorting with Comparator
List<String> names = Arrays.asList("Yassine", "Ali", "Mariam");
names.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
```

---

## 4. Functional Programming & Lambda Expressions

### Functional Interfaces (java.util.function)
| Interface | Signature | Use Case |
|-----------|-----------|----------|
| `Function<T,R>` | `R apply(T t)` | Transform input to output |
| `Consumer<T>` | `void accept(T t)` | Consume without return |
| `Supplier<T>` | `T get()` | Produce a value |
| `Predicate<T>` | `boolean test(T t)` | Test a condition |
| `BiFunction<T,U,R>` | `R apply(T t, U u)` | Two inputs, one output |
| `UnaryOperator<T>` | `T apply(T t)` | Same type in/out |

### Lambda Syntax
```java
// Traditional anonymous class
Runnable r1 = new Runnable() {
    public void run() { System.out.println("Running"); }
};

// Lambda equivalent
Runnable r2 = () -> System.out.println("Running");
```

### Method References
```java
// Static method reference
Function<String, Integer> parser = Integer::parseInt;

// Instance method reference
Consumer<String> printer = System.out::println;

// Constructor reference
Supplier<ArrayList<String>> listFactory = ArrayList::new;
```

### Function Composition
```java
Function<Integer, Integer> times2 = x -> x * 2;
Function<Integer, Integer> plus3  = x -> x + 3;

Function<Integer, Integer> times2ThenPlus3 = times2.andThen(plus3);
```

---

## 5. Streams API

### Stream Pipeline
A stream operation consists of: **Source → Intermediate Operations → Terminal Operation**

### Intermediate Operations (lazy)
- `filter(Predicate)` — keep matching elements
- `map(Function)` — transform elements
- `flatMap(Function)` — flatten nested streams
- `distinct()` — remove duplicates
- `sorted()` / `sorted(Comparator)` — sort
- `peek(Consumer)` — debug without consuming
- `limit(n)` / `skip(n)` — slicing

### Terminal Operations (eager)
- `collect(Collectors.toList())` — gather into collection
- `forEach(Consumer)` — iterate
- `reduce(identity, accumulator)` — fold to single value
- `count()`, `min()`, `max()`, `findFirst()`, `anyMatch()`, `allMatch()`

### Collectors
```java
// Group by first letter
Map<Character, List<String>> grouped = names.stream()
    .collect(Collectors.groupingBy(s -> s.charAt(0)));

// Joining
String joined = names.stream().collect(Collectors.joining(", ", "[", "]"));

// Partitioning
Map<Boolean, List<Integer>> partitioned = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
```

### Parallel Streams
```java
long count = largeList.parallelStream()
    .filter(x -> x > 100)
    .count();
// ⚠️ Not always faster — use only for CPU-intensive, stateless operations
```

### Primitive Streams
- `IntStream`, `LongStream`, `DoubleStream` — avoid boxing overhead
- `IntStream.range(0, 10)`, `IntStream.of(1, 2, 3)`

---

## 6. Exception Handling (Advanced)

### Exception Hierarchy
```
Throwable
├── Error (JVM-level, don't catch)
│   ├── OutOfMemoryError
│   └── StackOverflowError
└── Exception
    ├── RuntimeException (Unchecked)
    │   ├── NullPointerException
    │   ├── IllegalArgumentException
    │   └── IndexOutOfBoundsException
    └── Checked Exceptions
        ├── IOException
        └── SQLException
```

### Advanced Techniques
- **Multi-catch** — `catch (IOException | SQLException e)`
- **Try-with-resources** — auto-closes `AutoCloseable` resources
- **Custom exceptions** — extend `Exception` or `RuntimeException`
- **Exception chaining** — `new RuntimeException("msg", cause)`
- **`finally` vs `try-with-resources`** — prefer the latter

```java
// Try-with-resources
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement stmt = conn.prepareStatement(sql)) {
    // use resources
} catch (SQLException e) {
    throw new RuntimeException("DB error", e); // exception chaining
}
```

---

## 7. Multithreading & Concurrency

### Thread Creation
```java
// Extending Thread
class MyThread extends Thread {
    public void run() { /* task */ }
}

// Implementing Runnable (preferred)
Thread t = new Thread(() -> System.out.println("Task"));
t.start();
```

### Thread Lifecycle
`NEW → RUNNABLE → RUNNING → BLOCKED/WAITING/TIMED_WAITING → TERMINATED`

### Synchronization
- **`synchronized` keyword** — method-level or block-level
- **Intrinsic locks (monitors)** — every object has one
- **`volatile` keyword** — ensures visibility across threads (not atomicity)
- **`ReentrantLock`** — explicit lock with `lock()` / `unlock()`
- **`ReadWriteLock`** — multiple readers OR one writer

### java.util.concurrent
- **`ExecutorService`** — thread pool management (`Executors.newFixedThreadPool(n)`)
- **`Future<T>` & `Callable<T>`** — tasks that return results
- **`CompletableFuture<T>`** — async, non-blocking composition
- **`CountDownLatch`** — wait for N tasks to finish
- **`CyclicBarrier`** — all threads reach a point before continuing
- **`Semaphore`** — limit concurrent access
- **`AtomicInteger`, `AtomicReference`** — lock-free atomic operations

```java
// CompletableFuture example
CompletableFuture.supplyAsync(() -> fetchData())
    .thenApply(data -> process(data))
    .thenAccept(result -> save(result))
    .exceptionally(ex -> { log(ex); return null; });
```

### Common Concurrency Pitfalls
- **Race condition** — unsynchronized access to shared mutable state
- **Deadlock** — two threads waiting on each other's lock
- **Livelock** — threads respond to each other but make no progress
- **Starvation** — thread never gets CPU time

---

## 8. Java Memory Model (JMM)

### Heap vs Stack
| | Stack | Heap |
|--|-------|------|
| Stores | Primitives, references, method frames | Objects, arrays |
| Size | Small, fixed | Large, dynamic |
| Thread | Per-thread | Shared |
| GC | Auto (LIFO) | Garbage collected |

### Garbage Collection
- **Generations** — Young (Eden + Survivors), Old (Tenured), Metaspace
- **GC Algorithms** — Serial, Parallel, G1 (default), ZGC, Shenandoah
- **Stop-the-world pauses** — minimized by modern collectors

### Memory Areas (JVM)
- **Method Area / Metaspace** — class metadata
- **Heap** — object instances
- **Stack** — method invocation frames
- **Program Counter (PC)** — current instruction per thread
- **Native Method Stack** — native (C/C++) method calls

### Tuning GC (JVM flags)
```bash
-Xms512m -Xmx2g          # Initial and max heap size
-XX:+UseG1GC              # Use G1 garbage collector
-XX:MaxGCPauseMillis=200  # Target max GC pause
```

---

## 9. Java I/O and NIO

### Classic I/O (java.io)
- **Byte streams** — `FileInputStream`, `FileOutputStream`
- **Character streams** — `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`
- **Object serialization** — `ObjectInputStream`, `ObjectOutputStream`, `Serializable`

```java
// Efficient file reading with BufferedReader
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
}
```

### NIO (java.nio) — Non-blocking I/O
- **`Path` & `Files`** — modern file API (use instead of `File`)
- **`ByteBuffer`** — direct memory buffers
- **`Channel`** — `FileChannel`, `SocketChannel`, `ServerSocketChannel`
- **`Selector`** — single thread handles multiple channels

```java
// Modern file operations with NIO
Path path = Path.of("file.txt");
List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
```

---

## 10. Reflection API

Reflection lets you inspect and manipulate classes, methods, and fields **at runtime**.

```java
Class<?> clazz = Class.forName("com.example.MyClass");

// Get all methods
Method[] methods = clazz.getDeclaredMethods();

// Invoke a method dynamically
Method method = clazz.getMethod("greet", String.class);
Object instance = clazz.getDeclaredConstructor().newInstance();
method.invoke(instance, "Yassine");

// Access private fields
Field field = clazz.getDeclaredField("secret");
field.setAccessible(true);
field.set(instance, "newValue");
```

### Use Cases
- Dependency injection frameworks (Spring)
- Testing frameworks (JUnit)
- Serialization libraries (Jackson, Gson)
- ORM frameworks (Hibernate)

> ⚠️ Use reflection sparingly — it bypasses compile-time checks and has performance overhead.

---

## 11. Annotations

### Built-in Annotations
- `@Override`, `@Deprecated`, `@SuppressWarnings`, `@FunctionalInterface`
- `@SafeVarargs` — suppresses unchecked varargs warnings

### Meta-Annotations
| Annotation | Purpose |
|------------|---------|
| `@Target` | Where it can be applied (CLASS, METHOD, FIELD...) |
| `@Retention` | Lifespan: SOURCE, CLASS, RUNTIME |
| `@Documented` | Included in Javadoc |
| `@Inherited` | Subclasses inherit it |
| `@Repeatable` | Can appear multiple times |

### Creating Custom Annotations
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
    String value() default "default";
}
```

Processing at runtime via Reflection:
```java
for (Method m : clazz.getMethods()) {
    if (m.isAnnotationPresent(LogExecutionTime.class)) {
        long start = System.nanoTime();
        m.invoke(obj);
        System.out.println("Time: " + (System.nanoTime() - start) + "ns");
    }
}
```

---

## 12. Design Patterns

### Creational Patterns
- **Singleton** — one instance (`volatile` + double-checked locking, or enum-based)
- **Factory Method** — let subclasses decide which class to instantiate
- **Abstract Factory** — family of related objects
- **Builder** — step-by-step object construction (fluent API)
- **Prototype** — clone existing objects

### Structural Patterns
- **Adapter** — bridge incompatible interfaces
- **Decorator** — add behavior dynamically (InputStream wrappers)
- **Proxy** — control access (lazy loading, security, logging)
- **Facade** — simplified interface to a complex subsystem
- **Composite** — tree structure of objects
- **Flyweight** — share common state to save memory (String pool)

### Behavioral Patterns
- **Strategy** — swap algorithms at runtime
- **Observer** — publish/subscribe event system
- **Command** — encapsulate a request as an object
- **Template Method** — skeleton algorithm, subclasses fill details
- **Iterator** — sequentially access collection elements
- **Chain of Responsibility** — pass request along a chain of handlers

```java
// Builder pattern
Person person = new Person.Builder()
    .name("Yassine")
    .age(22)
    .city("Marrakech")
    .build();
```

---

## 13. Java Modules (JPMS)

Introduced in **Java 9** via Project Jigsaw. Modules are named groups of packages.

### `module-info.java`
```java
module com.myapp.core {
    requires java.sql;
    requires transitive java.logging;
    exports com.myapp.api;
    opens com.myapp.internal to com.myapp.test;
}
```

### Key Directives
| Directive | Meaning |
|-----------|---------|
| `requires` | Depends on another module |
| `requires transitive` | Passes dependency to consumers |
| `exports` | Makes package public |
| `opens` | Opens package for reflection |
| `uses` / `provides` | Service loader mechanism |

---

## 14. JDBC & Database Access

### JDBC Workflow
```java
// 1. Load driver (Java 6+ auto-loads via SPI)
// 2. Get connection
Connection conn = DriverManager.getConnection(url, user, password);

// 3. Create statement
PreparedStatement stmt = conn.prepareStatement(
    "SELECT * FROM users WHERE id = ?"
);
stmt.setInt(1, userId);

// 4. Execute query
ResultSet rs = stmt.executeQuery();
while (rs.next()) {
    System.out.println(rs.getString("name"));
}

// 5. Close resources (use try-with-resources)
```

### Connection Pooling
Use **HikariCP**, **C3P0**, or **DBCP** instead of creating connections manually. Connection creation is expensive.

```java
HikariConfig config = new HikariConfig();
config.setJdbcUrl("jdbc:mysql://localhost/db");
config.setMaximumPoolSize(10);
DataSource ds = new HikariDataSource(config);
```

---

## 15. Networking in Java

### TCP Sockets
```java
// Server
ServerSocket server = new ServerSocket(8080);
Socket client = server.accept();
BufferedReader in = new BufferedReader(
    new InputStreamReader(client.getInputStream())
);

// Client
Socket socket = new Socket("localhost", 8080);
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
out.println("Hello Server");
```

### HTTP with `HttpClient` (Java 11+)
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .header("Content-Type", "application/json")
    .GET()
    .build();

HttpResponse<String> response = client.send(request,
    HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
```

---

## 16. JVM Internals & Performance Tuning

### JVM Execution
1. **Class Loading** — Bootstrap → Extension → Application ClassLoader
2. **Bytecode Verification** — safety checks
3. **JIT Compilation** — HotSpot compiles hot methods to native code
4. **Garbage Collection** — memory reclamation

### Profiling & Monitoring Tools
- **`jps`** — list Java processes
- **`jstack`** — thread dump
- **`jmap`** — heap dump
- **`jvisualvm`** / **JMC (Java Mission Control)** — GUI profiler
- **`jstat`** — GC statistics

### Performance Tips
- Prefer `StringBuilder` over `String` concatenation in loops
- Use primitive types where possible (avoid boxing)
- Cache expensive computations
- Use `final` to help JIT optimize
- Avoid unnecessary object creation
- Use `System.arraycopy()` for array copies

---

## 17. Unit Testing with JUnit & Mockito

### JUnit 5 Basics
```java
@Test
void shouldAddTwoNumbers() {
    assertEquals(5, calculator.add(2, 3));
}

@ParameterizedTest
@ValueSource(ints = {1, 2, 3, 4, 5})
void shouldBePositive(int number) {
    assertTrue(number > 0);
}

@BeforeEach
void setUp() { /* runs before each test */ }

@AfterAll
static void tearDown() { /* runs once after all tests */ }
```

### Mockito
```java
// Create mock
UserRepository repo = mock(UserRepository.class);

// Stub behavior
when(repo.findById(1L)).thenReturn(Optional.of(new User("Yassine")));

// Verify interaction
verify(repo, times(1)).findById(1L);

// Argument matchers
when(repo.save(any(User.class))).thenReturn(savedUser);
```

### Test Coverage Goals
- **Unit tests** — isolated, fast, test single unit of logic
- **Integration tests** — test component interactions
- **Aim for 70–80%+ coverage** on business logic

---

## 18. Build Tools (Maven & Gradle)

### Maven
- **`pom.xml`** — project descriptor
- **Lifecycle phases** — `validate → compile → test → package → install → deploy`
- **Key commands**: `mvn clean install`, `mvn test`, `mvn package`
- **Dependency scopes** — `compile`, `test`, `provided`, `runtime`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>3.2.0</version>
</dependency>
```

### Gradle
- **`build.gradle`** (Groovy) or **`build.gradle.kts`** (Kotlin DSL)
- Faster than Maven due to incremental builds and build cache
- **Key commands**: `gradle build`, `gradle test`, `gradle run`

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web:3.2.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}
```

---

## 19. Java 9–21 Modern Features

| Version | Key Features |
|---------|-------------|
| **Java 9** | Modules (JPMS), `List.of()`, `Map.of()`, `Stream` improvements |
| **Java 10** | `var` (local type inference) |
| **Java 11** | `HttpClient`, `String` new methods (`isBlank()`, `lines()`, `strip()`) |
| **Java 12–13** | Switch expressions (preview), text blocks (preview) |
| **Java 14** | Records (preview), pattern matching for `instanceof` |
| **Java 15** | Text blocks (stable), sealed classes (preview) |
| **Java 16** | Records (stable), `Stream.toList()` |
| **Java 17** | Sealed classes (stable), pattern matching stable (LTS) |
| **Java 21** | Virtual Threads (Project Loom), Sequenced Collections, Record Patterns (LTS) |

### Key Modern Features in Detail

**`var` — Local Type Inference**
```java
var list = new ArrayList<String>(); // inferred as ArrayList<String>
var map = Map.of("key", 42);
```

**Records**
```java
record Point(int x, int y) {}  // immutable data class, auto-generates constructor, equals, hashCode, toString
Point p = new Point(3, 4);
System.out.println(p.x()); // 3
```

**Text Blocks**
```java
String json = """
        {
            "name": "Yassine",
            "city": "Marrakech"
        }
        """;
```

**Switch Expressions**
```java
String result = switch (day) {
    case MONDAY, TUESDAY -> "Weekday";
    case SATURDAY, SUNDAY -> "Weekend";
    default -> "Other";
};
```

**Sealed Classes**
```java
sealed interface Shape permits Circle, Rectangle, Triangle {}
record Circle(double radius) implements Shape {}
record Rectangle(double w, double h) implements Shape {}
```

**Virtual Threads (Java 21)**
```java
// Millions of lightweight threads!
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    IntStream.range(0, 1_000_000)
        .forEach(i -> executor.submit(() -> task(i)));
}
```

**Pattern Matching for `instanceof`**
```java
// Old way
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.length());
}
// New way
if (obj instanceof String s) {
    System.out.println(s.length());
}
```

---

## 20. Best Practices & Clean Code

### Code Quality Principles
- **SOLID Principles** — Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion
- **DRY** — Don't Repeat Yourself
- **KISS** — Keep It Simple, Stupid
- **YAGNI** — You Aren't Gonna Need It

### Java-Specific Best Practices
- Favor **immutability** — use `final`, `record`, `List.of()`
- Use **`Optional<T>`** instead of returning `null`
- Prefer **interfaces over concrete types** in declarations
- Use **`try-with-resources`** for all `Closeable` objects
- Override **`equals()` and `hashCode()`** together (or use `record`)
- Use **`@Override`** annotation always when overriding
- Document public APIs with **Javadoc**
- Write **small, focused methods** (single responsibility)
- Name things **clearly and consistently** — code is read more than written

```java
// ✅ Good: returns Optional, avoids null
public Optional<User> findUser(long id) {
    return userRepository.findById(id);
}

// ❌ Bad: caller must check for null manually
public User findUser(long id) {
    return userRepository.findById(id); // may return null
}
```

### Tools to Enforce Quality
- **Checkstyle** — style enforcement
- **PMD / SpotBugs** — bug detection
- **SonarQube** — continuous code quality
- **Google Java Format** — auto-formatting

---

## 🗺️ Learning Roadmap

```
Level 1 (Foundation)
└── OOP Deep Dive → Generics → Collections

Level 2 (Core Advanced)
├── Functional Programming → Streams API
├── Exception Handling
└── I/O & NIO

Level 3 (Concurrency & Performance)
├── Multithreading & Concurrency
├── Java Memory Model
└── JVM Internals & Performance

Level 4 (Architecture & Ecosystem)
├── Design Patterns
├── Reflection & Annotations
├── JDBC & Networking
└── Build Tools & Testing

Level 5 (Modern Java)
└── Java 9–21 Features → Modules → Virtual Threads
```

---

## 📖 Recommended Resources

- 📘 *Effective Java* — Joshua Bloch (must-read)
- 📘 *Java Concurrency in Practice* — Brian Goetz
- 📘 *Clean Code* — Robert C. Martin
- 📘 *Head First Design Patterns* — Freeman & Robson
- 🌐 [docs.oracle.com/en/java](https://docs.oracle.com/en/java/)
- 🌐 [baeldung.com](https://www.baeldung.com) — best Java tutorials online
- 🌐 [jenkov.com](https://jenkov.com) — deep Java tutorials

---

*Built for advanced Java mastery — study each section, practice with code, and build real projects.*
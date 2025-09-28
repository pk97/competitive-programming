
| Type                  | Example                        | Use Case                               |
| --------------------- | ------------------------------ | -------------------------------------- |
| **Implicit Lock**     | `synchronized`                 | Simple cases, easy to use              |
| **Explicit Lock**     | `ReentrantLock`                | More control (e.g., try-lock, timeout) |
| **ReadWriteLock**     | `ReentrantReadWriteLock`       | Optimizes for read-heavy cases         |
| **StampedLock**       | `StampedLock` (Java 8+)        | High-performance alternatives          |
| **Distributed Locks** | Redis, Zookeeper, DB row locks | For multi-instance/multi-machine apps  |

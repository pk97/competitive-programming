ACID properties are the funudamental properties of Relational databases which helps to 
keep data integrity and manage concurrent requests in db.

A -> Atomicity

Either the whole transaction is taken place or nothing will take place.
Any successful intermediate state will be roll backed. 

Eg. Transfer 100 ruppes from Account A to B. If db craches after deducting from account A,
we may lead to inconsistent state.

In PostgreSQL, atomicity is achieved by using a transaction log, 
also known as a write-ahead log (WAL). All the changes made during 
a transaction are first written to the WAL before being applied to the actual database.

C -> Consistency
Consistency is the property that guarantees the database remains in a consistent state
before and after a transaction. This means that any transaction must transform 
the database from one consistent state to another, respecting the defined rules and constraints.

Rules like unqiue column, check constraints like account balance >100 eg.

I -> Isolation
 concurrent transactions can run independent of each other as they run isolation.
The final result of running them should be same if as they ran sequentially.
Read commited isolation level is used by postgres -> Transaction can only read changes whicha re commited.

D-> Durability

If a transcation is commited, even after shutting down the system, the data 
should be durable.






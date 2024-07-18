- primary key is used to Identify unique rows in a table.
<p>
foreign key is primary key of 1 table added to a column to another table to creating mapping between 2 tables.
this ensures data integrity. Eg. address entity cannot exist witout a User. Or 1 to 1 mapping.
This leads to better performance as 1 can normalise the db. 
less space is required.
</p>
- Composition -> is Like child depends on Parent class for existance. Like head exists only if a Person exists.
- Associated -> Customer places an order. This is 1 to many Association.
- Aggregation -> 2 classes are aggregated together but both can exist independently. Like Wheel, Car, Steering.

- How to improve query performance
- <p> Use primary key in query where possible as the engine doesn't scan all the records with PK
    A PK can have multiple columns. PK should never be NULL. 
- In MYSQl, a clustered index is automatically created on PK. This kind of index physically organizes the data on disk as per the logical
- order of the index key. Eg. CustomerId is 1 to 100, so data will be ordered in 1 to 100 hence searching in ordered data becomes efficient.\
- Hence @GeneratedValuie is used. All the data is ordered as per the primary key. 
- It is a B+ tree index where leaf nodes points to actual data blocks in the disk.
- Since a clustered index impacts the physical organization of the data, there can be only one clustered index per table.
</p>
- Secondary Index
- <p> Secondary Index </p>
- It is stored in a separate memory space. Eg. I want to find all emails, which are not PK. I can create a Secondary Index on it.

-  DB sharding.



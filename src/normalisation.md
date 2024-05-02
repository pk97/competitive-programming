# Normalisation 

- it is a technique using which we can control redudancy and maintian integrity in
- SQL dbs. It can be achieved using different normalising forms like 1NF, 2 NF, 3 NF.

## 1 NF
 - Order of row in a table is of no significance
 - Mixing data types within same column is not permitted
 - Having a table without primary key is not permitted
 - Storing repeating group of data in single row is bad.

Suppose we are designing db for online multiplayer game, where each player
can have swords, guns, armor etc.

| PlayerId |          Inventory           |
|----------|:----------------------------:| 
| player1  | 1 swords, 2 coins, 4 shields | 
| player 2 |           5 coins            | 
| player 3 |            6 guns            | 

:Problem of grouping items under 1 column. We may keep all this as a String but Querying
this data is hell. like. no. of swords of player 3.

Option 2 : Separate Columns


| PlayerId | Sword_count | Coin_count | Gun_count |
|----------|:-----------:|:----------:|:---------:|
| player1  |      1      |     3      |     4     | 
| player 2 |      0      |     4      |     5     |
| player 3 |      6      |     4      |     1     |

Problem: too many columns. (100 columns!!!)

Option 3: 

| PlayerId | Inventory type | quantity |
|----------|:--------------:| :------: |
| player 1 |     swords     | 1 | 
| player 1 |     coins      | 5 |
| player 3 |      guns      | 6 | 


## 2 NF

Each non key attribute of the table must depend on the **entire** primary key.

| PlayerId | Inventory type | quantity | rating |
|----------|:--------------:| :------: | :------: |
| player 1 |     swords     | 1 | beginner |
| player 1 |     coins      | 5 | beginner |
| player 3 |      guns      | 6 | advance |

Problem: Redundant data. Resulting in update and delete anomaly. What is I update 
just 1st row's rating not the second. What is the source of truth? What is I delete 
inventory types as player 1 doesn't have that anymore, then we will alos lose rating.

Problem: rating depends on part of Primary key, i.e playerId not the whole key i.e
playerid + inventory_type.

Thus Answer:

| PlayerId |  rating  |
|----------|:--------:| 
| player 1 | beginner |  
| player 2 | advance  |


## 3 NF
It forbids dependency of a non-key attribute on a non-key attribute.

skill level is a new requirement. Following is the mapping.
Beginner -> {1.2.3}
Intermediate -> {4,5,6}
Advance -> {7,8,9}

Add skill level of each player.

Option 1:


| PlayerId |  rating  | skill_level |
|----------|:--------:|:-----------:|
| player 1 | beginner |      1      |
| player 2 | advance  |      9      |

Problem: let's say player 1 skill's improve and updates skill to 6.
Now you have to update rating too. Update anomaly leading to inconsistent data.

Reason: non key attribute skill depends on non key attribute rating.

Solution:

| skill_level |  rating  |
|:-----------:|:--------:|
|      1      | beginner |
|      2      | beginner |
|      3      | beginner |
|      8      | advance  | 

Primary key is skill_level. Now keep skill level in player table

| PlayerId | skill_level |
|----------|:-----------:|
| player 1 |      1      |
| player 2 |      9      |

no data inconsistancy.
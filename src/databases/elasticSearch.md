- It stores data in Documents, which are not structured.
- Kibana is visualizing tool and ElasticSearch is the search engine.
- Indexes are used for searching key topics.
- Inverse indexes are used to quickly find log. e.g


|  ID | dish
|  1  | pizza maconri
|  2  | pizza makhani
|  3 | cheese burger


Inverse index can used to better the search query my words instead of full table scan using LIKE

pizza -> 1,2
burger -> 3




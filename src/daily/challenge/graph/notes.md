# Graph

- Use adjacency list is required to create a Graph and represent it's edges.
- DFS
  - maintain a visited array to check if node is already visited.
  - T.c: for every node, search for neighbour and explore it if not visited. Each node, each edge is only
        visited once so O(V+E)
- BFS (Queue)
  - maintain a queue and visited array for level order traversal.
  - Prefer to use DFS because code is shorter.
  - T.C is same as BFS: O(V+E)

## Topoligical sort
  - Only possible in DAG
    - DFS -> Use a stack to store visited element at the time of return.
    - BFS ->  Kahn algorithm. Maintain an indegree array notifying every vetrex's indegree.
    
  - Application: Cycle detection
    - Using DFS
    - Using BFS
## Shortest distance
    - if a graph is not weighted then use BFS to find shortest distance.
    - if a graph is weighted then use Dijstra.
    - In one scenario we can even use Topoligical sort 
    - Dijkstra
    -   Works with non negative numbers, directed graph
    - MST (Minimum spanning tree) : Prims and Kruskal algorithm 
    - DSU
    
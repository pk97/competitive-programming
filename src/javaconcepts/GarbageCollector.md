# Garbage Collector in Java

## Java Memory Model    
- <p> To understand Garbage collection in Java we first need a refreshal on Java Memory Model.
    Basically Memory is divided in Heap, stack. Heap memory stores all the objects whereas stack has the
    mehod call stack and local primitive varibles and references to object. 
</p>
- <p> Each thread has it's own stack whereas Heap is a shared state</p>
-<p> Heap memory can be divided into Yound generation and Old generation, where young generation has newly created objects.
    If they are survive after garbage collector deamon runs, they are moved to long live objects list present in
    Old generation memory.
</p>
- <p> String Constant pool is part of Heap only which used specifically to create immutable Strings</p>

### Garbage Collection
<p>
Java wanted to automate deletion of Garabage values or used memory space to avoid memory leaks.
GC runs a daemon thread and finds out the memory whicha are still reachable and MARK them. In sweep phase
rest of the memory is cleared and made avaiable for allocation & compacted. To make it more efficient  GC runs 2 phases
minor and major, minor runs on Young gen and major on old.
</p>
- finialize() keyword called just before removing that object from memory. It can be used to close connections etc.




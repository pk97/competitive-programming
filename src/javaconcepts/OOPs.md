Object oriented programming

- Objects
- classes
- Polymorphsim
  - Compilte time: method overloading and operator overloading\
  - Runtime: basically method overriding where the child class overrides parent class funcationality
    - internally, in runtime JVM uses vtables to keep a map of a class and it's methods.
    - So Animal a = new Dog; a.sound(); 
    - in runtime JVM decides to call the overriden method of sound for variable a
- Inheritence
- 
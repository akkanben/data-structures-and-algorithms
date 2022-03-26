# Hash Table

## Challenge

Implement a Hashtable class with a *set()*, *get()*, *contains()*, *keys()*, and *hash()*.

### Requirements

- Create a hash table/hash map class.
- The client can add new values or replace existing values.
- The client can get values with the appropriate key.
- The client can check if a value is in the HashMap or not.
- The client can retrieve a list of all the present keys.
- The client can use the hash function to create a hash that fits within the bounds of the Hashmaps capacity.

### Tests

1. Setting a key/value to your hashtable results in the value being in the data structure
2. Retrieving based on a key returns the value stored
3. Successfully returns null for a key that does not exist in the hashtable
4. Successfully returns a list of all unique keys that exist in the hashtable
5. Successfully handle a collision within the hashtable
6. Successfully retrieve a value from a bucket within the hashtable that has a collision
7. Successfully hash a key to an in-range value


## Approach & Efficiency

To allow for generic types I used an ArrayList to hold the buckets of the hash map. Each bucket contains a linked list for collisions. The interal size of the ArrayList begins at 10 with the default constructor and doubles in size as soon as the number of elements equals the current capacity.

The time complexity for setting, getting in the HashMap is an average of O(1), in the worst case when all the elements hash to the same bucket it becomes O(N) because at that point it's basically an array. The space complexity is directly proportional to the size of N so the Big O is O(N).

## API

### Hash Map

*public HashMap()* Intantiates a HashMap with a default size of 10. This size expands internally as elements are added.

*public HashMap(int size)* Intantiates a HashMap with a defined initial size.

*public int size()* Returns the number of elements in the HashMap, this is not the capacity.

*public void set(K key, V value)* Adds an element to the HashMap in the form of a key/value pair. If the chosen key already exists in the HashMap then the chosen value will overwrite the existing value.

*public V get(K key)* Retrieves the value that matches the key if present, else returns null.

*public boolean contains(K key)* Returns true if the value is present, false if not.

*public List<K> keys()* Returns a List of keys that exist in the HashMap.

*public int hash(K key)* Returns a hashed positive integer sized to fit in within the internal capacity of the HashMap.


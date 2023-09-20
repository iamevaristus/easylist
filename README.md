# EasyList Documentation

## Features

---

- Extra List Clauses
  - .any(): Returns true or false if condition is met.
  - .where(): Returns a list of items where condition
    is met.
  - .firstOrNull(): Returns the first item in the list
    where the condition is met.
  - .lastOrNull(): Returns the last item in the list
    where the condition is met.
  - .getFirst(): Returns the first item in the list.
  - .setFirst(): Sets the first item in the list with
    given value.
  - .getLast(): Returns the last item in the list.
  - .setLast(): Sets the last item in the list with
    given value.
  - .setLength(): Sets the length of the list with
    given length.
  - .reversed(): Returns a reversed value in the list.
  - .indexWhere(): Returns the index where condition is
    met.
  - .lastIndexWhere(): Returns the last index where
    condition is met.
  - .insert(): Adds item to the list.
  - .removeWhere(): Removes an item where condition
    is met.
  - .getRange(): Gets the range of items in the list
    with the start and end values.
  - .setRange(): Sets the range of items in the list
    with the start and end values.
  - .removeRange(): Removes the list of items within
    the start and end values.
  - .fillWithItem(): Fills the list with the item with
    a start and end.

- Support for Normal Java List Clauses.

---

## Getting Started

---

```
EasyList<String> easyList = new EasyList<>();

easyList.add("Food");
easyList.add("Book");
easyList.add("Phone");
easyList.add("Bag");

boolean hasFood = easyList.any(str -> str.equals("Food"));
String book = easyList.firstOrNull(str -> str.equals("Book"));
List<String> newList = easyList.reversed();

try {
    var easyListRange = easyList.getRange(10, 15);
    System.out.println(easyListRange);
} catch (EasyListException e) {
    System.out.println(e.toString());
}

System.out.println(hasFood);
System.out.println(book);
System.out.println(newList.toString());
```

The easy list repository can be accessed here [^3].

[^1]: https://www.instagram.com/iamevaristus
[^2]: https://iamevaristus@github.io
[^3]: https://github.com/iamevaristus/easylist.git

> ---
> [!NOTE]
> EasyList works with the ideology of list in flutter.
> The concept is built on flutter list clauses and
> methods that makes it easy to render, access and
> implement lists.
> ---

> ---
> [!IMPORTANT]
> EasyList is in BETA mode. This is the first
> dependency I have created and I plan on maintaining
> it. Also, this depends on flutter list ideology.
> ---

> ---
> [!WARNING]
> Enjoy the usage of EasyList.
> 
> ---

---

## Parameters

---

```
/**
 * Add an item to the list.
 */
public void add(E item);

/**
 * Check if the list is empty.
 * @return True of False.
 */
public boolean isEmpty();

/**
 * Operator [] (getter) Gets a value with its index.
 * @param index The Index of a particular item in the list
 * @return Index
 */
public E get(int index) throws EasyListException;

/**
 * Operator [] (setter) Sets a particular index with the new value.
 * @param index The Index of the particular item in the list.
 * @param value Value to be changed.
 */
public void set(int index, E value) throws EasyListException;

/**
 * Get the first item in the list.
 * @return Item.
 */
public E getFirst() throws EasyListException;

/**
 * Sets the first item of the list to the value passed.
 * @param value Item to be set.
 */
public void setFirst(E value) throws EasyListException;

/**
 * Get the last item in the list.
 * @return Item.
 */
public E getLast() throws EasyListException;

/**
 * Set the last item in the list.
 * @param value Item to set.
 */
public void setLast(E value) throws EasyListException;

/**
 * Length of the List.
 * @return Integer... amount.
 */
public int length();

/**
 * Sets the list to the amount of length passed.
 * @param newLength Length to be set.
 */
public void setLength(int newLength) throws EasyListException;

/**
 * Adds a list of items to the list.
 * @param newList Items to be added
 */
public void addAll(List<E> newList);

/**
 * Gets the reverse of the list.
 * @return A reversed list.
 */
public List<E> reversed();

/**
 * Gets the index of the item.
 * @param element Item to get the index.
 * @return Integer.
 */
public int indexOf(E element);

/**
 * Get the index where the condition is met.
 * @param predicate Condition to be met.
 * @return Integer.
 */
public List<Integer> indexWhere(Predicate<? super E> predicate);

/**
 * Get the first index where the condition is met.
 * @param predicate Condition to be met.
 * @return Integer.
 */
public int firstIndexWhere(Predicate<? super E> predicate) throws EasyListException;

/**
 * Gets the last index where the condition is met.
 * @param predicate Conditions to be met.
 * @return Integer.
 */
public int lastIndexWhere(Predicate<? super E> predicate) throws EasyListException;

/**
 * Get the last index of the item in the list.
 * @param element Item to get.
 * @return Integer.
 */
public int lastIndexOf(E element);

/**
 * Insert an item to the list with the index and item
 * @param index Index where the item should be.
 * @param element Item to be inserted.
 */
public void insert(int index, E element) throws EasyListException;

/**
 * Insert items to the list.
 * @param index Index where the item should be added.
 * @param elements Items to be added.
 */
public void insertAll(int index, List<E> elements) throws EasyListException;

/**
 * Set the list to new items added.
 * @param index Index to start from.
 * @param elements Items to be set.
 */
public void setAll(int index, List<E> elements) throws EasyListException;

/**
 * Remove an item from the list
 * @param value Item to be removed.
 * @return True, if it is removed.
 */
public boolean remove(E value);

/**
 * Remove item from its index.
 * @param index The index of the item.
 * @return Item removed.
 */
public E removeAt(int index) throws EasyListException;

/**
 * Remove the last item in the list
 * @return Item removed.
 */
public E removeLast() throws EasyListException;

/**
 * Remove item where the condition is met.
 * @param predicate Condition to check.
 */
public E removeWhere(Predicate<? super E> predicate) throws EasyListException;

/**
 * Retain item where condition is met.
 * @param predicate Condition to meet.
 */
public void retainWhere(Predicate<? super E> predicate);

// operator +
public List<E> operatorPlus(List<E> other);

/**
 * Gets a sublist of the list.
 * @param start Which index to start.
 * @param end Where to stop.
 * @return New List
 */
public List<E> sublist(int start, int end) throws EasyListException;

/**
 * Gets the range of the items required.
 * @param start Where to start.
 * @param end Where to stop.
 * @return New List.
 */
public List<E> getRange(int start, int end) throws EasyListException;

/**
 * Set
 * @param start Integer start
 * @param end Integer end
 * @param elements Items to add
 */
public void setRange(int start, int end, List<E> elements) throws EasyListException;

/**
 * Remove the range from the list.
 * @param start Where to start.
 * @param end Where to end.
 */
public void removeRange(int start, int end) throws EasyListException;

/**
 * Apply a condition to each item in the list and return true if any item satisfies the condition.
 * @param condition The condition to be met.
 * @return True or False.
 */
public boolean any(Predicate<E> condition);

/**
 * Filter the list based on a condition and return a new list.
 * @param condition The condition to be met.
 * @return A new List
 */
public List<E> where(Predicate<E> condition);

/**
 * Get the first item that satisfies the condition, or null if none is found.
 * @param condition The condition to be met.
 * @return First item in the list that met the condition.
 */
public E firstOrNull(Predicate<E> condition);

/**
 * Get the last item that satisfies the condition, or null if none is found.
 * @param condition The condition to be met.
 * @return The last item in the list that met the condition.
 */
public E lastOrNull(Predicate<E> condition);

/**
 * Clear the list.
 */
public void clear();

/**
 * Fill the list with an item.
 * @param value Item to fill with.
 * @param start Where to start.
 * @param end Where to end.
 */
public void fillWithItem(E value, int start, int end) throws EasyListException;

/**
 * Convert List to String.
 * @return String
 */
public String toListString();
```

---

<!-- This content will not appear in the rendered
Markdown -->

**TODO**

---
- [ ] \(Optional) Open a followup issue.
- [x] Add .any() method.
- [ ] Add .anyWhere() method.
- [ ] Add .isNotNull() method.
- [ ] Add delight to the experience when all tasks
are complete

[//]: # ([EasyList Main]&#40;)

[//]: # (    /EasyList.java)

[//]: # (&#41;)

[//]: # (H<sub>2</sub>0)

[//]: # (H<sup>2</sup>0)
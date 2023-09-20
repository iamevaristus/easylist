package com.easylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public abstract class EasyListImplementation<E> implements EasyListService<E> {

    private final List<E> list;

    public EasyListImplementation() {
        this.list = new ArrayList<>();
    }

    /**
     * Get all items in the list.
     * @return List.
     */
    public List<E> getList() {
        return this.list;
    }

    @Override
    public void add(E item) {
        this.list.add(item);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public E get(int index) throws EasyListException {
        if (index < 0 || index >= length()) {
            throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
        }
        return list.get(index);
    }

    @Override
    public void set(int index, E value) throws EasyListException {
        if (index < 0 || index >= length()) {
            throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
        }
        list.set(index, value);
    }

    @Override
    public E getFirst() throws EasyListException {
        if(isEmpty()) {
            throw new EasyListException(EasyListException.LIST_IS_EMPTY);
        } else {
            return get(0);
        }
    }

    @Override
    public void setFirst(E value) throws EasyListException {
        if(isEmpty()) {
            throw new EasyListException(EasyListException.LIST_IS_EMPTY);
        } else {
            set(0, value);
        }
    }

    @Override
    public E getLast() throws EasyListException {
        if(isEmpty()) {
            throw new EasyListException(EasyListException.LIST_IS_EMPTY);
        } else {
            return get(length() - 1);
        }
    }

    @Override
    public void setLast(E value) throws EasyListException {
        if(isEmpty()) {
            throw new EasyListException(EasyListException.LIST_IS_EMPTY);
        } else {
            set(length() - 1, value);
        }
    }

    @Override
    public void setLength(int newLength) throws EasyListException {
        if(newLength < 0) {
            throw new EasyListException(EasyListException.NEW_LENGTH_MUST_BE_NON_NEGATIVE);
        }

        int currentLength = length();
        if(newLength > currentLength) {
            for(int i = currentLength; i < newLength; i++) {
                add(null);
            }
        } else {
            sublist(newLength, currentLength).clear();
        }
    }

    @Override
    public void addAll(List<E> newList) {
        list.addAll(newList);
    }

    @Override
    public List<E> reversed() {
        List<E> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }

    @Override
    public int indexOf(E element) {
        return list.indexOf(element);
    }

    @Override
    public int indexWhere(Predicate<? super E> predicate) throws EasyListException {
        for (int i = 0; i < length(); i++) {
            if (predicate.test(get(i))) {
                return i;
            }
        }
        throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
    }

    @Override
    public int lastIndexWhere(Predicate<? super E> predicate) throws EasyListException {
        for (int i = length() - 1; i > 0; i--) {
            if (predicate.test(get(i))) {
                return i;
            }
        }
        throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
    }

    @Override
    public int lastIndexOf(E element) {
        return list.lastIndexOf(element);
    }

    @Override
    public void insert(int index, E element) throws EasyListException {
        if (index < 0 || index > length()) {
            throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
        }

        list.add(index, element);
    }

    @Override
    public void insertAll(int index, List<E> elements) throws EasyListException {
        if (index < 0 || index > length()) {
            throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
        }

        list.addAll(index, elements);
    }

    @Override
    public void setAll(int index, List<E> elements) throws EasyListException {
        if (index < 0 || index + elements.size() > length()) {
            throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
        }
        List<E> subList = new ArrayList<>(elements);
        for (int i = 0; i < subList.size(); i++) {
            list.set(index + i, subList.get(i));
        }
    }

    @Override
    public boolean remove(E value) {
        return list.remove(value);
    }

    @Override
    public E removeAt(int index) throws EasyListException {
        if (index < 0 || index > length()) {
            throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
        }

        return list.remove(index);
    }

    @Override
    public E removeLast() throws EasyListException {
        if (isEmpty()) {
            throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
        }

        return list.remove(length() - 1);
    }

    @Override
    public E removeWhere(Predicate<? super E> predicate) throws EasyListException {
        for (int i = 0; i < length(); i++) {
            if (predicate.test(get(i))) {
                return removeAt(i);
            }
        }
        // list.removeIf(predicate);
        throw new EasyListException(EasyListException.INDEX_OUT_OF_BOUNDS);
    }

    @Override
    public void retainWhere(Predicate<? super E> predicate) {
        list.retainAll(list.stream().filter(predicate).toList());
    }

    @Override
    public List<E> operatorPlus(List<E> other) {
        List<E> result = new ArrayList<>(list);
        result.addAll(other);
        return result;
    }

    @Override
    public List<E> sublist(int start, int end) throws EasyListException {
        if (start < 0 || start > end || end > length()) {
            throw new EasyListException(EasyListException.INVALID_START_OR_END);
        }
        return list.subList(start, end);
    }

    @Override
    public List<E> getRange(int start, int end) throws EasyListException {
        if (start < 0 || start > end || end > length()) {
            throw new EasyListException(EasyListException.INVALID_START_OR_END);
        }
        return new ArrayList<>(list.subList(start, end));
    }

    @Override
    public void setRange(int start, int end, List<E> elements) throws EasyListException {
        if (start < 0 || start > end || end > list.size() || start + elements.size() != end) {
            throw new EasyListException(EasyListException.INVALID_START_OR_END);
        }

        int i = 0;
        for(int index = start; index < end; index++) {
            list.set(index, elements.get(i++));
        }
    }

    @Override
    public void removeRange(int start, int end) throws EasyListException {
        if (start < 0 || start > end || end > list.size()) {
            throw new EasyListException(EasyListException.INVALID_START_OR_END);
        }
        list.subList(start, end).clear();
    }

    @Override
    public boolean any(Predicate<E> condition) {
        for(E item : list) {
            if(condition.test(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<E> where(Predicate<E> condition) {
        List<E> result = new ArrayList<>();

        for(E item : list) {
            if(condition.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    @Override
    public E firstOrNull(Predicate<E> condition) {
        for(E item : list) {
            if(condition.test(item)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public E lastOrNull(Predicate<E> condition) {
        for(int i = length() - 1; i >= 0; i--) {
            E item = list.get(i);

            if(condition.test(item)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void fillWithItem(E value, int start, int end) throws EasyListException {
        if (start < 0 || start > end || end > length()) {
            throw new EasyListException(EasyListException.INVALID_START_OR_END);
        }

        for(int index = start; index < end; index++) {
            set(index, value);
        }
    }

    @Override
    public String toListString() {
        return list.toString();
    }
}

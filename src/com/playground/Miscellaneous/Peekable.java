package com.playground.Miscellaneous;

import java.util.Iterator;

public class Peekable<T> implements Iterator<T> {

    private final Iterator<T> iterator;
    private boolean isPeak = false;
    private T nextPeek = null;

    public Peekable(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public T next() {
        if (isPeak) {
            isPeak = false;
            return peek();
        }
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public T peek() {
        if (hasNext()) {
            if (isPeak == false) {
                nextPeek = next();
                isPeak = true;
            }
        } else {
            nextPeek = null;
        }
        return nextPeek;
    }

}

package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes3.dex */
final class a<T> implements Iterator<T>, kotlin.jvm.internal.a.a {

    /* renamed from: a */
    private int f28536a;

    /* renamed from: b */
    private final T[] f28537b;

    public a(T[] tArr) {
        h.b(tArr, "array");
        this.f28537b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f28536a < this.f28537b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f28537b;
            int i = this.f28536a;
            this.f28536a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f28536a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

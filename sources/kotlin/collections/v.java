package kotlin.collections;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public abstract class v implements Iterator<Integer>, kotlin.jvm.internal.a.a {
    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}

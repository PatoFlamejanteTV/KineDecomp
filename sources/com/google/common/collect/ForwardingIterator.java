package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract Iterator<T> delegate();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return delegate().hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        return delegate().next();
    }

    @Override // java.util.Iterator
    public void remove() {
        delegate().remove();
    }
}

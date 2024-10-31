package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
/* loaded from: classes2.dex */
public interface PeekingIterator<E> extends Iterator<E> {
    E a();

    @Override // java.util.Iterator
    E next();
}

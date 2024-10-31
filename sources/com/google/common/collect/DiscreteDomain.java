package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.Comparable;
import java.util.NoSuchElementException;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class DiscreteDomain<C extends Comparable> {
    public abstract long a(C c, C c2);

    public abstract C a(C c);

    public abstract C b(C c);

    protected DiscreteDomain() {
    }

    public C a() {
        throw new NoSuchElementException();
    }

    public C b() {
        throw new NoSuchElementException();
    }
}

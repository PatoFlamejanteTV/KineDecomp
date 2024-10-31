package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class Ranges {
    private Ranges() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Range<C> a(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> a(C c, C c2) {
        return a(Cut.belowValue(c), Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> a(C c, BoundType boundType, C c2, BoundType boundType2) {
        Preconditions.a(boundType);
        Preconditions.a(boundType2);
        return a(boundType == BoundType.OPEN ? Cut.aboveValue(c) : Cut.belowValue(c), boundType2 == BoundType.OPEN ? Cut.belowValue(c2) : Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> a(C c) {
        return a(Cut.belowAll(), Cut.belowValue(c));
    }

    public static <C extends Comparable<?>> Range<C> b(C c) {
        return a(Cut.belowAll(), Cut.aboveValue(c));
    }

    public static <C extends Comparable<?>> Range<C> a(C c, BoundType boundType) {
        switch (boundType) {
            case OPEN:
                return a(c);
            case CLOSED:
                return b(c);
            default:
                throw new AssertionError();
        }
    }

    public static <C extends Comparable<?>> Range<C> c(C c) {
        return a(Cut.aboveValue(c), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> d(C c) {
        return a(Cut.belowValue(c), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> b(C c, BoundType boundType) {
        switch (boundType) {
            case OPEN:
                return c(c);
            case CLOSED:
                return d(c);
            default:
                throw new AssertionError();
        }
    }
}

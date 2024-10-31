package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
    private static final long serialVersionUID = 0;
    final C endpoint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void describeAsLowerBound(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void describeAsUpperBound(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C greatestValueBelow(DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isLessThan(C c);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C leastValueAbove(DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType typeAsLowerBound();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType typeAsUpperBound();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    Cut(@Nullable C c) {
        this.endpoint = c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
        return this;
    }

    @Override // java.lang.Comparable
    public int compareTo(Cut<C> cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        int compareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
        return compareOrThrow == 0 ? Booleans.a(this instanceof AboveValue, cut instanceof AboveValue) : compareOrThrow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            return compareTo((Cut) obj) == 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.f2672a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class BelowAll extends Cut<Comparable<?>> {

        /* renamed from: a, reason: collision with root package name */
        private static final BelowAll f2672a = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super(null);
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.a();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return Cut.belowValue(discreteDomain.a());
            } catch (NoSuchElementException e) {
                return this;
            }
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        private Object readResolve() {
            return f2672a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.f2671a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class AboveAll extends Cut<Comparable<?>> {

        /* renamed from: a, reason: collision with root package name */
        private static final AboveAll f2671a = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super(null);
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.b();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        private Object readResolve() {
            return f2671a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> belowValue(C c) {
        return new BelowValue(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        BelowValue(C c) {
            super((Comparable) Preconditions.a(c));
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C c) {
            return Range.compareOrThrow(this.endpoint, c) <= 0;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            switch (boundType) {
                case CLOSED:
                    return this;
                case OPEN:
                    C b = discreteDomain.b(this.endpoint);
                    return b == null ? Cut.belowAll() : new AboveValue<>(b);
                default:
                    throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            switch (boundType) {
                case CLOSED:
                    C b = discreteDomain.b(this.endpoint);
                    return b == null ? Cut.aboveAll() : new AboveValue(b);
                case OPEN:
                    return this;
                default:
                    throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append('[').append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint).append(')');
        }

        @Override // com.google.common.collect.Cut
        C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.b(this.endpoint);
        }

        public int hashCode() {
            return this.endpoint.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> aboveValue(C c) {
        return new AboveValue(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        AboveValue(C c) {
            super((Comparable) Preconditions.a(c));
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C c) {
            return Range.compareOrThrow(this.endpoint, c) < 0;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            switch (boundType) {
                case CLOSED:
                    C a2 = discreteDomain.a(this.endpoint);
                    return a2 == null ? Cut.belowAll() : belowValue(a2);
                case OPEN:
                    return this;
                default:
                    throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            switch (boundType) {
                case CLOSED:
                    return this;
                case OPEN:
                    C a2 = discreteDomain.a(this.endpoint);
                    return a2 == null ? Cut.aboveAll() : belowValue(a2);
                default:
                    throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append('(').append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint).append(']');
        }

        @Override // com.google.common.collect.Cut
        C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.a(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
            C leastValueAbove = leastValueAbove(discreteDomain);
            return leastValueAbove != null ? belowValue(leastValueAbove) : Cut.aboveAll();
        }

        public int hashCode() {
            return this.endpoint.hashCode() ^ (-1);
        }
    }
}

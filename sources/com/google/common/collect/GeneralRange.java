package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes.dex */
public final class GeneralRange<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private transient GeneralRange<T> f2682a;
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @Nullable
    private final T lowerEndpoint;
    private final BoundType upperBoundType;

    @Nullable
    private final T upperEndpoint;

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, @Nullable T t, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, @Nullable T t, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator, @Nullable T t, BoundType boundType, @Nullable T t2, BoundType boundType2) {
        return new GeneralRange<>(comparator, true, t, boundType, true, t2, boundType2);
    }

    private GeneralRange(Comparator<? super T> comparator, boolean z, @Nullable T t, BoundType boundType, boolean z2, @Nullable T t2, BoundType boundType2) {
        this.comparator = (Comparator) Preconditions.a(comparator);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) Preconditions.a(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) Preconditions.a(boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            Preconditions.a(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                Preconditions.a((boundType != BoundType.OPEN) | (boundType2 != BoundType.OPEN));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tooLow(@Nullable T t) {
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getLowerEndpoint());
        return (compare < 0) | ((compare == 0) & (getLowerBoundType() == BoundType.OPEN));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tooHigh(@Nullable T t) {
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getUpperEndpoint());
        return (compare > 0) | ((compare == 0) & (getUpperBoundType() == BoundType.OPEN));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean contains(@Nullable T t) {
        return (tooLow(t) || tooHigh(t)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        int compare;
        int compare2;
        BoundType boundType;
        T t;
        int compare3;
        Preconditions.a(generalRange);
        Preconditions.a(this.comparator.equals(generalRange.comparator));
        boolean z = this.hasLowerBound;
        T lowerEndpoint = getLowerEndpoint();
        BoundType lowerBoundType = getLowerBoundType();
        if (!hasLowerBound()) {
            z = generalRange.hasLowerBound;
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((compare = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        }
        boolean z2 = this.hasUpperBound;
        T upperEndpoint = getUpperEndpoint();
        BoundType upperBoundType = getUpperBoundType();
        if (!hasUpperBound()) {
            z2 = generalRange.hasUpperBound;
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        }
        if (z && z2 && ((compare3 = this.comparator.compare(lowerEndpoint, upperEndpoint)) > 0 || (compare3 == 0 && lowerBoundType == BoundType.OPEN && upperBoundType == BoundType.OPEN))) {
            BoundType boundType2 = BoundType.OPEN;
            upperBoundType = BoundType.CLOSED;
            boundType = boundType2;
            t = upperEndpoint;
        } else {
            boundType = lowerBoundType;
            t = lowerEndpoint;
        }
        return new GeneralRange<>(this.comparator, z, t, boundType, z2, upperEndpoint, upperBoundType);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && Objects.a(getLowerEndpoint(), generalRange.getLowerEndpoint()) && Objects.a(getUpperEndpoint(), generalRange.getUpperEndpoint());
    }

    public int hashCode() {
        return Objects.a(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.f2682a;
        if (generalRange == null) {
            GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
            generalRange2.f2682a = this;
            this.f2682a = generalRange2;
            return generalRange2;
        }
        return generalRange;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator).append(":");
        switch (getLowerBoundType()) {
            case CLOSED:
                sb.append('[');
                break;
            case OPEN:
                sb.append('(');
                break;
        }
        if (hasLowerBound()) {
            sb.append(getLowerEndpoint());
        } else {
            sb.append("-∞");
        }
        sb.append(',');
        if (hasUpperBound()) {
            sb.append(getUpperEndpoint());
        } else {
            sb.append("∞");
        }
        switch (getUpperBoundType()) {
            case CLOSED:
                sb.append(']');
                break;
            case OPEN:
                sb.append(')');
                break;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}

package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Comparator;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class ElementOrder<T> {

    /* renamed from: a */
    private final Type f15916a;

    /* renamed from: b */
    @Nullable
    private final Comparator<T> f15917b;

    /* loaded from: classes2.dex */
    public enum Type {
        UNORDERED,
        INSERTION,
        SORTED
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        return this.f15916a == elementOrder.f15916a && Objects.a(this.f15917b, elementOrder.f15917b);
    }

    public int hashCode() {
        return Objects.a(this.f15916a, this.f15917b);
    }

    public String toString() {
        MoreObjects.ToStringHelper a2 = MoreObjects.a(this).a("type", this.f15916a);
        Comparator<T> comparator = this.f15917b;
        if (comparator != null) {
            a2.a("comparator", comparator);
        }
        return a2.toString();
    }
}

package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes.dex */
public final class Absent extends Optional<Object> {
    static final Absent INSTANCE = new Absent();
    private static final long serialVersionUID = 0;

    Absent() {
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public Object get() {
        throw new IllegalStateException("value is absent");
    }

    @Override // com.google.common.base.Optional
    public Object or(Object obj) {
        return Preconditions.a(obj, "use orNull() instead of or(null)");
    }

    @Override // com.google.common.base.Optional
    public Optional<Object> or(Optional<? extends Object> optional) {
        return (Optional) Preconditions.a(optional);
    }

    @Override // com.google.common.base.Optional
    public Object or(Supplier<? extends Object> supplier) {
        return Preconditions.a(supplier.get(), "use orNull() instead of a Supplier that returns null");
    }

    @Override // com.google.common.base.Optional
    @Nullable
    public Object orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public Set<Object> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(Function<Object, V> function) {
        Preconditions.a(function);
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(@Nullable Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 1502476572;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

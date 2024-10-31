package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Present(T t) {
        this.reference = t;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        Preconditions.a(t, "use orNull() instead of or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        Preconditions.a(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(Supplier<? extends T> supplier) {
        Preconditions.a(supplier);
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        return new Present(Preconditions.a(function.apply(this.reference), "Transformation function cannot return null."));
    }

    @Override // com.google.common.base.Optional
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 1502476572 + this.reference.hashCode();
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}

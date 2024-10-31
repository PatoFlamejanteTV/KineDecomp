package kotlin;

import java.io.Serializable;

/* compiled from: Lazy.kt */
/* loaded from: classes.dex */
public final class InitializedLazyImpl<T> implements d<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // kotlin.d
    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}

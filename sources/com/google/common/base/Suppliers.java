package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Suppliers {
    private Suppliers() {
    }

    public static <T> Supplier<T> a(@Nullable T t) {
        return new SupplierOfInstance(t);
    }

    /* loaded from: classes2.dex */
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        SupplierOfInstance(@Nullable T t) {
            this.instance = t;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.instance;
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }
}

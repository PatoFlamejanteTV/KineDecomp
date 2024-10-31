package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public abstract class TypeParameter<T> extends f<T> {

    /* renamed from: a */
    final TypeVariable<?> f16062a;

    protected TypeParameter() {
        Type capture = capture();
        Preconditions.a(capture instanceof TypeVariable, "%s should be a type variable.", capture);
        this.f16062a = (TypeVariable) capture;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeParameter) {
            return this.f16062a.equals(((TypeParameter) obj).f16062a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f16062a.hashCode();
    }

    public String toString() {
        return this.f16062a.toString();
    }
}

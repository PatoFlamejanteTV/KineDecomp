package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

@Beta
/* loaded from: classes2.dex */
public abstract class TypeParameter<T> extends a<T> {

    /* renamed from: a, reason: collision with root package name */
    final TypeVariable<?> f2935a;

    protected TypeParameter() {
        Type capture = capture();
        Preconditions.a(capture instanceof TypeVariable, "%s should be a type variable.", capture);
        this.f2935a = (TypeVariable) capture;
    }

    public final int hashCode() {
        return this.f2935a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeParameter) {
            return this.f2935a.equals(((TypeParameter) obj).f2935a);
        }
        return false;
    }

    public String toString() {
        return this.f2935a.toString();
    }
}

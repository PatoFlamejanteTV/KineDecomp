package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: TypeVisitor.java */
@NotThreadSafe
/* loaded from: classes2.dex */
public abstract class r {

    /* renamed from: a */
    private final Set<Type> f16104a = Sets.a();

    void a(Class<?> cls) {
    }

    void a(GenericArrayType genericArrayType) {
    }

    void a(ParameterizedType parameterizedType) {
    }

    abstract void a(TypeVariable<?> typeVariable);

    abstract void a(WildcardType wildcardType);

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.f16104a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        a((TypeVariable<?>) type);
                    } else if (type instanceof WildcardType) {
                        a((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        a((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        a((Class<?>) type);
                    } else if (type instanceof GenericArrayType) {
                        a((GenericArrayType) type);
                    } else {
                        throw new AssertionError("Unknown type: " + type);
                    }
                } catch (Throwable th) {
                    this.f16104a.remove(type);
                    throw th;
                }
            }
        }
    }
}

package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Types.java */
/* loaded from: classes2.dex */
public class t extends r {

    /* renamed from: b */
    final /* synthetic */ AtomicReference f16105b;

    public t(AtomicReference atomicReference) {
        this.f16105b = atomicReference;
    }

    @Override // com.google.common.reflect.r
    void a(TypeVariable<?> typeVariable) {
        Type b2;
        AtomicReference atomicReference = this.f16105b;
        b2 = Types.b(typeVariable.getBounds());
        atomicReference.set(b2);
    }

    @Override // com.google.common.reflect.r
    void a(WildcardType wildcardType) {
        Type b2;
        AtomicReference atomicReference = this.f16105b;
        b2 = Types.b(wildcardType.getUpperBounds());
        atomicReference.set(b2);
    }

    @Override // com.google.common.reflect.r
    void a(GenericArrayType genericArrayType) {
        this.f16105b.set(genericArrayType.getGenericComponentType());
    }

    @Override // com.google.common.reflect.r
    void a(Class<?> cls) {
        this.f16105b.set(cls.getComponentType());
    }
}

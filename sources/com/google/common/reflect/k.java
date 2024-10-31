package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
class k extends r {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ TypeToken f16097b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TypeToken typeToken) {
        this.f16097b = typeToken;
    }

    @Override // com.google.common.reflect.r
    void a(TypeVariable<?> typeVariable) {
        throw new IllegalArgumentException(this.f16097b.runtimeType + "contains a type variable and is not safe for the operation");
    }

    @Override // com.google.common.reflect.r
    void a(WildcardType wildcardType) {
        a(wildcardType.getLowerBounds());
        a(wildcardType.getUpperBounds());
    }

    @Override // com.google.common.reflect.r
    void a(ParameterizedType parameterizedType) {
        a(parameterizedType.getActualTypeArguments());
        a(parameterizedType.getOwnerType());
    }

    @Override // com.google.common.reflect.r
    void a(GenericArrayType genericArrayType) {
        a(genericArrayType.getGenericComponentType());
    }
}

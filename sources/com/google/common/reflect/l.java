package com.google.common.reflect;

import com.google.common.collect.ImmutableSet;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
public class l extends r {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImmutableSet.Builder f16098b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TypeToken f16099c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TypeToken typeToken, ImmutableSet.Builder builder) {
        this.f16099c = typeToken;
        this.f16098b = builder;
    }

    @Override // com.google.common.reflect.r
    void a(TypeVariable<?> typeVariable) {
        a(typeVariable.getBounds());
    }

    @Override // com.google.common.reflect.r
    void a(WildcardType wildcardType) {
        a(wildcardType.getUpperBounds());
    }

    @Override // com.google.common.reflect.r
    void a(ParameterizedType parameterizedType) {
        this.f16098b.a((ImmutableSet.Builder) parameterizedType.getRawType());
    }

    @Override // com.google.common.reflect.r
    void a(Class<?> cls) {
        this.f16098b.a((ImmutableSet.Builder) cls);
    }

    @Override // com.google.common.reflect.r
    void a(GenericArrayType genericArrayType) {
        this.f16098b.a((ImmutableSet.Builder) Types.a((Class<?>) TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
    }
}

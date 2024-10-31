package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeResolver;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeResolver.java */
/* loaded from: classes2.dex */
public class g extends r {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f16090b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Type f16091c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Map map, Type type) {
        this.f16090b = map;
        this.f16091c = type;
    }

    @Override // com.google.common.reflect.r
    void a(TypeVariable<?> typeVariable) {
        this.f16090b.put(new TypeResolver.c(typeVariable), this.f16091c);
    }

    @Override // com.google.common.reflect.r
    void a(WildcardType wildcardType) {
        Type type = this.f16091c;
        if (type instanceof WildcardType) {
            WildcardType wildcardType2 = (WildcardType) type;
            Type[] upperBounds = wildcardType.getUpperBounds();
            Type[] upperBounds2 = wildcardType2.getUpperBounds();
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] lowerBounds2 = wildcardType2.getLowerBounds();
            Preconditions.a(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f16091c);
            for (int i = 0; i < upperBounds.length; i++) {
                TypeResolver.b(this.f16090b, upperBounds[i], upperBounds2[i]);
            }
            for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                TypeResolver.b(this.f16090b, lowerBounds[i2], lowerBounds2[i2]);
            }
        }
    }

    @Override // com.google.common.reflect.r
    void a(ParameterizedType parameterizedType) {
        Object b2;
        Type type = this.f16091c;
        if (type instanceof WildcardType) {
            return;
        }
        b2 = TypeResolver.b(ParameterizedType.class, type);
        ParameterizedType parameterizedType2 = (ParameterizedType) b2;
        if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
            TypeResolver.b(this.f16090b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
        }
        Preconditions.a(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f16091c);
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        Preconditions.a(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
        for (int i = 0; i < actualTypeArguments.length; i++) {
            TypeResolver.b(this.f16090b, actualTypeArguments[i], actualTypeArguments2[i]);
        }
    }

    @Override // com.google.common.reflect.r
    void a(GenericArrayType genericArrayType) {
        Type type = this.f16091c;
        if (type instanceof WildcardType) {
            return;
        }
        Type a2 = Types.a(type);
        Preconditions.a(a2 != null, "%s is not an array type.", this.f16091c);
        TypeResolver.b(this.f16090b, genericArrayType.getGenericComponentType(), a2);
    }

    @Override // com.google.common.reflect.r
    void a(Class<?> cls) {
        if (this.f16091c instanceof WildcardType) {
            return;
        }
        throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f16091c);
    }
}

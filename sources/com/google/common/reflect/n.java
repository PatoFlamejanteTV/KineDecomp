package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import javax.annotation.Nullable;

/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
class n extends TypeToken.b<TypeToken<?>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Iterable<? extends TypeToken<?>> b(TypeToken<?> typeToken) {
        return typeToken.getGenericInterfaces();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Class<?> c(TypeToken<?> typeToken) {
        return typeToken.getRawType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    @Nullable
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public TypeToken<?> d(TypeToken<?> typeToken) {
        return typeToken.getGenericSuperclass();
    }
}

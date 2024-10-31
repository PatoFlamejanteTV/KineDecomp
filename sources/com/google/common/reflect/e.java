package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import javax.annotation.Nullable;

/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
final class e extends TypeToken.a<TypeToken<?>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Class<?> b(TypeToken<?> typeToken) {
        return typeToken.getRawType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.a
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Iterable<? extends TypeToken<?>> c(TypeToken<?> typeToken) {
        return typeToken.getGenericInterfaces();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.a
    @Nullable
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public TypeToken<?> d(TypeToken<?> typeToken) {
        return typeToken.getGenericSuperclass();
    }
}

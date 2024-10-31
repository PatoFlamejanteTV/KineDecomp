package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
final class f extends TypeToken.a<Class<?>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Class<?> b(Class<?> cls) {
        return cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.a
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Iterable<? extends Class<?>> c(Class<?> cls) {
        return Arrays.asList(cls.getInterfaces());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.a
    @Nullable
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Class<?> d(Class<?> cls) {
        return cls.getSuperclass();
    }
}

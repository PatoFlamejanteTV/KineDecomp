package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeCapture.java */
/* loaded from: classes2.dex */
abstract class a<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Preconditions.a(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}

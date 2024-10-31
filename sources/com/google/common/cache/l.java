package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* compiled from: Striped64.java */
/* loaded from: classes2.dex */
final class l implements PrivilegedExceptionAction<Unsafe> {
    @Override // java.security.PrivilegedExceptionAction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Unsafe run() throws Exception {
        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
        declaredField.setAccessible(true);
        return (Unsafe) declaredField.get(null);
    }
}

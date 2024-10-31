package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class ObjectArrays {

    /* renamed from: a */
    static final Object[] f15629a = new Object[0];

    private ObjectArrays() {
    }

    @GwtIncompatible
    public static <T> T[] a(Class<T> cls, int i) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    @CanIgnoreReturnValue
    public static Object[] b(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    public static <T> T[] c(T[] tArr, int i) {
        return (T[]) C1497cb.a(tArr, i);
    }

    public static <T> T[] a(T[] tArr, int i) {
        T[] tArr2 = (T[]) c(tArr, i);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(tArr.length, i));
        return tArr2;
    }

    public static <T> T[] a(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) c(tArr, size);
        }
        a((Iterable<?>) collection, (Object[]) tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    @CanIgnoreReturnValue
    private static Object[] a(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    @CanIgnoreReturnValue
    public static Object[] a(Object... objArr) {
        b(objArr, objArr.length);
        return objArr;
    }

    @CanIgnoreReturnValue
    public static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}

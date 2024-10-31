package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
/* loaded from: classes2.dex */
public final class ObjectArrays {

    /* renamed from: a, reason: collision with root package name */
    static final Object[] f2748a = new Object[0];

    private ObjectArrays() {
    }

    public static <T> T[] a(T[] tArr, int i) {
        return (T[]) cp.a(tArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] b(T[] tArr, int i) {
        T[] tArr2 = (T[]) a((Object[]) tArr, i);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(tArr.length, i));
        return tArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) a((Object[]) tArr, size);
        }
        a((Iterable<?>) collection, (Object[]) tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] a(Collection<?> collection) {
        return a((Iterable<?>) collection, new Object[collection.size()]);
    }

    private static Object[] a(Iterable<?> iterable, Object[] objArr) {
        int i = 0;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException("at index " + i);
        }
        return obj;
    }
}

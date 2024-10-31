package com.nexstreaming.app.general.util;

import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* compiled from: RefUtil.java */
/* loaded from: classes2.dex */
public class D {
    public static <K, V> void a(Map<K, WeakReference<V>> map) {
        Iterator<Map.Entry<K, WeakReference<V>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<V> value = it.next().getValue();
            if (value == null || value.get() == null) {
                it.remove();
            }
        }
    }

    public static <T> void a(SparseArray<WeakReference<T>> sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        while (i < size) {
            WeakReference<T> valueAt = sparseArray.valueAt(i);
            if (valueAt == null || valueAt.get() == null) {
                sparseArray.removeAt(i);
                size--;
                i--;
            }
            i++;
        }
    }
}

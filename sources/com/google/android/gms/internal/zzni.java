package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class zzni {
    public static <T> boolean zza(List<T> list, List<T> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!list2.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}

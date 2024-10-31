package com.nexstreaming.app.general.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: Ints.java */
/* loaded from: classes2.dex */
public final class q {
    public static final int[] a(Collection<Integer> collection) {
        if (collection == null) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            Integer next = it.next();
            int i2 = i + 1;
            iArr[i] = next == null ? 0 : next.intValue();
            i = i2;
        }
        return iArr;
    }

    public static final List<Integer> a(int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}

package com.nexstreaming.app.general.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: Floats.java */
/* renamed from: com.nexstreaming.app.general.util.l */
/* loaded from: classes2.dex */
public final class C1708l {
    public static final float[] a(Collection<Float> collection) {
        int i = 0;
        if (collection == null) {
            return new float[0];
        }
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            int i2 = i + 1;
            fArr[i] = next == null ? 0.0f : next.floatValue();
            i = i2;
        }
        return fArr;
    }

    public static final List<Float> a(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }
}

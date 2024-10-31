package com.nexstreaming.app.general.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: Floats.java */
/* loaded from: classes.dex */
public final class h {
    public static final float[] a(Collection<Float> collection) {
        if (collection == null) {
            return new float[0];
        }
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i = 0;
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
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }
}

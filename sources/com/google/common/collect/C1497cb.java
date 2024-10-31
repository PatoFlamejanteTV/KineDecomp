package com.google.common.collect;

import java.lang.reflect.Array;

/* compiled from: Platform.java */
/* renamed from: com.google.common.collect.cb */
/* loaded from: classes2.dex */
final class C1497cb {
    public static <T> T[] a(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    public static MapMaker a(MapMaker mapMaker) {
        return mapMaker.g();
    }
}

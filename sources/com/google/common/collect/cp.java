package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;

/* compiled from: Platform.java */
@GwtCompatible
/* loaded from: classes2.dex */
class cp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(T[] tArr) {
        return (T[]) ((Object[]) tArr.clone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapMaker a(MapMaker mapMaker) {
        return mapMaker.f();
    }
}

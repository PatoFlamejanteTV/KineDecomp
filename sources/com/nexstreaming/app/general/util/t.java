package com.nexstreaming.app.general.util;

import java.util.Iterator;

/* compiled from: IterUtil.java */
/* loaded from: classes2.dex */
public class t {
    public static <T> Iterable<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return new r(iterable, iterable2);
    }

    public static <T> Iterator<T> a(Iterator<? extends T> it, Iterator<? extends T> it2) {
        return new s(it, it2);
    }
}

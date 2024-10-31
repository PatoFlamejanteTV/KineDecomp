package com.google.common.collect;

import com.google.common.collect.AbstractIterator;

/* compiled from: AbstractIterator.java */
/* renamed from: com.google.common.collect.c */
/* loaded from: classes2.dex */
public /* synthetic */ class C1495c {

    /* renamed from: a */
    static final /* synthetic */ int[] f15769a = new int[AbstractIterator.State.values().length];

    static {
        try {
            f15769a[AbstractIterator.State.DONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15769a[AbstractIterator.State.READY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

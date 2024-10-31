package com.google.common.base;

import com.google.common.base.AbstractIterator;

/* compiled from: AbstractIterator.java */
/* loaded from: classes2.dex */
public /* synthetic */ class a {

    /* renamed from: a */
    static final /* synthetic */ int[] f15126a = new int[AbstractIterator.State.values().length];

    static {
        try {
            f15126a[AbstractIterator.State.READY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15126a[AbstractIterator.State.DONE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

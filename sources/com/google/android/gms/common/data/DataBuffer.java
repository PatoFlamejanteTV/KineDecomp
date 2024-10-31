package com.google.android.gms.common.data;

import com.google.android.gms.common.api.Releasable;

/* loaded from: classes.dex */
public interface DataBuffer<T> extends Releasable, Iterable<T> {
    int a();

    T a(int i);
}

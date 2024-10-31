package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.rl, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1073rl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ C1115ul f12499a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ C1032ol f12500b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1073rl(C1032ol c1032ol, C1115ul c1115ul) {
        this.f12500b = c1032ol;
        this.f12499a = c1115ul;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        this.f12499a.a();
        sparseArray = this.f12500b.p;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray2 = this.f12500b.p;
            ((zzls) sparseArray2.valueAt(i)).disable();
        }
    }
}

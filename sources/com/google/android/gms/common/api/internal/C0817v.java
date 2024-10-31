package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0817v extends zabr {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<zaaw> f10860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0817v(zaaw zaawVar) {
        this.f10860a = new WeakReference<>(zaawVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void a() {
        zaaw zaawVar = this.f10860a.get();
        if (zaawVar == null) {
            return;
        }
        zaawVar.o();
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class E implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaft f11479a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(zzaft zzaftVar) {
        this.f11479a = zzaftVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11479a.disconnect();
    }
}

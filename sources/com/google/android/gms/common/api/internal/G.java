package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
final class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.signin.internal.zaj f10737a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zace f10738b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(zace zaceVar, com.google.android.gms.signin.internal.zaj zajVar) {
        this.f10738b = zaceVar;
        this.f10737a = zajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10738b.b(this.f10737a);
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.ql, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1060ql implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ C1032ol f12470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1060ql(C1032ol c1032ol) {
        this.f12470a = c1032ol;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzln zzlnVar;
        z = this.f12470a.H;
        if (z) {
            return;
        }
        zzlnVar = this.f12470a.q;
        zzlnVar.zza((zzln) this.f12470a);
    }
}

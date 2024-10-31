package com.google.android.gms.internal;

/* loaded from: classes.dex */
final class cy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgv f1491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(zzgv zzgvVar) {
        this.f1491a = zzgvVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1491a.zzfT();
        if (this.f1491a.zzfR() != null) {
            this.f1491a.zzfR().release();
        }
    }
}

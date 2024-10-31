package com.google.android.gms.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhz f1504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(zzhz zzhzVar) {
        this.f1504a = zzhzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1504a.zzIl = Thread.currentThread();
        this.f1504a.zzbn();
    }
}

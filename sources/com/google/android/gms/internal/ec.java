package com.google.android.gms.internal;

import com.google.android.gms.internal.zzip;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
final class ec implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzin f1522a;
    final /* synthetic */ zzip.zza b;
    final /* synthetic */ zziq c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(zzin zzinVar, zzip.zza zzaVar, zziq zziqVar) {
        this.f1522a = zzinVar;
        this.b = zzaVar;
        this.c = zziqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1522a.zzf(this.b.zze(this.c.get()));
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            this.f1522a.cancel(true);
        }
    }
}

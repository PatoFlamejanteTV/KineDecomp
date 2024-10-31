package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzin f1511a;
    final /* synthetic */ Callable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(zzin zzinVar, Callable callable) {
        this.f1511a = zzinVar;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Process.setThreadPriority(10);
            this.f1511a.zzf(this.b.call());
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzp.h().zzc(e, true);
            this.f1511a.cancel(true);
        }
    }
}

package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1436q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbw f13819a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f13820b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Bundle f13821c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Context f13822d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzas f13823e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ BroadcastReceiver.PendingResult f13824f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1436q(zzbm zzbmVar, zzbw zzbwVar, long j, Bundle bundle, Context context, zzas zzasVar, BroadcastReceiver.PendingResult pendingResult) {
        this.f13819a = zzbwVar;
        this.f13820b = j;
        this.f13821c = bundle;
        this.f13822d = context;
        this.f13823e = zzasVar;
        this.f13824f = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long a2 = this.f13819a.q().k.a();
        long j = this.f13820b;
        if (a2 > 0 && (j >= a2 || j <= 0)) {
            j = a2 - 1;
        }
        if (j > 0) {
            this.f13821c.putLong("click_timestamp", j);
        }
        this.f13821c.putString("_cis", "referrer broadcast");
        zzbw.a(this.f13822d, (zzan) null).h().b("auto", "_cmp", this.f13821c);
        this.f13823e.y().a("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.f13824f;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}

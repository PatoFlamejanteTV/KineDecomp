package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;

/* renamed from: com.google.android.gms.measurement.internal.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1432o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzu f13806a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f13807b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbk f13808c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1432o(zzbk zzbkVar, com.google.android.gms.internal.measurement.zzu zzuVar, ServiceConnection serviceConnection) {
        this.f13808c = zzbkVar;
        this.f13806a = zzuVar;
        this.f13807b = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzbk zzbkVar = this.f13808c;
        zzbj zzbjVar = zzbkVar.f13965b;
        str = zzbkVar.f13964a;
        com.google.android.gms.internal.measurement.zzu zzuVar = this.f13806a;
        ServiceConnection serviceConnection = this.f13807b;
        Bundle a2 = zzbjVar.a(str, zzuVar);
        zzbjVar.f13963a.zzgs().c();
        if (a2 != null) {
            long j = a2.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzbjVar.f13963a.b().q().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a2.getString("install_referrer");
                if (string != null && !string.isEmpty()) {
                    zzbjVar.f13963a.b().y().a("InstallReferrer API result", string);
                    zzfy p = zzbjVar.f13963a.p();
                    String valueOf = String.valueOf(string);
                    Bundle a3 = p.a(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (a3 == null) {
                        zzbjVar.f13963a.b().q().a("No campaign params defined in install referrer result");
                    } else {
                        String string2 = a3.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = a2.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzbjVar.f13963a.b().q().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                a3.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzbjVar.f13963a.q().l.a()) {
                            zzbjVar.f13963a.zzgw();
                            zzbjVar.f13963a.b().y().a("Campaign has already been logged");
                        } else {
                            zzbjVar.f13963a.q().l.a(j);
                            zzbjVar.f13963a.zzgw();
                            zzbjVar.f13963a.b().y().a("Logging Install Referrer campaign from sdk with ", "referrer API");
                            a3.putString("_cis", "referrer API");
                            zzbjVar.f13963a.h().b("auto", "_cmp", a3);
                        }
                    }
                } else {
                    zzbjVar.f13963a.b().q().a("No referrer defined in install referrer response");
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.a().a(zzbjVar.f13963a.getContext(), serviceConnection);
        }
    }
}

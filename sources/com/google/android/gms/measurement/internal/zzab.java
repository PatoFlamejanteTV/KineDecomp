package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class zzab {

    /* renamed from: a, reason: collision with root package name */
    final String f13890a;

    /* renamed from: b, reason: collision with root package name */
    final String f13891b;

    /* renamed from: c, reason: collision with root package name */
    private final String f13892c;

    /* renamed from: d, reason: collision with root package name */
    final long f13893d;

    /* renamed from: e, reason: collision with root package name */
    final long f13894e;

    /* renamed from: f, reason: collision with root package name */
    final zzad f13895f;

    private zzab(zzbw zzbwVar, String str, String str2, String str3, long j, long j2, zzad zzadVar) {
        Preconditions.b(str2);
        Preconditions.b(str3);
        Preconditions.a(zzadVar);
        this.f13890a = str2;
        this.f13891b = str3;
        this.f13892c = TextUtils.isEmpty(str) ? null : str;
        this.f13893d = j;
        this.f13894e = j2;
        long j3 = this.f13894e;
        if (j3 != 0 && j3 > this.f13893d) {
            zzbwVar.b().t().a("Event created with reverse previous/current timestamps. appId, name", zzas.a(str2), zzas.a(str3));
        }
        this.f13895f = zzadVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzab a(zzbw zzbwVar, long j) {
        return new zzab(zzbwVar, this.f13892c, this.f13890a, this.f13891b, this.f13893d, j, this.f13895f);
    }

    public final String toString() {
        String str = this.f13890a;
        String str2 = this.f13891b;
        String valueOf = String.valueOf(this.f13895f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzbw zzbwVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzad zzadVar;
        Preconditions.b(str2);
        Preconditions.b(str3);
        this.f13890a = str2;
        this.f13891b = str3;
        this.f13892c = TextUtils.isEmpty(str) ? null : str;
        this.f13893d = j;
        this.f13894e = j2;
        long j3 = this.f13894e;
        if (j3 != 0 && j3 > this.f13893d) {
            zzbwVar.b().t().a("Event created with reverse previous/current timestamps. appId", zzas.a(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzbwVar.b().q().a("Param name can't be null");
                    it.remove();
                } else {
                    Object a2 = zzbwVar.p().a(next, bundle2.get(next));
                    if (a2 == null) {
                        zzbwVar.b().t().a("Param value can't be null", zzbwVar.o().b(next));
                        it.remove();
                    } else {
                        zzbwVar.p().a(bundle2, next, a2);
                    }
                }
            }
            zzadVar = new zzad(bundle2);
        } else {
            zzadVar = new zzad(new Bundle());
        }
        this.f13895f = zzadVar;
    }
}

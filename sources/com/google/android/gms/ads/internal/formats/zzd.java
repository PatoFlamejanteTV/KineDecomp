package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcq;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzd extends zzcq.zza implements zzh.zza {

    /* renamed from: a, reason: collision with root package name */
    private final String f574a;
    private final List<zzc> b;
    private final String c;
    private final zzcm d;
    private final String e;
    private final double f;
    private final String g;
    private final String h;
    private final zza i;
    private final Bundle j;
    private final Object k = new Object();
    private zzh l;

    public zzd(String str, List list, String str2, zzcm zzcmVar, String str3, double d, String str4, String str5, zza zzaVar, Bundle bundle) {
        this.f574a = str;
        this.b = list;
        this.c = str2;
        this.d = zzcmVar;
        this.e = str3;
        this.f = d;
        this.g = str4;
        this.h = str5;
        this.i = zzaVar;
        this.j = bundle;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String a() {
        return "2";
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void a(zzh zzhVar) {
        synchronized (this.k) {
            this.l = zzhVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza b() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.zzcq
    public String getBody() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.zzcq
    public String getCallToAction() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzcq
    public Bundle getExtras() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.zzcq
    public String getHeadline() {
        return this.f574a;
    }

    @Override // com.google.android.gms.internal.zzcq
    public List getImages() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.zzcq
    public String getPrice() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.zzcq
    public double getStarRating() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.zzcq
    public String getStore() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.zzcq
    public zzcm zzdw() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.zzcq
    public com.google.android.gms.dynamic.zzd zzdx() {
        return com.google.android.gms.dynamic.zze.a(this.l);
    }
}

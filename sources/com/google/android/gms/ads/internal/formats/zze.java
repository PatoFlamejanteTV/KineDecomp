package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zze extends zzcs.zza implements zzh.zza {

    /* renamed from: a, reason: collision with root package name */
    private final String f575a;
    private final List<zzc> b;
    private final String c;
    private final zzcm d;
    private final String e;
    private final String f;
    private final zza g;
    private final Bundle h;
    private final Object i = new Object();
    private zzh j;

    public zze(String str, List list, String str2, zzcm zzcmVar, String str3, String str4, zza zzaVar, Bundle bundle) {
        this.f575a = str;
        this.b = list;
        this.c = str2;
        this.d = zzcmVar;
        this.e = str3;
        this.f = str4;
        this.g = zzaVar;
        this.h = bundle;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String a() {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void a(zzh zzhVar) {
        synchronized (this.i) {
            this.j = zzhVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza b() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.zzcs
    public String getAdvertiser() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.zzcs
    public String getBody() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.zzcs
    public String getCallToAction() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzcs
    public Bundle getExtras() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.zzcs
    public String getHeadline() {
        return this.f575a;
    }

    @Override // com.google.android.gms.internal.zzcs
    public List getImages() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.zzcs
    public zzcm zzdA() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.zzcs
    public com.google.android.gms.dynamic.zzd zzdx() {
        return com.google.android.gms.dynamic.zze.a(this.j);
    }
}

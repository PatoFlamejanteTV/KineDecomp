package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzmi;
import java.util.Arrays;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzf extends zzcu.zza implements zzh.zza {

    /* renamed from: a, reason: collision with root package name */
    private final zza f576a;
    private final String b;
    private final zzmi<String, zzc> c;
    private final zzmi<String, String> d;
    private final Object e = new Object();
    private zzh f;

    public zzf(String str, zzmi<String, zzc> zzmiVar, zzmi<String, String> zzmiVar2, zza zzaVar) {
        this.b = str;
        this.c = zzmiVar;
        this.d = zzmiVar2;
        this.f576a = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String a() {
        return "3";
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void a(zzh zzhVar) {
        synchronized (this.e) {
            this.f = zzhVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza b() {
        return this.f576a;
    }

    @Override // com.google.android.gms.internal.zzcu
    public List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[this.c.size() + this.d.size()];
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            strArr[i2] = this.c.keyAt(i3);
            i2++;
        }
        while (i < this.d.size()) {
            strArr[i2] = this.d.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.zzcu, com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.zzcu
    public void performClick(String str) {
        synchronized (this.e) {
            if (this.f == null) {
                zzb.b("Attempt to call performClick before ad initialized.");
            } else {
                this.f.a(str, null, null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcu
    public void recordImpression() {
        synchronized (this.e) {
            if (this.f == null) {
                zzb.b("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.f.a();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcu
    public String zzU(String str) {
        return this.d.get(str);
    }

    @Override // com.google.android.gms.internal.zzcu
    public zzcm zzV(String str) {
        return this.c.get(str);
    }
}

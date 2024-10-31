package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzmi;

@zzgr
/* loaded from: classes.dex */
public class zzj extends zzq.zza {

    /* renamed from: a, reason: collision with root package name */
    private com.google.android.gms.ads.internal.client.zzo f660a;
    private zzcw b;
    private zzcx c;
    private NativeAdOptionsParcel f;
    private final Context g;
    private final zzem h;
    private final String i;
    private final VersionInfoParcel j;
    private zzmi<String, zzcz> e = new zzmi<>();
    private zzmi<String, zzcy> d = new zzmi<>();

    public zzj(Context context, String str, zzem zzemVar, VersionInfoParcel versionInfoParcel) {
        this.g = context;
        this.i = str;
        this.h = zzemVar;
        this.j = versionInfoParcel;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public com.google.android.gms.ads.internal.client.zzp a() {
        return new zzi(this.g, this.i, this.h, this.j, this.f660a, this.b, this.c, this.e, this.d, this.f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void a(com.google.android.gms.ads.internal.client.zzo zzoVar) {
        this.f660a = zzoVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.f = nativeAdOptionsParcel;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void a(zzcw zzcwVar) {
        this.b = zzcwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void a(zzcx zzcxVar) {
        this.c = zzcxVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void a(String str, zzcz zzczVar, zzcy zzcyVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.e.put(str, zzczVar);
        this.d.put(str, zzcyVar);
    }
}

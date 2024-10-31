package com.google.android.gms.ads.internal;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzi extends zzp.zza {

    /* renamed from: a, reason: collision with root package name */
    private final Context f659a;
    private final com.google.android.gms.ads.internal.client.zzo b;
    private final zzem c;
    private final zzcw d;
    private final zzcx e;
    private final zzmi<String, zzcz> f;
    private final zzmi<String, zzcy> g;
    private final NativeAdOptionsParcel h;
    private final String j;
    private final VersionInfoParcel k;
    private WeakReference<zzn> l;
    private Object m = new Object();
    private final List<String> i = d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(Context context, String str, zzem zzemVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.client.zzo zzoVar, zzcw zzcwVar, zzcx zzcxVar, zzmi<String, zzcz> zzmiVar, zzmi<String, zzcy> zzmiVar2, NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.f659a = context;
        this.j = str;
        this.c = zzemVar;
        this.k = versionInfoParcel;
        this.b = zzoVar;
        this.e = zzcxVar;
        this.d = zzcwVar;
        this.f = zzmiVar;
        this.g = zzmiVar2;
        this.h = nativeAdOptionsParcel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        if (this.e != null) {
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.d != null) {
            arrayList.add("2");
        }
        if (this.f.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzp
    public String a() {
        synchronized (this.m) {
            if (this.l == null) {
                return null;
            }
            zzn zznVar = this.l.get();
            return zznVar != null ? zznVar.getMediationAdapterClassName() : null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzp
    public void a(AdRequestParcel adRequestParcel) {
        a(new h(this, adRequestParcel));
    }

    protected void a(Runnable runnable) {
        zzid.zzIE.post(runnable);
    }

    @Override // com.google.android.gms.ads.internal.client.zzp
    public boolean b() {
        synchronized (this.m) {
            if (this.l == null) {
                return false;
            }
            zzn zznVar = this.l.get();
            return zznVar != null ? zznVar.isLoading() : false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzn c() {
        return new zzn(this.f659a, AdSizeParcel.a(this.f659a), this.j, this.c, this.k);
    }
}

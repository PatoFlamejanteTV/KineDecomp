package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    public final int f608a;
    public final zzk b;
    public final zzfr c;
    public final Context d;
    public final zzj e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.f608a = i;
        this.b = (zzk) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder));
        this.c = (zzfr) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder2));
        this.d = (Context) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder3));
        this.e = (zzj) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzkVar, zzfr zzfrVar, zzj zzjVar) {
        this.f608a = 2;
        this.d = context;
        this.b = zzkVar;
        this.c = zzfrVar;
        this.e = zzjVar;
    }

    public static GInAppPurchaseManagerInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return com.google.android.gms.dynamic.zze.a(this.e).asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        return com.google.android.gms.dynamic.zze.a(this.b).asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder c() {
        return com.google.android.gms.dynamic.zze.a(this.c).asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder d() {
        return com.google.android.gms.dynamic.zze.a(this.d).asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}

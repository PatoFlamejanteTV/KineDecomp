package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;

@zzgr
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final zzf CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    public final int f589a;
    public final AdLauncherIntentInfoParcel b;
    public final com.google.android.gms.ads.internal.client.zza c;
    public final zzg d;
    public final zziz e;
    public final zzdg f;
    public final String g;
    public final boolean h;
    public final String i;
    public final zzn j;
    public final int k;
    public final int l;
    public final String m;
    public final VersionInfoParcel n;
    public final zzdm o;
    public final String p;
    public final InterstitialAdParameterParcel q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.f589a = i;
        this.b = adLauncherIntentInfoParcel;
        this.c = (com.google.android.gms.ads.internal.client.zza) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder));
        this.d = (zzg) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder2));
        this.e = (zziz) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder3));
        this.f = (zzdg) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder4));
        this.g = str;
        this.h = z;
        this.i = str2;
        this.j = (zzn) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder5));
        this.k = i2;
        this.l = i3;
        this.m = str3;
        this.n = versionInfoParcel;
        this.o = (zzdm) com.google.android.gms.dynamic.zze.a(zzd.zza.a(iBinder6));
        this.p = str4;
        this.q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzn zznVar, zziz zzizVar, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.f589a = 4;
        this.b = null;
        this.c = zzaVar;
        this.d = zzgVar;
        this.e = zzizVar;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = zznVar;
        this.k = i;
        this.l = 1;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = null;
        this.p = str;
        this.q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzn zznVar, zziz zzizVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.f589a = 4;
        this.b = null;
        this.c = zzaVar;
        this.d = zzgVar;
        this.e = zzizVar;
        this.f = null;
        this.g = null;
        this.h = z;
        this.i = null;
        this.j = zznVar;
        this.k = i;
        this.l = 2;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzdg zzdgVar, zzn zznVar, zziz zzizVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzdm zzdmVar) {
        this.f589a = 4;
        this.b = null;
        this.c = zzaVar;
        this.d = zzgVar;
        this.e = zzizVar;
        this.f = zzdgVar;
        this.g = null;
        this.h = z;
        this.i = null;
        this.j = zznVar;
        this.k = i;
        this.l = 3;
        this.m = str;
        this.n = versionInfoParcel;
        this.o = zzdmVar;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzdg zzdgVar, zzn zznVar, zziz zzizVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzdm zzdmVar) {
        this.f589a = 4;
        this.b = null;
        this.c = zzaVar;
        this.d = zzgVar;
        this.e = zzizVar;
        this.f = zzdgVar;
        this.g = str2;
        this.h = z;
        this.i = str;
        this.j = zznVar;
        this.k = i;
        this.l = 3;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = zzdmVar;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzn zznVar, VersionInfoParcel versionInfoParcel) {
        this.f589a = 4;
        this.b = adLauncherIntentInfoParcel;
        this.c = zzaVar;
        this.d = zzgVar;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = zznVar;
        this.k = -1;
        this.l = 4;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return com.google.android.gms.dynamic.zze.a(this.c).asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        return com.google.android.gms.dynamic.zze.a(this.d).asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder c() {
        return com.google.android.gms.dynamic.zze.a(this.e).asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder d() {
        return com.google.android.gms.dynamic.zze.a(this.f).asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder e() {
        return com.google.android.gms.dynamic.zze.a(this.o).asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder f() {
        return com.google.android.gms.dynamic.zze.a(this.j).asBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}

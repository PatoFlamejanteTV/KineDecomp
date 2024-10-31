package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzaq;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzvt;

@zzark
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    public final zzc f10098a;

    /* renamed from: b, reason: collision with root package name */
    public final zzvt f10099b;

    /* renamed from: c, reason: collision with root package name */
    public final zzn f10100c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbgg f10101d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.gmsg.zzd f10102e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10103f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10104g;

    /* renamed from: h, reason: collision with root package name */
    public final String f10105h;
    public final zzt i;
    public final int j;
    public final int k;
    public final String l;
    public final zzbbi m;
    public final String n;
    public final zzaq o;
    public final com.google.android.gms.ads.internal.gmsg.zzb p;

    public AdOverlayInfoParcel(zzvt zzvtVar, zzn zznVar, zzt zztVar, zzbgg zzbggVar, int i, zzbbi zzbbiVar, String str, zzaq zzaqVar) {
        this.f10098a = null;
        this.f10099b = zzvtVar;
        this.f10100c = zznVar;
        this.f10101d = zzbggVar;
        this.p = null;
        this.f10102e = null;
        this.f10103f = null;
        this.f10104g = false;
        this.f10105h = null;
        this.i = zztVar;
        this.j = i;
        this.k = 1;
        this.l = null;
        this.m = zzbbiVar;
        this.n = str;
        this.o = zzaqVar;
    }

    public static void a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.f10098a, i, false);
        SafeParcelWriter.a(parcel, 3, ObjectWrapper.a(this.f10099b).asBinder(), false);
        SafeParcelWriter.a(parcel, 4, ObjectWrapper.a(this.f10100c).asBinder(), false);
        SafeParcelWriter.a(parcel, 5, ObjectWrapper.a(this.f10101d).asBinder(), false);
        SafeParcelWriter.a(parcel, 6, ObjectWrapper.a(this.f10102e).asBinder(), false);
        SafeParcelWriter.a(parcel, 7, this.f10103f, false);
        SafeParcelWriter.a(parcel, 8, this.f10104g);
        SafeParcelWriter.a(parcel, 9, this.f10105h, false);
        SafeParcelWriter.a(parcel, 10, ObjectWrapper.a(this.i).asBinder(), false);
        SafeParcelWriter.a(parcel, 11, this.j);
        SafeParcelWriter.a(parcel, 12, this.k);
        SafeParcelWriter.a(parcel, 13, this.l, false);
        SafeParcelWriter.a(parcel, 14, (Parcelable) this.m, i, false);
        SafeParcelWriter.a(parcel, 16, this.n, false);
        SafeParcelWriter.a(parcel, 17, (Parcelable) this.o, i, false);
        SafeParcelWriter.a(parcel, 18, ObjectWrapper.a(this.p).asBinder(), false);
        SafeParcelWriter.a(parcel, a2);
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zzvt zzvtVar, zzn zznVar, zzt zztVar, zzbgg zzbggVar, boolean z, int i, zzbbi zzbbiVar) {
        this.f10098a = null;
        this.f10099b = zzvtVar;
        this.f10100c = zznVar;
        this.f10101d = zzbggVar;
        this.p = null;
        this.f10102e = null;
        this.f10103f = null;
        this.f10104g = z;
        this.f10105h = null;
        this.i = zztVar;
        this.j = i;
        this.k = 2;
        this.l = null;
        this.m = zzbbiVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzvt zzvtVar, zzn zznVar, com.google.android.gms.ads.internal.gmsg.zzb zzbVar, com.google.android.gms.ads.internal.gmsg.zzd zzdVar, zzt zztVar, zzbgg zzbggVar, boolean z, int i, String str, zzbbi zzbbiVar) {
        this.f10098a = null;
        this.f10099b = zzvtVar;
        this.f10100c = zznVar;
        this.f10101d = zzbggVar;
        this.p = zzbVar;
        this.f10102e = zzdVar;
        this.f10103f = null;
        this.f10104g = z;
        this.f10105h = null;
        this.i = zztVar;
        this.j = i;
        this.k = 3;
        this.l = str;
        this.m = zzbbiVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzvt zzvtVar, zzn zznVar, com.google.android.gms.ads.internal.gmsg.zzb zzbVar, com.google.android.gms.ads.internal.gmsg.zzd zzdVar, zzt zztVar, zzbgg zzbggVar, boolean z, int i, String str, String str2, zzbbi zzbbiVar) {
        this.f10098a = null;
        this.f10099b = zzvtVar;
        this.f10100c = zznVar;
        this.f10101d = zzbggVar;
        this.p = zzbVar;
        this.f10102e = zzdVar;
        this.f10103f = str2;
        this.f10104g = z;
        this.f10105h = str;
        this.i = zztVar;
        this.j = i;
        this.k = 3;
        this.l = null;
        this.m = zzbbiVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzc zzcVar, zzvt zzvtVar, zzn zznVar, zzt zztVar, zzbbi zzbbiVar) {
        this.f10098a = zzcVar;
        this.f10099b = zzvtVar;
        this.f10100c = zznVar;
        this.f10101d = null;
        this.p = null;
        this.f10102e = null;
        this.f10103f = null;
        this.f10104g = false;
        this.f10105h = null;
        this.i = zztVar;
        this.j = -1;
        this.k = 4;
        this.l = null;
        this.m = zzbbiVar;
        this.n = null;
        this.o = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AdOverlayInfoParcel(@SafeParcelable.Param(id = 2) zzc zzcVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) IBinder iBinder4, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) IBinder iBinder5, @SafeParcelable.Param(id = 11) int i, @SafeParcelable.Param(id = 12) int i2, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) zzbbi zzbbiVar, @SafeParcelable.Param(id = 16) String str4, @SafeParcelable.Param(id = 17) zzaq zzaqVar, @SafeParcelable.Param(id = 18) IBinder iBinder6) {
        this.f10098a = zzcVar;
        this.f10099b = (zzvt) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder));
        this.f10100c = (zzn) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder2));
        this.f10101d = (zzbgg) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder3));
        this.p = (com.google.android.gms.ads.internal.gmsg.zzb) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder6));
        this.f10102e = (com.google.android.gms.ads.internal.gmsg.zzd) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder4));
        this.f10103f = str;
        this.f10104g = z;
        this.f10105h = str2;
        this.i = (zzt) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder5));
        this.j = i;
        this.k = i2;
        this.l = str3;
        this.m = zzbbiVar;
        this.n = str4;
        this.o = zzaqVar;
    }
}

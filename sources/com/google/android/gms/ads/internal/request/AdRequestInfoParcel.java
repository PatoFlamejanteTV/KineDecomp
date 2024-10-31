package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;
import java.util.Collections;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public final class AdRequestInfoParcel implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final List<String> A;
    public final long B;
    public final CapabilityParcel C;
    public final String D;

    /* renamed from: a, reason: collision with root package name */
    public final int f620a;
    public final Bundle b;
    public final AdRequestParcel c;
    public final AdSizeParcel d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final VersionInfoParcel k;
    public final Bundle l;
    public final int m;
    public final List<String> n;
    public final Bundle o;
    public final boolean p;
    public final Messenger q;
    public final int r;
    public final int s;
    public final float t;
    public final String u;
    public final long v;
    public final String w;
    public final List<String> x;
    public final String y;
    public final NativeAdOptionsParcel z;

    @zzgr
    /* loaded from: classes.dex */
    public static final class zza {
        public final String A;

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f621a;
        public final AdRequestParcel b;
        public final AdSizeParcel c;
        public final String d;
        public final ApplicationInfo e;
        public final PackageInfo f;
        public final String g;
        public final String h;
        public final Bundle i;
        public final VersionInfoParcel j;
        public final int k;
        public final List<String> l;
        public final List<String> m;
        public final Bundle n;
        public final boolean o;
        public final Messenger p;
        public final int q;
        public final int r;
        public final float s;
        public final String t;
        public final long u;
        public final String v;
        public final List<String> w;
        public final String x;
        public final NativeAdOptionsParcel y;
        public final CapabilityParcel z;

        public zza(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel, String str7) {
            this.f621a = bundle;
            this.b = adRequestParcel;
            this.c = adSizeParcel;
            this.d = str;
            this.e = applicationInfo;
            this.f = packageInfo;
            this.g = str2;
            this.h = str3;
            this.j = versionInfoParcel;
            this.i = bundle2;
            this.o = z;
            this.p = messenger;
            this.q = i;
            this.r = i2;
            this.s = f;
            if (list == null || list.size() <= 0) {
                this.k = 0;
                this.l = null;
                this.m = null;
            } else {
                this.k = 3;
                this.l = list;
                this.m = list2;
            }
            this.n = bundle3;
            this.t = str4;
            this.u = j;
            this.v = str5;
            this.w = list3;
            this.x = str6;
            this.y = nativeAdOptionsParcel;
            this.z = capabilityParcel;
            this.A = str7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel, String str8) {
        this.f620a = i;
        this.b = bundle;
        this.c = adRequestParcel;
        this.d = adSizeParcel;
        this.e = str;
        this.f = applicationInfo;
        this.g = packageInfo;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = versionInfoParcel;
        this.l = bundle2;
        this.m = i2;
        this.n = list;
        this.A = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.o = bundle3;
        this.p = z;
        this.q = messenger;
        this.r = i3;
        this.s = i4;
        this.t = f;
        this.u = str5;
        this.v = j;
        this.w = str6;
        this.x = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.y = str7;
        this.z = nativeAdOptionsParcel;
        this.B = j2;
        this.C = capabilityParcel;
        this.D = str8;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel, String str8) {
        this(12, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, nativeAdOptionsParcel, list2, j2, capabilityParcel, str8);
    }

    public AdRequestInfoParcel(zza zzaVar, String str, long j) {
        this(zzaVar.f621a, zzaVar.b, zzaVar.c, zzaVar.d, zzaVar.e, zzaVar.f, str, zzaVar.g, zzaVar.h, zzaVar.j, zzaVar.i, zzaVar.k, zzaVar.l, zzaVar.m, zzaVar.n, zzaVar.o, zzaVar.p, zzaVar.q, zzaVar.r, zzaVar.s, zzaVar.t, zzaVar.u, zzaVar.v, zzaVar.w, zzaVar.x, zzaVar.y, j, zzaVar.z, zzaVar.A);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}

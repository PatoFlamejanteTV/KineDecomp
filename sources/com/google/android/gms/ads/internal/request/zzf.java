package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<AdRequestInfoParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, adRequestInfoParcel.f620a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, adRequestInfoParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) adRequestInfoParcel.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) adRequestInfoParcel.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, adRequestInfoParcel.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) adRequestInfoParcel.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) adRequestInfoParcel.g, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, adRequestInfoParcel.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, adRequestInfoParcel.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, adRequestInfoParcel.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, (Parcelable) adRequestInfoParcel.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, adRequestInfoParcel.l, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, adRequestInfoParcel.m);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 14, adRequestInfoParcel.n, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, adRequestInfoParcel.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, (Parcelable) adRequestInfoParcel.q, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, adRequestInfoParcel.p);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 19, adRequestInfoParcel.s);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 18, adRequestInfoParcel.r);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 21, adRequestInfoParcel.u, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 20, adRequestInfoParcel.t);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 25, adRequestInfoParcel.v);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 27, adRequestInfoParcel.x, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 26, adRequestInfoParcel.w, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 29, (Parcelable) adRequestInfoParcel.z, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 28, adRequestInfoParcel.y, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 31, adRequestInfoParcel.B);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 30, adRequestInfoParcel.A, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 32, (Parcelable) adRequestInfoParcel.C, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 33, adRequestInfoParcel.D, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdRequestInfoParcel createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        ArrayList<String> arrayList3 = null;
        long j2 = 0;
        CapabilityParcel capabilityParcel = null;
        String str8 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 13:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 14:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 15:
                    bundle3 = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 16:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 17:
                    messenger = (Messenger) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 19:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 20:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 21:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 22:
                case 23:
                case 24:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 25:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 26:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 27:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 28:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 29:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 31:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 32:
                    capabilityParcel = (CapabilityParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, CapabilityParcel.CREATOR);
                    break;
                case 33:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, arrayList, bundle3, z, messenger, i3, i4, f, str5, j, str6, arrayList2, str7, nativeAdOptionsParcel, arrayList3, j2, capabilityParcel, str8);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdRequestInfoParcel[] newArray(int i) {
        return new AdRequestInfoParcel[i];
    }
}

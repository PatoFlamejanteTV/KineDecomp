package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzl implements Parcelable.Creator<PlaceImpl> {
    public static void a(PlaceImpl placeImpl, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, placeImpl.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, placeImpl.r(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) placeImpl.t(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) placeImpl.g(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, placeImpl.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) placeImpl.i(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, placeImpl.s(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) placeImpl.j(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, placeImpl.n());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, placeImpl.o());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, placeImpl.p());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, placeImpl.q());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, placeImpl.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, placeImpl.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, placeImpl.k(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 17, placeImpl.m(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, placeImpl.l(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placeImpl.f1882a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 19, placeImpl.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 18, placeImpl.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 20, placeImpl.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PlaceImpl createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        ArrayList<Integer> arrayList = null;
        ArrayList<Integer> arrayList2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        boolean z2 = false;
        PlaceLocalization placeLocalization = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 3:
                    placeLocalization = (PlaceLocalization) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PlaceLocalization.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 5:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLngBounds.CREATOR);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 9:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 10:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 11:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 12:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 13:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.C(parcel, a2);
                    break;
                case 14:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 15:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 16:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 17:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 18:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 19:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 20:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.C(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PlaceImpl(i, str, arrayList, arrayList2, bundle, str2, str3, str4, str5, arrayList3, latLng, f, latLngBounds, str6, uri, z, f2, i2, j, z2, placeLocalization);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PlaceImpl[] newArray(int i) {
        return new PlaceImpl[i];
    }
}

package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<AddPlaceRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AddPlaceRequest addPlaceRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, addPlaceRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, addPlaceRequest.f1865a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) addPlaceRequest.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, addPlaceRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, addPlaceRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, addPlaceRequest.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) addPlaceRequest.f(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddPlaceRequest createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        ArrayList<Integer> arrayList = null;
        String str2 = null;
        LatLng latLng = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.C(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
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
        return new AddPlaceRequest(i, str3, latLng, str2, arrayList, str, uri);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddPlaceRequest[] newArray(int i) {
        return new AddPlaceRequest[i];
    }
}

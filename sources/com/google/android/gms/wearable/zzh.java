package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<PutDataRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, putDataRequest.f2327a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) putDataRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, putDataRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, putDataRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PutDataRequest createFromParcel(Parcel parcel) {
        byte[] s;
        Bundle bundle;
        Uri uri;
        int i;
        byte[] bArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Bundle bundle2 = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    byte[] bArr2 = bArr;
                    bundle = bundle2;
                    uri = uri2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    s = bArr2;
                    break;
                case 2:
                    i = i2;
                    Bundle bundle3 = bundle2;
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    s = bArr;
                    bundle = bundle3;
                    break;
                case 3:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    s = bArr;
                    bundle = bundle2;
                    uri = uri2;
                    i = i2;
                    break;
                case 4:
                    uri = uri2;
                    i = i2;
                    byte[] bArr3 = bArr;
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    s = bArr3;
                    break;
                case 5:
                    s = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    bundle = bundle2;
                    uri = uri2;
                    i = i2;
                    break;
            }
            i2 = i;
            uri2 = uri;
            bundle2 = bundle;
            bArr = s;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PutDataRequest(i2, uri2, bundle2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PutDataRequest[] newArray(int i) {
        return new PutDataRequest[i];
    }
}

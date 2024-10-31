package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<Asset> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Asset asset, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, asset.f2324a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, asset.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, asset.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) asset.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) asset.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Asset createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Asset(i, bArr, str, parcelFileDescriptor, uri);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Asset[] newArray(int i) {
        return new Asset[i];
    }
}

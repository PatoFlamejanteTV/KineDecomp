package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<BitmapTeleporter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, bitmapTeleporter.f983a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) bitmapTeleporter.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, bitmapTeleporter.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitmapTeleporter createFromParcel(Parcel parcel) {
        int g;
        ParcelFileDescriptor parcelFileDescriptor;
        int i;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i4 = i2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i4;
                    break;
                case 2:
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    i = i3;
                    g = i2;
                    parcelFileDescriptor = parcelFileDescriptor3;
                    break;
                case 3:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i3;
                    break;
            }
            i3 = i;
            parcelFileDescriptor2 = parcelFileDescriptor;
            i2 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new BitmapTeleporter(i3, parcelFileDescriptor2, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitmapTeleporter[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}

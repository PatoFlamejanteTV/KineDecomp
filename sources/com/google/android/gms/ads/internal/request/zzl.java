package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzl implements Parcelable.Creator<LargeParcelTeleporter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, largeParcelTeleporter.f624a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) largeParcelTeleporter.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LargeParcelTeleporter createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LargeParcelTeleporter(i, parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LargeParcelTeleporter[] newArray(int i) {
        return new LargeParcelTeleporter[i];
    }
}

package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zza implements Parcelable.Creator<ChangeSequenceNumber> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ChangeSequenceNumber changeSequenceNumber, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, changeSequenceNumber.f1049a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, changeSequenceNumber.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, changeSequenceNumber.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, changeSequenceNumber.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangeSequenceNumber createFromParcel(Parcel parcel) {
        long j = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ChangeSequenceNumber(i, j3, j2, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangeSequenceNumber[] newArray(int i) {
        return new ChangeSequenceNumber[i];
    }
}

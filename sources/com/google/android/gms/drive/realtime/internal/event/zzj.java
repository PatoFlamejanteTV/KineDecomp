package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzj implements Parcelable.Creator<ValuesRemovedDetails> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ValuesRemovedDetails valuesRemovedDetails, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, valuesRemovedDetails.f1185a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, valuesRemovedDetails.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, valuesRemovedDetails.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, valuesRemovedDetails.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, valuesRemovedDetails.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, valuesRemovedDetails.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ValuesRemovedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
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
        return new ValuesRemovedDetails(i5, i4, i3, i2, str, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ValuesRemovedDetails[] newArray(int i) {
        return new ValuesRemovedDetails[i];
    }
}

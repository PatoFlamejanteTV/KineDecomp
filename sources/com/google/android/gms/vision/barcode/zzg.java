package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<Barcode.Email> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Barcode.Email email, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, email.f2262a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, email.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, email.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, email.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, email.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.Email createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Barcode.Email(i2, i, str3, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.Email[] newArray(int i) {
        return new Barcode.Email[i];
    }
}

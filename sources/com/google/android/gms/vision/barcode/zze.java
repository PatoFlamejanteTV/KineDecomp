package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<Barcode.ContactInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Barcode.ContactInfo contactInfo, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, contactInfo.f2260a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) contactInfo.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, contactInfo.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, contactInfo.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable[]) contactInfo.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable[]) contactInfo.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, contactInfo.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable[]) contactInfo.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.ContactInfo createFromParcel(Parcel parcel) {
        Barcode.Address[] addressArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String[] strArr = null;
        Barcode.Email[] emailArr = null;
        Barcode.Phone[] phoneArr = null;
        String str = null;
        String str2 = null;
        Barcode.PersonName personName = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    personName = (Barcode.PersonName) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.PersonName.CREATOR);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    phoneArr = (Barcode.Phone[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Barcode.Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Barcode.Email[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Barcode.Email.CREATOR);
                    break;
                case 7:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 8:
                    addressArr = (Barcode.Address[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Barcode.Address.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Barcode.ContactInfo(i, personName, str2, str, phoneArr, emailArr, strArr, addressArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.ContactInfo[] newArray(int i) {
        return new Barcode.ContactInfo[i];
    }
}

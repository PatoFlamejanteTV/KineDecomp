package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

/* loaded from: classes2.dex */
public class zzc implements Parcelable.Creator<CustomProperty> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CustomProperty customProperty, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, customProperty.f1146a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) customProperty.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, customProperty.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CustomProperty createFromParcel(Parcel parcel) {
        String p;
        CustomPropertyKey customPropertyKey;
        int i;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        CustomPropertyKey customPropertyKey2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    String str2 = str;
                    customPropertyKey = customPropertyKey2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str2;
                    break;
                case 2:
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, CustomPropertyKey.CREATOR);
                    i = i2;
                    p = str;
                    customPropertyKey = customPropertyKey3;
                    break;
                case 3:
                    p = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    p = str;
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
            }
            i2 = i;
            customPropertyKey2 = customPropertyKey;
            str = p;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CustomProperty(i2, customPropertyKey2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CustomProperty[] newArray(int i) {
        return new CustomProperty[i];
    }
}

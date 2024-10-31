package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<FastJsonResponse.Field> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FastJsonResponse.Field field, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, field.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, field.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, field.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, field.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, field.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, field.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, field.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, field.j(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) field.l(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FastJsonResponse.Field createFromParcel(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ConverterWrapper.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new FastJsonResponse.Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FastJsonResponse.Field[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}

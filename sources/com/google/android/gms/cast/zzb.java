package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<CastDevice> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CastDevice castDevice, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, castDevice.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, castDevice.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, castDevice.f820a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, castDevice.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, castDevice.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, castDevice.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, castDevice.f());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 8, castDevice.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, castDevice.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, castDevice.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CastDevice createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 10:
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
        return new CastDevice(i4, str5, str4, str3, str2, str, i3, arrayList, i2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CastDevice[] newArray(int i) {
        return new CastDevice[i];
    }
}

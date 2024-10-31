package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<LandmarkParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LandmarkParcel landmarkParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, landmarkParcel.f2273a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, landmarkParcel.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, landmarkParcel.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, landmarkParcel.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LandmarkParcel createFromParcel(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 3:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 4:
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
        return new LandmarkParcel(i2, f2, f, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LandmarkParcel[] newArray(int i) {
        return new LandmarkParcel[i];
    }
}

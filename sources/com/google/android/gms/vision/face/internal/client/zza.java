package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<FaceParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FaceParcel faceParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, faceParcel.f2271a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, faceParcel.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, faceParcel.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, faceParcel.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, faceParcel.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, faceParcel.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, faceParcel.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, faceParcel.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable[]) faceParcel.i, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, faceParcel.j);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, faceParcel.k);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, faceParcel.l);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FaceParcel createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        LandmarkParcel[] landmarkParcelArr = null;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 5:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 6:
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 7:
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 8:
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 9:
                    landmarkParcelArr = (LandmarkParcel[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, LandmarkParcel.CREATOR);
                    break;
                case 10:
                    f7 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 11:
                    f8 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 12:
                    f9 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new FaceParcel(i, i2, f, f2, f3, f4, f5, f6, landmarkParcelArr, f7, f8, f9);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FaceParcel[] newArray(int i) {
        return new FaceParcel[i];
    }
}

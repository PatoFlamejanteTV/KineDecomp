package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzt implements Parcelable.Creator<Value> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Value value, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, value.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, value.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, value.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, value.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, value.k(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, value.l(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, value.m(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, value.n(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Value createFromParcel(Parcel parcel) {
        boolean z = false;
        float[] fArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        float f = 0.0f;
        int[] iArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 3:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 6:
                    iArr = com.google.android.gms.common.internal.safeparcel.zza.v(parcel, a2);
                    break;
                case 7:
                    fArr = com.google.android.gms.common.internal.safeparcel.zza.y(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Value(i2, i, z, f, str, bundle, iArr, fArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Value[] newArray(int i) {
        return new Value[i];
    }
}

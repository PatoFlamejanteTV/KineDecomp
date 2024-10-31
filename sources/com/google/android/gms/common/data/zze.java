package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<DataHolder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, dataHolder.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataHolder.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable[]) dataHolder.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, dataHolder.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, dataHolder.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
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
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.a();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}

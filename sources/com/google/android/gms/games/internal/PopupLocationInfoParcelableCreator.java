package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class PopupLocationInfoParcelableCreator implements Parcelable.Creator<PopupLocationInfoParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PopupLocationInfoParcelable popupLocationInfoParcelable, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, popupLocationInfoParcelable.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, popupLocationInfoParcelable.a());
        zzb.a(parcel, 2, popupLocationInfoParcelable.c(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PopupLocationInfoParcelable createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int b = zza.b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    bundle = zza.r(parcel, a2);
                    break;
                case 2:
                    iBinder = zza.q(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PopupLocationInfoParcelable(i, bundle, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PopupLocationInfoParcelable[] newArray(int i) {
        return new PopupLocationInfoParcelable[i];
    }
}

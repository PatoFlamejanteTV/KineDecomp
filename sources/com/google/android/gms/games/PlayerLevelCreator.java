package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class PlayerLevelCreator implements Parcelable.Creator<PlayerLevel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlayerLevel playerLevel, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, playerLevel.b());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, playerLevel.a());
        zzb.a(parcel, 2, playerLevel.c());
        zzb.a(parcel, 3, playerLevel.d());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int b = zza.b(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    i = zza.g(parcel, a2);
                    break;
                case 2:
                    j2 = zza.i(parcel, a2);
                    break;
                case 3:
                    j = zza.i(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PlayerLevel(i2, i, j2, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerLevel[] newArray(int i) {
        return new PlayerLevel[i];
    }
}

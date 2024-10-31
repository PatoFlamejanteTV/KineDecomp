package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class PlayerLevelInfoCreator implements Parcelable.Creator<PlayerLevelInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, playerLevelInfo.b());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, playerLevelInfo.a());
        zzb.a(parcel, 2, playerLevelInfo.c());
        zzb.a(parcel, 3, (Parcelable) playerLevelInfo.d(), i, false);
        zzb.a(parcel, 4, (Parcelable) playerLevelInfo.e(), i, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int b = zza.b(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    j2 = zza.i(parcel, a2);
                    break;
                case 2:
                    j = zza.i(parcel, a2);
                    break;
                case 3:
                    playerLevel2 = (PlayerLevel) zza.a(parcel, a2, PlayerLevel.CREATOR);
                    break;
                case 4:
                    playerLevel = (PlayerLevel) zza.a(parcel, a2, PlayerLevel.CREATOR);
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
        return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerLevelInfo[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }
}

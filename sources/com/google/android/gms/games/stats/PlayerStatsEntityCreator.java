package com.google.android.gms.games.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class PlayerStatsEntityCreator implements Parcelable.Creator<PlayerStatsEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlayerStatsEntity playerStatsEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, playerStatsEntity.b());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, playerStatsEntity.i());
        zzb.a(parcel, 2, playerStatsEntity.c());
        zzb.a(parcel, 3, playerStatsEntity.d());
        zzb.a(parcel, 4, playerStatsEntity.e());
        zzb.a(parcel, 5, playerStatsEntity.f());
        zzb.a(parcel, 6, playerStatsEntity.g());
        zzb.a(parcel, 7, playerStatsEntity.h());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerStatsEntity createFromParcel(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int b = zza.b(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    f4 = zza.l(parcel, a2);
                    break;
                case 2:
                    f3 = zza.l(parcel, a2);
                    break;
                case 3:
                    i3 = zza.g(parcel, a2);
                    break;
                case 4:
                    i2 = zza.g(parcel, a2);
                    break;
                case 5:
                    i = zza.g(parcel, a2);
                    break;
                case 6:
                    f2 = zza.l(parcel, a2);
                    break;
                case 7:
                    f = zza.l(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i4 = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PlayerStatsEntity(i4, f4, f3, i3, i2, i, f2, f);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerStatsEntity[] newArray(int i) {
        return new PlayerStatsEntity[i];
    }
}

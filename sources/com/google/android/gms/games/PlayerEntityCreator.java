package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class PlayerEntityCreator implements Parcelable.Creator<PlayerEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, playerEntity.b(), false);
        zzb.a(parcel, 2, playerEntity.c(), false);
        zzb.a(parcel, 3, (Parcelable) playerEntity.g(), i, false);
        zzb.a(parcel, 4, (Parcelable) playerEntity.i(), i, false);
        zzb.a(parcel, 5, playerEntity.k());
        zzb.a(parcel, 6, playerEntity.m());
        zzb.a(parcel, 7, playerEntity.l());
        zzb.a(parcel, 8, playerEntity.h(), false);
        zzb.a(parcel, 9, playerEntity.j(), false);
        zzb.a(parcel, 14, playerEntity.o(), false);
        zzb.a(parcel, 15, (Parcelable) playerEntity.q(), i, false);
        zzb.a(parcel, 16, (Parcelable) playerEntity.p(), i, false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, playerEntity.r());
        zzb.a(parcel, 19, playerEntity.f());
        zzb.a(parcel, 18, playerEntity.n());
        zzb.a(parcel, 21, playerEntity.e(), false);
        zzb.a(parcel, 20, playerEntity.d(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        boolean z2 = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str = zza.p(parcel, a2);
                    break;
                case 2:
                    str2 = zza.p(parcel, a2);
                    break;
                case 3:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 5:
                    j = zza.i(parcel, a2);
                    break;
                case 6:
                    i2 = zza.g(parcel, a2);
                    break;
                case 7:
                    j2 = zza.i(parcel, a2);
                    break;
                case 8:
                    str3 = zza.p(parcel, a2);
                    break;
                case 9:
                    str4 = zza.p(parcel, a2);
                    break;
                case 14:
                    str5 = zza.p(parcel, a2);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zza.a(parcel, a2, MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) zza.a(parcel, a2, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = zza.c(parcel, a2);
                    break;
                case 19:
                    z2 = zza.c(parcel, a2);
                    break;
                case 20:
                    str6 = zza.p(parcel, a2);
                    break;
                case 21:
                    str7 = zza.p(parcel, a2);
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
        return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2, str6, str7);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }
}

package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class AchievementEntityCreator implements Parcelable.Creator<AchievementEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, achievementEntity.b(), false);
        zzb.a(parcel, 2, achievementEntity.c());
        zzb.a(parcel, 3, achievementEntity.d(), false);
        zzb.a(parcel, 4, achievementEntity.e(), false);
        zzb.a(parcel, 5, (Parcelable) achievementEntity.f(), i, false);
        zzb.a(parcel, 6, achievementEntity.g(), false);
        zzb.a(parcel, 7, (Parcelable) achievementEntity.h(), i, false);
        zzb.a(parcel, 8, achievementEntity.i(), false);
        zzb.a(parcel, 9, achievementEntity.s());
        zzb.a(parcel, 10, achievementEntity.t(), false);
        zzb.a(parcel, 11, (Parcelable) achievementEntity.l(), i, false);
        zzb.a(parcel, 12, achievementEntity.m());
        zzb.a(parcel, 13, achievementEntity.u());
        zzb.a(parcel, 14, achievementEntity.v(), false);
        zzb.a(parcel, 15, achievementEntity.p());
        zzb.a(parcel, 16, achievementEntity.q());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, achievementEntity.r());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AchievementEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str = zza.p(parcel, a2);
                    break;
                case 2:
                    i2 = zza.g(parcel, a2);
                    break;
                case 3:
                    str2 = zza.p(parcel, a2);
                    break;
                case 4:
                    str3 = zza.p(parcel, a2);
                    break;
                case 5:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 6:
                    str4 = zza.p(parcel, a2);
                    break;
                case 7:
                    uri2 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 8:
                    str5 = zza.p(parcel, a2);
                    break;
                case 9:
                    i3 = zza.g(parcel, a2);
                    break;
                case 10:
                    str6 = zza.p(parcel, a2);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) zza.a(parcel, a2, PlayerEntity.CREATOR);
                    break;
                case 12:
                    i4 = zza.g(parcel, a2);
                    break;
                case 13:
                    i5 = zza.g(parcel, a2);
                    break;
                case 14:
                    str7 = zza.p(parcel, a2);
                    break;
                case 15:
                    j = zza.i(parcel, a2);
                    break;
                case 16:
                    j2 = zza.i(parcel, a2);
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
        return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AchievementEntity[] newArray(int i) {
        return new AchievementEntity[i];
    }
}

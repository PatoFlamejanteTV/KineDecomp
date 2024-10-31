package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class GameBadgeEntityCreator implements Parcelable.Creator<GameBadgeEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, gameBadgeEntity.b());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, gameBadgeEntity.f());
        zzb.a(parcel, 2, gameBadgeEntity.c(), false);
        zzb.a(parcel, 3, gameBadgeEntity.d(), false);
        zzb.a(parcel, 4, (Parcelable) gameBadgeEntity.e(), i, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameBadgeEntity createFromParcel(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int b = zza.b(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    i = zza.g(parcel, a2);
                    break;
                case 2:
                    str2 = zza.p(parcel, a2);
                    break;
                case 3:
                    str = zza.p(parcel, a2);
                    break;
                case 4:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
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
        return new GameBadgeEntity(i2, i, str2, str, uri);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameBadgeEntity[] newArray(int i) {
        return new GameBadgeEntity[i];
    }
}

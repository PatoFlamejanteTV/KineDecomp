package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GameRequestEntityCreator implements Parcelable.Creator<GameRequestEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, (Parcelable) gameRequestEntity.e(), i, false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, gameRequestEntity.b());
        zzb.a(parcel, 2, (Parcelable) gameRequestEntity.f(), i, false);
        zzb.a(parcel, 3, gameRequestEntity.h(), false);
        zzb.a(parcel, 4, gameRequestEntity.d(), false);
        zzb.c(parcel, 5, gameRequestEntity.n(), false);
        zzb.a(parcel, 7, gameRequestEntity.i());
        zzb.a(parcel, 9, gameRequestEntity.j());
        zzb.a(parcel, 10, gameRequestEntity.k());
        zzb.a(parcel, 11, gameRequestEntity.c(), false);
        zzb.a(parcel, 12, gameRequestEntity.l());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameRequestEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    gameEntity = (GameEntity) zza.a(parcel, a2, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) zza.a(parcel, a2, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = zza.s(parcel, a2);
                    break;
                case 4:
                    str = zza.p(parcel, a2);
                    break;
                case 5:
                    arrayList = zza.c(parcel, a2, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = zza.g(parcel, a2);
                    break;
                case 9:
                    j = zza.i(parcel, a2);
                    break;
                case 10:
                    j2 = zza.i(parcel, a2);
                    break;
                case 11:
                    bundle = zza.r(parcel, a2);
                    break;
                case 12:
                    i3 = zza.g(parcel, a2);
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
        return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameRequestEntity[] newArray(int i) {
        return new GameRequestEntity[i];
    }
}

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TurnBasedMatchEntityCreator implements Parcelable.Creator<TurnBasedMatchEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, (Parcelable) turnBasedMatchEntity.b(), i, false);
        zzb.a(parcel, 2, turnBasedMatchEntity.c(), false);
        zzb.a(parcel, 3, turnBasedMatchEntity.d(), false);
        zzb.a(parcel, 4, turnBasedMatchEntity.e());
        zzb.a(parcel, 5, turnBasedMatchEntity.j(), false);
        zzb.a(parcel, 6, turnBasedMatchEntity.k());
        zzb.a(parcel, 7, turnBasedMatchEntity.m(), false);
        zzb.a(parcel, 8, turnBasedMatchEntity.f());
        zzb.a(parcel, 10, turnBasedMatchEntity.i());
        zzb.a(parcel, 11, turnBasedMatchEntity.o());
        zzb.a(parcel, 12, turnBasedMatchEntity.n(), false);
        zzb.c(parcel, 13, turnBasedMatchEntity.l(), false);
        zzb.a(parcel, 14, turnBasedMatchEntity.p(), false);
        zzb.a(parcel, 15, turnBasedMatchEntity.q(), false);
        zzb.a(parcel, 17, turnBasedMatchEntity.s(), false);
        zzb.a(parcel, 16, turnBasedMatchEntity.r());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, turnBasedMatchEntity.w());
        zzb.a(parcel, 19, turnBasedMatchEntity.u());
        zzb.a(parcel, 18, turnBasedMatchEntity.g());
        zzb.a(parcel, 21, turnBasedMatchEntity.v(), false);
        zzb.a(parcel, 20, turnBasedMatchEntity.h(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    gameEntity = (GameEntity) zza.a(parcel, a2, GameEntity.CREATOR);
                    break;
                case 2:
                    str = zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = zza.p(parcel, a2);
                    break;
                case 4:
                    j = zza.i(parcel, a2);
                    break;
                case 5:
                    str3 = zza.p(parcel, a2);
                    break;
                case 6:
                    j2 = zza.i(parcel, a2);
                    break;
                case 7:
                    str4 = zza.p(parcel, a2);
                    break;
                case 8:
                    i2 = zza.g(parcel, a2);
                    break;
                case 10:
                    i3 = zza.g(parcel, a2);
                    break;
                case 11:
                    i4 = zza.g(parcel, a2);
                    break;
                case 12:
                    bArr = zza.s(parcel, a2);
                    break;
                case 13:
                    arrayList = zza.c(parcel, a2, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = zza.p(parcel, a2);
                    break;
                case 15:
                    bArr2 = zza.s(parcel, a2);
                    break;
                case 16:
                    i5 = zza.g(parcel, a2);
                    break;
                case 17:
                    bundle = zza.r(parcel, a2);
                    break;
                case 18:
                    i6 = zza.g(parcel, a2);
                    break;
                case 19:
                    z = zza.c(parcel, a2);
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
        return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatchEntity[] newArray(int i) {
        return new TurnBasedMatchEntity[i];
    }
}

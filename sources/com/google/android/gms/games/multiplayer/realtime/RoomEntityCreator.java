package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RoomEntityCreator implements Parcelable.Creator<RoomEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RoomEntity roomEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, roomEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, roomEntity.j());
        zzb.a(parcel, 2, roomEntity.c(), false);
        zzb.a(parcel, 3, roomEntity.d());
        zzb.a(parcel, 4, roomEntity.e());
        zzb.a(parcel, 5, roomEntity.f(), false);
        zzb.a(parcel, 6, roomEntity.g());
        zzb.a(parcel, 7, roomEntity.h(), false);
        zzb.c(parcel, 8, roomEntity.l(), false);
        zzb.a(parcel, 9, roomEntity.i());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RoomEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int b = zza.b(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str3 = zza.p(parcel, a2);
                    break;
                case 2:
                    str2 = zza.p(parcel, a2);
                    break;
                case 3:
                    j = zza.i(parcel, a2);
                    break;
                case 4:
                    i3 = zza.g(parcel, a2);
                    break;
                case 5:
                    str = zza.p(parcel, a2);
                    break;
                case 6:
                    i2 = zza.g(parcel, a2);
                    break;
                case 7:
                    bundle = zza.r(parcel, a2);
                    break;
                case 8:
                    arrayList = zza.c(parcel, a2, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = zza.g(parcel, a2);
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
        return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }
}

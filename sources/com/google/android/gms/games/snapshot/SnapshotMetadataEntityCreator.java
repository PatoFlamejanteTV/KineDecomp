package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class SnapshotMetadataEntityCreator implements Parcelable.Creator<SnapshotMetadataEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, (Parcelable) snapshotMetadataEntity.b(), i, false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, snapshotMetadataEntity.p());
        zzb.a(parcel, 2, (Parcelable) snapshotMetadataEntity.c(), i, false);
        zzb.a(parcel, 3, snapshotMetadataEntity.d(), false);
        zzb.a(parcel, 5, (Parcelable) snapshotMetadataEntity.e(), i, false);
        zzb.a(parcel, 6, snapshotMetadataEntity.f(), false);
        zzb.a(parcel, 7, snapshotMetadataEntity.i(), false);
        zzb.a(parcel, 8, snapshotMetadataEntity.j(), false);
        zzb.a(parcel, 9, snapshotMetadataEntity.k());
        zzb.a(parcel, 10, snapshotMetadataEntity.l());
        zzb.a(parcel, 11, snapshotMetadataEntity.g());
        zzb.a(parcel, 12, snapshotMetadataEntity.h(), false);
        zzb.a(parcel, 13, snapshotMetadataEntity.m());
        zzb.a(parcel, 14, snapshotMetadataEntity.n());
        zzb.a(parcel, 15, snapshotMetadataEntity.o(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z = false;
        long j3 = 0;
        String str6 = null;
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
                    str = zza.p(parcel, a2);
                    break;
                case 5:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 6:
                    str2 = zza.p(parcel, a2);
                    break;
                case 7:
                    str3 = zza.p(parcel, a2);
                    break;
                case 8:
                    str4 = zza.p(parcel, a2);
                    break;
                case 9:
                    j = zza.i(parcel, a2);
                    break;
                case 10:
                    j2 = zza.i(parcel, a2);
                    break;
                case 11:
                    f = zza.l(parcel, a2);
                    break;
                case 12:
                    str5 = zza.p(parcel, a2);
                    break;
                case 13:
                    z = zza.c(parcel, a2);
                    break;
                case 14:
                    j3 = zza.i(parcel, a2);
                    break;
                case 15:
                    str6 = zza.p(parcel, a2);
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
        return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5, z, j3, str6);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataEntity[] newArray(int i) {
        return new SnapshotMetadataEntity[i];
    }
}

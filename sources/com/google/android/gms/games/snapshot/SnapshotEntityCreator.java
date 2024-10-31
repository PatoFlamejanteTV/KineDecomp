package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class SnapshotEntityCreator implements Parcelable.Creator<SnapshotEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, (Parcelable) snapshotEntity.b(), i, false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, snapshotEntity.d());
        zzb.a(parcel, 3, (Parcelable) snapshotEntity.c(), i, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotEntity createFromParcel(Parcel parcel) {
        SnapshotContentsEntity snapshotContentsEntity;
        SnapshotMetadataEntity snapshotMetadataEntity;
        int i;
        SnapshotContentsEntity snapshotContentsEntity2 = null;
        int b = zza.b(parcel);
        int i2 = 0;
        SnapshotMetadataEntity snapshotMetadataEntity2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    SnapshotMetadataEntity snapshotMetadataEntity3 = (SnapshotMetadataEntity) zza.a(parcel, a2, SnapshotMetadataEntity.CREATOR);
                    i = i2;
                    snapshotContentsEntity = snapshotContentsEntity2;
                    snapshotMetadataEntity = snapshotMetadataEntity3;
                    break;
                case 3:
                    snapshotContentsEntity = (SnapshotContentsEntity) zza.a(parcel, a2, SnapshotContentsEntity.CREATOR);
                    snapshotMetadataEntity = snapshotMetadataEntity2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    SnapshotContentsEntity snapshotContentsEntity3 = snapshotContentsEntity2;
                    snapshotMetadataEntity = snapshotMetadataEntity2;
                    i = zza.g(parcel, a2);
                    snapshotContentsEntity = snapshotContentsEntity3;
                    break;
                default:
                    zza.b(parcel, a2);
                    snapshotContentsEntity = snapshotContentsEntity2;
                    snapshotMetadataEntity = snapshotMetadataEntity2;
                    i = i2;
                    break;
            }
            i2 = i;
            snapshotMetadataEntity2 = snapshotMetadataEntity;
            snapshotContentsEntity2 = snapshotContentsEntity;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SnapshotEntity(i2, snapshotMetadataEntity2, snapshotContentsEntity2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotEntity[] newArray(int i) {
        return new SnapshotEntity[i];
    }
}

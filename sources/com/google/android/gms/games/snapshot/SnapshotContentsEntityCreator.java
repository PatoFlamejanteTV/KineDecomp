package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class SnapshotContentsEntityCreator implements Parcelable.Creator<SnapshotContentsEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, (Parcelable) snapshotContentsEntity.b(), i, false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, snapshotContentsEntity.a());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotContentsEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    contents = (Contents) zza.a(parcel, a2, Contents.CREATOR);
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
        return new SnapshotContentsEntity(i, contents);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotContentsEntity[] newArray(int i) {
        return new SnapshotContentsEntity[i];
    }
}

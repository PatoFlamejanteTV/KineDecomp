package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class SnapshotMetadataChangeCreator implements Parcelable.Creator<SnapshotMetadataChangeEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, snapshotMetadataChangeEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, snapshotMetadataChangeEntity.a());
        zzb.a(parcel, 2, snapshotMetadataChangeEntity.c(), false);
        zzb.a(parcel, 4, (Parcelable) snapshotMetadataChangeEntity.f(), i, false);
        zzb.a(parcel, 5, (Parcelable) snapshotMetadataChangeEntity.e(), i, false);
        zzb.a(parcel, 6, snapshotMetadataChangeEntity.d(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataChangeEntity createFromParcel(Parcel parcel) {
        Long l = null;
        int b = zza.b(parcel);
        int i = 0;
        Uri uri = null;
        BitmapTeleporter bitmapTeleporter = null;
        Long l2 = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str = zza.p(parcel, a2);
                    break;
                case 2:
                    l2 = zza.j(parcel, a2);
                    break;
                case 4:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 5:
                    bitmapTeleporter = (BitmapTeleporter) zza.a(parcel, a2, BitmapTeleporter.CREATOR);
                    break;
                case 6:
                    l = zza.j(parcel, a2);
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
        return new SnapshotMetadataChangeEntity(i, str, l2, bitmapTeleporter, uri, l);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataChangeEntity[] newArray(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}

package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class MostRecentGameInfoEntityCreator implements Parcelable.Creator<MostRecentGameInfoEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, mostRecentGameInfoEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, mostRecentGameInfoEntity.h());
        zzb.a(parcel, 2, mostRecentGameInfoEntity.c(), false);
        zzb.a(parcel, 3, mostRecentGameInfoEntity.d());
        zzb.a(parcel, 4, (Parcelable) mostRecentGameInfoEntity.e(), i, false);
        zzb.a(parcel, 5, (Parcelable) mostRecentGameInfoEntity.f(), i, false);
        zzb.a(parcel, 6, (Parcelable) mostRecentGameInfoEntity.g(), i, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfoEntity createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str2 = zza.p(parcel, a2);
                    break;
                case 2:
                    str = zza.p(parcel, a2);
                    break;
                case 3:
                    j = zza.i(parcel, a2);
                    break;
                case 4:
                    uri3 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
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
        return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfoEntity[] newArray(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}

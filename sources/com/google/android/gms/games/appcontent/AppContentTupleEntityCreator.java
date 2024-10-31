package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class AppContentTupleEntityCreator implements Parcelable.Creator<AppContentTupleEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppContentTupleEntity appContentTupleEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, appContentTupleEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, appContentTupleEntity.d());
        zzb.a(parcel, 2, appContentTupleEntity.c(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentTupleEntity createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
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
        return new AppContentTupleEntity(i, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentTupleEntity[] newArray(int i) {
        return new AppContentTupleEntity[i];
    }
}

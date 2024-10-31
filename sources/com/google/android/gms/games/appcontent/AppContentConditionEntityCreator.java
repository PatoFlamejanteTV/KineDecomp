package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class AppContentConditionEntityCreator implements Parcelable.Creator<AppContentConditionEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, appContentConditionEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, appContentConditionEntity.f());
        zzb.a(parcel, 2, appContentConditionEntity.c(), false);
        zzb.a(parcel, 3, appContentConditionEntity.d(), false);
        zzb.a(parcel, 4, appContentConditionEntity.e(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentConditionEntity createFromParcel(Parcel parcel) {
        Bundle bundle = null;
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
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
                    str = zza.p(parcel, a2);
                    break;
                case 4:
                    bundle = zza.r(parcel, a2);
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
        return new AppContentConditionEntity(i, str3, str2, str, bundle);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentConditionEntity[] newArray(int i) {
        return new AppContentConditionEntity[i];
    }
}

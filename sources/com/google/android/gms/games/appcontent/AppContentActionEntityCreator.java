package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AppContentActionEntityCreator implements Parcelable.Creator<AppContentActionEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.c(parcel, 1, appContentActionEntity.c(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, appContentActionEntity.i());
        zzb.a(parcel, 2, appContentActionEntity.d(), false);
        zzb.a(parcel, 3, appContentActionEntity.e(), false);
        zzb.a(parcel, 6, appContentActionEntity.h(), false);
        zzb.a(parcel, 7, appContentActionEntity.f(), false);
        zzb.a(parcel, 8, (Parcelable) appContentActionEntity.b(), i, false);
        zzb.a(parcel, 9, appContentActionEntity.g(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentActionEntity createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    arrayList = zza.c(parcel, a2, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    str4 = zza.p(parcel, a2);
                    break;
                case 3:
                    bundle = zza.r(parcel, a2);
                    break;
                case 6:
                    str3 = zza.p(parcel, a2);
                    break;
                case 7:
                    str2 = zza.p(parcel, a2);
                    break;
                case 8:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) zza.a(parcel, a2, AppContentAnnotationEntity.CREATOR);
                    break;
                case 9:
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
        return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, appContentAnnotationEntity, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentActionEntity[] newArray(int i) {
        return new AppContentActionEntity[i];
    }
}

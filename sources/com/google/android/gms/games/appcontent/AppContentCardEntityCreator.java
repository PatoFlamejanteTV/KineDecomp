package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AppContentCardEntityCreator implements Parcelable.Creator<AppContentCardEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.c(parcel, 1, appContentCardEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, appContentCardEntity.n());
        zzb.c(parcel, 2, appContentCardEntity.c(), false);
        zzb.c(parcel, 3, appContentCardEntity.d(), false);
        zzb.a(parcel, 4, appContentCardEntity.e(), false);
        zzb.a(parcel, 5, appContentCardEntity.f());
        zzb.a(parcel, 6, appContentCardEntity.g(), false);
        zzb.a(parcel, 7, appContentCardEntity.h(), false);
        zzb.a(parcel, 10, appContentCardEntity.j(), false);
        zzb.a(parcel, 11, appContentCardEntity.k(), false);
        zzb.a(parcel, 12, appContentCardEntity.l());
        zzb.a(parcel, 13, appContentCardEntity.m(), false);
        zzb.a(parcel, 14, appContentCardEntity.i(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentCardEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    arrayList = zza.c(parcel, a2, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayList2 = zza.c(parcel, a2, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayList3 = zza.c(parcel, a2, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    str = zza.p(parcel, a2);
                    break;
                case 5:
                    i2 = zza.g(parcel, a2);
                    break;
                case 6:
                    str2 = zza.p(parcel, a2);
                    break;
                case 7:
                    bundle = zza.r(parcel, a2);
                    break;
                case 10:
                    str3 = zza.p(parcel, a2);
                    break;
                case 11:
                    str4 = zza.p(parcel, a2);
                    break;
                case 12:
                    i3 = zza.g(parcel, a2);
                    break;
                case 13:
                    str5 = zza.p(parcel, a2);
                    break;
                case 14:
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
        return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, str3, str4, i3, str5, str6);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentCardEntity[] newArray(int i) {
        return new AppContentCardEntity[i];
    }
}

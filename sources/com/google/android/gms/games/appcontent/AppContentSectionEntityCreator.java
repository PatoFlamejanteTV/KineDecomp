package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AppContentSectionEntityCreator implements Parcelable.Creator<AppContentSectionEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.c(parcel, 1, appContentSectionEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, appContentSectionEntity.l());
        zzb.c(parcel, 3, appContentSectionEntity.d(), false);
        zzb.a(parcel, 4, appContentSectionEntity.f(), false);
        zzb.a(parcel, 5, appContentSectionEntity.g(), false);
        zzb.a(parcel, 6, appContentSectionEntity.i(), false);
        zzb.a(parcel, 7, appContentSectionEntity.j(), false);
        zzb.a(parcel, 8, appContentSectionEntity.k(), false);
        zzb.a(parcel, 9, appContentSectionEntity.h(), false);
        zzb.a(parcel, 10, appContentSectionEntity.e(), false);
        zzb.c(parcel, 14, appContentSectionEntity.c(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        String str6 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    arrayList3 = zza.c(parcel, a2, AppContentActionEntity.CREATOR);
                    break;
                case 3:
                    arrayList2 = zza.c(parcel, a2, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str6 = zza.p(parcel, a2);
                    break;
                case 5:
                    bundle = zza.r(parcel, a2);
                    break;
                case 6:
                    str5 = zza.p(parcel, a2);
                    break;
                case 7:
                    str4 = zza.p(parcel, a2);
                    break;
                case 8:
                    str3 = zza.p(parcel, a2);
                    break;
                case 9:
                    str2 = zza.p(parcel, a2);
                    break;
                case 10:
                    str = zza.p(parcel, a2);
                    break;
                case 14:
                    arrayList = zza.c(parcel, a2, AppContentAnnotationEntity.CREATOR);
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
        return new AppContentSectionEntity(i, arrayList3, arrayList2, str6, bundle, str5, str4, str3, str2, str, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity[] newArray(int i) {
        return new AppContentSectionEntity[i];
    }
}

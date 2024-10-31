package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class AppContentAnnotationEntityCreator implements Parcelable.Creator<AppContentAnnotationEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, appContentAnnotationEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, appContentAnnotationEntity.k());
        zzb.a(parcel, 2, (Parcelable) appContentAnnotationEntity.f(), i, false);
        zzb.a(parcel, 3, appContentAnnotationEntity.j(), false);
        zzb.a(parcel, 5, appContentAnnotationEntity.c(), false);
        zzb.a(parcel, 6, appContentAnnotationEntity.i(), false);
        zzb.a(parcel, 7, appContentAnnotationEntity.d(), false);
        zzb.a(parcel, 8, appContentAnnotationEntity.e());
        zzb.a(parcel, 9, appContentAnnotationEntity.h());
        zzb.a(parcel, 10, appContentAnnotationEntity.g(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = zza.b(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str5 = zza.p(parcel, a2);
                    break;
                case 2:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 3:
                    str4 = zza.p(parcel, a2);
                    break;
                case 5:
                    str3 = zza.p(parcel, a2);
                    break;
                case 6:
                    str2 = zza.p(parcel, a2);
                    break;
                case 7:
                    str = zza.p(parcel, a2);
                    break;
                case 8:
                    i2 = zza.g(parcel, a2);
                    break;
                case 9:
                    i = zza.g(parcel, a2);
                    break;
                case 10:
                    bundle = zza.r(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i3 = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AppContentAnnotationEntity(i3, str5, uri, str4, str3, str2, str, i2, i, bundle);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity[] newArray(int i) {
        return new AppContentAnnotationEntity[i];
    }
}

package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class GameEntityCreator implements Parcelable.Creator<GameEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GameEntity gameEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, gameEntity.b(), false);
        zzb.a(parcel, 2, gameEntity.c(), false);
        zzb.a(parcel, 3, gameEntity.d(), false);
        zzb.a(parcel, 4, gameEntity.e(), false);
        zzb.a(parcel, 5, gameEntity.f(), false);
        zzb.a(parcel, 6, gameEntity.g(), false);
        zzb.a(parcel, 7, (Parcelable) gameEntity.h(), i, false);
        zzb.a(parcel, 8, (Parcelable) gameEntity.j(), i, false);
        zzb.a(parcel, 9, (Parcelable) gameEntity.l(), i, false);
        zzb.a(parcel, 10, gameEntity.n());
        zzb.a(parcel, 11, gameEntity.q());
        zzb.a(parcel, 12, gameEntity.r(), false);
        zzb.a(parcel, 13, gameEntity.s());
        zzb.a(parcel, 14, gameEntity.t());
        zzb.a(parcel, 15, gameEntity.u());
        zzb.a(parcel, 17, gameEntity.w());
        zzb.a(parcel, 16, gameEntity.v());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, gameEntity.A());
        zzb.a(parcel, 19, gameEntity.k(), false);
        zzb.a(parcel, 18, gameEntity.i(), false);
        zzb.a(parcel, 21, gameEntity.o());
        zzb.a(parcel, 20, gameEntity.m(), false);
        zzb.a(parcel, 23, gameEntity.x());
        zzb.a(parcel, 22, gameEntity.p());
        zzb.a(parcel, 25, gameEntity.z());
        zzb.a(parcel, 24, gameEntity.y(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
        boolean z8 = false;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str = zza.p(parcel, a2);
                    break;
                case 2:
                    str2 = zza.p(parcel, a2);
                    break;
                case 3:
                    str3 = zza.p(parcel, a2);
                    break;
                case 4:
                    str4 = zza.p(parcel, a2);
                    break;
                case 5:
                    str5 = zza.p(parcel, a2);
                    break;
                case 6:
                    str6 = zza.p(parcel, a2);
                    break;
                case 7:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 10:
                    z = zza.c(parcel, a2);
                    break;
                case 11:
                    z2 = zza.c(parcel, a2);
                    break;
                case 12:
                    str7 = zza.p(parcel, a2);
                    break;
                case 13:
                    i2 = zza.g(parcel, a2);
                    break;
                case 14:
                    i3 = zza.g(parcel, a2);
                    break;
                case 15:
                    i4 = zza.g(parcel, a2);
                    break;
                case 16:
                    z3 = zza.c(parcel, a2);
                    break;
                case 17:
                    z4 = zza.c(parcel, a2);
                    break;
                case 18:
                    str8 = zza.p(parcel, a2);
                    break;
                case 19:
                    str9 = zza.p(parcel, a2);
                    break;
                case 20:
                    str10 = zza.p(parcel, a2);
                    break;
                case 21:
                    z5 = zza.c(parcel, a2);
                    break;
                case 22:
                    z6 = zza.c(parcel, a2);
                    break;
                case 23:
                    z7 = zza.c(parcel, a2);
                    break;
                case 24:
                    str11 = zza.p(parcel, a2);
                    break;
                case 25:
                    z8 = zza.c(parcel, a2);
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
        return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11, z8);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameEntity[] newArray(int i) {
        return new GameEntity[i];
    }
}

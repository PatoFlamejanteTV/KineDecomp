package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class QuestEntityCreator implements Parcelable.Creator<QuestEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(QuestEntity questEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, (Parcelable) questEntity.j(), i, false);
        zzb.a(parcel, 2, questEntity.b(), false);
        zzb.a(parcel, 3, questEntity.m());
        zzb.a(parcel, 4, (Parcelable) questEntity.e(), i, false);
        zzb.a(parcel, 5, questEntity.f(), false);
        zzb.a(parcel, 6, questEntity.d(), false);
        zzb.a(parcel, 7, questEntity.n());
        zzb.a(parcel, 8, questEntity.o());
        zzb.a(parcel, 9, (Parcelable) questEntity.g(), i, false);
        zzb.a(parcel, 10, questEntity.h(), false);
        zzb.a(parcel, 12, questEntity.c(), false);
        zzb.a(parcel, 13, questEntity.p());
        zzb.a(parcel, 14, questEntity.q());
        zzb.a(parcel, 15, questEntity.k());
        zzb.c(parcel, 17, questEntity.i(), false);
        zzb.a(parcel, 16, questEntity.l());
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, questEntity.r());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QuestEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    gameEntity = (GameEntity) zza.a(parcel, a2, GameEntity.CREATOR);
                    break;
                case 2:
                    str = zza.p(parcel, a2);
                    break;
                case 3:
                    j = zza.i(parcel, a2);
                    break;
                case 4:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 5:
                    str2 = zza.p(parcel, a2);
                    break;
                case 6:
                    str3 = zza.p(parcel, a2);
                    break;
                case 7:
                    j2 = zza.i(parcel, a2);
                    break;
                case 8:
                    j3 = zza.i(parcel, a2);
                    break;
                case 9:
                    uri2 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 10:
                    str4 = zza.p(parcel, a2);
                    break;
                case 12:
                    str5 = zza.p(parcel, a2);
                    break;
                case 13:
                    j4 = zza.i(parcel, a2);
                    break;
                case 14:
                    j5 = zza.i(parcel, a2);
                    break;
                case 15:
                    i2 = zza.g(parcel, a2);
                    break;
                case 16:
                    i3 = zza.g(parcel, a2);
                    break;
                case 17:
                    arrayList = zza.c(parcel, a2, MilestoneEntity.CREATOR);
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
        return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QuestEntity[] newArray(int i) {
        return new QuestEntity[i];
    }
}

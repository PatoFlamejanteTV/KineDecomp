package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class ParticipantEntityCreator implements Parcelable.Creator<ParticipantEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, participantEntity.k(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, participantEntity.n());
        zzb.a(parcel, 2, participantEntity.f(), false);
        zzb.a(parcel, 3, (Parcelable) participantEntity.g(), i, false);
        zzb.a(parcel, 4, (Parcelable) participantEntity.i(), i, false);
        zzb.a(parcel, 5, participantEntity.b());
        zzb.a(parcel, 6, participantEntity.c(), false);
        zzb.a(parcel, 7, participantEntity.e());
        zzb.a(parcel, 8, (Parcelable) participantEntity.l(), i, false);
        zzb.a(parcel, 9, participantEntity.d());
        zzb.a(parcel, 10, (Parcelable) participantEntity.m(), i, false);
        zzb.a(parcel, 11, participantEntity.h(), false);
        zzb.a(parcel, 12, participantEntity.j(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 5:
                    i2 = zza.g(parcel, a2);
                    break;
                case 6:
                    str3 = zza.p(parcel, a2);
                    break;
                case 7:
                    z = zza.c(parcel, a2);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) zza.a(parcel, a2, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = zza.g(parcel, a2);
                    break;
                case 10:
                    participantResult = (ParticipantResult) zza.a(parcel, a2, ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = zza.p(parcel, a2);
                    break;
                case 12:
                    str5 = zza.p(parcel, a2);
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
        return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParticipantEntity[] newArray(int i) {
        return new ParticipantEntity[i];
    }
}

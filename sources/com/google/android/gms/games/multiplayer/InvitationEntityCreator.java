package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class InvitationEntityCreator implements Parcelable.Creator<InvitationEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, (Parcelable) invitationEntity.d(), i, false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, invitationEntity.k());
        zzb.a(parcel, 2, invitationEntity.e(), false);
        zzb.a(parcel, 3, invitationEntity.g());
        zzb.a(parcel, 4, invitationEntity.h());
        zzb.a(parcel, 5, (Parcelable) invitationEntity.f(), i, false);
        zzb.c(parcel, 6, invitationEntity.l(), false);
        zzb.a(parcel, 7, invitationEntity.i());
        zzb.a(parcel, 8, invitationEntity.j());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public InvitationEntity createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int b = zza.b(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    i3 = zza.g(parcel, a2);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) zza.a(parcel, a2, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = zza.c(parcel, a2, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = zza.g(parcel, a2);
                    break;
                case 8:
                    i = zza.g(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i4 = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }
}

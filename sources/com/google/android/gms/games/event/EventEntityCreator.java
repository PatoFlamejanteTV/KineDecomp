package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class EventEntityCreator implements Parcelable.Creator<EventEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(EventEntity eventEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, eventEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, eventEntity.k());
        zzb.a(parcel, 2, eventEntity.c(), false);
        zzb.a(parcel, 3, eventEntity.d(), false);
        zzb.a(parcel, 4, (Parcelable) eventEntity.e(), i, false);
        zzb.a(parcel, 5, eventEntity.f(), false);
        zzb.a(parcel, 6, (Parcelable) eventEntity.g(), i, false);
        zzb.a(parcel, 7, eventEntity.h());
        zzb.a(parcel, 8, eventEntity.i(), false);
        zzb.a(parcel, 9, eventEntity.j());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = zza.b(parcel);
        long j = 0;
        PlayerEntity playerEntity = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str5 = zza.p(parcel, a2);
                    break;
                case 2:
                    str4 = zza.p(parcel, a2);
                    break;
                case 3:
                    str3 = zza.p(parcel, a2);
                    break;
                case 4:
                    uri = (Uri) zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 5:
                    str2 = zza.p(parcel, a2);
                    break;
                case 6:
                    playerEntity = (PlayerEntity) zza.a(parcel, a2, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = zza.i(parcel, a2);
                    break;
                case 8:
                    str = zza.p(parcel, a2);
                    break;
                case 9:
                    z = zza.c(parcel, a2);
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
        return new EventEntity(i, str5, str4, str3, uri, str2, playerEntity, j, str, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EventEntity[] newArray(int i) {
        return new EventEntity[i];
    }
}

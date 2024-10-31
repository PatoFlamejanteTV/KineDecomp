package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class MilestoneEntityCreator implements Parcelable.Creator<MilestoneEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, milestoneEntity.b(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, milestoneEntity.h());
        zzb.a(parcel, 2, milestoneEntity.c());
        zzb.a(parcel, 3, milestoneEntity.f());
        zzb.a(parcel, 4, milestoneEntity.g(), false);
        zzb.a(parcel, 5, milestoneEntity.e());
        zzb.a(parcel, 6, milestoneEntity.d(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int b = zza.b(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    str2 = zza.p(parcel, a2);
                    break;
                case 2:
                    j2 = zza.i(parcel, a2);
                    break;
                case 3:
                    j = zza.i(parcel, a2);
                    break;
                case 4:
                    bArr = zza.s(parcel, a2);
                    break;
                case 5:
                    i = zza.g(parcel, a2);
                    break;
                case 6:
                    str = zza.p(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MilestoneEntity[] newArray(int i) {
        return new MilestoneEntity[i];
    }
}

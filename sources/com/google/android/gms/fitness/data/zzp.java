package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzp implements Parcelable.Creator<Session> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Session session, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, session.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, session.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, session.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, session.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, session.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, session.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, session.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) session.f(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, session.j(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Session createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        Long l = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Application application = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    application = (Application) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Application.CREATOR);
                    break;
                case 9:
                    l = com.google.android.gms.common.internal.safeparcel.zza.j(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Session(i2, j2, j, str3, str2, str, i, application, l);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Session[] newArray(int i) {
        return new Session[i];
    }
}

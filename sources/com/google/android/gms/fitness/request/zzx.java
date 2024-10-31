package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.Session;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzx implements Parcelable.Creator<SessionStartRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SessionStartRequest sessionStartRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) sessionStartRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sessionStartRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, sessionStartRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionStartRequest createFromParcel(Parcel parcel) {
        IBinder q;
        Session session;
        int i;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Session session2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Session session3 = (Session) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Session.CREATOR);
                    i = i2;
                    q = iBinder;
                    session = session3;
                    break;
                case 2:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    session = session2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder2 = iBinder;
                    session = session2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SessionStartRequest(i2, session2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionStartRequest[] newArray(int i) {
        return new SessionStartRequest[i];
    }
}

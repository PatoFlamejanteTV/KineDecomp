package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzz implements Parcelable.Creator<SessionUnregistrationRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SessionUnregistrationRequest sessionUnregistrationRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) sessionUnregistrationRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sessionUnregistrationRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, sessionUnregistrationRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionUnregistrationRequest createFromParcel(Parcel parcel) {
        IBinder q;
        PendingIntent pendingIntent;
        int i;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        PendingIntent pendingIntent2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    PendingIntent pendingIntent3 = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    i = i2;
                    q = iBinder;
                    pendingIntent = pendingIntent3;
                    break;
                case 2:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    pendingIntent = pendingIntent2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder2 = iBinder;
                    pendingIntent = pendingIntent2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    pendingIntent = pendingIntent2;
                    i = i2;
                    break;
            }
            i2 = i;
            pendingIntent2 = pendingIntent;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SessionUnregistrationRequest(i2, pendingIntent2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionUnregistrationRequest[] newArray(int i) {
        return new SessionUnregistrationRequest[i];
    }
}

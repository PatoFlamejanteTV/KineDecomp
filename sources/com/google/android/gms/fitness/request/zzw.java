package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzw implements Parcelable.Creator<SessionRegistrationRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SessionRegistrationRequest sessionRegistrationRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) sessionRegistrationRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sessionRegistrationRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, sessionRegistrationRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, sessionRegistrationRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionRegistrationRequest createFromParcel(Parcel parcel) {
        int g;
        IBinder iBinder;
        PendingIntent pendingIntent;
        int i;
        IBinder iBinder2 = null;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        PendingIntent pendingIntent2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i3;
                    IBinder iBinder3 = iBinder2;
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    g = i2;
                    iBinder = iBinder3;
                    break;
                case 2:
                    pendingIntent = pendingIntent2;
                    i = i3;
                    int i4 = i2;
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    g = i4;
                    break;
                case 4:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = i3;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    int i5 = i2;
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i5;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i2;
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = i3;
                    break;
            }
            i3 = i;
            pendingIntent2 = pendingIntent;
            iBinder2 = iBinder;
            i2 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SessionRegistrationRequest(i3, pendingIntent2, iBinder2, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionRegistrationRequest[] newArray(int i) {
        return new SessionRegistrationRequest[i];
    }
}

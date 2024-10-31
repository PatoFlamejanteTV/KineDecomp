package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzr implements Parcelable.Creator<UnsubscribeRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, unsubscribeRequest.f2118a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, unsubscribeRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, unsubscribeRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) unsubscribeRequest.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, unsubscribeRequest.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, unsubscribeRequest.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, unsubscribeRequest.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UnsubscribeRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 3:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new UnsubscribeRequest(i2, iBinder2, iBinder, pendingIntent, i, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UnsubscribeRequest[] newArray(int i) {
        return new UnsubscribeRequest[i];
    }
}

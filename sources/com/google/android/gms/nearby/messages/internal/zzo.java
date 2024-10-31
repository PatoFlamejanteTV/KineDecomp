package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzo implements Parcelable.Creator<RegisterStatusCallbackRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RegisterStatusCallbackRequest registerStatusCallbackRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, registerStatusCallbackRequest.f2115a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, registerStatusCallbackRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, registerStatusCallbackRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, registerStatusCallbackRequest.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RegisterStatusCallbackRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        IBinder iBinder2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 3:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new RegisterStatusCallbackRequest(i, iBinder2, iBinder, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RegisterStatusCallbackRequest[] newArray(int i) {
        return new RegisterStatusCallbackRequest[i];
    }
}

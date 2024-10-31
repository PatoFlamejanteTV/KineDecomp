package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes.dex */
public class zzn implements Parcelable.Creator<PublishRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PublishRequest publishRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, publishRequest.f2114a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) publishRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) publishRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, publishRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, publishRequest.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, publishRequest.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, publishRequest.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, publishRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PublishRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        String str2 = null;
        IBinder iBinder2 = null;
        Strategy strategy = null;
        MessageWrapper messageWrapper = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    messageWrapper = (MessageWrapper) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MessageWrapper.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 8:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PublishRequest(i, messageWrapper, strategy, iBinder2, str2, str, z, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PublishRequest[] newArray(int i) {
        return new PublishRequest[i];
    }
}

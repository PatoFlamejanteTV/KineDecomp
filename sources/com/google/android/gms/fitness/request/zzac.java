package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.Subscription;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzac implements Parcelable.Creator<SubscribeRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) subscribeRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, subscribeRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, subscribeRequest.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, subscribeRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest createFromParcel(Parcel parcel) {
        IBinder q;
        boolean z;
        Subscription subscription;
        int i;
        IBinder iBinder = null;
        boolean z2 = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Subscription subscription2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i2;
                    boolean z3 = z2;
                    subscription = (Subscription) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Subscription.CREATOR);
                    q = iBinder;
                    z = z3;
                    break;
                case 2:
                    subscription = subscription2;
                    i = i2;
                    IBinder iBinder2 = iBinder;
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    q = iBinder2;
                    break;
                case 3:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    z = z2;
                    subscription = subscription2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder3 = iBinder;
                    z = z2;
                    subscription = subscription2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    z = z2;
                    subscription = subscription2;
                    i = i2;
                    break;
            }
            i2 = i;
            subscription2 = subscription;
            z2 = z;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SubscribeRequest(i2, subscription2, z2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}

package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes.dex */
public class zzp implements Parcelable.Creator<SubscribeRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, subscribeRequest.f2116a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, subscribeRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) subscribeRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, subscribeRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) subscribeRequest.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) subscribeRequest.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, subscribeRequest.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, subscribeRequest.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, subscribeRequest.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, subscribeRequest.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, subscribeRequest.k);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, subscribeRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        boolean z = false;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 3:
                    strategy = (Strategy) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 5:
                    messageFilter = (MessageFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                case 11:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 12:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SubscribeRequest(i, iBinder, strategy, iBinder2, messageFilter, pendingIntent, i2, str, str2, bArr, z, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}

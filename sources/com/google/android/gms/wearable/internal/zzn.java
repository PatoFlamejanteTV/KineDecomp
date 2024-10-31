package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzn implements Parcelable.Creator<ChannelEventParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ChannelEventParcelable channelEventParcelable, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, channelEventParcelable.f2335a);
        zzb.a(parcel, 2, (Parcelable) channelEventParcelable.b, i, false);
        zzb.a(parcel, 3, channelEventParcelable.c);
        zzb.a(parcel, 4, channelEventParcelable.d);
        zzb.a(parcel, 5, channelEventParcelable.e);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChannelEventParcelable createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    channelImpl = (ChannelImpl) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ChannelImpl.CREATOR);
                    break;
                case 3:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ChannelEventParcelable(i4, channelImpl, i3, i2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChannelEventParcelable[] newArray(int i) {
        return new ChannelEventParcelable[i];
    }
}

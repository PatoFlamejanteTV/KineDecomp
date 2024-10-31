package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<MessageFilter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MessageFilter messageFilter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 1, messageFilter.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, messageFilter.b);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, messageFilter.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, messageFilter.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageFilter createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, MessageType.CREATOR);
                    break;
                case 2:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, NearbyDeviceFilter.CREATOR);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
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
        return new MessageFilter(i, arrayList2, arrayList, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }
}

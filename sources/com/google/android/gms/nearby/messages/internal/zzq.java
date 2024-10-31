package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzq implements Parcelable.Creator<UnpublishRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UnpublishRequest unpublishRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, unpublishRequest.f2117a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) unpublishRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, unpublishRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, unpublishRequest.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, unpublishRequest.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UnpublishRequest createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        IBinder iBinder = null;
        MessageWrapper messageWrapper = null;
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
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
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
        return new UnpublishRequest(i, messageWrapper, iBinder, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UnpublishRequest[] newArray(int i) {
        return new UnpublishRequest[i];
    }
}

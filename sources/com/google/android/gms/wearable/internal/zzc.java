package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<AddListenerRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AddListenerRequest addListenerRequest, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, addListenerRequest.f2330a);
        zzb.a(parcel, 2, addListenerRequest.a(), false);
        zzb.a(parcel, 3, (Parcelable[]) addListenerRequest.c, i, false);
        zzb.a(parcel, 4, addListenerRequest.d, false);
        zzb.a(parcel, 5, addListenerRequest.e, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddListenerRequest createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        IntentFilter[] intentFilterArr = null;
        IBinder iBinder = null;
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
                    intentFilterArr = (IntentFilter[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, IntentFilter.CREATOR);
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
        return new AddListenerRequest(i, iBinder, intentFilterArr, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddListenerRequest[] newArray(int i) {
        return new AddListenerRequest[i];
    }
}

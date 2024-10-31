package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<ProvideContentRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ProvideContentRequest provideContentRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, provideContentRequest.f2134a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, provideContentRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, provideContentRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, provideContentRequest.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, provideContentRequest.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, provideContentRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProvideContentRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        ArrayList arrayList = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 3:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, SharedContent.CREATOR);
                    break;
                case 5:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 6:
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
        return new ProvideContentRequest(i, iBinder3, iBinder2, arrayList, j, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProvideContentRequest[] newArray(int i) {
        return new ProvideContentRequest[i];
    }
}

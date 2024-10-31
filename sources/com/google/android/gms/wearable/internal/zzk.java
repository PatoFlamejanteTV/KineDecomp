package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzk implements Parcelable.Creator<CapabilityInfoParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CapabilityInfoParcelable capabilityInfoParcelable, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, capabilityInfoParcelable.f2334a);
        zzb.a(parcel, 2, capabilityInfoParcelable.a(), false);
        zzb.c(parcel, 3, capabilityInfoParcelable.b(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CapabilityInfoParcelable createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, NodeParcelable.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CapabilityInfoParcelable(i, str, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CapabilityInfoParcelable[] newArray(int i) {
        return new CapabilityInfoParcelable[i];
    }
}

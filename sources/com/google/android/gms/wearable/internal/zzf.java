package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<AmsEntityUpdateParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, amsEntityUpdateParcelable.f2332a);
        zzb.a(parcel, 2, amsEntityUpdateParcelable.a());
        zzb.a(parcel, 3, amsEntityUpdateParcelable.b());
        zzb.a(parcel, 4, amsEntityUpdateParcelable.c(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AmsEntityUpdateParcelable createFromParcel(Parcel parcel) {
        byte b = 0;
        int b2 = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        byte b3 = 0;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 3:
                    b = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b2) {
            throw new zza.C0032zza("Overread allowed size end=" + b2, parcel);
        }
        return new AmsEntityUpdateParcelable(i, b3, b, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AmsEntityUpdateParcelable[] newArray(int i) {
        return new AmsEntityUpdateParcelable[i];
    }
}

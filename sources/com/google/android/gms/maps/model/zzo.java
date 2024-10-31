package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzo implements Parcelable.Creator<TileOverlayOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, tileOverlayOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, tileOverlayOptions.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, tileOverlayOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, tileOverlayOptions.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, tileOverlayOptions.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
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
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new TileOverlayOptions(i, iBinder, z, f, z2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}

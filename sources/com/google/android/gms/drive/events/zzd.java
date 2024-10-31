package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzd implements Parcelable.Creator<ChangesAvailableOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, changesAvailableOptions.f1069a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, changesAvailableOptions.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, changesAvailableOptions.c);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, changesAvailableOptions.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangesAvailableOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveSpace.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ChangesAvailableOptions(i2, i, z, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangesAvailableOptions[] newArray(int i) {
        return new ChangesAvailableOptions[i];
    }
}

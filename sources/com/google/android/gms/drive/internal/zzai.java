package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzai implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getDriveIdFromUniqueIdentifierRequest.f1093a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, getDriveIdFromUniqueIdentifierRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getDriveIdFromUniqueIdentifierRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetDriveIdFromUniqueIdentifierRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        int i = 0;
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
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetDriveIdFromUniqueIdentifierRequest[] newArray(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}

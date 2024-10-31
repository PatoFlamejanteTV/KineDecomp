package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.Permission;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzal implements Parcelable.Creator<GetPermissionsResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getPermissionsResponse.f1096a);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, getPermissionsResponse.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getPermissionsResponse.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetPermissionsResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, Permission.CREATOR);
                    break;
                case 3:
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
        return new GetPermissionsResponse(i2, arrayList, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetPermissionsResponse[] newArray(int i) {
        return new GetPermissionsResponse[i];
    }
}

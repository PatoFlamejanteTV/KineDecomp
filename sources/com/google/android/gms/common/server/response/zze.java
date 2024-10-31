package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<SafeParcelResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, safeParcelResponse.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, safeParcelResponse.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) safeParcelResponse.f(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    parcel2 = com.google.android.gms.common.internal.safeparcel.zza.E(parcel, a2);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}

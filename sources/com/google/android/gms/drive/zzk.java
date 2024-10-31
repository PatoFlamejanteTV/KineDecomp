package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzk implements Parcelable.Creator<UserMetadata> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UserMetadata userMetadata, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, userMetadata.f1065a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, userMetadata.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, userMetadata.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, userMetadata.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, userMetadata.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, userMetadata.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UserMetadata createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
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
        return new UserMetadata(i, str4, str3, str2, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UserMetadata[] newArray(int i) {
        return new UserMetadata[i];
    }
}

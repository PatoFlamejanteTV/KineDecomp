package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzi implements Parcelable.Creator<Permission> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Permission permission, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, permission.f1063a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, permission.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, permission.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, permission.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, permission.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, permission.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, permission.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Permission createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 7:
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
        return new Permission(i3, str3, i2, str2, str, i, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Permission[] newArray(int i) {
        return new Permission[i];
    }
}

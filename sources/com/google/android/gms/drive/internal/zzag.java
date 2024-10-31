package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzag implements Parcelable.Creator<FileUploadPreferencesImpl> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, fileUploadPreferencesImpl.f1091a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, fileUploadPreferencesImpl.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, fileUploadPreferencesImpl.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, fileUploadPreferencesImpl.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileUploadPreferencesImpl createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
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
        return new FileUploadPreferencesImpl(i3, i2, i, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileUploadPreferencesImpl[] newArray(int i) {
        return new FileUploadPreferencesImpl[i];
    }
}

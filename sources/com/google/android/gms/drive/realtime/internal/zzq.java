package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzq implements Parcelable.Creator<ParcelableCollaborator> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, parcelableCollaborator.f1174a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, parcelableCollaborator.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, parcelableCollaborator.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, parcelableCollaborator.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, parcelableCollaborator.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, parcelableCollaborator.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, parcelableCollaborator.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, parcelableCollaborator.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableCollaborator createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
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
        return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableCollaborator[] newArray(int i) {
        return new ParcelableCollaborator[i];
    }
}

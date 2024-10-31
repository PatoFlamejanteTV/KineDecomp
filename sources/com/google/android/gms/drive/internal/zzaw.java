package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.Contents;

/* loaded from: classes2.dex */
public class zzaw implements Parcelable.Creator<OnContentsResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, onContentsResponse.f1100a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) onContentsResponse.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, onContentsResponse.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        boolean c;
        Contents contents;
        int i;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Contents contents2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    boolean z2 = z;
                    contents = contents2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = z2;
                    break;
                case 2:
                    Contents contents3 = (Contents) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Contents.CREATOR);
                    i = i2;
                    c = z;
                    contents = contents3;
                    break;
                case 3:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    contents = contents2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = z;
                    contents = contents2;
                    i = i2;
                    break;
            }
            i2 = i;
            contents2 = contents;
            z = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OnContentsResponse(i2, contents2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}

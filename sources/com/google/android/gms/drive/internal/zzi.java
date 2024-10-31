package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.Contents;

/* loaded from: classes2.dex */
public class zzi implements Parcelable.Creator<CloseContentsRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, closeContentsRequest.f1081a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) closeContentsRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, closeContentsRequest.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, closeContentsRequest.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        int g;
        Boolean bool;
        Contents contents;
        int i;
        Boolean bool2 = null;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Contents contents2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i4 = i2;
                    bool = bool2;
                    contents = contents2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i4;
                    break;
                case 2:
                    i = i3;
                    Boolean bool3 = bool2;
                    contents = (Contents) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Contents.CREATOR);
                    g = i2;
                    bool = bool3;
                    break;
                case 3:
                    contents = contents2;
                    i = i3;
                    int i5 = i2;
                    bool = com.google.android.gms.common.internal.safeparcel.zza.d(parcel, a2);
                    g = i5;
                    break;
                case 4:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    bool = bool2;
                    contents = contents2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i2;
                    bool = bool2;
                    contents = contents2;
                    i = i3;
                    break;
            }
            i3 = i;
            contents2 = contents;
            bool2 = bool;
            i2 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CloseContentsRequest(i3, contents2, bool2, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}

package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<AppContentReceivedResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppContentReceivedResult appContentReceivedResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, appContentReceivedResult.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) appContentReceivedResult.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, appContentReceivedResult.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentReceivedResult createFromParcel(Parcel parcel) {
        int g;
        Uri uri;
        int i;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Uri uri2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i4 = i2;
                    uri = uri2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i4;
                    break;
                case 2:
                    Uri uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    i = i3;
                    g = i2;
                    uri = uri3;
                    break;
                case 3:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    uri = uri2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i2;
                    uri = uri2;
                    i = i3;
                    break;
            }
            i3 = i;
            uri2 = uri;
            i2 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AppContentReceivedResult(i3, uri2, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppContentReceivedResult[] newArray(int i) {
        return new AppContentReceivedResult[i];
    }
}

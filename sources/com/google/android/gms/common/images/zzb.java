package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<WebImage> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(WebImage webImage, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, webImage.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) webImage.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, webImage.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, webImage.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WebImage createFromParcel(Parcel parcel) {
        int g;
        int i;
        Uri uri;
        int i2;
        int i3 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Uri uri2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i6 = i3;
                    i = i4;
                    uri = uri2;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i6;
                    break;
                case 2:
                    i2 = i5;
                    int i7 = i4;
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    g = i3;
                    i = i7;
                    break;
                case 3:
                    uri = uri2;
                    i2 = i5;
                    int i8 = i3;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i8;
                    break;
                case 4:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i3;
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            uri2 = uri;
            i4 = i;
            i3 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new WebImage(i5, uri2, i4, i3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WebImage[] newArray(int i) {
        return new WebImage[i];
    }
}

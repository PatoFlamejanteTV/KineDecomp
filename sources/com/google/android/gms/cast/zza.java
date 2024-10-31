package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ApplicationMetadata> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, applicationMetadata.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, applicationMetadata.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, applicationMetadata.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, applicationMetadata.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 5, applicationMetadata.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, applicationMetadata.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) applicationMetadata.e(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ApplicationMetadata createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        ArrayList arrayList2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, WebImage.CREATOR);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ApplicationMetadata(i, str3, str2, arrayList2, arrayList, str, uri);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ApplicationMetadata[] newArray(int i) {
        return new ApplicationMetadata[i];
    }
}

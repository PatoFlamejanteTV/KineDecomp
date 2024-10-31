package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<ConnectionResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, connectionResult.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, connectionResult.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) connectionResult.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, connectionResult.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionResult createFromParcel(Parcel parcel) {
        String p;
        PendingIntent pendingIntent;
        int i;
        int i2;
        String str = null;
        int i3 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        PendingIntent pendingIntent2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    String str2 = str;
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str2;
                    break;
                case 2:
                    i2 = i4;
                    PendingIntent pendingIntent3 = pendingIntent2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str;
                    pendingIntent = pendingIntent3;
                    break;
                case 3:
                    i = i3;
                    i2 = i4;
                    String str3 = str;
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    p = str3;
                    break;
                case 4:
                    p = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = i4;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    p = str;
                    pendingIntent = pendingIntent2;
                    i = i3;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            i3 = i;
            pendingIntent2 = pendingIntent;
            str = p;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ConnectionResult(i4, i3, pendingIntent2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}

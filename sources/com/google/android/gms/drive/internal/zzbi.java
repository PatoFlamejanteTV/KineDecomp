package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzbi implements Parcelable.Creator<OnStartStreamSession> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OnStartStreamSession onStartStreamSession, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, onStartStreamSession.f1112a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) onStartStreamSession.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, onStartStreamSession.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, onStartStreamSession.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnStartStreamSession createFromParcel(Parcel parcel) {
        String p;
        IBinder iBinder;
        ParcelFileDescriptor parcelFileDescriptor;
        int i;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        IBinder iBinder2 = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    String str2 = str;
                    iBinder = iBinder2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str2;
                    break;
                case 2:
                    i = i2;
                    IBinder iBinder3 = iBinder2;
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    p = str;
                    iBinder = iBinder3;
                    break;
                case 3:
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i2;
                    String str3 = str;
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    p = str3;
                    break;
                case 4:
                    p = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    iBinder = iBinder2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    p = str;
                    iBinder = iBinder2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i2;
                    break;
            }
            i2 = i;
            parcelFileDescriptor2 = parcelFileDescriptor;
            iBinder2 = iBinder;
            str = p;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OnStartStreamSession(i2, parcelFileDescriptor2, iBinder2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnStartStreamSession[] newArray(int i) {
        return new OnStartStreamSession[i];
    }
}

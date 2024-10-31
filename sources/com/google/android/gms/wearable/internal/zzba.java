package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzba implements Parcelable.Creator<MessageEventParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MessageEventParcelable messageEventParcelable, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, messageEventParcelable.f2356a);
        zzb.a(parcel, 2, messageEventParcelable.a());
        zzb.a(parcel, 3, messageEventParcelable.b(), false);
        zzb.a(parcel, 4, messageEventParcelable.c(), false);
        zzb.a(parcel, 5, messageEventParcelable.d(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageEventParcelable createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                case 5:
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
        return new MessageEventParcelable(i2, i, str2, bArr, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageEventParcelable[] newArray(int i) {
        return new MessageEventParcelable[i];
    }
}

package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzk implements Parcelable.Creator<QueryResultEventParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, queryResultEventParcelable.f1073a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) queryResultEventParcelable.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, queryResultEventParcelable.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, queryResultEventParcelable.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QueryResultEventParcelable createFromParcel(Parcel parcel) {
        int g;
        boolean z;
        DataHolder dataHolder;
        int i;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DataHolder dataHolder2 = null;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i4 = i2;
                    z = z2;
                    dataHolder = dataHolder2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i4;
                    break;
                case 2:
                    i = i3;
                    boolean z3 = z2;
                    dataHolder = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataHolder.CREATOR);
                    g = i2;
                    z = z3;
                    break;
                case 3:
                    dataHolder = dataHolder2;
                    i = i3;
                    int i5 = i2;
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    g = i5;
                    break;
                case 4:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    z = z2;
                    dataHolder = dataHolder2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i2;
                    z = z2;
                    dataHolder = dataHolder2;
                    i = i3;
                    break;
            }
            i3 = i;
            dataHolder2 = dataHolder;
            z2 = z;
            i2 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new QueryResultEventParcelable(i3, dataHolder2, z2, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QueryResultEventParcelable[] newArray(int i) {
        return new QueryResultEventParcelable[i];
    }
}

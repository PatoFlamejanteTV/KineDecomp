package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzmj;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<LabelValueRow> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LabelValueRow labelValueRow, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, labelValueRow.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, labelValueRow.f2317a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, labelValueRow.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, labelValueRow.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LabelValueRow createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList zzqs = zzmj.zzqs();
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    zzqs = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LabelValue.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LabelValueRow(i, str2, str, zzqs);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LabelValueRow[] newArray(int i) {
        return new LabelValueRow[i];
    }
}

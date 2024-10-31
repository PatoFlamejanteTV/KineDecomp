package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzb implements Parcelable.Creator<ChangesAvailableEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ChangesAvailableEvent changesAvailableEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, changesAvailableEvent.f1068a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, changesAvailableEvent.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) changesAvailableEvent.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangesAvailableEvent createFromParcel(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    changesAvailableOptions = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ChangesAvailableOptions.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ChangesAvailableEvent(i, str, changesAvailableOptions);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangesAvailableEvent[] newArray(int i) {
        return new ChangesAvailableEvent[i];
    }
}

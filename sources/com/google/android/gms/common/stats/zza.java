package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 6:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 8:
                    j2 = SafeParcelReader.C(parcel, a2);
                    break;
                case 10:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 11:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 12:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 13:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 14:
                    i4 = SafeParcelReader.A(parcel, a2);
                    break;
                case 15:
                    f2 = SafeParcelReader.x(parcel, a2);
                    break;
                case 16:
                    j3 = SafeParcelReader.C(parcel, a2);
                    break;
                case 17:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 18:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f2, j3, str5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}

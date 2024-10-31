package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public final class zzbbi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbbi> CREATOR = new zzbbj();
    public String zzdp;
    public int zzeou;
    public int zzeov;
    public boolean zzeow;
    public boolean zzeox;

    public zzbbi(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public static zzbbi zzaav() {
        return new zzbbi(12451009, 12451009, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzdp, false);
        SafeParcelWriter.a(parcel, 3, this.zzeou);
        SafeParcelWriter.a(parcel, 4, this.zzeov);
        SafeParcelWriter.a(parcel, 5, this.zzeow);
        SafeParcelWriter.a(parcel, 6, this.zzeox);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzbbi(int i, int i2, boolean z, boolean z2) {
        this(14300000, i2, true, false, z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzbbi(int r9, int r10, boolean r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            if (r11 == 0) goto L5
            java.lang.String r12 = "0"
            goto L7
        L5:
            java.lang.String r12 = "1"
        L7:
            int r0 = r12.length()
            int r0 = r0 + 36
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "afma-sdk-a-v"
            r1.append(r0)
            r1.append(r9)
            java.lang.String r0 = "."
            r1.append(r0)
            r1.append(r10)
            r1.append(r0)
            r1.append(r12)
            java.lang.String r3 = r1.toString()
            r2 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbi.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    public zzbbi(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) boolean z2) {
        this.zzdp = str;
        this.zzeou = i;
        this.zzeov = i2;
        this.zzeow = z;
        this.zzeox = z2;
    }
}

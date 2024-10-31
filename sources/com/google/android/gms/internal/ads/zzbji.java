package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzbji extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbji> CREATOR = new zzbjj();
    private final int versionCode;
    private zzbl zzfcw = null;
    private byte[] zzfcx;

    @SafeParcelable.Constructor
    public zzbji(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzfcx = bArr;
        zzafo();
    }

    private final void zzafo() {
        if (this.zzfcw != null || this.zzfcx == null) {
            if (this.zzfcw == null || this.zzfcx != null) {
                if (this.zzfcw != null && this.zzfcx != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.zzfcw == null && this.zzfcx == null) {
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Impossible");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.versionCode);
        byte[] bArr = this.zzfcx;
        if (bArr == null) {
            bArr = zzbuz.zzb(this.zzfcw);
        }
        SafeParcelWriter.a(parcel, 2, bArr, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final zzbl zzafn() {
        if (!(this.zzfcw != null)) {
            try {
                byte[] bArr = this.zzfcx;
                zzbl zzblVar = new zzbl();
                zzbuz.zza(zzblVar, bArr);
                this.zzfcw = zzblVar;
                this.zzfcx = null;
            } catch (zzbuy e2) {
                throw new IllegalStateException(e2);
            }
        }
        zzafo();
        return this.zzfcw;
    }
}

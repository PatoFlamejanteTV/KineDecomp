package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;

/* loaded from: classes2.dex */
public final class zzdg extends AbstractSafeParcelable implements com.google.firebase.auth.api.internal.zzdw<zzdg, zzj.C0083zzj> {
    public static final Parcelable.Creator<zzdg> CREATOR = new zzdi();
    private String zzgh;
    private String zzpf;
    private String zzpn;

    public zzdg() {
    }

    public final String getEmail() {
        return this.zzgh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzgh, false);
        SafeParcelWriter.a(parcel, 3, this.zzpn, false);
        SafeParcelWriter.a(parcel, 4, this.zzpf, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzj.C0083zzj) {
            zzj.C0083zzj c0083zzj = (zzj.C0083zzj) zzhcVar;
            this.zzgh = Strings.a(c0083zzj.getEmail());
            this.zzpn = Strings.a(c0083zzj.zzad());
            int i = C1242c.f13018a[c0083zzj.zzae().ordinal()];
            this.zzpf = i != 1 ? i != 2 ? null : "PASSWORD_RESET" : "VERIFY_EMAIL";
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of ResetPasswordResponse.");
    }

    public final String zzad() {
        return this.zzpn;
    }

    public final zzhm<zzj.C0083zzj> zzdj() {
        return zzj.C0083zzj.zzl();
    }

    public final String zzea() {
        return this.zzpf;
    }

    @SafeParcelable.Constructor
    public zzdg(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3) {
        this.zzgh = str;
        this.zzpn = str2;
        this.zzpf = str3;
    }
}

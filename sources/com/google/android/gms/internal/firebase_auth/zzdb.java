package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new zzdc();
    private String zzgb;
    private String zzgh;
    private String zzhq;
    private String zzhw;
    private String zzhx;
    private String zzpk;
    private String zzpl;

    public zzdb() {
    }

    public final String getDisplayName() {
        return this.zzhw;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPhoneNumber() {
        return this.zzhq;
    }

    public final Uri getPhotoUri() {
        if (TextUtils.isEmpty(this.zzhx)) {
            return null;
        }
        return Uri.parse(this.zzhx);
    }

    public final String getProviderId() {
        return this.zzgb;
    }

    public final String getRawUserInfo() {
        return this.zzpl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzpk, false);
        SafeParcelWriter.a(parcel, 3, this.zzhw, false);
        SafeParcelWriter.a(parcel, 4, this.zzhx, false);
        SafeParcelWriter.a(parcel, 5, this.zzgb, false);
        SafeParcelWriter.a(parcel, 6, this.zzpl, false);
        SafeParcelWriter.a(parcel, 7, this.zzhq, false);
        SafeParcelWriter.a(parcel, 8, this.zzgh, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzbg() {
        return this.zzpk;
    }

    public final void zzcg(String str) {
        this.zzpl = str;
    }

    @SafeParcelable.Constructor
    public zzdb(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7) {
        this.zzpk = str;
        this.zzhw = str2;
        this.zzhx = str3;
        this.zzgb = str4;
        this.zzpl = str5;
        this.zzhq = str6;
        this.zzgh = str7;
    }
}

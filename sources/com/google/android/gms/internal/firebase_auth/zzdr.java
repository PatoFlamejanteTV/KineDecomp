package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzdr extends AbstractSafeParcelable implements zzff<zzj.zzp> {
    public static final Parcelable.Creator<zzdr> CREATOR = new zzds();
    private String zzgb;
    private String zzgc;
    private String zzgd;
    private String zzgf;
    private String zzgh;
    private String zzgw;
    private boolean zzhr;
    private boolean zzpt;
    private String zzpx;
    private String zzpy;
    private String zzpz;
    private String zzqa;
    private String zzqb;
    private String zzqc;
    private String zzqd;
    private boolean zzqe;

    public zzdr() {
        this.zzpt = true;
        this.zzhr = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzpx, false);
        SafeParcelWriter.a(parcel, 3, this.zzpy, false);
        SafeParcelWriter.a(parcel, 4, this.zzgc, false);
        SafeParcelWriter.a(parcel, 5, this.zzgd, false);
        SafeParcelWriter.a(parcel, 6, this.zzgb, false);
        SafeParcelWriter.a(parcel, 7, this.zzgh, false);
        SafeParcelWriter.a(parcel, 8, this.zzpz, false);
        SafeParcelWriter.a(parcel, 9, this.zzqa, false);
        SafeParcelWriter.a(parcel, 10, this.zzpt);
        SafeParcelWriter.a(parcel, 11, this.zzhr);
        SafeParcelWriter.a(parcel, 12, this.zzqb, false);
        SafeParcelWriter.a(parcel, 13, this.zzqc, false);
        SafeParcelWriter.a(parcel, 14, this.zzqd, false);
        SafeParcelWriter.a(parcel, 15, this.zzgw, false);
        SafeParcelWriter.a(parcel, 16, this.zzqe);
        SafeParcelWriter.a(parcel, 17, this.zzgf, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final zzdr zzcq(String str) {
        Preconditions.b(str);
        this.zzpy = str;
        return this;
    }

    public final zzdr zzcr(String str) {
        this.zzgw = str;
        return this;
    }

    public final /* synthetic */ zzhc zzds() {
        zzj.zzp.zza zzk = zzj.zzp.zzas().zzi(this.zzpt).zzk(this.zzhr);
        String str = this.zzpy;
        if (str != null) {
            zzk.zzbe(str);
        }
        String str2 = this.zzpx;
        if (str2 != null) {
            zzk.zzbb(str2);
        }
        String str3 = this.zzpz;
        if (str3 != null) {
            zzk.zzbc(str3);
        }
        String str4 = this.zzgw;
        if (str4 != null) {
            zzk.zzbf(str4);
        }
        String str5 = this.zzgf;
        if (str5 != null) {
            zzk.zzbg(str5);
        }
        if (!TextUtils.isEmpty(this.zzqc)) {
            zzk.zzbd(this.zzqc);
        }
        if (!TextUtils.isEmpty(this.zzqd)) {
            zzk.zzbb(this.zzqd);
        }
        zzk.zzj(this.zzqe);
        return (zzj.zzp) zzk.zzhn();
    }

    public final zzdr zzp(boolean z) {
        this.zzhr = false;
        return this;
    }

    public final zzdr zzq(boolean z) {
        this.zzqe = z;
        return this;
    }

    @SafeParcelable.Constructor
    public zzdr(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) boolean z2, @SafeParcelable.Param(id = 12) String str9, @SafeParcelable.Param(id = 13) String str10, @SafeParcelable.Param(id = 14) String str11, @SafeParcelable.Param(id = 15) String str12, @SafeParcelable.Param(id = 16) boolean z3, @SafeParcelable.Param(id = 17) String str13) {
        this.zzpx = str;
        this.zzpy = str2;
        this.zzgc = str3;
        this.zzgd = str4;
        this.zzgb = str5;
        this.zzgh = str6;
        this.zzpz = str7;
        this.zzqa = str8;
        this.zzpt = z;
        this.zzhr = z2;
        this.zzqb = str9;
        this.zzqc = str10;
        this.zzqd = str11;
        this.zzgw = str12;
        this.zzqe = z3;
        this.zzgf = str13;
    }

    public zzdr(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.zzpx = "http://localhost";
        this.zzgc = str;
        this.zzgd = str2;
        this.zzqa = str5;
        this.zzqb = str6;
        this.zzgw = str7;
        this.zzgf = str8;
        this.zzpt = true;
        if (TextUtils.isEmpty(this.zzgc) && TextUtils.isEmpty(this.zzgd) && TextUtils.isEmpty(this.zzqb)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        Preconditions.b(str3);
        this.zzgb = str3;
        this.zzgh = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.zzgc)) {
            sb.append("id_token=");
            sb.append(this.zzgc);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzgd)) {
            sb.append("access_token=");
            sb.append(this.zzgd);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzgh)) {
            sb.append("identifier=");
            sb.append(this.zzgh);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzqa)) {
            sb.append("oauth_token_secret=");
            sb.append(this.zzqa);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzqb)) {
            sb.append("code=");
            sb.append(this.zzqb);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.zzgb);
        this.zzpz = sb.toString();
        this.zzhr = true;
    }
}

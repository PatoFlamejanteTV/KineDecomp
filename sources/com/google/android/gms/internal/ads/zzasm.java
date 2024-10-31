package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzasm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasm> CREATOR = new zzasn();
    public final int errorCode;
    public final int orientation;
    private final int versionCode;
    public final String zzbde;
    public final boolean zzbph;
    public final boolean zzbpi;
    public final String zzcgx;
    public final boolean zzckn;
    public final boolean zzcko;
    public final boolean zzckp;
    public final List<String> zzdlq;
    public final List<String> zzdlr;
    public final List<String> zzdls;
    public final List<String> zzdlu;
    public final boolean zzdlv;
    public final long zzdlx;
    private zzasi zzdnh;
    public final boolean zzdwn;
    public final boolean zzdxb;
    public String zzdxc;
    public final boolean zzdxn;
    public String zzdyb;
    public final long zzdyc;
    public final boolean zzdyd;
    public final long zzdye;
    public final List<String> zzdyf;
    public final String zzdyg;
    public final long zzdyh;
    public final String zzdyi;
    public final boolean zzdyj;
    public final String zzdyk;
    public final String zzdyl;
    public final boolean zzdym;
    public final boolean zzdyn;
    public final boolean zzdyo;
    private zzasy zzdyp;
    public String zzdyq;
    public final zzawd zzdyr;
    public final List<String> zzdys;
    public final List<String> zzdyt;
    public final boolean zzdyu;
    public final zzaso zzdyv;
    public final String zzdyw;
    public final zzawo zzdyx;
    public final String zzdyy;
    public final boolean zzdyz;
    private Bundle zzdza;
    public final int zzdzb;
    public final boolean zzdzc;
    public final String zzdzd;
    public String zzdze;
    public boolean zzdzf;

    public zzasm(zzasi zzasiVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzawd zzawdVar, List<String> list4, List<String> list5, boolean z10, zzaso zzasoVar, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzawo zzawoVar, String str10, boolean z13, boolean z14, boolean z15, int i2, boolean z16, List<String> list7, boolean z17, String str11, String str12, boolean z18) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, zzawdVar, list4, list5, z10, zzasoVar, z11, str8, list6, z12, str9, zzawoVar, str10, z13, z14, null, z15, 0, z16, list7, z17, str11, str12, z18);
        this.zzdnh = zzasiVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzasi zzasiVar = this.zzdnh;
        if (zzasiVar != null && zzasiVar.versionCode >= 9 && !TextUtils.isEmpty(this.zzdyb)) {
            this.zzdyp = new zzasy(new zzatm(this.zzdyb));
            this.zzdyb = null;
        }
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.versionCode);
        SafeParcelWriter.a(parcel, 2, this.zzbde, false);
        SafeParcelWriter.a(parcel, 3, this.zzdyb, false);
        SafeParcelWriter.c(parcel, 4, this.zzdlq, false);
        SafeParcelWriter.a(parcel, 5, this.errorCode);
        SafeParcelWriter.c(parcel, 6, this.zzdlr, false);
        SafeParcelWriter.a(parcel, 7, this.zzdyc);
        SafeParcelWriter.a(parcel, 8, this.zzdyd);
        SafeParcelWriter.a(parcel, 9, this.zzdye);
        SafeParcelWriter.c(parcel, 10, this.zzdyf, false);
        SafeParcelWriter.a(parcel, 11, this.zzdlx);
        SafeParcelWriter.a(parcel, 12, this.orientation);
        SafeParcelWriter.a(parcel, 13, this.zzdyg, false);
        SafeParcelWriter.a(parcel, 14, this.zzdyh);
        SafeParcelWriter.a(parcel, 15, this.zzdyi, false);
        SafeParcelWriter.a(parcel, 18, this.zzdyj);
        SafeParcelWriter.a(parcel, 19, this.zzdyk, false);
        SafeParcelWriter.a(parcel, 21, this.zzdyl, false);
        SafeParcelWriter.a(parcel, 22, this.zzdym);
        SafeParcelWriter.a(parcel, 23, this.zzckn);
        SafeParcelWriter.a(parcel, 24, this.zzdwn);
        SafeParcelWriter.a(parcel, 25, this.zzdyn);
        SafeParcelWriter.a(parcel, 26, this.zzdyo);
        SafeParcelWriter.a(parcel, 28, (Parcelable) this.zzdyp, i, false);
        SafeParcelWriter.a(parcel, 29, this.zzdyq, false);
        SafeParcelWriter.a(parcel, 30, this.zzcgx, false);
        SafeParcelWriter.a(parcel, 31, this.zzcko);
        SafeParcelWriter.a(parcel, 32, this.zzckp);
        SafeParcelWriter.a(parcel, 33, (Parcelable) this.zzdyr, i, false);
        SafeParcelWriter.c(parcel, 34, this.zzdys, false);
        SafeParcelWriter.c(parcel, 35, this.zzdyt, false);
        SafeParcelWriter.a(parcel, 36, this.zzdyu);
        SafeParcelWriter.a(parcel, 37, (Parcelable) this.zzdyv, i, false);
        SafeParcelWriter.a(parcel, 38, this.zzdxb);
        SafeParcelWriter.a(parcel, 39, this.zzdxc, false);
        SafeParcelWriter.c(parcel, 40, this.zzdlu, false);
        SafeParcelWriter.a(parcel, 42, this.zzdlv);
        SafeParcelWriter.a(parcel, 43, this.zzdyw, false);
        SafeParcelWriter.a(parcel, 44, (Parcelable) this.zzdyx, i, false);
        SafeParcelWriter.a(parcel, 45, this.zzdyy, false);
        SafeParcelWriter.a(parcel, 46, this.zzdyz);
        SafeParcelWriter.a(parcel, 47, this.zzdxn);
        SafeParcelWriter.a(parcel, 48, this.zzdza, false);
        SafeParcelWriter.a(parcel, 49, this.zzbph);
        SafeParcelWriter.a(parcel, 50, this.zzdzb);
        SafeParcelWriter.a(parcel, 51, this.zzdzc);
        SafeParcelWriter.c(parcel, 52, this.zzdls, false);
        SafeParcelWriter.a(parcel, 53, this.zzbpi);
        SafeParcelWriter.a(parcel, 54, this.zzdzd, false);
        SafeParcelWriter.a(parcel, 55, this.zzdze, false);
        SafeParcelWriter.a(parcel, 56, this.zzdzf);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzasm(zzasi zzasiVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzawd zzawdVar, List<String> list4, List<String> list5, boolean z9, zzaso zzasoVar, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzawo zzawoVar, String str9, boolean z12, boolean z13, boolean z14, int i2, boolean z15, List<String> list7, boolean z16, String str10, String str11, boolean z17) {
        this(19, str, str2, list, -2, list2, j, z, -1L, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, false, null, null, str6, z7, z8, zzawdVar, list4, list5, z9, zzasoVar, z10, str7, list6, z11, str8, zzawoVar, str9, z12, z13, null, z14, i2, z15, list7, z16, str10, str11, z17);
        this.zzdnh = zzasiVar;
    }

    public zzasm(int i) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null, null, false);
    }

    public zzasm(int i, long j) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, j, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null, null, false);
    }

    @SafeParcelable.Constructor
    public zzasm(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<String> list, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 7) long j, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) List<String> list3, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) long j4, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 18) boolean z2, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 21) String str6, @SafeParcelable.Param(id = 22) boolean z3, @SafeParcelable.Param(id = 23) boolean z4, @SafeParcelable.Param(id = 24) boolean z5, @SafeParcelable.Param(id = 25) boolean z6, @SafeParcelable.Param(id = 26) boolean z7, @SafeParcelable.Param(id = 28) zzasy zzasyVar, @SafeParcelable.Param(id = 29) String str7, @SafeParcelable.Param(id = 30) String str8, @SafeParcelable.Param(id = 31) boolean z8, @SafeParcelable.Param(id = 32) boolean z9, @SafeParcelable.Param(id = 33) zzawd zzawdVar, @SafeParcelable.Param(id = 34) List<String> list4, @SafeParcelable.Param(id = 35) List<String> list5, @SafeParcelable.Param(id = 36) boolean z10, @SafeParcelable.Param(id = 37) zzaso zzasoVar, @SafeParcelable.Param(id = 38) boolean z11, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 40) List<String> list6, @SafeParcelable.Param(id = 42) boolean z12, @SafeParcelable.Param(id = 43) String str10, @SafeParcelable.Param(id = 44) zzawo zzawoVar, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) boolean z13, @SafeParcelable.Param(id = 47) boolean z14, @SafeParcelable.Param(id = 48) Bundle bundle, @SafeParcelable.Param(id = 49) boolean z15, @SafeParcelable.Param(id = 50) int i4, @SafeParcelable.Param(id = 51) boolean z16, @SafeParcelable.Param(id = 52) List<String> list7, @SafeParcelable.Param(id = 53) boolean z17, @SafeParcelable.Param(id = 54) String str12, @SafeParcelable.Param(id = 55) String str13, @SafeParcelable.Param(id = 56) boolean z18) {
        zzasy zzasyVar2;
        zzatm zzatmVar;
        this.versionCode = i;
        this.zzbde = str;
        this.zzdyb = str2;
        this.zzdlq = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdlr = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdyc = j;
        this.zzdyd = z;
        this.zzdye = j2;
        this.zzdyf = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdlx = j3;
        this.orientation = i3;
        this.zzdyg = str3;
        this.zzdyh = j4;
        this.zzdyi = str4;
        this.zzdyj = z2;
        this.zzdyk = str5;
        this.zzdyl = str6;
        this.zzdym = z3;
        this.zzckn = z4;
        this.zzdwn = z5;
        this.zzdyn = z6;
        this.zzdyz = z13;
        this.zzdyo = z7;
        this.zzdyp = zzasyVar;
        this.zzdyq = str7;
        this.zzcgx = str8;
        if (this.zzdyb == null && (zzasyVar2 = this.zzdyp) != null && (zzatmVar = (zzatm) zzasyVar2.zza(zzatm.CREATOR)) != null && !TextUtils.isEmpty(zzatmVar.zzczq)) {
            this.zzdyb = zzatmVar.zzczq;
        }
        this.zzcko = z8;
        this.zzckp = z9;
        this.zzdyr = zzawdVar;
        this.zzdys = list4;
        this.zzdyt = list5;
        this.zzdyu = z10;
        this.zzdyv = zzasoVar;
        this.zzdxb = z11;
        this.zzdxc = str9;
        this.zzdlu = list6;
        this.zzdlv = z12;
        this.zzdyw = str10;
        this.zzdyx = zzawoVar;
        this.zzdyy = str11;
        this.zzdxn = z14;
        this.zzdza = bundle;
        this.zzbph = z15;
        this.zzdzb = i4;
        this.zzdzc = z16;
        this.zzdls = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.zzbpi = z17;
        this.zzdzd = str12;
        this.zzdze = str13;
        this.zzdzf = z18;
    }
}

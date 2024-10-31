package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzasi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasi> CREATOR = new zzask();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzbsm;
    public final String zzbsn;
    public final zzbbi zzbsp;
    public final zzwf zzbst;
    public final zzacp zzbti;
    public final zzafz zzbtk;
    public final zzyv zzbtl;
    public final List<Integer> zzbtn;
    public final List<String> zzbtt;
    public final float zzbwv;
    public final String zzclm;
    public final boolean zzdlv;
    public final Bundle zzdwf;
    public final zzwb zzdwg;
    public final PackageInfo zzdwh;
    public final String zzdwi;
    public final String zzdwj;
    public final Bundle zzdwk;
    public final int zzdwl;
    public final Bundle zzdwm;
    public final boolean zzdwn;
    public final int zzdwo;
    public final int zzdwp;
    public final String zzdwq;
    public final long zzdwr;
    public final String zzdws;
    public final List<String> zzdwt;
    public final List<String> zzdwu;
    public final long zzdwv;
    public final String zzdww;
    public final float zzdwx;
    public final int zzdwy;
    public final int zzdwz;
    public final boolean zzdxa;
    public final boolean zzdxb;
    public final String zzdxc;
    public final boolean zzdxd;
    public final String zzdxe;
    public final int zzdxf;
    public final Bundle zzdxg;
    public final String zzdxh;
    public final boolean zzdxi;
    public final Bundle zzdxj;
    public final String zzdxk;
    public final String zzdxl;
    public final String zzdxm;
    public final boolean zzdxn;
    public final String zzdxo;
    public final List<String> zzdxp;
    public final int zzdxq;
    public final boolean zzdxr;
    public final boolean zzdxs;
    public final boolean zzdxt;
    public final ArrayList<String> zzdxu;
    public final String zzdxv;
    public final String zzdxw;
    public final Bundle zzdxx;

    private zzasi(Bundle bundle, zzwb zzwbVar, zzwf zzwfVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzbbi zzbbiVar, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f2, String str5, long j, String str6, List<String> list3, String str7, zzacp zzacpVar, long j2, String str8, float f3, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, zzyv zzyvVar, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList, String str16, zzafz zzafzVar, String str17, Bundle bundle6) {
        this(24, bundle, zzwbVar, zzwfVar, str, applicationInfo, packageInfo, str2, str3, str4, zzbbiVar, bundle2, i, list, bundle3, z, i2, i3, f2, str5, j, str6, list3, str7, zzacpVar, list2, j2, str8, f3, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, zzyvVar, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9, z10, arrayList, str16, zzafzVar, str17, bundle6);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.versionCode);
        SafeParcelWriter.a(parcel, 2, this.zzdwf, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.zzdwg, i, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.zzbst, i, false);
        SafeParcelWriter.a(parcel, 5, this.zzbsn, false);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.applicationInfo, i, false);
        SafeParcelWriter.a(parcel, 7, (Parcelable) this.zzdwh, i, false);
        SafeParcelWriter.a(parcel, 8, this.zzdwi, false);
        SafeParcelWriter.a(parcel, 9, this.zzdwj, false);
        SafeParcelWriter.a(parcel, 10, this.zzclm, false);
        SafeParcelWriter.a(parcel, 11, (Parcelable) this.zzbsp, i, false);
        SafeParcelWriter.a(parcel, 12, this.zzdwk, false);
        SafeParcelWriter.a(parcel, 13, this.zzdwl);
        SafeParcelWriter.c(parcel, 14, this.zzbtt, false);
        SafeParcelWriter.a(parcel, 15, this.zzdwm, false);
        SafeParcelWriter.a(parcel, 16, this.zzdwn);
        SafeParcelWriter.a(parcel, 18, this.zzdwo);
        SafeParcelWriter.a(parcel, 19, this.zzdwp);
        SafeParcelWriter.a(parcel, 20, this.zzbwv);
        SafeParcelWriter.a(parcel, 21, this.zzdwq, false);
        SafeParcelWriter.a(parcel, 25, this.zzdwr);
        SafeParcelWriter.a(parcel, 26, this.zzdws, false);
        SafeParcelWriter.c(parcel, 27, this.zzdwt, false);
        SafeParcelWriter.a(parcel, 28, this.zzbsm, false);
        SafeParcelWriter.a(parcel, 29, (Parcelable) this.zzbti, i, false);
        SafeParcelWriter.c(parcel, 30, this.zzdwu, false);
        SafeParcelWriter.a(parcel, 31, this.zzdwv);
        SafeParcelWriter.a(parcel, 33, this.zzdww, false);
        SafeParcelWriter.a(parcel, 34, this.zzdwx);
        SafeParcelWriter.a(parcel, 35, this.zzdwy);
        SafeParcelWriter.a(parcel, 36, this.zzdwz);
        SafeParcelWriter.a(parcel, 37, this.zzdxa);
        SafeParcelWriter.a(parcel, 38, this.zzdxb);
        SafeParcelWriter.a(parcel, 39, this.zzdxc, false);
        SafeParcelWriter.a(parcel, 40, this.zzdxd);
        SafeParcelWriter.a(parcel, 41, this.zzdxe, false);
        SafeParcelWriter.a(parcel, 42, this.zzdlv);
        SafeParcelWriter.a(parcel, 43, this.zzdxf);
        SafeParcelWriter.a(parcel, 44, this.zzdxg, false);
        SafeParcelWriter.a(parcel, 45, this.zzdxh, false);
        SafeParcelWriter.a(parcel, 46, (Parcelable) this.zzbtl, i, false);
        SafeParcelWriter.a(parcel, 47, this.zzdxi);
        SafeParcelWriter.a(parcel, 48, this.zzdxj, false);
        SafeParcelWriter.a(parcel, 49, this.zzdxk, false);
        SafeParcelWriter.a(parcel, 50, this.zzdxl, false);
        SafeParcelWriter.a(parcel, 51, this.zzdxm, false);
        SafeParcelWriter.a(parcel, 52, this.zzdxn);
        SafeParcelWriter.a(parcel, 53, this.zzbtn, false);
        SafeParcelWriter.a(parcel, 54, this.zzdxo, false);
        SafeParcelWriter.c(parcel, 55, this.zzdxp, false);
        SafeParcelWriter.a(parcel, 56, this.zzdxq);
        SafeParcelWriter.a(parcel, 57, this.zzdxr);
        SafeParcelWriter.a(parcel, 58, this.zzdxs);
        SafeParcelWriter.a(parcel, 59, this.zzdxt);
        SafeParcelWriter.c(parcel, 60, this.zzdxu, false);
        SafeParcelWriter.a(parcel, 61, this.zzdxv, false);
        SafeParcelWriter.a(parcel, 63, (Parcelable) this.zzbtk, i, false);
        SafeParcelWriter.a(parcel, 64, this.zzdxw, false);
        SafeParcelWriter.a(parcel, 65, this.zzdxx, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzasi(zzasj zzasjVar, long j, String str, String str2, String str3, String str4) {
        this(zzasjVar.zzdwf, zzasjVar.zzdwg, zzasjVar.zzbst, zzasjVar.zzbsn, zzasjVar.applicationInfo, zzasjVar.zzdwh, (String) zzbbq.zza(zzasjVar.zzdxz, ""), zzasjVar.zzdwj, zzasjVar.zzclm, zzasjVar.zzbsp, zzasjVar.zzdwk, zzasjVar.zzdwl, zzasjVar.zzbtt, zzasjVar.zzdwu, zzasjVar.zzdwm, zzasjVar.zzdwn, zzasjVar.zzdwo, zzasjVar.zzdwp, zzasjVar.zzbwv, zzasjVar.zzdwq, zzasjVar.zzdwr, zzasjVar.zzdws, zzasjVar.zzdwt, zzasjVar.zzbsm, zzasjVar.zzbti, j, zzasjVar.zzdww, zzasjVar.zzdwx, zzasjVar.zzdxd, zzasjVar.zzdwy, zzasjVar.zzdwz, zzasjVar.zzdxa, zzasjVar.zzdxb, (String) zzbbq.zza(zzasjVar.zzdxy, "", 1L, TimeUnit.SECONDS), zzasjVar.zzdxe, zzasjVar.zzdlv, zzasjVar.zzdxf, zzasjVar.zzdxg, zzasjVar.zzdxh, zzasjVar.zzbtl, zzasjVar.zzdxi, zzasjVar.zzdxj, str, str2, str3, zzasjVar.zzdxn, zzasjVar.zzbtn, zzasjVar.zzdxo, zzasjVar.zzdxp, zzasjVar.zzdxq, zzasjVar.zzdxr, zzasjVar.zzdxs, zzasjVar.zzdxt, zzasjVar.zzdxu, zzasjVar.zzdxv, zzasjVar.zzbtk, str4, zzasjVar.zzdxx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzasi(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzwb zzwbVar, @SafeParcelable.Param(id = 4) zzwf zzwfVar, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzbbi zzbbiVar, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i2, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) int i3, @SafeParcelable.Param(id = 19) int i4, @SafeParcelable.Param(id = 20) float f2, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzacp zzacpVar, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j2, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f3, @SafeParcelable.Param(id = 40) boolean z2, @SafeParcelable.Param(id = 35) int i5, @SafeParcelable.Param(id = 36) int i6, @SafeParcelable.Param(id = 37) boolean z3, @SafeParcelable.Param(id = 38) boolean z4, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z5, @SafeParcelable.Param(id = 43) int i7, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzyv zzyvVar, @SafeParcelable.Param(id = 47) boolean z6, @SafeParcelable.Param(id = 48) Bundle bundle5, @SafeParcelable.Param(id = 49) String str12, @SafeParcelable.Param(id = 50) String str13, @SafeParcelable.Param(id = 51) String str14, @SafeParcelable.Param(id = 52) boolean z7, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i8, @SafeParcelable.Param(id = 57) boolean z8, @SafeParcelable.Param(id = 58) boolean z9, @SafeParcelable.Param(id = 59) boolean z10, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzafz zzafzVar, @SafeParcelable.Param(id = 64) String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        List<String> unmodifiableList;
        List<String> unmodifiableList2;
        this.versionCode = i;
        this.zzdwf = bundle;
        this.zzdwg = zzwbVar;
        this.zzbst = zzwfVar;
        this.zzbsn = str;
        this.applicationInfo = applicationInfo;
        this.zzdwh = packageInfo;
        this.zzdwi = str2;
        this.zzdwj = str3;
        this.zzclm = str4;
        this.zzbsp = zzbbiVar;
        this.zzdwk = bundle2;
        this.zzdwl = i2;
        this.zzbtt = list;
        if (list3 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list3);
        }
        this.zzdwu = unmodifiableList;
        this.zzdwm = bundle3;
        this.zzdwn = z;
        this.zzdwo = i3;
        this.zzdwp = i4;
        this.zzbwv = f2;
        this.zzdwq = str5;
        this.zzdwr = j;
        this.zzdws = str6;
        if (list2 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list2);
        }
        this.zzdwt = unmodifiableList2;
        this.zzbsm = str7;
        this.zzbti = zzacpVar;
        this.zzdwv = j2;
        this.zzdww = str8;
        this.zzdwx = f3;
        this.zzdxd = z2;
        this.zzdwy = i5;
        this.zzdwz = i6;
        this.zzdxa = z3;
        this.zzdxb = z4;
        this.zzdxc = str9;
        this.zzdxe = str10;
        this.zzdlv = z5;
        this.zzdxf = i7;
        this.zzdxg = bundle4;
        this.zzdxh = str11;
        this.zzbtl = zzyvVar;
        this.zzdxi = z6;
        this.zzdxj = bundle5;
        this.zzdxk = str12;
        this.zzdxl = str13;
        this.zzdxm = str14;
        this.zzdxn = z7;
        this.zzbtn = list4;
        this.zzdxo = str15;
        this.zzdxp = list5;
        this.zzdxq = i8;
        this.zzdxr = z8;
        this.zzdxs = z9;
        this.zzdxt = z10;
        this.zzdxu = arrayList;
        this.zzdxv = str16;
        this.zzbtk = zzafzVar;
        this.zzdxw = str17;
        this.zzdxx = bundle6;
    }
}

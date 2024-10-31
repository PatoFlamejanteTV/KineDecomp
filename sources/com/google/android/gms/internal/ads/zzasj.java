package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@zzark
/* loaded from: classes2.dex */
public final class zzasj {
    public final ApplicationInfo applicationInfo;
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
    public final String zzdww;
    public final float zzdwx;
    public final int zzdwy;
    public final int zzdwz;
    public final boolean zzdxa;
    public final boolean zzdxb;
    public final boolean zzdxd;
    public final String zzdxe;
    public final int zzdxf;
    public final Bundle zzdxg;
    public final String zzdxh;
    public final boolean zzdxi;
    public final Bundle zzdxj;
    public final boolean zzdxn;
    public final String zzdxo;
    public final List<String> zzdxp;
    public final int zzdxq;
    public final boolean zzdxr;
    public final boolean zzdxs;
    public final boolean zzdxt;
    public final ArrayList<String> zzdxu;
    public final String zzdxv;
    public final Bundle zzdxx;
    public final Future<String> zzdxy;
    public final Future<String> zzdxz;

    public zzasj(Bundle bundle, zzwb zzwbVar, zzwf zzwfVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, zzbbi zzbbiVar, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i, int i2, float f2, String str4, long j, String str5, List<String> list3, String str6, zzacp zzacpVar, String str7, float f3, boolean z2, int i3, int i4, boolean z3, boolean z4, Future<String> future, String str8, boolean z5, int i5, Bundle bundle4, String str9, zzyv zzyvVar, boolean z6, Bundle bundle5, boolean z7, Future<String> future2, List<Integer> list4, String str10, List<String> list5, int i6, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList, String str11, zzafz zzafzVar, Bundle bundle6) {
        this.zzdwf = bundle;
        this.zzdwg = zzwbVar;
        this.zzbst = zzwfVar;
        this.zzbsn = str;
        this.applicationInfo = applicationInfo;
        this.zzdwh = packageInfo;
        this.zzdwj = str2;
        this.zzclm = str3;
        this.zzbsp = zzbbiVar;
        this.zzdwk = bundle2;
        this.zzdwn = z;
        this.zzdwo = i;
        this.zzdwp = i2;
        this.zzbwv = f2;
        if (list != null && list.size() > 0) {
            this.zzdwl = 3;
            this.zzbtt = list;
            this.zzdwu = list2;
        } else {
            this.zzdwl = 0;
            this.zzbtt = null;
            this.zzdwu = null;
        }
        this.zzdwm = bundle3;
        this.zzdwq = str4;
        this.zzdwr = j;
        this.zzdws = str5;
        this.zzdwt = list3;
        this.zzbsm = str6;
        this.zzbti = zzacpVar;
        this.zzdww = str7;
        this.zzdwx = f3;
        this.zzdxd = z2;
        this.zzdwy = i3;
        this.zzdwz = i4;
        this.zzdxa = z3;
        this.zzdxb = z4;
        this.zzdxy = future;
        this.zzdxe = str8;
        this.zzdlv = z5;
        this.zzdxf = i5;
        this.zzdxg = bundle4;
        this.zzdxh = str9;
        this.zzbtl = zzyvVar;
        this.zzdxi = z6;
        this.zzdxj = bundle5;
        this.zzdxn = z7;
        this.zzdxz = future2;
        this.zzbtn = list4;
        this.zzdxo = str10;
        this.zzdxp = list5;
        this.zzdxq = i6;
        this.zzdxr = z8;
        this.zzdxs = z9;
        this.zzdxt = z10;
        this.zzdxu = arrayList;
        this.zzdxv = str11;
        this.zzbtk = zzafzVar;
        this.zzdxx = bundle6;
    }
}

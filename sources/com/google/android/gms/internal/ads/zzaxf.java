package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaxf {
    public final int errorCode;
    public final int orientation;
    public final boolean zzbph;
    public final boolean zzbpi;
    public final List<String> zzdlq;
    public final List<String> zzdlr;
    public final List<String> zzdls;
    public final List<String> zzdlu;
    public final long zzdlx;
    public final zzakq zzdnb;
    public final zzalj zzdnc;
    public final String zzdnd;
    public final zzakt zzdne;
    public final zzbgg zzdrv;
    public final zzwb zzdwg;
    public final String zzdwj;
    private final long zzdyc;
    public final boolean zzdyd;
    private final long zzdye;
    public final List<String> zzdyf;
    public final String zzdyi;
    public final zzawd zzdyr;
    public final List<String> zzdyt;
    public final boolean zzdyu;
    private final zzaso zzdyv;
    public final String zzdyy;
    public final boolean zzdzc;
    private final String zzdzd;
    public final boolean zzdzf;
    public final JSONObject zzehh;
    public boolean zzehi;
    public final zzakr zzehj;
    public final String zzehk;
    public final zzwf zzehl;
    public final List<String> zzehm;
    public final long zzehn;
    public final long zzeho;
    public final zzacf zzehp;
    public boolean zzehq;
    public boolean zzehr;
    public boolean zzehs;
    public boolean zzeht;
    public boolean zzehu;
    public boolean zzehv;
    public final zzum zzehw;
    public final boolean zzehx;

    public zzaxf(zzwb zzwbVar, zzbgg zzbggVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzakq zzakqVar, zzalj zzaljVar, String str2, zzakr zzakrVar, zzakt zzaktVar, long j2, zzwf zzwfVar, long j3, long j4, long j5, String str3, JSONObject jSONObject, zzacf zzacfVar, zzawd zzawdVar, List<String> list4, List<String> list5, boolean z2, zzaso zzasoVar, String str4, List<String> list6, String str5, zzum zzumVar, boolean z3, boolean z4, boolean z5, List<String> list7, boolean z6, String str6, boolean z7) {
        this.zzehq = false;
        this.zzehr = false;
        this.zzehs = false;
        this.zzeht = false;
        this.zzehu = false;
        this.zzehv = false;
        this.zzdwg = zzwbVar;
        this.zzdrv = zzbggVar;
        this.zzdlq = zzn(list);
        this.errorCode = i;
        this.zzdlr = zzn(list2);
        this.zzdyf = zzn(list3);
        this.orientation = i2;
        this.zzdlx = j;
        this.zzdwj = str;
        this.zzdyd = z;
        this.zzdnb = zzakqVar;
        this.zzdnc = zzaljVar;
        this.zzdnd = str2;
        this.zzehj = zzakrVar;
        this.zzdne = zzaktVar;
        this.zzdye = j2;
        this.zzehl = zzwfVar;
        this.zzdyc = j3;
        this.zzehn = j4;
        this.zzeho = j5;
        this.zzdyi = str3;
        this.zzehh = jSONObject;
        this.zzehp = zzacfVar;
        this.zzdyr = zzawdVar;
        this.zzehm = zzn(list4);
        this.zzdyt = zzn(list5);
        this.zzdyu = z2;
        this.zzdyv = zzasoVar;
        this.zzehk = str4;
        this.zzdlu = zzn(list6);
        this.zzdyy = str5;
        this.zzehw = zzumVar;
        this.zzbph = z3;
        this.zzehx = z4;
        this.zzdzc = z5;
        this.zzdls = zzn(list7);
        this.zzbpi = z6;
        this.zzdzd = str6;
        this.zzdzf = z7;
    }

    private static <T> List<T> zzn(List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public final boolean zzmu() {
        zzbgg zzbggVar = this.zzdrv;
        if (zzbggVar == null || zzbggVar.zzadl() == null) {
            return false;
        }
        return this.zzdrv.zzadl().zzmu();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzaxf(com.google.android.gms.internal.ads.zzaxg r47, com.google.android.gms.internal.ads.zzbgg r48, com.google.android.gms.internal.ads.zzakq r49, com.google.android.gms.internal.ads.zzalj r50, java.lang.String r51, com.google.android.gms.internal.ads.zzakt r52, com.google.android.gms.internal.ads.zzacf r53, java.lang.String r54) {
        /*
            r46 = this;
            r0 = r47
            r1 = r46
            com.google.android.gms.internal.ads.zzasi r3 = r0.zzeag
            com.google.android.gms.internal.ads.zzwb r2 = r3.zzdwg
            com.google.android.gms.internal.ads.zzasm r13 = r0.zzehy
            java.util.List<java.lang.String> r4 = r13.zzdlq
            int r5 = r0.errorCode
            java.util.List<java.lang.String> r6 = r13.zzdlr
            java.util.List<java.lang.String> r7 = r13.zzdyf
            int r8 = r13.orientation
            long r9 = r13.zzdlx
            java.lang.String r11 = r3.zzdwj
            boolean r12 = r13.zzdyd
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzehj
            r16 = r3
            long r14 = r13.zzdye
            r18 = r14
            com.google.android.gms.internal.ads.zzwf r3 = r0.zzbst
            r20 = r3
            long r14 = r13.zzdyc
            r21 = r14
            long r14 = r0.zzehn
            r23 = r14
            long r14 = r0.zzeho
            r25 = r14
            java.lang.String r3 = r13.zzdyi
            r27 = r3
            org.json.JSONObject r3 = r0.zzehh
            r28 = r3
            com.google.android.gms.internal.ads.zzawd r3 = r13.zzdyr
            r30 = r3
            java.util.List<java.lang.String> r3 = r13.zzdys
            r31 = r3
            r32 = r3
            boolean r3 = r13.zzdyu
            r33 = r3
            com.google.android.gms.internal.ads.zzaso r3 = r13.zzdyv
            r34 = r3
            java.util.List<java.lang.String> r3 = r13.zzdlu
            r36 = r3
            java.lang.String r3 = r13.zzdyy
            r37 = r3
            com.google.android.gms.internal.ads.zzum r3 = r0.zzehw
            r38 = r3
            boolean r3 = r13.zzbph
            r39 = r3
            boolean r0 = r0.zzehx
            r40 = r0
            boolean r0 = r13.zzdzc
            r41 = r0
            java.util.List<java.lang.String> r0 = r13.zzdls
            r42 = r0
            boolean r0 = r13.zzbpi
            r43 = r0
            java.lang.String r0 = r13.zzdzd
            r44 = r0
            boolean r0 = r13.zzdzf
            r45 = r0
            r3 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r29 = 0
            r35 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxf.<init>(com.google.android.gms.internal.ads.zzaxg, com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzakq, com.google.android.gms.internal.ads.zzalj, java.lang.String, com.google.android.gms.internal.ads.zzakt, com.google.android.gms.internal.ads.zzacf, java.lang.String):void");
    }
}

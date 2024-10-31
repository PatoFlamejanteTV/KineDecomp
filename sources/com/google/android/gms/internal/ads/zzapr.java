package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzapr extends zzaph {
    private final zzaba zzbln;
    private zzalg zzbma;
    private final zzbgg zzdin;
    private zzakr zzdmn;

    @VisibleForTesting
    private zzakp zzdsw;
    protected zzakx zzdsx;
    private boolean zzdsy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapr(Context context, zzaxg zzaxgVar, zzalg zzalgVar, zzapm zzapmVar, zzaba zzabaVar, zzbgg zzbggVar) {
        super(context, zzaxgVar, zzapmVar);
        this.zzbma = zzalgVar;
        this.zzdmn = zzaxgVar.zzehj;
        this.zzbln = zzabaVar;
        this.zzdin = zzbggVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaph, com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        synchronized (this.zzdsn) {
            super.onStop();
            if (this.zzdsw != null) {
                this.zzdsw.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    protected final void zzap(long j) throws zzapk {
        zzakp zzaldVar;
        Bundle bundle;
        synchronized (this.zzdsn) {
            if (this.zzdmn.zzdma != -1) {
                zzaldVar = new zzala(this.mContext, this.zzdsk.zzeag, this.zzbma, this.zzdmn, this.zzdsl.zzckn, this.zzdsl.zzckp, this.zzdsl.zzdyw, j, ((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), 2, this.zzdsk.zzehx);
            } else {
                zzaldVar = new zzald(this.mContext, this.zzdsk.zzeag, this.zzbma, this.zzdmn, this.zzdsl.zzckn, this.zzdsl.zzckp, this.zzdsl.zzdyw, j, ((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), this.zzbln, this.zzdsk.zzehx);
            }
            this.zzdsw = zzaldVar;
        }
        ArrayList arrayList = new ArrayList(this.zzdmn.zzdlp);
        Bundle bundle2 = this.zzdsk.zzeag.zzdwg.zzcjl;
        if ((bundle2 == null || (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) == null) ? false : bundle.getBoolean("_skipMediation")) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzakq) listIterator.next()).zzdkw.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                    listIterator.remove();
                }
            }
        }
        this.zzdsx = this.zzdsw.zzh(arrayList);
        zzakx zzakxVar = this.zzdsx;
        int i = zzakxVar.zzdna;
        if (i != 0) {
            if (i != 1) {
                StringBuilder sb = new StringBuilder(40);
                sb.append("Unexpected mediation result: ");
                sb.append(i);
                throw new zzapk(sb.toString(), 0);
            }
            throw new zzapk("No fill from any mediation ad networks.", 3);
        }
        zzakq zzakqVar = zzakxVar.zzdnb;
        if (zzakqVar == null || zzakqVar.zzdli == null) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zzayh.zzelc.post(new Ub(this, countDownLatch));
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
            synchronized (this.zzdsn) {
                if (this.zzdsy) {
                    if (this.zzdin.isDestroyed()) {
                        throw new zzapk("Assets not loaded, web view is destroyed", 0);
                    }
                } else {
                    throw new zzapk("View could not be prepared", 0);
                }
            }
        } catch (InterruptedException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 38);
            sb2.append("Interrupted while waiting for latch : ");
            sb2.append(valueOf);
            throw new zzapk(sb2.toString(), 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    protected final zzaxf zzcr(int i) {
        String name;
        List<String> list;
        zzaso zzasoVar;
        String str;
        boolean z;
        long j;
        String str2;
        List<String> list2;
        Iterator<zzakx> it;
        String str3;
        boolean z2;
        long j2;
        int i2;
        String str4;
        zzasi zzasiVar = this.zzdsk.zzeag;
        zzwb zzwbVar = zzasiVar.zzdwg;
        zzbgg zzbggVar = this.zzdin;
        zzasm zzasmVar = this.zzdsl;
        List<String> list3 = zzasmVar.zzdlq;
        List<String> list4 = zzasmVar.zzdlr;
        List<String> list5 = zzasmVar.zzdyf;
        int i3 = zzasmVar.orientation;
        long j3 = zzasmVar.zzdlx;
        String str5 = zzasiVar.zzdwj;
        boolean z3 = zzasmVar.zzdyd;
        zzakx zzakxVar = this.zzdsx;
        zzakq zzakqVar = zzakxVar != null ? zzakxVar.zzdnb : null;
        zzakx zzakxVar2 = this.zzdsx;
        zzalj zzaljVar = zzakxVar2 != null ? zzakxVar2.zzdnc : null;
        zzakx zzakxVar3 = this.zzdsx;
        if (zzakxVar3 != null) {
            name = zzakxVar3.zzdnd;
        } else {
            name = AdMobAdapter.class.getName();
        }
        String str6 = name;
        zzakr zzakrVar = this.zzdmn;
        zzakx zzakxVar4 = this.zzdsx;
        zzakt zzaktVar = zzakxVar4 != null ? zzakxVar4.zzdne : null;
        zzasm zzasmVar2 = this.zzdsl;
        zzakq zzakqVar2 = zzakqVar;
        zzalj zzaljVar2 = zzaljVar;
        long j4 = zzasmVar2.zzdye;
        zzaxg zzaxgVar = this.zzdsk;
        zzwf zzwfVar = zzaxgVar.zzbst;
        long j5 = zzasmVar2.zzdyc;
        long j6 = zzaxgVar.zzehn;
        long j7 = zzasmVar2.zzdyh;
        String str7 = zzasmVar2.zzdyi;
        JSONObject jSONObject = zzaxgVar.zzehh;
        zzawd zzawdVar = zzasmVar2.zzdyr;
        List<String> list6 = zzasmVar2.zzdys;
        List<String> list7 = zzasmVar2.zzdyt;
        zzakr zzakrVar2 = this.zzdmn;
        boolean z4 = zzakrVar2 != null ? zzakrVar2.zzdmc : false;
        zzaso zzasoVar2 = this.zzdsl.zzdyv;
        zzakp zzakpVar = this.zzdsw;
        if (zzakpVar != null) {
            List<zzakx> zzui = zzakpVar.zzui();
            if (zzui == null) {
                list = list6;
                zzasoVar = zzasoVar2;
                str = str5;
                z = z3;
                j = j7;
                str2 = "";
            } else {
                Iterator<zzakx> it2 = zzui.iterator();
                String str8 = "";
                while (true) {
                    zzasoVar = zzasoVar2;
                    if (!it2.hasNext()) {
                        break;
                    }
                    zzakx next = it2.next();
                    if (next != null) {
                        it = it2;
                        zzakq zzakqVar3 = next.zzdnb;
                        if (zzakqVar3 == null || TextUtils.isEmpty(zzakqVar3.zzdkx)) {
                            list2 = list6;
                        } else {
                            String valueOf = String.valueOf(str8);
                            j2 = j7;
                            String str9 = next.zzdnb.zzdkx;
                            int i4 = next.zzdna;
                            list2 = list6;
                            if (i4 != -1) {
                                if (i4 == 0) {
                                    str4 = str5;
                                    z2 = z3;
                                    i2 = 0;
                                } else if (i4 == 1) {
                                    str4 = str5;
                                    z2 = z3;
                                    i2 = 1;
                                } else if (i4 == 3) {
                                    i2 = 2;
                                } else if (i4 != 4) {
                                    i2 = 5;
                                    if (i4 != 5) {
                                        i2 = 6;
                                    }
                                } else {
                                    str4 = str5;
                                    z2 = z3;
                                    i2 = 3;
                                }
                                long j8 = next.zzdng;
                                str3 = str4;
                                StringBuilder sb = new StringBuilder(String.valueOf(str9).length() + 33);
                                sb.append(str9);
                                sb.append(".");
                                sb.append(i2);
                                sb.append(".");
                                sb.append(j8);
                                String sb2 = sb.toString();
                                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(sb2).length());
                                sb3.append(valueOf);
                                sb3.append(sb2);
                                sb3.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
                                str8 = sb3.toString();
                                it2 = it;
                                zzasoVar2 = zzasoVar;
                                j7 = j2;
                                list6 = list2;
                                z3 = z2;
                                str5 = str3;
                            } else {
                                i2 = 4;
                            }
                            str4 = str5;
                            z2 = z3;
                            long j82 = next.zzdng;
                            str3 = str4;
                            StringBuilder sb4 = new StringBuilder(String.valueOf(str9).length() + 33);
                            sb4.append(str9);
                            sb4.append(".");
                            sb4.append(i2);
                            sb4.append(".");
                            sb4.append(j82);
                            String sb22 = sb4.toString();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(sb22).length());
                            sb32.append(valueOf);
                            sb32.append(sb22);
                            sb32.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
                            str8 = sb32.toString();
                            it2 = it;
                            zzasoVar2 = zzasoVar;
                            j7 = j2;
                            list6 = list2;
                            z3 = z2;
                            str5 = str3;
                        }
                    } else {
                        list2 = list6;
                        it = it2;
                    }
                    str3 = str5;
                    z2 = z3;
                    j2 = j7;
                    it2 = it;
                    zzasoVar2 = zzasoVar;
                    j7 = j2;
                    list6 = list2;
                    z3 = z2;
                    str5 = str3;
                }
                list = list6;
                str = str5;
                z = z3;
                j = j7;
                str2 = str8.substring(0, Math.max(0, str8.length() - 1));
            }
        } else {
            list = list6;
            zzasoVar = zzasoVar2;
            str = str5;
            z = z3;
            j = j7;
            str2 = null;
        }
        zzasm zzasmVar3 = this.zzdsl;
        List<String> list8 = zzasmVar3.zzdlu;
        String str10 = zzasmVar3.zzdyy;
        zzaxg zzaxgVar2 = this.zzdsk;
        return new zzaxf(zzwbVar, zzbggVar, list3, i, list4, list5, i3, j3, str, z, zzakqVar2, zzaljVar2, str6, zzakrVar, zzaktVar, j4, zzwfVar, j5, j6, j, str7, jSONObject, null, zzawdVar, list, list7, z4, zzasoVar, str2, list8, str10, zzaxgVar2.zzehw, zzasmVar3.zzbph, zzaxgVar2.zzehx, zzasmVar3.zzdzc, zzasmVar3.zzdls, zzasmVar3.zzbpi, zzasmVar3.zzdzd, zzasmVar3.zzdzf);
    }
}

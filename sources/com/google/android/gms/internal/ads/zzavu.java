package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzavu extends zzaxv implements zzavt {
    private final Context mContext;
    private final Object mLock;
    private final zzaxg zzdsk;
    private final long zzeet;
    private final ArrayList<zzavk> zzefh;
    private final List<zzavn> zzefi;
    private final HashSet<String> zzefj;
    private final zzauk zzefk;

    public zzavu(Context context, zzaxg zzaxgVar, zzauk zzaukVar) {
        this(context, zzaxgVar, zzaukVar, ((Long) zzwu.zzpz().zzd(zzaan.zzcrj)).longValue());
    }

    private final zzaxf zza(int i, String str, zzakq zzakqVar) {
        zzaso zzasoVar;
        boolean z;
        String str2;
        boolean z2;
        List<String> list;
        String substring;
        zzaxg zzaxgVar = this.zzdsk;
        zzasi zzasiVar = zzaxgVar.zzeag;
        zzwb zzwbVar = zzasiVar.zzdwg;
        zzasm zzasmVar = zzaxgVar.zzehy;
        List<String> list2 = zzasmVar.zzdlq;
        List<String> list3 = zzasmVar.zzdlr;
        List<String> list4 = zzasmVar.zzdyf;
        int i2 = zzasmVar.orientation;
        long j = zzasmVar.zzdlx;
        String str3 = zzasiVar.zzdwj;
        boolean z3 = zzasmVar.zzdyd;
        zzakr zzakrVar = zzaxgVar.zzehj;
        long j2 = zzasmVar.zzdye;
        zzwf zzwfVar = zzaxgVar.zzbst;
        long j3 = zzasmVar.zzdyc;
        long j4 = zzaxgVar.zzehn;
        long j5 = zzasmVar.zzdyh;
        String str4 = zzasmVar.zzdyi;
        JSONObject jSONObject = zzaxgVar.zzehh;
        zzawd zzawdVar = zzasmVar.zzdyr;
        List<String> list5 = zzasmVar.zzdys;
        List<String> list6 = zzasmVar.zzdyt;
        boolean z4 = zzasmVar.zzdyu;
        zzaso zzasoVar2 = zzasmVar.zzdyv;
        StringBuilder sb = new StringBuilder("");
        List<zzavn> list7 = this.zzefi;
        if (list7 == null) {
            substring = sb.toString();
            zzasoVar = zzasoVar2;
            z = z3;
            str2 = str4;
            z2 = z4;
            list = list5;
        } else {
            Iterator<zzavn> it = list7.iterator();
            while (true) {
                zzasoVar = zzasoVar2;
                if (!it.hasNext()) {
                    break;
                }
                zzavn next = it.next();
                if (next != null) {
                    Iterator<zzavn> it2 = it;
                    if (TextUtils.isEmpty(next.zzdkx)) {
                        it = it2;
                    } else {
                        String str5 = next.zzdkx;
                        String str6 = str4;
                        int i3 = next.errorCode;
                        boolean z5 = z4;
                        List<String> list8 = list5;
                        int i4 = 3;
                        if (i3 == 3) {
                            i4 = 1;
                        } else if (i3 == 4) {
                            i4 = 2;
                        } else if (i3 == 5) {
                            i4 = 4;
                        } else if (i3 == 6) {
                            i4 = 0;
                        } else if (i3 != 7) {
                            i4 = 6;
                        }
                        long j6 = next.zzdng;
                        boolean z6 = z3;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 33);
                        sb2.append(str5);
                        sb2.append(".");
                        sb2.append(i4);
                        sb2.append(".");
                        sb2.append(j6);
                        sb.append(String.valueOf(sb2.toString()).concat(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR));
                        it = it2;
                        zzasoVar2 = zzasoVar;
                        str4 = str6;
                        z4 = z5;
                        z3 = z6;
                        list5 = list8;
                    }
                }
                zzasoVar2 = zzasoVar;
            }
            z = z3;
            str2 = str4;
            z2 = z4;
            list = list5;
            substring = sb.substring(0, Math.max(0, sb.length() - 1));
        }
        zzaxg zzaxgVar2 = this.zzdsk;
        zzasm zzasmVar2 = zzaxgVar2.zzehy;
        return new zzaxf(zzwbVar, null, list2, i, list3, list4, i2, j, str3, z, zzakqVar, null, str, zzakrVar, null, j2, zzwfVar, j3, j4, j5, str2, jSONObject, null, zzawdVar, list, list6, z2, zzasoVar, substring, zzasmVar2.zzdlu, zzasmVar2.zzdyy, zzaxgVar2.zzehw, zzasmVar2.zzbph, zzaxgVar2.zzehx, zzasmVar2.zzdzc, zzasmVar2.zzdls, zzasmVar2.zzbpi, zzasmVar2.zzdzd, zzasmVar2.zzdzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzavt
    public final void zza(String str, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzavt
    public final void zzde(String str) {
        synchronized (this.mLock) {
            this.zzefj.add(str);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:? -> B:28:0x00b7). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        Object obj;
        for (zzakq zzakqVar : this.zzdsk.zzehj.zzdlp) {
            String str = zzakqVar.zzdle;
            for (String str2 : zzakqVar.zzdkw) {
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str2) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {
                    try {
                        str2 = new JSONObject(str).getString("class_name");
                    } catch (JSONException e2) {
                        zzbbd.zzb("Unable to determine custom event class name, skipping...", e2);
                    }
                }
                String str3 = str2;
                Object obj2 = this.mLock;
                synchronized (obj2) {
                    try {
                        zzavy zzdd = this.zzefk.zzdd(str3);
                        if (zzdd != null && zzdd.zzxo() != null && zzdd.zzxn() != null) {
                            obj = obj2;
                            try {
                                zzavk zzavkVar = new zzavk(this.mContext, str3, str, zzakqVar, this.zzdsk, zzdd, this, this.zzeet);
                                zzavkVar.zza(this.zzefk.zzxb());
                                this.zzefh.add(zzavkVar);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        this.zzefi.add(new zzavp().zzdg(zzakqVar.zzdkx).zzdf(str3).zzar(0L).zzcu(7).zzxm());
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj2;
                        throw th;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList<zzavk> arrayList = this.zzefh;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            zzavk zzavkVar2 = arrayList.get(i2);
            i2++;
            zzavk zzavkVar3 = zzavkVar2;
            if (hashSet.add(zzavkVar3.zzdml)) {
                zzavkVar3.zzxi();
            }
        }
        ArrayList<zzavk> arrayList2 = this.zzefh;
        int size2 = arrayList2.size();
        while (i < size2) {
            zzavk zzavkVar4 = arrayList2.get(i);
            i++;
            zzavk zzavkVar5 = zzavkVar4;
            try {
                try {
                    zzavkVar5.zzxi().get();
                    synchronized (this.mLock) {
                        if (!TextUtils.isEmpty(zzavkVar5.zzdml)) {
                            this.zzefi.add(zzavkVar5.zzxj());
                        }
                    }
                    synchronized (this.mLock) {
                        if (this.zzefj.contains(zzavkVar5.zzdml)) {
                            final zzaxf zza = zza(-2, zzavkVar5.zzdml, zzavkVar5.zzxk());
                            zzbat.zztu.post(new Runnable(this, zza) { // from class: com.google.android.gms.internal.ads.cd

                                /* renamed from: a, reason: collision with root package name */
                                private final zzavu f12096a;

                                /* renamed from: b, reason: collision with root package name */
                                private final zzaxf f12097b;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.f12096a = this;
                                    this.f12097b = zza;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f12096a.zzm(this.f12097b);
                                }
                            });
                            return;
                        }
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    synchronized (this.mLock) {
                        if (!TextUtils.isEmpty(zzavkVar5.zzdml)) {
                            this.zzefi.add(zzavkVar5.zzxj());
                        }
                    }
                } catch (Exception e3) {
                    zzbbd.zzc("Unable to resolve rewarded adapter.", e3);
                    synchronized (this.mLock) {
                        if (!TextUtils.isEmpty(zzavkVar5.zzdml)) {
                            this.zzefi.add(zzavkVar5.zzxj());
                        }
                    }
                }
            } catch (Throwable th3) {
                synchronized (this.mLock) {
                    if (!TextUtils.isEmpty(zzavkVar5.zzdml)) {
                        this.zzefi.add(zzavkVar5.zzxj());
                    }
                    throw th3;
                }
            }
        }
        final zzaxf zza2 = zza(3, null, null);
        zzbat.zztu.post(new Runnable(this, zza2) { // from class: com.google.android.gms.internal.ads.dd

            /* renamed from: a, reason: collision with root package name */
            private final zzavu f12120a;

            /* renamed from: b, reason: collision with root package name */
            private final zzaxf f12121b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12120a = this;
                this.f12121b = zza2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12120a.zzl(this.f12121b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzaxf zzaxfVar) {
        this.zzefk.zzxc().zzb(zzaxfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzaxf zzaxfVar) {
        this.zzefk.zzxc().zzb(zzaxfVar);
    }

    @VisibleForTesting
    private zzavu(Context context, zzaxg zzaxgVar, zzauk zzaukVar, long j) {
        this.zzefh = new ArrayList<>();
        this.zzefi = new ArrayList();
        this.zzefj = new HashSet<>();
        this.mLock = new Object();
        this.mContext = context;
        this.zzdsk = zzaxgVar;
        this.zzefk = zzaukVar;
        this.zzeet = j;
    }
}

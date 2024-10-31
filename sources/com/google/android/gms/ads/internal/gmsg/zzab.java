package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzaoa;
import com.google.android.gms.internal.ads.zzaoc;
import com.google.android.gms.internal.ads.zzaod;
import com.google.android.gms.internal.ads.zzaol;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzwu;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public final class zzab implements zzu<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f10059a = CollectionUtils.a(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});

    /* renamed from: b, reason: collision with root package name */
    private final zzw f10060b;

    /* renamed from: c, reason: collision with root package name */
    private final zzaoa f10061c;

    /* renamed from: d, reason: collision with root package name */
    private final zzaol f10062d;

    public zzab(zzw zzwVar, zzaoa zzaoaVar, zzaol zzaolVar) {
        this.f10060b = zzwVar;
        this.f10061c = zzaoaVar;
        this.f10062d = zzaolVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzw zzwVar;
        zzbgg zzbggVar2 = zzbggVar;
        int intValue = f10059a.get((String) map.get(com.umeng.commonsdk.proguard.e.al)).intValue();
        if (intValue != 5 && intValue != 7 && (zzwVar = this.f10060b) != null && !zzwVar.b()) {
            this.f10060b.a(null);
            return;
        }
        if (intValue == 1) {
            this.f10061c.zzk(map);
            return;
        }
        if (intValue == 3) {
            new zzaod(zzbggVar2, map).execute();
            return;
        }
        if (intValue == 4) {
            new zzanx(zzbggVar2, map).execute();
            return;
        }
        if (intValue == 5) {
            new zzaoc(zzbggVar2, map).execute();
            return;
        }
        if (intValue == 6) {
            this.f10061c.zzx(true);
        } else if (intValue != 7) {
            zzbbd.zzen("Unknown MRAID command called.");
        } else if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcpv)).booleanValue()) {
            this.f10062d.zzjv();
        }
    }
}

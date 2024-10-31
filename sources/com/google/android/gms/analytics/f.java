package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.internal.zzpb;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f697a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ long d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;
    final /* synthetic */ String g;
    final /* synthetic */ Tracker h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.h = tracker;
        this.f697a = map;
        this.b = z;
        this.c = str;
        this.d = j;
        this.e = z2;
        this.f = z3;
        this.g = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Tracker.a aVar;
        com.google.android.gms.analytics.internal.zza y;
        zzk z;
        zzu A;
        zzu A2;
        com.google.android.gms.analytics.internal.zzb t;
        com.google.android.gms.analytics.internal.zzb t2;
        zzaf p;
        zzad zzadVar;
        zzaf p2;
        aVar = this.h.e;
        if (aVar.b()) {
            this.f697a.put("sc", "start");
        }
        zzam.b(this.f697a, "cid", this.h.s().h());
        String str = (String) this.f697a.get("sf");
        if (str != null) {
            double a2 = zzam.a(str, 100.0d);
            if (zzam.a(a2, (String) this.f697a.get("cid"))) {
                this.h.b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(a2));
                return;
            }
        }
        y = this.h.y();
        if (this.b) {
            zzam.a((Map<String, String>) this.f697a, "ate", y.b());
            zzam.a((Map<String, String>) this.f697a, "adid", y.c());
        } else {
            this.f697a.remove("ate");
            this.f697a.remove("adid");
        }
        z = this.h.z();
        zzpb c = z.c();
        zzam.a((Map<String, String>) this.f697a, "an", c.zzkp());
        zzam.a((Map<String, String>) this.f697a, "av", c.zzkr());
        zzam.a((Map<String, String>) this.f697a, "aid", c.zzuM());
        zzam.a((Map<String, String>) this.f697a, "aiid", c.zzyt());
        this.f697a.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.f697a.put("_v", zze.b);
        Map map = this.f697a;
        A = this.h.A();
        zzam.a((Map<String, String>) map, "ul", A.b().getLanguage());
        Map map2 = this.f697a;
        A2 = this.h.A();
        zzam.a((Map<String, String>) map2, "sr", A2.c());
        if (!(this.c.equals("transaction") || this.c.equals("item"))) {
            zzadVar = this.h.d;
            if (!zzadVar.a()) {
                p2 = this.h.p();
                p2.a(this.f697a, "Too many hits sent too quickly, rate limiting invoked");
                return;
            }
        }
        long a3 = zzam.a((String) this.f697a.get("ht"));
        if (a3 == 0) {
            a3 = this.d;
        }
        if (this.e) {
            zzab zzabVar = new zzab(this.h, this.f697a, a3, this.f);
            p = this.h.p();
            p.c("Dry run enabled. Would have sent hit", zzabVar);
            return;
        }
        String str2 = (String) this.f697a.get("cid");
        HashMap hashMap = new HashMap();
        zzam.a(hashMap, "uid", (Map<String, String>) this.f697a);
        zzam.a(hashMap, "an", (Map<String, String>) this.f697a);
        zzam.a(hashMap, "aid", (Map<String, String>) this.f697a);
        zzam.a(hashMap, "av", (Map<String, String>) this.f697a);
        zzam.a(hashMap, "aiid", (Map<String, String>) this.f697a);
        zzh zzhVar = new zzh(0L, str2, this.g, TextUtils.isEmpty((CharSequence) this.f697a.get("adid")) ? false : true, 0L, hashMap);
        t = this.h.t();
        this.f697a.put("_s", String.valueOf(t.a(zzhVar)));
        zzab zzabVar2 = new zzab(this.h, this.f697a, a3, this.f);
        t2 = this.h.t();
        t2.a(zzabVar2);
    }
}

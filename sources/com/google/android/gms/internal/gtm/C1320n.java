package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1320n extends zzan {

    /* renamed from: a, reason: collision with root package name */
    private boolean f13270a;

    /* renamed from: b, reason: collision with root package name */
    private final C1316l f13271b;

    /* renamed from: c, reason: collision with root package name */
    private final C f13272c;

    /* renamed from: d, reason: collision with root package name */
    private final B f13273d;

    /* renamed from: e, reason: collision with root package name */
    private final zzat f13274e;

    /* renamed from: f, reason: collision with root package name */
    private long f13275f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC1341y f13276g;

    /* renamed from: h, reason: collision with root package name */
    private final AbstractC1341y f13277h;
    private final I i;
    private long j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1320n(zzap zzapVar, zzar zzarVar) {
        super(zzapVar);
        Preconditions.a(zzarVar);
        this.f13275f = Long.MIN_VALUE;
        this.f13273d = new B(zzapVar);
        this.f13271b = new C1316l(zzapVar);
        this.f13272c = new C(zzapVar);
        this.f13274e = new zzat(zzapVar);
        this.i = new I(zzcn());
        this.f13276g = new C1322o(this, zzapVar);
        this.f13277h = new C1324p(this, zzapVar);
    }

    private final long A() {
        long j = this.f13275f;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        long longValue = zzby.zzzh.get().longValue();
        zzda zzcu = zzcu();
        zzcu.zzdb();
        if (!zzcu.zzacv) {
            return longValue;
        }
        zzcu().zzdb();
        return r0.zzaax * 1000;
    }

    private final void L() {
        zzdb();
        com.google.android.gms.analytics.zzk.d();
        this.k = true;
        this.f13274e.disconnect();
        r();
    }

    private final boolean f(String str) {
        return Wrappers.a(getContext()).a(str) == 0;
    }

    private final long s() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        try {
            return this.f13271b.s();
        } catch (SQLiteException e2) {
            zze("Failed to get min/max hit times from local store", e2);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        a(new r(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        try {
            this.f13271b.r();
            r();
        } catch (SQLiteException e2) {
            zzd("Failed to delete stale hits", e2);
        }
        this.f13277h.a(86400000L);
    }

    private final void w() {
        if (this.k || !zzbq.zzen() || this.f13274e.isConnected()) {
            return;
        }
        if (this.i.a(zzby.zzaan.get().longValue())) {
            this.i.b();
            zzq("Connecting to service");
            if (this.f13274e.connect()) {
                zzq("Connected to service");
                this.i.a();
                onServiceConnected();
            }
        }
    }

    private final boolean x() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        zzq("Dispatching a batch of local hits");
        boolean z = !this.f13274e.isConnected();
        boolean z2 = !this.f13272c.a();
        if (z && z2) {
            zzq("No network or service available. Will retry later");
            return false;
        }
        long max = Math.max(zzbq.zzer(), zzbq.zzes());
        ArrayList arrayList = new ArrayList();
        long j = 0;
        while (true) {
            try {
                this.f13271b.C();
                arrayList.clear();
                try {
                    List<zzcd> g2 = this.f13271b.g(max);
                    if (g2.isEmpty()) {
                        zzq("Store is empty, nothing to dispatch");
                        z();
                        try {
                            this.f13271b.E();
                            this.f13271b.F();
                            return false;
                        } catch (SQLiteException e2) {
                            zze("Failed to commit local dispatch transaction", e2);
                            z();
                            return false;
                        }
                    }
                    zza("Hits loaded from store. count", Integer.valueOf(g2.size()));
                    Iterator<zzcd> it = g2.iterator();
                    while (it.hasNext()) {
                        if (it.next().zzfg() == j) {
                            zzd("Database contains successfully uploaded hit", Long.valueOf(j), Integer.valueOf(g2.size()));
                            z();
                            try {
                                this.f13271b.E();
                                this.f13271b.F();
                                return false;
                            } catch (SQLiteException e3) {
                                zze("Failed to commit local dispatch transaction", e3);
                                z();
                                return false;
                            }
                        }
                    }
                    if (this.f13274e.isConnected()) {
                        zzq("Service connected, sending hits to the service");
                        while (!g2.isEmpty()) {
                            zzcd zzcdVar = g2.get(0);
                            if (!this.f13274e.zzb(zzcdVar)) {
                                break;
                            }
                            j = Math.max(j, zzcdVar.zzfg());
                            g2.remove(zzcdVar);
                            zzb("Hit sent do device AnalyticsService for delivery", zzcdVar);
                            try {
                                this.f13271b.h(zzcdVar.zzfg());
                                arrayList.add(Long.valueOf(zzcdVar.zzfg()));
                            } catch (SQLiteException e4) {
                                zze("Failed to remove hit that was send for delivery", e4);
                                z();
                                try {
                                    this.f13271b.E();
                                    this.f13271b.F();
                                    return false;
                                } catch (SQLiteException e5) {
                                    zze("Failed to commit local dispatch transaction", e5);
                                    z();
                                    return false;
                                }
                            }
                        }
                    }
                    if (this.f13272c.a()) {
                        List<Long> a2 = this.f13272c.a(g2);
                        Iterator<Long> it2 = a2.iterator();
                        while (it2.hasNext()) {
                            j = Math.max(j, it2.next().longValue());
                        }
                        try {
                            this.f13271b.a(a2);
                            arrayList.addAll(a2);
                        } catch (SQLiteException e6) {
                            zze("Failed to remove successfully uploaded hits", e6);
                            z();
                            try {
                                this.f13271b.E();
                                this.f13271b.F();
                                return false;
                            } catch (SQLiteException e7) {
                                zze("Failed to commit local dispatch transaction", e7);
                                z();
                                return false;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        try {
                            this.f13271b.E();
                            this.f13271b.F();
                            return false;
                        } catch (SQLiteException e8) {
                            zze("Failed to commit local dispatch transaction", e8);
                            z();
                            return false;
                        }
                    }
                    try {
                        this.f13271b.E();
                        this.f13271b.F();
                    } catch (SQLiteException e9) {
                        zze("Failed to commit local dispatch transaction", e9);
                        z();
                        return false;
                    }
                } catch (SQLiteException e10) {
                    zzd("Failed to read hits from persisted store", e10);
                    z();
                    try {
                        this.f13271b.E();
                        this.f13271b.F();
                        return false;
                    } catch (SQLiteException e11) {
                        zze("Failed to commit local dispatch transaction", e11);
                        z();
                        return false;
                    }
                }
            } catch (Throwable th) {
                this.f13271b.E();
                this.f13271b.F();
                throw th;
            }
            try {
                this.f13271b.E();
                this.f13271b.F();
                throw th;
            } catch (SQLiteException e12) {
                zze("Failed to commit local dispatch transaction", e12);
                z();
                return false;
            }
        }
    }

    private final void y() {
        zzbv zzct = zzct();
        if (zzct.zzfc() && !zzct.zzez()) {
            long s = s();
            if (s == 0 || Math.abs(zzcn().a() - s) > zzby.zzzm.get().longValue()) {
                return;
            }
            zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzbq.zzeq()));
            zzct.zzfd();
        }
    }

    private final void z() {
        if (this.f13276g.d()) {
            zzq("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f13276g.a();
        zzbv zzct = zzct();
        if (zzct.zzez()) {
            zzct.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        zzdb();
        com.google.android.gms.analytics.zzk.d();
        Context context = zzcm().getContext();
        if (!zzcp.zza(context)) {
            zzt("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzcq.zze(context)) {
            zzu("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.a(context)) {
            zzt("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzcv().zzfv();
        if (!f("android.permission.ACCESS_NETWORK_STATE")) {
            zzu("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            L();
        }
        if (!f("android.permission.INTERNET")) {
            zzu("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            L();
        }
        if (zzcq.zze(getContext())) {
            zzq("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzt("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.k && !this.f13271b.b()) {
            w();
        }
        r();
    }

    public final void b() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        zzr("Sync dispatching local hits");
        long j = this.j;
        w();
        try {
            x();
            zzcv().zzfy();
            r();
            if (this.j != j) {
                this.f13273d.d();
            }
        } catch (Exception e2) {
            zze("Sync local dispatch failed", e2);
            r();
        }
    }

    public final void e(String str) {
        Preconditions.b(str);
        com.google.android.gms.analytics.zzk.d();
        zzr zza = zzcz.zza(zzco(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzfz = zzcv().zzfz();
        if (str.equals(zzfz)) {
            zzt("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(zzfz)) {
            zzd("Ignoring multiple install campaigns. original, new", zzfz, str);
            return;
        }
        zzcv().zzad(str);
        if (zzcv().zzfw().a(zzbq.zzex())) {
            zzd("Campaign received too late, ignoring", zza);
            return;
        }
        zzb("Received installation campaign", zza);
        Iterator<zzas> it = this.f13271b.i(0L).iterator();
        while (it.hasNext()) {
            a(it.next(), zza);
        }
    }

    public final void g(long j) {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        if (j < 0) {
            j = 0;
        }
        this.f13275f = j;
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onServiceConnected() {
        com.google.android.gms.analytics.zzk.d();
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        if (!zzbq.zzen()) {
            zzt("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.f13274e.isConnected()) {
            zzq("Service not connected");
            return;
        }
        if (this.f13271b.b()) {
            return;
        }
        zzq("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List<zzcd> g2 = this.f13271b.g(zzbq.zzer());
                if (g2.isEmpty()) {
                    r();
                    return;
                }
                while (!g2.isEmpty()) {
                    zzcd zzcdVar = g2.get(0);
                    if (!this.f13274e.zzb(zzcdVar)) {
                        r();
                        return;
                    }
                    g2.remove(zzcdVar);
                    try {
                        this.f13271b.h(zzcdVar.zzfg());
                    } catch (SQLiteException e2) {
                        zze("Failed to remove hit that was send for delivery", e2);
                        z();
                        return;
                    }
                }
            } catch (SQLiteException e3) {
                zze("Failed to read hits from store", e3);
                z();
                return;
            }
        }
    }

    public final void r() {
        long min;
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        boolean z = true;
        if (!(!this.k && A() > 0)) {
            this.f13273d.b();
            z();
            return;
        }
        if (this.f13271b.b()) {
            this.f13273d.b();
            z();
            return;
        }
        if (!zzby.zzaai.get().booleanValue()) {
            this.f13273d.c();
            z = this.f13273d.a();
        }
        if (z) {
            y();
            long A = A();
            long zzfx = zzcv().zzfx();
            if (zzfx != 0) {
                min = A - Math.abs(zzcn().a() - zzfx);
                if (min <= 0) {
                    min = Math.min(zzbq.zzep(), A);
                }
            } else {
                min = Math.min(zzbq.zzep(), A);
            }
            zza("Dispatch scheduled (ms)", Long.valueOf(min));
            if (this.f13276g.d()) {
                this.f13276g.b(Math.max(1L, min + this.f13276g.c()));
                return;
            } else {
                this.f13276g.a(min);
                return;
            }
        }
        z();
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void start() {
        zzdb();
        Preconditions.b(!this.f13270a, "Analytics backend already started");
        this.f13270a = true;
        zzcq().a(new RunnableC1326q(this));
    }

    public final void zza(zzcd zzcdVar) {
        Pair<String, Long> zzgc;
        Preconditions.a(zzcdVar);
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        if (this.k) {
            zzr("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzcdVar);
        }
        if (TextUtils.isEmpty(zzcdVar.zzfl()) && (zzgc = zzcv().zzga().zzgc()) != null) {
            Long l = (Long) zzgc.second;
            String str = (String) zzgc.first;
            String valueOf = String.valueOf(l);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
            sb.append(valueOf);
            sb.append(":");
            sb.append(str);
            String sb2 = sb.toString();
            HashMap hashMap = new HashMap(zzcdVar.zzdm());
            hashMap.put("_m", sb2);
            zzcdVar = new zzcd(this, hashMap, zzcdVar.zzfh(), zzcdVar.zzfj(), zzcdVar.zzfg(), zzcdVar.zzff(), zzcdVar.zzfi());
        }
        w();
        if (this.f13274e.zzb(zzcdVar)) {
            zzr("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.f13271b.a(zzcdVar);
            r();
        } catch (SQLiteException e2) {
            zze("Delivery failed to save hit to a database", e2);
            zzco().zza(zzcdVar, "deliver: failed to insert hit to database");
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
        this.f13271b.zzag();
        this.f13272c.zzag();
        this.f13274e.zzag();
    }

    public final void zzch() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        zzq("Delete all hits from local store");
        try {
            C1316l c1316l = this.f13271b;
            com.google.android.gms.analytics.zzk.d();
            c1316l.zzdb();
            c1316l.a().delete("hits2", null, null);
            C1316l c1316l2 = this.f13271b;
            com.google.android.gms.analytics.zzk.d();
            c1316l2.zzdb();
            c1316l2.a().delete("properties", null, null);
            r();
        } catch (SQLiteException e2) {
            zzd("Failed to delete hits from store", e2);
        }
        w();
        if (this.f13274e.zzdn()) {
            zzq("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzcl() {
        com.google.android.gms.analytics.zzk.d();
        this.j = zzcn().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzas zzasVar) {
        com.google.android.gms.analytics.zzk.d();
        zzb("Sending first hit to property", zzasVar.zzdj());
        if (zzcv().zzfw().a(zzbq.zzex())) {
            return;
        }
        String zzfz = zzcv().zzfz();
        if (TextUtils.isEmpty(zzfz)) {
            return;
        }
        zzr zza = zzcz.zza(zzco(), zzfz);
        zzb("Found relevant installation campaign", zza);
        a(zzasVar, zza);
    }

    public final long a(zzas zzasVar, boolean z) {
        Preconditions.a(zzasVar);
        zzdb();
        com.google.android.gms.analytics.zzk.d();
        try {
            try {
                this.f13271b.C();
                C1316l c1316l = this.f13271b;
                long zzdi = zzasVar.zzdi();
                String zzbt = zzasVar.zzbt();
                Preconditions.b(zzbt);
                c1316l.zzdb();
                com.google.android.gms.analytics.zzk.d();
                int i = 1;
                int delete = c1316l.a().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(zzdi), zzbt});
                if (delete > 0) {
                    c1316l.zza("Deleted property records", Integer.valueOf(delete));
                }
                long a2 = this.f13271b.a(zzasVar.zzdi(), zzasVar.zzbt(), zzasVar.zzdj());
                zzasVar.zzb(1 + a2);
                C1316l c1316l2 = this.f13271b;
                Preconditions.a(zzasVar);
                c1316l2.zzdb();
                com.google.android.gms.analytics.zzk.d();
                SQLiteDatabase a3 = c1316l2.a();
                Map<String, String> zzdm = zzasVar.zzdm();
                Preconditions.a(zzdm);
                Uri.Builder builder = new Uri.Builder();
                for (Map.Entry<String, String> entry : zzdm.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
                String encodedQuery = builder.build().getEncodedQuery();
                if (encodedQuery == null) {
                    encodedQuery = "";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_uid", Long.valueOf(zzasVar.zzdi()));
                contentValues.put("cid", zzasVar.zzbt());
                contentValues.put("tid", zzasVar.zzdj());
                if (!zzasVar.zzdk()) {
                    i = 0;
                }
                contentValues.put("adid", Integer.valueOf(i));
                contentValues.put("hits_count", Long.valueOf(zzasVar.zzdl()));
                contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, encodedQuery);
                try {
                    if (a3.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                        c1316l2.zzu("Failed to insert/update a property (got -1)");
                    }
                } catch (SQLiteException e2) {
                    c1316l2.zze("Error storing a property", e2);
                }
                this.f13271b.E();
                try {
                    this.f13271b.F();
                } catch (SQLiteException e3) {
                    zze("Failed to end transaction", e3);
                }
                return a2;
            } finally {
            }
        } catch (SQLiteException e4) {
            zze("Failed to update Analytics property", e4);
            try {
                this.f13271b.F();
            } catch (SQLiteException e5) {
                zze("Failed to end transaction", e5);
            }
            return -1L;
        }
    }

    public final void a(zzbw zzbwVar) {
        long j = this.j;
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        long zzfx = zzcv().zzfx();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(zzfx != 0 ? Math.abs(zzcn().a() - zzfx) : -1L));
        w();
        try {
            x();
            zzcv().zzfy();
            r();
            if (zzbwVar != null) {
                zzbwVar.zza(null);
            }
            if (this.j != j) {
                this.f13273d.d();
            }
        } catch (Exception e2) {
            zze("Local dispatch failed", e2);
            zzcv().zzfy();
            r();
            if (zzbwVar != null) {
                zzbwVar.zza(e2);
            }
        }
    }

    private final void a(zzas zzasVar, zzr zzrVar) {
        Preconditions.a(zzasVar);
        Preconditions.a(zzrVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(zzcm());
        zzaVar.a(zzasVar.zzdj());
        zzaVar.a(zzasVar.zzdk());
        com.google.android.gms.analytics.zzg c2 = zzaVar.c();
        zzz zzzVar = (zzz) c2.b(zzz.class);
        zzzVar.zzl(ShareConstants.WEB_DIALOG_PARAM_DATA);
        zzzVar.zzb(true);
        c2.a(zzrVar);
        zzu zzuVar = (zzu) c2.b(zzu.class);
        zzq zzqVar = (zzq) c2.b(zzq.class);
        for (Map.Entry<String, String> entry : zzasVar.zzdm().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zzqVar.setAppName(value);
            } else if ("av".equals(key)) {
                zzqVar.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zzqVar.setAppId(value);
            } else if ("aiid".equals(key)) {
                zzqVar.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzzVar.setUserId(value);
            } else {
                zzuVar.set(key, value);
            }
        }
        zzb("Sending installation campaign to", zzasVar.zzdj(), zzrVar);
        c2.a(zzcv().zzfv());
        c2.e();
    }
}

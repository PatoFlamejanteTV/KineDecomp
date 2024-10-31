package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzavy;
import com.google.android.gms.internal.ads.zzazc;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzyd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzay extends zzyd {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f10212a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static zzay f10213b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f10214c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f10215d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f10216e = false;

    /* renamed from: f, reason: collision with root package name */
    private zzbbi f10217f;

    @VisibleForTesting
    private zzay(Context context, zzbbi zzbbiVar) {
        this.f10214c = context;
        this.f10217f = zzbbiVar;
    }

    public static zzay a(Context context, zzbbi zzbbiVar) {
        zzay zzayVar;
        synchronized (f10212a) {
            if (f10213b == null) {
                f10213b = new zzay(context.getApplicationContext(), zzbbiVar);
            }
            zzayVar = f10213b;
        }
        return zzayVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void setAppMuted(boolean z) {
        zzbv.j().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void setAppVolume(float f2) {
        zzbv.j().setAppVolume(f2);
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void zza() {
        synchronized (f10212a) {
            if (this.f10216e) {
                zzbbd.zzeo("Mobile ads is initialized already.");
                return;
            }
            this.f10216e = true;
            zzaan.initialize(this.f10214c);
            zzbv.i().zzd(this.f10214c, this.f10217f);
            zzbv.k().initialize(this.f10214c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void zza(zzalg zzalgVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void zzat(String str) {
        zzaan.initialize(this.f10214c);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuz)).booleanValue()) {
            zzbv.m().a(this.f10214c, this.f10217f, str, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void zzau(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzbbd.e("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        if (context == null) {
            zzbbd.e("Context is null. Failed to open debug menu.");
            return;
        }
        zzazc zzazcVar = new zzazc(context);
        zzazcVar.setAdUnitId(str);
        zzazcVar.zzee(this.f10217f.zzdp);
        zzazcVar.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final float zzkj() {
        return zzbv.j().zzkj();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final boolean zzkk() {
        return zzbv.j().zzkk();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final String zzkl() {
        return this.f10217f.zzdp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Runnable runnable) {
        Context context = this.f10214c;
        Preconditions.a("Adapters must be initialized on the main thread.");
        Map<String, zzakr> zzyg = zzbv.i().zzyq().zzzi().zzyg();
        if (zzyg == null || zzyg.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzbbd.zzc("Could not initialize rewarded ads.", th);
                return;
            }
        }
        zzauo zzxg = zzauo.zzxg();
        if (zzxg != null) {
            Collection<zzakr> values = zzyg.values();
            HashMap hashMap = new HashMap();
            IObjectWrapper a2 = ObjectWrapper.a(context);
            Iterator<zzakr> it = values.iterator();
            while (it.hasNext()) {
                for (zzakq zzakqVar : it.next().zzdlp) {
                    String str = zzakqVar.zzdle;
                    for (String str2 : zzakqVar.zzdkw) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzavy zzdd = zzxg.zzdd(str3);
                    if (zzdd != null) {
                        zzalj zzxn = zzdd.zzxn();
                        if (!zzxn.isInitialized() && zzxn.zzuy()) {
                            zzxn.zza(a2, zzdd.zzxo(), (List<String>) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            zzbbd.zzdn(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (Throwable th2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzbbd.zzc(sb.toString(), th2);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzaan.initialize(this.f10214c);
        boolean booleanValue = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcuz)).booleanValue() | ((Boolean) zzwu.zzpz().zzd(zzaan.zzcri)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcri)).booleanValue()) {
            booleanValue = true;
            final Runnable runnable2 = (Runnable) ObjectWrapper.a(iObjectWrapper);
            runnable = new Runnable(this, runnable2) { // from class: com.google.android.gms.ads.internal.n

                /* renamed from: a, reason: collision with root package name */
                private final zzay f10095a;

                /* renamed from: b, reason: collision with root package name */
                private final Runnable f10096b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f10095a = this;
                    this.f10096b = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final zzay zzayVar = this.f10095a;
                    final Runnable runnable3 = this.f10096b;
                    zzbcg.zzepo.execute(new Runnable(zzayVar, runnable3) { // from class: com.google.android.gms.ads.internal.p

                        /* renamed from: a, reason: collision with root package name */
                        private final zzay f10144a;

                        /* renamed from: b, reason: collision with root package name */
                        private final Runnable f10145b;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f10144a = zzayVar;
                            this.f10145b = runnable3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f10144a.a(this.f10145b);
                        }
                    });
                }
            };
        }
        if (booleanValue) {
            zzbv.m().a(this.f10214c, this.f10217f, str, runnable);
        }
    }
}

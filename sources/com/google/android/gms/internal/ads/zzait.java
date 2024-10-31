package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzait {
    private final Context mContext;
    private final Object mLock;
    private final zzbbi zzbob;
    private final String zzdiv;
    private zzazn<zzaii> zzdiw;
    private zzazn<zzaii> zzdix;
    private zzajm zzdiy;
    private int zzdiz;

    public zzait(Context context, zzbbi zzbbiVar, String str) {
        this.mLock = new Object();
        this.zzdiz = 1;
        this.zzdiv = str;
        this.mContext = context.getApplicationContext();
        this.zzbob = zzbbiVar;
        this.zzdiw = new zzajh();
        this.zzdix = new zzajh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzajm zza(final zzcu zzcuVar) {
        final zzajm zzajmVar = new zzajm(this.zzdix);
        zzbcg.zzepo.execute(new Runnable(this, zzcuVar, zzajmVar) { // from class: com.google.android.gms.internal.ads.Ga

            /* renamed from: a, reason: collision with root package name */
            private final zzait f11538a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcu f11539b;

            /* renamed from: c, reason: collision with root package name */
            private final zzajm f11540c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11538a = this;
                this.f11539b = zzcuVar;
                this.f11540c = zzajmVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11538a.zza(this.f11539b, this.f11540c);
            }
        });
        zzajmVar.zza(new Qa(this, zzajmVar), new Ra(this, zzajmVar));
        return zzajmVar;
    }

    public final zzaji zzb(zzcu zzcuVar) {
        synchronized (this.mLock) {
            synchronized (this.mLock) {
                if (this.zzdiy != null && this.zzdiz == 0) {
                    if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcob)).booleanValue()) {
                        this.zzdiy.zza(new zzbcq(this) { // from class: com.google.android.gms.internal.ads.Ha

                            /* renamed from: a, reason: collision with root package name */
                            private final zzait f11558a;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f11558a = this;
                            }

                            @Override // com.google.android.gms.internal.ads.zzbcq
                            public final void zzh(Object obj) {
                                this.f11558a.zza((zzaii) obj);
                            }
                        }, Ia.f11589a);
                    }
                }
            }
            if (this.zzdiy != null && this.zzdiy.getStatus() != -1) {
                if (this.zzdiz == 0) {
                    return this.zzdiy.zzud();
                }
                if (this.zzdiz == 1) {
                    this.zzdiz = 2;
                    zza((zzcu) null);
                    return this.zzdiy.zzud();
                }
                if (this.zzdiz == 2) {
                    return this.zzdiy.zzud();
                }
                return this.zzdiy.zzud();
            }
            this.zzdiz = 2;
            this.zzdiy = zza((zzcu) null);
            return this.zzdiy.zzud();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzaii zzaiiVar) {
        if (zzaiiVar.isDestroyed()) {
            this.zzdiz = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcu zzcuVar, final zzajm zzajmVar) {
        final zzaii zzaikVar;
        try {
            Context context = this.mContext;
            zzbbi zzbbiVar = this.zzbob;
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrd)).booleanValue()) {
                zzaikVar = new zzahv(context, zzbbiVar);
            } else {
                zzaikVar = new zzaik(context, zzbbiVar, zzcuVar, null);
            }
            zzaikVar.zza(new zzaij(this, zzajmVar, zzaikVar) { // from class: com.google.android.gms.internal.ads.Ja

                /* renamed from: a, reason: collision with root package name */
                private final zzait f11618a;

                /* renamed from: b, reason: collision with root package name */
                private final zzajm f11619b;

                /* renamed from: c, reason: collision with root package name */
                private final zzaii f11620c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11618a = this;
                    this.f11619b = zzajmVar;
                    this.f11620c = zzaikVar;
                }

                @Override // com.google.android.gms.internal.ads.zzaij
                public final void zzub() {
                    final zzait zzaitVar = this.f11618a;
                    final zzajm zzajmVar2 = this.f11619b;
                    final zzaii zzaiiVar = this.f11620c;
                    zzayh.zzelc.postDelayed(new Runnable(zzaitVar, zzajmVar2, zzaiiVar) { // from class: com.google.android.gms.internal.ads.Ka

                        /* renamed from: a, reason: collision with root package name */
                        private final zzait f11634a;

                        /* renamed from: b, reason: collision with root package name */
                        private final zzajm f11635b;

                        /* renamed from: c, reason: collision with root package name */
                        private final zzaii f11636c;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f11634a = zzaitVar;
                            this.f11635b = zzajmVar2;
                            this.f11636c = zzaiiVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11634a.zza(this.f11635b, this.f11636c);
                        }
                    }, Sa.f11820b);
                }
            });
            zzaikVar.zza("/jsLoaded", new Ma(this, zzajmVar, zzaikVar));
            zzbaj zzbajVar = new zzbaj();
            Na na = new Na(this, zzcuVar, zzaikVar, zzbajVar);
            zzbajVar.set(na);
            zzaikVar.zza("/requestReload", na);
            if (this.zzdiv.endsWith(".js")) {
                zzaikVar.zzcd(this.zzdiv);
            } else if (this.zzdiv.startsWith("<html>")) {
                zzaikVar.zzce(this.zzdiv);
            } else {
                zzaikVar.zzcf(this.zzdiv);
            }
            zzayh.zzelc.postDelayed(new Oa(this, zzajmVar, zzaikVar), Sa.f11819a);
        } catch (Throwable th) {
            zzbbd.zzb("Error creating webview.", th);
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzajmVar.reject();
        }
    }

    public zzait(Context context, zzbbi zzbbiVar, String str, zzazn<zzaii> zzaznVar, zzazn<zzaii> zzaznVar2) {
        this(context, zzbbiVar, str);
        this.zzdiw = zzaznVar;
        this.zzdix = zzaznVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzajm zzajmVar, zzaii zzaiiVar) {
        synchronized (this.mLock) {
            if (zzajmVar.getStatus() != -1 && zzajmVar.getStatus() != 1) {
                zzajmVar.reject();
                Executor executor = zzbcg.zzepo;
                zzaiiVar.getClass();
                executor.execute(La.a(zzaiiVar));
                zzaxz.v("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzbgm {
    public static zzbcb<zzbgg> zza(final Context context, final zzbbi zzbbiVar, final String str, final zzcu zzcuVar, final com.google.android.gms.ads.internal.zzv zzvVar) {
        return zzbbq.zza(zzbbq.zzm(null), new zzbbl(context, zzcuVar, zzbbiVar, zzvVar, str) { // from class: com.google.android.gms.internal.ads.Hf

            /* renamed from: a, reason: collision with root package name */
            private final Context f11566a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcu f11567b;

            /* renamed from: c, reason: collision with root package name */
            private final zzbbi f11568c;

            /* renamed from: d, reason: collision with root package name */
            private final com.google.android.gms.ads.internal.zzv f11569d;

            /* renamed from: e, reason: collision with root package name */
            private final String f11570e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11566a = context;
                this.f11567b = zzcuVar;
                this.f11568c = zzbbiVar;
                this.f11569d = zzvVar;
                this.f11570e = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbbl
            public final zzbcb zzf(Object obj) {
                Context context2 = this.f11566a;
                zzcu zzcuVar2 = this.f11567b;
                zzbbi zzbbiVar2 = this.f11568c;
                com.google.android.gms.ads.internal.zzv zzvVar2 = this.f11569d;
                String str2 = this.f11570e;
                com.google.android.gms.ads.internal.zzbv.f();
                zzbgg zza = zzbgm.zza(context2, zzbht.zzaey(), "", false, false, zzcuVar2, zzbbiVar2, null, null, zzvVar2, zzum.zzoi());
                final zzbck zzn = zzbck.zzn(zza);
                zza.zzadl().zza(new zzbho(zzn) { // from class: com.google.android.gms.internal.ads.Jf

                    /* renamed from: a, reason: collision with root package name */
                    private final zzbck f11627a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f11627a = zzn;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbho
                    public final void zzp(boolean z) {
                        this.f11627a.zzaax();
                    }
                });
                zza.loadUrl(str2);
                return zzn;
            }
        }, zzbcg.zzepo);
    }

    public static zzbgg zza(final Context context, final zzbht zzbhtVar, final String str, final boolean z, final boolean z2, final zzcu zzcuVar, final zzbbi zzbbiVar, final zzaba zzabaVar, final com.google.android.gms.ads.internal.zzbo zzboVar, final com.google.android.gms.ads.internal.zzv zzvVar, final zzum zzumVar) throws zzbgq {
        zzaan.initialize(context);
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrc)).booleanValue()) {
            return zzbhz.zza(context, zzbhtVar, str, z, z2, zzcuVar, zzbbiVar, zzabaVar, zzboVar, zzvVar, zzumVar);
        }
        try {
            return (zzbgg) zzbak.zzb(new Callable(context, zzbhtVar, str, z, z2, zzcuVar, zzbbiVar, zzabaVar, zzboVar, zzvVar, zzumVar) { // from class: com.google.android.gms.internal.ads.If

                /* renamed from: a, reason: collision with root package name */
                private final Context f11596a;

                /* renamed from: b, reason: collision with root package name */
                private final zzbht f11597b;

                /* renamed from: c, reason: collision with root package name */
                private final String f11598c;

                /* renamed from: d, reason: collision with root package name */
                private final boolean f11599d;

                /* renamed from: e, reason: collision with root package name */
                private final boolean f11600e;

                /* renamed from: f, reason: collision with root package name */
                private final zzcu f11601f;

                /* renamed from: g, reason: collision with root package name */
                private final zzbbi f11602g;

                /* renamed from: h, reason: collision with root package name */
                private final zzaba f11603h;
                private final com.google.android.gms.ads.internal.zzbo i;
                private final com.google.android.gms.ads.internal.zzv j;
                private final zzum k;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11596a = context;
                    this.f11597b = zzbhtVar;
                    this.f11598c = str;
                    this.f11599d = z;
                    this.f11600e = z2;
                    this.f11601f = zzcuVar;
                    this.f11602g = zzbbiVar;
                    this.f11603h = zzabaVar;
                    this.i = zzboVar;
                    this.j = zzvVar;
                    this.k = zzumVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f11596a;
                    zzbht zzbhtVar2 = this.f11597b;
                    String str2 = this.f11598c;
                    boolean z3 = this.f11599d;
                    boolean z4 = this.f11600e;
                    zzcu zzcuVar2 = this.f11601f;
                    zzbbi zzbbiVar2 = this.f11602g;
                    zzaba zzabaVar2 = this.f11603h;
                    com.google.android.gms.ads.internal.zzbo zzboVar2 = this.i;
                    com.google.android.gms.ads.internal.zzv zzvVar2 = this.j;
                    zzum zzumVar2 = this.k;
                    zzbgr zzbgrVar = new zzbgr(Lf.a(context2, zzbhtVar2, str2, z3, z4, zzcuVar2, zzbbiVar2, zzabaVar2, zzboVar2, zzvVar2, zzumVar2));
                    zzbgrVar.setWebViewClient(com.google.android.gms.ads.internal.zzbv.g().zza(zzbgrVar, zzumVar2, z4));
                    zzbgrVar.setWebChromeClient(new zzbfy(zzbgrVar));
                    return zzbgrVar;
                }
            });
        } catch (Throwable th) {
            throw new zzbgq("Webview initialization failed.", th);
        }
    }
}

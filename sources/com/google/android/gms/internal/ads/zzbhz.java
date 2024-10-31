package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzbhz {
    public static zzbgg zza(final Context context, final zzbht zzbhtVar, final String str, final boolean z, final boolean z2, final zzcu zzcuVar, final zzbbi zzbbiVar, final zzaba zzabaVar, final com.google.android.gms.ads.internal.zzbo zzboVar, final com.google.android.gms.ads.internal.zzv zzvVar, zzum zzumVar) throws zzbgq {
        try {
            return (zzbgg) zzbak.zzb(new Callable(context, zzbhtVar, str, z, z2, zzcuVar, zzbbiVar, zzabaVar, zzboVar, zzvVar) { // from class: com.google.android.gms.internal.ads.Vf

                /* renamed from: a, reason: collision with root package name */
                private final Context f11903a;

                /* renamed from: b, reason: collision with root package name */
                private final zzbht f11904b;

                /* renamed from: c, reason: collision with root package name */
                private final String f11905c;

                /* renamed from: d, reason: collision with root package name */
                private final boolean f11906d;

                /* renamed from: e, reason: collision with root package name */
                private final boolean f11907e;

                /* renamed from: f, reason: collision with root package name */
                private final zzcu f11908f;

                /* renamed from: g, reason: collision with root package name */
                private final zzbbi f11909g;

                /* renamed from: h, reason: collision with root package name */
                private final zzaba f11910h;
                private final com.google.android.gms.ads.internal.zzbo i;
                private final com.google.android.gms.ads.internal.zzv j;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11903a = context;
                    this.f11904b = zzbhtVar;
                    this.f11905c = str;
                    this.f11906d = z;
                    this.f11907e = z2;
                    this.f11908f = zzcuVar;
                    this.f11909g = zzbbiVar;
                    this.f11910h = zzabaVar;
                    this.i = zzboVar;
                    this.j = zzvVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f11903a;
                    zzbht zzbhtVar2 = this.f11904b;
                    String str2 = this.f11905c;
                    boolean z3 = this.f11906d;
                    boolean z4 = this.f11907e;
                    zzcu zzcuVar2 = this.f11908f;
                    zzbbi zzbbiVar2 = this.f11909g;
                    zzaba zzabaVar2 = this.f11910h;
                    com.google.android.gms.ads.internal.zzbo zzboVar2 = this.i;
                    com.google.android.gms.ads.internal.zzv zzvVar2 = this.j;
                    zzbhu zzbhuVar = new zzbhu();
                    Wf wf = new Wf(new zzbhs(context2), zzbhuVar, zzbhtVar2, str2, z3, z4, zzcuVar2, zzbbiVar2, zzabaVar2, zzboVar2, zzvVar2);
                    zzbgr zzbgrVar = new zzbgr(wf);
                    wf.setWebChromeClient(new zzbfy(zzbgrVar));
                    zzbhuVar.zzb(zzbgrVar, z4);
                    return zzbgrVar;
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbgq("Webview initialization failed.", th);
        }
    }
}

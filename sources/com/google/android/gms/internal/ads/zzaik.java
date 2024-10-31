package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaik implements zzaic, zzaii {
    private final Context mContext;
    private final zzbgg zzdin;

    public zzaik(Context context, zzbbi zzbbiVar, zzcu zzcuVar, com.google.android.gms.ads.internal.zzv zzvVar) throws zzbgq {
        this.mContext = context;
        com.google.android.gms.ads.internal.zzbv.f();
        this.zzdin = zzbgm.zza(context, zzbht.zzaey(), "", false, false, zzcuVar, zzbbiVar, null, null, null, zzum.zzoi());
        this.zzdin.getView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzwu.zzpv();
        if (zzbat.zzaar()) {
            runnable.run();
        } else {
            zzayh.zzelc.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void destroy() {
        this.zzdin.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final boolean isDestroyed() {
        return this.zzdin.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr> zzuVar) {
        this.zzdin.zza(str, new Fa(this, zzuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map map) {
        zzaid.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        zzaid.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zzb(String str, final com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr> zzuVar) {
        this.zzdin.zza(str, new Predicate(zzuVar) { // from class: com.google.android.gms.internal.ads.Aa

            /* renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.ads.internal.gmsg.zzu f11362a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11362a = zzuVar;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                com.google.android.gms.ads.internal.gmsg.zzu zzuVar2;
                com.google.android.gms.ads.internal.gmsg.zzu zzuVar3 = this.f11362a;
                com.google.android.gms.ads.internal.gmsg.zzu zzuVar4 = (com.google.android.gms.ads.internal.gmsg.zzu) obj;
                if (!(zzuVar4 instanceof Fa)) {
                    return false;
                }
                zzuVar2 = ((Fa) zzuVar4).f11522a;
                return zzuVar2.equals(zzuVar3);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        zzaid.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcd(String str) {
        runOnUiThread(new Ca(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzce(String str) {
        runOnUiThread(new Da(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcf(String str) {
        runOnUiThread(new Ea(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final void zzcg(final String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.za

            /* renamed from: a, reason: collision with root package name */
            private final zzaik f12694a;

            /* renamed from: b, reason: collision with root package name */
            private final String f12695b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12694a = this;
                this.f12695b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12694a.zzck(this.f12695b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzck(String str) {
        this.zzdin.zzcg(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaic
    public final void zzh(String str, String str2) {
        zzaid.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final zzajs zzua() {
        return new zzajt(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zza(zzaij zzaijVar) {
        zzbhn zzadl = this.zzdin.zzadl();
        zzaijVar.getClass();
        zzadl.zza(Ba.a(zzaijVar));
    }
}

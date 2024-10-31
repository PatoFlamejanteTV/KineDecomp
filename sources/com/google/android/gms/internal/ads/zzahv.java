package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzahv extends zzaig<zzajr> implements zzaic, zzaii {
    private final zzbig zzdid;
    private zzaij zzdie;

    /* JADX WARN: Multi-variable type inference failed */
    public zzahv(Context context, zzbbi zzbbiVar) throws zzbgq {
        try {
            this.zzdid = new zzbig(context, new C1146xa(this));
            this.zzdid.setWillNotDraw(true);
            this.zzdid.addJavascriptInterface(new C1132wa(this), "GoogleJsInterface");
            com.google.android.gms.ads.internal.zzbv.e().zza(context, zzbbiVar.zzdp, this.zzdid.getSettings());
            super.zzi(this);
        } catch (Throwable th) {
            throw new zzbgq("Init failed.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void destroy() {
        this.zzdid.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final boolean isDestroyed() {
        return this.zzdid.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zza(zzaij zzaijVar) {
        this.zzdie = zzaijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map map) {
        zzaid.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        zzaid.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        zzaid.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcd(String str) {
        zzce(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzce(String str) {
        zzbcg.zzepo.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.sa

            /* renamed from: a, reason: collision with root package name */
            private final zzahv f12508a;

            /* renamed from: b, reason: collision with root package name */
            private final String f12509b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12508a = this;
                this.f12509b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12508a.zzcj(this.f12509b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcf(String str) {
        zzbcg.zzepo.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.ta

            /* renamed from: a, reason: collision with root package name */
            private final zzahv f12543a;

            /* renamed from: b, reason: collision with root package name */
            private final String f12544b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12543a = this;
                this.f12544b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12543a.zzci(this.f12544b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        zzbcg.zzepo.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.ua

            /* renamed from: a, reason: collision with root package name */
            private final zzahv f12574a;

            /* renamed from: b, reason: collision with root package name */
            private final String f12575b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12574a = this;
                this.f12575b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12574a.zzch(this.f12575b);
            }
        });
    }

    public final /* synthetic */ void zzch(String str) {
        this.zzdid.zzcg(str);
    }

    public final /* synthetic */ void zzci(String str) {
        this.zzdid.loadUrl(str);
    }

    public final /* synthetic */ void zzcj(String str) {
        this.zzdid.loadData(str, "text/html", "UTF-8");
    }

    @Override // com.google.android.gms.internal.ads.zzaic
    public final void zzh(String str, String str2) {
        zzaid.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final zzajs zzua() {
        return new zzajt(this);
    }
}

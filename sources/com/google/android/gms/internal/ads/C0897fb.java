package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.fb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0897fb implements com.google.android.gms.ads.internal.gmsg.zzaf {

    /* renamed from: a, reason: collision with root package name */
    private final zzaji f12154a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbcl f12155b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzakg f12156c;

    public C0897fb(zzakg zzakgVar, zzaji zzajiVar, zzbcl zzbclVar) {
        this.f12156c = zzakgVar;
        this.f12154a = zzajiVar;
        this.f12155b = zzbclVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzaf
    public final void a(JSONObject jSONObject) {
        zzajx zzajxVar;
        try {
            try {
                zzbcl zzbclVar = this.f12155b;
                zzajxVar = this.f12156c.zzdkh;
                zzbclVar.set(zzajxVar.zze(jSONObject));
                this.f12154a.release();
            } catch (IllegalStateException unused) {
                this.f12154a.release();
            } catch (JSONException e2) {
                this.f12155b.set(e2);
                this.f12154a.release();
            }
        } catch (Throwable th) {
            this.f12154a.release();
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzaf
    public final void zzbw(@Nullable String str) {
        try {
            if (str == null) {
                this.f12155b.setException(new zzaju());
            } else {
                this.f12155b.setException(new zzaju(str));
            }
        } catch (IllegalStateException unused) {
        } finally {
            this.f12154a.release();
        }
    }
}

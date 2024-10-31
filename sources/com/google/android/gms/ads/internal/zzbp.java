package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzaow;
import com.google.android.gms.internal.ads.zzapc;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzcu;
import com.google.android.gms.internal.ads.zzcv;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyp;
import com.google.android.gms.internal.ads.zzyv;
import com.google.android.gms.internal.ads.zzzw;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbp extends zzxm {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbi f10233a;

    /* renamed from: b, reason: collision with root package name */
    private final zzwf f10234b;

    /* renamed from: c, reason: collision with root package name */
    private final Future<zzcu> f10235c = zzayf.zza(new C(this));

    /* renamed from: d, reason: collision with root package name */
    private final Context f10236d;

    /* renamed from: e, reason: collision with root package name */
    private final E f10237e;

    /* renamed from: f, reason: collision with root package name */
    private WebView f10238f;

    /* renamed from: g, reason: collision with root package name */
    private zzxa f10239g;

    /* renamed from: h, reason: collision with root package name */
    private zzcu f10240h;
    private AsyncTask<Void, Void, String> i;

    public zzbp(Context context, zzwf zzwfVar, String str, zzbbi zzbbiVar) {
        this.f10236d = context;
        this.f10233a = zzbbiVar;
        this.f10234b = zzwfVar;
        this.f10238f = new WebView(this.f10236d);
        this.f10237e = new E(str);
        c(0);
        this.f10238f.setVerticalScrollBarEnabled(false);
        this.f10238f.getSettings().setJavaScriptEnabled(true);
        this.f10238f.setWebViewClient(new A(this));
        this.f10238f.setOnTouchListener(new B(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(String str) {
        if (this.f10240h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f10240h.zza(parse, this.f10236d, null, null);
        } catch (zzcv e2) {
            zzbbd.zzc("Unable to process ad data", e2);
        }
        return parse.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f10236d.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String A() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzwu.zzpz().zzd(zzaan.zzcvg));
        builder.appendQueryParameter("query", this.f10237e.a());
        builder.appendQueryParameter("pubId", this.f10237e.c());
        Map<String, String> d2 = this.f10237e.d();
        for (String str : d2.keySet()) {
            builder.appendQueryParameter(str, d2.get(str));
        }
        Uri build = builder.build();
        zzcu zzcuVar = this.f10240h;
        if (zzcuVar != null) {
            try {
                build = zzcuVar.zza(build, this.f10236d);
            } catch (zzcv e2) {
                zzbbd.zzc("Unable to process ad data", e2);
            }
        }
        String B = B();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(B).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(B);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String B() {
        String b2 = this.f10237e.b();
        if (TextUtils.isEmpty(b2)) {
            b2 = "www.google.com";
        }
        String str = (String) zzwu.zzpz().zzd(zzaan.zzcvg);
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(b2);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void c(int i) {
        if (this.f10238f == null) {
            return;
        }
        this.f10238f.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void destroy() throws RemoteException {
        Preconditions.a("destroy must be called on the main UI thread.");
        this.i.cancel(true);
        this.f10235c.cancel(true);
        this.f10238f.destroy();
        this.f10238f = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final int f(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwu.zzpv();
            return zzbat.zza(this.f10236d, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzyp getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void pause() throws RemoteException {
        Preconditions.a("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void resume() throws RemoteException {
        Preconditions.a("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxa zzxaVar) throws RemoteException {
        this.f10239g = zzxaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzap(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwbVar) throws RemoteException {
        Preconditions.a(this.f10238f, "This Search Ad has already been torn down");
        this.f10237e.a(zzwbVar, this.f10233a);
        this.i = new D(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final IObjectWrapper zzie() throws RemoteException {
        Preconditions.a("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.a(this.f10238f);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwf zzif() throws RemoteException {
        return this.f10234b;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzih() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzir() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxa zzis() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String zzje() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxtVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxq zzxqVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwf zzwfVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaow zzaowVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzapc zzapcVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabgVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwxVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxz zzxzVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzavb zzavbVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzw zzzwVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyv zzyvVar) {
        throw new IllegalStateException("Unused method");
    }
}

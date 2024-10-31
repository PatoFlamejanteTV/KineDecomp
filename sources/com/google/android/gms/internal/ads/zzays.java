package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import java.util.Set;

@TargetApi(11)
/* loaded from: classes2.dex */
public class zzays extends zzayr {
    @Override // com.google.android.gms.internal.ads.zzayp
    public boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        return ((Boolean) zzbak.zza(context, new Gd(this, context, webSettings))).booleanValue();
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final boolean zzaa(View view) {
        view.setLayerType(1, null);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final Set<String> zzh(Uri uri) {
        return uri.getQueryParameterNames();
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final boolean zzz(View view) {
        view.setLayerType(0, null);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final boolean zza(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public zzbgh zza(zzbgg zzbggVar, zzum zzumVar, boolean z) {
        return new zzbhe(zzbggVar, zzumVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzayr, com.google.android.gms.internal.ads.zzayp
    public final boolean zza(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }
}

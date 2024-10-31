package com.google.android.gms.internal;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public class zzie {

    /* loaded from: classes.dex */
    public static class zza extends zzie {
        public zza() {
            super();
        }

        @Override // com.google.android.gms.internal.zzie
        public boolean zza(DownloadManager.Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        @Override // com.google.android.gms.internal.zzie
        public int zzgG() {
            return 6;
        }

        @Override // com.google.android.gms.internal.zzie
        public int zzgH() {
            return 7;
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends zza {
        @Override // com.google.android.gms.internal.zzie.zza, com.google.android.gms.internal.zzie
        public boolean zza(DownloadManager.Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        @Override // com.google.android.gms.internal.zzie
        public boolean zza(Context context, WebSettings webSettings) {
            if (context.getCacheDir() != null) {
                webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                webSettings.setAppCacheMaxSize(0L);
                webSettings.setAppCacheEnabled(true);
            }
            webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            return true;
        }

        @Override // com.google.android.gms.internal.zzie
        public boolean zza(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        @Override // com.google.android.gms.internal.zzie
        public zzja zzb(zziz zzizVar, boolean z) {
            return new zzjg(zzizVar, z);
        }

        @Override // com.google.android.gms.internal.zzie
        public WebChromeClient zzf(zziz zzizVar) {
            return new zzjf(zzizVar);
        }

        @Override // com.google.android.gms.internal.zzie
        public Set<String> zzf(Uri uri) {
            return uri.getQueryParameterNames();
        }

        @Override // com.google.android.gms.internal.zzie
        public boolean zzl(View view) {
            view.setLayerType(0, null);
            return true;
        }

        @Override // com.google.android.gms.internal.zzie
        public boolean zzm(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class zzc extends zzb {
        @Override // com.google.android.gms.internal.zzie
        public String zza(SslError sslError) {
            return sslError.getUrl();
        }

        @Override // com.google.android.gms.internal.zzie.zzb, com.google.android.gms.internal.zzie
        public WebChromeClient zzf(zziz zzizVar) {
            return new zzjh(zzizVar);
        }
    }

    /* loaded from: classes.dex */
    public static class zzd extends zzf {
        @Override // com.google.android.gms.internal.zzie
        public String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        @Override // com.google.android.gms.internal.zzie
        public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        @Override // com.google.android.gms.internal.zzie.zzb, com.google.android.gms.internal.zzie
        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class zze extends zzd {
        @Override // com.google.android.gms.internal.zzie
        public boolean isAttachedToWindow(View view) {
            return super.isAttachedToWindow(view) || view.getWindowId() != null;
        }

        @Override // com.google.android.gms.internal.zzie
        public int zzgI() {
            return 14;
        }
    }

    /* loaded from: classes.dex */
    public static class zzf extends zzc {
        @Override // com.google.android.gms.internal.zzie
        public void zza(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @Override // com.google.android.gms.internal.zzie
        public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @Override // com.google.android.gms.internal.zzie
        public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
                return;
            }
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    /* loaded from: classes.dex */
    public static class zzg extends zze {
        @Override // com.google.android.gms.internal.zzie.zze, com.google.android.gms.internal.zzie
        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        @Override // com.google.android.gms.internal.zzie
        public ViewGroup.LayoutParams zzgJ() {
            return new ViewGroup.LayoutParams(-1, -1);
        }
    }

    private zzie() {
    }

    /* synthetic */ zzie(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static zzie zzM(int i) {
        return i >= 19 ? new zzg() : i >= 18 ? new zze() : i >= 17 ? new zzd() : i >= 16 ? new zzf() : i >= 14 ? new zzc() : i >= 11 ? new zzb() : i >= 9 ? new zza() : new zzie();
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return "";
    }

    public void zza(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(DownloadManager.Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public boolean zza(WebView webView) {
        if (webView == null) {
            return false;
        }
        webView.onPause();
        return true;
    }

    public zzja zzb(zziz zzizVar, boolean z) {
        return new zzja(zzizVar, z);
    }

    public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }

    public boolean zzb(WebView webView) {
        if (webView == null) {
            return false;
        }
        webView.onResume();
        return true;
    }

    public WebChromeClient zzf(zziz zzizVar) {
        return null;
    }

    public Set<String> zzf(Uri uri) {
        String encodedQuery;
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            do {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                i = indexOf + 1;
            } while (i < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    public int zzgG() {
        return 0;
    }

    public int zzgH() {
        return 1;
    }

    public int zzgI() {
        return 5;
    }

    public ViewGroup.LayoutParams zzgJ() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public boolean zzl(View view) {
        return false;
    }

    public boolean zzm(View view) {
        return false;
    }
}

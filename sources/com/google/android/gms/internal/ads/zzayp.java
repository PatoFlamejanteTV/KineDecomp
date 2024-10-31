package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@zzark
@TargetApi(8)
/* loaded from: classes2.dex */
public class zzayp {
    /* JADX INFO: Access modifiers changed from: private */
    public zzayp() {
    }

    public static boolean zzaaa() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public static boolean zzi(zzbgg zzbggVar) {
        if (zzbggVar == null) {
            return false;
        }
        zzbggVar.onPause();
        return true;
    }

    public static boolean zzj(zzbgg zzbggVar) {
        if (zzbggVar == null) {
            return false;
        }
        zzbggVar.onResume();
        return true;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public void setBackground(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public zzbgh zza(zzbgg zzbggVar, zzum zzumVar, boolean z) {
        return new zzbgh(zzbggVar, zzumVar, z);
    }

    public String zza(SslError sslError) {
        return "";
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

    public boolean zzaa(View view) {
        return false;
    }

    public int zzaab() {
        return 0;
    }

    public void zzaz(Context context) {
    }

    public CookieManager zzba(Context context) {
        if (zzaaa()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbbd.zzb("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public Set<String> zzh(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
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

    public boolean zzz(View view) {
        return false;
    }

    public int zzzw() {
        return 0;
    }

    public int zzzx() {
        return 1;
    }

    public int zzzy() {
        return 5;
    }

    public ViewGroup.LayoutParams zzzz() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public /* synthetic */ zzayp(Fd fd) {
        this();
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f2) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }
}

package com.google.android.gms.internal;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

@zzgr
/* loaded from: classes.dex */
public class zzjf extends WebChromeClient {
    private final zziz zzoM;

    /* renamed from: com.google.android.gms.internal.zzjf$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1731a = new int[ConsoleMessage.MessageLevel.values().length];

        static {
            try {
                f1731a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1731a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1731a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1731a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1731a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public zzjf(zziz zzizVar) {
        this.zzoM = zzizVar;
    }

    private static void zza(AlertDialog.Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(R.string.ok, new en(jsResult)).setNegativeButton(R.string.cancel, new em(jsResult)).setOnCancelListener(new el(jsResult)).create().show();
    }

    private static void zza(Context context, AlertDialog.Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(str);
        EditText editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(R.string.ok, new eq(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new ep(jsPromptResult)).setOnCancelListener(new eo(jsPromptResult)).create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Context zzc(WebView webView) {
        if (!(webView instanceof zziz)) {
            return webView.getContext();
        }
        zziz zzizVar = (zziz) webView;
        Activity zzgZ = zzizVar.zzgZ();
        return zzgZ == null ? zzizVar.getContext() : zzgZ;
    }

    private final boolean zzhE() {
        return com.google.android.gms.ads.internal.zzp.e().zza(this.zzoM.getContext().getPackageManager(), this.zzoM.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || com.google.android.gms.ads.internal.zzp.e().zza(this.zzoM.getContext().getPackageManager(), this.zzoM.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zziz)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzhc = ((zziz) webView).zzhc();
        if (zzhc == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzhc.a();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (AnonymousClass1.f1731a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                com.google.android.gms.ads.internal.util.client.zzb.b(str);
                break;
            case 2:
                com.google.android.gms.ads.internal.util.client.zzb.e(str);
                break;
            case 3:
            case 4:
                com.google.android.gms.ads.internal.util.client.zzb.c(str);
                break;
            case 5:
                com.google.android.gms.ads.internal.util.client.zzb.a(str);
                break;
            default:
                com.google.android.gms.ads.internal.util.client.zzb.c(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.zzoM.zzhe());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072L, j4) + j, 1048576L);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (callback != null) {
            callback.invoke(str, zzhE(), true);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzd zzhc = this.zzoM.zzhc();
        if (zzhc == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not get ad overlay when hiding custom view.");
        } else {
            zzhc.b();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzc(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0L);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, -1, customViewCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzd zzhc = this.zzoM.zzhc();
        if (zzhc == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
        } else {
            zzhc.a(view, customViewCallback);
            zzhc.a(i);
        }
    }

    protected boolean zza(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str);
            if (z) {
                zza(context, builder, str2, str3, jsPromptResult);
            } else {
                zza(builder, str2, jsResult);
            }
            return true;
        } catch (WindowManager.BadTokenException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Fail to display Dialog.", e);
            return true;
        }
    }
}

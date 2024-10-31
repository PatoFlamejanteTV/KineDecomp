package com.google.ads.consent;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.internal.NativeProtocol;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConsentForm {
    private final boolean adFreeOption;
    private final URL appPrivacyPolicyURL;
    private final Context context;
    private final Dialog dialog;
    private final ConsentFormListener listener;
    private LoadState loadState;
    private final boolean nonPersonalizedAdsOption;
    private final boolean personalizedAdsOption;
    private final WebView webView;

    /* renamed from: com.google.ads.consent.ConsentForm$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ConsentFormListener {
    }

    /* renamed from: com.google.ads.consent.ConsentForm$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements DialogInterface.OnShowListener {
        final /* synthetic */ ConsentForm this$0;

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.this$0.listener.b();
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private boolean adFreeOption;
        private final URL appPrivacyPolicyURL;
        private final Context context;
        private ConsentFormListener listener;
        private boolean nonPersonalizedAdsOption;
        private boolean personalizedAdsOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum LoadState {
        NOT_READY,
        LOADING,
        LOADED
    }

    private static String b(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.listener.a("No valid URL for browser navigation.");
            return;
        }
        try {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            this.listener.a("No Activity found to handle browser intent.");
        }
    }

    /* renamed from: com.google.ads.consent.ConsentForm$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends WebViewClient {
        boolean isInternalRedirect;
        final /* synthetic */ ConsentForm this$0;

        private void a(String str) {
            if (b(str)) {
                this.isInternalRedirect = true;
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter(NativeProtocol.WEB_DIALOG_ACTION);
                String queryParameter2 = parse.getQueryParameter("status");
                String queryParameter3 = parse.getQueryParameter("url");
                char c2 = 65535;
                int hashCode = queryParameter.hashCode();
                if (hashCode != -1370505102) {
                    if (hashCode != 150940456) {
                        if (hashCode == 1671672458 && queryParameter.equals("dismiss")) {
                            c2 = 1;
                        }
                    } else if (queryParameter.equals("browser")) {
                        c2 = 2;
                    }
                } else if (queryParameter.equals("load_complete")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    this.this$0.b(queryParameter2);
                    return;
                }
                if (c2 == 1) {
                    this.isInternalRedirect = false;
                    this.this$0.a(queryParameter2);
                } else {
                    if (c2 != 2) {
                        return;
                    }
                    this.this$0.c(queryParameter3);
                }
            }
        }

        private boolean b(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("consent://");
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            a(str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!this.isInternalRedirect) {
                this.this$0.a(webView);
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            this.this$0.loadState = LoadState.NOT_READY;
            this.this$0.listener.a(webResourceError.toString());
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl().toString();
            if (!b(uri)) {
                return false;
            }
            a(uri);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!b(str)) {
                return false;
            }
            a(str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.loadState = LoadState.NOT_READY;
            this.listener.a("No information");
        } else if (str.contains("Error")) {
            this.loadState = LoadState.NOT_READY;
            this.listener.a(str);
        } else {
            this.loadState = LoadState.LOADED;
            this.listener.a();
        }
    }

    private static String a(Context context) {
        Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
        Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        applicationIcon.draw(canvas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        return valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
    }

    private static String a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("info", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("args", hashMap);
        return String.format("javascript:%s(%s)", str, new Gson().toJson(hashMap2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, b(this.context));
        hashMap.put("app_icon", a(this.context));
        hashMap.put("offer_personalized", Boolean.valueOf(this.personalizedAdsOption));
        hashMap.put("offer_non_personalized", Boolean.valueOf(this.nonPersonalizedAdsOption));
        hashMap.put("offer_ad_free", Boolean.valueOf(this.adFreeOption));
        hashMap.put("is_request_in_eea_or_unknown", Boolean.valueOf(ConsentInformation.a(this.context).d()));
        hashMap.put("app_privacy_url", this.appPrivacyPolicyURL);
        ConsentData f2 = ConsentInformation.a(this.context).f();
        hashMap.put("plat", f2.d());
        hashMap.put("consent_info", f2);
        webView.loadUrl(a("setUpConsentDialog", new Gson().toJson(hashMap)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        ConsentStatus consentStatus;
        this.loadState = LoadState.NOT_READY;
        this.dialog.dismiss();
        if (TextUtils.isEmpty(str)) {
            this.listener.a("No information provided.");
            return;
        }
        if (str.contains("Error")) {
            this.listener.a(str);
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        boolean z = false;
        if (hashCode != -1152655096) {
            if (hashCode != -258041904) {
                if (hashCode == 1666911234 && str.equals("non_personalized")) {
                    c2 = 1;
                }
            } else if (str.equals("personalized")) {
                c2 = 0;
            }
        } else if (str.equals("ad_free")) {
            c2 = 2;
        }
        if (c2 == 0) {
            consentStatus = ConsentStatus.PERSONALIZED;
        } else if (c2 == 1) {
            consentStatus = ConsentStatus.NON_PERSONALIZED;
        } else if (c2 != 2) {
            consentStatus = ConsentStatus.UNKNOWN;
        } else {
            consentStatus = ConsentStatus.UNKNOWN;
            z = true;
        }
        ConsentInformation.a(this.context).a(consentStatus, "form");
        this.listener.a(consentStatus, Boolean.valueOf(z));
    }
}

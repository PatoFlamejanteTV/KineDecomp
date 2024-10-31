package com.adobe.creativesdk.foundation.internal.auth;

import android.app.AlertDialog;
import android.net.UrlQuerySanitizer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
public class T extends WebViewClient {

    /* renamed from: f, reason: collision with root package name */
    AdobeAuthSignInActivity.a f4864f;

    /* renamed from: g, reason: collision with root package name */
    private N f4865g;

    /* renamed from: a, reason: collision with root package name */
    String f4859a = "code";

    /* renamed from: b, reason: collision with root package name */
    String f4860b = "device_token";

    /* renamed from: c, reason: collision with root package name */
    String f4861c = "error";

    /* renamed from: d, reason: collision with root package name */
    String f4862d = "access_denied#";

    /* renamed from: e, reason: collision with root package name */
    String f4863e = "invalid_scope";

    /* renamed from: h, reason: collision with root package name */
    private boolean f4866h = false;

    public T(AdobeAuthSignInActivity.a aVar) {
        this.f4864f = aVar;
    }

    private boolean a(String str) {
        boolean z;
        try {
            URI uri = new URI(AdobeAuthIdentityManagementService.K().H());
            String scheme = uri.getScheme();
            String host = uri.getHost();
            URI uri2 = new URI(str);
            String scheme2 = uri2.getScheme();
            String host2 = uri2.getHost();
            if (!"www.adobe.com".equals(host2) && !"adobe.com".equals(host2)) {
                z = false;
                if (E.m().g() && z) {
                    this.f4866h = true;
                    return false;
                }
                if (host2 != null || scheme2 == null || host == null || scheme == null) {
                    return false;
                }
                return (host2.equals(host) && scheme2.equals(scheme)) || host2.equals("www.adobe.com") || host2.equals("adobe.com") || host2.equals("fake.domain.adobe.com");
            }
            z = true;
            if (E.m().g()) {
            }
            return host2 != null ? false : false;
        } catch (URISyntaxException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "doesMatchWithRedirectURI failure", e2.getMessage());
            return false;
        }
    }

    private boolean b(String str) {
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = new UrlQuerySanitizer(str).getParameterList();
        boolean z = false;
        for (int i = 0; i < parameterList.size(); i++) {
            UrlQuerySanitizer.ParameterValuePair parameterValuePair = parameterList.get(i);
            if (parameterValuePair.mParameter.equals(this.f4859a)) {
                if (a(str)) {
                    this.f4865g.a(parameterValuePair.mValue);
                    z = true;
                } else {
                    if (this.f4866h) {
                        AdobeAuthSignInActivity.a aVar = this.f4864f;
                        aVar.f(aVar.getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_id_pre_UDP_client_error));
                    } else {
                        this.f4864f.C();
                    }
                }
            } else {
                if (parameterValuePair.mParameter.equals(this.f4860b)) {
                    if (a(str)) {
                        this.f4865g.b(parameterValuePair.mValue);
                        z = true;
                    } else if (this.f4866h) {
                        AdobeAuthSignInActivity.a aVar2 = this.f4864f;
                        aVar2.f(aVar2.getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_id_pre_UDP_client_error));
                    } else {
                        this.f4864f.C();
                    }
                } else if (parameterValuePair.mParameter.equals(this.f4861c) && parameterValuePair.mValue.equals(this.f4862d)) {
                    this.f4865g.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED));
                } else if (parameterValuePair.mParameter.equals(this.f4861c) && parameterValuePair.mValue.equals(this.f4863e)) {
                    this.f4864f.C();
                }
            }
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", "onPageFinished");
        this.f4864f.D();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "Authentication", "onReceivedError:Webpage Error=" + str + " with webpage error " + i);
        if (i == -1 && str.equals("net::ERR_CACHE_MISS")) {
            this.f4865g.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED));
        } else {
            this.f4864f.C();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AdobeAuthSignInActivity.a aVar = this.f4864f;
        aVar.f4787g = true;
        View inflate = aVar.getActivity().getLayoutInflater().inflate(com.adobe.creativesdk.foundation.auth.q.adobe_csdk_ux_auth_dialog_proxy_credentials, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_proxy_userName);
        EditText editText2 = (EditText) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_proxy_passWord);
        ((TextView) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_proxy_warningMsg)).setText(String.format(inflate.getResources().getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_warning_msg), str, str2));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f4864f.getActivity(), com.adobe.creativesdk.foundation.auth.s.AdobeCSDKProxyAlertDialog);
        AlertDialog create = builder.create();
        builder.setCustomTitle(this.f4864f.getActivity().getLayoutInflater().inflate(com.adobe.creativesdk.foundation.auth.q.adobe_csdk_ux_auth_dialog_proxy_title, (ViewGroup) null));
        builder.setMessage(" ");
        builder.setCancelable(true);
        builder.setView(inflate);
        builder.setNegativeButton(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_cancelLogIn, new Q(this, create, httpAuthHandler));
        builder.setPositiveButton(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_logIn, new S(this, httpAuthHandler, editText, editText2));
        builder.show();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return b(str);
    }

    public void a(N n) {
        this.f4865g = n;
    }
}

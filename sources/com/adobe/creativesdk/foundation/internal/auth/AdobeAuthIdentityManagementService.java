package com.adobe.creativesdk.foundation.internal.auth;

import android.os.Handler;
import android.text.TextUtils;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.facebook.AccessToken;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobeAuthIdentityManagementService {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4762a = {"creative_sdk", "AdobeID"};

    /* renamed from: b, reason: collision with root package name */
    private static volatile AdobeAuthIdentityManagementService f4763b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f4764c = 1;
    private volatile Date A;
    private volatile Date B;
    private volatile Date C;
    private com.adobe.creativesdk.foundation.internal.net.A D;
    private AdobeAuthIMSEnvironment E;
    private AdobeAuthIMSGrantType F;
    private volatile Set<String> G;
    private L H;
    private boolean I = false;
    private volatile String J = null;

    /* renamed from: d, reason: collision with root package name */
    private final AdobeAuthKeychain f4765d;

    /* renamed from: e, reason: collision with root package name */
    private volatile String f4766e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f4767f;

    /* renamed from: g, reason: collision with root package name */
    private volatile String f4768g;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f4769h;
    private volatile String i;
    private volatile String j;
    private volatile String k;
    private volatile String l;
    private volatile String m;
    private volatile String n;
    private volatile String o;
    private volatile String p;
    private volatile String q;
    private volatile String r;
    private volatile String s;
    private volatile String t;
    private volatile String u;
    private volatile String v;
    private volatile String w;
    private volatile String x;
    private volatile String y;
    private volatile String z;

    /* loaded from: classes.dex */
    public enum TokenType {
        AccessToken,
        DeviceToken,
        RefreshToken
    }

    private AdobeAuthIdentityManagementService() {
        a(J.e().d());
        this.f4765d = new AdobeAuthKeychain(this);
        AdobeAuthKeychain.a(this.f4765d);
        a(AdobeAuthKeychain.r().n());
        a((String[]) null);
    }

    public static AdobeAuthIdentityManagementService K() {
        if (f4763b == null) {
            synchronized (AdobeAuthIdentityManagementService.class) {
                if (f4763b == null) {
                    f4763b = new AdobeAuthIdentityManagementService();
                }
            }
        }
        return f4763b;
    }

    private void R() {
        if (p() == null) {
            return;
        }
        I.c(c.a.a.a.c.a.a.b().a());
    }

    private void S() {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "AuthIMS", "resetKeys");
        this.f4765d.s();
        this.f4767f = null;
        this.f4766e = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.f4768g = null;
        this.f4769h = null;
        this.i = null;
        this.G = null;
        this.j = null;
        this.k = null;
        this.z = null;
        this.x = null;
        this.y = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        a(TokenType.DeviceToken, str, 15768000);
    }

    private void x(String str) {
        a(TokenType.RefreshToken, str, 1209600);
    }

    public String A() {
        return this.q;
    }

    public String B() {
        if (this.z == null) {
            this.z = this.f4765d.l();
        }
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String C() {
        if (this.i == null) {
            this.i = this.f4765d.o();
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String D() {
        return "/ims/authorize/" + E();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String E() {
        return "v1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String F() {
        return "/ims/logout/" + G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G() {
        return "v1";
    }

    public String H() {
        if (this.J == null) {
            this.J = "https://adobe.com";
        }
        return this.J;
    }

    public String I() {
        if (this.o == null) {
            Date q = this.f4765d.q();
            if (q != null && q.getTime() - new Date().getTime() > 0) {
                this.o = this.f4765d.p();
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting Refresh Token; (inside if)ExpirationDate : " + q);
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting Refresh Token; (inside else)ExpirationDate : " + q);
            }
        }
        return this.o;
    }

    public Date J() {
        if (this.C == null) {
            this.C = this.f4765d.q();
        }
        if (this.C == null) {
            return null;
        }
        Date date = new Date(this.C.getTime());
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting Refresh Token Expiration Time : " + date);
        return date;
    }

    public URL L() {
        String str;
        String str2;
        String str3;
        String str4;
        String url = f().toString();
        if (this.F == AdobeAuthIMSGrantType.AdobeAuthIMSGrantTypeAuthorization) {
            str3 = url + "?redirect_uri=signin%3A%2F%2Fcomplete&scope=" + this.w + "&force_marketing_permission=true&idp_flow=login&client_id=" + h() + "&dc=false&locale=" + o();
        } else {
            try {
                str = URLEncoder.encode(p(), "UTF-8");
                str2 = URLEncoder.encode(q(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error during encode", e2);
                str = "";
                str2 = str;
            }
            str3 = url + "?redirect_uri=signin%3A%2F%2Fcomplete&scope=" + this.w + "&force_marketing_permission=true&idp_flow=login&response_type=device&device_id=" + str + "&device_name=" + str2 + "&client_id=" + h() + "&dc=false&locale=" + o();
        }
        if (j() != null && !j().equals("")) {
            try {
                str4 = URLEncoder.encode(j(), "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error during encode process", e3);
                str4 = null;
            }
            str3 = str3 + "&state=" + str4;
        }
        try {
            return new URL(str3);
        } catch (MalformedURLException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Sign in url is malformed", e4);
            return null;
        }
    }

    URL M() {
        try {
            return new URL((this.q + F()) + "?access_token=" + this.f4766e + "&client_id=" + h() + "&client_secret=" + i());
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Malformed exception", e2);
            return null;
        }
    }

    public URL N() {
        String str;
        String str2;
        String str3;
        String str4;
        String url = f().toString();
        if (this.F == AdobeAuthIMSGrantType.AdobeAuthIMSGrantTypeAuthorization) {
            str3 = url + "?redirect_uri=signin%3A%2F%2Fcomplete&scope=" + this.w + "&idp_flow=create_account&force_marketing_permission=true&client_id=" + h() + "&locale=" + o();
        } else {
            try {
                str = URLEncoder.encode(p(), "UTF-8");
                str2 = URLEncoder.encode(q(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error during encode process", e2);
                str = null;
                str2 = null;
            }
            str3 = url + "?redirect_uri=signin%3A%2F%2Fcomplete&scope=" + this.w + "&idp_flow=create_account&force_marketing_permission=true&response_type=device&device_id=" + str + "&device_name=" + str2 + "&client_id=" + h() + "&locale=" + o();
        }
        if (j() != null && !j().equals("")) {
            try {
                str4 = URLEncoder.encode(j(), "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error during encode process", e3);
                str4 = null;
            }
            str3 = str3 + "&state=" + str4;
        }
        try {
            return new URL(str3);
        } catch (MalformedURLException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Malformed url", e4);
            return null;
        }
    }

    public String O() {
        String str;
        String str2 = "";
        try {
            str = URLEncoder.encode("creative_sdk,openid", "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            str = "";
        }
        try {
            str2 = URLEncoder.encode(x(), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error during encode process", e);
            return "scope=" + str + "&idp_flow=social.native&force_marketing_permission=true&client_id=" + h() + "&provider_id=facebook&idp_token=" + str2;
        }
        return "scope=" + str + "&idp_flow=social.native&force_marketing_permission=true&client_id=" + h() + "&provider_id=facebook&idp_token=" + str2;
    }

    URL P() {
        try {
            return new URL(this.q + "/ims/token/v1");
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Invalid token url", e2);
            return null;
        }
    }

    URL Q() {
        try {
            return new URL(this.q + "/ims/validate_token/v1");
        } catch (MalformedURLException unused) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Invalid validate token url");
            return null;
        }
    }

    public void a(com.adobe.creativesdk.foundation.internal.net.F f2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
    }

    public String c() {
        if (this.f4766e == null) {
            Date b2 = this.f4765d.b();
            if (b2 != null && b2.getTime() - new Date().getTime() > 0) {
                this.f4766e = this.f4765d.a();
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting Access Token; (inside if)ExpirationDate : " + b2);
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting Access Token; (inside else)ExpirationDate : " + b2);
            }
        }
        return this.f4766e;
    }

    void d(String str) {
        this.u = str;
        a("ClientSecret", str);
    }

    public String e() {
        if (TextUtils.isEmpty(this.f4767f)) {
            this.f4767f = this.f4765d.c();
        }
        return this.f4767f;
    }

    void f(String str) {
        this.p = str;
        a("ContinuationToken", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str) {
        this.f4765d.a("ContinuableEventErrorCode", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str) {
        if (str == null) {
            this.f4765d.a("ContinuableEventJumpURL");
        } else {
            this.f4765d.a("ContinuableEventJumpURL", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        this.l = str;
        a("CountryCode", str);
    }

    public String j() {
        if (this.v == null) {
            this.v = this.f4765d.b("ClientState");
        }
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobeAuthException k() {
        char c2;
        String l = l();
        int hashCode = l.hashCode();
        if (hashCode == -1766661833) {
            if (l.equals("ride_AdobeID_acct_terms")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode != -171684462) {
            if (hashCode == 522321180 && l.equals("ride_AdobeID_acct_actreq")) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (l.equals("ride_AdobeID_acct_evs")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_EMAIL_VERIFICATION);
        }
        if (c2 == 1) {
            return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UPDATED_TOU);
        }
        if (c2 != 2) {
            return null;
        }
        return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_AGE_VERIFICATION);
    }

    public String l() {
        return this.f4765d.d();
    }

    public String m() {
        return this.f4765d.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str) {
        this.j = str;
        a("Email", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str) {
        this.k = str;
        a("EmailVerified", str);
    }

    public String p() {
        if (this.s == null) {
            this.s = this.f4765d.b("DeviceId");
        }
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        this.f4769h = str;
        a("FirstName", str);
    }

    public String r() {
        if (this.m == null) {
            Date h2 = this.f4765d.h();
            if (h2 != null && h2.getTime() - new Date().getTime() > 0) {
                this.m = this.f4765d.g();
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting Device Token; (inside if)ExpirationDate : " + h2);
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting Device Token; (inside else)ExpirationDate : " + h2);
            }
        }
        return this.m;
    }

    public void s(String str) {
        this.z = str;
        a("EnterpriseInfo", str);
    }

    public String t() {
        if (this.f4768g == null) {
            this.f4768g = this.f4765d.i();
        }
        return this.f4768g;
    }

    public String u() {
        if (this.j == null) {
            this.j = this.f4765d.j();
        }
        return this.j;
    }

    public String v() {
        if (this.k == null) {
            this.k = this.f4765d.k();
        }
        return this.k;
    }

    public String y() {
        if (this.f4769h == null) {
            this.f4769h = this.f4765d.m();
        }
        return this.f4769h;
    }

    public String z() {
        if (this.y == null) {
            this.y = this.f4765d.b("idpFlow");
        }
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(AdobeNetworkException adobeNetworkException) {
        String d2 = ((com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get(AdobeNetworkException.getKeyForResponse())).d();
        JSONObject jSONObject = null;
        if (d2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(d2);
            try {
                String optString = jSONObject2.optString("error");
                String optString2 = jSONObject2.optString("jump");
                if (optString == null || optString2 == null) {
                    return null;
                }
                if (optString != null && !optString.equals("ride_AdobeID_acct_evs") && !optString.equals("ride_AdobeID_acct_terms")) {
                    if (!optString.equals("ride_AdobeID_acct_actreq")) {
                        return null;
                    }
                }
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error parsing JSON", e);
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public L g() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str) {
        this.m = str;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Setting Device Token " + new Date().toString());
        a("DeviceToken", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str) {
        this.f4768g = str;
        a("DisplayName", str);
    }

    public AdobeAuthIMSEnvironment w() {
        return this.E;
    }

    public String x() {
        return this.x;
    }

    public Date d() {
        if (this.A == null) {
            this.A = this.f4765d.b();
        }
        if (this.A == null) {
            return null;
        }
        Date date = new Date(this.A.getTime());
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting the access token expiration time : " + date);
        return date;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public URL f() {
        try {
            return new URL(this.q + D());
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Invalid auth URL", e2);
            return null;
        }
    }

    public String h() {
        if (this.t == null) {
            this.t = this.f4765d.b("ClientId");
        }
        return this.t;
    }

    public String i() {
        if (this.u == null) {
            this.u = this.f4765d.b("ClientSecret");
        }
        return this.u;
    }

    public String n() {
        if (this.l == null) {
            this.l = this.f4765d.f();
        }
        return this.l;
    }

    String o() {
        return Locale.getDefault().toString();
    }

    public String q() {
        if (this.r == null) {
            this.r = this.f4765d.b("DeviceName");
        }
        return this.r;
    }

    public Date s() {
        if (this.B == null) {
            this.B = this.f4765d.h();
        }
        if (this.B == null) {
            return null;
        }
        Date date = new Date(this.B.getTime());
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Getting DeviceTokenExpirationTime : " + date);
        return date;
    }

    public void e(String str) {
        this.v = str;
        a("ClientState", str);
    }

    protected void j(String str) {
        this.s = str;
        a("DeviceId", str);
    }

    public void p(String str) {
        this.x = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str) {
        this.i = str;
        a("LastName", str);
    }

    public void u(String str) {
        this.J = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(String str) {
        this.o = str;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Setting Refresh Token " + new Date().toString());
        a("RefreshToken", str);
    }

    void k(String str) {
        this.r = str;
        a("DeviceName", str);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        c(str);
        d(str2);
        e(str3);
        j(str4);
        k(str5);
    }

    void c(String str) {
        this.t = str;
        a("ClientId", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(String str) {
        this.y = str;
        a("idpFlow", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdobeAuthException b(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null || (optString = jSONObject.optString("error")) == null) {
            return null;
        }
        char c2 = 65535;
        int hashCode = optString.hashCode();
        if (hashCode != -1766661833) {
            if (hashCode != -171684462) {
                if (hashCode == 522321180 && optString.equals("ride_AdobeID_acct_actreq")) {
                    c2 = 2;
                }
            } else if (optString.equals("ride_AdobeID_acct_evs")) {
                c2 = 0;
            }
        } else if (optString.equals("ride_AdobeID_acct_terms")) {
            c2 = 1;
        }
        if (c2 == 0) {
            return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_EMAIL_VERIFICATION);
        }
        if (c2 == 1) {
            return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UPDATED_TOU);
        }
        if (c2 != 2) {
            return null;
        }
        return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_AGE_VERIFICATION);
    }

    private void c(Date date) {
        this.C = date;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Setting Refresh Token Expiration Time " + date);
        a("RefreshTokenExpiration", date);
    }

    public void a(AdobeAuthIMSGrantType adobeAuthIMSGrantType) {
        this.F = adobeAuthIMSGrantType;
    }

    void c(String str, Z z) {
        if (h() == null) {
            z.c();
            return;
        }
        if (i() == null) {
            z.b();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "refresh_token");
        hashMap.put("refresh_token", str);
        if (!this.I) {
            hashMap.put("client_id", h());
            hashMap.put("client_secret", i());
        } else {
            hashMap.put("client_id", "FastExpiringTokenTest3");
            hashMap.put("client_secret", "305d59c4-f42c-4cab-b596-cc0986bcdeff");
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Refreshing Access Token " + new Date().toString());
        a(P(), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, hashMap, "application/x-www-form-urlencoded", new C0302f(this, z));
    }

    public void a(V v) {
        this.m = r();
        this.o = I();
        if (p() == null || (this.m != null && this.m.isEmpty())) {
            this.m = null;
        }
        if (I() == null || (this.o != null && this.o.isEmpty())) {
            this.o = null;
        }
        if (this.o != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Trying to refresh the access token with refresh token");
            c(this.o, new C0308l(this, v));
        } else if (this.m != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Trying to refresh the access token with device token");
            b(this.m, new C0311o(this, v));
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Show signin UI");
            v.a(AdobeAuthIMSInfoNeeded.AdobeAuthIMSInfoNeededUsernameAndPassword);
        }
    }

    public void b(String str, Z z) {
        if (p() == null) {
            z.a();
            return;
        }
        if (h() == null) {
            z.c();
            return;
        }
        if (i() == null) {
            z.b();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "device");
        hashMap.put("device_token", str);
        hashMap.put("device_id", p());
        hashMap.put("client_id", h());
        hashMap.put("client_secret", i());
        hashMap.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, H());
        hashMap.put("scope", this.w);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithDeviceToken() " + new Date().toString());
        a(P(), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, hashMap, "application/x-www-form-urlencoded", new C0313q(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONException jSONException, V v) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error parsing JSON", jSONException);
        v.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UNKNOWN_ERROR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdobeAuthException a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorOffline) {
            return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_OFFLINE);
        }
        return new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_NETWORK_ERROR);
    }

    public void b(String str, V v) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "trying to sign in with authCode");
        w(str);
        b(str, new C0318w(this, str, v));
    }

    protected void a(String str, Z z) {
        if (h() == null) {
            z.c();
            return;
        }
        if (i() == null) {
            z.b();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "authorization_code");
        hashMap.put("code", str);
        if (this.F == AdobeAuthIMSGrantType.AdobeAuthIMSGrantTypeDevice) {
            hashMap.put("device_id", p());
        }
        hashMap.put("client_id", h());
        hashMap.put("client_secret", i());
        hashMap.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, H());
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithAuthCode() " + new Date().toString());
        a(P(), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, hashMap, "application/x-www-form-urlencoded", new C0312p(this, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "adobeID empty.");
        }
        this.f4767f = str;
        this.f4765d.a("AdobeID", str);
    }

    private void b(Date date) {
        this.B = date;
        a("DeviceTokenExpiration", date);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Setting DeviceTokenExpirationTime : " + date);
    }

    void b() {
        a((com.adobe.creativesdk.foundation.internal.net.F) null);
    }

    public void a(String str, V v) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "trying to sign in with authCode");
        a(str, (Z) new C0315t(this, v));
    }

    public void a(W w) {
        h(null);
        if (c() != null) {
            a(M(), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, new HashMap(), (String) null, new C0319x(this, w));
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Trying to reset tokens from signOut()(accessToken is not null)");
            S();
            R();
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Trying to reset tokens from signOut()(accessToken is null)");
        S();
        R();
        w.onSuccess();
    }

    public void a(String[] strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(f4762a));
        if (strArr != null) {
            for (String str : strArr) {
                String replaceAll = str.replaceAll("\\s", "");
                if (replaceAll.length() > 0) {
                    linkedHashSet.add(replaceAll);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(",");
        }
        this.w = sb.substring(0, sb.length() - 1);
    }

    public void a() {
        this.f4765d.a("ContinuableEventJumpURL");
        this.f4765d.a("ContinuableEventErrorCode");
    }

    void a(String str) {
        this.f4766e = str;
        a("AccessToken", str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Setting the access token " + new Date().toString());
    }

    public void a(Date date) {
        this.A = date;
        a("AccessTokenExpiration", date);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Setting the expiration time of access token : " + date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TokenType tokenType, Date date) {
        int i = C0305i.f4889a[tokenType.ordinal()];
        if (i == 1) {
            b(date);
            return;
        }
        if (i == 2) {
            a(date);
            return;
        }
        if (i != 3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "unknown token type " + tokenType);
            return;
        }
        c(date);
    }

    private void a(TokenType tokenType, String str, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, i);
        a(tokenType, calendar.getTime());
        a(str, (com.adobe.creativesdk.foundation.internal.net.F) new C0320y(this, tokenType));
    }

    public void a(String str, com.adobe.creativesdk.foundation.internal.net.F f2) {
        if (h() != null && i() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("token", str);
            hashMap.put("client_id", h());
            a(Q(), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, hashMap, "application/x-www-form-urlencoded", new C0301e(this, f2));
            return;
        }
        f2.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
    }

    public void a(AdobeAuthIMSEnvironment adobeAuthIMSEnvironment) {
        int i = C0305i.f4890b[adobeAuthIMSEnvironment.ordinal()];
        if (i == 1) {
            this.q = "https://ims-na1-stg1.adobelogin.com";
        } else if (i == 2) {
            this.q = "https://ims-na1-qa1.adobelogin.com";
        } else if (i == 3) {
            this.q = "https://ims-na1-qa2.adobelogin.com";
        } else if (i != 4) {
            this.q = "https://ims-na1.adobelogin.com";
        } else {
            throw new AdobeInvalidIMSHostException();
        }
        this.D = new com.adobe.creativesdk.foundation.internal.net.A(this.q, "Adobe Creative SDK", null);
        this.E = adobeAuthIMSEnvironment;
    }

    void a(String str, Object obj) {
        if (str != null && obj != null) {
            this.f4765d.a(str, obj);
        } else if (str != null) {
            this.f4765d.a(str);
        }
    }

    private void a(URL url, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, Map<String, String> map, String str, com.adobe.creativesdk.foundation.internal.net.F f2) {
        Handler handler;
        com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j(url, adobeNetworkHttpRequestMethod, map);
        if (adobeNetworkHttpRequestMethod == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET && !map.isEmpty()) {
            this.f4767f = this.f4765d.c();
            jVar.b(map);
        }
        if (adobeNetworkHttpRequestMethod == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST) {
            jVar.a(map);
        }
        if (str != null) {
            jVar.b(HttpHeaders.CONTENT_TYPE, str);
        }
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAuthIdentityManagementService.class.getSimpleName(), e2.getMessage(), e2);
            handler = null;
        }
        this.D.a(jVar, AdobeNetworkRequestPriority.NORMAL, f2, handler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.adobe.creativesdk.foundation.internal.utils.k kVar, boolean z) {
        String a2;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AuthIMS", "parseResponse..");
        if (kVar.b("sub")) {
            a2 = kVar.a("sub");
        } else {
            a2 = kVar.a("userId");
        }
        if (TextUtils.isEmpty(a2)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Adobe ID missing : response " + kVar.toString());
        }
        b(a2);
        a(kVar.a("access_token"));
        if (kVar.b("device_token")) {
            l(kVar.a("device_token"));
            w(kVar.a("device_token"));
        }
        if (kVar.b("refresh_token")) {
            v(kVar.a("refresh_token"));
            x(kVar.a("refresh_token"));
        }
        f(kVar.a("continuation_token"));
        String a3 = kVar.a(AccessToken.EXPIRES_IN_KEY);
        if (a3 != null) {
            Long valueOf = Long.valueOf(Long.parseLong(a3) / 1000);
            Calendar calendar = Calendar.getInstance();
            calendar.add(13, valueOf.intValue());
            a(calendar.getTime());
        } else {
            a((Date) null);
        }
        b();
    }

    public void a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        try {
            this.H = L.a(bArr2);
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAuthIdentityManagementService.class.getSimpleName(), e2.getMessage(), e2);
            throw new IllegalArgumentException("CSDK Foundation Auth : Cannot create Cipher Instance !");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, c.a.a.a.b<JSONObject> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        Handler handler;
        com.adobe.creativesdk.foundation.adobeinternal.entitlement.h k = com.adobe.creativesdk.foundation.adobeinternal.entitlement.h.k();
        k.n();
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAuthIdentityManagementService.class.getSimpleName(), e2.getMessage(), e2);
            handler = null;
        }
        k.a(str, new C0303g(this, bVar), new C0304h(this, cVar), handler);
    }
}

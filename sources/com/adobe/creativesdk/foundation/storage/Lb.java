package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXLocalStorageScheme;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0235h;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.share.internal.ShareConstants;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobePSDComposite.java */
/* loaded from: classes.dex */
public class Lb {

    /* renamed from: a, reason: collision with root package name */
    private String f7048a;

    /* renamed from: b, reason: collision with root package name */
    private C0231f f7049b;

    /* renamed from: c, reason: collision with root package name */
    private Nb f7050c;

    /* renamed from: d, reason: collision with root package name */
    private Nb f7051d;

    public Lb(String str, String str2) {
        this.f7048a = str;
        try {
            this.f7049b = C0231f.a((URI) null, (String) null, str2, AdobeDCXLocalStorageScheme.AdobeDCXLocalStorageSchemeCopyOnWrite);
            this.f7049b.a(false);
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePSDComposite.Constructor", e2.getMessage());
        }
        String str3 = this.f7048a;
        if (str3 != null) {
            this.f7049b.d(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(a(str3), true));
        }
        try {
            this.f7049b.a(new URI("assets/psd/" + this.f7049b.n()));
        } catch (URISyntaxException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePSDComposite.Constructor", e3.getMessage());
        }
    }

    private String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePSDComposite.getStringByRemovingPercentEncoding", e2.getMessage());
            return null;
        }
    }

    public Nb b() {
        C0235h p = this.f7049b.p();
        if (p == null) {
            this.f7050c = null;
        } else {
            Nb nb = this.f7050c;
            if (nb == null) {
                this.f7050c = new Nb(p);
            } else {
                nb.a(p);
            }
        }
        return this.f7050c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0231f c() {
        return this.f7049b;
    }

    public String d() {
        JSONObject e2;
        JSONObject jSONObject;
        if (this.f7048a == null && (e2 = this.f7049b.p().e()) != null) {
            try {
                jSONObject = (JSONObject) e2.get(ShareConstants.FEED_SOURCE_PARAM);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                this.f7048a = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null);
            }
        }
        return this.f7048a;
    }

    public Nb e() {
        C0233g A = this.f7049b.A();
        if (A == null) {
            this.f7051d = null;
        } else {
            Nb nb = this.f7051d;
            if (nb == null) {
                this.f7051d = new Nb(A);
            } else {
                nb.a(A);
            }
        }
        return this.f7051d;
    }

    public boolean f() throws AdobeDCXException {
        return this.f7049b.a((C0235h) null);
    }

    public boolean a() throws AdobeDCXException {
        return this.f7049b.a();
    }
}

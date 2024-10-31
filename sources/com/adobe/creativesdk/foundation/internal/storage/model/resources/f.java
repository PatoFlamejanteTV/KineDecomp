package com.adobe.creativesdk.foundation.internal.storage.model.resources;

import com.adobe.creativesdk.foundation.internal.storage.model.util.ParsingDataException;
import com.adobe.creativesdk.foundation.internal.storage.model.util.g;
import com.adobe.creativesdk.foundation.internal.storage.model.util.i;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeStorageResourceItem.java */
/* loaded from: classes.dex */
public class f extends b {
    private byte[] n;
    private String o;
    private String p;
    private String q;
    private JSONObject r;
    private Number s;

    public f() {
        this.n = null;
    }

    public static f a(URI uri) {
        f fVar = new f();
        fVar.f6610b = uri;
        fVar.f6611c = g.a(uri.getPath());
        return fVar;
    }

    public static f b(String str) {
        f fVar = new f();
        try {
            fVar.f6610b = new URI(i.c(str));
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
        fVar.f6611c = g.a(str);
        return fVar;
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        return (str.matches(".*[\\\\:\\*\\?\"\\/<>\\|\\x00-\\x1F]+.*") || str.matches(".*[\\ \\.]$")) ? false : true;
    }

    public void c(String str) {
        this.q = str;
    }

    public byte[] d() {
        return this.n;
    }

    public void e(String str) {
        this.p = str;
    }

    public String g() {
        JSONObject jSONObject = this.j;
        JSONObject jSONObject2 = jSONObject != null ? (JSONObject) jSONObject.opt("metadata") : null;
        if (jSONObject2 != null) {
            return jSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_HREF);
        }
        return null;
    }

    public JSONObject h() {
        return this.r;
    }

    public String i() {
        return this.o;
    }

    public String j() {
        JSONObject jSONObject = this.j;
        JSONObject jSONObject2 = jSONObject != null ? (JSONObject) jSONObject.opt("rendition") : null;
        if (jSONObject2 != null) {
            return jSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_HREF);
        }
        return null;
    }

    public String k() {
        return this.p;
    }

    public void d(String str) {
        this.o = str;
    }

    public Number e() {
        return this.s;
    }

    public f(f fVar) {
        super(fVar);
        this.n = null;
        this.n = fVar.d();
        this.o = fVar.i();
        this.p = fVar.k();
        this.q = fVar.f();
        this.r = fVar.h();
        this.s = fVar.e();
    }

    public String f() {
        return this.q;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static f a(String str, String str2) {
        f fVar = new f();
        fVar.f6612d = str2;
        fVar.o = str;
        return fVar;
    }

    public void b(JSONObject jSONObject) throws ParsingDataException {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.equals("name")) {
                this.f6611c = (String) jSONObject.opt(next);
            } else if (next.equals("type")) {
                this.f6612d = (String) jSONObject.opt(next);
            } else if (next.equals("etag")) {
                this.f6613e = (String) jSONObject.opt(next);
            } else if (next.equals("size")) {
                this.s = (Number) jSONObject.opt(next);
            } else if (next.equals("md5")) {
                this.q = (String) jSONObject.opt(next);
            } else if (next.equals("id")) {
                this.f6609a = (String) jSONObject.opt(next);
            } else if (next.equals("created")) {
                this.f6614f = (String) jSONObject.opt(next);
            } else if (next.equals("modified")) {
                this.f6615g = (String) jSONObject.opt(next);
            } else if (next.equals("ordinal")) {
                this.i = jSONObject.optInt(next);
            } else if (next.equals("_links")) {
                this.j = (JSONObject) jSONObject.opt(next);
            } else {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (jSONObject2.opt(PlaceFields.PAGE) != null) {
            try {
                jSONObject2.put(PlaceFields.PAGE, 1);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (jSONObject2.opt("height") == null) {
            try {
                jSONObject2.put("height", 0);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (jSONObject2.opt("width") == null) {
            try {
                jSONObject2.put("width", 0);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        this.r = jSONObject2;
        if (this.f6611c != null) {
            if (this.f6612d != null) {
                if (this.f6615g == null) {
                    throw new ParsingDataException(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Item doesn't have a modified time."));
                }
                return;
            }
            throw new ParsingDataException(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Item doesn't have a type."));
        }
        throw new ParsingDataException(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Item doesn't have a name."));
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.n = bArr;
        }
    }

    public void a(JSONObject jSONObject) {
        this.r = jSONObject;
    }

    public void a(Number number) {
        this.s = number;
    }
}

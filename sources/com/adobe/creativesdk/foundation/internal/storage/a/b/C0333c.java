package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.facebook.share.internal.ShareConstants;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;

/* compiled from: AdobeStorageDCXServiceMapping.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0333c {
    public static com.adobe.creativesdk.foundation.internal.storage.model.resources.f a(C0231f c0231f) {
        if (c0231f.r() == null) {
            return null;
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(c0231f.r());
        a2.f6612d = "application/vnd.adobe.directory+json";
        Fa w = c0231f.w();
        if (w != null) {
            a2.f6611c = w.h();
        } else {
            a2.f6611c = org.apache.commons.io.c.e(c0231f.r().toString());
        }
        a2.i = c0231f.y();
        a2.k = c0231f.m();
        a2.l = c0231f.l();
        return a2;
    }

    public static com.adobe.creativesdk.foundation.internal.storage.model.resources.f a(Fa fa, C0231f c0231f) {
        String str;
        if (c0231f.H()) {
            JSONObject optJSONObject = c0231f.s().optJSONObject("http://ns.adobe.com/ccapi/manifest");
            str = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(optJSONObject != null ? optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null) : null, new com.adobe.creativesdk.foundation.internal.storage.model.resources.a());
        } else {
            str = null;
        }
        if (str == null) {
            str = Za.c(c0231f.r().toString(), "manifest");
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar = new com.adobe.creativesdk.foundation.internal.storage.model.resources.f();
        fVar.f6612d = "application/vnd.adobe.dcx-manifest+json";
        try {
            fVar.f6610b = new URI(str);
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
        fVar.f6613e = fa != null ? fa.l() : null;
        return fVar;
    }

    public static com.adobe.creativesdk.foundation.internal.storage.model.resources.f a(C0225c c0225c, String str, JSONObject jSONObject, String str2, boolean z) {
        if (c0225c == null) {
            return null;
        }
        if (c0225c.b() != null && (str != null || jSONObject != null)) {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("http://ns.adobe.com/ccapi/component");
                r0 = optJSONObject != null ? optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null) : null;
                if (r0 != null) {
                    r0 = r0.replace("{component_id}", c0225c.b());
                }
            }
            if (r0 == null) {
                r0 = Za.c(str, c0225c.b());
            }
            if (z) {
                com.adobe.creativesdk.foundation.internal.storage.model.resources.a aVar = new com.adobe.creativesdk.foundation.internal.storage.model.resources.a();
                String o = c0225c.o();
                if (o == null) {
                    o = "(null)";
                }
                aVar.c(o);
                r0 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(r0, aVar);
            }
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar = new com.adobe.creativesdk.foundation.internal.storage.model.resources.f();
        fVar.f6611c = c0225c.b();
        fVar.f6612d = c0225c.n();
        if (r0 != null) {
            try {
                fVar.f6610b = new URI(r0);
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
        fVar.f6613e = c0225c.d();
        fVar.c(c0225c.h());
        fVar.a(Long.valueOf(c0225c.f()));
        fVar.e(c0225c.o());
        fVar.d(str2);
        return fVar;
    }

    public static com.adobe.creativesdk.foundation.internal.storage.model.resources.f a(C0225c c0225c, C0231f c0231f, String str, boolean z) {
        return a(c0225c, c0231f.r().toString(), c0231f.s(), str, z);
    }
}

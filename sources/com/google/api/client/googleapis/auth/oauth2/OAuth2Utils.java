package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.util.Beta;
import java.nio.charset.Charset;
import java.util.logging.Logger;

@Beta
/* loaded from: classes2.dex */
public class OAuth2Utils {

    /* renamed from: a */
    static final Charset f14652a = Charset.forName("UTF-8");

    /* renamed from: b */
    private static final Logger f14653b = Logger.getLogger(OAuth2Utils.class.getName());

    public static String a() {
        return a(a.f14654a);
    }

    static String a(a aVar) {
        String a2 = aVar.a("GCE_METADATA_HOST");
        if (a2 == null) {
            return "http://169.254.169.254";
        }
        return "http://" + a2;
    }
}

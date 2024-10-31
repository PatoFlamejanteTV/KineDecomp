package com.google.api.client.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class BearerToken {

    /* renamed from: a, reason: collision with root package name */
    static final Pattern f14592a = Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");

    /* loaded from: classes2.dex */
    static final class a implements Credential.AccessMethod {
        a() {
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public void a(HttpRequest httpRequest, String str) throws IOException {
            httpRequest.e().b("Bearer " + str);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public String a(HttpRequest httpRequest) {
            List<String> b2 = httpRequest.e().b();
            if (b2 == null) {
                return null;
            }
            for (String str : b2) {
                if (str.startsWith("Bearer ")) {
                    return str.substring(7);
                }
            }
            return null;
        }
    }

    public static Credential.AccessMethod a() {
        return new a();
    }
}

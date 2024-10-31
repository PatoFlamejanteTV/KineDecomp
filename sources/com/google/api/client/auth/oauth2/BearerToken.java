package com.google.api.client.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class BearerToken {

    /* renamed from: a */
    static final Pattern f2408a = Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements Credential.AccessMethod {
        a() {
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public void a(HttpRequest httpRequest, String str) throws IOException {
            HttpHeaders g = httpRequest.g();
            String valueOf = String.valueOf("Bearer ");
            String valueOf2 = String.valueOf(str);
            g.b(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public String a(HttpRequest httpRequest) {
            List<String> b = httpRequest.g().b();
            if (b != null) {
                for (String str : b) {
                    if (str.startsWith("Bearer ")) {
                        return str.substring("Bearer ".length());
                    }
                }
            }
            return null;
        }
    }

    public static Credential.AccessMethod a() {
        return new a();
    }
}

package com.google.api.client.googleapis.compute;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class ComputeCredential extends Credential {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.auth.oauth2.Credential
    public TokenResponse k() throws IOException {
        HttpRequest a2 = c().createRequestFactory().a(new GenericUrl(e()));
        a2.a(new JsonObjectParser(d()));
        a2.g().set("X-Google-Metadata-Request", (Object) true);
        return (TokenResponse) a2.p().a(TokenResponse.class);
    }

    @Beta
    /* loaded from: classes.dex */
    public static class Builder extends Credential.Builder {
        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder a(String str) {
            return (Builder) super.a((String) Preconditions.a(str));
        }
    }
}

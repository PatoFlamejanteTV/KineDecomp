package com.google.api.client.googleapis.compute;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public class ComputeCredential extends Credential {
    public static final String n = OAuth2Utils.a() + "/computeMetadata/v1/instance/service-accounts/default/token";

    @Beta
    /* loaded from: classes2.dex */
    public static class Builder extends Credential.Builder {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.auth.oauth2.Credential
    public TokenResponse a() throws IOException {
        HttpRequest a2 = j().createRequestFactory().a(new GenericUrl(i()));
        a2.a(new JsonObjectParser(g()));
        a2.e().set("Metadata-Flavor", "Google");
        return (TokenResponse) a2.a().a(TokenResponse.class);
    }
}

package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpResponseException;

/* loaded from: classes.dex */
public class TokenResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4020689092957439244L;

    /* renamed from: a */
    private final transient TokenErrorResponse f2415a;

    TokenResponseException(HttpResponseException.Builder builder, TokenErrorResponse tokenErrorResponse) {
        super(builder);
        this.f2415a = tokenErrorResponse;
    }

    public final TokenErrorResponse getDetails() {
        return this.f2415a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.api.client.auth.oauth2.TokenErrorResponse] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.api.client.auth.oauth2.TokenResponseException from(com.google.api.client.json.JsonFactory r7, com.google.api.client.http.HttpResponse r8) {
        /*
            r1 = 0
            com.google.api.client.http.HttpResponseException$Builder r3 = new com.google.api.client.http.HttpResponseException$Builder
            int r0 = r8.d()
            java.lang.String r2 = r8.e()
            com.google.api.client.http.HttpHeaders r4 = r8.b()
            r3.<init>(r0, r2, r4)
            com.google.api.client.util.Preconditions.a(r7)
            java.lang.String r0 = r8.a()
            boolean r2 = r8.c()     // Catch: java.io.IOException -> L73
            if (r2 != 0) goto L6e
            if (r0 == 0) goto L6e
            java.io.InputStream r2 = r8.g()     // Catch: java.io.IOException -> L73
            if (r2 == 0) goto L6e
            java.lang.String r2 = "application/json; charset=UTF-8"
            boolean r0 = com.google.api.client.http.HttpMediaType.b(r2, r0)     // Catch: java.io.IOException -> L73
            if (r0 == 0) goto L6e
            com.google.api.client.json.JsonObjectParser r0 = new com.google.api.client.json.JsonObjectParser     // Catch: java.io.IOException -> L73
            r0.<init>(r7)     // Catch: java.io.IOException -> L73
            java.io.InputStream r2 = r8.g()     // Catch: java.io.IOException -> L73
            java.nio.charset.Charset r4 = r8.k()     // Catch: java.io.IOException -> L73
            java.lang.Class<com.google.api.client.auth.oauth2.TokenErrorResponse> r5 = com.google.api.client.auth.oauth2.TokenErrorResponse.class
            java.lang.Object r0 = r0.a(r2, r4, r5)     // Catch: java.io.IOException -> L73
            com.google.api.client.auth.oauth2.TokenErrorResponse r0 = (com.google.api.client.auth.oauth2.TokenErrorResponse) r0     // Catch: java.io.IOException -> L73
            java.lang.String r1 = r0.toPrettyString()     // Catch: java.io.IOException -> L7d
            r6 = r1
            r1 = r0
            r0 = r6
        L4b:
            java.lang.StringBuilder r2 = com.google.api.client.http.HttpResponseException.computeMessageBuffer(r8)
            boolean r4 = com.google.api.client.util.Strings.a(r0)
            if (r4 != 0) goto L61
            java.lang.String r4 = com.google.api.client.util.StringUtils.f2548a
            java.lang.StringBuilder r4 = r2.append(r4)
            r4.append(r0)
            r3.c(r0)
        L61:
            java.lang.String r0 = r2.toString()
            r3.a(r0)
            com.google.api.client.auth.oauth2.TokenResponseException r0 = new com.google.api.client.auth.oauth2.TokenResponseException
            r0.<init>(r3, r1)
            return r0
        L6e:
            java.lang.String r0 = r8.j()     // Catch: java.io.IOException -> L73
            goto L4b
        L73:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L76:
            r2.printStackTrace()
            r6 = r1
            r1 = r0
            r0 = r6
            goto L4b
        L7d:
            r2 = move-exception
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.auth.oauth2.TokenResponseException.from(com.google.api.client.json.JsonFactory, com.google.api.client.http.HttpResponse):com.google.api.client.auth.oauth2.TokenResponseException");
    }
}

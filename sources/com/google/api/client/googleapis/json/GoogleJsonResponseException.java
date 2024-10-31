package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

/* loaded from: classes.dex */
public class GoogleJsonResponseException extends HttpResponseException {
    private static final long serialVersionUID = 409811126989994864L;

    /* renamed from: a */
    private final transient GoogleJsonError f2436a;

    GoogleJsonResponseException(HttpResponseException.Builder builder, GoogleJsonError googleJsonError) {
        super(builder);
        this.f2436a = googleJsonError;
    }

    public final GoogleJsonError getDetails() {
        return this.f2436a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[Catch: IOException -> 0x008b, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x008b, blocks: (B:24:0x005f, B:34:0x0087), top: B:22:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ae A[Catch: IOException -> 0x00b2, TRY_ENTER, TryCatch #4 {IOException -> 0x00b2, blocks: (B:56:0x00ae, B:57:0x00b1, B:60:0x00ba), top: B:54:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v39, types: [com.google.api.client.googleapis.json.GoogleJsonError] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.api.client.http.HttpResponseException$Builder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.api.client.googleapis.json.GoogleJsonResponseException from(com.google.api.client.json.JsonFactory r6, com.google.api.client.http.HttpResponse r7) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.json.GoogleJsonResponseException.from(com.google.api.client.json.JsonFactory, com.google.api.client.http.HttpResponse):com.google.api.client.googleapis.json.GoogleJsonResponseException");
    }

    public static HttpResponse execute(JsonFactory jsonFactory, HttpRequest httpRequest) throws GoogleJsonResponseException, IOException {
        Preconditions.a(jsonFactory);
        boolean o = httpRequest.o();
        if (o) {
            httpRequest.a(false);
        }
        HttpResponse p = httpRequest.p();
        httpRequest.a(o);
        if (!o || p.c()) {
            return p;
        }
        throw from(jsonFactory, p);
    }
}

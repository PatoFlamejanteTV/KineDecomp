package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class AbstractGoogleJsonClientRequest<T> extends AbstractGoogleClientRequest<T> {
    private final Object jsonContent;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AbstractGoogleJsonClientRequest(com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient r7, java.lang.String r8, java.lang.String r9, java.lang.Object r10, java.lang.Class<T> r11) {
        /*
            r6 = this;
            r0 = 0
            if (r10 != 0) goto Lf
            r4 = r0
        L4:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r6.jsonContent = r10
            return
        Lf:
            com.google.api.client.http.json.JsonHttpContent r1 = new com.google.api.client.http.json.JsonHttpContent
            com.google.api.client.json.JsonFactory r2 = r7.getJsonFactory()
            r1.<init>(r2, r10)
            com.google.api.client.json.JsonObjectParser r2 = r7.getObjectParser()
            java.util.Set r2 = r2.b()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L2b
        L26:
            com.google.api.client.http.json.JsonHttpContent r4 = r1.a(r0)
            goto L4
        L2b:
            java.lang.String r0 = "data"
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest.<init>(com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient, java.lang.String, java.lang.String, java.lang.Object, java.lang.Class):void");
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public AbstractGoogleJsonClient getAbstractGoogleClient() {
        return (AbstractGoogleJsonClient) super.getAbstractGoogleClient();
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public AbstractGoogleJsonClientRequest<T> setDisableGZipContent(boolean z) {
        return (AbstractGoogleJsonClientRequest) super.setDisableGZipContent(z);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public AbstractGoogleJsonClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (AbstractGoogleJsonClientRequest) super.setRequestHeaders(httpHeaders);
    }

    public final void queue(BatchRequest batchRequest, JsonBatchCallback<T> jsonBatchCallback) throws IOException {
        super.queue(batchRequest, GoogleJsonErrorContainer.class, jsonBatchCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public GoogleJsonResponseException newExceptionOnError(HttpResponse httpResponse) {
        return GoogleJsonResponseException.from(getAbstractGoogleClient().getJsonFactory(), httpResponse);
    }

    public Object getJsonContent() {
        return this.jsonContent;
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public AbstractGoogleJsonClientRequest<T> set(String str, Object obj) {
        return (AbstractGoogleJsonClientRequest) super.set(str, obj);
    }
}

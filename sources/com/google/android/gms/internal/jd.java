package com.google.android.gms.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: classes.dex */
class jd implements zzrf {

    /* renamed from: a, reason: collision with root package name */
    private HttpClient f1644a;

    private InputStream a(HttpClient httpClient, HttpResponse httpResponse) throws IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            com.google.android.gms.tagmanager.zzbg.d("Success response");
            return httpResponse.getEntity().getContent();
        }
        String str = "Bad response: " + statusCode;
        if (statusCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    private void a(HttpClient httpClient) {
        if (httpClient == null || httpClient.getConnectionManager() == null) {
            return;
        }
        httpClient.getConnectionManager().shutdown();
    }

    HttpClient a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        return new DefaultHttpClient(basicHttpParams);
    }

    @Override // com.google.android.gms.internal.zzrf
    public void close() {
        a(this.f1644a);
    }

    @Override // com.google.android.gms.internal.zzrf
    public InputStream zzft(String str) throws IOException {
        this.f1644a = a();
        return a(this.f1644a, this.f1644a.execute(new HttpGet(str)));
    }
}

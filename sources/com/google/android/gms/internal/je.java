package com.google.android.gms.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
class je implements zzrf {

    /* renamed from: a, reason: collision with root package name */
    private HttpURLConnection f1645a;

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    private void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    HttpURLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }

    @Override // com.google.android.gms.internal.zzrf
    public void close() {
        b(this.f1645a);
    }

    @Override // com.google.android.gms.internal.zzrf
    public InputStream zzft(String str) throws IOException {
        this.f1645a = a(str);
        return a(this.f1645a);
    }
}

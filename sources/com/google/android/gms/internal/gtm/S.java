package com.google.android.gms.internal.gtm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
final class S implements zzpc {

    /* renamed from: a */
    private HttpURLConnection f13177a;

    /* renamed from: b */
    private InputStream f13178b = null;

    @Override // com.google.android.gms.internal.gtm.zzpc
    public final void close() {
        HttpURLConnection httpURLConnection = this.f13177a;
        try {
            if (this.f13178b != null) {
                this.f13178b.close();
            }
        } catch (IOException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            com.google.android.gms.tagmanager.zzdi.a(valueOf.length() != 0 ? "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf) : new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "), e2);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzpc
    public final InputStream zzcj(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.f13177a = httpURLConnection;
        HttpURLConnection httpURLConnection2 = this.f13177a;
        int responseCode = httpURLConnection2.getResponseCode();
        if (responseCode == 200) {
            this.f13178b = httpURLConnection2.getInputStream();
            return this.f13178b;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Bad response: ");
        sb.append(responseCode);
        String sb2 = sb.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(sb2);
        }
        if (responseCode == 503) {
            throw new zzpe(sb2);
        }
        throw new IOException(sb2);
    }
}

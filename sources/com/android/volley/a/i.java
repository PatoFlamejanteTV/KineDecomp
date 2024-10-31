package com.android.volley.a;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HurlStack.java */
/* loaded from: classes.dex */
public class i extends com.android.volley.a.a {

    /* renamed from: a */
    private final a f8016a;

    /* renamed from: b */
    private final SSLSocketFactory f8017b;

    /* compiled from: HurlStack.java */
    /* loaded from: classes.dex */
    public interface a {
        String a(String str);
    }

    public i() {
        this(null);
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    private static void b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] a2 = request.a();
        if (a2 != null) {
            a(httpURLConnection, request, a2);
        }
    }

    @Override // com.android.volley.a.a
    public g a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String str;
        String q = request.q();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.g());
        hashMap.putAll(map);
        a aVar = this.f8016a;
        if (aVar != null) {
            str = aVar.a(q);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + q);
            }
        } else {
            str = q;
        }
        HttpURLConnection a2 = a(new URL(str), request);
        for (String str2 : hashMap.keySet()) {
            a2.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        a(a2, request);
        int responseCode = a2.getResponseCode();
        if (responseCode != -1) {
            if (!a(request.h(), responseCode)) {
                return new g(responseCode, a(a2.getHeaderFields()));
            }
            return new g(responseCode, a(a2.getHeaderFields()), a2.getContentLength(), a(a2));
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    public i(a aVar) {
        this(aVar, null);
    }

    public i(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f8016a = aVar;
        this.f8017b = sSLSocketFactory;
    }

    static List<com.android.volley.g> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.android.volley.g(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    private HttpURLConnection a(URL url, Request<?> request) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection a2 = a(url);
        int o = request.o();
        a2.setConnectTimeout(o);
        a2.setReadTimeout(o);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f8017b) != null) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(sSLSocketFactory);
        }
        return a2;
    }

    static void a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        switch (request.h()) {
            case -1:
                byte[] k = request.k();
                if (k != null) {
                    httpURLConnection.setRequestMethod("POST");
                    a(httpURLConnection, request, k);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException, AuthFailureError {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, request.d());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}

package com.bumptech.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class k implements d<InputStream> {

    /* renamed from: a */
    static final b f8561a = new a();

    /* renamed from: b */
    private final com.bumptech.glide.load.b.l f8562b;

    /* renamed from: c */
    private final int f8563c;

    /* renamed from: d */
    private final b f8564d;

    /* renamed from: e */
    private HttpURLConnection f8565e;

    /* renamed from: f */
    private InputStream f8566f;

    /* renamed from: g */
    private volatile boolean f8567g;

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.a.k.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public k(com.bumptech.glide.load.b.l lVar, int i) {
        this(lVar, i, f8561a);
    }

    private static boolean b(int i) {
        return i / 100 == 3;
    }

    @Override // com.bumptech.glide.load.a.d
    public void a(Priority priority, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long a2 = com.bumptech.glide.g.h.a();
        try {
            try {
                aVar.a((d.a<? super InputStream>) a(this.f8562b.c(), 0, null, this.f8562b.b()));
            } catch (IOException e2) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
                }
                aVar.a((Exception) e2);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.g.h.a(a2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.g.h.a(a2));
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public DataSource c() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.a.d
    public void cancel() {
        this.f8567g = true;
    }

    k(com.bumptech.glide.load.b.l lVar, int i, b bVar) {
        this.f8562b = lVar;
        this.f8563c = i;
        this.f8564d = bVar;
    }

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        InputStream inputStream = this.f8566f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f8565e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f8565e = null;
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f8565e = this.f8564d.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f8565e.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f8565e.setConnectTimeout(this.f8563c);
            this.f8565e.setReadTimeout(this.f8563c);
            this.f8565e.setUseCaches(false);
            this.f8565e.setDoInput(true);
            this.f8565e.setInstanceFollowRedirects(false);
            this.f8565e.connect();
            this.f8566f = this.f8565e.getInputStream();
            if (this.f8567g) {
                return null;
            }
            int responseCode = this.f8565e.getResponseCode();
            if (a(responseCode)) {
                return a(this.f8565e);
            }
            if (!b(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.f8565e.getResponseMessage(), responseCode);
            }
            String headerField = this.f8565e.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                b();
                return a(url3, i + 1, url, map);
            }
            throw new HttpException("Received empty or null redirect url");
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    private static boolean a(int i) {
        return i / 100 == 2;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f8566f = com.bumptech.glide.g.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f8566f = httpURLConnection.getInputStream();
        }
        return this.f8566f;
    }

    @Override // com.bumptech.glide.load.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}

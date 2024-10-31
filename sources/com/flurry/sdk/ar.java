package com.flurry.sdk;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.HttpParams;

/* loaded from: classes.dex */
public final class ar {

    /* renamed from: a, reason: collision with root package name */
    private static SchemeRegistry f466a;

    private static synchronized SchemeRegistry a() {
        SchemeRegistry schemeRegistry;
        synchronized (ar.class) {
            if (f466a != null) {
                schemeRegistry = f466a;
            } else {
                f466a = new SchemeRegistry();
                f466a.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                f466a.register(new Scheme("https", new ap(), 443));
                schemeRegistry = f466a;
            }
        }
        return schemeRegistry;
    }

    public static HttpClient a(HttpParams httpParams) {
        return new DefaultHttpClient(new SingleClientConnManager(httpParams, a()), httpParams);
    }
}

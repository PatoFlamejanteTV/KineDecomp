package com.adobe.creativesdk.foundation.internal.net;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpTask.java */
/* loaded from: classes.dex */
public abstract class C implements Callable<l> {

    /* renamed from: a */
    private static final String f5073a = "C";

    /* renamed from: b */
    protected static double[] f5074b = {0.1d, 1.0d, 2.0d};

    /* renamed from: c */
    protected m f5075c = null;

    /* renamed from: d */
    protected E f5076d = null;

    /* renamed from: e */
    protected String f5077e = null;

    /* renamed from: f */
    protected HttpURLConnection f5078f = null;

    /* renamed from: g */
    protected j f5079g = null;

    /* renamed from: h */
    protected int f5080h = -1;
    protected boolean i = true;
    l j = null;

    public void a(j jVar, String str, m mVar, E e2) {
        this.f5079g = jVar;
        this.f5075c = mVar;
        this.f5076d = e2;
        this.f5077e = str;
        this.f5078f = null;
        this.f5080h = -1;
        this.j = null;
    }

    protected abstract void b();

    protected boolean b(l lVar) {
        if (lVar == null || !this.i) {
            return false;
        }
        int g2 = lVar.g();
        this.f5080h++;
        if (g2 <= 499 || g2 >= 600 || g2 == 507) {
            return false;
        }
        int i = this.f5080h;
        double[] dArr = f5074b;
        if (i >= dArr.length) {
            return false;
        }
        try {
            long j = (long) (dArr[i] * 1000.0d);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, f5073a, "retry #" + this.f5080h + " sleep ..." + j);
            Thread.sleep(j);
        } catch (InterruptedException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "NetworkService", "Retry connection for" + this.f5078f.toString(), e2);
        }
        return true;
    }

    protected void c() {
        if (!TextUtils.isEmpty(this.f5077e)) {
            this.f5078f.setRequestProperty("Authorization", "Bearer " + this.f5077e);
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, f5073a, "access token empty");
    }

    protected void d() {
        if (TextUtils.isEmpty(c.a.a.a.a.c())) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, f5073a, "client ID empty");
        }
        this.f5078f.setRequestProperty("X-IMS-ClientId", c.a.a.a.a.c());
    }

    protected boolean e() {
        OutputStream outputStream = null;
        try {
            try {
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C.class.getName(), "Error during io operation", e2);
            }
            if (this.f5079g.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST) {
                this.f5078f.setDoOutput(true);
                Uri.Builder builder = new Uri.Builder();
                if (this.f5079g.c() != null) {
                    for (Map.Entry<String, String> entry : this.f5079g.c().entrySet()) {
                        builder.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                }
                String uri = builder.build().toString();
                if (!uri.isEmpty()) {
                    uri = uri.substring(1);
                }
                if (!uri.isEmpty() || this.f5079g.b() != null) {
                    outputStream = this.f5078f.getOutputStream();
                    if (!uri.isEmpty()) {
                        outputStream.write(uri.getBytes("UTF-8"));
                    }
                    InputStream b2 = this.f5079g.b();
                    if (b2 != null && b2.available() > 0) {
                        int available = b2.available();
                        byte[] bArr = new byte[32768];
                        int read = b2.read(bArr, 0, 32768);
                        int i = 0;
                        while (read > 0) {
                            if (this.f5076d.c()) {
                                this.f5079g.a();
                                return false;
                            }
                            outputStream.write(bArr, 0, read);
                            outputStream.flush();
                            i += read;
                            read = b2.read(bArr, 0, 32768);
                            a(Integer.valueOf((int) ((i / available) * 100.0f)));
                        }
                        this.j.b(i);
                        this.f5079g.a();
                    }
                }
                return true;
            }
            if (this.f5079g.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT) {
                if (this.f5079g.b() != null) {
                    this.f5078f.setDoOutput(true);
                    outputStream = this.f5078f.getOutputStream();
                    InputStream b3 = this.f5079g.b();
                    byte[] bArr2 = new byte[32768];
                    for (int read2 = b3.read(bArr2, 0, 32768); read2 > 0; read2 = b3.read(bArr2, 0, 32768)) {
                        outputStream.write(bArr2, 0, read2);
                    }
                    outputStream.flush();
                    this.f5079g.a();
                }
                return true;
            }
            return false;
        } finally {
            org.apache.commons.io.d.a((OutputStream) null);
        }
    }

    @Override // java.util.concurrent.Callable
    public l call() {
        this.f5076d.a(true);
        if (!this.f5076d.c()) {
            this.j = new l();
            do {
                this.f5078f = null;
                this.j.c(404);
                try {
                    this.f5078f = (HttpURLConnection) a(this.f5079g);
                    this.j.a(this.f5079g.g());
                    a();
                    if (this.f5078f == null) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f5073a, "error : url connection null");
                        return null;
                    }
                    c();
                    d();
                    boolean e2 = e();
                    boolean c2 = this.f5076d.c();
                    if (!c2 || e2) {
                        try {
                            this.j.c(this.f5078f.getResponseCode());
                            d(this.j);
                            b();
                            c2 = this.f5076d.c();
                        } catch (IOException e3) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e3);
                            if (!(e3 instanceof SSLException) && !(e3 instanceof UnknownHostException)) {
                                this.j.c(404);
                            } else {
                                this.j.c(600);
                            }
                            this.j.a(e3);
                        }
                    }
                    this.f5078f.disconnect();
                    this.f5078f = null;
                    if (c2 && !e2) {
                        this.j = null;
                    }
                } catch (IOException e4) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error opening url connection", e4);
                    return null;
                }
            } while (b(this.j));
        }
        c(this.j);
        return this.j;
    }

    protected void c(l lVar) {
        m mVar = this.f5075c;
        if (mVar != null) {
            mVar.a(lVar);
        }
    }

    protected void d(l lVar) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : this.f5078f.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < value.size(); i++) {
                arrayList.add(a(value.get(i)));
            }
            hashMap.put(key, arrayList);
        }
        lVar.a(hashMap);
    }

    public void a(l lVar) {
        int g2 = lVar.g();
        if (g2 >= 200 && g2 < 299) {
            try {
                InputStream inputStream = this.f5078f.getInputStream();
                if (inputStream != null) {
                    byte[] bArr = new byte[32768];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(32768);
                    int read = inputStream.read(bArr, 0, 32768);
                    int i = 0;
                    while (read > 0) {
                        if (this.f5076d.c()) {
                            org.apache.commons.io.d.a(inputStream);
                            org.apache.commons.io.d.a((OutputStream) byteArrayOutputStream);
                            return;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        byteArrayOutputStream.flush();
                        i += read;
                        read = inputStream.read(bArr, 0, 32768);
                        if (this.f5078f.getContentLength() > 0) {
                            a(Integer.valueOf((int) ((i / this.f5078f.getContentLength()) * 100.0f)));
                        }
                    }
                    lVar.a(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return;
                }
                return;
            } catch (IOException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", "Error during io operation", e2);
                return;
            }
        }
        try {
            InputStream errorStream = this.f5078f.getErrorStream();
            if (errorStream != null) {
                lVar.a(ByteBuffer.wrap(org.apache.commons.io.d.b(errorStream)));
                errorStream.close();
            }
        } catch (IOException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", "Error during io operation", e3);
        }
    }

    public void a(Integer num) {
        this.f5076d.a(num.intValue());
    }

    protected URLConnection a(j jVar) throws IOException {
        URL g2 = jVar.g();
        if (jVar.h() && jVar.e() != AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST && jVar.e() != AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT) {
            jVar.a("client_id", c.a.a.a.a.c());
        }
        String d2 = jVar.d();
        if (d2 != null && !d2.isEmpty()) {
            if (jVar.g().toString().contains("?")) {
                g2 = new URL(jVar.g() + "&" + jVar.d());
            } else {
                g2 = new URL(jVar.g() + "?" + jVar.d());
            }
        }
        URLConnection openConnection = g2.openConnection();
        a(jVar, openConnection);
        return openConnection;
    }

    protected void a(j jVar, URLConnection uRLConnection) {
        for (Map.Entry<String, String> entry : jVar.f().entrySet()) {
            uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (c.a.a.a.a.a() != null && !"".equals(c.a.a.a.a.a())) {
            a(uRLConnection);
        }
        uRLConnection.setRequestProperty("Connection", "close");
    }

    private void a(URLConnection uRLConnection) {
        uRLConnection.setRequestProperty(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, c.a.a.a.a.a() + "(" + c.a.a.a.a.b() + ";" + Build.MANUFACTURER + ";" + Build.MODEL + ";Android;" + Build.VERSION.RELEASE + ")");
    }

    private String a(String str) {
        if (str == null || !str.startsWith("=?") || !str.endsWith("?=")) {
            return str;
        }
        String[] split = str.split("\\?");
        if (split.length < 4) {
            return str;
        }
        String str2 = split[3];
        String str3 = split[2];
        if (!split[1].startsWith("utf-8")) {
            return str;
        }
        if (str3.startsWith("b")) {
            return new String(Base64.decode(str2, 0), org.apache.commons.io.a.f29306f);
        }
        return str3.startsWith("q") ? new String(str2.getBytes(org.apache.commons.io.a.f29306f), org.apache.commons.io.a.f29306f) : str;
    }

    protected void a() {
        try {
            int i = B.f5072a[this.f5079g.e().ordinal()];
            if (i == 1) {
                this.f5078f.setRequestMethod("GET");
            } else if (i == 2) {
                this.f5078f.setRequestMethod("DELETE");
            } else if (i == 3) {
                this.f5078f.setRequestMethod("HEAD");
            } else if (i == 4) {
                this.f5078f.setRequestMethod("POST");
            } else if (i == 5) {
                this.f5078f.setRequestMethod("PUT");
            }
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", "Error while setting Http request method.", e2);
        }
    }
}

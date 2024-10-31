package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends zzd {
    private static final byte[] c = "\n".getBytes();

    /* renamed from: a, reason: collision with root package name */
    private final String f700a;
    private final d b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private int b;
        private ByteArrayOutputStream c = new ByteArrayOutputStream();

        public a() {
        }

        public int a() {
            return this.b;
        }

        public boolean a(zzab zzabVar) {
            com.google.android.gms.common.internal.zzx.a(zzabVar);
            if (this.b + 1 > c.this.q().m()) {
                return false;
            }
            String a2 = c.this.a(zzabVar, false);
            if (a2 == null) {
                c.this.p().a(zzabVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = a2.getBytes();
            int length = bytes.length;
            if (length > c.this.q().e()) {
                c.this.p().a(zzabVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.c.size() > 0) {
                length++;
            }
            if (length + this.c.size() > c.this.q().g()) {
                return false;
            }
            try {
                if (this.c.size() > 0) {
                    this.c.write(c.c);
                }
                this.c.write(bytes);
                this.b++;
                return true;
            } catch (IOException e) {
                c.this.e("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public byte[] b() {
            return this.c.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzf zzfVar) {
        super(zzfVar);
        this.f700a = a("GoogleAnalytics", zze.f740a, Build.VERSION.RELEASE, zzam.a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.b = new d(zzfVar.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(java.net.URL r6, byte[] r7) {
        /*
            r5 = this;
            r1 = 0
            com.google.android.gms.common.internal.zzx.a(r6)
            com.google.android.gms.common.internal.zzx.a(r7)
            java.lang.String r0 = "POST bytes, url"
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.b(r0, r2, r6)
            boolean r0 = r5.B()
            if (r0 == 0) goto L21
            java.lang.String r0 = "Post payload\n"
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            r5.a(r0, r2)
        L21:
            java.net.HttpURLConnection r2 = r5.a(r6)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L7e
            r0 = 1
            r2.setDoOutput(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            int r0 = r7.length     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r2.setFixedLengthStreamingMode(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r2.connect()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r1.write(r7)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r5.a(r2)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            int r0 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L49
            com.google.android.gms.analytics.internal.zzb r3 = r5.t()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r3.h()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
        L49:
            java.lang.String r3 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r5.b(r3, r4)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L5d
        L57:
            if (r2 == 0) goto L5c
            r2.disconnect()
        L5c:
            return r0
        L5d:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.e(r3, r1)
            goto L57
        L64:
            r0 = move-exception
            r2 = r1
        L66:
            java.lang.String r3 = "Network POST connection error"
            r5.d(r3, r0)     // Catch: java.lang.Throwable -> L92
            r0 = 0
            if (r1 == 0) goto L71
            r1.close()     // Catch: java.io.IOException -> L77
        L71:
            if (r2 == 0) goto L5c
            r2.disconnect()
            goto L5c
        L77:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.e(r3, r1)
            goto L71
        L7e:
            r0 = move-exception
            r2 = r1
        L80:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.io.IOException -> L8b
        L85:
            if (r2 == 0) goto L8a
            r2.disconnect()
        L8a:
            throw r0
        L8b:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.e(r3, r1)
            goto L85
        L92:
            r0 = move-exception
            goto L80
        L94:
            r0 = move-exception
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.c.a(java.net.URL, byte[]):int");
    }

    private static String a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private URL a(zzab zzabVar, String str) {
        try {
            return new URL(zzabVar.f() ? q().o() + q().q() + "?" + str : q().p() + q().q() + "?" + str);
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void a(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, Keyczar.DEFAULT_ENCODING));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, Keyczar.DEFAULT_ENCODING));
    }

    private void a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    private boolean a(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.a(zzabVar);
        String a2 = a(zzabVar, !zzabVar.f());
        if (a2 == null) {
            p().a(zzabVar, "Error formatting hit for upload");
            return true;
        }
        if (a2.length() <= q().d()) {
            URL a3 = a(zzabVar, a2);
            if (a3 != null) {
                return b(a3) == 200;
            }
            f("Failed to build collect GET endpoint url");
            return false;
        }
        String a4 = a(zzabVar, false);
        if (a4 == null) {
            p().a(zzabVar, "Error formatting hit for POST upload");
            return true;
        }
        byte[] bytes = a4.getBytes();
        if (bytes.length > q().f()) {
            p().a(zzabVar, "Hit payload exceeds size limit");
            return true;
        }
        URL b = b(zzabVar);
        if (b != null) {
            return a(b, bytes) == 200;
        }
        f("Failed to build collect POST endpoint url");
        return false;
    }

    private static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private int b(URL url) {
        int i;
        com.google.android.gms.common.internal.zzx.a(url);
        b("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = a(url);
                httpURLConnection.connect();
                a(httpURLConnection);
                i = httpURLConnection.getResponseCode();
                if (i == 200) {
                    t().h();
                }
                b("GET status", Integer.valueOf(i));
            } catch (IOException e) {
                d("Network GET connection error", e);
                i = 0;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
            return i;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(java.net.URL r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.c.b(java.net.URL, byte[]):int");
    }

    private URL b(zzab zzabVar) {
        try {
            return new URL(zzabVar.f() ? q().o() + q().q() : q().p() + q().q());
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String c(zzab zzabVar) {
        return String.valueOf(zzabVar.c());
    }

    private URL d() {
        try {
            return new URL(q().o() + q().r());
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String a(zzab zzabVar, boolean z) {
        com.google.android.gms.common.internal.zzx.a(zzabVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzabVar.b().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    a(sb, key, entry.getValue());
                }
            }
            a(sb, "ht", String.valueOf(zzabVar.d()));
            a(sb, "qt", String.valueOf(n().currentTimeMillis() - zzabVar.d()));
            if (q().a()) {
                a(sb, "_gmsv", zze.f740a);
            }
            if (z) {
                long g = zzabVar.g();
                a(sb, "z", g != 0 ? String.valueOf(g) : c(zzabVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e("Failed to encode name or value", e);
            return null;
        }
    }

    HttpURLConnection a(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(q().D());
        httpURLConnection.setReadTimeout(q().E());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.f700a);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public List<Long> a(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        m();
        D();
        com.google.android.gms.common.internal.zzx.a(list);
        if (q().u().isEmpty() || !this.b.a(q().n() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = q().s() != zzm.NONE;
            if (q().t() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? a(list, z2) : b(list);
    }

    List<Long> a(List<zzab> list, boolean z) {
        com.google.android.gms.common.internal.zzx.b(!list.isEmpty());
        a("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        a aVar = new a();
        ArrayList arrayList = new ArrayList();
        for (zzab zzabVar : list) {
            if (!aVar.a(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.c()));
        }
        if (aVar.a() == 0) {
            return arrayList;
        }
        URL d = d();
        if (d == null) {
            f("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int b = z ? b(d, aVar.b()) : a(d, aVar.b());
        if (200 == b) {
            a("Batched upload completed. Hits batched", Integer.valueOf(aVar.a()));
            return arrayList;
        }
        a("Network error uploading hits. status code", Integer.valueOf(b));
        if (q().u().contains(Integer.valueOf(b))) {
            e("Server instructed the client to stop batching");
            this.b.a();
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        a("Network initialized. User agent", this.f700a);
    }

    List<Long> b(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzabVar : list) {
            if (!a(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.c()));
            if (arrayList.size() >= q().l()) {
                break;
            }
        }
        return arrayList;
    }

    public boolean b() {
        NetworkInfo networkInfo;
        m();
        D();
        try {
            networkInfo = ((ConnectivityManager) o().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        b("No network connectivity");
        return false;
    }
}

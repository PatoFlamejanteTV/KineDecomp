package io.fabric.sdk.android.services.network;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

/* loaded from: classes3.dex */
public class HttpRequest {

    /* renamed from: a */
    private static final String[] f26963a = new String[0];

    /* renamed from: b */
    private static b f26964b = b.f26973a;

    /* renamed from: d */
    public final URL f26966d;

    /* renamed from: e */
    private final String f26967e;

    /* renamed from: f */
    private d f26968f;

    /* renamed from: g */
    private boolean f26969g;
    private String k;
    private int l;

    /* renamed from: c */
    private HttpURLConnection f26965c = null;

    /* renamed from: h */
    private boolean f26970h = true;
    private boolean i = false;
    private int j = 8192;

    /* loaded from: classes3.dex */
    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static abstract class a<V> extends c<V> {

        /* renamed from: a */
        private final Closeable f26971a;

        /* renamed from: b */
        private final boolean f26972b;

        public a(Closeable closeable, boolean z) {
            this.f26971a = closeable;
            this.f26972b = z;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.c
        protected void a() throws IOException {
            Closeable closeable = this.f26971a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f26972b) {
                try {
                    this.f26971a.close();
                } catch (IOException unused) {
                }
            } else {
                this.f26971a.close();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {

        /* renamed from: a */
        public static final b f26973a = new e();

        HttpURLConnection a(URL url) throws IOException;

        HttpURLConnection a(URL url, Proxy proxy) throws IOException;
    }

    /* loaded from: classes3.dex */
    public static abstract class c<V> implements Callable<V> {
        protected c() {
        }

        protected abstract void a() throws IOException;

        protected abstract V b() throws HttpRequestException, IOException;

        @Override // java.util.concurrent.Callable
        public V call() throws HttpRequestException {
            Throwable th;
            boolean z = true;
            try {
                try {
                    V b2 = b();
                    try {
                        a();
                        return b2;
                    } catch (IOException e2) {
                        throw new HttpRequestException(e2);
                    }
                } catch (HttpRequestException e3) {
                    throw e3;
                } catch (IOException e4) {
                    throw new HttpRequestException(e4);
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                    try {
                        a();
                    } catch (IOException e5) {
                        if (!z) {
                            throw new HttpRequestException(e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a();
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends BufferedOutputStream {

        /* renamed from: a */
        private final CharsetEncoder f26974a;

        public d(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f26974a = Charset.forName(HttpRequest.f(str)).newEncoder();
        }

        public d e(String str) throws IOException {
            ByteBuffer encode = this.f26974a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public HttpRequest(CharSequence charSequence, String str) throws HttpRequestException {
        try {
            this.f26966d = new URL(charSequence.toString());
            this.f26967e = str;
        } catch (MalformedURLException e2) {
            throw new HttpRequestException(e2);
        }
    }

    private static StringBuilder b(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    public static HttpRequest c(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest d(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest e(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "PUT");
    }

    public static String f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private HttpURLConnection q() {
        HttpURLConnection a2;
        try {
            if (this.k != null) {
                a2 = f26964b.a(this.f26966d, r());
            } else {
                a2 = f26964b.a(this.f26966d);
            }
            a2.setRequestMethod(this.f26967e);
            return a2;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    private Proxy r() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.k, this.l));
    }

    public int g() throws HttpRequestException {
        try {
            e();
            return j().getResponseCode();
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String h() {
        return d("Content-Encoding");
    }

    public int i() {
        return e(HttpHeaders.CONTENT_LENGTH);
    }

    public HttpURLConnection j() {
        if (this.f26965c == null) {
            this.f26965c = q();
        }
        return this.f26965c;
    }

    public String k() {
        return j().getRequestMethod();
    }

    public boolean l() throws HttpRequestException {
        return 200 == g();
    }

    protected HttpRequest m() throws IOException {
        if (this.f26968f != null) {
            return this;
        }
        j().setDoOutput(true);
        this.f26968f = new d(j().getOutputStream(), b(j().getRequestProperty(HttpHeaders.CONTENT_TYPE), "charset"), this.j);
        return this;
    }

    protected HttpRequest n() throws IOException {
        if (!this.f26969g) {
            this.f26969g = true;
            c("multipart/form-data; boundary=00content0boundary00");
            m();
            this.f26968f.e("--00content0boundary00\r\n");
        } else {
            this.f26968f.e("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    public InputStream o() throws HttpRequestException {
        InputStream inputStream;
        if (g() < 400) {
            try {
                inputStream = j().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        } else {
            inputStream = j().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = j().getInputStream();
                } catch (IOException e3) {
                    throw new HttpRequestException(e3);
                }
            }
        }
        if (!this.i || !"gzip".equals(h())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e4) {
            throw new HttpRequestException(e4);
        }
    }

    public URL p() {
        return j().getURL();
    }

    public String toString() {
        return k() + ' ' + p();
    }

    protected ByteArrayOutputStream c() {
        int i = i();
        if (i > 0) {
            return new ByteArrayOutputStream(i);
        }
        return new ByteArrayOutputStream();
    }

    public String d(String str) throws HttpRequestException {
        f();
        return j().getHeaderField(str);
    }

    public int e(String str) throws HttpRequestException {
        return a(str, -1);
    }

    protected HttpRequest f() throws HttpRequestException {
        try {
            e();
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    private static StringBuilder a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    public static String b(CharSequence charSequence) throws HttpRequestException {
        int i;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0 || (i = indexOf + 1) >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i) + aSCIIString.substring(i).replace("+", "%2B");
            } catch (URISyntaxException e2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e2);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e3) {
            throw new HttpRequestException(e3);
        }
    }

    protected HttpRequest e() throws IOException {
        d dVar = this.f26968f;
        if (dVar == null) {
            return this;
        }
        if (this.f26969g) {
            dVar.e("\r\n--00content0boundary00--\r\n");
        }
        if (this.f26970h) {
            try {
                this.f26968f.close();
            } catch (IOException unused) {
            }
        } else {
            this.f26968f.close();
        }
        this.f26968f = null;
        return this;
    }

    public String d(String str, String str2) {
        return b(d(str), str2);
    }

    public HttpRequest f(String str, String str2) throws HttpRequestException {
        f((CharSequence) str);
        f(": ");
        f((CharSequence) str2);
        f("\r\n");
        return this;
    }

    public HttpRequest c(String str, String str2) {
        j().setRequestProperty(str, str2);
        return this;
    }

    public String d() {
        return d(HttpHeaders.CONTENT_TYPE, "charset");
    }

    public HttpRequest f(CharSequence charSequence) throws HttpRequestException {
        try {
            m();
            this.f26968f.e(charSequence.toString());
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest c(String str) {
        a(str, (String) null);
        return this;
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        b(charSequence2, sb);
        a(charSequence2, sb);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry<?, ?> next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Map.Entry<?, ?> next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    public HttpRequest e(String str, String str2) {
        a(str, (String) null, str2);
        return this;
    }

    public static HttpRequest b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = b((CharSequence) a2);
        }
        return d((CharSequence) a2);
    }

    public String b(String str) throws HttpRequestException {
        ByteArrayOutputStream c2 = c();
        try {
            a(b(), c2);
            return c2.toString(f(str));
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public BufferedInputStream b() throws HttpRequestException {
        return new BufferedInputStream(o(), this.j);
    }

    protected String b(String str, String str2) {
        String trim;
        int length;
        if (str != null && str.length() != 0) {
            int length2 = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf != 0 && indexOf != length2) {
                int indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length2;
                }
                while (indexOf < indexOf2) {
                    int indexOf3 = str.indexOf(61, indexOf);
                    if (indexOf3 != -1 && indexOf3 < indexOf2 && str2.equals(str.substring(indexOf, indexOf3).trim()) && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                        if (length > 2 && '\"' == trim.charAt(0)) {
                            int i = length - 1;
                            if ('\"' == trim.charAt(i)) {
                                return trim.substring(1, i);
                            }
                        }
                        return trim;
                    }
                    indexOf = indexOf2 + 1;
                    indexOf2 = str.indexOf(59, indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = length2;
                    }
                }
            }
        }
        return null;
    }

    public static HttpRequest a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = b((CharSequence) a2);
        }
        return c((CharSequence) a2);
    }

    public static HttpRequest a(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "DELETE");
    }

    public String a() throws HttpRequestException {
        return b(d());
    }

    public HttpRequest a(int i) {
        j().setConnectTimeout(i);
        return this;
    }

    public HttpRequest a(Map.Entry<String, String> entry) {
        c(entry.getKey(), entry.getValue());
        return this;
    }

    public int a(String str, int i) throws HttpRequestException {
        f();
        return j().getHeaderFieldInt(str, i);
    }

    protected HttpRequest b(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        f("Content-Disposition", sb.toString());
        if (str3 != null) {
            f(HttpHeaders.CONTENT_TYPE, str3);
        }
        f("\r\n");
        return this;
    }

    public HttpRequest a(boolean z) {
        j().setUseCaches(z);
        return this;
    }

    public HttpRequest a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            c(HttpHeaders.CONTENT_TYPE, str + "; charset=" + str2);
            return this;
        }
        c(HttpHeaders.CONTENT_TYPE, str);
        return this;
    }

    protected HttpRequest a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return new io.fabric.sdk.android.services.network.d(this, inputStream, this.f26970h, inputStream, outputStream).call();
    }

    public HttpRequest a(String str, String str2, String str3) throws HttpRequestException {
        a(str, str2, (String) null, str3);
        return this;
    }

    public HttpRequest a(String str, String str2, String str3, String str4) throws HttpRequestException {
        try {
            n();
            b(str, str2, str3);
            this.f26968f.e(str4);
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest a(String str, Number number) throws HttpRequestException {
        a(str, (String) null, number);
        return this;
    }

    public HttpRequest a(String str, String str2, Number number) throws HttpRequestException {
        a(str, str2, number != null ? number.toString() : null);
        return this;
    }

    public HttpRequest a(String str, String str2, String str3, File file) throws HttpRequestException {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    a(str, str2, str3, bufferedInputStream2);
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return this;
                } catch (IOException e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream2;
                    throw new HttpRequestException(e);
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    public HttpRequest a(String str, String str2, String str3, InputStream inputStream) throws HttpRequestException {
        try {
            n();
            b(str, str2, str3);
            a(inputStream, this.f26968f);
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }
}

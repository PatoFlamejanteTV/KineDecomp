package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Base64;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class HttpHeaders extends GenericData {

    @Key(io.fabric.sdk.android.services.common.a.HEADER_ACCEPT)
    private List<String> accept;

    @Key("Accept-Encoding")
    private List<String> acceptEncoding;

    @Key("Age")
    private List<Long> age;

    @Key("WWW-Authenticate")
    private List<String> authenticate;

    @Key("Authorization")
    private List<String> authorization;

    @Key("Cache-Control")
    private List<String> cacheControl;

    @Key("Content-Encoding")
    private List<String> contentEncoding;

    @Key(com.facebook.stetho.server.http.HttpHeaders.CONTENT_LENGTH)
    private List<Long> contentLength;

    @Key("Content-MD5")
    private List<String> contentMD5;

    @Key("Content-Range")
    private List<String> contentRange;

    @Key(com.facebook.stetho.server.http.HttpHeaders.CONTENT_TYPE)
    private List<String> contentType;

    @Key("Cookie")
    private List<String> cookie;

    @Key("Date")
    private List<String> date;

    @Key("ETag")
    private List<String> etag;

    @Key("Expires")
    private List<String> expires;

    @Key("If-Match")
    private List<String> ifMatch;

    @Key("If-Modified-Since")
    private List<String> ifModifiedSince;

    @Key("If-None-Match")
    private List<String> ifNoneMatch;

    @Key("If-Range")
    private List<String> ifRange;

    @Key("If-Unmodified-Since")
    private List<String> ifUnmodifiedSince;

    @Key("Last-Modified")
    private List<String> lastModified;

    @Key("Location")
    private List<String> location;

    @Key("MIME-Version")
    private List<String> mimeVersion;

    @Key("Range")
    private List<String> range;

    @Key("Retry-After")
    private List<String> retryAfter;

    @Key(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT)
    private List<String> userAgent;

    /* loaded from: classes2.dex */
    private static class a extends LowLevelHttpRequest {

        /* renamed from: e, reason: collision with root package name */
        private final HttpHeaders f14750e;

        /* renamed from: f, reason: collision with root package name */
        private final b f14751f;

        a(HttpHeaders httpHeaders, b bVar) {
            this.f14750e = httpHeaders;
            this.f14751f = bVar;
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public void a(String str, String str2) {
            this.f14750e.a(str, str2, this.f14751f);
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public LowLevelHttpResponse a() throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final ArrayValueMap f14752a;

        /* renamed from: b, reason: collision with root package name */
        final StringBuilder f14753b;

        /* renamed from: c, reason: collision with root package name */
        final ClassInfo f14754c;

        /* renamed from: d, reason: collision with root package name */
        final List<Type> f14755d;

        public b(HttpHeaders httpHeaders, StringBuilder sb) {
            Class<?> cls = httpHeaders.getClass();
            this.f14755d = Arrays.asList(cls);
            this.f14754c = ClassInfo.a(cls, true);
            this.f14753b = sb;
            this.f14752a = new ArrayValueMap(httpHeaders);
        }

        void a() {
            this.f14752a.a();
        }
    }

    public HttpHeaders() {
        super(EnumSet.of(GenericData.Flags.IGNORE_CASE));
        this.acceptEncoding = new ArrayList(Collections.singleton("gzip"));
    }

    public HttpHeaders a(String str) {
        this.acceptEncoding = a((HttpHeaders) str);
        return this;
    }

    public final List<String> b() {
        return this.authorization;
    }

    public HttpHeaders c(String str) {
        this.contentEncoding = a((HttpHeaders) str);
        return this;
    }

    public final String d() {
        return (String) b((List) this.contentRange);
    }

    public HttpHeaders e(String str) {
        this.ifMatch = a((HttpHeaders) str);
        return this;
    }

    public HttpHeaders f(String str) {
        this.ifModifiedSince = a((HttpHeaders) str);
        return this;
    }

    public HttpHeaders g(String str) {
        this.ifNoneMatch = a((HttpHeaders) str);
        return this;
    }

    public final String getContentType() {
        return (String) b((List) this.contentType);
    }

    public final String getLocation() {
        return (String) b((List) this.location);
    }

    public HttpHeaders h(String str) {
        this.ifRange = a((HttpHeaders) str);
        return this;
    }

    public HttpHeaders i(String str) {
        this.ifUnmodifiedSince = a((HttpHeaders) str);
        return this;
    }

    public HttpHeaders j(String str) {
        this.range = a((HttpHeaders) str);
        return this;
    }

    public HttpHeaders k(String str) {
        this.userAgent = a((HttpHeaders) str);
        return this;
    }

    public HttpHeaders setContentType(String str) {
        this.contentType = a((HttpHeaders) str);
        return this;
    }

    public HttpHeaders a(List<String> list) {
        this.authorization = list;
        return this;
    }

    public HttpHeaders b(String str) {
        return a(a((HttpHeaders) str));
    }

    public final Long c() {
        return (Long) b((List) this.contentLength);
    }

    public HttpHeaders d(String str) {
        this.contentRange = a((HttpHeaders) str);
        return this;
    }

    public final String e() {
        return (String) b((List) this.range);
    }

    public final String f() {
        return (String) b((List) this.userAgent);
    }

    @Override // com.google.api.client.util.GenericData
    public HttpHeaders set(String str, Object obj) {
        super.set(str, obj);
        return this;
    }

    private static String b(Object obj) {
        return obj instanceof Enum ? FieldInfo.a((Enum<?>) obj).d() : obj.toString();
    }

    public HttpHeaders a(Long l) {
        this.contentLength = a((HttpHeaders) l);
        return this;
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public HttpHeaders clone() {
        return (HttpHeaders) super.clone();
    }

    public HttpHeaders e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        Preconditions.a(str);
        sb.append(str);
        sb.append(":");
        Preconditions.a(str2);
        sb.append(str2);
        return b("Basic " + Base64.b(StringUtils.a(sb.toString())));
    }

    public final List<String> a() {
        return this.authenticate;
    }

    private static void a(Logger logger, StringBuilder sb, StringBuilder sb2, LowLevelHttpRequest lowLevelHttpRequest, String str, Object obj, Writer writer) throws IOException {
        if (obj == null || Data.b(obj)) {
            return;
        }
        String b2 = b(obj);
        String str2 = (("Authorization".equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : b2;
        if (sb != null) {
            sb.append(str);
            sb.append(": ");
            sb.append(str2);
            sb.append(StringUtils.f14981a);
        }
        if (sb2 != null) {
            sb2.append(" -H '");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(str2);
            sb2.append("'");
        }
        if (lowLevelHttpRequest != null) {
            lowLevelHttpRequest.a(str, b2);
        }
        if (writer != null) {
            writer.write(str);
            writer.write(": ");
            writer.write(b2);
            writer.write("\r\n");
        }
    }

    private <T> T b(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(HttpHeaders httpHeaders, StringBuilder sb, StringBuilder sb2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest) throws IOException {
        a(httpHeaders, sb, sb2, logger, lowLevelHttpRequest, null);
    }

    public static void a(HttpHeaders httpHeaders, StringBuilder sb, Logger logger, Writer writer) throws IOException {
        a(httpHeaders, sb, null, logger, null, writer);
    }

    static void a(HttpHeaders httpHeaders, StringBuilder sb, StringBuilder sb2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest, Writer writer) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, Object> entry : httpHeaders.entrySet()) {
            String key = entry.getKey();
            Preconditions.a(hashSet.add(key), "multiple headers of the same name (headers are case insensitive): %s", key);
            Object value = entry.getValue();
            if (value != null) {
                FieldInfo b2 = httpHeaders.getClassInfo().b(key);
                if (b2 != null) {
                    key = b2.d();
                }
                Class<?> cls = value.getClass();
                if (!(value instanceof Iterable) && !cls.isArray()) {
                    a(logger, sb, sb2, lowLevelHttpRequest, key, value, writer);
                } else {
                    Iterator it = Types.a(value).iterator();
                    while (it.hasNext()) {
                        a(logger, sb, sb2, lowLevelHttpRequest, key, it.next(), writer);
                    }
                }
            }
        }
        if (writer != null) {
            writer.flush();
        }
    }

    public final void a(LowLevelHttpResponse lowLevelHttpResponse, StringBuilder sb) throws IOException {
        clear();
        b bVar = new b(this, sb);
        int e2 = lowLevelHttpResponse.e();
        for (int i = 0; i < e2; i++) {
            a(lowLevelHttpResponse.a(i), lowLevelHttpResponse.b(i), bVar);
        }
        bVar.a();
    }

    private <T> List<T> a(T t) {
        if (t == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    public final void a(HttpHeaders httpHeaders) {
        try {
            b bVar = new b(this, null);
            a(httpHeaders, null, null, null, new a(this, bVar));
            bVar.a();
        } catch (IOException e2) {
            Throwables.a(e2);
            throw null;
        }
    }

    void a(String str, String str2, b bVar) {
        List<Type> list = bVar.f14755d;
        ClassInfo classInfo = bVar.f14754c;
        ArrayValueMap arrayValueMap = bVar.f14752a;
        StringBuilder sb = bVar.f14753b;
        if (sb != null) {
            sb.append(str + ": " + str2);
            sb.append(StringUtils.f14981a);
        }
        FieldInfo b2 = classInfo.b(str);
        if (b2 != null) {
            Type a2 = Data.a(list, b2.c());
            if (Types.d(a2)) {
                Class<?> a3 = Types.a(list, Types.a(a2));
                arrayValueMap.a(b2.b(), a3, a(a3, list, str2));
                return;
            } else {
                if (Types.a(Types.a(list, a2), (Class<?>) Iterable.class)) {
                    Collection<Object> collection = (Collection) b2.a(this);
                    if (collection == null) {
                        collection = Data.b(a2);
                        b2.a(this, collection);
                    }
                    collection.add(a(a2 == Object.class ? null : Types.b(a2), list, str2));
                    return;
                }
                b2.a(this, a(a2, list, str2));
                return;
            }
        }
        ArrayList arrayList = (ArrayList) get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            set(str, (Object) arrayList);
        }
        arrayList.add(str2);
    }

    private static Object a(Type type, List<Type> list, String str) {
        return Data.a(Data.a(list, type), str);
    }
}

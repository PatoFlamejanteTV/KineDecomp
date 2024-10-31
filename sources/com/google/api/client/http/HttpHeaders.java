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

/* loaded from: classes.dex */
public class HttpHeaders extends GenericData {

    /* renamed from: a, reason: collision with root package name */
    @Key(a = "Accept-Encoding")
    private List<String> f2461a;

    @Key(a = "Authorization")
    private List<String> b;

    @Key(a = "Content-Encoding")
    private List<String> c;

    @Key(a = "Content-Length")
    private List<Long> d;

    @Key(a = "Content-Range")
    private List<String> e;

    @Key(a = "Content-Type")
    private List<String> f;

    @Key(a = "If-Modified-Since")
    private List<String> g;

    @Key(a = "If-Match")
    private List<String> h;

    @Key(a = "If-None-Match")
    private List<String> i;

    @Key(a = "If-Unmodified-Since")
    private List<String> j;

    @Key(a = "If-Range")
    private List<String> k;

    @Key(a = "Location")
    private List<String> l;

    @Key(a = "Range")
    private List<String> m;

    @Key(a = "User-Agent")
    private List<String> n;

    @Key(a = "WWW-Authenticate")
    private List<String> o;

    public HttpHeaders() {
        super(EnumSet.of(GenericData.Flags.IGNORE_CASE));
        this.f2461a = new ArrayList(Collections.singleton("gzip"));
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HttpHeaders clone() {
        return (HttpHeaders) super.clone();
    }

    @Override // com.google.api.client.util.GenericData
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HttpHeaders set(String str, Object obj) {
        return (HttpHeaders) super.set(str, obj);
    }

    public HttpHeaders a(String str) {
        this.f2461a = b((HttpHeaders) str);
        return this;
    }

    public final List<String> b() {
        return this.b;
    }

    public HttpHeaders b(String str) {
        return a(b((HttpHeaders) str));
    }

    public HttpHeaders a(List<String> list) {
        this.b = list;
        return this;
    }

    public HttpHeaders c(String str) {
        this.c = b((HttpHeaders) str);
        return this;
    }

    public final Long c() {
        return (Long) b((List) this.d);
    }

    public HttpHeaders a(Long l) {
        this.d = b((HttpHeaders) l);
        return this;
    }

    public final String d() {
        return (String) b((List) this.e);
    }

    public HttpHeaders d(String str) {
        this.e = b((HttpHeaders) str);
        return this;
    }

    public final String e() {
        return (String) b((List) this.f);
    }

    public HttpHeaders e(String str) {
        this.f = b((HttpHeaders) str);
        return this;
    }

    public HttpHeaders f(String str) {
        this.g = b((HttpHeaders) str);
        return this;
    }

    public HttpHeaders g(String str) {
        this.h = b((HttpHeaders) str);
        return this;
    }

    public HttpHeaders h(String str) {
        this.i = b((HttpHeaders) str);
        return this;
    }

    public HttpHeaders i(String str) {
        this.j = b((HttpHeaders) str);
        return this;
    }

    public HttpHeaders j(String str) {
        this.k = b((HttpHeaders) str);
        return this;
    }

    public final String f() {
        return (String) b((List) this.l);
    }

    public final String g() {
        return (String) b((List) this.m);
    }

    public HttpHeaders k(String str) {
        this.m = b((HttpHeaders) str);
        return this;
    }

    public final String h() {
        return (String) b((List) this.n);
    }

    public HttpHeaders l(String str) {
        this.n = b((HttpHeaders) str);
        return this;
    }

    public final List<String> i() {
        return this.o;
    }

    public HttpHeaders a(String str, String str2) {
        String valueOf = String.valueOf(String.valueOf((String) Preconditions.a(str)));
        String valueOf2 = String.valueOf(String.valueOf((String) Preconditions.a(str2)));
        String valueOf3 = String.valueOf(Base64.b(StringUtils.a(new StringBuilder(valueOf.length() + 1 + valueOf2.length()).append(valueOf).append(":").append(valueOf2).toString())));
        return b(valueOf3.length() != 0 ? "Basic ".concat(valueOf3) : new String("Basic "));
    }

    private static void a(Logger logger, StringBuilder sb, StringBuilder sb2, LowLevelHttpRequest lowLevelHttpRequest, String str, Object obj, Writer writer) throws IOException {
        if (obj != null && !Data.a(obj)) {
            String a2 = a(obj);
            String str2 = (("Authorization".equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : a2;
            if (sb != null) {
                sb.append(str).append(": ");
                sb.append(str2);
                sb.append(StringUtils.f2548a);
            }
            if (sb2 != null) {
                sb2.append(" -H '").append(str).append(": ").append(str2).append("'");
            }
            if (lowLevelHttpRequest != null) {
                lowLevelHttpRequest.a(str, a2);
            }
            if (writer != null) {
                writer.write(str);
                writer.write(": ");
                writer.write(a2);
                writer.write("\r\n");
            }
        }
    }

    private static String a(Object obj) {
        return obj instanceof Enum ? FieldInfo.a((Enum<?>) obj).b() : obj.toString();
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
                FieldInfo a2 = httpHeaders.getClassInfo().a(key);
                String b2 = a2 != null ? a2.b() : key;
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    Iterator it = Types.a(value).iterator();
                    while (it.hasNext()) {
                        a(logger, sb, sb2, lowLevelHttpRequest, b2, it.next(), writer);
                    }
                } else {
                    a(logger, sb, sb2, lowLevelHttpRequest, b2, value, writer);
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
        int g = lowLevelHttpResponse.g();
        for (int i = 0; i < g; i++) {
            a(lowLevelHttpResponse.a(i), lowLevelHttpResponse.b(i), bVar);
        }
        bVar.a();
    }

    /* loaded from: classes.dex */
    private static class a extends LowLevelHttpRequest {

        /* renamed from: a, reason: collision with root package name */
        private final HttpHeaders f2462a;
        private final b b;

        a(HttpHeaders httpHeaders, b bVar) {
            this.f2462a = httpHeaders;
            this.b = bVar;
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public void a(String str, String str2) {
            this.f2462a.a(str, str2, this.b);
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public LowLevelHttpResponse a() throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    private <T> T b(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    private <T> List<T> b(T t) {
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
        } catch (IOException e) {
            throw Throwables.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final ArrayValueMap f2463a;
        final StringBuilder b;
        final ClassInfo c;
        final List<Type> d;

        public b(HttpHeaders httpHeaders, StringBuilder sb) {
            Class<?> cls = httpHeaders.getClass();
            this.d = Arrays.asList(cls);
            this.c = ClassInfo.a(cls, true);
            this.b = sb;
            this.f2463a = new ArrayValueMap(httpHeaders);
        }

        void a() {
            this.f2463a.a();
        }
    }

    void a(String str, String str2, b bVar) {
        List<Type> list = bVar.d;
        ClassInfo classInfo = bVar.c;
        ArrayValueMap arrayValueMap = bVar.f2463a;
        StringBuilder sb = bVar.b;
        if (sb != null) {
            String valueOf = String.valueOf(String.valueOf(str));
            String valueOf2 = String.valueOf(String.valueOf(str2));
            sb.append(new StringBuilder(valueOf.length() + 2 + valueOf2.length()).append(valueOf).append(": ").append(valueOf2).toString()).append(StringUtils.f2548a);
        }
        FieldInfo a2 = classInfo.a(str);
        if (a2 != null) {
            Type a3 = Data.a(list, a2.d());
            if (Types.a(a3)) {
                Class<?> a4 = Types.a(list, Types.b(a3));
                arrayValueMap.a(a2.a(), a4, a(a4, list, str2));
                return;
            } else {
                if (Types.a(Types.a(list, a3), (Class<?>) Iterable.class)) {
                    Collection<Object> collection = (Collection) a2.a(this);
                    if (collection == null) {
                        collection = Data.b(a3);
                        a2.a(this, collection);
                    }
                    collection.add(a(a3 == Object.class ? null : Types.c(a3), list, str2));
                    return;
                }
                a2.a(this, a(a3, list, str2));
                return;
            }
        }
        ArrayList arrayList = (ArrayList) get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            set(str, arrayList);
        }
        arrayList.add(str2);
    }

    private static Object a(Type type, List<Type> list, String str) {
        return Data.a(Data.a(list, type), str);
    }
}

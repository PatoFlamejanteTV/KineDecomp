package retrofit2;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.D;
import okhttp3.I;
import okhttp3.z;
import retrofit2.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestFactory.java */
/* loaded from: classes3.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    private final Method f29403a;

    /* renamed from: b, reason: collision with root package name */
    private final okhttp3.A f29404b;

    /* renamed from: c, reason: collision with root package name */
    final String f29405c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f29406d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final okhttp3.z f29407e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final okhttp3.C f29408f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f29409g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f29410h;
    private final boolean i;
    private final z<?>[] j;

    C(a aVar) {
        this.f29403a = aVar.f29414d;
        this.f29404b = aVar.f29413c.f29428c;
        this.f29405c = aVar.p;
        this.f29406d = aVar.t;
        this.f29407e = aVar.u;
        this.f29408f = aVar.v;
        this.f29409g = aVar.q;
        this.f29410h = aVar.r;
        this.i = aVar.s;
        this.j = aVar.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C a(F f2, Method method) {
        return new a(f2, method).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public I a(Object[] objArr) throws IOException {
        z<?>[] zVarArr = this.j;
        int length = objArr.length;
        if (length == zVarArr.length) {
            B b2 = new B(this.f29405c, this.f29404b, this.f29406d, this.f29407e, this.f29408f, this.f29409g, this.f29410h, this.i);
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(objArr[i]);
                zVarArr[i].a(b2, objArr[i]);
            }
            I.a a2 = b2.a();
            a2.a((Class<? super Class>) s.class, (Class) new s(this.f29403a, arrayList));
            return a2.a();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + zVarArr.length + ")");
    }

    /* compiled from: RequestFactory.java */
    /* loaded from: classes3.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Pattern f29411a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: b, reason: collision with root package name */
        private static final Pattern f29412b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: c, reason: collision with root package name */
        final F f29413c;

        /* renamed from: d, reason: collision with root package name */
        final Method f29414d;

        /* renamed from: e, reason: collision with root package name */
        final Annotation[] f29415e;

        /* renamed from: f, reason: collision with root package name */
        final Annotation[][] f29416f;

        /* renamed from: g, reason: collision with root package name */
        final Type[] f29417g;

        /* renamed from: h, reason: collision with root package name */
        boolean f29418h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;
        boolean o;

        @Nullable
        String p;
        boolean q;
        boolean r;
        boolean s;

        @Nullable
        String t;

        @Nullable
        okhttp3.z u;

        @Nullable
        okhttp3.C v;

        @Nullable
        Set<String> w;

        @Nullable
        z<?>[] x;

        a(F f2, Method method) {
            this.f29413c = f2;
            this.f29414d = method;
            this.f29415e = method.getAnnotations();
            this.f29417g = method.getGenericParameterTypes();
            this.f29416f = method.getParameterAnnotations();
        }

        C a() {
            for (Annotation annotation : this.f29415e) {
                a(annotation);
            }
            if (this.p != null) {
                if (!this.q) {
                    if (!this.s) {
                        if (this.r) {
                            throw H.a(this.f29414d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    } else {
                        throw H.a(this.f29414d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f29416f.length;
                this.x = new z[length];
                for (int i = 0; i < length; i++) {
                    this.x[i] = a(i, this.f29417g[i], this.f29416f[i]);
                }
                if (this.t == null && !this.o) {
                    throw H.a(this.f29414d, "Missing either @%s URL or @Url parameter.", this.p);
                }
                if (!this.r && !this.s && !this.q && this.j) {
                    throw H.a(this.f29414d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (this.r && !this.f29418h) {
                    throw H.a(this.f29414d, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (this.s && !this.i) {
                    throw H.a(this.f29414d, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                return new C(this);
            }
            throw H.a(this.f29414d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }

        private void a(Annotation annotation) {
            if (annotation instanceof retrofit2.b.a) {
                a("DELETE", ((retrofit2.b.a) annotation).value(), false);
                return;
            }
            if (annotation instanceof retrofit2.b.e) {
                a("GET", ((retrofit2.b.e) annotation).value(), false);
                return;
            }
            if (annotation instanceof retrofit2.b.f) {
                a("HEAD", ((retrofit2.b.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof retrofit2.b.k) {
                a("PATCH", ((retrofit2.b.k) annotation).value(), true);
                return;
            }
            if (annotation instanceof retrofit2.b.l) {
                a("POST", ((retrofit2.b.l) annotation).value(), true);
                return;
            }
            if (annotation instanceof retrofit2.b.m) {
                a("PUT", ((retrofit2.b.m) annotation).value(), true);
                return;
            }
            if (annotation instanceof retrofit2.b.j) {
                a("OPTIONS", ((retrofit2.b.j) annotation).value(), false);
                return;
            }
            if (annotation instanceof retrofit2.b.g) {
                retrofit2.b.g gVar = (retrofit2.b.g) annotation;
                a(gVar.method(), gVar.path(), gVar.hasBody());
                return;
            }
            if (annotation instanceof retrofit2.b.i) {
                String[] value = ((retrofit2.b.i) annotation).value();
                if (value.length != 0) {
                    this.u = a(value);
                    return;
                }
                throw H.a(this.f29414d, "@Headers annotation is empty.", new Object[0]);
            }
            if (annotation instanceof retrofit2.b.d) {
                if (!this.s) {
                    this.r = true;
                    return;
                }
                throw H.a(this.f29414d, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.p;
            if (str3 != null) {
                throw H.a(this.f29414d, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.p = str;
            this.q = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (f29411a.matcher(substring).find()) {
                    throw H.a(this.f29414d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.t = str2;
            this.w = a(str2);
        }

        private okhttp3.z a(String[] strArr) {
            z.a aVar = new z.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw H.a(this.f29414d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    try {
                        this.v = okhttp3.C.a(trim);
                    } catch (IllegalArgumentException e2) {
                        throw H.a(this.f29414d, e2, "Malformed content type: %s", trim);
                    }
                } else {
                    aVar.a(substring, trim);
                }
            }
            return aVar.a();
        }

        private z<?> a(int i, Type type, @Nullable Annotation[] annotationArr) {
            z<?> zVar = null;
            if (annotationArr != null) {
                z<?> zVar2 = null;
                for (Annotation annotation : annotationArr) {
                    z<?> a2 = a(i, type, annotationArr, annotation);
                    if (a2 != null) {
                        if (zVar2 != null) {
                            throw H.a(this.f29414d, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        zVar2 = a2;
                    }
                }
                zVar = zVar2;
            }
            if (zVar != null) {
                return zVar;
            }
            throw H.a(this.f29414d, i, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private z<?> a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof retrofit2.b.p) {
                a(i, type);
                if (!this.l) {
                    if (!this.m) {
                        if (!this.n) {
                            if (!this.o) {
                                if (this.t == null) {
                                    throw H.a(this.f29414d, i, "@Path can only be used with relative url on @%s", this.p);
                                }
                                this.k = true;
                                retrofit2.b.p pVar = (retrofit2.b.p) annotation;
                                String value = pVar.value();
                                a(i, value);
                                return new z.f(value, this.f29413c.c(type, annotationArr), pVar.encoded());
                            }
                            throw H.a(this.f29414d, i, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        throw H.a(this.f29414d, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                    }
                    throw H.a(this.f29414d, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                throw H.a(this.f29414d, i, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (annotation instanceof retrofit2.b.q) {
                a(i, type);
                retrofit2.b.q qVar = (retrofit2.b.q) annotation;
                String value2 = qVar.value();
                boolean encoded = qVar.encoded();
                Class<?> c2 = H.c(type);
                this.l = true;
                if (Iterable.class.isAssignableFrom(c2)) {
                    if (type instanceof ParameterizedType) {
                        return new z.g(value2, this.f29413c.c(H.a(0, (ParameterizedType) type), annotationArr), encoded).b();
                    }
                    throw H.a(this.f29414d, i, c2.getSimpleName() + " must include generic type (e.g., " + c2.getSimpleName() + "<String>)", new Object[0]);
                }
                if (c2.isArray()) {
                    return new z.g(value2, this.f29413c.c(a(c2.getComponentType()), annotationArr), encoded).a();
                }
                return new z.g(value2, this.f29413c.c(type, annotationArr), encoded);
            }
            if (annotation instanceof retrofit2.b.s) {
                a(i, type);
                boolean encoded2 = ((retrofit2.b.s) annotation).encoded();
                Class<?> c3 = H.c(type);
                this.m = true;
                if (Iterable.class.isAssignableFrom(c3)) {
                    if (type instanceof ParameterizedType) {
                        return new z.i(this.f29413c.c(H.a(0, (ParameterizedType) type), annotationArr), encoded2).b();
                    }
                    throw H.a(this.f29414d, i, c3.getSimpleName() + " must include generic type (e.g., " + c3.getSimpleName() + "<String>)", new Object[0]);
                }
                if (c3.isArray()) {
                    return new z.i(this.f29413c.c(a(c3.getComponentType()), annotationArr), encoded2).a();
                }
                return new z.i(this.f29413c.c(type, annotationArr), encoded2);
            }
            if (annotation instanceof retrofit2.b.r) {
                a(i, type);
                Class<?> c4 = H.c(type);
                this.n = true;
                if (Map.class.isAssignableFrom(c4)) {
                    Type b2 = H.b(type, c4, Map.class);
                    if (b2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) b2;
                        Type a2 = H.a(0, parameterizedType);
                        if (String.class == a2) {
                            return new z.h(this.f29413c.c(H.a(1, parameterizedType), annotationArr), ((retrofit2.b.r) annotation).encoded());
                        }
                        throw H.a(this.f29414d, i, "@QueryMap keys must be of type String: " + a2, new Object[0]);
                    }
                    throw H.a(this.f29414d, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw H.a(this.f29414d, i, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof retrofit2.b.h) {
                a(i, type);
                String value3 = ((retrofit2.b.h) annotation).value();
                Class<?> c5 = H.c(type);
                if (Iterable.class.isAssignableFrom(c5)) {
                    if (type instanceof ParameterizedType) {
                        return new z.c(value3, this.f29413c.c(H.a(0, (ParameterizedType) type), annotationArr)).b();
                    }
                    throw H.a(this.f29414d, i, c5.getSimpleName() + " must include generic type (e.g., " + c5.getSimpleName() + "<String>)", new Object[0]);
                }
                if (c5.isArray()) {
                    return new z.c(value3, this.f29413c.c(a(c5.getComponentType()), annotationArr)).a();
                }
                return new z.c(value3, this.f29413c.c(type, annotationArr));
            }
            if (annotation instanceof retrofit2.b.b) {
                a(i, type);
                if (this.r) {
                    retrofit2.b.b bVar = (retrofit2.b.b) annotation;
                    String value4 = bVar.value();
                    boolean encoded3 = bVar.encoded();
                    this.f29418h = true;
                    Class<?> c6 = H.c(type);
                    if (Iterable.class.isAssignableFrom(c6)) {
                        if (type instanceof ParameterizedType) {
                            return new z.a(value4, this.f29413c.c(H.a(0, (ParameterizedType) type), annotationArr), encoded3).b();
                        }
                        throw H.a(this.f29414d, i, c6.getSimpleName() + " must include generic type (e.g., " + c6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (c6.isArray()) {
                        return new z.a(value4, this.f29413c.c(a(c6.getComponentType()), annotationArr), encoded3).a();
                    }
                    return new z.a(value4, this.f29413c.c(type, annotationArr), encoded3);
                }
                throw H.a(this.f29414d, i, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof retrofit2.b.c) {
                a(i, type);
                if (this.r) {
                    Class<?> c7 = H.c(type);
                    if (Map.class.isAssignableFrom(c7)) {
                        Type b3 = H.b(type, c7, Map.class);
                        if (b3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType2 = (ParameterizedType) b3;
                            Type a3 = H.a(0, parameterizedType2);
                            if (String.class == a3) {
                                j c8 = this.f29413c.c(H.a(1, parameterizedType2), annotationArr);
                                this.f29418h = true;
                                return new z.b(c8, ((retrofit2.b.c) annotation).encoded());
                            }
                            throw H.a(this.f29414d, i, "@FieldMap keys must be of type String: " + a3, new Object[0]);
                        }
                        throw H.a(this.f29414d, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw H.a(this.f29414d, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw H.a(this.f29414d, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof retrofit2.b.n) {
                a(i, type);
                if (this.s) {
                    retrofit2.b.n nVar = (retrofit2.b.n) annotation;
                    this.i = true;
                    String value5 = nVar.value();
                    Class<?> c9 = H.c(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(c9)) {
                            if (type instanceof ParameterizedType) {
                                if (D.b.class.isAssignableFrom(H.c(H.a(0, (ParameterizedType) type)))) {
                                    return z.j.f29558a.b();
                                }
                                throw H.a(this.f29414d, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw H.a(this.f29414d, i, c9.getSimpleName() + " must include generic type (e.g., " + c9.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (c9.isArray()) {
                            if (D.b.class.isAssignableFrom(c9.getComponentType())) {
                                return z.j.f29558a.a();
                            }
                            throw H.a(this.f29414d, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (D.b.class.isAssignableFrom(c9)) {
                            return z.j.f29558a;
                        }
                        throw H.a(this.f29414d, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    okhttp3.z a4 = okhttp3.z.a("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", nVar.encoding());
                    if (Iterable.class.isAssignableFrom(c9)) {
                        if (type instanceof ParameterizedType) {
                            Type a5 = H.a(0, (ParameterizedType) type);
                            if (!D.b.class.isAssignableFrom(H.c(a5))) {
                                return new z.d(a4, this.f29413c.a(a5, annotationArr, this.f29415e)).b();
                            }
                            throw H.a(this.f29414d, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw H.a(this.f29414d, i, c9.getSimpleName() + " must include generic type (e.g., " + c9.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (c9.isArray()) {
                        Class<?> a6 = a(c9.getComponentType());
                        if (!D.b.class.isAssignableFrom(a6)) {
                            return new z.d(a4, this.f29413c.a(a6, annotationArr, this.f29415e)).a();
                        }
                        throw H.a(this.f29414d, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!D.b.class.isAssignableFrom(c9)) {
                        return new z.d(a4, this.f29413c.a(type, annotationArr, this.f29415e));
                    }
                    throw H.a(this.f29414d, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw H.a(this.f29414d, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (!(annotation instanceof retrofit2.b.o)) {
                return null;
            }
            a(i, type);
            if (this.s) {
                this.i = true;
                Class<?> c10 = H.c(type);
                if (Map.class.isAssignableFrom(c10)) {
                    Type b4 = H.b(type, c10, Map.class);
                    if (b4 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType3 = (ParameterizedType) b4;
                        Type a7 = H.a(0, parameterizedType3);
                        if (String.class == a7) {
                            Type a8 = H.a(1, parameterizedType3);
                            if (!D.b.class.isAssignableFrom(H.c(a8))) {
                                return new z.e(this.f29413c.a(a8, annotationArr, this.f29415e), ((retrofit2.b.o) annotation).encoding());
                            }
                            throw H.a(this.f29414d, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                        }
                        throw H.a(this.f29414d, i, "@PartMap keys must be of type String: " + a7, new Object[0]);
                    }
                    throw H.a(this.f29414d, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw H.a(this.f29414d, i, "@PartMap parameter type must be Map.", new Object[0]);
            }
            throw H.a(this.f29414d, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        }

        private void a(int i, Type type) {
            if (H.d(type)) {
                throw H.a(this.f29414d, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        private void a(int i, String str) {
            if (f29412b.matcher(str).matches()) {
                if (!this.w.contains(str)) {
                    throw H.a(this.f29414d, i, "URL \"%s\" does not contain \"{%s}\".", this.t, str);
                }
                return;
            }
            throw H.a(this.f29414d, i, "@Path parameter name must match %s. Found: %s", f29411a.pattern(), str);
        }

        static Set<String> a(String str) {
            Matcher matcher = f29411a.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }
    }
}

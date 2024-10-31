package com.google.firebase.storage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.annotations.PublicApi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class StorageMetadata {

    /* renamed from: a, reason: collision with root package name */
    private String f18088a;

    /* renamed from: b, reason: collision with root package name */
    private FirebaseStorage f18089b;

    /* renamed from: c, reason: collision with root package name */
    private StorageReference f18090c;

    /* renamed from: d, reason: collision with root package name */
    private String f18091d;

    /* renamed from: e, reason: collision with root package name */
    private String f18092e;

    /* renamed from: f, reason: collision with root package name */
    private a<String> f18093f;

    /* renamed from: g, reason: collision with root package name */
    private String f18094g;

    /* renamed from: h, reason: collision with root package name */
    private String f18095h;
    private String i;
    private long j;
    private String k;
    private a<String> l;
    private a<String> m;
    private a<String> n;
    private a<String> o;
    private a<Map<String, String>> p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f18098a;

        /* renamed from: b, reason: collision with root package name */
        private final T f18099b;

        a(T t, boolean z) {
            this.f18098a = z;
            this.f18099b = t;
        }

        static <T> a<T> a(T t) {
            return new a<>(t, false);
        }

        static <T> a<T> b(T t) {
            return new a<>(t, true);
        }

        T a() {
            return this.f18099b;
        }

        boolean b() {
            return this.f18098a;
        }
    }

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        StorageMetadata f18096a;

        /* renamed from: b, reason: collision with root package name */
        boolean f18097b;

        @PublicApi
        public Builder() {
            this.f18096a = new StorageMetadata();
        }

        private String a(JSONObject jSONObject, String str) throws JSONException {
            if (!jSONObject.has(str) || jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        }

        @PublicApi
        public Builder b(String str) {
            this.f18096a.m = a.b(str);
            return this;
        }

        @PublicApi
        public Builder c(String str) {
            this.f18096a.n = a.b(str);
            return this;
        }

        @PublicApi
        public Builder d(String str) {
            this.f18096a.o = a.b(str);
            return this;
        }

        @PublicApi
        public Builder e(String str) {
            this.f18096a.f18093f = a.b(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(JSONObject jSONObject, StorageReference storageReference) throws JSONException {
            this(jSONObject);
            this.f18096a.f18090c = storageReference;
        }

        private void a(JSONObject jSONObject) throws JSONException {
            this.f18096a.f18092e = jSONObject.optString("generation");
            this.f18096a.f18088a = jSONObject.optString("name");
            this.f18096a.f18091d = jSONObject.optString("bucket");
            this.f18096a.f18094g = jSONObject.optString("metageneration");
            this.f18096a.f18095h = jSONObject.optString("timeCreated");
            this.f18096a.i = jSONObject.optString("updated");
            this.f18096a.j = jSONObject.optLong("size");
            this.f18096a.k = jSONObject.optString("md5Hash");
            if (jSONObject.has("metadata") && !jSONObject.isNull("metadata")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a(next, jSONObject2.getString(next));
                }
            }
            String a2 = a(jSONObject, "contentType");
            if (a2 != null) {
                e(a2);
            }
            String a3 = a(jSONObject, "cacheControl");
            if (a3 != null) {
                a(a3);
            }
            String a4 = a(jSONObject, "contentDisposition");
            if (a4 != null) {
                b(a4);
            }
            String a5 = a(jSONObject, "contentEncoding");
            if (a5 != null) {
                c(a5);
            }
            String a6 = a(jSONObject, "contentLanguage");
            if (a6 != null) {
                d(a6);
            }
        }

        Builder(JSONObject jSONObject) throws JSONException {
            this.f18096a = new StorageMetadata();
            if (jSONObject != null) {
                a(jSONObject);
                this.f18097b = true;
            }
        }

        @PublicApi
        public StorageMetadata a() {
            return new StorageMetadata(this.f18097b);
        }

        @PublicApi
        public Builder a(String str) {
            this.f18096a.l = a.b(str);
            return this;
        }

        @PublicApi
        public Builder a(String str, String str2) {
            if (!this.f18096a.p.b()) {
                this.f18096a.p = a.b(new HashMap());
            }
            ((Map) this.f18096a.p.a()).put(str, str2);
            return this;
        }
    }

    @PublicApi
    public StorageMetadata() {
        this.f18088a = null;
        this.f18089b = null;
        this.f18090c = null;
        this.f18091d = null;
        this.f18092e = null;
        this.f18093f = a.a("");
        this.f18094g = null;
        this.f18095h = null;
        this.i = null;
        this.k = null;
        this.l = a.a("");
        this.m = a.a("");
        this.n = a.a("");
        this.o = a.a("");
        this.p = a.a(Collections.emptyMap());
    }

    @PublicApi
    public String b() {
        return this.l.a();
    }

    @PublicApi
    public String c() {
        return this.m.a();
    }

    @PublicApi
    public String d() {
        return this.n.a();
    }

    @PublicApi
    public String e() {
        return this.o.a();
    }

    @PublicApi
    public String f() {
        return this.f18093f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject a() throws JSONException {
        HashMap hashMap = new HashMap();
        if (this.f18093f.b()) {
            hashMap.put("contentType", f());
        }
        if (this.p.b()) {
            hashMap.put("metadata", new JSONObject(this.p.a()));
        }
        if (this.l.b()) {
            hashMap.put("cacheControl", b());
        }
        if (this.m.b()) {
            hashMap.put("contentDisposition", c());
        }
        if (this.n.b()) {
            hashMap.put("contentEncoding", d());
        }
        if (this.o.b()) {
            hashMap.put("contentLanguage", e());
        }
        return new JSONObject(hashMap);
    }

    private StorageMetadata(StorageMetadata storageMetadata, boolean z) {
        this.f18088a = null;
        this.f18089b = null;
        this.f18090c = null;
        this.f18091d = null;
        this.f18092e = null;
        this.f18093f = a.a("");
        this.f18094g = null;
        this.f18095h = null;
        this.i = null;
        this.k = null;
        this.l = a.a("");
        this.m = a.a("");
        this.n = a.a("");
        this.o = a.a("");
        this.p = a.a(Collections.emptyMap());
        Preconditions.a(storageMetadata);
        this.f18088a = storageMetadata.f18088a;
        this.f18089b = storageMetadata.f18089b;
        this.f18090c = storageMetadata.f18090c;
        this.f18091d = storageMetadata.f18091d;
        this.f18093f = storageMetadata.f18093f;
        this.l = storageMetadata.l;
        this.m = storageMetadata.m;
        this.n = storageMetadata.n;
        this.o = storageMetadata.o;
        this.p = storageMetadata.p;
        if (z) {
            this.k = storageMetadata.k;
            this.j = storageMetadata.j;
            this.i = storageMetadata.i;
            this.f18095h = storageMetadata.f18095h;
            this.f18094g = storageMetadata.f18094g;
            this.f18092e = storageMetadata.f18092e;
        }
    }
}

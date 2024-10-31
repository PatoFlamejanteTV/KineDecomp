package com.google.api.client.json;

import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class JsonObjectParser implements ObjectParser {

    /* renamed from: a */
    private final JsonFactory f14827a;

    /* renamed from: b */
    private final Set<String> f14828b;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        final JsonFactory f14829a;

        /* renamed from: b */
        Collection<String> f14830b = Sets.a();

        public Builder(JsonFactory jsonFactory) {
            Preconditions.a(jsonFactory);
            this.f14829a = jsonFactory;
        }

        public JsonObjectParser a() {
            return new JsonObjectParser(this);
        }

        public Builder a(Collection<String> collection) {
            this.f14830b = collection;
            return this;
        }
    }

    public JsonObjectParser(JsonFactory jsonFactory) {
        this(new Builder(jsonFactory));
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T a(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) a(inputStream, charset, (Type) cls);
    }

    public Set<String> b() {
        return Collections.unmodifiableSet(this.f14828b);
    }

    protected JsonObjectParser(Builder builder) {
        this.f14827a = builder.f14829a;
        this.f14828b = new HashSet(builder.f14830b);
    }

    public Object a(InputStream inputStream, Charset charset, Type type) throws IOException {
        JsonParser a2 = this.f14827a.a(inputStream, charset);
        a(a2);
        return a2.a(type, true);
    }

    public final JsonFactory a() {
        return this.f14827a;
    }

    private void a(JsonParser jsonParser) throws IOException {
        if (this.f14828b.isEmpty()) {
            return;
        }
        try {
            Preconditions.a((jsonParser.a(this.f14828b) == null || jsonParser.e() == JsonToken.END_OBJECT) ? false : true, "wrapper key(s) not found: %s", this.f14828b);
        } catch (Throwable th) {
            jsonParser.a();
            throw th;
        }
    }
}

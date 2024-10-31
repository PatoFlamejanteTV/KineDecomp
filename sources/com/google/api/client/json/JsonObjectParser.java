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

/* loaded from: classes.dex */
public class JsonObjectParser implements ObjectParser {

    /* renamed from: a, reason: collision with root package name */
    private final JsonFactory f2489a;
    private final Set<String> b;

    public JsonObjectParser(JsonFactory jsonFactory) {
        this(new Builder(jsonFactory));
    }

    protected JsonObjectParser(Builder builder) {
        this.f2489a = builder.f2490a;
        this.b = new HashSet(builder.b);
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T a(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) a(inputStream, charset, (Type) cls);
    }

    public Object a(InputStream inputStream, Charset charset, Type type) throws IOException {
        JsonParser a2 = this.f2489a.a(inputStream, charset);
        a(a2);
        return a2.a(type, true);
    }

    public final JsonFactory a() {
        return this.f2489a;
    }

    public Set<String> b() {
        return Collections.unmodifiableSet(this.b);
    }

    private void a(JsonParser jsonParser) throws IOException {
        if (!this.b.isEmpty()) {
            try {
                Preconditions.a((jsonParser.a(this.b) == null || jsonParser.c() == JsonToken.END_OBJECT) ? false : true, "wrapper key(s) not found: %s", this.b);
            } catch (Throwable th) {
                jsonParser.a();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        final JsonFactory f2490a;
        Collection<String> b = Sets.a();

        public Builder(JsonFactory jsonFactory) {
            this.f2490a = (JsonFactory) Preconditions.a(jsonFactory);
        }

        public JsonObjectParser a() {
            return new JsonObjectParser(this);
        }

        public Builder a(Collection<String> collection) {
            this.b = collection;
            return this;
        }
    }
}

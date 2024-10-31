package com.google.api.client.http.json;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class JsonHttpContent extends AbstractHttpContent {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2488a;
    private final JsonFactory b;
    private String c;

    public JsonHttpContent(JsonFactory jsonFactory, Object obj) {
        super("application/json; charset=UTF-8");
        this.b = (JsonFactory) Preconditions.a(jsonFactory);
        this.f2488a = Preconditions.a(obj);
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        JsonGenerator a2 = this.b.a(outputStream, c());
        if (this.c != null) {
            a2.f();
            a2.a(this.c);
        }
        a2.a(this.f2488a);
        if (this.c != null) {
            a2.c();
        }
        a2.a();
    }

    public JsonHttpContent a(String str) {
        this.c = str;
        return this;
    }
}

package com.google.api.client.http.json;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class JsonHttpContent extends AbstractHttpContent {

    /* renamed from: c */
    private final Object f14824c;

    /* renamed from: d */
    private final JsonFactory f14825d;

    /* renamed from: e */
    private String f14826e;

    public JsonHttpContent(JsonFactory jsonFactory, Object obj) {
        super("application/json; charset=UTF-8");
        Preconditions.a(jsonFactory);
        this.f14825d = jsonFactory;
        Preconditions.a(obj);
        this.f14824c = obj;
    }

    public JsonHttpContent a(String str) {
        this.f14826e = str;
        return this;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        JsonGenerator a2 = this.f14825d.a(outputStream, c());
        if (this.f14826e != null) {
            a2.g();
            a2.a(this.f14826e);
        }
        a2.a(this.f14824c);
        if (this.f14826e != null) {
            a2.d();
        }
        a2.b();
    }
}

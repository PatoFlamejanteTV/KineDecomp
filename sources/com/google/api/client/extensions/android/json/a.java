package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonWriter;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: AndroidJsonGenerator.java */
@Beta
@TargetApi(11)
/* loaded from: classes.dex */
class a extends JsonGenerator {

    /* renamed from: a, reason: collision with root package name */
    private final JsonWriter f2421a;
    private final AndroidJsonFactory b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AndroidJsonFactory androidJsonFactory, JsonWriter jsonWriter) {
        this.b = androidJsonFactory;
        this.f2421a = jsonWriter;
        jsonWriter.setLenient(true);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a() throws IOException {
        this.f2421a.flush();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(boolean z) throws IOException {
        this.f2421a.value(z);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b() throws IOException {
        this.f2421a.endArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void c() throws IOException {
        this.f2421a.endObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(String str) throws IOException {
        this.f2421a.name(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void d() throws IOException {
        this.f2421a.nullValue();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(int i) throws IOException {
        this.f2421a.value(i);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(long j) throws IOException {
        this.f2421a.value(j);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException {
        this.f2421a.value(bigInteger);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(double d) throws IOException {
        this.f2421a.value(d);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(float f) throws IOException {
        this.f2421a.value(f);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException {
        this.f2421a.value(bigDecimal);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void e() throws IOException {
        this.f2421a.beginArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void f() throws IOException {
        this.f2421a.beginObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b(String str) throws IOException {
        this.f2421a.value(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void g() throws IOException {
        this.f2421a.setIndent("  ");
    }
}

package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonWriter;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidJsonGenerator.java */
@Beta
@TargetApi(11)
/* loaded from: classes2.dex */
public class a extends JsonGenerator {

    /* renamed from: a */
    private final JsonWriter f14633a;

    /* renamed from: b */
    private final AndroidJsonFactory f14634b;

    public a(AndroidJsonFactory androidJsonFactory, JsonWriter jsonWriter) {
        this.f14634b = androidJsonFactory;
        this.f14633a = jsonWriter;
        jsonWriter.setLenient(true);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(boolean z) throws IOException {
        this.f14633a.value(z);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b() throws IOException {
        this.f14633a.flush();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void c() throws IOException {
        this.f14633a.endArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void d() throws IOException {
        this.f14633a.endObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void e() throws IOException {
        this.f14633a.nullValue();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void f() throws IOException {
        this.f14633a.beginArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void g() throws IOException {
        this.f14633a.beginObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(String str) throws IOException {
        this.f14633a.name(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b(String str) throws IOException {
        this.f14633a.value(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(int i) throws IOException {
        this.f14633a.value(i);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(long j) throws IOException {
        this.f14633a.value(j);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException {
        this.f14633a.value(bigInteger);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(double d2) throws IOException {
        this.f14633a.value(d2);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(float f2) throws IOException {
        this.f14633a.value(f2);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException {
        this.f14633a.value(bigDecimal);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a() throws IOException {
        this.f14633a.setIndent("  ");
    }
}

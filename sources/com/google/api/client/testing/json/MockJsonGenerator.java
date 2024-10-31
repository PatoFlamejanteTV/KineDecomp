package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Beta
/* loaded from: classes.dex */
public class MockJsonGenerator extends JsonGenerator {

    /* renamed from: a, reason: collision with root package name */
    private final JsonFactory f2513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MockJsonGenerator(JsonFactory jsonFactory) {
        this.f2513a = jsonFactory;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void e() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void f() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void c() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(String str) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void d() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b(String str) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(boolean z) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(int i) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(long j) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(float f) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(double d) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException {
    }
}

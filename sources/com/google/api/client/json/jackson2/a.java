package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: JacksonGenerator.java */
/* loaded from: classes.dex */
final class a extends JsonGenerator {

    /* renamed from: a, reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonGenerator f2495a;
    private final JacksonFactory b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonGenerator jsonGenerator) {
        this.b = jacksonFactory;
        this.f2495a = jsonGenerator;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a() throws IOException {
        this.f2495a.flush();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(boolean z) throws IOException {
        this.f2495a.a(z);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b() throws IOException {
        this.f2495a.d();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void c() throws IOException {
        this.f2495a.f();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(String str) throws IOException {
        this.f2495a.a(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void d() throws IOException {
        this.f2495a.g();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(int i) throws IOException {
        this.f2495a.b(i);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(long j) throws IOException {
        this.f2495a.a(j);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException {
        this.f2495a.a(bigInteger);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(double d) throws IOException {
        this.f2495a.a(d);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(float f) throws IOException {
        this.f2495a.a(f);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException {
        this.f2495a.a(bigDecimal);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void e() throws IOException {
        this.f2495a.c();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void f() throws IOException {
        this.f2495a.e();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b(String str) throws IOException {
        this.f2495a.b(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void g() throws IOException {
        this.f2495a.b();
    }
}

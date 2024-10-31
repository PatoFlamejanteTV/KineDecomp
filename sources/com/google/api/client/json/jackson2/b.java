package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: JacksonGenerator.java */
/* loaded from: classes2.dex */
final class b extends JsonGenerator {

    /* renamed from: a, reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonGenerator f14836a;

    /* renamed from: b, reason: collision with root package name */
    private final JacksonFactory f14837b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonGenerator jsonGenerator) {
        this.f14837b = jacksonFactory;
        this.f14836a = jsonGenerator;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(boolean z) throws IOException {
        this.f14836a.a(z);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b() throws IOException {
        this.f14836a.flush();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void c() throws IOException {
        this.f14836a.r();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void d() throws IOException {
        this.f14836a.s();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void e() throws IOException {
        this.f14836a.u();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void f() throws IOException {
        this.f14836a.v();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void g() throws IOException {
        this.f14836a.w();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(String str) throws IOException {
        this.f14836a.f(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void b(String str) throws IOException {
        this.f14836a.h(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(int i) throws IOException {
        this.f14836a.a(i);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(long j) throws IOException {
        this.f14836a.g(j);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException {
        this.f14836a.a(bigInteger);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(double d2) throws IOException {
        this.f14836a.a(d2);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(float f2) throws IOException {
        this.f14836a.a(f2);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException {
        this.f14836a.a(bigDecimal);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void a() throws IOException {
        this.f14836a.c();
    }
}

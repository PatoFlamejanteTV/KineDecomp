package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: JacksonParser.java */
/* loaded from: classes.dex */
final class b extends JsonParser {

    /* renamed from: a, reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonParser f2496a;
    private final JacksonFactory b;

    @Override // com.google.api.client.json.JsonParser
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public JacksonFactory d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonParser jsonParser) {
        this.b = jacksonFactory;
        this.f2496a = jsonParser;
    }

    @Override // com.google.api.client.json.JsonParser
    public void a() throws IOException {
        this.f2496a.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken n() throws IOException {
        return JacksonFactory.a(this.f2496a.a());
    }

    @Override // com.google.api.client.json.JsonParser
    public String b() throws IOException {
        return this.f2496a.d();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken c() {
        return JacksonFactory.a(this.f2496a.c());
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser o() throws IOException {
        this.f2496a.b();
        return this;
    }

    @Override // com.google.api.client.json.JsonParser
    public String m() throws IOException {
        return this.f2496a.f();
    }

    @Override // com.google.api.client.json.JsonParser
    public byte e() throws IOException {
        return this.f2496a.g();
    }

    @Override // com.google.api.client.json.JsonParser
    public float h() throws IOException {
        return this.f2496a.l();
    }

    @Override // com.google.api.client.json.JsonParser
    public int g() throws IOException {
        return this.f2496a.i();
    }

    @Override // com.google.api.client.json.JsonParser
    public short f() throws IOException {
        return this.f2496a.h();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger i() throws IOException {
        return this.f2496a.k();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal j() throws IOException {
        return this.f2496a.n();
    }

    @Override // com.google.api.client.json.JsonParser
    public double k() throws IOException {
        return this.f2496a.m();
    }

    @Override // com.google.api.client.json.JsonParser
    public long l() throws IOException {
        return this.f2496a.j();
    }
}

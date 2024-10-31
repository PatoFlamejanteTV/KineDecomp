package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: JacksonParser.java */
/* loaded from: classes2.dex */
final class c extends JsonParser {

    /* renamed from: c, reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonParser f14838c;

    /* renamed from: d, reason: collision with root package name */
    private final JacksonFactory f14839d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonParser jsonParser) {
        this.f14839d = jacksonFactory;
        this.f14838c = jsonParser;
    }

    @Override // com.google.api.client.json.JsonParser
    public void a() throws IOException {
        this.f14838c.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger b() throws IOException {
        return this.f14838c.a();
    }

    @Override // com.google.api.client.json.JsonParser
    public byte c() throws IOException {
        return this.f14838c.b();
    }

    @Override // com.google.api.client.json.JsonParser
    public String d() throws IOException {
        return this.f14838c.r();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken e() {
        return JacksonFactory.a(this.f14838c.s());
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal f() throws IOException {
        return this.f14838c.u();
    }

    @Override // com.google.api.client.json.JsonParser
    public double g() throws IOException {
        return this.f14838c.v();
    }

    @Override // com.google.api.client.json.JsonParser
    public float i() throws IOException {
        return this.f14838c.w();
    }

    @Override // com.google.api.client.json.JsonParser
    public int j() throws IOException {
        return this.f14838c.x();
    }

    @Override // com.google.api.client.json.JsonParser
    public long k() throws IOException {
        return this.f14838c.y();
    }

    @Override // com.google.api.client.json.JsonParser
    public short l() throws IOException {
        return this.f14838c.z();
    }

    @Override // com.google.api.client.json.JsonParser
    public String m() throws IOException {
        return this.f14838c.A();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken n() throws IOException {
        return JacksonFactory.a(this.f14838c.L());
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser o() throws IOException {
        this.f14838c.M();
        return this;
    }

    @Override // com.google.api.client.json.JsonParser
    public JacksonFactory h() {
        return this.f14839d;
    }
}

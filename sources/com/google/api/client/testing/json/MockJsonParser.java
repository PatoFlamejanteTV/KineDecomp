package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Beta
/* loaded from: classes2.dex */
public class MockJsonParser extends JsonParser {

    /* renamed from: c */
    private boolean f14878c;

    /* renamed from: d */
    private final JsonFactory f14879d;

    public MockJsonParser(JsonFactory jsonFactory) {
        this.f14879d = jsonFactory;
    }

    @Override // com.google.api.client.json.JsonParser
    public void a() throws IOException {
        this.f14878c = true;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger b() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public byte c() throws IOException {
        return (byte) 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public String d() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken e() {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal f() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public double g() throws IOException {
        return 0.0d;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonFactory h() {
        return this.f14879d;
    }

    @Override // com.google.api.client.json.JsonParser
    public float i() throws IOException {
        return 0.0f;
    }

    @Override // com.google.api.client.json.JsonParser
    public int j() throws IOException {
        return 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public long k() throws IOException {
        return 0L;
    }

    @Override // com.google.api.client.json.JsonParser
    public short l() throws IOException {
        return (short) 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public String m() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken n() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser o() throws IOException {
        return null;
    }
}

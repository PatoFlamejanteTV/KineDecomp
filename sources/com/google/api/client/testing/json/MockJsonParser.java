package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Beta
/* loaded from: classes.dex */
public class MockJsonParser extends JsonParser {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2514a;
    private final JsonFactory b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MockJsonParser(JsonFactory jsonFactory) {
        this.b = jsonFactory;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonFactory d() {
        return this.b;
    }

    @Override // com.google.api.client.json.JsonParser
    public void a() throws IOException {
        this.f2514a = true;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken n() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken c() {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public String b() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser o() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public String m() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public byte e() throws IOException {
        return (byte) 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public short f() throws IOException {
        return (short) 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public int g() throws IOException {
        return 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public float h() throws IOException {
        return 0.0f;
    }

    @Override // com.google.api.client.json.JsonParser
    public long l() throws IOException {
        return 0L;
    }

    @Override // com.google.api.client.json.JsonParser
    public double k() throws IOException {
        return 0.0d;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger i() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal j() throws IOException {
        return null;
    }
}

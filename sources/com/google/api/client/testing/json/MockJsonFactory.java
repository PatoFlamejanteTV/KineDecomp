package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;

@Beta
/* loaded from: classes.dex */
public class MockJsonFactory extends JsonFactory {
    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream) throws IOException {
        return new MockJsonParser(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream, Charset charset) throws IOException {
        return new MockJsonParser(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(String str) throws IOException {
        return new MockJsonParser(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(Reader reader) throws IOException {
        return new MockJsonParser(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonGenerator a(OutputStream outputStream, Charset charset) throws IOException {
        return new MockJsonGenerator(this);
    }
}

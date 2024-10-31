package com.google.api.client.json.jackson2;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class JacksonFactory extends JsonFactory {

    /* renamed from: a, reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonFactory f14834a = new com.fasterxml.jackson.core.JsonFactory();

    public JacksonFactory() {
        this.f14834a.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);
    }

    @Override // com.google.api.client.json.JsonFactory
    public com.google.api.client.json.JsonGenerator a(OutputStream outputStream, Charset charset) throws IOException {
        return new b(this, this.f14834a.createJsonGenerator(outputStream, JsonEncoding.UTF8));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(Reader reader) throws IOException {
        Preconditions.a(reader);
        return new c(this, this.f14834a.createJsonParser(reader));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream) throws IOException {
        Preconditions.a(inputStream);
        return new c(this, this.f14834a.createJsonParser(inputStream));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream, Charset charset) throws IOException {
        Preconditions.a(inputStream);
        return new c(this, this.f14834a.createJsonParser(inputStream));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(String str) throws IOException {
        Preconditions.a(str);
        return new c(this, this.f14834a.createJsonParser(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JsonToken a(com.fasterxml.jackson.core.JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (a.f14835a[jsonToken.ordinal()]) {
            case 1:
                return JsonToken.END_ARRAY;
            case 2:
                return JsonToken.START_ARRAY;
            case 3:
                return JsonToken.END_OBJECT;
            case 4:
                return JsonToken.START_OBJECT;
            case 5:
                return JsonToken.VALUE_FALSE;
            case 6:
                return JsonToken.VALUE_TRUE;
            case 7:
                return JsonToken.VALUE_NULL;
            case 8:
                return JsonToken.VALUE_STRING;
            case 9:
                return JsonToken.VALUE_NUMBER_FLOAT;
            case 10:
                return JsonToken.VALUE_NUMBER_INT;
            case 11:
                return JsonToken.FIELD_NAME;
            default:
                return JsonToken.NOT_AVAILABLE;
        }
    }
}

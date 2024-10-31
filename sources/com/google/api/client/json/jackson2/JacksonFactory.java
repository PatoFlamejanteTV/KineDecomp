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

/* loaded from: classes.dex */
public final class JacksonFactory extends JsonFactory {

    /* renamed from: a, reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonFactory f2493a = new com.fasterxml.jackson.core.JsonFactory();

    public JacksonFactory() {
        this.f2493a.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);
    }

    @Override // com.google.api.client.json.JsonFactory
    public com.google.api.client.json.JsonGenerator a(OutputStream outputStream, Charset charset) throws IOException {
        return new a(this, this.f2493a.createJsonGenerator(outputStream, JsonEncoding.UTF8));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(Reader reader) throws IOException {
        Preconditions.a(reader);
        return new b(this, this.f2493a.createJsonParser(reader));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream) throws IOException {
        Preconditions.a(inputStream);
        return new b(this, this.f2493a.createJsonParser(inputStream));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream, Charset charset) throws IOException {
        Preconditions.a(inputStream);
        return new b(this, this.f2493a.createJsonParser(inputStream));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(String str) throws IOException {
        Preconditions.a(str);
        return new b(this, this.f2493a.createJsonParser(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JsonToken a(com.fasterxml.jackson.core.JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (jsonToken) {
            case END_ARRAY:
                return JsonToken.END_ARRAY;
            case START_ARRAY:
                return JsonToken.START_ARRAY;
            case END_OBJECT:
                return JsonToken.END_OBJECT;
            case START_OBJECT:
                return JsonToken.START_OBJECT;
            case VALUE_FALSE:
                return JsonToken.VALUE_FALSE;
            case VALUE_TRUE:
                return JsonToken.VALUE_TRUE;
            case VALUE_NULL:
                return JsonToken.VALUE_NULL;
            case VALUE_STRING:
                return JsonToken.VALUE_STRING;
            case VALUE_NUMBER_FLOAT:
                return JsonToken.VALUE_NUMBER_FLOAT;
            case VALUE_NUMBER_INT:
                return JsonToken.VALUE_NUMBER_INT;
            case FIELD_NAME:
                return JsonToken.FIELD_NAME;
            default:
                return JsonToken.NOT_AVAILABLE;
        }
    }
}

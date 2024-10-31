package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.api.client.extensions.android.AndroidUtils;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Charsets;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

@Beta
@TargetApi(11)
/* loaded from: classes.dex */
public class AndroidJsonFactory extends JsonFactory {

    @Beta
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static final AndroidJsonFactory f2420a = new AndroidJsonFactory();
    }

    public static AndroidJsonFactory a() {
        return a.f2420a;
    }

    public AndroidJsonFactory() {
        AndroidUtils.b(11);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream) {
        return a((Reader) new InputStreamReader(inputStream, Charsets.f2530a));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream, Charset charset) {
        return charset == null ? a(inputStream) : a((Reader) new InputStreamReader(inputStream, charset));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(String str) {
        return a((Reader) new StringReader(str));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(Reader reader) {
        return new b(this, new JsonReader(reader));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonGenerator a(OutputStream outputStream, Charset charset) {
        return a((Writer) new OutputStreamWriter(outputStream, charset));
    }

    public JsonGenerator a(Writer writer) {
        return new com.google.api.client.extensions.android.json.a(this, new JsonWriter(writer));
    }
}

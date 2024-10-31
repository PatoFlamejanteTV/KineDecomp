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
/* loaded from: classes2.dex */
public class AndroidJsonFactory extends JsonFactory {
    public AndroidJsonFactory() {
        AndroidUtils.a(11);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream) {
        return a((Reader) new InputStreamReader(inputStream, Charsets.f14915a));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(InputStream inputStream, Charset charset) {
        if (charset == null) {
            return a(inputStream);
        }
        return a((Reader) new InputStreamReader(inputStream, charset));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(String str) {
        return a((Reader) new StringReader(str));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser a(Reader reader) {
        return new c(this, new JsonReader(reader));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonGenerator a(OutputStream outputStream, Charset charset) {
        return a((Writer) new OutputStreamWriter(outputStream, charset));
    }

    public JsonGenerator a(Writer writer) {
        return new a(this, new JsonWriter(writer));
    }
}

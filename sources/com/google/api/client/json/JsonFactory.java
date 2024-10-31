package com.google.api.client.json;

import com.google.api.client.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public abstract class JsonFactory {
    public abstract JsonGenerator a(OutputStream outputStream, Charset charset) throws IOException;

    public abstract JsonParser a(InputStream inputStream) throws IOException;

    public abstract JsonParser a(InputStream inputStream, Charset charset) throws IOException;

    public abstract JsonParser a(Reader reader) throws IOException;

    public abstract JsonParser a(String str) throws IOException;

    public final String a(Object obj) throws IOException {
        return a(obj, false);
    }

    public final String b(Object obj) throws IOException {
        return a(obj, true);
    }

    public final byte[] c(Object obj) throws IOException {
        return b(obj, false).toByteArray();
    }

    private String a(Object obj, boolean z) throws IOException {
        return b(obj, z).toString(Keyczar.DEFAULT_ENCODING);
    }

    private ByteArrayOutputStream b(Object obj, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonGenerator a2 = a(byteArrayOutputStream, Charsets.f2530a);
        if (z) {
            a2.g();
        }
        a2.a(obj);
        a2.a();
        return byteArrayOutputStream;
    }

    public final <T> T a(InputStream inputStream, Class<T> cls) throws IOException {
        return (T) a(inputStream).a(cls);
    }

    public final <T> T a(Reader reader, Class<T> cls) throws IOException {
        return (T) a(reader).a(cls);
    }
}

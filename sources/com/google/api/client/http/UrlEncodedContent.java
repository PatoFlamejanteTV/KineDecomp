package com.google.api.client.http;

import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class UrlEncodedContent extends AbstractHttpContent {

    /* renamed from: c, reason: collision with root package name */
    private Object f14800c;

    public UrlEncodedContent(Object obj) {
        super(UrlEncodedParser.f14801a);
        a(obj);
    }

    public UrlEncodedContent a(Object obj) {
        Preconditions.a(obj);
        this.f14800c = obj;
        return this;
    }

    public final Object e() {
        return this.f14800c;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, c()));
        boolean z = true;
        for (Map.Entry<String, Object> entry : Data.d(this.f14800c).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String b2 = CharEscapers.b(entry.getKey());
                Class<?> cls = value.getClass();
                if (!(value instanceof Iterable) && !cls.isArray()) {
                    z = a(z, bufferedWriter, b2, value);
                } else {
                    Iterator it = Types.a(value).iterator();
                    while (it.hasNext()) {
                        z = a(z, bufferedWriter, b2, it.next());
                    }
                }
            }
        }
        bufferedWriter.flush();
    }

    public static UrlEncodedContent a(HttpRequest httpRequest) {
        HttpContent b2 = httpRequest.b();
        if (b2 != null) {
            return (UrlEncodedContent) b2;
        }
        UrlEncodedContent urlEncodedContent = new UrlEncodedContent(new HashMap());
        httpRequest.a(urlEncodedContent);
        return urlEncodedContent;
    }

    private static boolean a(boolean z, Writer writer, String str, Object obj) throws IOException {
        if (obj != null && !Data.b(obj)) {
            if (z) {
                z = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            String b2 = CharEscapers.b(obj instanceof Enum ? FieldInfo.a((Enum<?>) obj).d() : obj.toString());
            if (b2.length() != 0) {
                writer.write("=");
                writer.write(b2);
            }
        }
        return z;
    }
}

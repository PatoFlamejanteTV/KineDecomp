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

/* loaded from: classes.dex */
public class UrlEncodedContent extends AbstractHttpContent {

    /* renamed from: a */
    private Object f2475a;

    public UrlEncodedContent(Object obj) {
        super(UrlEncodedParser.f2476a);
        a(obj);
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, c()));
        boolean z = true;
        Iterator<Map.Entry<String, Object>> it = Data.b(this.f2475a).entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                Object value = next.getValue();
                if (value != null) {
                    String a2 = CharEscapers.a(next.getKey());
                    Class<?> cls = value.getClass();
                    if ((value instanceof Iterable) || cls.isArray()) {
                        Iterator it2 = Types.a(value).iterator();
                        while (it2.hasNext()) {
                            z2 = a(z2, bufferedWriter, a2, it2.next());
                        }
                    } else {
                        z2 = a(z2, bufferedWriter, a2, value);
                    }
                }
                z = z2;
            } else {
                bufferedWriter.flush();
                return;
            }
        }
    }

    public final Object g() {
        return this.f2475a;
    }

    public UrlEncodedContent a(Object obj) {
        this.f2475a = Preconditions.a(obj);
        return this;
    }

    public static UrlEncodedContent a(HttpRequest httpRequest) {
        HttpContent d = httpRequest.d();
        if (d != null) {
            return (UrlEncodedContent) d;
        }
        UrlEncodedContent urlEncodedContent = new UrlEncodedContent(new HashMap());
        httpRequest.a(urlEncodedContent);
        return urlEncodedContent;
    }

    private static boolean a(boolean z, Writer writer, String str, Object obj) throws IOException {
        if (obj != null && !Data.a(obj)) {
            if (z) {
                z = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            String a2 = CharEscapers.a(obj instanceof Enum ? FieldInfo.a((Enum<?>) obj).b() : obj.toString());
            if (a2.length() != 0) {
                writer.write("=");
                writer.write(a2);
            }
        }
        return z;
    }
}

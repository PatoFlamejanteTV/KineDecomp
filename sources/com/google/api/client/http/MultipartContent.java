package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MultipartContent extends AbstractHttpContent {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Part> f2472a;

    public MultipartContent() {
        super(new HttpMediaType("multipart/related").a("boundary", "__END_OF_PART__"));
        this.f2472a = new ArrayList<>();
    }

    @Override // com.google.api.client.util.StreamingContent
    public void a(OutputStream outputStream) throws IOException {
        StreamingContent streamingContent;
        long a2;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, c());
        String g = g();
        Iterator<Part> it = this.f2472a.iterator();
        while (it.hasNext()) {
            Part next = it.next();
            HttpHeaders a3 = new HttpHeaders().a((String) null);
            if (next.b != null) {
                a3.a(next.b);
            }
            a3.c(null).l(null).e(null).a((Long) null).set("Content-Transfer-Encoding", (Object) null);
            HttpContent httpContent = next.f2473a;
            if (httpContent != null) {
                a3.set("Content-Transfer-Encoding", Arrays.asList("binary"));
                a3.e(httpContent.d());
                HttpEncoding httpEncoding = next.c;
                if (httpEncoding == null) {
                    a2 = httpContent.a();
                    streamingContent = httpContent;
                } else {
                    a3.c(httpEncoding.a());
                    streamingContent = new HttpEncodingStreamingContent(httpContent, httpEncoding);
                    a2 = AbstractHttpContent.a(httpContent);
                }
                if (a2 != -1) {
                    a3.a(Long.valueOf(a2));
                }
            } else {
                streamingContent = null;
            }
            outputStreamWriter.write("--");
            outputStreamWriter.write(g);
            outputStreamWriter.write("\r\n");
            HttpHeaders.a(a3, null, null, outputStreamWriter);
            if (streamingContent != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                streamingContent.a(outputStream);
                outputStreamWriter.write("\r\n");
            }
        }
        outputStreamWriter.write("--");
        outputStreamWriter.write(g);
        outputStreamWriter.write("--");
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }

    @Override // com.google.api.client.http.AbstractHttpContent, com.google.api.client.http.HttpContent
    public boolean f() {
        Iterator<Part> it = this.f2472a.iterator();
        while (it.hasNext()) {
            if (!it.next().f2473a.f()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultipartContent a(Part part) {
        this.f2472a.add(Preconditions.a(part));
        return this;
    }

    public MultipartContent a(Collection<? extends HttpContent> collection) {
        this.f2472a = new ArrayList<>(collection.size());
        Iterator<? extends HttpContent> it = collection.iterator();
        while (it.hasNext()) {
            a(new Part(it.next()));
        }
        return this;
    }

    public final String g() {
        return b().c("boundary");
    }

    /* loaded from: classes.dex */
    public static final class Part {

        /* renamed from: a, reason: collision with root package name */
        HttpContent f2473a;
        HttpHeaders b;
        HttpEncoding c;

        public Part() {
            this(null);
        }

        public Part(HttpContent httpContent) {
            this(null, httpContent);
        }

        public Part(HttpHeaders httpHeaders, HttpContent httpContent) {
            a(httpHeaders);
            a(httpContent);
        }

        public Part a(HttpContent httpContent) {
            this.f2473a = httpContent;
            return this;
        }

        public Part a(HttpHeaders httpHeaders) {
            this.b = httpHeaders;
            return this;
        }
    }
}

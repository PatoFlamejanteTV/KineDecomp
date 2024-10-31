package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MultipartContent extends AbstractHttpContent {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Part> f14795c;

    /* loaded from: classes2.dex */
    public static final class Part {

        /* renamed from: a, reason: collision with root package name */
        HttpContent f14796a;

        /* renamed from: b, reason: collision with root package name */
        HttpHeaders f14797b;

        /* renamed from: c, reason: collision with root package name */
        HttpEncoding f14798c;

        public Part() {
            this(null);
        }

        public Part a(HttpContent httpContent) {
            this.f14796a = httpContent;
            return this;
        }

        public Part(HttpContent httpContent) {
            this(null, httpContent);
        }

        public Part a(HttpHeaders httpHeaders) {
            this.f14797b = httpHeaders;
            return this;
        }

        public Part(HttpHeaders httpHeaders, HttpContent httpContent) {
            a(httpHeaders);
            a(httpContent);
        }
    }

    public MultipartContent() {
        super(new HttpMediaType("multipart/related").b("boundary", "__END_OF_PART__"));
        this.f14795c = new ArrayList<>();
    }

    @Override // com.google.api.client.http.AbstractHttpContent, com.google.api.client.http.HttpContent
    public boolean a() {
        Iterator<Part> it = this.f14795c.iterator();
        while (it.hasNext()) {
            if (!it.next().f14796a.a()) {
                return false;
            }
        }
        return true;
    }

    public final String e() {
        return d().a("boundary");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.google.api.client.http.HttpEncodingStreamingContent] */
    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        long j;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, c());
        String e2 = e();
        Iterator<Part> it = this.f14795c.iterator();
        while (it.hasNext()) {
            Part next = it.next();
            HttpHeaders a2 = new HttpHeaders().a((String) null);
            HttpHeaders httpHeaders = next.f14797b;
            if (httpHeaders != null) {
                a2.a(httpHeaders);
            }
            a2.c(null).k(null).setContentType(null).a((Long) null).set("Content-Transfer-Encoding", (Object) null);
            HttpContent httpContent = next.f14796a;
            if (httpContent != null) {
                a2.set("Content-Transfer-Encoding", (Object) Arrays.asList("binary"));
                a2.setContentType(httpContent.getType());
                HttpEncoding httpEncoding = next.f14798c;
                if (httpEncoding == null) {
                    j = httpContent.getLength();
                } else {
                    a2.c(httpEncoding.getName());
                    ?? httpEncodingStreamingContent = new HttpEncodingStreamingContent(httpContent, httpEncoding);
                    long a3 = AbstractHttpContent.a(httpContent);
                    httpContent = httpEncodingStreamingContent;
                    j = a3;
                }
                if (j != -1) {
                    a2.a(Long.valueOf(j));
                }
            } else {
                httpContent = null;
            }
            outputStreamWriter.write("--");
            outputStreamWriter.write(e2);
            outputStreamWriter.write("\r\n");
            HttpHeaders.a(a2, null, null, outputStreamWriter);
            if (httpContent != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                httpContent.writeTo(outputStream);
            }
            outputStreamWriter.write("\r\n");
        }
        outputStreamWriter.write("--");
        outputStreamWriter.write(e2);
        outputStreamWriter.write("--");
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }

    public MultipartContent a(Part part) {
        ArrayList<Part> arrayList = this.f14795c;
        Preconditions.a(part);
        arrayList.add(part);
        return this;
    }

    public MultipartContent a(Collection<? extends HttpContent> collection) {
        this.f14795c = new ArrayList<>(collection.size());
        Iterator<? extends HttpContent> it = collection.iterator();
        while (it.hasNext()) {
            a(new Part(it.next()));
        }
        return this;
    }
}

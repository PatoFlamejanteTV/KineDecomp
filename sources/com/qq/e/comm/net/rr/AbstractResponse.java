package com.qq.e.comm.net.rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;

/* loaded from: classes3.dex */
public abstract class AbstractResponse implements Response {

    /* renamed from: a */
    private final HttpResponse f25035a;

    /* renamed from: b */
    private final HttpUriRequest f25036b;

    public AbstractResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        this.f25035a = httpResponse;
        this.f25036b = httpUriRequest;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public void close() throws IllegalStateException, IOException {
        HttpUriRequest httpUriRequest = this.f25036b;
        if (httpUriRequest != null && !httpUriRequest.isAborted()) {
            this.f25036b.abort();
        }
        HttpResponse httpResponse = this.f25035a;
        if (httpResponse != null) {
            httpResponse.getEntity().getContent().close();
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public int getStatusCode() {
        return this.f25035a.getStatusLine().getStatusCode();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public InputStream getStreamContent() throws IllegalStateException, IOException {
        InputStream content = this.f25035a.getEntity().getContent();
        Header contentEncoding = this.f25035a.getEntity().getContentEncoding();
        return (contentEncoding == null || !contentEncoding.getValue().contains("gzip")) ? content : new GZIPInputStream(content);
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent() throws IOException {
        return getStringContent("UTF-8");
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent(String str) throws IOException {
        byte[] bytesContent = getBytesContent();
        String str2 = null;
        if (bytesContent == null) {
            return null;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str2 = EntityUtils.getContentCharSet(this.f25035a.getEntity());
        } catch (Throwable unused) {
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}

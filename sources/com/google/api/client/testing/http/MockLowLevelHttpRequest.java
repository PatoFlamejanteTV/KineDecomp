package com.google.api.client.testing.http;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@Beta
/* loaded from: classes2.dex */
public class MockLowLevelHttpRequest extends LowLevelHttpRequest {

    /* renamed from: e */
    private String f14857e;

    /* renamed from: f */
    private final Map<String, List<String>> f14858f = new HashMap();

    /* renamed from: g */
    private MockLowLevelHttpResponse f14859g = new MockLowLevelHttpResponse();

    public MockLowLevelHttpRequest() {
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(String str, String str2) throws IOException {
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> list = this.f14858f.get(lowerCase);
        if (list == null) {
            list = new ArrayList<>();
            this.f14858f.put(lowerCase, list);
        }
        list.add(str2);
    }

    public String c(String str) {
        List<String> list = this.f14858f.get(str.toLowerCase(Locale.US));
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    public String f() throws IOException {
        Charset charset;
        if (e() == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e().writeTo(byteArrayOutputStream);
        String b2 = b();
        if (b2 != null && b2.contains("gzip")) {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.a((InputStream) gZIPInputStream, (OutputStream) byteArrayOutputStream);
        }
        String d2 = d();
        HttpMediaType httpMediaType = d2 != null ? new HttpMediaType(d2) : null;
        if (httpMediaType != null && httpMediaType.b() != null) {
            charset = httpMediaType.b();
        } else {
            charset = Charsets.f14916b;
        }
        return byteArrayOutputStream.toString(charset.name());
    }

    public MockLowLevelHttpRequest(String str) {
        this.f14857e = str;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        return this.f14859g;
    }

    public MockLowLevelHttpRequest a(MockLowLevelHttpResponse mockLowLevelHttpResponse) {
        this.f14859g = mockLowLevelHttpResponse;
        return this;
    }
}

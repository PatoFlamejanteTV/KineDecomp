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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@Beta
/* loaded from: classes.dex */
public class MockLowLevelHttpRequest extends LowLevelHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f2510a;
    private final Map<String, List<String>> b = new HashMap();
    private MockLowLevelHttpResponse c = new MockLowLevelHttpResponse();

    public MockLowLevelHttpRequest() {
    }

    public MockLowLevelHttpRequest(String str) {
        this.f2510a = str;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void a(String str, String str2) throws IOException {
        String lowerCase = str.toLowerCase();
        List<String> list = this.b.get(lowerCase);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(lowerCase, list);
        }
        list.add(str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        return this.c;
    }

    public String c(String str) {
        List<String> list = this.b.get(str.toLowerCase());
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    public String f() throws IOException {
        if (e() == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e().a(byteArrayOutputStream);
        String c = c();
        if (c != null && c.contains("gzip")) {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.a((InputStream) gZIPInputStream, (OutputStream) byteArrayOutputStream);
        }
        String d = d();
        HttpMediaType httpMediaType = d != null ? new HttpMediaType(d) : null;
        return byteArrayOutputStream.toString(((httpMediaType == null || httpMediaType.d() == null) ? Charsets.b : httpMediaType.d()).name());
    }

    public MockLowLevelHttpRequest a(MockLowLevelHttpResponse mockLowLevelHttpResponse) {
        this.c = mockLowLevelHttpResponse;
        return this;
    }
}

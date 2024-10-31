package com.google.api.client.testing.http;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.util.TestableByteArrayInputStream;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Beta
/* loaded from: classes.dex */
public class MockLowLevelHttpResponse extends LowLevelHttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f2511a;
    private String b;
    private String d;
    private String g;
    private boolean i;
    private int c = 200;
    private List<String> e = new ArrayList();
    private List<String> f = new ArrayList();
    private long h = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public MockLowLevelHttpResponse a(String str, String str2) {
        this.e.add(Preconditions.a(str));
        this.f.add(Preconditions.a(str2));
        return this;
    }

    public MockLowLevelHttpResponse a(String str) {
        return str == null ? i() : a(StringUtils.a(str));
    }

    public MockLowLevelHttpResponse a(byte[] bArr) {
        if (bArr == null) {
            return i();
        }
        this.f2511a = new TestableByteArrayInputStream(bArr);
        a(bArr.length);
        return this;
    }

    public MockLowLevelHttpResponse i() {
        this.f2511a = null;
        a(0L);
        return this;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream a() throws IOException {
        return this.f2511a;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b() {
        return this.g;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public final String c() {
        return this.b;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int g() {
        return this.e.size();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String a(int i) {
        return this.e.get(i);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b(int i) {
        return this.f.get(i);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String f() {
        return this.d;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int e() {
        return this.c;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        if (this.d != null) {
            sb.append(this.d);
        }
        return sb.toString();
    }

    public MockLowLevelHttpResponse b(String str) {
        this.b = str;
        return this;
    }

    public MockLowLevelHttpResponse a(long j) {
        this.h = j;
        Preconditions.a(j >= -1);
        return this;
    }

    public MockLowLevelHttpResponse c(int i) {
        this.c = i;
        return this;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void h() throws IOException {
        this.i = true;
        super.h();
    }
}

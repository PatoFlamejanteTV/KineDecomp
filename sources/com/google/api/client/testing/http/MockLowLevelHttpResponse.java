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
/* loaded from: classes2.dex */
public class MockLowLevelHttpResponse extends LowLevelHttpResponse {

    /* renamed from: a */
    private InputStream f14860a;

    /* renamed from: b */
    private String f14861b;

    /* renamed from: d */
    private String f14863d;

    /* renamed from: g */
    private String f14866g;
    private boolean i;

    /* renamed from: c */
    private int f14862c = 200;

    /* renamed from: e */
    private List<String> f14864e = new ArrayList();

    /* renamed from: f */
    private List<String> f14865f = new ArrayList();

    /* renamed from: h */
    private long f14867h = -1;

    public MockLowLevelHttpResponse a(String str, String str2) {
        List<String> list = this.f14864e;
        Preconditions.a(str);
        list.add(str);
        List<String> list2 = this.f14865f;
        Preconditions.a(str2);
        list2.add(str2);
        return this;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream b() throws IOException {
        return this.f14860a;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String c() {
        return this.f14866g;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public final String d() {
        return this.f14861b;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int e() {
        return this.f14864e.size();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String f() {
        return this.f14863d;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int g() {
        return this.f14862c;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String h() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14862c);
        String str = this.f14863d;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public MockLowLevelHttpResponse i() {
        this.f14860a = null;
        a(0L);
        return this;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b(int i) {
        return this.f14865f.get(i);
    }

    public MockLowLevelHttpResponse c(int i) {
        this.f14862c = i;
        return this;
    }

    public MockLowLevelHttpResponse a(String str) {
        if (str == null) {
            return i();
        }
        return a(StringUtils.a(str));
    }

    public MockLowLevelHttpResponse b(String str) {
        this.f14861b = str;
        return this;
    }

    public MockLowLevelHttpResponse a(byte[] bArr) {
        if (bArr == null) {
            return i();
        }
        this.f14860a = new TestableByteArrayInputStream(bArr);
        a(bArr.length);
        return this;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String a(int i) {
        return this.f14864e.get(i);
    }

    public MockLowLevelHttpResponse a(long j) {
        this.f14867h = j;
        Preconditions.a(j >= -1);
        return this;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void a() throws IOException {
        this.i = true;
        super.a();
    }
}

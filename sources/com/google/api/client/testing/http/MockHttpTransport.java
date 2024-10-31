package com.google.api.client.testing.http;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public class MockHttpTransport extends HttpTransport {

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f14852a;

    /* renamed from: b, reason: collision with root package name */
    private MockLowLevelHttpRequest f14853b;

    /* renamed from: c, reason: collision with root package name */
    private MockLowLevelHttpResponse f14854c;

    @Beta
    /* loaded from: classes2.dex */
    public static class Builder {
    }

    @Override // com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        Preconditions.a(supportsMethod(str), "HTTP method %s not supported", str);
        MockLowLevelHttpRequest mockLowLevelHttpRequest = this.f14853b;
        if (mockLowLevelHttpRequest != null) {
            return mockLowLevelHttpRequest;
        }
        this.f14853b = new MockLowLevelHttpRequest(str2);
        MockLowLevelHttpResponse mockLowLevelHttpResponse = this.f14854c;
        if (mockLowLevelHttpResponse != null) {
            this.f14853b.a(mockLowLevelHttpResponse);
        }
        return this.f14853b;
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) throws IOException {
        Set<String> set = this.f14852a;
        return set == null || set.contains(str);
    }
}

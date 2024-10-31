package com.google.api.client.testing.http;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Set;

@Beta
/* loaded from: classes.dex */
public class MockHttpTransport extends HttpTransport {

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f2508a;
    private MockLowLevelHttpRequest b;
    private MockLowLevelHttpResponse c;

    @Beta
    /* loaded from: classes.dex */
    public static class Builder {
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) throws IOException {
        return this.f2508a == null || this.f2508a.contains(str);
    }

    @Override // com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        Preconditions.a(supportsMethod(str), "HTTP method %s not supported", str);
        if (this.b != null) {
            return this.b;
        }
        MockLowLevelHttpRequest mockLowLevelHttpRequest = new MockLowLevelHttpRequest(str2);
        if (this.c != null) {
            mockLowLevelHttpRequest.a(this.c);
            return mockLowLevelHttpRequest;
        }
        return mockLowLevelHttpRequest;
    }
}

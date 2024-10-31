package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;

/* compiled from: MockMetadataServerTransport.java */
/* loaded from: classes.dex */
class b extends MockLowLevelHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MockMetadataServerTransport f2448a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MockMetadataServerTransport mockMetadataServerTransport, String str) {
        super(str);
        this.f2448a = mockMetadataServerTransport;
    }

    @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() {
        MockLowLevelHttpResponse mockLowLevelHttpResponse = new MockLowLevelHttpResponse();
        mockLowLevelHttpResponse.a("Metadata-Flavor", "Google");
        return mockLowLevelHttpResponse;
    }
}

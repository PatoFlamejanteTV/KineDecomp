package com.google.api.client.http.apache;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

/* compiled from: ContentEntity.java */
/* loaded from: classes2.dex */
final class c extends AbstractHttpEntity {

    /* renamed from: a */
    private final long f14808a;

    /* renamed from: b */
    private final StreamingContent f14809b;

    public c(long j, StreamingContent streamingContent) {
        this.f14808a = j;
        Preconditions.a(streamingContent);
        this.f14809b = streamingContent;
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.f14808a;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.f14808a != 0) {
            this.f14809b.writeTo(outputStream);
        }
    }
}

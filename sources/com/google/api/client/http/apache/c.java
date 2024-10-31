package com.google.api.client.http.apache;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import org.apache.http.entity.AbstractHttpEntity;

/* compiled from: ContentEntity.java */
/* loaded from: classes.dex */
final class c extends AbstractHttpEntity {

    /* renamed from: a, reason: collision with root package name */
    private final long f2480a;
    private final StreamingContent b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(long j, StreamingContent streamingContent) {
        this.f2480a = j;
        this.b = (StreamingContent) Preconditions.a(streamingContent);
    }
}

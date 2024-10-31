package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.AbstractMessageLite;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class ia implements Callable {

    /* renamed from: a */
    private final ProtoStorageClient f17865a;

    /* renamed from: b */
    private final AbstractMessageLite f17866b;

    private ia(ProtoStorageClient protoStorageClient, AbstractMessageLite abstractMessageLite) {
        this.f17865a = protoStorageClient;
        this.f17866b = abstractMessageLite;
    }

    public static Callable a(ProtoStorageClient protoStorageClient, AbstractMessageLite abstractMessageLite) {
        return new ia(protoStorageClient, abstractMessageLite);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        ProtoStorageClient protoStorageClient = this.f17865a;
        AbstractMessageLite abstractMessageLite = this.f17866b;
        ProtoStorageClient.a(protoStorageClient, abstractMessageLite);
        return abstractMessageLite;
    }
}

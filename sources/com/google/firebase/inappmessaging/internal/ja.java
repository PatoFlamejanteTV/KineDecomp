package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.Parser;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class ja implements Callable {

    /* renamed from: a */
    private final ProtoStorageClient f17969a;

    /* renamed from: b */
    private final Parser f17970b;

    private ja(ProtoStorageClient protoStorageClient, Parser parser) {
        this.f17969a = protoStorageClient;
        this.f17970b = parser;
    }

    public static Callable a(ProtoStorageClient protoStorageClient, Parser parser) {
        return new ja(protoStorageClient, parser);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return ProtoStorageClient.a(this.f17969a, this.f17970b);
    }
}

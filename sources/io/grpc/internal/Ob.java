package io.grpc.internal;

import io.grpc.internal.MessageDeframer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageDeframer.java */
/* loaded from: classes3.dex */
public /* synthetic */ class Ob {

    /* renamed from: a */
    static final /* synthetic */ int[] f27461a = new int[MessageDeframer.State.values().length];

    static {
        try {
            f27461a[MessageDeframer.State.HEADER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f27461a[MessageDeframer.State.BODY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

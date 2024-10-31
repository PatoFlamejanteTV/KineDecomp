package com.squareup.okhttp.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/* compiled from: FrameWriter.java */
/* renamed from: com.squareup.okhttp.internal.framed.b */
/* loaded from: classes3.dex */
public interface InterfaceC2385b extends Closeable {
    void a(int i, int i2, List<q> list) throws IOException;

    void a(int i, long j) throws IOException;

    void a(int i, ErrorCode errorCode) throws IOException;

    void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException;

    void a(A a2) throws IOException;

    void a(boolean z, int i, int i2) throws IOException;

    void a(boolean z, int i, okio.g gVar, int i2) throws IOException;

    void a(boolean z, boolean z2, int i, int i2, List<q> list) throws IOException;

    void b(A a2) throws IOException;

    void flush() throws IOException;

    void q() throws IOException;

    int t();
}

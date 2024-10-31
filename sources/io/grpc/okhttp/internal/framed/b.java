package io.grpc.okhttp.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/* compiled from: FrameWriter.java */
/* loaded from: classes3.dex */
public interface b extends Closeable {
    void a(int i, long j) throws IOException;

    void a(int i, ErrorCode errorCode) throws IOException;

    void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException;

    void a(g gVar) throws IOException;

    void a(boolean z, int i, int i2) throws IOException;

    void a(boolean z, int i, okio.g gVar, int i2) throws IOException;

    void a(boolean z, boolean z2, int i, int i2, List<c> list) throws IOException;

    void b(g gVar) throws IOException;

    void flush() throws IOException;

    void q() throws IOException;

    int t();
}

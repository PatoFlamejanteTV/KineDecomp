package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.java */
/* loaded from: classes3.dex */
public interface h extends y, WritableByteChannel {
    long a(z zVar) throws IOException;

    h a(String str) throws IOException;

    h a(ByteString byteString) throws IOException;

    g d();

    h d(long j) throws IOException;

    h f() throws IOException;

    h f(long j) throws IOException;

    @Override // okio.y, java.io.Flushable
    void flush() throws IOException;

    h g() throws IOException;

    h write(byte[] bArr) throws IOException;

    h write(byte[] bArr, int i, int i2) throws IOException;

    h writeByte(int i) throws IOException;

    h writeInt(int i) throws IOException;

    h writeShort(int i) throws IOException;
}

package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.java */
/* loaded from: classes3.dex */
public interface i extends z, ReadableByteChannel {
    long a(byte b2) throws IOException;

    long a(y yVar) throws IOException;

    String a(long j) throws IOException;

    String a(long j, Charset charset) throws IOException;

    boolean a(long j, ByteString byteString) throws IOException;

    byte[] b(long j) throws IOException;

    void c(long j) throws IOException;

    g d();

    ByteString e(long j) throws IOException;

    String h() throws IOException;

    short i() throws IOException;

    long j() throws IOException;

    byte[] k() throws IOException;

    boolean l() throws IOException;

    long m() throws IOException;

    int n() throws IOException;

    long o() throws IOException;

    InputStream p();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j) throws IOException;
}

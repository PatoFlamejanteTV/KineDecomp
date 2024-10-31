package okio;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.java */
/* loaded from: classes.dex */
public interface d extends k {
    String a(long j, Charset charset) throws IOException;

    void a(long j) throws IOException;

    ByteString b(long j) throws IOException;

    boolean b() throws IOException;

    byte c() throws IOException;

    void d(long j) throws IOException;

    int f() throws IOException;

    long g() throws IOException;
}

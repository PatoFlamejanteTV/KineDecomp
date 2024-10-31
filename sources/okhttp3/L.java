package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.ByteString;

/* compiled from: RequestBody.java */
/* loaded from: classes3.dex */
public abstract class L {
    public static L a(@Nullable C c2, String str) {
        Charset charset = okhttp3.a.e.j;
        if (c2 != null && (charset = c2.a()) == null) {
            charset = okhttp3.a.e.j;
            c2 = C.b(c2 + "; charset=utf-8");
        }
        return a(c2, str.getBytes(charset));
    }

    public long a() throws IOException {
        return -1L;
    }

    public abstract void a(okio.h hVar) throws IOException;

    @Nullable
    public abstract C b();

    public static L a(@Nullable C c2, ByteString byteString) {
        return new J(c2, byteString);
    }

    public static L a(@Nullable C c2, byte[] bArr) {
        return a(c2, bArr, 0, bArr.length);
    }

    public static L a(@Nullable C c2, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            okhttp3.a.e.a(bArr.length, i, i2);
            return new K(c2, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }
}

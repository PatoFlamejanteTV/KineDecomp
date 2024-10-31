package okio;

import java.io.InputStream;
import java.util.logging.Logger;

/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f4931a = Logger.getLogger(e.class.getName());

    private e() {
    }

    public static d a(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        return new g(kVar);
    }

    public static k a(InputStream inputStream) {
        return a(inputStream, new l());
    }

    private static k a(InputStream inputStream, l lVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (lVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new f(lVar, inputStream);
    }
}

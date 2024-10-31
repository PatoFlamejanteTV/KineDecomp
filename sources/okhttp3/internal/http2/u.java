package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes3.dex */
public interface u {

    /* renamed from: a */
    public static final u f29155a = new t();

    void a(int i, ErrorCode errorCode);

    boolean a(int i, List<a> list);

    boolean a(int i, List<a> list, boolean z);

    boolean a(int i, okio.i iVar, int i2, boolean z) throws IOException;
}

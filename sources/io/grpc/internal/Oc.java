package io.grpc.internal;

import java.io.InputStream;
import javax.annotation.Nullable;

/* compiled from: StreamListener.java */
/* loaded from: classes3.dex */
public interface Oc {

    /* compiled from: StreamListener.java */
    /* loaded from: classes3.dex */
    public interface a {
        @Nullable
        InputStream next();
    }

    void a();

    void a(a aVar);
}

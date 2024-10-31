package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.InterfaceC2514o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: CompressorRegistry.java */
@ThreadSafe
/* renamed from: io.grpc.q */
/* loaded from: classes3.dex */
public final class C2522q {

    /* renamed from: a */
    private static final C2522q f28021a = new C2522q(new InterfaceC2514o.a(), InterfaceC2514o.b.f27821a);

    /* renamed from: b */
    private final ConcurrentMap<String, InterfaceC2521p> f28022b = new ConcurrentHashMap();

    @VisibleForTesting
    C2522q(InterfaceC2521p... interfaceC2521pArr) {
        for (InterfaceC2521p interfaceC2521p : interfaceC2521pArr) {
            this.f28022b.put(interfaceC2521p.a(), interfaceC2521p);
        }
    }

    public static C2522q a() {
        return f28021a;
    }

    @Nullable
    public InterfaceC2521p a(String str) {
        return this.f28022b.get(str);
    }
}

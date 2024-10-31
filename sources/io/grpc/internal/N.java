package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: Channelz.java */
/* loaded from: classes3.dex */
public final class N {

    /* renamed from: a */
    private static final N f27454a = new N();

    /* renamed from: b */
    private final ConcurrentNavigableMap<Long, InterfaceC2429eb<Object>> f27455b = new ConcurrentSkipListMap();

    /* renamed from: c */
    private final ConcurrentNavigableMap<Long, InterfaceC2429eb<Object>> f27456c = new ConcurrentSkipListMap();

    /* renamed from: d */
    private final ConcurrentMap<Long, InterfaceC2429eb<Object>> f27457d = new ConcurrentHashMap();

    /* renamed from: e */
    private final ConcurrentMap<Long, InterfaceC2429eb<Object>> f27458e = new ConcurrentHashMap();

    /* renamed from: f */
    private final ConcurrentMap<Long, Object> f27459f = new ConcurrentHashMap();

    @VisibleForTesting
    public N() {
    }

    public static N a() {
        return f27454a;
    }

    public void b(InterfaceC2429eb<Object> interfaceC2429eb) {
        a(this.f27456c, interfaceC2429eb);
    }

    public void c(InterfaceC2429eb<Object> interfaceC2429eb) {
        a(this.f27457d, interfaceC2429eb);
    }

    public void d(InterfaceC2429eb<Object> interfaceC2429eb) {
        b(this.f27458e, interfaceC2429eb);
    }

    public void e(InterfaceC2429eb<Object> interfaceC2429eb) {
        b(this.f27456c, interfaceC2429eb);
    }

    public void f(InterfaceC2429eb<Object> interfaceC2429eb) {
        b(this.f27457d, interfaceC2429eb);
    }

    private static <T extends InterfaceC2429eb<?>> void b(Map<Long, T> map, T t) {
        map.remove(Long.valueOf(a((Sc) t)));
    }

    public void a(InterfaceC2429eb<Object> interfaceC2429eb) {
        a(this.f27458e, interfaceC2429eb);
    }

    private static <T extends InterfaceC2429eb<?>> void a(Map<Long, T> map, T t) {
        map.put(Long.valueOf(t.a().a()), t);
    }

    public static long a(Sc sc) {
        return sc.a().a();
    }
}

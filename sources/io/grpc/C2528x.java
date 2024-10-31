package io.grpc;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import io.grpc.InterfaceC2514o;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: DecompressorRegistry.java */
@ThreadSafe
/* renamed from: io.grpc.x */
/* loaded from: classes3.dex */
public final class C2528x {

    /* renamed from: a */
    static final Joiner f28031a = Joiner.a(',');

    /* renamed from: b */
    private static final C2528x f28032b = a().a(new InterfaceC2514o.a(), true).a(InterfaceC2514o.b.f27821a, false);

    /* renamed from: c */
    private final Map<String, a> f28033c;

    /* renamed from: d */
    private final byte[] f28034d;

    /* compiled from: DecompressorRegistry.java */
    /* renamed from: io.grpc.x$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        final InterfaceC2527w f28035a;

        /* renamed from: b */
        final boolean f28036b;

        a(InterfaceC2527w interfaceC2527w, boolean z) {
            Preconditions.a(interfaceC2527w, "decompressor");
            this.f28035a = interfaceC2527w;
            this.f28036b = z;
        }
    }

    private C2528x(InterfaceC2527w interfaceC2527w, boolean z, C2528x c2528x) {
        String a2 = interfaceC2527w.a();
        Preconditions.a(!a2.contains(","), "Comma is currently not allowed in message encoding");
        int size = c2528x.f28033c.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(c2528x.f28033c.containsKey(interfaceC2527w.a()) ? size : size + 1);
        for (a aVar : c2528x.f28033c.values()) {
            String a3 = aVar.f28035a.a();
            if (!a3.equals(a2)) {
                linkedHashMap.put(a3, new a(aVar.f28035a, aVar.f28036b));
            }
        }
        linkedHashMap.put(a2, new a(interfaceC2527w, z));
        this.f28033c = Collections.unmodifiableMap(linkedHashMap);
        this.f28034d = f28031a.a((Iterable<?>) b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static C2528x a() {
        return new C2528x();
    }

    public static C2528x c() {
        return f28032b;
    }

    public Set<String> b() {
        HashSet hashSet = new HashSet(this.f28033c.size());
        for (Map.Entry<String, a> entry : this.f28033c.entrySet()) {
            if (entry.getValue().f28036b) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f28034d;
    }

    public C2528x a(InterfaceC2527w interfaceC2527w, boolean z) {
        return new C2528x(interfaceC2527w, z, this);
    }

    @Nullable
    public InterfaceC2527w a(String str) {
        a aVar = this.f28033c.get(str);
        if (aVar != null) {
            return aVar.f28035a;
        }
        return null;
    }

    private C2528x() {
        this.f28033c = new LinkedHashMap(0);
        this.f28034d = new byte[0];
    }
}

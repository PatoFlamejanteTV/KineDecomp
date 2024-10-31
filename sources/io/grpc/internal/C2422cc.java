package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import javax.annotation.Nullable;

/* compiled from: ProxyParameters.java */
/* renamed from: io.grpc.internal.cc */
/* loaded from: classes3.dex */
public final class C2422cc {

    /* renamed from: a */
    public final InetSocketAddress f27593a;

    /* renamed from: b */
    @Nullable
    public final String f27594b;

    /* renamed from: c */
    @Nullable
    public final String f27595c;

    public C2422cc(InetSocketAddress inetSocketAddress, @Nullable String str, @Nullable String str2) {
        Preconditions.a(inetSocketAddress);
        Preconditions.b(!inetSocketAddress.isUnresolved());
        this.f27593a = inetSocketAddress;
        this.f27594b = str;
        this.f27595c = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2422cc)) {
            return false;
        }
        C2422cc c2422cc = (C2422cc) obj;
        return Objects.a(this.f27593a, c2422cc.f27593a) && Objects.a(this.f27594b, c2422cc.f27594b) && Objects.a(this.f27595c, c2422cc.f27595c);
    }

    public int hashCode() {
        return Objects.a(this.f27593a, this.f27594b, this.f27595c);
    }
}

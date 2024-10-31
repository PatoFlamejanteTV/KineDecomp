package io.grpc.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.C2403b;
import io.grpc.C2522q;
import io.grpc.C2528x;
import io.grpc.InterfaceC2409h;
import io.grpc.J;
import io.grpc.S;
import io.grpc.internal.AbstractC2419c;
import io.grpc.internal.Ia;
import io.grpc.internal.Kc;
import io.grpc.internal.Rc;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AbstractManagedChannelImplBuilder.java */
/* renamed from: io.grpc.internal.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2419c<T extends AbstractC2419c<T>> extends io.grpc.L<T> {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static final long f27574a = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    static final long f27575b = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: c, reason: collision with root package name */
    private static final Ub<? extends Executor> f27576c = Lc.a((Kc.b) GrpcUtil.s);

    /* renamed from: d, reason: collision with root package name */
    private static final S.a f27577d = io.grpc.U.b();

    /* renamed from: e, reason: collision with root package name */
    private static final C2528x f27578e = C2528x.c();

    /* renamed from: f, reason: collision with root package name */
    private static final C2522q f27579f = C2522q.a();

    @Nullable
    private E G;
    final String j;

    @Nullable
    private final SocketAddress k;

    @Nullable
    String l;

    @VisibleForTesting
    @Nullable
    String m;

    @Nullable
    J.a n;
    boolean o;
    boolean x;

    /* renamed from: g, reason: collision with root package name */
    Ub<? extends Executor> f27580g = f27576c;

    /* renamed from: h, reason: collision with root package name */
    private final List<InterfaceC2409h> f27581h = new ArrayList();
    private S.a i = f27577d;
    C2528x p = f27578e;
    C2522q q = f27579f;
    long r = f27574a;
    int s = 5;
    int t = 5;
    long u = 16777216;
    long v = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    boolean w = false;
    N y = N.a();
    protected Rc.a z = Rc.a();
    private int A = 4194304;

    @Nullable
    AbstractC2503y B = AbstractC2503y.r();
    private boolean C = true;
    private boolean D = true;
    private boolean E = true;
    private boolean F = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC2419c(String str) {
        Preconditions.a(str, "target");
        this.j = str;
        this.k = null;
    }

    @Override // io.grpc.L
    public io.grpc.K a() {
        return new Mb(new Fb(this, b(), new Ia.a(), Lc.a((Kc.b) GrpcUtil.s), GrpcUtil.u, c(), C.a()));
    }

    protected abstract Z b();

    @VisibleForTesting
    final List<InterfaceC2409h> c() {
        ArrayList arrayList = new ArrayList(this.f27581h);
        this.x = false;
        if (this.C) {
            this.x = true;
            E e2 = this.G;
            if (e2 == null) {
                e2 = new E(GrpcUtil.u, true);
            }
            arrayList.add(0, e2.a(this.D, this.E));
        }
        if (this.F) {
            this.x = true;
            arrayList.add(0, new J(io.opencensus.trace.q.b(), io.opencensus.trace.q.a().a()).d());
        }
        AbstractC2503y abstractC2503y = this.B;
        if (abstractC2503y != null) {
            arrayList.add(0, abstractC2503y.a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public S.a d() {
        String str = this.m;
        if (str == null) {
            return this.i;
        }
        return new Xb(this.i, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract C2403b e();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        return this.A;
    }
}

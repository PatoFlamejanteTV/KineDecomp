package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: ConnectivityStateManager.java */
@NotThreadSafe
/* renamed from: io.grpc.internal.ea */
/* loaded from: classes3.dex */
public final class C2428ea {

    /* renamed from: a */
    private ArrayList<a> f27604a = new ArrayList<>();

    /* renamed from: b */
    private volatile ConnectivityState f27605b = ConnectivityState.IDLE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConnectivityStateManager.java */
    /* renamed from: io.grpc.internal.ea$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        final Runnable f27606a;

        /* renamed from: b */
        final Executor f27607b;

        void a() {
            this.f27607b.execute(this.f27606a);
        }
    }

    public void a(@Nonnull ConnectivityState connectivityState) {
        Preconditions.a(connectivityState, "newState");
        if (this.f27605b == connectivityState || this.f27605b == ConnectivityState.SHUTDOWN) {
            return;
        }
        this.f27605b = connectivityState;
        if (this.f27604a.isEmpty()) {
            return;
        }
        ArrayList<a> arrayList = this.f27604a;
        this.f27604a = new ArrayList<>();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}

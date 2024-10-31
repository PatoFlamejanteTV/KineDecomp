package io.grpc.okhttp;

import android.support.v7.widget.ActivityChooserView;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.C2403b;
import io.grpc.StatusException;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.w;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Executor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpClientTransport.java */
/* loaded from: classes3.dex */
public class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f28000a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(w wVar) {
        this.f28000a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean i;
        Executor executor;
        w.a aVar;
        Executor executor2;
        w.a aVar2;
        Executor executor3;
        w.a aVar3;
        InetSocketAddress inetSocketAddress;
        Socket a2;
        SSLSocketFactory sSLSocketFactory;
        Executor executor4;
        w.a aVar4;
        Socket socket;
        SSLSocketFactory sSLSocketFactory2;
        HostnameVerifier hostnameVerifier;
        io.grpc.okhttp.internal.b bVar;
        InetSocketAddress inetSocketAddress2;
        InetSocketAddress inetSocketAddress3;
        io.grpc.okhttp.internal.framed.a aVar5;
        Executor executor5;
        w.a aVar6;
        io.grpc.okhttp.internal.framed.b bVar2;
        Socket socket2;
        i = this.f28000a.i();
        if (i) {
            Runnable runnable = this.f28000a.R;
            if (runnable != null) {
                runnable.run();
            }
            w wVar = this.f28000a;
            aVar5 = wVar.j;
            wVar.u = new w.a(aVar5);
            executor5 = this.f28000a.q;
            aVar6 = this.f28000a.u;
            executor5.execute(aVar6);
            synchronized (this.f28000a.m) {
                this.f28000a.E = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                this.f28000a.l();
            }
            l lVar = this.f28000a.k;
            bVar2 = this.f28000a.H;
            socket2 = this.f28000a.D;
            lVar.a(bVar2, socket2);
            this.f28000a.S.a((SettableFuture<Void>) null);
            return;
        }
        okio.i a3 = okio.s.a(new u(this));
        io.grpc.okhttp.internal.framed.e eVar = new io.grpc.okhttp.internal.framed.e();
        try {
            try {
                try {
                    if (this.f28000a.Q == null) {
                        inetSocketAddress2 = this.f28000a.f28004d;
                        InetAddress address = inetSocketAddress2.getAddress();
                        inetSocketAddress3 = this.f28000a.f28004d;
                        a2 = new Socket(address, inetSocketAddress3.getPort());
                    } else {
                        w wVar2 = this.f28000a;
                        inetSocketAddress = this.f28000a.f28004d;
                        a2 = wVar2.a(inetSocketAddress, this.f28000a.Q.f27593a, this.f28000a.Q.f27594b, this.f28000a.Q.f27595c);
                    }
                    Socket socket3 = a2;
                    sSLSocketFactory = this.f28000a.B;
                    if (sSLSocketFactory != null) {
                        sSLSocketFactory2 = this.f28000a.B;
                        hostnameVerifier = this.f28000a.C;
                        String d2 = this.f28000a.d();
                        int e2 = this.f28000a.e();
                        bVar = this.f28000a.G;
                        socket3 = A.a(sSLSocketFactory2, hostnameVerifier, socket3, d2, e2, bVar);
                    }
                    socket3.setTcpNoDelay(true);
                    a3 = okio.s.a(okio.s.b(socket3));
                    okio.h a4 = okio.s.a(okio.s.a(socket3));
                    w wVar3 = this.f28000a;
                    C2403b.a b2 = C2403b.b();
                    b2.a(io.grpc.C.f27074a, socket3.getRemoteSocketAddress());
                    wVar3.v = b2.a();
                    w wVar4 = this.f28000a;
                    wVar4.u = new w.a(eVar.a(a3, true));
                    executor4 = this.f28000a.q;
                    aVar4 = this.f28000a.u;
                    executor4.execute(aVar4);
                    synchronized (this.f28000a.m) {
                        this.f28000a.D = socket3;
                        this.f28000a.E = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        this.f28000a.l();
                    }
                    io.grpc.okhttp.internal.framed.b a5 = eVar.a(a4, true);
                    l lVar2 = this.f28000a.k;
                    socket = this.f28000a.D;
                    lVar2.a(a5, socket);
                    try {
                        a5.q();
                        a5.b(new io.grpc.okhttp.internal.framed.g());
                    } catch (Exception e3) {
                        this.f28000a.a(e3);
                    }
                } catch (Exception e4) {
                    this.f28000a.a(e4);
                    w wVar5 = this.f28000a;
                    wVar5.u = new w.a(eVar.a(a3, true));
                    executor = this.f28000a.q;
                    aVar = this.f28000a.u;
                    executor.execute(aVar);
                }
            } catch (StatusException e5) {
                this.f28000a.a(0, ErrorCode.INTERNAL_ERROR, e5.getStatus());
                w wVar6 = this.f28000a;
                wVar6.u = new w.a(eVar.a(a3, true));
                executor2 = this.f28000a.q;
                aVar2 = this.f28000a.u;
                executor2.execute(aVar2);
            }
        } catch (Throwable th) {
            w wVar7 = this.f28000a;
            wVar7.u = new w.a(eVar.a(a3, true));
            executor3 = this.f28000a.q;
            aVar3 = this.f28000a.u;
            executor3.execute(aVar3);
            throw th;
        }
    }
}

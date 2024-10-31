package io.grpc.internal;

import io.grpc.C2403b;
import io.grpc.C2530z;
import io.grpc.S;
import io.grpc.Status;
import io.grpc.internal.Ga;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DnsNameResolver.java */
/* loaded from: classes3.dex */
public class Fa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ga f27277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fa(Ga ga) {
        this.f27277a = ga;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        S.b bVar;
        String str;
        int i;
        String str2;
        String str3;
        Ga.b bVar2;
        String str4;
        String str5;
        Random random;
        String g2;
        int i2;
        synchronized (this.f27277a) {
            z = this.f27277a.n;
            if (z) {
                return;
            }
            bVar = this.f27277a.q;
            this.f27277a.p = true;
            try {
                str = this.f27277a.k;
                i = this.f27277a.l;
                InetSocketAddress createUnresolved = InetSocketAddress.createUnresolved(str, i);
                try {
                    C2422cc a2 = this.f27277a.f27315g.a(createUnresolved);
                    if (a2 == null) {
                        try {
                            bVar2 = this.f27277a.i;
                            str4 = this.f27277a.k;
                            Ga.e a3 = bVar2.a(str4);
                            ArrayList arrayList = new ArrayList();
                            for (InetAddress inetAddress : a3.f27320a) {
                                i2 = this.f27277a.l;
                                arrayList.add(new C2530z(new InetSocketAddress(inetAddress, i2)));
                            }
                            arrayList.addAll(a3.f27322c);
                            C2403b.a b2 = C2403b.b();
                            if (a3.f27321b.isEmpty()) {
                                Logger logger = Ga.f27309a;
                                Level level = Level.FINE;
                                str5 = this.f27277a.k;
                                logger.log(level, "No TXT records found for {0}", new Object[]{str5});
                            } else {
                                Map<String, Object> map = null;
                                try {
                                    for (Map<String, Object> map2 : Ga.a(a3.f27321b)) {
                                        try {
                                            random = this.f27277a.f27316h;
                                            g2 = Ga.g();
                                            map = Ga.a(map2, random, g2);
                                        } catch (RuntimeException e2) {
                                            Ga.f27309a.log(Level.WARNING, "Bad service config choice " + map2, (Throwable) e2);
                                        }
                                        if (map != null) {
                                            break;
                                        }
                                    }
                                } catch (RuntimeException e3) {
                                    Ga.f27309a.log(Level.WARNING, "Can't parse service Configs", (Throwable) e3);
                                }
                                if (map != null) {
                                    b2.a(Sa.f27502a, map);
                                }
                            }
                            bVar.a(arrayList, b2.a());
                            synchronized (this.f27277a) {
                                this.f27277a.p = false;
                            }
                            return;
                        } catch (Exception e4) {
                            Status status = Status.q;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unable to resolve host ");
                            str3 = this.f27277a.k;
                            sb.append(str3);
                            bVar.a(status.b(sb.toString()).b(e4));
                            synchronized (this.f27277a) {
                                this.f27277a.p = false;
                                return;
                            }
                        }
                    }
                    C2403b.a b3 = C2403b.b();
                    b3.a(Zb.f27542a, a2);
                    bVar.a(Collections.singletonList(new C2530z(new PairSocketAddress(createUnresolved, b3.a()))), C2403b.f27155a);
                    synchronized (this.f27277a) {
                        this.f27277a.p = false;
                    }
                } catch (IOException e5) {
                    Status status2 = Status.q;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to resolve host ");
                    str2 = this.f27277a.k;
                    sb2.append(str2);
                    bVar.a(status2.b(sb2.toString()).b(e5));
                    synchronized (this.f27277a) {
                        this.f27277a.p = false;
                    }
                }
            } catch (Throwable th) {
                synchronized (this.f27277a) {
                    this.f27277a.p = false;
                    throw th;
                }
            }
        }
    }
}

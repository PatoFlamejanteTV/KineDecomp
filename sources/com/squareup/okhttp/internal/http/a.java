package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.InterfaceC2376b;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;

/* compiled from: AuthenticatorAdapter.java */
/* loaded from: classes3.dex */
public final class a implements InterfaceC2376b {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC2376b f25412a = new a();

    @Override // com.squareup.okhttp.InterfaceC2376b
    public E a(Proxy proxy, H h2) throws IOException {
        List<com.squareup.okhttp.l> d2 = h2.d();
        E l = h2.l();
        HttpUrl d3 = l.d();
        int size = d2.size();
        for (int i = 0; i < size; i++) {
            com.squareup.okhttp.l lVar = d2.get(i);
            if ("Basic".equalsIgnoreCase(lVar.b())) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), a(proxy, d3), inetSocketAddress.getPort(), d3.l(), lVar.a(), lVar.b(), d3.n(), Authenticator.RequestorType.PROXY);
                if (requestPasswordAuthentication != null) {
                    String a2 = com.squareup.okhttp.r.a(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()));
                    E.a g2 = l.g();
                    g2.b("Proxy-Authorization", a2);
                    return g2.a();
                }
            }
        }
        return null;
    }

    @Override // com.squareup.okhttp.InterfaceC2376b
    public E b(Proxy proxy, H h2) throws IOException {
        PasswordAuthentication requestPasswordAuthentication;
        List<com.squareup.okhttp.l> d2 = h2.d();
        E l = h2.l();
        HttpUrl d3 = l.d();
        int size = d2.size();
        for (int i = 0; i < size; i++) {
            com.squareup.okhttp.l lVar = d2.get(i);
            if ("Basic".equalsIgnoreCase(lVar.b()) && (requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(d3.g(), a(proxy, d3), d3.j(), d3.l(), lVar.a(), lVar.b(), d3.n(), Authenticator.RequestorType.SERVER)) != null) {
                String a2 = com.squareup.okhttp.r.a(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()));
                E.a g2 = l.g();
                g2.b("Authorization", a2);
                return g2.a();
            }
        }
        return null;
    }

    private InetAddress a(Proxy proxy, HttpUrl httpUrl) throws IOException {
        if (proxy != null && proxy.type() != Proxy.Type.DIRECT) {
            return ((InetSocketAddress) proxy.address()).getAddress();
        }
        return InetAddress.getByName(httpUrl.g());
    }
}

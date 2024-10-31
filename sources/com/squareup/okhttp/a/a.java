package com.squareup.okhttp.a;

import com.squareup.okhttp.q;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    private final List<q> f25135a;

    /* renamed from: b */
    private int f25136b = 0;

    /* renamed from: c */
    private boolean f25137c;

    /* renamed from: d */
    private boolean f25138d;

    public a(List<q> list) {
        this.f25135a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f25136b; i < this.f25135a.size(); i++) {
            if (this.f25135a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public q a(SSLSocket sSLSocket) throws IOException {
        q qVar;
        int i = this.f25136b;
        int size = this.f25135a.size();
        while (true) {
            if (i >= size) {
                qVar = null;
                break;
            }
            qVar = this.f25135a.get(i);
            if (qVar.a(sSLSocket)) {
                this.f25136b = i + 1;
                break;
            }
            i++;
        }
        if (qVar != null) {
            this.f25137c = b(sSLSocket);
            h.f25192b.a(qVar, sSLSocket, this.f25138d);
            return qVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f25138d + ", modes=" + this.f25135a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f25138d = true;
        if (!this.f25137c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}

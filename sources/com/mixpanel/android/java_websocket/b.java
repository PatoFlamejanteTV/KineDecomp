package com.mixpanel.android.java_websocket;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.b.f;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.drafts.Draft_10;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: WebSocketImpl.java */
@SuppressLint({"Assert"})
/* loaded from: classes.dex */
public class b implements WebSocket {

    /* renamed from: a, reason: collision with root package name */
    public static int f2990a;
    public static boolean b;
    public static final List<Draft> c;
    static final /* synthetic */ boolean h;
    public SelectionKey d;
    public ByteChannel e;
    public final BlockingQueue<ByteBuffer> f;
    public final BlockingQueue<ByteBuffer> g;
    private final c k;
    private List<Draft> l;
    private Draft m;
    private WebSocket.Role n;
    private volatile boolean i = false;
    private WebSocket.READYSTATE j = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private Framedata.Opcode o = null;
    private ByteBuffer p = ByteBuffer.allocate(0);
    private com.mixpanel.android.java_websocket.b.a q = null;
    private String r = null;
    private Integer s = null;
    private Boolean t = null;
    private String u = null;

    static {
        h = !b.class.desiredAssertionStatus();
        f2990a = 16384;
        b = false;
        c = new ArrayList(4);
        c.add(new com.mixpanel.android.java_websocket.drafts.a());
        c.add(new Draft_10());
        c.add(new com.mixpanel.android.java_websocket.drafts.c());
        c.add(new com.mixpanel.android.java_websocket.drafts.b());
    }

    public b(c cVar, Draft draft) {
        this.m = null;
        if (cVar == null || (draft == null && this.n == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f = new LinkedBlockingQueue();
        this.g = new LinkedBlockingQueue();
        this.k = cVar;
        this.n = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.m = draft.c();
        }
    }

    public void a(ByteBuffer byteBuffer) {
        if (!h && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (b) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + "}");
        }
        if (this.j != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            c(byteBuffer);
        } else if (b(byteBuffer)) {
            if (!h && this.p.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                c(byteBuffer);
            } else if (this.p.hasRemaining()) {
                c(this.p);
            }
        }
        if (!h && !d() && !e() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(java.nio.ByteBuffer r9) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.java_websocket.b.b(java.nio.ByteBuffer):boolean");
    }

    private void c(ByteBuffer byteBuffer) {
        String str;
        int i;
        try {
        } catch (InvalidDataException e) {
            this.k.a(this, e);
            a(e);
            return;
        }
        for (Framedata framedata : this.m.c(byteBuffer)) {
            if (b) {
                System.out.println("matched frame: " + framedata);
            }
            Framedata.Opcode f = framedata.f();
            boolean d = framedata.d();
            if (f == Framedata.Opcode.CLOSING) {
                if (!(framedata instanceof com.mixpanel.android.java_websocket.framing.a)) {
                    str = "";
                    i = 1005;
                } else {
                    com.mixpanel.android.java_websocket.framing.a aVar = (com.mixpanel.android.java_websocket.framing.a) framedata;
                    i = aVar.a();
                    str = aVar.b();
                }
                if (this.j == WebSocket.READYSTATE.CLOSING) {
                    a(i, str, true);
                } else if (this.m.b() == Draft.CloseHandshakeType.TWOWAY) {
                    c(i, str, true);
                } else {
                    b(i, str, false);
                }
            } else if (f == Framedata.Opcode.PING) {
                this.k.b(this, framedata);
            } else if (f == Framedata.Opcode.PONG) {
                this.k.c(this, framedata);
            } else {
                if (!d || f == Framedata.Opcode.CONTINUOUS) {
                    if (f != Framedata.Opcode.CONTINUOUS) {
                        if (this.o != null) {
                            throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, "Previous continuous frame sequence not completed.");
                        }
                        this.o = f;
                    } else if (d) {
                        if (this.o == null) {
                            throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, "Continuous frame sequence was not started.");
                        }
                        this.o = null;
                    } else if (this.o == null) {
                        throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, "Continuous frame sequence was not started.");
                    }
                    try {
                        this.k.a(this, framedata);
                    } catch (RuntimeException e2) {
                        this.k.a(this, e2);
                    }
                } else {
                    if (this.o != null) {
                        throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, "Continuous frame sequence not completed.");
                    }
                    if (f == Framedata.Opcode.TEXT) {
                        try {
                            this.k.a(this, com.mixpanel.android.java_websocket.c.b.a(framedata.c()));
                        } catch (RuntimeException e3) {
                            this.k.a(this, e3);
                        }
                    } else if (f == Framedata.Opcode.BINARY) {
                        try {
                            this.k.a(this, framedata.c());
                        } catch (RuntimeException e4) {
                            this.k.a(this, e4);
                        }
                    } else {
                        throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, "non control or continious frame expected");
                    }
                }
                this.k.a(this, e);
                a(e);
                return;
            }
        }
    }

    private void c(int i, String str, boolean z) {
        if (this.j != WebSocket.READYSTATE.CLOSING && this.j != WebSocket.READYSTATE.CLOSED) {
            if (this.j == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!h && z) {
                        throw new AssertionError();
                    }
                    this.j = WebSocket.READYSTATE.CLOSING;
                    b(i, str, false);
                    return;
                }
                if (this.m.b() != Draft.CloseHandshakeType.NONE) {
                    try {
                        if (!z) {
                            try {
                                this.k.a(this, i, str);
                            } catch (RuntimeException e) {
                                this.k.a(this, e);
                            }
                        }
                        a(new com.mixpanel.android.java_websocket.framing.b(i, str));
                    } catch (InvalidDataException e2) {
                        this.k.a(this, e2);
                        b(1006, "generated frame is invalid", false);
                    }
                }
                b(i, str, z);
            } else if (i == -3) {
                if (!h && !z) {
                    throw new AssertionError();
                }
                b(-3, str, true);
            } else {
                b(-1, str, false);
            }
            if (i == 1002) {
                b(i, str, z);
            }
            this.j = WebSocket.READYSTATE.CLOSING;
            this.p = null;
        }
    }

    public void a(int i, String str) {
        c(i, str, false);
    }

    protected synchronized void a(int i, String str, boolean z) {
        if (this.j != WebSocket.READYSTATE.CLOSED) {
            if (this.d != null) {
                this.d.cancel();
            }
            if (this.e != null) {
                try {
                    this.e.close();
                } catch (IOException e) {
                    this.k.a(this, e);
                }
            }
            try {
                this.k.a(this, i, str, z);
            } catch (RuntimeException e2) {
                this.k.a(this, e2);
            }
            if (this.m != null) {
                this.m.a();
            }
            this.q = null;
            this.j = WebSocket.READYSTATE.CLOSED;
            this.f.clear();
        }
    }

    protected void a(int i, boolean z) {
        a(i, "", z);
    }

    public void b(int i, String str) {
        a(i, str, false);
    }

    protected synchronized void b(int i, String str, boolean z) {
        if (!this.i) {
            this.s = Integer.valueOf(i);
            this.r = str;
            this.t = Boolean.valueOf(z);
            this.i = true;
            this.k.b(this);
            try {
                this.k.b(this, i, str, z);
            } catch (RuntimeException e) {
                this.k.a(this, e);
            }
            if (this.m != null) {
                this.m.a();
            }
            this.q = null;
        }
    }

    public void b() {
        if (g() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            a(-1, true);
            return;
        }
        if (this.i) {
            a(this.s.intValue(), this.r, this.t.booleanValue());
            return;
        }
        if (this.m.b() == Draft.CloseHandshakeType.NONE) {
            a(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, true);
            return;
        }
        if (this.m.b() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.n == WebSocket.Role.SERVER) {
                a(1006, true);
                return;
            } else {
                a(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, true);
                return;
            }
        }
        a(1006, true);
    }

    public void a(InvalidDataException invalidDataException) {
        c(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(Collection<Framedata> collection) {
        if (!c()) {
            throw new WebsocketNotConnectedException();
        }
        Iterator<Framedata> it = collection.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        a(this.m.a(opcode, byteBuffer, z));
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public void a(Framedata framedata) {
        if (b) {
            System.out.println("send frame: " + framedata);
        }
        e(this.m.a(framedata));
    }

    private Draft.HandshakeState d(ByteBuffer byteBuffer) throws IncompleteHandshakeException {
        byteBuffer.mark();
        if (byteBuffer.limit() > Draft.c.length) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (byteBuffer.limit() < Draft.c.length) {
            throw new IncompleteHandshakeException(Draft.c.length);
        }
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            if (Draft.c[i] == byteBuffer.get()) {
                i++;
            } else {
                byteBuffer.reset();
                return Draft.HandshakeState.NOT_MATCHED;
            }
        }
        return Draft.HandshakeState.MATCHED;
    }

    public void a(com.mixpanel.android.java_websocket.b.b bVar) throws InvalidHandshakeException {
        if (!h && this.j == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.q = this.m.a(bVar);
        this.u = bVar.a();
        if (!h && this.u == null) {
            throw new AssertionError();
        }
        try {
            this.k.a((WebSocket) this, this.q);
            a(this.m.a(this.q, this.n));
        } catch (InvalidDataException e) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.k.a(this, e2);
            throw new InvalidHandshakeException("rejected because of" + e2);
        }
    }

    private void e(ByteBuffer byteBuffer) {
        if (b) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + "}");
        }
        this.f.add(byteBuffer);
        this.k.b(this);
    }

    private void a(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            e(it.next());
        }
    }

    private void a(f fVar) {
        if (b) {
            System.out.println("open using draft: " + this.m.getClass().getSimpleName());
        }
        this.j = WebSocket.READYSTATE.OPEN;
        try {
            this.k.a(this, fVar);
        } catch (RuntimeException e) {
            this.k.a(this, e);
        }
    }

    public boolean c() {
        if (!h && this.j == WebSocket.READYSTATE.OPEN && this.i) {
            throw new AssertionError();
        }
        return this.j == WebSocket.READYSTATE.OPEN;
    }

    public boolean d() {
        return this.j == WebSocket.READYSTATE.CLOSING;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE g() {
        return this.j;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public InetSocketAddress a() {
        return this.k.c(this);
    }
}

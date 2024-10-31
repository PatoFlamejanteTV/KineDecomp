package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.b.f;
import com.mixpanel.android.java_websocket.b.h;
import com.mixpanel.android.java_websocket.b.i;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.d;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* compiled from: Draft_75.java */
/* loaded from: classes.dex */
public class b extends Draft {
    protected ByteBuffer h;
    protected boolean f = false;
    protected List<Framedata> g = new LinkedList();
    private final Random i = new Random();

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar, h hVar) {
        return (aVar.b("WebSocket-Origin").equals(hVar.b("Origin")) && a(hVar)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar) {
        return (aVar.c("Origin") && a((f) aVar)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        if (framedata.f() != Framedata.Opcode.TEXT) {
            throw new RuntimeException("only text frames supported");
        }
        ByteBuffer c = framedata.c();
        ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + 2);
        allocate.put((byte) 0);
        c.mark();
        allocate.put(c);
        c.reset();
        allocate.put((byte) -1);
        allocate.flip();
        return allocate;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public com.mixpanel.android.java_websocket.b.b a(com.mixpanel.android.java_websocket.b.b bVar) throws InvalidHandshakeException {
        bVar.a("Upgrade", "WebSocket");
        bVar.a("Connection", "Upgrade");
        if (!bVar.c("Origin")) {
            bVar.a("Origin", "random" + this.i.nextInt());
        }
        return bVar;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public com.mixpanel.android.java_websocket.b.c a(com.mixpanel.android.java_websocket.b.a aVar, i iVar) throws InvalidHandshakeException {
        iVar.a("Web Socket Protocol Handshake");
        iVar.a("Upgrade", "WebSocket");
        iVar.a("Connection", aVar.b("Connection"));
        iVar.a("WebSocket-Origin", aVar.b("Origin"));
        iVar.a("WebSocket-Location", "ws://" + aVar.b("Host") + aVar.a());
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Framedata> e(ByteBuffer byteBuffer) throws InvalidDataException {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == 0) {
                if (this.f) {
                    throw new InvalidFrameException("unexpected START_OF_FRAME");
                }
                this.f = true;
            } else if (b == -1) {
                if (!this.f) {
                    throw new InvalidFrameException("unexpected END_OF_FRAME");
                }
                if (this.h != null) {
                    this.h.flip();
                    d dVar = new d();
                    dVar.a(this.h);
                    dVar.a(true);
                    dVar.a(Framedata.Opcode.TEXT);
                    this.g.add(dVar);
                    this.h = null;
                    byteBuffer.mark();
                }
                this.f = false;
            } else {
                if (!this.f) {
                    return null;
                }
                if (this.h == null) {
                    this.h = d();
                } else if (!this.h.hasRemaining()) {
                    this.h = f(this.h);
                }
                this.h.put(b);
            }
        }
        List<Framedata> list = this.g;
        this.g = new LinkedList();
        return list;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public List<Framedata> c(ByteBuffer byteBuffer) throws InvalidDataException {
        List<Framedata> e = e(byteBuffer);
        if (e == null) {
            throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE);
        }
        return e;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public void a() {
        this.f = false;
        this.h = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType b() {
        return Draft.CloseHandshakeType.NONE;
    }

    public ByteBuffer d() {
        return ByteBuffer.allocate(b);
    }

    public ByteBuffer f(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        byteBuffer.flip();
        ByteBuffer allocate = ByteBuffer.allocate(a(byteBuffer.capacity() * 2));
        allocate.put(byteBuffer);
        return allocate;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft c() {
        return new b();
    }
}

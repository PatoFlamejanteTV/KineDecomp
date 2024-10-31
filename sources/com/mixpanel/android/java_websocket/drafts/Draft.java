package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.b.d;
import com.mixpanel.android.java_websocket.b.e;
import com.mixpanel.android.java_websocket.b.f;
import com.mixpanel.android.java_websocket.b.h;
import com.mixpanel.android.java_websocket.b.i;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class Draft {

    /* renamed from: a, reason: collision with root package name */
    public static int f2997a = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
    public static int b = 64;
    public static final byte[] c = com.mixpanel.android.java_websocket.c.b.a("<policy-file-request/>\u0000");
    protected WebSocket.Role d = null;
    protected Framedata.Opcode e = null;

    /* loaded from: classes.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract com.mixpanel.android.java_websocket.b.b a(com.mixpanel.android.java_websocket.b.b bVar) throws InvalidHandshakeException;

    public abstract com.mixpanel.android.java_websocket.b.c a(com.mixpanel.android.java_websocket.b.a aVar, i iVar) throws InvalidHandshakeException;

    public abstract HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar) throws InvalidHandshakeException;

    public abstract HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar, h hVar) throws InvalidHandshakeException;

    public abstract ByteBuffer a(Framedata framedata);

    public abstract void a();

    public abstract CloseHandshakeType b();

    public abstract Draft c();

    public abstract List<Framedata> c(ByteBuffer byteBuffer) throws InvalidDataException;

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b2 = b3;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String b(ByteBuffer byteBuffer) {
        ByteBuffer a2 = a(byteBuffer);
        if (a2 == null) {
            return null;
        }
        return com.mixpanel.android.java_websocket.c.b.a(a2.array(), 0, a2.limit());
    }

    public static com.mixpanel.android.java_websocket.b.c a(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        com.mixpanel.android.java_websocket.b.c cVar;
        String b2 = b(byteBuffer);
        if (b2 == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = b2.split(" ", 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            com.mixpanel.android.java_websocket.b.c eVar = new e();
            i iVar = (i) eVar;
            iVar.a(Short.parseShort(split[1]));
            iVar.a(split[2]);
            cVar = eVar;
        } else {
            d dVar = new d();
            dVar.a(split[1]);
            cVar = dVar;
        }
        String b3 = b(byteBuffer);
        while (b3 != null && b3.length() > 0) {
            String[] split2 = b3.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            cVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
            b3 = b(byteBuffer);
        }
        if (b3 == null) {
            throw new IncompleteHandshakeException();
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(f fVar) {
        return fVar.b("Upgrade").equalsIgnoreCase("websocket") && fVar.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<Framedata> a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.e != null) {
            this.e = Framedata.Opcode.CONTINUOUS;
        } else {
            this.e = opcode;
        }
        com.mixpanel.android.java_websocket.framing.d dVar = new com.mixpanel.android.java_websocket.framing.d(this.e);
        try {
            dVar.a(byteBuffer);
            dVar.a(z);
            if (z) {
                this.e = null;
            } else {
                this.e = opcode;
            }
            return Collections.singletonList(dVar);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ByteBuffer> a(f fVar, WebSocket.Role role) {
        return a(fVar, role, true);
    }

    public List<ByteBuffer> a(f fVar, WebSocket.Role role, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (fVar instanceof com.mixpanel.android.java_websocket.b.a) {
            sb.append("GET ");
            sb.append(((com.mixpanel.android.java_websocket.b.a) fVar).a());
            sb.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            sb.append("HTTP/1.1 101 " + ((h) fVar).a());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> b2 = fVar.b();
        while (b2.hasNext()) {
            String next = b2.next();
            String b3 = fVar.b(next);
            sb.append(next);
            sb.append(": ");
            sb.append(b3);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] b4 = com.mixpanel.android.java_websocket.c.b.b(sb.toString());
        byte[] c2 = z ? fVar.c() : null;
        ByteBuffer allocate = ByteBuffer.allocate((c2 == null ? 0 : c2.length) + b4.length);
        allocate.put(b4);
        if (c2 != null) {
            allocate.put(c2);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public f d(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return a(byteBuffer, this.d);
    }

    public int a(int i) throws LimitExedeedException, InvalidDataException {
        if (i < 0) {
            throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, "Negative count");
        }
        return i;
    }

    public void a(WebSocket.Role role) {
        this.d = role;
    }
}

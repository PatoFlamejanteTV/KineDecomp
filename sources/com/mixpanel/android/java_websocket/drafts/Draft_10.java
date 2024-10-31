package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
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
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint({"Assert", "UseValueOf"})
/* loaded from: classes.dex */
public class Draft_10 extends Draft {
    static final /* synthetic */ boolean f;
    private ByteBuffer g;
    private Framedata h = null;
    private final Random i = new Random();

    static {
        f = !Draft_10.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class IncompleteException extends Throwable {
        private static final long serialVersionUID = 7330519489840500997L;
        private int preferedsize;

        public IncompleteException(int i) {
            this.preferedsize = i;
        }

        public int getPreferedSize() {
            return this.preferedsize;
        }
    }

    public static int b(f fVar) {
        String b = fVar.b("Sec-WebSocket-Version");
        if (b.length() <= 0) {
            return -1;
        }
        try {
            return new Integer(b.trim()).intValue();
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar, h hVar) throws InvalidHandshakeException {
        if (!aVar.c("Sec-WebSocket-Key") || !hVar.c("Sec-WebSocket-Accept")) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (a(aVar.b("Sec-WebSocket-Key")).equals(hVar.b("Sec-WebSocket-Accept"))) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar) throws InvalidHandshakeException {
        int b = b(aVar);
        if (b == 7 || b == 8) {
            return a((f) aVar) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer c = framedata.c();
        boolean z = this.d == WebSocket.Role.CLIENT;
        if (c.remaining() <= 125) {
            i = 1;
        } else {
            i = c.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + c.remaining());
        allocate.put((byte) (((byte) (framedata.d() ? -128 : 0)) | a(framedata.f())));
        byte[] a2 = a(c.remaining(), i);
        if (!f && a2.length != i) {
            throw new AssertionError();
        }
        if (i == 1) {
            allocate.put((byte) (a2[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
        } else if (i == 2) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
            allocate.put(a2);
        } else if (i == 8) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
            allocate.put(a2);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.i.nextInt());
            allocate.put(allocate2.array());
            while (c.hasRemaining()) {
                allocate.put((byte) (c.get() ^ allocate2.get(i2 % 4)));
                i2++;
            }
        } else {
            allocate.put(c);
        }
        if (!f && allocate.remaining() != 0) {
            throw new AssertionError(allocate.remaining());
        }
        allocate.flip();
        return allocate;
    }

    private byte a(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + opcode.toString());
    }

    private String a(String str) {
        try {
            return com.mixpanel.android.java_websocket.c.a.a(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public com.mixpanel.android.java_websocket.b.b a(com.mixpanel.android.java_websocket.b.b bVar) {
        bVar.a("Upgrade", "websocket");
        bVar.a("Connection", "Upgrade");
        bVar.a("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.i.nextBytes(bArr);
        bVar.a("Sec-WebSocket-Key", com.mixpanel.android.java_websocket.c.a.a(bArr));
        return bVar;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public com.mixpanel.android.java_websocket.b.c a(com.mixpanel.android.java_websocket.b.a aVar, i iVar) throws InvalidHandshakeException {
        iVar.a("Upgrade", "websocket");
        iVar.a("Connection", aVar.b("Connection"));
        iVar.a("Switching Protocols");
        String b = aVar.b("Sec-WebSocket-Key");
        if (b == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.a("Sec-WebSocket-Accept", a(b));
        return iVar;
    }

    private byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    private Framedata.Opcode a(byte b) throws InvalidFrameException {
        switch (b) {
            case 0:
                return Framedata.Opcode.CONTINUOUS;
            case 1:
                return Framedata.Opcode.TEXT;
            case 2:
                return Framedata.Opcode.BINARY;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                throw new InvalidFrameException("unknow optcode " + ((int) b));
            case 8:
                return Framedata.Opcode.CLOSING;
            case 9:
                return Framedata.Opcode.PING;
            case 10:
                return Framedata.Opcode.PONG;
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public List<Framedata> c(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        LinkedList linkedList = new LinkedList();
        if (this.g != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.g.remaining();
                if (remaining2 > remaining) {
                    this.g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(e((ByteBuffer) this.g.duplicate().position(0)));
                this.g = null;
            } catch (IncompleteException e) {
                this.g.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a(e.getPreferedSize()));
                if (!f && allocate.limit() <= this.g.limit()) {
                    throw new AssertionError();
                }
                this.g.rewind();
                allocate.put(this.g);
                this.g = allocate;
                return c(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(e(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.g = ByteBuffer.allocate(a(e2.getPreferedSize()));
                this.g.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Framedata e(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        com.mixpanel.android.java_websocket.framing.c dVar;
        int i = 2;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new IncompleteException(2);
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & Byte.MAX_VALUE) >> 4);
        if (b2 != 0) {
            throw new InvalidFrameException("bad rsv " + ((int) b2));
        }
        byte b3 = byteBuffer.get();
        boolean z2 = (b3 & Byte.MIN_VALUE) != 0;
        int i2 = (byte) (b3 & Byte.MAX_VALUE);
        Framedata.Opcode a2 = a((byte) (b & 15));
        if (!z && (a2 == Framedata.Opcode.PING || a2 == Framedata.Opcode.PONG || a2 == Framedata.Opcode.CLOSING)) {
            throw new InvalidFrameException("control frames may no be fragmented");
        }
        if (i2 < 0 || i2 > 125) {
            if (a2 == Framedata.Opcode.PING || a2 == Framedata.Opcode.PONG || a2 == Framedata.Opcode.CLOSING) {
                throw new InvalidFrameException("more than 125 octets");
            }
            if (i2 == 126) {
                if (remaining < 4) {
                    throw new IncompleteException(4);
                }
                i2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                i = 4;
            } else {
                if (remaining < 10) {
                    throw new IncompleteException(10);
                }
                byte[] bArr = new byte[8];
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr[i3] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                if (longValue <= 2147483647L) {
                    i = 10;
                    i2 = (int) longValue;
                } else {
                    throw new LimitExedeedException("Payloadsize is to big...");
                }
            }
        }
        int i4 = (z2 ? 4 : 0) + i + i2;
        if (remaining < i4) {
            throw new IncompleteException(i4);
        }
        ByteBuffer allocate = ByteBuffer.allocate(a(i2));
        if (z2) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i5 = 0; i5 < i2; i5++) {
                allocate.put((byte) (byteBuffer.get() ^ bArr2[i5 % 4]));
            }
        } else {
            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
            byteBuffer.position(byteBuffer.position() + allocate.limit());
        }
        if (a2 == Framedata.Opcode.CLOSING) {
            dVar = new com.mixpanel.android.java_websocket.framing.b();
        } else {
            dVar = new d();
            dVar.a(z);
            dVar.a(a2);
        }
        allocate.flip();
        dVar.a(allocate);
        return dVar;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public void a() {
        this.g = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft c() {
        return new Draft_10();
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType b() {
        return Draft.CloseHandshakeType.TWOWAY;
    }
}

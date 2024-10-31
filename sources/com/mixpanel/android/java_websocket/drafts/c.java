package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.b.f;
import com.mixpanel.android.java_websocket.b.h;
import com.mixpanel.android.java_websocket.b.i;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* compiled from: Draft_76.java */
@SuppressLint({"UseValueOf"})
/* loaded from: classes.dex */
public class c extends b {
    private static final byte[] j = {-1, 0};
    private boolean i = false;
    private final Random k = new Random();

    public static byte[] a(String str, String str2, byte[] bArr) throws InvalidHandshakeException {
        byte[] a2 = a(str);
        byte[] a3 = a(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{a2[0], a2[1], a2[2], a2[3], a3[0], a3[1], a3[2], a3[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String e() {
        Random random = new Random();
        long nextInt = random.nextInt(12) + 1;
        String l = Long.toString((random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1) * nextInt);
        int nextInt2 = random.nextInt(12) + 1;
        for (int i = 0; i < nextInt2; i++) {
            int abs = Math.abs(random.nextInt(l.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l = new StringBuilder(l).insert(abs, nextInt3).toString();
        }
        String str = l;
        for (int i2 = 0; i2 < nextInt; i2++) {
            str = new StringBuilder(str).insert(Math.abs(random.nextInt(str.length() - 1) + 1), " ").toString();
        }
        return str;
    }

    private static byte[] a(String str) throws InvalidHandshakeException {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = str.split(" ").length - 1;
            if (length == 0) {
                throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
            }
            long longValue = new Long(parseLong / length).longValue();
            return new byte[]{(byte) (longValue >> 24), (byte) ((longValue << 8) >> 24), (byte) ((longValue << 16) >> 24), (byte) ((longValue << 24) >> 24)};
        } catch (NumberFormatException e) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar, h hVar) {
        if (this.i) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        try {
            if (!hVar.b("Sec-WebSocket-Origin").equals(aVar.b("Origin")) || !a(hVar)) {
                return Draft.HandshakeState.NOT_MATCHED;
            }
            byte[] c = hVar.c();
            if (c == null || c.length == 0) {
                throw new IncompleteHandshakeException();
            }
            if (Arrays.equals(c, a(aVar.b("Sec-WebSocket-Key1"), aVar.b("Sec-WebSocket-Key2"), aVar.c()))) {
                return Draft.HandshakeState.MATCHED;
            }
            return Draft.HandshakeState.NOT_MATCHED;
        } catch (InvalidHandshakeException e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar) {
        return (aVar.b("Upgrade").equals("WebSocket") && aVar.b("Connection").contains("Upgrade") && aVar.b("Sec-WebSocket-Key1").length() > 0 && !aVar.b("Sec-WebSocket-Key2").isEmpty() && aVar.c("Origin")) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public com.mixpanel.android.java_websocket.b.b a(com.mixpanel.android.java_websocket.b.b bVar) {
        bVar.a("Upgrade", "WebSocket");
        bVar.a("Connection", "Upgrade");
        bVar.a("Sec-WebSocket-Key1", e());
        bVar.a("Sec-WebSocket-Key2", e());
        if (!bVar.c("Origin")) {
            bVar.a("Origin", "random" + this.k.nextInt());
        }
        byte[] bArr = new byte[8];
        this.k.nextBytes(bArr);
        bVar.a(bArr);
        return bVar;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public com.mixpanel.android.java_websocket.b.c a(com.mixpanel.android.java_websocket.b.a aVar, i iVar) throws InvalidHandshakeException {
        iVar.a("WebSocket Protocol Handshake");
        iVar.a("Upgrade", "WebSocket");
        iVar.a("Connection", aVar.b("Connection"));
        iVar.a("Sec-WebSocket-Origin", aVar.b("Origin"));
        iVar.a("Sec-WebSocket-Location", "ws://" + aVar.b("Host") + aVar.a());
        String b = aVar.b("Sec-WebSocket-Key1");
        String b2 = aVar.b("Sec-WebSocket-Key2");
        byte[] c = aVar.c();
        if (b == null || b2 == null || c == null || c.length != 8) {
            throw new InvalidHandshakeException("Bad keys");
        }
        iVar.a(a(b, b2, c));
        return iVar;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public f d(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        com.mixpanel.android.java_websocket.b.c a2 = a(byteBuffer, this.d);
        if ((a2.c("Sec-WebSocket-Key1") || this.d == WebSocket.Role.CLIENT) && !a2.c("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[this.d == WebSocket.Role.SERVER ? 8 : 16];
            try {
                byteBuffer.get(bArr);
                a2.a(bArr);
            } catch (BufferUnderflowException e) {
                throw new IncompleteHandshakeException(byteBuffer.capacity() + 16);
            }
        }
        return a2;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public List<Framedata> c(ByteBuffer byteBuffer) throws InvalidDataException {
        byteBuffer.mark();
        List<Framedata> e = super.e(byteBuffer);
        if (e == null) {
            byteBuffer.reset();
            e = this.g;
            this.f = true;
            if (this.h == null) {
                this.h = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() > this.h.remaining()) {
                    throw new InvalidFrameException();
                }
                this.h.put(byteBuffer);
                if (!this.h.hasRemaining()) {
                    if (Arrays.equals(this.h.array(), j)) {
                        e.add(new com.mixpanel.android.java_websocket.framing.b(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED));
                    } else {
                        throw new InvalidFrameException();
                    }
                } else {
                    this.g = new LinkedList();
                }
            } else {
                throw new InvalidFrameException();
            }
        }
        return e;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        return framedata.f() == Framedata.Opcode.CLOSING ? ByteBuffer.wrap(j) : super.a(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType b() {
        return Draft.CloseHandshakeType.ONEWAY;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.b, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft c() {
        return new c();
    }
}

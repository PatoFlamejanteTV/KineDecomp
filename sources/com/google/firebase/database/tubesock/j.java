package com.google.firebase.database.tubesock;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a */
    private BlockingQueue<ByteBuffer> f17259a;

    /* renamed from: e */
    private WebSocket f17263e;

    /* renamed from: f */
    private WritableByteChannel f17264f;

    /* renamed from: b */
    private final Random f17260b = new Random();

    /* renamed from: c */
    private volatile boolean f17261c = false;

    /* renamed from: d */
    private boolean f17262d = false;

    /* renamed from: g */
    private final Thread f17265g = WebSocket.g().newThread(new i(this));

    public j(WebSocket webSocket, String str, int i) {
        WebSocket.f().a(a(), str + "Writer-" + i);
        this.f17263e = webSocket;
        this.f17259a = new LinkedBlockingQueue();
    }

    private ByteBuffer b(byte b2, boolean z, byte[] bArr) throws IOException {
        int i = z ? 6 : 2;
        int length = bArr.length;
        if (length >= 126) {
            i = length <= 65535 ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i);
        allocate.put((byte) (b2 | Byte.MIN_VALUE));
        if (length < 126) {
            if (z) {
                length |= 128;
            }
            allocate.put((byte) length);
        } else if (length <= 65535) {
            allocate.put((byte) (z ? 254 : 126));
            allocate.putShort((short) length);
        } else {
            allocate.put((byte) (z ? 255 : 127));
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] c2 = c();
            allocate.put(c2);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                allocate.put((byte) (bArr[i2] ^ c2[i2 % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] c() {
        byte[] bArr = new byte[4];
        this.f17260b.nextBytes(bArr);
        return bArr;
    }

    public void d() {
        while (!this.f17261c && !Thread.interrupted()) {
            try {
                e();
            } catch (IOException e2) {
                a(new WebSocketException("IO Exception", e2));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i = 0; i < this.f17259a.size(); i++) {
            e();
        }
    }

    private void e() throws InterruptedException, IOException {
        this.f17264f.write(this.f17259a.take());
    }

    public void a(OutputStream outputStream) {
        this.f17264f = Channels.newChannel(outputStream);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:            r1.f17262d = true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(byte r2, boolean r3, byte[] r4) throws java.io.IOException {
        /*
            r1 = this;
            monitor-enter(r1)
            java.nio.ByteBuffer r3 = r1.b(r2, r3, r4)     // Catch: java.lang.Throwable -> L26
            boolean r4 = r1.f17261c     // Catch: java.lang.Throwable -> L26
            r0 = 8
            if (r4 == 0) goto L1a
            boolean r4 = r1.f17262d     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L12
            if (r2 != r0) goto L12
            goto L1a
        L12:
            com.google.firebase.database.tubesock.WebSocketException r2 = new com.google.firebase.database.tubesock.WebSocketException     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "Shouldn't be sending"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L26
            throw r2     // Catch: java.lang.Throwable -> L26
        L1a:
            if (r2 != r0) goto L1f
            r2 = 1
            r1.f17262d = r2     // Catch: java.lang.Throwable -> L26
        L1f:
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r2 = r1.f17259a     // Catch: java.lang.Throwable -> L26
            r2.add(r3)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r1)
            return
        L26:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.tubesock.j.a(byte, boolean, byte[]):void");
    }

    private void a(WebSocketException webSocketException) {
        this.f17263e.a(webSocketException);
    }

    public Thread a() {
        return this.f17265g;
    }

    public void b() {
        this.f17261c = true;
    }
}

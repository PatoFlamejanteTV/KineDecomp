package com.google.firebase.database.tubesock;

import com.google.firebase.database.tubesock.a;
import com.umeng.commonsdk.proguard.ap;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: b */
    private WebSocket f17253b;

    /* renamed from: e */
    private a.b f17256e;

    /* renamed from: a */
    private DataInputStream f17252a = null;

    /* renamed from: c */
    private WebSocketEventHandler f17254c = null;

    /* renamed from: d */
    private byte[] f17255d = new byte[112];

    /* renamed from: f */
    private volatile boolean f17257f = false;

    public h(WebSocket webSocket) {
        this.f17253b = null;
        this.f17253b = webSocket;
    }

    public void a(DataInputStream dataInputStream) {
        this.f17252a = dataInputStream;
    }

    public void b() {
        this.f17257f = true;
    }

    public void a() {
        boolean z;
        this.f17254c = this.f17253b.d();
        while (!this.f17257f) {
            try {
                a(this.f17255d, 0, 1);
                z = (this.f17255d[0] & 128) != 0;
            } catch (WebSocketException e2) {
                a(e2);
            } catch (SocketTimeoutException unused) {
            } catch (IOException e3) {
                a(new WebSocketException("IO Error", e3));
            }
            if (!((this.f17255d[0] & 112) != 0)) {
                byte b2 = (byte) (this.f17255d[0] & ap.m);
                a(this.f17255d, 1, 1);
                byte b3 = this.f17255d[1];
                long j = 0;
                if (b3 < 126) {
                    j = b3;
                } else if (b3 == 126) {
                    a(this.f17255d, 2, 2);
                    j = ((this.f17255d[2] & 255) << 8) | (this.f17255d[3] & 255);
                } else if (b3 == Byte.MAX_VALUE) {
                    a(this.f17255d, 2, 8);
                    j = a(this.f17255d, 2);
                }
                int i = (int) j;
                byte[] bArr = new byte[i];
                a(bArr, 0, i);
                if (b2 == 8) {
                    this.f17253b.h();
                } else if (b2 != 10) {
                    if (b2 != 1 && b2 != 2 && b2 != 9 && b2 != 0) {
                        throw new WebSocketException("Unsupported opcode: " + ((int) b2));
                    }
                    a(z, b2, bArr);
                }
            } else {
                throw new WebSocketException("Invalid frame received");
            }
        }
    }

    private void a(boolean z, byte b2, byte[] bArr) {
        if (b2 == 9) {
            if (z) {
                a(bArr);
                return;
            }
            throw new WebSocketException("PING must not fragment across frames");
        }
        if (this.f17256e != null && b2 != 0) {
            throw new WebSocketException("Failed to continue outstanding frame");
        }
        if (this.f17256e == null && b2 == 0) {
            throw new WebSocketException("Received continuing frame, but there's nothing to continue");
        }
        if (this.f17256e == null) {
            this.f17256e = a.a(b2);
        }
        if (!this.f17256e.a(bArr)) {
            throw new WebSocketException("Failed to decode frame");
        }
        if (z) {
            WebSocketMessage a2 = this.f17256e.a();
            this.f17256e = null;
            if (a2 != null) {
                this.f17254c.a(a2);
                return;
            }
            throw new WebSocketException("Failed to decode whole message");
        }
    }

    private void a(byte[] bArr) {
        if (bArr.length <= 125) {
            this.f17253b.a(bArr);
            return;
        }
        throw new WebSocketException("PING frame too long");
    }

    private long a(byte[] bArr, int i) {
        return (bArr[i + 0] << 56) + ((bArr[i + 1] & 255) << 48) + ((bArr[i + 2] & 255) << 40) + ((bArr[i + 3] & 255) << 32) + ((bArr[i + 4] & 255) << 24) + ((bArr[i + 5] & 255) << 16) + ((bArr[i + 6] & 255) << 8) + ((bArr[i + 7] & 255) << 0);
    }

    private int a(byte[] bArr, int i, int i2) throws IOException {
        this.f17252a.readFully(bArr, i, i2);
        return i2;
    }

    private void a(WebSocketException webSocketException) {
        b();
        this.f17253b.a(webSocketException);
    }
}

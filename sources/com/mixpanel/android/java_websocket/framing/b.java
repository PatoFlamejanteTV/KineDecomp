package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.nio.ByteBuffer;

/* compiled from: CloseFrameBuilder.java */
/* loaded from: classes.dex */
public class b extends d implements a {

    /* renamed from: a, reason: collision with root package name */
    static final ByteBuffer f2998a = ByteBuffer.allocate(0);
    private int f;
    private String g;

    public b() {
        super(Framedata.Opcode.CLOSING);
        a(true);
    }

    public b(int i) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        a(true);
        a(i, "");
    }

    public b(int i, String str) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        a(true);
        a(i, str);
    }

    private void a(int i, String str) throws InvalidDataException {
        String str2 = str == null ? "" : str;
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i == 1005) {
            if (str2.length() > 0) {
                throw new InvalidDataException(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, "A close frame must have a closecode if it has a reason");
            }
            return;
        }
        byte[] a2 = com.mixpanel.android.java_websocket.c.b.a(str2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(a2.length + 2);
        allocate2.put(allocate);
        allocate2.put(a2);
        allocate2.rewind();
        a(allocate2);
    }

    private void g() throws InvalidFrameException {
        this.f = 1005;
        ByteBuffer c = super.c();
        c.mark();
        if (c.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(c.getShort());
            allocate.position(0);
            this.f = allocate.getInt();
            if (this.f == 1006 || this.f == 1015 || this.f == 1005 || this.f > 4999 || this.f < 1000 || this.f == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f);
            }
        }
        c.reset();
    }

    @Override // com.mixpanel.android.java_websocket.framing.a
    public int a() {
        return this.f;
    }

    private void h() throws InvalidDataException {
        if (this.f == 1005) {
            this.g = com.mixpanel.android.java_websocket.c.b.a(super.c());
            return;
        }
        ByteBuffer c = super.c();
        int position = c.position();
        try {
            try {
                c.position(c.position() + 2);
                this.g = com.mixpanel.android.java_websocket.c.b.a(c);
            } catch (IllegalArgumentException e) {
                throw new InvalidFrameException(e);
            }
        } finally {
            c.position(position);
        }
    }

    @Override // com.mixpanel.android.java_websocket.framing.a
    public String b() {
        return this.g;
    }

    @Override // com.mixpanel.android.java_websocket.framing.d
    public String toString() {
        return super.toString() + "code: " + this.f;
    }

    @Override // com.mixpanel.android.java_websocket.framing.d, com.mixpanel.android.java_websocket.framing.c
    public void a(ByteBuffer byteBuffer) throws InvalidDataException {
        super.a(byteBuffer);
        g();
        h();
    }

    @Override // com.mixpanel.android.java_websocket.framing.d, com.mixpanel.android.java_websocket.framing.Framedata
    public ByteBuffer c() {
        return this.f == 1005 ? f2998a : super.c();
    }
}

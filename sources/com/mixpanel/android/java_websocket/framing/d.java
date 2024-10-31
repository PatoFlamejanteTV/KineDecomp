package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: FramedataImpl1.java */
/* loaded from: classes.dex */
public class d implements c {
    protected static byte[] b = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f2999a;
    protected boolean c;
    protected Framedata.Opcode d;
    protected boolean e;

    public d() {
    }

    public d(Framedata.Opcode opcode) {
        this.d = opcode;
        this.f2999a = ByteBuffer.wrap(b);
    }

    public d(Framedata framedata) {
        this.c = framedata.d();
        this.d = framedata.f();
        this.f2999a = framedata.c();
        this.e = framedata.e();
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public boolean d() {
        return this.c;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public Framedata.Opcode f() {
        return this.d;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public boolean e() {
        return this.e;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public ByteBuffer c() {
        return this.f2999a;
    }

    @Override // com.mixpanel.android.java_websocket.framing.c
    public void a(boolean z) {
        this.c = z;
    }

    @Override // com.mixpanel.android.java_websocket.framing.c
    public void a(Framedata.Opcode opcode) {
        this.d = opcode;
    }

    @Override // com.mixpanel.android.java_websocket.framing.c
    public void a(ByteBuffer byteBuffer) throws InvalidDataException {
        this.f2999a = byteBuffer;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f2999a.position() + ", len:" + this.f2999a.remaining() + "], payload:" + Arrays.toString(com.mixpanel.android.java_websocket.c.b.a(new String(this.f2999a.array()))) + "}";
    }
}

package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Timestamp extends GeneratedMessageLite<Timestamp, Builder> implements TimestampOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Timestamp f18693d = new Timestamp();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Timestamp> f18694e;

    /* renamed from: f, reason: collision with root package name */
    private long f18695f;

    /* renamed from: g, reason: collision with root package name */
    private int f18696g;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Timestamp, Builder> implements TimestampOrBuilder {
        /* synthetic */ Builder(ba baVar) {
            this();
        }

        private Builder() {
            super(Timestamp.f18693d);
        }
    }

    static {
        f18693d.l();
    }

    private Timestamp() {
    }

    public static Timestamp n() {
        return f18693d;
    }

    public static Parser<Timestamp> o() {
        return f18693d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.f18695f;
        if (j != 0) {
            codedOutputStream.e(1, j);
        }
        int i = this.f18696g;
        if (i != 0) {
            codedOutputStream.g(2, i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        long j = this.f18695f;
        int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        int i2 = this.f18696g;
        if (i2 != 0) {
            b2 += CodedOutputStream.c(2, i2);
        }
        this.f18584c = b2;
        return b2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        ba baVar = null;
        switch (ba.f18745a[methodToInvoke.ordinal()]) {
            case 1:
                return new Timestamp();
            case 2:
                return f18693d;
            case 3:
                return null;
            case 4:
                return new Builder(baVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Timestamp timestamp = (Timestamp) obj2;
                this.f18695f = visitor.a(this.f18695f != 0, this.f18695f, timestamp.f18695f != 0, timestamp.f18695f);
                this.f18696g = visitor.a(this.f18696g != 0, this.f18696g, timestamp.f18696g != 0, timestamp.f18696g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                this.f18695f = codedInputStream.k();
                            } else if (x != 16) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18696g = codedInputStream.j();
                            }
                        }
                        r1 = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f18694e == null) {
                    synchronized (Timestamp.class) {
                        if (f18694e == null) {
                            f18694e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18693d);
                        }
                    }
                }
                return f18694e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18693d;
    }
}

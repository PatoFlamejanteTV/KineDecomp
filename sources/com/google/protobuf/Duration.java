package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Duration extends GeneratedMessageLite<Duration, Builder> implements DurationOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Duration f18543d = new Duration();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Duration> f18544e;

    /* renamed from: f, reason: collision with root package name */
    private long f18545f;

    /* renamed from: g, reason: collision with root package name */
    private int f18546g;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Duration, Builder> implements DurationOrBuilder {
        /* synthetic */ Builder(C1663q c1663q) {
            this();
        }

        private Builder() {
            super(Duration.f18543d);
        }
    }

    static {
        f18543d.l();
    }

    private Duration() {
    }

    public static Duration n() {
        return f18543d;
    }

    public static Parser<Duration> o() {
        return f18543d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.f18545f;
        if (j != 0) {
            codedOutputStream.e(1, j);
        }
        int i = this.f18546g;
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
        long j = this.f18545f;
        int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        int i2 = this.f18546g;
        if (i2 != 0) {
            b2 += CodedOutputStream.c(2, i2);
        }
        this.f18584c = b2;
        return b2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1663q c1663q = null;
        switch (C1663q.f18794a[methodToInvoke.ordinal()]) {
            case 1:
                return new Duration();
            case 2:
                return f18543d;
            case 3:
                return null;
            case 4:
                return new Builder(c1663q);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Duration duration = (Duration) obj2;
                this.f18545f = visitor.a(this.f18545f != 0, this.f18545f, duration.f18545f != 0, duration.f18545f);
                this.f18546g = visitor.a(this.f18546g != 0, this.f18546g, duration.f18546g != 0, duration.f18546g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                this.f18545f = codedInputStream.k();
                            } else if (x != 16) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18546g = codedInputStream.j();
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
                if (f18544e == null) {
                    synchronized (Duration.class) {
                        if (f18544e == null) {
                            f18544e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18543d);
                        }
                    }
                }
                return f18544e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18543d;
    }
}

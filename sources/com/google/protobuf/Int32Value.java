package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Int32Value extends GeneratedMessageLite<Int32Value, Builder> implements Int32ValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Int32Value f18611d = new Int32Value();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Int32Value> f18612e;

    /* renamed from: f, reason: collision with root package name */
    private int f18613f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Int32Value, Builder> implements Int32ValueOrBuilder {
        /* synthetic */ Builder(C c2) {
            this();
        }

        private Builder() {
            super(Int32Value.f18611d);
        }
    }

    static {
        f18611d.l();
    }

    private Int32Value() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.f18613f;
        if (i != 0) {
            codedOutputStream.g(1, i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = this.f18613f;
        int c2 = i2 != 0 ? 0 + CodedOutputStream.c(1, i2) : 0;
        this.f18584c = c2;
        return c2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C c2 = null;
        switch (C.f18397a[methodToInvoke.ordinal()]) {
            case 1:
                return new Int32Value();
            case 2:
                return f18611d;
            case 3:
                return null;
            case 4:
                return new Builder(c2);
            case 5:
                Int32Value int32Value = (Int32Value) obj2;
                this.f18613f = ((GeneratedMessageLite.Visitor) obj).a(this.f18613f != 0, this.f18613f, int32Value.f18613f != 0, int32Value.f18613f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 8) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18613f = codedInputStream.j();
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
                if (f18612e == null) {
                    synchronized (Int32Value.class) {
                        if (f18612e == null) {
                            f18612e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18611d);
                        }
                    }
                }
                return f18612e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18611d;
    }
}

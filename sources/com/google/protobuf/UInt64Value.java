package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class UInt64Value extends GeneratedMessageLite<UInt64Value, Builder> implements UInt64ValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final UInt64Value f18720d = new UInt64Value();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<UInt64Value> f18721e;

    /* renamed from: f, reason: collision with root package name */
    private long f18722f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<UInt64Value, Builder> implements UInt64ValueOrBuilder {
        /* synthetic */ Builder(ea eaVar) {
            this();
        }

        private Builder() {
            super(UInt64Value.f18720d);
        }
    }

    static {
        f18720d.l();
    }

    private UInt64Value() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.f18722f;
        if (j != 0) {
            codedOutputStream.f(1, j);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        long j = this.f18722f;
        int c2 = j != 0 ? 0 + CodedOutputStream.c(1, j) : 0;
        this.f18584c = c2;
        return c2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        ea eaVar = null;
        boolean z = false;
        switch (ea.f18774a[methodToInvoke.ordinal()]) {
            case 1:
                return new UInt64Value();
            case 2:
                return f18720d;
            case 3:
                return null;
            case 4:
                return new Builder(eaVar);
            case 5:
                UInt64Value uInt64Value = (UInt64Value) obj2;
                this.f18722f = ((GeneratedMessageLite.Visitor) obj).a(this.f18722f != 0, this.f18722f, uInt64Value.f18722f != 0, uInt64Value.f18722f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 8) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18722f = codedInputStream.z();
                            }
                        }
                        z = true;
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
                if (f18721e == null) {
                    synchronized (UInt64Value.class) {
                        if (f18721e == null) {
                            f18721e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18720d);
                        }
                    }
                }
                return f18721e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18720d;
    }
}

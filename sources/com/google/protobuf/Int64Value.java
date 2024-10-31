package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Int64Value extends GeneratedMessageLite<Int64Value, Builder> implements Int64ValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Int64Value f18614d = new Int64Value();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Int64Value> f18615e;

    /* renamed from: f, reason: collision with root package name */
    private long f18616f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Int64Value, Builder> implements Int64ValueOrBuilder {
        /* synthetic */ Builder(D d2) {
            this();
        }

        private Builder() {
            super(Int64Value.f18614d);
        }
    }

    static {
        f18614d.l();
    }

    private Int64Value() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.f18616f;
        if (j != 0) {
            codedOutputStream.e(1, j);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        long j = this.f18616f;
        int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        this.f18584c = b2;
        return b2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        D d2 = null;
        boolean z = false;
        switch (D.f18418a[methodToInvoke.ordinal()]) {
            case 1:
                return new Int64Value();
            case 2:
                return f18614d;
            case 3:
                return null;
            case 4:
                return new Builder(d2);
            case 5:
                Int64Value int64Value = (Int64Value) obj2;
                this.f18616f = ((GeneratedMessageLite.Visitor) obj).a(this.f18616f != 0, this.f18616f, int64Value.f18616f != 0, int64Value.f18616f);
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
                                this.f18616f = codedInputStream.k();
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
                if (f18615e == null) {
                    synchronized (Int64Value.class) {
                        if (f18615e == null) {
                            f18615e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18614d);
                        }
                    }
                }
                return f18615e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18614d;
    }
}

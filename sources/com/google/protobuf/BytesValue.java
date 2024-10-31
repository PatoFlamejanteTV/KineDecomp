package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class BytesValue extends GeneratedMessageLite<BytesValue, Builder> implements BytesValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final BytesValue f18394d = new BytesValue();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<BytesValue> f18395e;

    /* renamed from: f, reason: collision with root package name */
    private ByteString f18396f = ByteString.EMPTY;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BytesValue, Builder> implements BytesValueOrBuilder {
        /* synthetic */ Builder(C1652f c1652f) {
            this();
        }

        private Builder() {
            super(BytesValue.f18394d);
        }
    }

    static {
        f18394d.l();
    }

    private BytesValue() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18396f.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, this.f18396f);
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18396f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, this.f18396f);
        this.f18584c = a2;
        return a2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1652f c1652f = null;
        switch (C1652f.f18775a[methodToInvoke.ordinal()]) {
            case 1:
                return new BytesValue();
            case 2:
                return f18394d;
            case 3:
                return null;
            case 4:
                return new Builder(c1652f);
            case 5:
                BytesValue bytesValue = (BytesValue) obj2;
                this.f18396f = ((GeneratedMessageLite.Visitor) obj).a(this.f18396f != ByteString.EMPTY, this.f18396f, bytesValue.f18396f != ByteString.EMPTY, bytesValue.f18396f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 10) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18396f = codedInputStream.d();
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
                if (f18395e == null) {
                    synchronized (BytesValue.class) {
                        if (f18395e == null) {
                            f18395e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18394d);
                        }
                    }
                }
                return f18395e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18394d;
    }
}

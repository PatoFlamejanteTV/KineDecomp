package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class DoubleValue extends GeneratedMessageLite<DoubleValue, Builder> implements DoubleValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final DoubleValue f18540d = new DoubleValue();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<DoubleValue> f18541e;

    /* renamed from: f, reason: collision with root package name */
    private double f18542f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DoubleValue, Builder> implements DoubleValueOrBuilder {
        /* synthetic */ Builder(C1662p c1662p) {
            this();
        }

        private Builder() {
            super(DoubleValue.f18540d);
        }
    }

    static {
        f18540d.l();
    }

    private DoubleValue() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        double d2 = this.f18542f;
        if (d2 != 0.0d) {
            codedOutputStream.b(1, d2);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        double d2 = this.f18542f;
        int a2 = d2 != 0.0d ? 0 + CodedOutputStream.a(1, d2) : 0;
        this.f18584c = a2;
        return a2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1662p c1662p = null;
        boolean z = false;
        switch (C1662p.f18793a[methodToInvoke.ordinal()]) {
            case 1:
                return new DoubleValue();
            case 2:
                return f18540d;
            case 3:
                return null;
            case 4:
                return new Builder(c1662p);
            case 5:
                DoubleValue doubleValue = (DoubleValue) obj2;
                this.f18542f = ((GeneratedMessageLite.Visitor) obj).a(this.f18542f != 0.0d, this.f18542f, doubleValue.f18542f != 0.0d, doubleValue.f18542f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 9) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18542f = codedInputStream.e();
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
                if (f18541e == null) {
                    synchronized (DoubleValue.class) {
                        if (f18541e == null) {
                            f18541e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18540d);
                        }
                    }
                }
                return f18541e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18540d;
    }
}

package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class BoolValue extends GeneratedMessageLite<BoolValue, Builder> implements BoolValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final BoolValue f18382d = new BoolValue();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<BoolValue> f18383e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18384f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BoolValue, Builder> implements BoolValueOrBuilder {
        /* synthetic */ Builder(C1650d c1650d) {
            this();
        }

        private Builder() {
            super(BoolValue.f18382d);
        }
    }

    static {
        f18382d.l();
    }

    private BoolValue() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        boolean z = this.f18384f;
        if (z) {
            codedOutputStream.b(1, z);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        boolean z = this.f18384f;
        int a2 = z ? 0 + CodedOutputStream.a(1, z) : 0;
        this.f18584c = a2;
        return a2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1650d c1650d = null;
        switch (C1650d.f18769a[methodToInvoke.ordinal()]) {
            case 1:
                return new BoolValue();
            case 2:
                return f18382d;
            case 3:
                return null;
            case 4:
                return new Builder(c1650d);
            case 5:
                boolean z = this.f18384f;
                boolean z2 = ((BoolValue) obj2).f18384f;
                this.f18384f = ((GeneratedMessageLite.Visitor) obj).a(z, z, z2, z2);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 8) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18384f = codedInputStream.c();
                            }
                        }
                        z3 = true;
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
                if (f18383e == null) {
                    synchronized (BoolValue.class) {
                        if (f18383e == null) {
                            f18383e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18382d);
                        }
                    }
                }
                return f18383e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18382d;
    }
}

package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class FloatValue extends GeneratedMessageLite<FloatValue, Builder> implements FloatValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final FloatValue f18579d = new FloatValue();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<FloatValue> f18580e;

    /* renamed from: f, reason: collision with root package name */
    private float f18581f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<FloatValue, Builder> implements FloatValueOrBuilder {
        /* synthetic */ Builder(A a2) {
            this();
        }

        private Builder() {
            super(FloatValue.f18579d);
        }
    }

    static {
        f18579d.l();
    }

    private FloatValue() {
    }

    public static FloatValue n() {
        return f18579d;
    }

    public static Parser<FloatValue> o() {
        return f18579d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        float f2 = this.f18581f;
        if (f2 != 0.0f) {
            codedOutputStream.b(1, f2);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        float f2 = this.f18581f;
        int a2 = f2 != 0.0f ? 0 + CodedOutputStream.a(1, f2) : 0;
        this.f18584c = a2;
        return a2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        A a2 = null;
        switch (A.f18369a[methodToInvoke.ordinal()]) {
            case 1:
                return new FloatValue();
            case 2:
                return f18579d;
            case 3:
                return null;
            case 4:
                return new Builder(a2);
            case 5:
                FloatValue floatValue = (FloatValue) obj2;
                this.f18581f = ((GeneratedMessageLite.Visitor) obj).a(this.f18581f != 0.0f, this.f18581f, floatValue.f18581f != 0.0f, floatValue.f18581f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 13) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18581f = codedInputStream.i();
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
                if (f18580e == null) {
                    synchronized (FloatValue.class) {
                        if (f18580e == null) {
                            f18580e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18579d);
                        }
                    }
                }
                return f18580e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18579d;
    }
}

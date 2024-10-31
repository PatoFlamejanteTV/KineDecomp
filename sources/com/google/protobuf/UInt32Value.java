package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class UInt32Value extends GeneratedMessageLite<UInt32Value, Builder> implements UInt32ValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final UInt32Value f18717d = new UInt32Value();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<UInt32Value> f18718e;

    /* renamed from: f, reason: collision with root package name */
    private int f18719f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<UInt32Value, Builder> implements UInt32ValueOrBuilder {
        /* synthetic */ Builder(da daVar) {
            this();
        }

        private Builder() {
            super(UInt32Value.f18717d);
        }
    }

    static {
        f18717d.l();
    }

    private UInt32Value() {
    }

    public static UInt32Value n() {
        return f18717d;
    }

    public static Parser<UInt32Value> o() {
        return f18717d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.f18719f;
        if (i != 0) {
            codedOutputStream.i(1, i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = this.f18719f;
        int d2 = i2 != 0 ? 0 + CodedOutputStream.d(1, i2) : 0;
        this.f18584c = d2;
        return d2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        da daVar = null;
        switch (da.f18770a[methodToInvoke.ordinal()]) {
            case 1:
                return new UInt32Value();
            case 2:
                return f18717d;
            case 3:
                return null;
            case 4:
                return new Builder(daVar);
            case 5:
                UInt32Value uInt32Value = (UInt32Value) obj2;
                this.f18719f = ((GeneratedMessageLite.Visitor) obj).a(this.f18719f != 0, this.f18719f, uInt32Value.f18719f != 0, uInt32Value.f18719f);
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
                                this.f18719f = codedInputStream.y();
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
                if (f18718e == null) {
                    synchronized (UInt32Value.class) {
                        if (f18718e == null) {
                            f18718e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18717d);
                        }
                    }
                }
                return f18718e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18717d;
    }
}

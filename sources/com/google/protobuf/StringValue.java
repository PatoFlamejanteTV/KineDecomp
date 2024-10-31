package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class StringValue extends GeneratedMessageLite<StringValue, Builder> implements StringValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final StringValue f18686d = new StringValue();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<StringValue> f18687e;

    /* renamed from: f, reason: collision with root package name */
    private String f18688f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<StringValue, Builder> implements StringValueOrBuilder {
        /* synthetic */ Builder(W w) {
            this();
        }

        private Builder() {
            super(StringValue.f18686d);
        }
    }

    static {
        f18686d.l();
    }

    private StringValue() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18688f.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18688f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18688f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        W w = null;
        switch (W.f18736a[methodToInvoke.ordinal()]) {
            case 1:
                return new StringValue();
            case 2:
                return f18686d;
            case 3:
                return null;
            case 4:
                return new Builder(w);
            case 5:
                StringValue stringValue = (StringValue) obj2;
                this.f18688f = ((GeneratedMessageLite.Visitor) obj).a(!this.f18688f.isEmpty(), this.f18688f, true ^ stringValue.f18688f.isEmpty(), stringValue.f18688f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 10) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18688f = codedInputStream.w();
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
                if (f18687e == null) {
                    synchronized (StringValue.class) {
                        if (f18687e == null) {
                            f18687e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18686d);
                        }
                    }
                }
                return f18687e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18686d;
    }
}

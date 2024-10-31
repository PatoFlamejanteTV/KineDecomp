package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class SourceContext extends GeneratedMessageLite<SourceContext, Builder> implements SourceContextOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final SourceContext f18683d = new SourceContext();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<SourceContext> f18684e;

    /* renamed from: f, reason: collision with root package name */
    private String f18685f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SourceContext, Builder> implements SourceContextOrBuilder {
        /* synthetic */ Builder(V v) {
            this();
        }

        private Builder() {
            super(SourceContext.f18683d);
        }
    }

    static {
        f18683d.l();
    }

    private SourceContext() {
    }

    public static SourceContext n() {
        return f18683d;
    }

    public static Parser<SourceContext> p() {
        return f18683d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18685f.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18685f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        this.f18584c = a2;
        return a2;
    }

    public String o() {
        return this.f18685f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        V v = null;
        switch (V.f18731a[methodToInvoke.ordinal()]) {
            case 1:
                return new SourceContext();
            case 2:
                return f18683d;
            case 3:
                return null;
            case 4:
                return new Builder(v);
            case 5:
                SourceContext sourceContext = (SourceContext) obj2;
                this.f18685f = ((GeneratedMessageLite.Visitor) obj).a(!this.f18685f.isEmpty(), this.f18685f, true ^ sourceContext.f18685f.isEmpty(), sourceContext.f18685f);
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
                                this.f18685f = codedInputStream.w();
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
                if (f18684e == null) {
                    synchronized (SourceContext.class) {
                        if (f18684e == null) {
                            f18684e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18683d);
                        }
                    }
                }
                return f18684e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18683d;
    }
}

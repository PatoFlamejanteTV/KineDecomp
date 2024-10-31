package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Mixin extends GeneratedMessageLite<Mixin, Builder> implements MixinOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Mixin f18661d = new Mixin();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Mixin> f18662e;

    /* renamed from: f, reason: collision with root package name */
    private String f18663f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18664g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Mixin, Builder> implements MixinOrBuilder {
        /* synthetic */ Builder(L l) {
            this();
        }

        private Builder() {
            super(Mixin.f18661d);
        }
    }

    static {
        f18661d.l();
    }

    private Mixin() {
    }

    public static Parser<Mixin> p() {
        return f18661d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18663f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f18664g.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18663f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        if (!this.f18664g.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18663f;
    }

    public String o() {
        return this.f18664g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        L l = null;
        switch (L.f18633a[methodToInvoke.ordinal()]) {
            case 1:
                return new Mixin();
            case 2:
                return f18661d;
            case 3:
                return null;
            case 4:
                return new Builder(l);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Mixin mixin = (Mixin) obj2;
                this.f18663f = visitor.a(!this.f18663f.isEmpty(), this.f18663f, !mixin.f18663f.isEmpty(), mixin.f18663f);
                this.f18664g = visitor.a(!this.f18664g.isEmpty(), this.f18664g, true ^ mixin.f18664g.isEmpty(), mixin.f18664g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18663f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18664g = codedInputStream.w();
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
                if (f18662e == null) {
                    synchronized (Mixin.class) {
                        if (f18662e == null) {
                            f18662e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18661d);
                        }
                    }
                }
                return f18662e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18661d;
    }
}

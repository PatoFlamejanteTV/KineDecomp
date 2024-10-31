package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Any extends GeneratedMessageLite<Any, Builder> implements AnyOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Any f18372d = new Any();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Any> f18373e;

    /* renamed from: f, reason: collision with root package name */
    private String f18374f = "";

    /* renamed from: g, reason: collision with root package name */
    private ByteString f18375g = ByteString.EMPTY;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Any, Builder> implements AnyOrBuilder {
        /* synthetic */ Builder(C1648b c1648b) {
            this();
        }

        private Builder() {
            super(Any.f18372d);
        }
    }

    static {
        f18372d.l();
    }

    private Any() {
    }

    public static Any n() {
        return f18372d;
    }

    public static Parser<Any> p() {
        return f18372d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18374f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (this.f18375g.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, this.f18375g);
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18374f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (!this.f18375g.isEmpty()) {
            a2 += CodedOutputStream.a(2, this.f18375g);
        }
        this.f18584c = a2;
        return a2;
    }

    public String o() {
        return this.f18374f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1648b c1648b = null;
        switch (C1648b.f18744a[methodToInvoke.ordinal()]) {
            case 1:
                return new Any();
            case 2:
                return f18372d;
            case 3:
                return null;
            case 4:
                return new Builder(c1648b);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Any any = (Any) obj2;
                this.f18374f = visitor.a(!this.f18374f.isEmpty(), this.f18374f, !any.f18374f.isEmpty(), any.f18374f);
                this.f18375g = visitor.a(this.f18375g != ByteString.EMPTY, this.f18375g, any.f18375g != ByteString.EMPTY, any.f18375g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18374f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18375g = codedInputStream.d();
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
                if (f18373e == null) {
                    synchronized (Any.class) {
                        if (f18373e == null) {
                            f18373e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18372d);
                        }
                    }
                }
                return f18373e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18372d;
    }
}

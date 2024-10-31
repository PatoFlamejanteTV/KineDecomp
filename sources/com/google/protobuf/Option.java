package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Option extends GeneratedMessageLite<Option, Builder> implements OptionOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Option f18668d = new Option();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Option> f18669e;

    /* renamed from: f, reason: collision with root package name */
    private String f18670f = "";

    /* renamed from: g, reason: collision with root package name */
    private Any f18671g;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Option, Builder> implements OptionOrBuilder {
        /* synthetic */ Builder(N n) {
            this();
        }

        private Builder() {
            super(Option.f18668d);
        }
    }

    static {
        f18668d.l();
    }

    private Option() {
    }

    public static Parser<Option> p() {
        return f18668d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18670f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f18671g != null) {
            codedOutputStream.c(2, o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18670f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        if (this.f18671g != null) {
            a2 += CodedOutputStream.a(2, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18670f;
    }

    public Any o() {
        Any any = this.f18671g;
        return any == null ? Any.n() : any;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        N n = null;
        switch (N.f18665a[methodToInvoke.ordinal()]) {
            case 1:
                return new Option();
            case 2:
                return f18668d;
            case 3:
                return null;
            case 4:
                return new Builder(n);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Option option = (Option) obj2;
                this.f18670f = visitor.a(!this.f18670f.isEmpty(), this.f18670f, true ^ option.f18670f.isEmpty(), option.f18670f);
                this.f18671g = (Any) visitor.a(this.f18671g, option.f18671g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18670f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                Any.Builder b2 = this.f18671g != null ? this.f18671g.b() : null;
                                this.f18671g = (Any) codedInputStream.a(Any.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((Any.Builder) this.f18671g);
                                    this.f18671g = b2.T();
                                }
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
                if (f18669e == null) {
                    synchronized (Option.class) {
                        if (f18669e == null) {
                            f18669e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18668d);
                        }
                    }
                }
                return f18669e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18668d;
    }
}

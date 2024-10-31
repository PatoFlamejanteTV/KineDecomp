package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class CustomHttpPattern extends GeneratedMessageLite<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final CustomHttpPattern f14384d = new CustomHttpPattern();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<CustomHttpPattern> f14385e;

    /* renamed from: f, reason: collision with root package name */
    private String f14386f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f14387g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
        /* synthetic */ Builder(C1477o c1477o) {
            this();
        }

        private Builder() {
            super(CustomHttpPattern.f14384d);
        }
    }

    static {
        f14384d.l();
    }

    private CustomHttpPattern() {
    }

    public static Parser<CustomHttpPattern> p() {
        return f14384d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14386f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f14387g.isEmpty()) {
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
        int a2 = this.f14386f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        if (!this.f14387g.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14386f;
    }

    public String o() {
        return this.f14387g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1477o c1477o = null;
        switch (C1477o.f15031a[methodToInvoke.ordinal()]) {
            case 1:
                return new CustomHttpPattern();
            case 2:
                return f14384d;
            case 3:
                return null;
            case 4:
                return new Builder(c1477o);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CustomHttpPattern customHttpPattern = (CustomHttpPattern) obj2;
                this.f14386f = visitor.a(!this.f14386f.isEmpty(), this.f14386f, !customHttpPattern.f14386f.isEmpty(), customHttpPattern.f14386f);
                this.f14387g = visitor.a(!this.f14387g.isEmpty(), this.f14387g, true ^ customHttpPattern.f14387g.isEmpty(), customHttpPattern.f14387g);
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
                                this.f14386f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14387g = codedInputStream.w();
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
                if (f14385e == null) {
                    synchronized (CustomHttpPattern.class) {
                        if (f14385e == null) {
                            f14385e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14384d);
                        }
                    }
                }
                return f14385e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14384d;
    }
}

package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Advice extends GeneratedMessageLite<Advice, Builder> implements AdviceOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Advice f14325d = new Advice();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Advice> f14326e;

    /* renamed from: f, reason: collision with root package name */
    private String f14327f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Advice, Builder> implements AdviceOrBuilder {
        /* synthetic */ Builder(C1463a c1463a) {
            this();
        }

        private Builder() {
            super(Advice.f14325d);
        }
    }

    static {
        f14325d.l();
    }

    private Advice() {
    }

    public static Parser<Advice> o() {
        return f14325d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f14327f.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14327f.isEmpty() ? 0 : 0 + CodedOutputStream.a(2, n());
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14327f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1463a c1463a = null;
        switch (C1463a.f14576a[methodToInvoke.ordinal()]) {
            case 1:
                return new Advice();
            case 2:
                return f14325d;
            case 3:
                return null;
            case 4:
                return new Builder(c1463a);
            case 5:
                Advice advice = (Advice) obj2;
                this.f14327f = ((GeneratedMessageLite.Visitor) obj).a(!this.f14327f.isEmpty(), this.f14327f, true ^ advice.f14327f.isEmpty(), advice.f14327f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14327f = codedInputStream.w();
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
                if (f14326e == null) {
                    synchronized (Advice.class) {
                        if (f14326e == null) {
                            f14326e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14325d);
                        }
                    }
                }
                return f14326e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14325d;
    }
}

package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Control extends GeneratedMessageLite<Control, Builder> implements ControlOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Control f14381d = new Control();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Control> f14382e;

    /* renamed from: f, reason: collision with root package name */
    private String f14383f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Control, Builder> implements ControlOrBuilder {
        /* synthetic */ Builder(C1476n c1476n) {
            this();
        }

        private Builder() {
            super(Control.f14381d);
        }
    }

    static {
        f14381d.l();
    }

    private Control() {
    }

    public static Control n() {
        return f14381d;
    }

    public static Parser<Control> p() {
        return f14381d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f14383f.isEmpty()) {
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
        int a2 = this.f14383f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        this.f18584c = a2;
        return a2;
    }

    public String o() {
        return this.f14383f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1476n c1476n = null;
        switch (C1476n.f15030a[methodToInvoke.ordinal()]) {
            case 1:
                return new Control();
            case 2:
                return f14381d;
            case 3:
                return null;
            case 4:
                return new Builder(c1476n);
            case 5:
                Control control = (Control) obj2;
                this.f14383f = ((GeneratedMessageLite.Visitor) obj).a(!this.f14383f.isEmpty(), this.f14383f, true ^ control.f14383f.isEmpty(), control.f14383f);
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
                                this.f14383f = codedInputStream.w();
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
                if (f14382e == null) {
                    synchronized (Control.class) {
                        if (f14382e == null) {
                            f14382e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14381d);
                        }
                    }
                }
                return f14382e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14381d;
    }
}

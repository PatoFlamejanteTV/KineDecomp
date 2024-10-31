package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Empty extends GeneratedMessageLite<Empty, Builder> implements EmptyOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Empty f18550d = new Empty();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Empty> f18551e;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Empty, Builder> implements EmptyOrBuilder {
        /* synthetic */ Builder(r rVar) {
            this();
        }

        private Builder() {
            super(Empty.f18550d);
        }
    }

    static {
        f18550d.l();
    }

    private Empty() {
    }

    public static Empty n() {
        return f18550d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        r rVar = null;
        switch (r.f18795a[methodToInvoke.ordinal()]) {
            case 1:
                return new Empty();
            case 2:
                return f18550d;
            case 3:
                return null;
            case 4:
                return new Builder(rVar);
            case 5:
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x == 0 || !codedInputStream.f(x)) {
                                z = true;
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f18551e == null) {
                    synchronized (Empty.class) {
                        if (f18551e == null) {
                            f18551e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18550d);
                        }
                    }
                }
                return f18551e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18550d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        this.f18584c = 0;
        return 0;
    }
}

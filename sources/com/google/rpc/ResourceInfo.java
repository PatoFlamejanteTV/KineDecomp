package com.google.rpc;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class ResourceInfo extends GeneratedMessageLite<ResourceInfo, Builder> implements ResourceInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ResourceInfo f18878d = new ResourceInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ResourceInfo> f18879e;

    /* renamed from: f, reason: collision with root package name */
    private String f18880f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18881g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f18882h = "";
    private String i = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ResourceInfo, Builder> implements ResourceInfoOrBuilder {
        /* synthetic */ Builder(i iVar) {
            this();
        }

        private Builder() {
            super(ResourceInfo.f18878d);
        }
    }

    static {
        f18878d.l();
    }

    private ResourceInfo() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18880f.isEmpty()) {
            codedOutputStream.b(1, q());
        }
        if (!this.f18881g.isEmpty()) {
            codedOutputStream.b(2, p());
        }
        if (!this.f18882h.isEmpty()) {
            codedOutputStream.b(3, o());
        }
        if (this.i.isEmpty()) {
            return;
        }
        codedOutputStream.b(4, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18880f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, q());
        if (!this.f18881g.isEmpty()) {
            a2 += CodedOutputStream.a(2, p());
        }
        if (!this.f18882h.isEmpty()) {
            a2 += CodedOutputStream.a(3, o());
        }
        if (!this.i.isEmpty()) {
            a2 += CodedOutputStream.a(4, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.i;
    }

    public String o() {
        return this.f18882h;
    }

    public String p() {
        return this.f18881g;
    }

    public String q() {
        return this.f18880f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        i iVar = null;
        switch (i.f18898a[methodToInvoke.ordinal()]) {
            case 1:
                return new ResourceInfo();
            case 2:
                return f18878d;
            case 3:
                return null;
            case 4:
                return new Builder(iVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ResourceInfo resourceInfo = (ResourceInfo) obj2;
                this.f18880f = visitor.a(!this.f18880f.isEmpty(), this.f18880f, !resourceInfo.f18880f.isEmpty(), resourceInfo.f18880f);
                this.f18881g = visitor.a(!this.f18881g.isEmpty(), this.f18881g, !resourceInfo.f18881g.isEmpty(), resourceInfo.f18881g);
                this.f18882h = visitor.a(!this.f18882h.isEmpty(), this.f18882h, !resourceInfo.f18882h.isEmpty(), resourceInfo.f18882h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, true ^ resourceInfo.i.isEmpty(), resourceInfo.i);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f18880f = codedInputStream.w();
                                } else if (x == 18) {
                                    this.f18881g = codedInputStream.w();
                                } else if (x == 26) {
                                    this.f18882h = codedInputStream.w();
                                } else if (x != 34) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.i = codedInputStream.w();
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw new RuntimeException(e3.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f18879e == null) {
                    synchronized (ResourceInfo.class) {
                        if (f18879e == null) {
                            f18879e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18878d);
                        }
                    }
                }
                return f18879e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18878d;
    }
}

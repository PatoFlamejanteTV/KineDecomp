package com.google.rpc;

import com.google.protobuf.Any;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Status extends GeneratedMessageLite<Status, Builder> implements StatusOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Status f18886d = new Status();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Status> f18887e;

    /* renamed from: f, reason: collision with root package name */
    private int f18888f;

    /* renamed from: g, reason: collision with root package name */
    private int f18889g;

    /* renamed from: h, reason: collision with root package name */
    private String f18890h = "";
    private Internal.ProtobufList<Any> i = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Status, Builder> implements StatusOrBuilder {
        /* synthetic */ Builder(k kVar) {
            this();
        }

        private Builder() {
            super(Status.f18886d);
        }
    }

    static {
        f18886d.l();
    }

    private Status() {
    }

    public static Status n() {
        return f18886d;
    }

    public static Parser<Status> p() {
        return f18886d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.f18889g;
        if (i != 0) {
            codedOutputStream.g(1, i);
        }
        if (!this.f18890h.isEmpty()) {
            codedOutputStream.b(2, o());
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            codedOutputStream.c(3, this.i.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = this.f18889g;
        int c2 = i2 != 0 ? CodedOutputStream.c(1, i2) + 0 : 0;
        if (!this.f18890h.isEmpty()) {
            c2 += CodedOutputStream.a(2, o());
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            c2 += CodedOutputStream.a(3, this.i.get(i3));
        }
        this.f18584c = c2;
        return c2;
    }

    public String o() {
        return this.f18890h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        k kVar = null;
        switch (k.f18900a[methodToInvoke.ordinal()]) {
            case 1:
                return new Status();
            case 2:
                return f18886d;
            case 3:
                this.i.L();
                return null;
            case 4:
                return new Builder(kVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Status status = (Status) obj2;
                this.f18889g = visitor.a(this.f18889g != 0, this.f18889g, status.f18889g != 0, status.f18889g);
                this.f18890h = visitor.a(!this.f18890h.isEmpty(), this.f18890h, !status.f18890h.isEmpty(), status.f18890h);
                this.i = visitor.a(this.i, status.i);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18888f |= status.f18888f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                this.f18889g = codedInputStream.j();
                            } else if (x == 18) {
                                this.f18890h = codedInputStream.w();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add((Any) codedInputStream.a(Any.p(), extensionRegistryLite));
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
                if (f18887e == null) {
                    synchronized (Status.class) {
                        if (f18887e == null) {
                            f18887e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18886d);
                        }
                    }
                }
                return f18887e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18886d;
    }
}

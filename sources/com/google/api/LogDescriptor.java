package com.google.api;

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
public final class LogDescriptor extends GeneratedMessageLite<LogDescriptor, Builder> implements LogDescriptorOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final LogDescriptor f14458d = new LogDescriptor();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<LogDescriptor> f14459e;

    /* renamed from: f, reason: collision with root package name */
    private int f14460f;

    /* renamed from: g, reason: collision with root package name */
    private String f14461g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<LabelDescriptor> f14462h = GeneratedMessageLite.k();
    private String i = "";
    private String j = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<LogDescriptor, Builder> implements LogDescriptorOrBuilder {
        /* synthetic */ Builder(z zVar) {
            this();
        }

        private Builder() {
            super(LogDescriptor.f14458d);
        }
    }

    static {
        f14458d.l();
    }

    private LogDescriptor() {
    }

    public static Parser<LogDescriptor> q() {
        return f14458d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14461g.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        for (int i = 0; i < this.f14462h.size(); i++) {
            codedOutputStream.c(2, this.f14462h.get(i));
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(3, n());
        }
        if (this.j.isEmpty()) {
            return;
        }
        codedOutputStream.b(4, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14461g.isEmpty() ? CodedOutputStream.a(1, p()) + 0 : 0;
        for (int i2 = 0; i2 < this.f14462h.size(); i2++) {
            a2 += CodedOutputStream.a(2, this.f14462h.get(i2));
        }
        if (!this.i.isEmpty()) {
            a2 += CodedOutputStream.a(3, n());
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(4, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.i;
    }

    public String o() {
        return this.j;
    }

    public String p() {
        return this.f14461g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        z zVar = null;
        switch (z.f15044a[methodToInvoke.ordinal()]) {
            case 1:
                return new LogDescriptor();
            case 2:
                return f14458d;
            case 3:
                this.f14462h.L();
                return null;
            case 4:
                return new Builder(zVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                LogDescriptor logDescriptor = (LogDescriptor) obj2;
                this.f14461g = visitor.a(!this.f14461g.isEmpty(), this.f14461g, !logDescriptor.f14461g.isEmpty(), logDescriptor.f14461g);
                this.f14462h = visitor.a(this.f14462h, logDescriptor.f14462h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !logDescriptor.i.isEmpty(), logDescriptor.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, true ^ logDescriptor.j.isEmpty(), logDescriptor.j);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14460f |= logDescriptor.f14460f;
                }
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
                                this.f14461g = codedInputStream.w();
                            } else if (x == 18) {
                                if (!this.f14462h.M()) {
                                    this.f14462h = GeneratedMessageLite.a(this.f14462h);
                                }
                                this.f14462h.add((LabelDescriptor) codedInputStream.a(LabelDescriptor.p(), extensionRegistryLite));
                            } else if (x == 26) {
                                this.i = codedInputStream.w();
                            } else if (x != 34) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.j = codedInputStream.w();
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
                if (f14459e == null) {
                    synchronized (LogDescriptor.class) {
                        if (f14459e == null) {
                            f14459e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14458d);
                        }
                    }
                }
                return f14459e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14458d;
    }
}

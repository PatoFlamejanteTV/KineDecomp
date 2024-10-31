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
public final class ConfigChange extends GeneratedMessageLite<ConfigChange, Builder> implements ConfigChangeOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ConfigChange f14368d = new ConfigChange();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ConfigChange> f14369e;

    /* renamed from: f, reason: collision with root package name */
    private int f14370f;
    private int j;

    /* renamed from: g, reason: collision with root package name */
    private String f14371g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f14372h = "";
    private String i = "";
    private Internal.ProtobufList<Advice> k = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ConfigChange, Builder> implements ConfigChangeOrBuilder {
        /* synthetic */ Builder(C1473k c1473k) {
            this();
        }

        private Builder() {
            super(ConfigChange.f14368d);
        }
    }

    static {
        f14368d.l();
    }

    private ConfigChange() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14371g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (!this.f14372h.isEmpty()) {
            codedOutputStream.b(2, p());
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(3, o());
        }
        if (this.j != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            codedOutputStream.e(4, this.j);
        }
        for (int i = 0; i < this.k.size(); i++) {
            codedOutputStream.c(5, this.k.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14371g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        if (!this.f14372h.isEmpty()) {
            a2 += CodedOutputStream.a(2, p());
        }
        if (!this.i.isEmpty()) {
            a2 += CodedOutputStream.a(3, o());
        }
        if (this.j != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            a2 += CodedOutputStream.a(4, this.j);
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            a2 += CodedOutputStream.a(5, this.k.get(i2));
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14371g;
    }

    public String o() {
        return this.i;
    }

    public String p() {
        return this.f14372h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1473k c1473k = null;
        switch (C1473k.f15027a[methodToInvoke.ordinal()]) {
            case 1:
                return new ConfigChange();
            case 2:
                return f14368d;
            case 3:
                this.k.L();
                return null;
            case 4:
                return new Builder(c1473k);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ConfigChange configChange = (ConfigChange) obj2;
                this.f14371g = visitor.a(!this.f14371g.isEmpty(), this.f14371g, !configChange.f14371g.isEmpty(), configChange.f14371g);
                this.f14372h = visitor.a(!this.f14372h.isEmpty(), this.f14372h, !configChange.f14372h.isEmpty(), configChange.f14372h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !configChange.i.isEmpty(), configChange.i);
                this.j = visitor.a(this.j != 0, this.j, configChange.j != 0, configChange.j);
                this.k = visitor.a(this.k, configChange.k);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14370f |= configChange.f14370f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14371g = codedInputStream.w();
                            } else if (x == 18) {
                                this.f14372h = codedInputStream.w();
                            } else if (x == 26) {
                                this.i = codedInputStream.w();
                            } else if (x == 32) {
                                this.j = codedInputStream.f();
                            } else if (x != 42) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.k.M()) {
                                    this.k = GeneratedMessageLite.a(this.k);
                                }
                                this.k.add((Advice) codedInputStream.a(Advice.o(), extensionRegistryLite));
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
                if (f14369e == null) {
                    synchronized (ConfigChange.class) {
                        if (f14369e == null) {
                            f14369e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14368d);
                        }
                    }
                }
                return f14369e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14368d;
    }
}

package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Struct extends GeneratedMessageLite<Struct, Builder> implements StructOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Struct f18689d = new Struct();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Struct> f18690e;

    /* renamed from: f, reason: collision with root package name */
    private MapFieldLite<String, Value> f18691f = MapFieldLite.emptyMapField();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Struct, Builder> implements StructOrBuilder {
        /* synthetic */ Builder(X x) {
            this();
        }

        private Builder() {
            super(Struct.f18689d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final MapEntryLite<String, Value> f18692a = MapEntryLite.a(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.n());
    }

    static {
        f18689d.l();
    }

    private Struct() {
    }

    public static Struct n() {
        return f18689d;
    }

    public static Parser<Struct> o() {
        return f18689d.f();
    }

    private MapFieldLite<String, Value> p() {
        return this.f18691f;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<String, Value> entry : p().entrySet()) {
            a.f18692a.a(codedOutputStream, 1, (int) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (Map.Entry<String, Value> entry : p().entrySet()) {
            i2 += a.f18692a.a(1, (int) entry.getKey(), (String) entry.getValue());
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        X x = null;
        switch (X.f18741a[methodToInvoke.ordinal()]) {
            case 1:
                return new Struct();
            case 2:
                return f18689d;
            case 3:
                this.f18691f.makeImmutable();
                return null;
            case 4:
                return new Builder(x);
            case 5:
                this.f18691f = ((GeneratedMessageLite.Visitor) obj).a(this.f18691f, ((Struct) obj2).p());
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x2 = codedInputStream.x();
                            if (x2 != 0) {
                                if (x2 != 10) {
                                    if (!codedInputStream.f(x2)) {
                                    }
                                } else {
                                    if (!this.f18691f.isMutable()) {
                                        this.f18691f = this.f18691f.mutableCopy();
                                    }
                                    a.f18692a.a(this.f18691f, codedInputStream, extensionRegistryLite);
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
                if (f18690e == null) {
                    synchronized (Struct.class) {
                        if (f18690e == null) {
                            f18690e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18689d);
                        }
                    }
                }
                return f18690e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18689d;
    }
}

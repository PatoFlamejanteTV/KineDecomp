package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class ListValue extends GeneratedMessageLite<ListValue, Builder> implements ListValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ListValue f18645d = new ListValue();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ListValue> f18646e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<Value> f18647f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListValue, Builder> implements ListValueOrBuilder {
        /* synthetic */ Builder(G g2) {
            this();
        }

        private Builder() {
            super(ListValue.f18645d);
        }
    }

    static {
        f18645d.l();
    }

    private ListValue() {
    }

    public static Parser<ListValue> n() {
        return f18645d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18647f.size(); i++) {
            codedOutputStream.c(1, this.f18647f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18647f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18647f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        G g2 = null;
        switch (G.f18582a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListValue();
            case 2:
                return f18645d;
            case 3:
                this.f18647f.L();
                return null;
            case 4:
                return new Builder(g2);
            case 5:
                this.f18647f = ((GeneratedMessageLite.Visitor) obj).a(this.f18647f, ((ListValue) obj2).f18647f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    if (!this.f18647f.M()) {
                                        this.f18647f = GeneratedMessageLite.a(this.f18647f);
                                    }
                                    this.f18647f.add((Value) codedInputStream.a(Value.q(), extensionRegistryLite));
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
                if (f18646e == null) {
                    synchronized (ListValue.class) {
                        if (f18646e == null) {
                            f18646e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18645d);
                        }
                    }
                }
                return f18646e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18645d;
    }
}

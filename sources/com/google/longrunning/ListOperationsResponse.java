package com.google.longrunning;

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
public final class ListOperationsResponse extends GeneratedMessageLite<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ListOperationsResponse f18352d = new ListOperationsResponse();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ListOperationsResponse> f18353e;

    /* renamed from: f, reason: collision with root package name */
    private int f18354f;

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<Operation> f18355g = GeneratedMessageLite.k();

    /* renamed from: h, reason: collision with root package name */
    private String f18356h = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
        /* synthetic */ Builder(e eVar) {
            this();
        }

        private Builder() {
            super(ListOperationsResponse.f18352d);
        }
    }

    static {
        f18352d.l();
    }

    private ListOperationsResponse() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18355g.size(); i++) {
            codedOutputStream.c(1, this.f18355g.get(i));
        }
        if (this.f18356h.isEmpty()) {
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
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18355g.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18355g.get(i3));
        }
        if (!this.f18356h.isEmpty()) {
            i2 += CodedOutputStream.a(2, n());
        }
        this.f18584c = i2;
        return i2;
    }

    public String n() {
        return this.f18356h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f18366a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListOperationsResponse();
            case 2:
                return f18352d;
            case 3:
                this.f18355g.L();
                return null;
            case 4:
                return new Builder(eVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListOperationsResponse listOperationsResponse = (ListOperationsResponse) obj2;
                this.f18355g = visitor.a(this.f18355g, listOperationsResponse.f18355g);
                this.f18356h = visitor.a(!this.f18356h.isEmpty(), this.f18356h, true ^ listOperationsResponse.f18356h.isEmpty(), listOperationsResponse.f18356h);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18354f |= listOperationsResponse.f18354f;
                }
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
                                if (x == 10) {
                                    if (!this.f18355g.M()) {
                                        this.f18355g = GeneratedMessageLite.a(this.f18355g);
                                    }
                                    this.f18355g.add((Operation) codedInputStream.a(Operation.q(), extensionRegistryLite));
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f18356h = codedInputStream.w();
                                }
                            }
                            z = true;
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
                if (f18353e == null) {
                    synchronized (ListOperationsResponse.class) {
                        if (f18353e == null) {
                            f18353e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18352d);
                        }
                    }
                }
                return f18353e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18352d;
    }
}

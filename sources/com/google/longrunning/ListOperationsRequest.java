package com.google.longrunning;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class ListOperationsRequest extends GeneratedMessageLite<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ListOperationsRequest f18347d = new ListOperationsRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ListOperationsRequest> f18348e;

    /* renamed from: h, reason: collision with root package name */
    private int f18351h;

    /* renamed from: f, reason: collision with root package name */
    private String f18349f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18350g = "";
    private String i = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {
        /* synthetic */ Builder(d dVar) {
            this();
        }

        private Builder() {
            super(ListOperationsRequest.f18347d);
        }
    }

    static {
        f18347d.l();
    }

    private ListOperationsRequest() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18350g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        int i = this.f18351h;
        if (i != 0) {
            codedOutputStream.g(2, i);
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(3, p());
        }
        if (this.f18349f.isEmpty()) {
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
        int a2 = this.f18350g.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        int i2 = this.f18351h;
        if (i2 != 0) {
            a2 += CodedOutputStream.c(2, i2);
        }
        if (!this.i.isEmpty()) {
            a2 += CodedOutputStream.a(3, p());
        }
        if (!this.f18349f.isEmpty()) {
            a2 += CodedOutputStream.a(4, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18350g;
    }

    public String o() {
        return this.f18349f;
    }

    public String p() {
        return this.i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        d dVar = null;
        switch (d.f18365a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListOperationsRequest();
            case 2:
                return f18347d;
            case 3:
                return null;
            case 4:
                return new Builder(dVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListOperationsRequest listOperationsRequest = (ListOperationsRequest) obj2;
                this.f18349f = visitor.a(!this.f18349f.isEmpty(), this.f18349f, !listOperationsRequest.f18349f.isEmpty(), listOperationsRequest.f18349f);
                this.f18350g = visitor.a(!this.f18350g.isEmpty(), this.f18350g, !listOperationsRequest.f18350g.isEmpty(), listOperationsRequest.f18350g);
                this.f18351h = visitor.a(this.f18351h != 0, this.f18351h, listOperationsRequest.f18351h != 0, listOperationsRequest.f18351h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !listOperationsRequest.i.isEmpty(), listOperationsRequest.i);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f18350g = codedInputStream.w();
                                } else if (x == 16) {
                                    this.f18351h = codedInputStream.j();
                                } else if (x == 26) {
                                    this.i = codedInputStream.w();
                                } else if (x != 34) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f18349f = codedInputStream.w();
                                }
                            }
                            r1 = true;
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
                if (f18348e == null) {
                    synchronized (ListOperationsRequest.class) {
                        if (f18348e == null) {
                            f18348e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18347d);
                        }
                    }
                }
                return f18348e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18347d;
    }
}

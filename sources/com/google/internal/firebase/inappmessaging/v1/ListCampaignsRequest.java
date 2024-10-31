package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ListCampaignsRequest extends GeneratedMessageLite<ListCampaignsRequest, Builder> implements ListCampaignsRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Internal.ListAdapter.Converter<Integer, CommonTypesProto.CampaignState> f18264d = new h();

    /* renamed from: e, reason: collision with root package name */
    private static final ListCampaignsRequest f18265e = new ListCampaignsRequest();

    /* renamed from: f, reason: collision with root package name */
    private static volatile Parser<ListCampaignsRequest> f18266f;

    /* renamed from: g, reason: collision with root package name */
    private int f18267g;

    /* renamed from: h, reason: collision with root package name */
    private String f18268h = "";
    private Internal.IntList i = GeneratedMessageLite.i();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListCampaignsRequest, Builder> implements ListCampaignsRequestOrBuilder {
        /* synthetic */ Builder(h hVar) {
            this();
        }

        private Builder() {
            super(ListCampaignsRequest.f18265e);
        }
    }

    static {
        f18265e.l();
    }

    private ListCampaignsRequest() {
    }

    public static ListCampaignsRequest n() {
        return f18265e;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        d();
        if (!this.f18268h.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.e(2, this.i.getInt(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18268h.isEmpty() ? CodedOutputStream.a(1, o()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            i2 += CodedOutputStream.a(this.i.getInt(i3));
        }
        int size = a2 + i2 + (this.i.size() * 1);
        this.f18584c = size;
        return size;
    }

    public String o() {
        return this.f18268h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        h hVar = null;
        switch (i.f18297a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListCampaignsRequest();
            case 2:
                return f18265e;
            case 3:
                this.i.L();
                return null;
            case 4:
                return new Builder(hVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListCampaignsRequest listCampaignsRequest = (ListCampaignsRequest) obj2;
                this.f18268h = visitor.a(!this.f18268h.isEmpty(), this.f18268h, true ^ listCampaignsRequest.f18268h.isEmpty(), listCampaignsRequest.f18268h);
                this.i = visitor.a(this.i, listCampaignsRequest.i);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18267g |= listCampaignsRequest.f18267g;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18268h = codedInputStream.w();
                            } else if (x == 16) {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.i(codedInputStream.f());
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                int d2 = codedInputStream.d(codedInputStream.o());
                                while (codedInputStream.a() > 0) {
                                    this.i.i(codedInputStream.f());
                                }
                                codedInputStream.c(d2);
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
                if (f18266f == null) {
                    synchronized (ListCampaignsRequest.class) {
                        if (f18266f == null) {
                            f18266f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18265e);
                        }
                    }
                }
                return f18266f;
            default:
                throw new UnsupportedOperationException();
        }
        return f18265e;
    }
}

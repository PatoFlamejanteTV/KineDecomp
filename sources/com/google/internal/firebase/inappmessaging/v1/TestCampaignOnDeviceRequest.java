package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class TestCampaignOnDeviceRequest extends GeneratedMessageLite<TestCampaignOnDeviceRequest, Builder> implements TestCampaignOnDeviceRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final TestCampaignOnDeviceRequest f18281d = new TestCampaignOnDeviceRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<TestCampaignOnDeviceRequest> f18282e;

    /* renamed from: f, reason: collision with root package name */
    private int f18283f;

    /* renamed from: g, reason: collision with root package name */
    private String f18284g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f18285h = "";
    private Internal.ProtobufList<String> i = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<TestCampaignOnDeviceRequest, Builder> implements TestCampaignOnDeviceRequestOrBuilder {
        /* synthetic */ Builder(m mVar) {
            this();
        }

        private Builder() {
            super(TestCampaignOnDeviceRequest.f18281d);
        }
    }

    static {
        f18281d.l();
    }

    private TestCampaignOnDeviceRequest() {
    }

    public static TestCampaignOnDeviceRequest o() {
        return f18281d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18284g.isEmpty()) {
            codedOutputStream.b(1, q());
        }
        if (!this.f18285h.isEmpty()) {
            codedOutputStream.b(2, n());
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.b(3, this.i.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18284g.isEmpty() ? CodedOutputStream.a(1, q()) + 0 : 0;
        if (!this.f18285h.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            i2 += CodedOutputStream.a(this.i.get(i3));
        }
        int size = a2 + i2 + (p().size() * 1);
        this.f18584c = size;
        return size;
    }

    public String n() {
        return this.f18285h;
    }

    public List<String> p() {
        return this.i;
    }

    public String q() {
        return this.f18284g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        m mVar = null;
        switch (m.f18301a[methodToInvoke.ordinal()]) {
            case 1:
                return new TestCampaignOnDeviceRequest();
            case 2:
                return f18281d;
            case 3:
                this.i.L();
                return null;
            case 4:
                return new Builder(mVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                TestCampaignOnDeviceRequest testCampaignOnDeviceRequest = (TestCampaignOnDeviceRequest) obj2;
                this.f18284g = visitor.a(!this.f18284g.isEmpty(), this.f18284g, !testCampaignOnDeviceRequest.f18284g.isEmpty(), testCampaignOnDeviceRequest.f18284g);
                this.f18285h = visitor.a(!this.f18285h.isEmpty(), this.f18285h, true ^ testCampaignOnDeviceRequest.f18285h.isEmpty(), testCampaignOnDeviceRequest.f18285h);
                this.i = visitor.a(this.i, testCampaignOnDeviceRequest.i);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18283f |= testCampaignOnDeviceRequest.f18283f;
                }
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
                                    this.f18284g = codedInputStream.w();
                                } else if (x == 18) {
                                    this.f18285h = codedInputStream.w();
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    String w = codedInputStream.w();
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add(w);
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
                if (f18282e == null) {
                    synchronized (TestCampaignOnDeviceRequest.class) {
                        if (f18282e == null) {
                            f18282e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18281d);
                        }
                    }
                }
                return f18282e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18281d;
    }
}

package com.google.type;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class LatLng extends GeneratedMessageLite<LatLng, Builder> implements LatLngOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final LatLng f18915d = new LatLng();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<LatLng> f18916e;

    /* renamed from: f, reason: collision with root package name */
    private double f18917f;

    /* renamed from: g, reason: collision with root package name */
    private double f18918g;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<LatLng, Builder> implements LatLngOrBuilder {
        /* synthetic */ Builder(d dVar) {
            this();
        }

        private Builder() {
            super(LatLng.f18915d);
        }
    }

    static {
        f18915d.l();
    }

    private LatLng() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        double d2 = this.f18917f;
        if (d2 != 0.0d) {
            codedOutputStream.b(1, d2);
        }
        double d3 = this.f18918g;
        if (d3 != 0.0d) {
            codedOutputStream.b(2, d3);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        double d2 = this.f18917f;
        int a2 = d2 != 0.0d ? 0 + CodedOutputStream.a(1, d2) : 0;
        double d3 = this.f18918g;
        if (d3 != 0.0d) {
            a2 += CodedOutputStream.a(2, d3);
        }
        this.f18584c = a2;
        return a2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        d dVar = null;
        boolean z = false;
        switch (d.f18936a[methodToInvoke.ordinal()]) {
            case 1:
                return new LatLng();
            case 2:
                return f18915d;
            case 3:
                return null;
            case 4:
                return new Builder(dVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                LatLng latLng = (LatLng) obj2;
                this.f18917f = visitor.a(this.f18917f != 0.0d, this.f18917f, latLng.f18917f != 0.0d, latLng.f18917f);
                this.f18918g = visitor.a(this.f18918g != 0.0d, this.f18918g, latLng.f18918g != 0.0d, latLng.f18918g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 9) {
                                this.f18917f = codedInputStream.e();
                            } else if (x != 17) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18918g = codedInputStream.e();
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
                if (f18916e == null) {
                    synchronized (LatLng.class) {
                        if (f18916e == null) {
                            f18916e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18915d);
                        }
                    }
                }
                return f18916e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18915d;
    }
}

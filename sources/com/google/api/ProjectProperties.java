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
public final class ProjectProperties extends GeneratedMessageLite<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ProjectProperties f14520d = new ProjectProperties();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ProjectProperties> f14521e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<Property> f14522f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
        /* synthetic */ Builder(L l) {
            this();
        }

        private Builder() {
            super(ProjectProperties.f14520d);
        }
    }

    static {
        f14520d.l();
    }

    private ProjectProperties() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14522f.size(); i++) {
            codedOutputStream.c(1, this.f14522f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14522f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14522f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        L l = null;
        switch (L.f14452a[methodToInvoke.ordinal()]) {
            case 1:
                return new ProjectProperties();
            case 2:
                return f14520d;
            case 3:
                this.f14522f.L();
                return null;
            case 4:
                return new Builder(l);
            case 5:
                this.f14522f = ((GeneratedMessageLite.Visitor) obj).a(this.f14522f, ((ProjectProperties) obj2).f14522f);
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
                                    if (!this.f14522f.M()) {
                                        this.f14522f = GeneratedMessageLite.a(this.f14522f);
                                    }
                                    this.f14522f.add((Property) codedInputStream.a(Property.p(), extensionRegistryLite));
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
                if (f14521e == null) {
                    synchronized (ProjectProperties.class) {
                        if (f14521e == null) {
                            f14521e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14520d);
                        }
                    }
                }
                return f14521e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14520d;
    }
}

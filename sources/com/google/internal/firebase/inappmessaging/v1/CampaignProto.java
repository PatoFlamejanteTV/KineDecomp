package com.google.internal.firebase.inappmessaging.v1;

import com.google.developers.mobile.targeting.proto.Conditions;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import developers.mobile.abt.FirebaseAbt$ExperimentPayload;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class CampaignProto {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface CampaignOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ExperimentalCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ExperimentalCampaignRolloutOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ThickContentOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface VanillaCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
    }

    private CampaignProto() {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ExperimentalCampaignPayload extends GeneratedMessageLite<ExperimentalCampaignPayload, Builder> implements ExperimentalCampaignPayloadOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final ExperimentalCampaignPayload f18218d = new ExperimentalCampaignPayload();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<ExperimentalCampaignPayload> f18219e;

        /* renamed from: f, reason: collision with root package name */
        private String f18220f = "";

        /* renamed from: g, reason: collision with root package name */
        private FirebaseAbt$ExperimentPayload f18221g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignPayload, Builder> implements ExperimentalCampaignPayloadOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(ExperimentalCampaignPayload.f18218d);
            }
        }

        static {
            f18218d.l();
        }

        private ExperimentalCampaignPayload() {
        }

        public static Parser<ExperimentalCampaignPayload> p() {
            return f18218d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18220f.isEmpty()) {
                codedOutputStream.b(1, n());
            }
            if (this.f18221g != null) {
                codedOutputStream.c(2, o());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f18220f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            if (this.f18221g != null) {
                a2 += CodedOutputStream.a(2, o());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f18220f;
        }

        public FirebaseAbt$ExperimentPayload o() {
            FirebaseAbt$ExperimentPayload firebaseAbt$ExperimentPayload = this.f18221g;
            return firebaseAbt$ExperimentPayload == null ? FirebaseAbt$ExperimentPayload.p() : firebaseAbt$ExperimentPayload;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f18290a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentalCampaignPayload();
                case 2:
                    return f18218d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ExperimentalCampaignPayload experimentalCampaignPayload = (ExperimentalCampaignPayload) obj2;
                    this.f18220f = visitor.a(!this.f18220f.isEmpty(), this.f18220f, true ^ experimentalCampaignPayload.f18220f.isEmpty(), experimentalCampaignPayload.f18220f);
                    this.f18221g = (FirebaseAbt$ExperimentPayload) visitor.a(this.f18221g, experimentalCampaignPayload.f18221g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
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
                                    this.f18220f = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    FirebaseAbt$ExperimentPayload.a b2 = this.f18221g != null ? this.f18221g.b() : null;
                                    this.f18221g = (FirebaseAbt$ExperimentPayload) codedInputStream.a(FirebaseAbt$ExperimentPayload.w(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((FirebaseAbt$ExperimentPayload.a) this.f18221g);
                                        this.f18221g = b2.T();
                                    }
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
                    if (f18219e == null) {
                        synchronized (ExperimentalCampaignPayload.class) {
                            if (f18219e == null) {
                                f18219e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18218d);
                            }
                        }
                    }
                    return f18219e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18218d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ExperimentalCampaignRollout extends GeneratedMessageLite<ExperimentalCampaignRollout, Builder> implements ExperimentalCampaignRolloutOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final ExperimentalCampaignRollout f18222d = new ExperimentalCampaignRollout();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<ExperimentalCampaignRollout> f18223e;

        /* renamed from: f, reason: collision with root package name */
        private String f18224f = "";

        /* renamed from: g, reason: collision with root package name */
        private int f18225g;

        /* renamed from: h, reason: collision with root package name */
        private CommonTypesProto.Priority f18226h;
        private CommonTypesProto.CampaignTime i;
        private CommonTypesProto.CampaignTime j;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignRollout, Builder> implements ExperimentalCampaignRolloutOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(ExperimentalCampaignRollout.f18222d);
            }
        }

        static {
            f18222d.l();
        }

        private ExperimentalCampaignRollout() {
        }

        public static ExperimentalCampaignRollout n() {
            return f18222d;
        }

        public static Parser<ExperimentalCampaignRollout> s() {
            return f18222d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18224f.isEmpty()) {
                codedOutputStream.b(1, p());
            }
            int i = this.f18225g;
            if (i != 0) {
                codedOutputStream.g(2, i);
            }
            if (this.f18226h != null) {
                codedOutputStream.c(3, q());
            }
            if (this.i != null) {
                codedOutputStream.c(4, r());
            }
            if (this.j != null) {
                codedOutputStream.c(5, o());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f18224f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
            int i2 = this.f18225g;
            if (i2 != 0) {
                a2 += CodedOutputStream.c(2, i2);
            }
            if (this.f18226h != null) {
                a2 += CodedOutputStream.a(3, q());
            }
            if (this.i != null) {
                a2 += CodedOutputStream.a(4, r());
            }
            if (this.j != null) {
                a2 += CodedOutputStream.a(5, o());
            }
            this.f18584c = a2;
            return a2;
        }

        public CommonTypesProto.CampaignTime o() {
            CommonTypesProto.CampaignTime campaignTime = this.j;
            return campaignTime == null ? CommonTypesProto.CampaignTime.o() : campaignTime;
        }

        public String p() {
            return this.f18224f;
        }

        public CommonTypesProto.Priority q() {
            CommonTypesProto.Priority priority = this.f18226h;
            return priority == null ? CommonTypesProto.Priority.n() : priority;
        }

        public CommonTypesProto.CampaignTime r() {
            CommonTypesProto.CampaignTime campaignTime = this.i;
            return campaignTime == null ? CommonTypesProto.CampaignTime.o() : campaignTime;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f18290a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentalCampaignRollout();
                case 2:
                    return f18222d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ExperimentalCampaignRollout experimentalCampaignRollout = (ExperimentalCampaignRollout) obj2;
                    this.f18224f = visitor.a(!this.f18224f.isEmpty(), this.f18224f, !experimentalCampaignRollout.f18224f.isEmpty(), experimentalCampaignRollout.f18224f);
                    this.f18225g = visitor.a(this.f18225g != 0, this.f18225g, experimentalCampaignRollout.f18225g != 0, experimentalCampaignRollout.f18225g);
                    this.f18226h = (CommonTypesProto.Priority) visitor.a(this.f18226h, experimentalCampaignRollout.f18226h);
                    this.i = (CommonTypesProto.CampaignTime) visitor.a(this.i, experimentalCampaignRollout.i);
                    this.j = (CommonTypesProto.CampaignTime) visitor.a(this.j, experimentalCampaignRollout.j);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f18224f = codedInputStream.w();
                                } else if (x == 16) {
                                    this.f18225g = codedInputStream.j();
                                } else if (x == 26) {
                                    CommonTypesProto.Priority.Builder b2 = this.f18226h != null ? this.f18226h.b() : null;
                                    this.f18226h = (CommonTypesProto.Priority) codedInputStream.a(CommonTypesProto.Priority.p(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((CommonTypesProto.Priority.Builder) this.f18226h);
                                        this.f18226h = b2.T();
                                    }
                                } else if (x == 34) {
                                    CommonTypesProto.CampaignTime.Builder b3 = this.i != null ? this.i.b() : null;
                                    this.i = (CommonTypesProto.CampaignTime) codedInputStream.a(CommonTypesProto.CampaignTime.r(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((CommonTypesProto.CampaignTime.Builder) this.i);
                                        this.i = b3.T();
                                    }
                                } else if (x != 42) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    CommonTypesProto.CampaignTime.Builder b4 = this.j != null ? this.j.b() : null;
                                    this.j = (CommonTypesProto.CampaignTime) codedInputStream.a(CommonTypesProto.CampaignTime.r(), extensionRegistryLite);
                                    if (b4 != null) {
                                        b4.b((CommonTypesProto.CampaignTime.Builder) this.j);
                                        this.j = b4.T();
                                    }
                                }
                            }
                            r0 = true;
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
                    if (f18223e == null) {
                        synchronized (ExperimentalCampaignRollout.class) {
                            if (f18223e == null) {
                                f18223e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18222d);
                            }
                        }
                    }
                    return f18223e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18222d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class VanillaCampaignPayload extends GeneratedMessageLite<VanillaCampaignPayload, Builder> implements VanillaCampaignPayloadOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final VanillaCampaignPayload f18232d = new VanillaCampaignPayload();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<VanillaCampaignPayload> f18233e;

        /* renamed from: h, reason: collision with root package name */
        private long f18236h;
        private long i;

        /* renamed from: f, reason: collision with root package name */
        private String f18234f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f18235g = "";
        private String j = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<VanillaCampaignPayload, Builder> implements VanillaCampaignPayloadOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(VanillaCampaignPayload.f18232d);
            }
        }

        static {
            f18232d.l();
        }

        private VanillaCampaignPayload() {
        }

        public static VanillaCampaignPayload r() {
            return f18232d;
        }

        public static Parser<VanillaCampaignPayload> t() {
            return f18232d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18234f.isEmpty()) {
                codedOutputStream.b(1, o());
            }
            if (!this.f18235g.isEmpty()) {
                codedOutputStream.b(2, s());
            }
            long j = this.f18236h;
            if (j != 0) {
                codedOutputStream.e(3, j);
            }
            long j2 = this.i;
            if (j2 != 0) {
                codedOutputStream.e(4, j2);
            }
            if (this.j.isEmpty()) {
                return;
            }
            codedOutputStream.b(5, p());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f18234f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
            if (!this.f18235g.isEmpty()) {
                a2 += CodedOutputStream.a(2, s());
            }
            long j = this.f18236h;
            if (j != 0) {
                a2 += CodedOutputStream.b(3, j);
            }
            long j2 = this.i;
            if (j2 != 0) {
                a2 += CodedOutputStream.b(4, j2);
            }
            if (!this.j.isEmpty()) {
                a2 += CodedOutputStream.a(5, p());
            }
            this.f18584c = a2;
            return a2;
        }

        public long n() {
            return this.i;
        }

        public String o() {
            return this.f18234f;
        }

        public String p() {
            return this.j;
        }

        public long q() {
            return this.f18236h;
        }

        public String s() {
            return this.f18235g;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            boolean z = false;
            switch (b.f18290a[methodToInvoke.ordinal()]) {
                case 1:
                    return new VanillaCampaignPayload();
                case 2:
                    return f18232d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    VanillaCampaignPayload vanillaCampaignPayload = (VanillaCampaignPayload) obj2;
                    this.f18234f = visitor.a(!this.f18234f.isEmpty(), this.f18234f, !vanillaCampaignPayload.f18234f.isEmpty(), vanillaCampaignPayload.f18234f);
                    this.f18235g = visitor.a(!this.f18235g.isEmpty(), this.f18235g, !vanillaCampaignPayload.f18235g.isEmpty(), vanillaCampaignPayload.f18235g);
                    this.f18236h = visitor.a(this.f18236h != 0, this.f18236h, vanillaCampaignPayload.f18236h != 0, vanillaCampaignPayload.f18236h);
                    this.i = visitor.a(this.i != 0, this.i, vanillaCampaignPayload.i != 0, vanillaCampaignPayload.i);
                    this.j = visitor.a(!this.j.isEmpty(), this.j, !vanillaCampaignPayload.j.isEmpty(), vanillaCampaignPayload.j);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f18234f = codedInputStream.w();
                                } else if (x == 18) {
                                    this.f18235g = codedInputStream.w();
                                } else if (x == 24) {
                                    this.f18236h = codedInputStream.k();
                                } else if (x == 32) {
                                    this.i = codedInputStream.k();
                                } else if (x != 42) {
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
                    if (f18233e == null) {
                        synchronized (VanillaCampaignPayload.class) {
                            if (f18233e == null) {
                                f18233e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18232d);
                            }
                        }
                    }
                    return f18233e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18232d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ThickContent extends GeneratedMessageLite<ThickContent, Builder> implements ThickContentOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final ThickContent f18227d = new ThickContent();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<ThickContent> f18228e;

        /* renamed from: f, reason: collision with root package name */
        private int f18229f;

        /* renamed from: h, reason: collision with root package name */
        private Object f18231h;
        private MessagesProto.Content i;
        private CommonTypesProto.Priority j;
        private boolean l;

        /* renamed from: g, reason: collision with root package name */
        private int f18230g = 0;
        private Internal.ProtobufList<CommonTypesProto.TriggeringCondition> k = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ThickContent, Builder> implements ThickContentOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(ThickContent.f18227d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum PayloadCase implements Internal.EnumLite {
            VANILLA_PAYLOAD(1),
            EXPERIMENTAL_PAYLOAD(2),
            PAYLOAD_NOT_SET(0);

            private final int value;

            PayloadCase(int i) {
                this.value = i;
            }

            public static PayloadCase forNumber(int i) {
                if (i == 0) {
                    return PAYLOAD_NOT_SET;
                }
                if (i == 1) {
                    return VANILLA_PAYLOAD;
                }
                if (i != 2) {
                    return null;
                }
                return EXPERIMENTAL_PAYLOAD;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static PayloadCase valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f18227d.l();
        }

        private ThickContent() {
        }

        public static Parser<ThickContent> t() {
            return f18227d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f18230g == 1) {
                codedOutputStream.c(1, (VanillaCampaignPayload) this.f18231h);
            }
            if (this.f18230g == 2) {
                codedOutputStream.c(2, (ExperimentalCampaignPayload) this.f18231h);
            }
            if (this.i != null) {
                codedOutputStream.c(3, n());
            }
            if (this.j != null) {
                codedOutputStream.c(4, q());
            }
            for (int i = 0; i < this.k.size(); i++) {
                codedOutputStream.c(5, this.k.get(i));
            }
            boolean z = this.l;
            if (z) {
                codedOutputStream.b(7, z);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f18230g == 1 ? CodedOutputStream.a(1, (VanillaCampaignPayload) this.f18231h) + 0 : 0;
            if (this.f18230g == 2) {
                a2 += CodedOutputStream.a(2, (ExperimentalCampaignPayload) this.f18231h);
            }
            if (this.i != null) {
                a2 += CodedOutputStream.a(3, n());
            }
            if (this.j != null) {
                a2 += CodedOutputStream.a(4, q());
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                a2 += CodedOutputStream.a(5, this.k.get(i2));
            }
            boolean z = this.l;
            if (z) {
                a2 += CodedOutputStream.a(7, z);
            }
            this.f18584c = a2;
            return a2;
        }

        public MessagesProto.Content n() {
            MessagesProto.Content content = this.i;
            return content == null ? MessagesProto.Content.o() : content;
        }

        public boolean o() {
            return this.l;
        }

        public PayloadCase p() {
            return PayloadCase.forNumber(this.f18230g);
        }

        public CommonTypesProto.Priority q() {
            CommonTypesProto.Priority priority = this.j;
            return priority == null ? CommonTypesProto.Priority.n() : priority;
        }

        public List<CommonTypesProto.TriggeringCondition> r() {
            return this.k;
        }

        public VanillaCampaignPayload s() {
            if (this.f18230g == 1) {
                return (VanillaCampaignPayload) this.f18231h;
            }
            return VanillaCampaignPayload.r();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f18290a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ThickContent();
                case 2:
                    return f18227d;
                case 3:
                    this.k.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ThickContent thickContent = (ThickContent) obj2;
                    this.i = (MessagesProto.Content) visitor.a(this.i, thickContent.i);
                    this.j = (CommonTypesProto.Priority) visitor.a(this.j, thickContent.j);
                    this.k = visitor.a(this.k, thickContent.k);
                    boolean z = this.l;
                    boolean z2 = thickContent.l;
                    this.l = visitor.a(z, z, z2, z2);
                    int i = b.f18291b[thickContent.p().ordinal()];
                    if (i == 1) {
                        this.f18231h = visitor.e(this.f18230g == 1, this.f18231h, thickContent.f18231h);
                    } else if (i == 2) {
                        this.f18231h = visitor.e(this.f18230g == 2, this.f18231h, thickContent.f18231h);
                    } else if (i == 3) {
                        visitor.a(this.f18230g != 0);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        int i2 = thickContent.f18230g;
                        if (i2 != 0) {
                            this.f18230g = i2;
                        }
                        this.f18229f |= thickContent.f18229f;
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
                                    VanillaCampaignPayload.Builder b2 = this.f18230g == 1 ? ((VanillaCampaignPayload) this.f18231h).b() : null;
                                    this.f18231h = codedInputStream.a(VanillaCampaignPayload.t(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((VanillaCampaignPayload.Builder) this.f18231h);
                                        this.f18231h = b2.T();
                                    }
                                    this.f18230g = 1;
                                } else if (x == 18) {
                                    ExperimentalCampaignPayload.Builder b3 = this.f18230g == 2 ? ((ExperimentalCampaignPayload) this.f18231h).b() : null;
                                    this.f18231h = codedInputStream.a(ExperimentalCampaignPayload.p(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((ExperimentalCampaignPayload.Builder) this.f18231h);
                                        this.f18231h = b3.T();
                                    }
                                    this.f18230g = 2;
                                } else if (x == 26) {
                                    MessagesProto.Content.Builder b4 = this.i != null ? this.i.b() : null;
                                    this.i = (MessagesProto.Content) codedInputStream.a(MessagesProto.Content.s(), extensionRegistryLite);
                                    if (b4 != null) {
                                        b4.b((MessagesProto.Content.Builder) this.i);
                                        this.i = b4.T();
                                    }
                                } else if (x == 34) {
                                    CommonTypesProto.Priority.Builder b5 = this.j != null ? this.j.b() : null;
                                    this.j = (CommonTypesProto.Priority) codedInputStream.a(CommonTypesProto.Priority.p(), extensionRegistryLite);
                                    if (b5 != null) {
                                        b5.b((CommonTypesProto.Priority.Builder) this.j);
                                        this.j = b5.T();
                                    }
                                } else if (x == 42) {
                                    if (!this.k.M()) {
                                        this.k = GeneratedMessageLite.a(this.k);
                                    }
                                    this.k.add((CommonTypesProto.TriggeringCondition) codedInputStream.a(CommonTypesProto.TriggeringCondition.q(), extensionRegistryLite));
                                } else if (x != 56) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.l = codedInputStream.c();
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
                    if (f18228e == null) {
                        synchronized (ThickContent.class) {
                            if (f18228e == null) {
                                f18228e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18227d);
                            }
                        }
                    }
                    return f18228e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18227d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Campaign extends GeneratedMessageLite<Campaign, Builder> implements CampaignOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Campaign f18213d = new Campaign();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Campaign> f18214e;

        /* renamed from: f, reason: collision with root package name */
        private int f18215f;
        private int i;
        private CommonTypesProto.CampaignTime l;
        private CommonTypesProto.CampaignTime m;
        private Conditions.Condition n;
        private CommonTypesProto.Priority p;
        private MessagesProto.Content q;
        private Timestamp s;
        private Timestamp t;

        /* renamed from: g, reason: collision with root package name */
        private String f18216g = "";

        /* renamed from: h, reason: collision with root package name */
        private String f18217h = "";
        private String j = "";
        private String k = "";
        private Internal.ProtobufList<CommonTypesProto.TriggeringCondition> o = GeneratedMessageLite.k();
        private Internal.ProtobufList<CommonTypesProto.ScionConversionEvent> r = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Campaign, Builder> implements CampaignOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(Campaign.f18213d);
            }
        }

        static {
            f18213d.l();
        }

        private Campaign() {
        }

        public static Campaign p() {
            return f18213d;
        }

        public static Parser<Campaign> z() {
            return f18213d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18216g.isEmpty()) {
                codedOutputStream.b(1, t());
            }
            if (!this.f18217h.isEmpty()) {
                codedOutputStream.b(2, n());
            }
            if (this.i != CommonTypesProto.CampaignState.UNKNOWN_CAMPAIGN_STATE.getNumber()) {
                codedOutputStream.e(3, this.i);
            }
            if (!this.j.isEmpty()) {
                codedOutputStream.b(4, r());
            }
            if (!this.k.isEmpty()) {
                codedOutputStream.b(5, q());
            }
            if (this.l != null) {
                codedOutputStream.c(6, w());
            }
            if (this.m != null) {
                codedOutputStream.c(7, u());
            }
            if (this.n != null) {
                codedOutputStream.c(8, y());
            }
            for (int i = 0; i < this.o.size(); i++) {
                codedOutputStream.c(9, this.o.get(i));
            }
            if (this.p != null) {
                codedOutputStream.c(10, s());
            }
            if (this.q != null) {
                codedOutputStream.c(11, o());
            }
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                codedOutputStream.c(12, this.r.get(i2));
            }
            if (this.s != null) {
                codedOutputStream.c(13, x());
            }
            if (this.t != null) {
                codedOutputStream.c(14, v());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = !this.f18216g.isEmpty() ? CodedOutputStream.a(1, t()) + 0 : 0;
            if (!this.f18217h.isEmpty()) {
                a2 += CodedOutputStream.a(2, n());
            }
            if (this.i != CommonTypesProto.CampaignState.UNKNOWN_CAMPAIGN_STATE.getNumber()) {
                a2 += CodedOutputStream.a(3, this.i);
            }
            if (!this.j.isEmpty()) {
                a2 += CodedOutputStream.a(4, r());
            }
            if (!this.k.isEmpty()) {
                a2 += CodedOutputStream.a(5, q());
            }
            if (this.l != null) {
                a2 += CodedOutputStream.a(6, w());
            }
            if (this.m != null) {
                a2 += CodedOutputStream.a(7, u());
            }
            if (this.n != null) {
                a2 += CodedOutputStream.a(8, y());
            }
            int i2 = a2;
            for (int i3 = 0; i3 < this.o.size(); i3++) {
                i2 += CodedOutputStream.a(9, this.o.get(i3));
            }
            if (this.p != null) {
                i2 += CodedOutputStream.a(10, s());
            }
            if (this.q != null) {
                i2 += CodedOutputStream.a(11, o());
            }
            for (int i4 = 0; i4 < this.r.size(); i4++) {
                i2 += CodedOutputStream.a(12, this.r.get(i4));
            }
            if (this.s != null) {
                i2 += CodedOutputStream.a(13, x());
            }
            if (this.t != null) {
                i2 += CodedOutputStream.a(14, v());
            }
            this.f18584c = i2;
            return i2;
        }

        public String n() {
            return this.f18217h;
        }

        public MessagesProto.Content o() {
            MessagesProto.Content content = this.q;
            return content == null ? MessagesProto.Content.o() : content;
        }

        public String q() {
            return this.k;
        }

        public String r() {
            return this.j;
        }

        public CommonTypesProto.Priority s() {
            CommonTypesProto.Priority priority = this.p;
            return priority == null ? CommonTypesProto.Priority.n() : priority;
        }

        public String t() {
            return this.f18216g;
        }

        public CommonTypesProto.CampaignTime u() {
            CommonTypesProto.CampaignTime campaignTime = this.m;
            return campaignTime == null ? CommonTypesProto.CampaignTime.o() : campaignTime;
        }

        public Timestamp v() {
            Timestamp timestamp = this.t;
            return timestamp == null ? Timestamp.n() : timestamp;
        }

        public CommonTypesProto.CampaignTime w() {
            CommonTypesProto.CampaignTime campaignTime = this.l;
            return campaignTime == null ? CommonTypesProto.CampaignTime.o() : campaignTime;
        }

        public Timestamp x() {
            Timestamp timestamp = this.s;
            return timestamp == null ? Timestamp.n() : timestamp;
        }

        public Conditions.Condition y() {
            Conditions.Condition condition = this.n;
            return condition == null ? Conditions.Condition.o() : condition;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f18290a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Campaign();
                case 2:
                    return f18213d;
                case 3:
                    this.o.L();
                    this.r.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Campaign campaign = (Campaign) obj2;
                    this.f18216g = visitor.a(!this.f18216g.isEmpty(), this.f18216g, !campaign.f18216g.isEmpty(), campaign.f18216g);
                    this.f18217h = visitor.a(!this.f18217h.isEmpty(), this.f18217h, !campaign.f18217h.isEmpty(), campaign.f18217h);
                    this.i = visitor.a(this.i != 0, this.i, campaign.i != 0, campaign.i);
                    this.j = visitor.a(!this.j.isEmpty(), this.j, !campaign.j.isEmpty(), campaign.j);
                    this.k = visitor.a(!this.k.isEmpty(), this.k, !campaign.k.isEmpty(), campaign.k);
                    this.l = (CommonTypesProto.CampaignTime) visitor.a(this.l, campaign.l);
                    this.m = (CommonTypesProto.CampaignTime) visitor.a(this.m, campaign.m);
                    this.n = (Conditions.Condition) visitor.a(this.n, campaign.n);
                    this.o = visitor.a(this.o, campaign.o);
                    this.p = (CommonTypesProto.Priority) visitor.a(this.p, campaign.p);
                    this.q = (MessagesProto.Content) visitor.a(this.q, campaign.q);
                    this.r = visitor.a(this.r, campaign.r);
                    this.s = (Timestamp) visitor.a(this.s, campaign.s);
                    this.t = (Timestamp) visitor.a(this.t, campaign.t);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18215f |= campaign.f18215f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int x = codedInputStream.x();
                            switch (x) {
                                case 0:
                                    r0 = true;
                                case 10:
                                    this.f18216g = codedInputStream.w();
                                case 18:
                                    this.f18217h = codedInputStream.w();
                                case 24:
                                    this.i = codedInputStream.f();
                                case 34:
                                    this.j = codedInputStream.w();
                                case 42:
                                    this.k = codedInputStream.w();
                                case 50:
                                    CommonTypesProto.CampaignTime.Builder b2 = this.l != null ? this.l.b() : null;
                                    this.l = (CommonTypesProto.CampaignTime) codedInputStream.a(CommonTypesProto.CampaignTime.r(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((CommonTypesProto.CampaignTime.Builder) this.l);
                                        this.l = b2.T();
                                    }
                                case 58:
                                    CommonTypesProto.CampaignTime.Builder b3 = this.m != null ? this.m.b() : null;
                                    this.m = (CommonTypesProto.CampaignTime) codedInputStream.a(CommonTypesProto.CampaignTime.r(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((CommonTypesProto.CampaignTime.Builder) this.m);
                                        this.m = b3.T();
                                    }
                                case 66:
                                    Conditions.Condition.Builder b4 = this.n != null ? this.n.b() : null;
                                    this.n = (Conditions.Condition) codedInputStream.a(Conditions.Condition.p(), extensionRegistryLite);
                                    if (b4 != null) {
                                        b4.b((Conditions.Condition.Builder) this.n);
                                        this.n = b4.T();
                                    }
                                case 74:
                                    if (!this.o.M()) {
                                        this.o = GeneratedMessageLite.a(this.o);
                                    }
                                    this.o.add((CommonTypesProto.TriggeringCondition) codedInputStream.a(CommonTypesProto.TriggeringCondition.q(), extensionRegistryLite));
                                case 82:
                                    CommonTypesProto.Priority.Builder b5 = this.p != null ? this.p.b() : null;
                                    this.p = (CommonTypesProto.Priority) codedInputStream.a(CommonTypesProto.Priority.p(), extensionRegistryLite);
                                    if (b5 != null) {
                                        b5.b((CommonTypesProto.Priority.Builder) this.p);
                                        this.p = b5.T();
                                    }
                                case 90:
                                    MessagesProto.Content.Builder b6 = this.q != null ? this.q.b() : null;
                                    this.q = (MessagesProto.Content) codedInputStream.a(MessagesProto.Content.s(), extensionRegistryLite);
                                    if (b6 != null) {
                                        b6.b((MessagesProto.Content.Builder) this.q);
                                        this.q = b6.T();
                                    }
                                case 98:
                                    if (!this.r.M()) {
                                        this.r = GeneratedMessageLite.a(this.r);
                                    }
                                    this.r.add((CommonTypesProto.ScionConversionEvent) codedInputStream.a(CommonTypesProto.ScionConversionEvent.o(), extensionRegistryLite));
                                case 106:
                                    Timestamp.Builder b7 = this.s != null ? this.s.b() : null;
                                    this.s = (Timestamp) codedInputStream.a(Timestamp.o(), extensionRegistryLite);
                                    if (b7 != null) {
                                        b7.b((Timestamp.Builder) this.s);
                                        this.s = b7.T();
                                    }
                                case 114:
                                    Timestamp.Builder b8 = this.t != null ? this.t.b() : null;
                                    this.t = (Timestamp) codedInputStream.a(Timestamp.o(), extensionRegistryLite);
                                    if (b8 != null) {
                                        b8.b((Timestamp.Builder) this.t);
                                        this.t = b8.T();
                                    }
                                default:
                                    if (!codedInputStream.f(x)) {
                                        r0 = true;
                                    }
                            }
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
                    if (f18214e == null) {
                        synchronized (Campaign.class) {
                            if (f18214e == null) {
                                f18214e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18213d);
                            }
                        }
                    }
                    return f18214e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18213d;
        }
    }
}

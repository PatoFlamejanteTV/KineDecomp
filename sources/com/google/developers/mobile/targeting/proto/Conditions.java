package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class Conditions {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface AbtExperimentConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface AnalyticsAudienceConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface AnalyticsUserPropertyConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface AndConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface AppVersionConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum ConditionUseCase implements Internal.EnumLite {
        USE_CASE_NOT_SPECIFIED(0),
        UNIVERSAL(1),
        REMOTE_CONFIG_ABT_EXPERIMENT(2),
        NOTIFICATIONS_ABT_EXPERIMENT(3),
        DIGITAL_GOODS(4),
        IN_APP_MESSAGING(5),
        REMOTE_CONFIG(6),
        UNRECOGNIZED(-1);

        public static final int DIGITAL_GOODS_VALUE = 4;
        public static final int IN_APP_MESSAGING_VALUE = 5;
        public static final int NOTIFICATIONS_ABT_EXPERIMENT_VALUE = 3;
        public static final int REMOTE_CONFIG_ABT_EXPERIMENT_VALUE = 2;
        public static final int REMOTE_CONFIG_VALUE = 6;
        public static final int UNIVERSAL_VALUE = 1;
        public static final int USE_CASE_NOT_SPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ConditionUseCase> internalValueMap = new f();
        private final int value;

        ConditionUseCase(int i) {
            this.value = i;
        }

        public static ConditionUseCase forNumber(int i) {
            switch (i) {
                case 0:
                    return USE_CASE_NOT_SPECIFIED;
                case 1:
                    return UNIVERSAL;
                case 2:
                    return REMOTE_CONFIG_ABT_EXPERIMENT;
                case 3:
                    return NOTIFICATIONS_ABT_EXPERIMENT;
                case 4:
                    return DIGITAL_GOODS;
                case 5:
                    return IN_APP_MESSAGING;
                case 6:
                    return REMOTE_CONFIG;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ConditionUseCase> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ConditionUseCase valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface DateTimeConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface DeviceCountryConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface DeviceLanguageConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class FalseCondition extends GeneratedMessageLite<FalseCondition, Builder> implements FalseConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final FalseCondition f16277d = new FalseCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<FalseCondition> f16278e;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FalseCondition, Builder> implements FalseConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(FalseCondition.f16277d);
            }
        }

        static {
            f16277d.l();
        }

        private FalseCondition() {
        }

        public static Parser<FalseCondition> n() {
            return f16277d.f();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FalseCondition();
                case 2:
                    return f16277d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x == 0 || !codedInputStream.f(x)) {
                                    z = true;
                                }
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
                    if (f16278e == null) {
                        synchronized (FalseCondition.class) {
                            if (f16278e == null) {
                                f16278e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16277d);
                            }
                        }
                    }
                    return f16278e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16277d;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            this.f18584c = 0;
            return 0;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface FalseConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface FirebaseAppIdConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface FunctionConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface NotConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface OrConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface OsTypeConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface PercentConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class PredictionsCondition extends GeneratedMessageLite<PredictionsCondition, Builder> implements PredictionsConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final PredictionsCondition f16300d = new PredictionsCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<PredictionsCondition> f16301e;

        /* renamed from: f, reason: collision with root package name */
        private int f16302f;

        /* renamed from: g, reason: collision with root package name */
        private int f16303g;

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<PredictionsTarget> f16304h = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<PredictionsCondition, Builder> implements PredictionsConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(PredictionsCondition.f16300d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum PredictionsOperator implements Internal.EnumLite {
            UNKNOWN(0),
            IN_AT_LEAST_ONE(1),
            IN_ALL(2),
            UNRECOGNIZED(-1);

            public static final int IN_ALL_VALUE = 2;
            public static final int IN_AT_LEAST_ONE_VALUE = 1;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<PredictionsOperator> internalValueMap = new k();
            private final int value;

            PredictionsOperator(int i) {
                this.value = i;
            }

            public static PredictionsOperator forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return IN_AT_LEAST_ONE;
                }
                if (i != 2) {
                    return null;
                }
                return IN_ALL;
            }

            public static Internal.EnumLiteMap<PredictionsOperator> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static PredictionsOperator valueOf(int i) {
                return forNumber(i);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public interface PredictionsTargetOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            f16300d.l();
        }

        private PredictionsCondition() {
        }

        public static Parser<PredictionsCondition> n() {
            return f16300d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16303g != PredictionsOperator.UNKNOWN.getNumber()) {
                codedOutputStream.e(1, this.f16303g);
            }
            for (int i = 0; i < this.f16304h.size(); i++) {
                codedOutputStream.c(2, this.f16304h.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16303g != PredictionsOperator.UNKNOWN.getNumber() ? CodedOutputStream.a(1, this.f16303g) + 0 : 0;
            for (int i2 = 0; i2 < this.f16304h.size(); i2++) {
                a2 += CodedOutputStream.a(2, this.f16304h.get(i2));
            }
            this.f18584c = a2;
            return a2;
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class PredictionsTarget extends GeneratedMessageLite<PredictionsTarget, Builder> implements PredictionsTargetOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final PredictionsTarget f16305d = new PredictionsTarget();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<PredictionsTarget> f16306e;

            /* renamed from: f, reason: collision with root package name */
            private String f16307f = "";

            /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<PredictionsTarget, Builder> implements PredictionsTargetOrBuilder {
                /* synthetic */ Builder(b bVar) {
                    this();
                }

                private Builder() {
                    super(PredictionsTarget.f16305d);
                }
            }

            static {
                f16305d.l();
            }

            private PredictionsTarget() {
            }

            public static Parser<PredictionsTarget> o() {
                return f16305d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                if (this.f16307f.isEmpty()) {
                    return;
                }
                codedOutputStream.b(1, n());
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int a2 = this.f16307f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
                this.f18584c = a2;
                return a2;
            }

            public String n() {
                return this.f16307f;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                b bVar = null;
                switch (b.f16318a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new PredictionsTarget();
                    case 2:
                        return f16305d;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(bVar);
                    case 5:
                        PredictionsTarget predictionsTarget = (PredictionsTarget) obj2;
                        this.f16307f = ((GeneratedMessageLite.Visitor) obj).a(!this.f16307f.isEmpty(), this.f16307f, true ^ predictionsTarget.f16307f.isEmpty(), predictionsTarget.f16307f);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x != 10) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        this.f16307f = codedInputStream.w();
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
                        if (f16306e == null) {
                            synchronized (PredictionsTarget.class) {
                                if (f16306e == null) {
                                    f16306e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16305d);
                                }
                            }
                        }
                        return f16306e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f16305d;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PredictionsCondition();
                case 2:
                    return f16300d;
                case 3:
                    this.f16304h.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    PredictionsCondition predictionsCondition = (PredictionsCondition) obj2;
                    this.f16303g = visitor.a(this.f16303g != 0, this.f16303g, predictionsCondition.f16303g != 0, predictionsCondition.f16303g);
                    this.f16304h = visitor.a(this.f16304h, predictionsCondition.f16304h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f16302f |= predictionsCondition.f16302f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r1) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        this.f16303g = codedInputStream.f();
                                    } else if (x != 18) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        if (!this.f16304h.M()) {
                                            this.f16304h = GeneratedMessageLite.a(this.f16304h);
                                        }
                                        this.f16304h.add((PredictionsTarget) codedInputStream.a(PredictionsTarget.o(), extensionRegistryLite));
                                    }
                                }
                                r1 = true;
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
                    if (f16301e == null) {
                        synchronized (PredictionsCondition.class) {
                            if (f16301e == null) {
                                f16301e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16300d);
                            }
                        }
                    }
                    return f16301e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16300d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface PredictionsConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface TargetDateTimeZoneOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface TopicConditionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class TrueCondition extends GeneratedMessageLite<TrueCondition, Builder> implements TrueConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final TrueCondition f16315d = new TrueCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<TrueCondition> f16316e;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TrueCondition, Builder> implements TrueConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(TrueCondition.f16315d);
            }
        }

        static {
            f16315d.l();
        }

        private TrueCondition() {
        }

        public static Parser<TrueCondition> n() {
            return f16315d.f();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TrueCondition();
                case 2:
                    return f16315d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x == 0 || !codedInputStream.f(x)) {
                                    z = true;
                                }
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
                    if (f16316e == null) {
                        synchronized (TrueCondition.class) {
                            if (f16316e == null) {
                                f16316e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16315d);
                            }
                        }
                    }
                    return f16316e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16315d;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            this.f18584c = 0;
            return 0;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface TrueConditionOrBuilder extends MessageLiteOrBuilder {
    }

    private Conditions() {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class AbtExperimentCondition extends GeneratedMessageLite<AbtExperimentCondition, Builder> implements AbtExperimentConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final AbtExperimentCondition f16242d = new AbtExperimentCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<AbtExperimentCondition> f16243e;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<String> f16244f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AbtExperimentCondition, Builder> implements AbtExperimentConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(AbtExperimentCondition.f16242d);
            }
        }

        static {
            f16242d.l();
        }

        private AbtExperimentCondition() {
        }

        public static Parser<AbtExperimentCondition> o() {
            return f16242d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f16244f.size(); i++) {
                codedOutputStream.b(1, this.f16244f.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f16244f.size(); i3++) {
                i2 += CodedOutputStream.a(this.f16244f.get(i3));
            }
            int size = 0 + i2 + (n().size() * 1);
            this.f18584c = size;
            return size;
        }

        public List<String> n() {
            return this.f16244f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AbtExperimentCondition();
                case 2:
                    return f16242d;
                case 3:
                    this.f16244f.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    this.f16244f = ((GeneratedMessageLite.Visitor) obj).a(this.f16244f, ((AbtExperimentCondition) obj2).f16244f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
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
                                        String w = codedInputStream.w();
                                        if (!this.f16244f.M()) {
                                            this.f16244f = GeneratedMessageLite.a(this.f16244f);
                                        }
                                        this.f16244f.add(w);
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
                    if (f16243e == null) {
                        synchronized (AbtExperimentCondition.class) {
                            if (f16243e == null) {
                                f16243e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16242d);
                            }
                        }
                    }
                    return f16243e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16242d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class AndCondition extends GeneratedMessageLite<AndCondition, Builder> implements AndConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final AndCondition f16255d = new AndCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<AndCondition> f16256e;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<Condition> f16257f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AndCondition, Builder> implements AndConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(AndCondition.f16255d);
            }
        }

        static {
            f16255d.l();
        }

        private AndCondition() {
        }

        public static Parser<AndCondition> n() {
            return f16255d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f16257f.size(); i++) {
                codedOutputStream.c(1, this.f16257f.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f16257f.size(); i3++) {
                i2 += CodedOutputStream.a(1, this.f16257f.get(i3));
            }
            this.f18584c = i2;
            return i2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AndCondition();
                case 2:
                    return f16255d;
                case 3:
                    this.f16257f.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    this.f16257f = ((GeneratedMessageLite.Visitor) obj).a(this.f16257f, ((AndCondition) obj2).f16257f);
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
                                        if (!this.f16257f.M()) {
                                            this.f16257f = GeneratedMessageLite.a(this.f16257f);
                                        }
                                        this.f16257f.add((Condition) codedInputStream.a(Condition.p(), extensionRegistryLite));
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
                    if (f16256e == null) {
                        synchronized (AndCondition.class) {
                            if (f16256e == null) {
                                f16256e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16255d);
                            }
                        }
                    }
                    return f16256e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16255d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class DeviceCountryCondition extends GeneratedMessageLite<DeviceCountryCondition, Builder> implements DeviceCountryConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final DeviceCountryCondition f16271d = new DeviceCountryCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<DeviceCountryCondition> f16272e;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<String> f16273f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DeviceCountryCondition, Builder> implements DeviceCountryConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(DeviceCountryCondition.f16271d);
            }
        }

        static {
            f16271d.l();
        }

        private DeviceCountryCondition() {
        }

        public static Parser<DeviceCountryCondition> o() {
            return f16271d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f16273f.size(); i++) {
                codedOutputStream.b(1, this.f16273f.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f16273f.size(); i3++) {
                i2 += CodedOutputStream.a(this.f16273f.get(i3));
            }
            int size = 0 + i2 + (n().size() * 1);
            this.f18584c = size;
            return size;
        }

        public List<String> n() {
            return this.f16273f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeviceCountryCondition();
                case 2:
                    return f16271d;
                case 3:
                    this.f16273f.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    this.f16273f = ((GeneratedMessageLite.Visitor) obj).a(this.f16273f, ((DeviceCountryCondition) obj2).f16273f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
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
                                        String w = codedInputStream.w();
                                        if (!this.f16273f.M()) {
                                            this.f16273f = GeneratedMessageLite.a(this.f16273f);
                                        }
                                        this.f16273f.add(w);
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
                    if (f16272e == null) {
                        synchronized (DeviceCountryCondition.class) {
                            if (f16272e == null) {
                                f16272e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16271d);
                            }
                        }
                    }
                    return f16272e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16271d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class DeviceLanguageCondition extends GeneratedMessageLite<DeviceLanguageCondition, Builder> implements DeviceLanguageConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final DeviceLanguageCondition f16274d = new DeviceLanguageCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<DeviceLanguageCondition> f16275e;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<String> f16276f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DeviceLanguageCondition, Builder> implements DeviceLanguageConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(DeviceLanguageCondition.f16274d);
            }
        }

        static {
            f16274d.l();
        }

        private DeviceLanguageCondition() {
        }

        public static Parser<DeviceLanguageCondition> o() {
            return f16274d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f16276f.size(); i++) {
                codedOutputStream.b(1, this.f16276f.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f16276f.size(); i3++) {
                i2 += CodedOutputStream.a(this.f16276f.get(i3));
            }
            int size = 0 + i2 + (n().size() * 1);
            this.f18584c = size;
            return size;
        }

        public List<String> n() {
            return this.f16276f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeviceLanguageCondition();
                case 2:
                    return f16274d;
                case 3:
                    this.f16276f.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    this.f16276f = ((GeneratedMessageLite.Visitor) obj).a(this.f16276f, ((DeviceLanguageCondition) obj2).f16276f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
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
                                        String w = codedInputStream.w();
                                        if (!this.f16276f.M()) {
                                            this.f16276f = GeneratedMessageLite.a(this.f16276f);
                                        }
                                        this.f16276f.add(w);
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
                    if (f16275e == null) {
                        synchronized (DeviceLanguageCondition.class) {
                            if (f16275e == null) {
                                f16275e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16274d);
                            }
                        }
                    }
                    return f16275e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16274d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class FirebaseAppIdCondition extends GeneratedMessageLite<FirebaseAppIdCondition, Builder> implements FirebaseAppIdConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final FirebaseAppIdCondition f16279d = new FirebaseAppIdCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<FirebaseAppIdCondition> f16280e;

        /* renamed from: f, reason: collision with root package name */
        private String f16281f = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAppIdCondition, Builder> implements FirebaseAppIdConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(FirebaseAppIdCondition.f16279d);
            }
        }

        static {
            f16279d.l();
        }

        private FirebaseAppIdCondition() {
        }

        public static Parser<FirebaseAppIdCondition> o() {
            return f16279d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16281f.isEmpty()) {
                return;
            }
            codedOutputStream.b(1, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16281f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f16281f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FirebaseAppIdCondition();
                case 2:
                    return f16279d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    FirebaseAppIdCondition firebaseAppIdCondition = (FirebaseAppIdCondition) obj2;
                    this.f16281f = ((GeneratedMessageLite.Visitor) obj).a(!this.f16281f.isEmpty(), this.f16281f, true ^ firebaseAppIdCondition.f16281f.isEmpty(), firebaseAppIdCondition.f16281f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f16281f = codedInputStream.w();
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
                    if (f16280e == null) {
                        synchronized (FirebaseAppIdCondition.class) {
                            if (f16280e == null) {
                                f16280e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16279d);
                            }
                        }
                    }
                    return f16280e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16279d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class FunctionCondition extends GeneratedMessageLite<FunctionCondition, Builder> implements FunctionConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final FunctionCondition f16282d = new FunctionCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<FunctionCondition> f16283e;

        /* renamed from: f, reason: collision with root package name */
        private String f16284f = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FunctionCondition, Builder> implements FunctionConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(FunctionCondition.f16282d);
            }
        }

        static {
            f16282d.l();
        }

        private FunctionCondition() {
        }

        public static Parser<FunctionCondition> o() {
            return f16282d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16284f.isEmpty()) {
                return;
            }
            codedOutputStream.b(1, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16284f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f16284f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FunctionCondition();
                case 2:
                    return f16282d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    FunctionCondition functionCondition = (FunctionCondition) obj2;
                    this.f16284f = ((GeneratedMessageLite.Visitor) obj).a(!this.f16284f.isEmpty(), this.f16284f, true ^ functionCondition.f16284f.isEmpty(), functionCondition.f16284f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f16284f = codedInputStream.w();
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
                    if (f16283e == null) {
                        synchronized (FunctionCondition.class) {
                            if (f16283e == null) {
                                f16283e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16282d);
                            }
                        }
                    }
                    return f16283e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16282d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class NotCondition extends GeneratedMessageLite<NotCondition, Builder> implements NotConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final NotCondition f16285d = new NotCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<NotCondition> f16286e;

        /* renamed from: f, reason: collision with root package name */
        private Condition f16287f;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<NotCondition, Builder> implements NotConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(NotCondition.f16285d);
            }
        }

        static {
            f16285d.l();
        }

        private NotCondition() {
        }

        public static Parser<NotCondition> o() {
            return f16285d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16287f != null) {
                codedOutputStream.c(1, n());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16287f != null ? 0 + CodedOutputStream.a(1, n()) : 0;
            this.f18584c = a2;
            return a2;
        }

        public Condition n() {
            Condition condition = this.f16287f;
            return condition == null ? Condition.o() : condition;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new NotCondition();
                case 2:
                    return f16285d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    this.f16287f = (Condition) ((GeneratedMessageLite.Visitor) obj).a(this.f16287f, ((NotCondition) obj2).f16287f);
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
                                        Condition.Builder b2 = this.f16287f != null ? this.f16287f.b() : null;
                                        this.f16287f = (Condition) codedInputStream.a(Condition.p(), extensionRegistryLite);
                                        if (b2 != null) {
                                            b2.b((Condition.Builder) this.f16287f);
                                            this.f16287f = b2.T();
                                        }
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
                    if (f16286e == null) {
                        synchronized (NotCondition.class) {
                            if (f16286e == null) {
                                f16286e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16285d);
                            }
                        }
                    }
                    return f16286e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16285d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class OrCondition extends GeneratedMessageLite<OrCondition, Builder> implements OrConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final OrCondition f16288d = new OrCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<OrCondition> f16289e;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<Condition> f16290f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<OrCondition, Builder> implements OrConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(OrCondition.f16288d);
            }
        }

        static {
            f16288d.l();
        }

        private OrCondition() {
        }

        public static Parser<OrCondition> n() {
            return f16288d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f16290f.size(); i++) {
                codedOutputStream.c(1, this.f16290f.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f16290f.size(); i3++) {
                i2 += CodedOutputStream.a(1, this.f16290f.get(i3));
            }
            this.f18584c = i2;
            return i2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OrCondition();
                case 2:
                    return f16288d;
                case 3:
                    this.f16290f.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    this.f16290f = ((GeneratedMessageLite.Visitor) obj).a(this.f16290f, ((OrCondition) obj2).f16290f);
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
                                        if (!this.f16290f.M()) {
                                            this.f16290f = GeneratedMessageLite.a(this.f16290f);
                                        }
                                        this.f16290f.add((Condition) codedInputStream.a(Condition.p(), extensionRegistryLite));
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
                    if (f16289e == null) {
                        synchronized (OrCondition.class) {
                            if (f16289e == null) {
                                f16289e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16288d);
                            }
                        }
                    }
                    return f16289e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16288d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class TopicCondition extends GeneratedMessageLite<TopicCondition, Builder> implements TopicConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final TopicCondition f16312d = new TopicCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<TopicCondition> f16313e;

        /* renamed from: f, reason: collision with root package name */
        private String f16314f = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TopicCondition, Builder> implements TopicConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(TopicCondition.f16312d);
            }
        }

        static {
            f16312d.l();
        }

        private TopicCondition() {
        }

        public static Parser<TopicCondition> o() {
            return f16312d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16314f.isEmpty()) {
                return;
            }
            codedOutputStream.b(1, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16314f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f16314f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TopicCondition();
                case 2:
                    return f16312d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    TopicCondition topicCondition = (TopicCondition) obj2;
                    this.f16314f = ((GeneratedMessageLite.Visitor) obj).a(!this.f16314f.isEmpty(), this.f16314f, true ^ topicCondition.f16314f.isEmpty(), topicCondition.f16314f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f16314f = codedInputStream.w();
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
                    if (f16313e == null) {
                        synchronized (TopicCondition.class) {
                            if (f16313e == null) {
                                f16313e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16312d);
                            }
                        }
                    }
                    return f16313e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16312d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class DateTimeCondition extends GeneratedMessageLite<DateTimeCondition, Builder> implements DateTimeConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final DateTimeCondition f16267d = new DateTimeCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<DateTimeCondition> f16268e;

        /* renamed from: f, reason: collision with root package name */
        private int f16269f;

        /* renamed from: g, reason: collision with root package name */
        private TargetDateTimeZone f16270g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DateTimeCondition, Builder> implements DateTimeConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(DateTimeCondition.f16267d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum TimeOperator implements Internal.EnumLite {
            UNKNOWN(0),
            BEFORE(1),
            AFTER_OR_EQUAL(2),
            UNRECOGNIZED(-1);

            public static final int AFTER_OR_EQUAL_VALUE = 2;
            public static final int BEFORE_VALUE = 1;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<TimeOperator> internalValueMap = new g();
            private final int value;

            TimeOperator(int i) {
                this.value = i;
            }

            public static TimeOperator forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return BEFORE;
                }
                if (i != 2) {
                    return null;
                }
                return AFTER_OR_EQUAL;
            }

            public static Internal.EnumLiteMap<TimeOperator> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static TimeOperator valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f16267d.l();
        }

        private DateTimeCondition() {
        }

        public static Parser<DateTimeCondition> o() {
            return f16267d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16269f != TimeOperator.UNKNOWN.getNumber()) {
                codedOutputStream.e(1, this.f16269f);
            }
            if (this.f16270g != null) {
                codedOutputStream.c(2, n());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16269f != TimeOperator.UNKNOWN.getNumber() ? 0 + CodedOutputStream.a(1, this.f16269f) : 0;
            if (this.f16270g != null) {
                a2 += CodedOutputStream.a(2, n());
            }
            this.f18584c = a2;
            return a2;
        }

        public TargetDateTimeZone n() {
            TargetDateTimeZone targetDateTimeZone = this.f16270g;
            return targetDateTimeZone == null ? TargetDateTimeZone.o() : targetDateTimeZone;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DateTimeCondition();
                case 2:
                    return f16267d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DateTimeCondition dateTimeCondition = (DateTimeCondition) obj2;
                    this.f16269f = visitor.a(this.f16269f != 0, this.f16269f, dateTimeCondition.f16269f != 0, dateTimeCondition.f16269f);
                    this.f16270g = (TargetDateTimeZone) visitor.a(this.f16270g, dateTimeCondition.f16270g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f16269f = codedInputStream.f();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    TargetDateTimeZone.Builder b2 = this.f16270g != null ? this.f16270g.b() : null;
                                    this.f16270g = (TargetDateTimeZone) codedInputStream.a(TargetDateTimeZone.q(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((TargetDateTimeZone.Builder) this.f16270g);
                                        this.f16270g = b2.T();
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
                    if (f16268e == null) {
                        synchronized (DateTimeCondition.class) {
                            if (f16268e == null) {
                                f16268e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16267d);
                            }
                        }
                    }
                    return f16268e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16267d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class OsTypeCondition extends GeneratedMessageLite<OsTypeCondition, Builder> implements OsTypeConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final OsTypeCondition f16291d = new OsTypeCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<OsTypeCondition> f16292e;

        /* renamed from: f, reason: collision with root package name */
        private int f16293f;

        /* renamed from: g, reason: collision with root package name */
        private int f16294g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<OsTypeCondition, Builder> implements OsTypeConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(OsTypeCondition.f16291d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum OsType implements Internal.EnumLite {
            UNKNOWN_OS_TYPE(0),
            ANDROID(1),
            IOS(2),
            UNRECOGNIZED(-1);

            public static final int ANDROID_VALUE = 1;
            public static final int IOS_VALUE = 2;
            public static final int UNKNOWN_OS_TYPE_VALUE = 0;
            private static final Internal.EnumLiteMap<OsType> internalValueMap = new h();
            private final int value;

            OsType(int i) {
                this.value = i;
            }

            public static OsType forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN_OS_TYPE;
                }
                if (i == 1) {
                    return ANDROID;
                }
                if (i != 2) {
                    return null;
                }
                return IOS;
            }

            public static Internal.EnumLiteMap<OsType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OsType valueOf(int i) {
                return forNumber(i);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum OsTypeOperator implements Internal.EnumLite {
            UNKNOWN_OPERATOR(0),
            EQUALS(1),
            NOT_EQUALS(2),
            UNRECOGNIZED(-1);

            public static final int EQUALS_VALUE = 1;
            public static final int NOT_EQUALS_VALUE = 2;
            public static final int UNKNOWN_OPERATOR_VALUE = 0;
            private static final Internal.EnumLiteMap<OsTypeOperator> internalValueMap = new i();
            private final int value;

            OsTypeOperator(int i) {
                this.value = i;
            }

            public static OsTypeOperator forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN_OPERATOR;
                }
                if (i == 1) {
                    return EQUALS;
                }
                if (i != 2) {
                    return null;
                }
                return NOT_EQUALS;
            }

            public static Internal.EnumLiteMap<OsTypeOperator> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OsTypeOperator valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f16291d.l();
        }

        private OsTypeCondition() {
        }

        public static Parser<OsTypeCondition> n() {
            return f16291d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16293f != OsTypeOperator.UNKNOWN_OPERATOR.getNumber()) {
                codedOutputStream.e(1, this.f16293f);
            }
            if (this.f16294g != OsType.UNKNOWN_OS_TYPE.getNumber()) {
                codedOutputStream.e(2, this.f16294g);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16293f != OsTypeOperator.UNKNOWN_OPERATOR.getNumber() ? 0 + CodedOutputStream.a(1, this.f16293f) : 0;
            if (this.f16294g != OsType.UNKNOWN_OS_TYPE.getNumber()) {
                a2 += CodedOutputStream.a(2, this.f16294g);
            }
            this.f18584c = a2;
            return a2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OsTypeCondition();
                case 2:
                    return f16291d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    OsTypeCondition osTypeCondition = (OsTypeCondition) obj2;
                    this.f16293f = visitor.a(this.f16293f != 0, this.f16293f, osTypeCondition.f16293f != 0, osTypeCondition.f16293f);
                    this.f16294g = visitor.a(this.f16294g != 0, this.f16294g, osTypeCondition.f16294g != 0, osTypeCondition.f16294g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f16293f = codedInputStream.f();
                                } else if (x != 16) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f16294g = codedInputStream.f();
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
                    if (f16292e == null) {
                        synchronized (OsTypeCondition.class) {
                            if (f16292e == null) {
                                f16292e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16291d);
                            }
                        }
                    }
                    return f16292e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16291d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class TargetDateTimeZone extends GeneratedMessageLite<TargetDateTimeZone, Builder> implements TargetDateTimeZoneOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final TargetDateTimeZone f16308d = new TargetDateTimeZone();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<TargetDateTimeZone> f16309e;

        /* renamed from: f, reason: collision with root package name */
        private String f16310f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f16311g = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TargetDateTimeZone, Builder> implements TargetDateTimeZoneOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(TargetDateTimeZone.f16308d);
            }
        }

        static {
            f16308d.l();
        }

        private TargetDateTimeZone() {
        }

        public static TargetDateTimeZone o() {
            return f16308d;
        }

        public static Parser<TargetDateTimeZone> q() {
            return f16308d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f16310f.isEmpty()) {
                codedOutputStream.b(1, n());
            }
            if (this.f16311g.isEmpty()) {
                return;
            }
            codedOutputStream.b(2, p());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16310f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            if (!this.f16311g.isEmpty()) {
                a2 += CodedOutputStream.a(2, p());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f16310f;
        }

        public String p() {
            return this.f16311g;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TargetDateTimeZone();
                case 2:
                    return f16308d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    TargetDateTimeZone targetDateTimeZone = (TargetDateTimeZone) obj2;
                    this.f16310f = visitor.a(!this.f16310f.isEmpty(), this.f16310f, !targetDateTimeZone.f16310f.isEmpty(), targetDateTimeZone.f16310f);
                    this.f16311g = visitor.a(!this.f16311g.isEmpty(), this.f16311g, true ^ targetDateTimeZone.f16311g.isEmpty(), targetDateTimeZone.f16311g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f16310f = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f16311g = codedInputStream.w();
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
                    if (f16309e == null) {
                        synchronized (TargetDateTimeZone.class) {
                            if (f16309e == null) {
                                f16309e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16308d);
                            }
                        }
                    }
                    return f16309e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16308d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class AppVersionCondition extends GeneratedMessageLite<AppVersionCondition, Builder> implements AppVersionConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final AppVersionCondition f16258d = new AppVersionCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<AppVersionCondition> f16259e;

        /* renamed from: f, reason: collision with root package name */
        private int f16260f;

        /* renamed from: g, reason: collision with root package name */
        private int f16261g;

        /* renamed from: h, reason: collision with root package name */
        private String f16262h = "";
        private Internal.ProtobufList<String> i = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum AppVersionOperator implements Internal.EnumLite {
            UNKNOWN(0),
            CONTAINS(1),
            DOES_NOT_CONTAIN(2),
            EXACTLY_MATCHES(3),
            CONTAINS_REGEX(4),
            UNRECOGNIZED(-1);

            public static final int CONTAINS_REGEX_VALUE = 4;
            public static final int CONTAINS_VALUE = 1;
            public static final int DOES_NOT_CONTAIN_VALUE = 2;
            public static final int EXACTLY_MATCHES_VALUE = 3;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<AppVersionOperator> internalValueMap = new e();
            private final int value;

            AppVersionOperator(int i) {
                this.value = i;
            }

            public static AppVersionOperator forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return CONTAINS;
                }
                if (i == 2) {
                    return DOES_NOT_CONTAIN;
                }
                if (i == 3) {
                    return EXACTLY_MATCHES;
                }
                if (i != 4) {
                    return null;
                }
                return CONTAINS_REGEX;
            }

            public static Internal.EnumLiteMap<AppVersionOperator> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static AppVersionOperator valueOf(int i) {
                return forNumber(i);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppVersionCondition, Builder> implements AppVersionConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(AppVersionCondition.f16258d);
            }
        }

        static {
            f16258d.l();
        }

        private AppVersionCondition() {
        }

        public static Parser<AppVersionCondition> p() {
            return f16258d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16261g != AppVersionOperator.UNKNOWN.getNumber()) {
                codedOutputStream.e(1, this.f16261g);
            }
            if (!this.f16262h.isEmpty()) {
                codedOutputStream.b(2, o());
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
            int a2 = this.f16261g != AppVersionOperator.UNKNOWN.getNumber() ? CodedOutputStream.a(1, this.f16261g) + 0 : 0;
            if (!this.f16262h.isEmpty()) {
                a2 += CodedOutputStream.a(2, o());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                i2 += CodedOutputStream.a(this.i.get(i3));
            }
            int size = a2 + i2 + (n().size() * 1);
            this.f18584c = size;
            return size;
        }

        public List<String> n() {
            return this.i;
        }

        @Deprecated
        public String o() {
            return this.f16262h;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AppVersionCondition();
                case 2:
                    return f16258d;
                case 3:
                    this.i.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AppVersionCondition appVersionCondition = (AppVersionCondition) obj2;
                    this.f16261g = visitor.a(this.f16261g != 0, this.f16261g, appVersionCondition.f16261g != 0, appVersionCondition.f16261g);
                    this.f16262h = visitor.a(!this.f16262h.isEmpty(), this.f16262h, !appVersionCondition.f16262h.isEmpty(), appVersionCondition.f16262h);
                    this.i = visitor.a(this.i, appVersionCondition.i);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f16260f |= appVersionCondition.f16260f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        this.f16261g = codedInputStream.f();
                                    } else if (x == 18) {
                                        this.f16262h = codedInputStream.w();
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
                    if (f16259e == null) {
                        synchronized (AppVersionCondition.class) {
                            if (f16259e == null) {
                                f16259e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16258d);
                            }
                        }
                    }
                    return f16259e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16258d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class PercentCondition extends GeneratedMessageLite<PercentCondition, Builder> implements PercentConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final PercentCondition f16295d = new PercentCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<PercentCondition> f16296e;

        /* renamed from: f, reason: collision with root package name */
        private int f16297f;

        /* renamed from: g, reason: collision with root package name */
        private int f16298g;

        /* renamed from: h, reason: collision with root package name */
        private String f16299h = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<PercentCondition, Builder> implements PercentConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(PercentCondition.f16295d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum PercentOperator implements Internal.EnumLite {
            UNKNOWN(0),
            LESS_OR_EQUAL(1),
            GREATER_THAN(2),
            UNRECOGNIZED(-1);

            public static final int GREATER_THAN_VALUE = 2;
            public static final int LESS_OR_EQUAL_VALUE = 1;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<PercentOperator> internalValueMap = new j();
            private final int value;

            PercentOperator(int i) {
                this.value = i;
            }

            public static PercentOperator forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return LESS_OR_EQUAL;
                }
                if (i != 2) {
                    return null;
                }
                return GREATER_THAN;
            }

            public static Internal.EnumLiteMap<PercentOperator> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static PercentOperator valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f16295d.l();
        }

        private PercentCondition() {
        }

        public static Parser<PercentCondition> o() {
            return f16295d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16297f != PercentOperator.UNKNOWN.getNumber()) {
                codedOutputStream.e(1, this.f16297f);
            }
            int i = this.f16298g;
            if (i != 0) {
                codedOutputStream.i(2, i);
            }
            if (this.f16299h.isEmpty()) {
                return;
            }
            codedOutputStream.b(3, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16297f != PercentOperator.UNKNOWN.getNumber() ? 0 + CodedOutputStream.a(1, this.f16297f) : 0;
            int i2 = this.f16298g;
            if (i2 != 0) {
                a2 += CodedOutputStream.d(2, i2);
            }
            if (!this.f16299h.isEmpty()) {
                a2 += CodedOutputStream.a(3, n());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f16299h;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PercentCondition();
                case 2:
                    return f16295d;
                case 3:
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    PercentCondition percentCondition = (PercentCondition) obj2;
                    this.f16297f = visitor.a(this.f16297f != 0, this.f16297f, percentCondition.f16297f != 0, percentCondition.f16297f);
                    this.f16298g = visitor.a(this.f16298g != 0, this.f16298g, percentCondition.f16298g != 0, percentCondition.f16298g);
                    this.f16299h = visitor.a(!this.f16299h.isEmpty(), this.f16299h, !percentCondition.f16299h.isEmpty(), percentCondition.f16299h);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f16297f = codedInputStream.f();
                                } else if (x == 16) {
                                    this.f16298g = codedInputStream.y();
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f16299h = codedInputStream.w();
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
                    if (f16296e == null) {
                        synchronized (PercentCondition.class) {
                            if (f16296e == null) {
                                f16296e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16295d);
                            }
                        }
                    }
                    return f16296e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16295d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class AnalyticsAudienceCondition extends GeneratedMessageLite<AnalyticsAudienceCondition, Builder> implements AnalyticsAudienceConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final AnalyticsAudienceCondition f16245d = new AnalyticsAudienceCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<AnalyticsAudienceCondition> f16246e;

        /* renamed from: f, reason: collision with root package name */
        private int f16247f;

        /* renamed from: g, reason: collision with root package name */
        private int f16248g;

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<String> f16249h = GeneratedMessageLite.k();
        private Internal.LongList i = GeneratedMessageLite.j();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum AnalyticsAudienceOperator implements Internal.EnumLite {
            UNKNOWN(0),
            IN_AT_LEAST_ONE(1),
            NOT_IN_AT_LEAST_ONE(2),
            IN_ALL(3),
            IN_NONE(4),
            UNRECOGNIZED(-1);

            public static final int IN_ALL_VALUE = 3;
            public static final int IN_AT_LEAST_ONE_VALUE = 1;
            public static final int IN_NONE_VALUE = 4;
            public static final int NOT_IN_AT_LEAST_ONE_VALUE = 2;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<AnalyticsAudienceOperator> internalValueMap = new c();
            private final int value;

            AnalyticsAudienceOperator(int i) {
                this.value = i;
            }

            public static AnalyticsAudienceOperator forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return IN_AT_LEAST_ONE;
                }
                if (i == 2) {
                    return NOT_IN_AT_LEAST_ONE;
                }
                if (i == 3) {
                    return IN_ALL;
                }
                if (i != 4) {
                    return null;
                }
                return IN_NONE;
            }

            public static Internal.EnumLiteMap<AnalyticsAudienceOperator> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static AnalyticsAudienceOperator valueOf(int i) {
                return forNumber(i);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AnalyticsAudienceCondition, Builder> implements AnalyticsAudienceConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(AnalyticsAudienceCondition.f16245d);
            }
        }

        static {
            f16245d.l();
        }

        private AnalyticsAudienceCondition() {
        }

        public static Parser<AnalyticsAudienceCondition> p() {
            return f16245d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            d();
            if (this.f16248g != AnalyticsAudienceOperator.UNKNOWN.getNumber()) {
                codedOutputStream.e(1, this.f16248g);
            }
            for (int i = 0; i < this.f16249h.size(); i++) {
                codedOutputStream.b(2, this.f16249h.get(i));
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                codedOutputStream.e(3, this.i.getLong(i2));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16248g != AnalyticsAudienceOperator.UNKNOWN.getNumber() ? CodedOutputStream.a(1, this.f16248g) + 0 : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f16249h.size(); i3++) {
                i2 += CodedOutputStream.a(this.f16249h.get(i3));
            }
            int size = a2 + i2 + (o().size() * 1);
            int i4 = 0;
            for (int i5 = 0; i5 < this.i.size(); i5++) {
                i4 += CodedOutputStream.b(this.i.getLong(i5));
            }
            int size2 = size + i4 + (n().size() * 1);
            this.f18584c = size2;
            return size2;
        }

        public List<Long> n() {
            return this.i;
        }

        public List<String> o() {
            return this.f16249h;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AnalyticsAudienceCondition();
                case 2:
                    return f16245d;
                case 3:
                    this.f16249h.L();
                    this.i.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AnalyticsAudienceCondition analyticsAudienceCondition = (AnalyticsAudienceCondition) obj2;
                    this.f16248g = visitor.a(this.f16248g != 0, this.f16248g, analyticsAudienceCondition.f16248g != 0, analyticsAudienceCondition.f16248g);
                    this.f16249h = visitor.a(this.f16249h, analyticsAudienceCondition.f16249h);
                    this.i = visitor.a(this.i, analyticsAudienceCondition.i);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f16247f |= analyticsAudienceCondition.f16247f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f16248g = codedInputStream.f();
                                } else if (x == 18) {
                                    String w = codedInputStream.w();
                                    if (!this.f16249h.M()) {
                                        this.f16249h = GeneratedMessageLite.a(this.f16249h);
                                    }
                                    this.f16249h.add(w);
                                } else if (x == 24) {
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.g(codedInputStream.k());
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    int d2 = codedInputStream.d(codedInputStream.o());
                                    if (!this.i.M() && codedInputStream.a() > 0) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    while (codedInputStream.a() > 0) {
                                        this.i.g(codedInputStream.k());
                                    }
                                    codedInputStream.c(d2);
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
                    if (f16246e == null) {
                        synchronized (AnalyticsAudienceCondition.class) {
                            if (f16246e == null) {
                                f16246e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16245d);
                            }
                        }
                    }
                    return f16246e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16245d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class AnalyticsUserPropertyCondition extends GeneratedMessageLite<AnalyticsUserPropertyCondition, Builder> implements AnalyticsUserPropertyConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final AnalyticsUserPropertyCondition f16250d = new AnalyticsUserPropertyCondition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<AnalyticsUserPropertyCondition> f16251e;

        /* renamed from: f, reason: collision with root package name */
        private int f16252f;

        /* renamed from: g, reason: collision with root package name */
        private int f16253g;
        private long i;

        /* renamed from: h, reason: collision with root package name */
        private String f16254h = "";
        private String j = "";
        private Internal.ProtobufList<String> k = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AnalyticsUserPropertyCondition, Builder> implements AnalyticsUserPropertyConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(AnalyticsUserPropertyCondition.f16250d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum UserPropertyOperator implements Internal.EnumLite {
            UNKNOWN(0),
            NUMERIC_LESS_THAN(1),
            NUMERIC_LESS_EQUAL(2),
            NUMERIC_EQUAL(3),
            NUMERIC_NOT_EQUAL(10),
            NUMERIC_GREATER_THAN(4),
            NUMERIC_GREATER_EQUAL(5),
            STRING_CONTAINS(6),
            STRING_DOES_NOT_CONTAIN(7),
            STRING_EXACTLY_MATCHES(8),
            STRING_CONTAINS_REGEX(9),
            UNRECOGNIZED(-1);

            public static final int NUMERIC_EQUAL_VALUE = 3;
            public static final int NUMERIC_GREATER_EQUAL_VALUE = 5;
            public static final int NUMERIC_GREATER_THAN_VALUE = 4;
            public static final int NUMERIC_LESS_EQUAL_VALUE = 2;
            public static final int NUMERIC_LESS_THAN_VALUE = 1;
            public static final int NUMERIC_NOT_EQUAL_VALUE = 10;
            public static final int STRING_CONTAINS_REGEX_VALUE = 9;
            public static final int STRING_CONTAINS_VALUE = 6;
            public static final int STRING_DOES_NOT_CONTAIN_VALUE = 7;
            public static final int STRING_EXACTLY_MATCHES_VALUE = 8;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<UserPropertyOperator> internalValueMap = new d();
            private final int value;

            UserPropertyOperator(int i) {
                this.value = i;
            }

            public static UserPropertyOperator forNumber(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return NUMERIC_LESS_THAN;
                    case 2:
                        return NUMERIC_LESS_EQUAL;
                    case 3:
                        return NUMERIC_EQUAL;
                    case 4:
                        return NUMERIC_GREATER_THAN;
                    case 5:
                        return NUMERIC_GREATER_EQUAL;
                    case 6:
                        return STRING_CONTAINS;
                    case 7:
                        return STRING_DOES_NOT_CONTAIN;
                    case 8:
                        return STRING_EXACTLY_MATCHES;
                    case 9:
                        return STRING_CONTAINS_REGEX;
                    case 10:
                        return NUMERIC_NOT_EQUAL;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<UserPropertyOperator> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static UserPropertyOperator valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f16250d.l();
        }

        private AnalyticsUserPropertyCondition() {
        }

        public static Parser<AnalyticsUserPropertyCondition> q() {
            return f16250d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16253g != UserPropertyOperator.UNKNOWN.getNumber()) {
                codedOutputStream.e(1, this.f16253g);
            }
            if (!this.j.isEmpty()) {
                codedOutputStream.b(2, o());
            }
            if (!this.f16254h.isEmpty()) {
                codedOutputStream.b(3, n());
            }
            long j = this.i;
            if (j != 0) {
                codedOutputStream.e(4, j);
            }
            for (int i = 0; i < this.k.size(); i++) {
                codedOutputStream.b(5, this.k.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16253g != UserPropertyOperator.UNKNOWN.getNumber() ? CodedOutputStream.a(1, this.f16253g) + 0 : 0;
            if (!this.j.isEmpty()) {
                a2 += CodedOutputStream.a(2, o());
            }
            if (!this.f16254h.isEmpty()) {
                a2 += CodedOutputStream.a(3, n());
            }
            long j = this.i;
            if (j != 0) {
                a2 += CodedOutputStream.b(4, j);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                i2 += CodedOutputStream.a(this.k.get(i3));
            }
            int size = a2 + i2 + (p().size() * 1);
            this.f18584c = size;
            return size;
        }

        public String n() {
            return this.f16254h;
        }

        @Deprecated
        public String o() {
            return this.j;
        }

        public List<String> p() {
            return this.k;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            b bVar = null;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AnalyticsUserPropertyCondition();
                case 2:
                    return f16250d;
                case 3:
                    this.k.L();
                    return null;
                case 4:
                    return new Builder(bVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AnalyticsUserPropertyCondition analyticsUserPropertyCondition = (AnalyticsUserPropertyCondition) obj2;
                    this.f16253g = visitor.a(this.f16253g != 0, this.f16253g, analyticsUserPropertyCondition.f16253g != 0, analyticsUserPropertyCondition.f16253g);
                    this.f16254h = visitor.a(!this.f16254h.isEmpty(), this.f16254h, !analyticsUserPropertyCondition.f16254h.isEmpty(), analyticsUserPropertyCondition.f16254h);
                    this.i = visitor.a(this.i != 0, this.i, analyticsUserPropertyCondition.i != 0, analyticsUserPropertyCondition.i);
                    this.j = visitor.a(!this.j.isEmpty(), this.j, !analyticsUserPropertyCondition.j.isEmpty(), analyticsUserPropertyCondition.j);
                    this.k = visitor.a(this.k, analyticsUserPropertyCondition.k);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f16252f |= analyticsUserPropertyCondition.f16252f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f16253g = codedInputStream.f();
                                } else if (x == 18) {
                                    this.j = codedInputStream.w();
                                } else if (x == 26) {
                                    this.f16254h = codedInputStream.w();
                                } else if (x == 32) {
                                    this.i = codedInputStream.k();
                                } else if (x != 42) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    String w = codedInputStream.w();
                                    if (!this.k.M()) {
                                        this.k = GeneratedMessageLite.a(this.k);
                                    }
                                    this.k.add(w);
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
                    if (f16251e == null) {
                        synchronized (AnalyticsUserPropertyCondition.class) {
                            if (f16251e == null) {
                                f16251e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16250d);
                            }
                        }
                    }
                    return f16251e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16250d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Condition extends GeneratedMessageLite<Condition, Builder> implements ConditionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Condition f16263d = new Condition();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Condition> f16264e;

        /* renamed from: f, reason: collision with root package name */
        private int f16265f = 0;

        /* renamed from: g, reason: collision with root package name */
        private Object f16266g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Condition, Builder> implements ConditionOrBuilder {
            /* synthetic */ Builder(b bVar) {
                this();
            }

            private Builder() {
                super(Condition.f16263d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum ConditionCase implements Internal.EnumLite {
            AND(1),
            OR(2),
            NOT(3),
            ALWAYS_TRUE(16),
            ALWAYS_FALSE(17),
            TIME(4),
            APP_VERSION(5),
            APP_ID(6),
            ANALYTICS_AUDIENCES(7),
            LANGUAGES(8),
            COUNTRIES(9),
            OS_TYPE(10),
            ANALYTICS_USER_PROPERTY(12),
            TOPIC(13),
            PERCENT(14),
            PREDICTIONS(15),
            ABT_EXPERIMENT(18),
            FIREBASE_FUNCTION(19),
            CONDITION_NOT_SET(0);

            private final int value;

            ConditionCase(int i) {
                this.value = i;
            }

            public static ConditionCase forNumber(int i) {
                switch (i) {
                    case 0:
                        return CONDITION_NOT_SET;
                    case 1:
                        return AND;
                    case 2:
                        return OR;
                    case 3:
                        return NOT;
                    case 4:
                        return TIME;
                    case 5:
                        return APP_VERSION;
                    case 6:
                        return APP_ID;
                    case 7:
                        return ANALYTICS_AUDIENCES;
                    case 8:
                        return LANGUAGES;
                    case 9:
                        return COUNTRIES;
                    case 10:
                        return OS_TYPE;
                    case 11:
                    default:
                        return null;
                    case 12:
                        return ANALYTICS_USER_PROPERTY;
                    case 13:
                        return TOPIC;
                    case 14:
                        return PERCENT;
                    case 15:
                        return PREDICTIONS;
                    case 16:
                        return ALWAYS_TRUE;
                    case 17:
                        return ALWAYS_FALSE;
                    case 18:
                        return ABT_EXPERIMENT;
                    case 19:
                        return FIREBASE_FUNCTION;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ConditionCase valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f16263d.l();
        }

        private Condition() {
        }

        public static Condition o() {
            return f16263d;
        }

        public static Parser<Condition> p() {
            return f16263d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f16265f == 1) {
                codedOutputStream.c(1, (AndCondition) this.f16266g);
            }
            if (this.f16265f == 2) {
                codedOutputStream.c(2, (OrCondition) this.f16266g);
            }
            if (this.f16265f == 3) {
                codedOutputStream.c(3, (NotCondition) this.f16266g);
            }
            if (this.f16265f == 4) {
                codedOutputStream.c(4, (DateTimeCondition) this.f16266g);
            }
            if (this.f16265f == 5) {
                codedOutputStream.c(5, (AppVersionCondition) this.f16266g);
            }
            if (this.f16265f == 6) {
                codedOutputStream.c(6, (FirebaseAppIdCondition) this.f16266g);
            }
            if (this.f16265f == 7) {
                codedOutputStream.c(7, (AnalyticsAudienceCondition) this.f16266g);
            }
            if (this.f16265f == 8) {
                codedOutputStream.c(8, (DeviceLanguageCondition) this.f16266g);
            }
            if (this.f16265f == 9) {
                codedOutputStream.c(9, (DeviceCountryCondition) this.f16266g);
            }
            if (this.f16265f == 10) {
                codedOutputStream.c(10, (OsTypeCondition) this.f16266g);
            }
            if (this.f16265f == 12) {
                codedOutputStream.c(12, (AnalyticsUserPropertyCondition) this.f16266g);
            }
            if (this.f16265f == 13) {
                codedOutputStream.c(13, (TopicCondition) this.f16266g);
            }
            if (this.f16265f == 14) {
                codedOutputStream.c(14, (PercentCondition) this.f16266g);
            }
            if (this.f16265f == 15) {
                codedOutputStream.c(15, (PredictionsCondition) this.f16266g);
            }
            if (this.f16265f == 16) {
                codedOutputStream.c(16, (TrueCondition) this.f16266g);
            }
            if (this.f16265f == 17) {
                codedOutputStream.c(17, (FalseCondition) this.f16266g);
            }
            if (this.f16265f == 18) {
                codedOutputStream.c(18, (AbtExperimentCondition) this.f16266g);
            }
            if (this.f16265f == 19) {
                codedOutputStream.c(19, (FunctionCondition) this.f16266g);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16265f == 1 ? 0 + CodedOutputStream.a(1, (AndCondition) this.f16266g) : 0;
            if (this.f16265f == 2) {
                a2 += CodedOutputStream.a(2, (OrCondition) this.f16266g);
            }
            if (this.f16265f == 3) {
                a2 += CodedOutputStream.a(3, (NotCondition) this.f16266g);
            }
            if (this.f16265f == 4) {
                a2 += CodedOutputStream.a(4, (DateTimeCondition) this.f16266g);
            }
            if (this.f16265f == 5) {
                a2 += CodedOutputStream.a(5, (AppVersionCondition) this.f16266g);
            }
            if (this.f16265f == 6) {
                a2 += CodedOutputStream.a(6, (FirebaseAppIdCondition) this.f16266g);
            }
            if (this.f16265f == 7) {
                a2 += CodedOutputStream.a(7, (AnalyticsAudienceCondition) this.f16266g);
            }
            if (this.f16265f == 8) {
                a2 += CodedOutputStream.a(8, (DeviceLanguageCondition) this.f16266g);
            }
            if (this.f16265f == 9) {
                a2 += CodedOutputStream.a(9, (DeviceCountryCondition) this.f16266g);
            }
            if (this.f16265f == 10) {
                a2 += CodedOutputStream.a(10, (OsTypeCondition) this.f16266g);
            }
            if (this.f16265f == 12) {
                a2 += CodedOutputStream.a(12, (AnalyticsUserPropertyCondition) this.f16266g);
            }
            if (this.f16265f == 13) {
                a2 += CodedOutputStream.a(13, (TopicCondition) this.f16266g);
            }
            if (this.f16265f == 14) {
                a2 += CodedOutputStream.a(14, (PercentCondition) this.f16266g);
            }
            if (this.f16265f == 15) {
                a2 += CodedOutputStream.a(15, (PredictionsCondition) this.f16266g);
            }
            if (this.f16265f == 16) {
                a2 += CodedOutputStream.a(16, (TrueCondition) this.f16266g);
            }
            if (this.f16265f == 17) {
                a2 += CodedOutputStream.a(17, (FalseCondition) this.f16266g);
            }
            if (this.f16265f == 18) {
                a2 += CodedOutputStream.a(18, (AbtExperimentCondition) this.f16266g);
            }
            if (this.f16265f == 19) {
                a2 += CodedOutputStream.a(19, (FunctionCondition) this.f16266g);
            }
            this.f18584c = a2;
            return a2;
        }

        public ConditionCase n() {
            return ConditionCase.forNumber(this.f16265f);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0050. Please report as an issue. */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            switch (b.f16318a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Condition();
                case 2:
                    return f16263d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Condition condition = (Condition) obj2;
                    switch (b.f16319b[condition.n().ordinal()]) {
                        case 1:
                            this.f16266g = visitor.e(this.f16265f == 1, this.f16266g, condition.f16266g);
                            break;
                        case 2:
                            this.f16266g = visitor.e(this.f16265f == 2, this.f16266g, condition.f16266g);
                            break;
                        case 3:
                            this.f16266g = visitor.e(this.f16265f == 3, this.f16266g, condition.f16266g);
                            break;
                        case 4:
                            this.f16266g = visitor.e(this.f16265f == 16, this.f16266g, condition.f16266g);
                            break;
                        case 5:
                            this.f16266g = visitor.e(this.f16265f == 17, this.f16266g, condition.f16266g);
                            break;
                        case 6:
                            this.f16266g = visitor.e(this.f16265f == 4, this.f16266g, condition.f16266g);
                            break;
                        case 7:
                            this.f16266g = visitor.e(this.f16265f == 5, this.f16266g, condition.f16266g);
                            break;
                        case 8:
                            this.f16266g = visitor.e(this.f16265f == 6, this.f16266g, condition.f16266g);
                            break;
                        case 9:
                            this.f16266g = visitor.e(this.f16265f == 7, this.f16266g, condition.f16266g);
                            break;
                        case 10:
                            this.f16266g = visitor.e(this.f16265f == 8, this.f16266g, condition.f16266g);
                            break;
                        case 11:
                            this.f16266g = visitor.e(this.f16265f == 9, this.f16266g, condition.f16266g);
                            break;
                        case 12:
                            this.f16266g = visitor.e(this.f16265f == 10, this.f16266g, condition.f16266g);
                            break;
                        case 13:
                            this.f16266g = visitor.e(this.f16265f == 12, this.f16266g, condition.f16266g);
                            break;
                        case 14:
                            this.f16266g = visitor.e(this.f16265f == 13, this.f16266g, condition.f16266g);
                            break;
                        case 15:
                            this.f16266g = visitor.e(this.f16265f == 14, this.f16266g, condition.f16266g);
                            break;
                        case 16:
                            this.f16266g = visitor.e(this.f16265f == 15, this.f16266g, condition.f16266g);
                            break;
                        case 17:
                            this.f16266g = visitor.e(this.f16265f == 18, this.f16266g, condition.f16266g);
                            break;
                        case 18:
                            this.f16266g = visitor.e(this.f16265f == 19, this.f16266g, condition.f16266g);
                            break;
                        case 19:
                            visitor.a(this.f16265f != 0);
                            break;
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a && (i = condition.f16265f) != 0) {
                        this.f16265f = i;
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
                                switch (x) {
                                    case 0:
                                        z = true;
                                    case 10:
                                        AndCondition.Builder b2 = this.f16265f == 1 ? ((AndCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(AndCondition.n(), extensionRegistryLite);
                                        if (b2 != null) {
                                            b2.b((AndCondition.Builder) this.f16266g);
                                            this.f16266g = b2.T();
                                        }
                                        this.f16265f = 1;
                                    case 18:
                                        OrCondition.Builder b3 = this.f16265f == 2 ? ((OrCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(OrCondition.n(), extensionRegistryLite);
                                        if (b3 != null) {
                                            b3.b((OrCondition.Builder) this.f16266g);
                                            this.f16266g = b3.T();
                                        }
                                        this.f16265f = 2;
                                    case 26:
                                        NotCondition.Builder b4 = this.f16265f == 3 ? ((NotCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(NotCondition.o(), extensionRegistryLite);
                                        if (b4 != null) {
                                            b4.b((NotCondition.Builder) this.f16266g);
                                            this.f16266g = b4.T();
                                        }
                                        this.f16265f = 3;
                                    case 34:
                                        DateTimeCondition.Builder b5 = this.f16265f == 4 ? ((DateTimeCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(DateTimeCondition.o(), extensionRegistryLite);
                                        if (b5 != null) {
                                            b5.b((DateTimeCondition.Builder) this.f16266g);
                                            this.f16266g = b5.T();
                                        }
                                        this.f16265f = 4;
                                    case 42:
                                        AppVersionCondition.Builder b6 = this.f16265f == 5 ? ((AppVersionCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(AppVersionCondition.p(), extensionRegistryLite);
                                        if (b6 != null) {
                                            b6.b((AppVersionCondition.Builder) this.f16266g);
                                            this.f16266g = b6.T();
                                        }
                                        this.f16265f = 5;
                                    case 50:
                                        FirebaseAppIdCondition.Builder b7 = this.f16265f == 6 ? ((FirebaseAppIdCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(FirebaseAppIdCondition.o(), extensionRegistryLite);
                                        if (b7 != null) {
                                            b7.b((FirebaseAppIdCondition.Builder) this.f16266g);
                                            this.f16266g = b7.T();
                                        }
                                        this.f16265f = 6;
                                    case 58:
                                        AnalyticsAudienceCondition.Builder b8 = this.f16265f == 7 ? ((AnalyticsAudienceCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(AnalyticsAudienceCondition.p(), extensionRegistryLite);
                                        if (b8 != null) {
                                            b8.b((AnalyticsAudienceCondition.Builder) this.f16266g);
                                            this.f16266g = b8.T();
                                        }
                                        this.f16265f = 7;
                                    case 66:
                                        DeviceLanguageCondition.Builder b9 = this.f16265f == 8 ? ((DeviceLanguageCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(DeviceLanguageCondition.o(), extensionRegistryLite);
                                        if (b9 != null) {
                                            b9.b((DeviceLanguageCondition.Builder) this.f16266g);
                                            this.f16266g = b9.T();
                                        }
                                        this.f16265f = 8;
                                    case 74:
                                        DeviceCountryCondition.Builder b10 = this.f16265f == 9 ? ((DeviceCountryCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(DeviceCountryCondition.o(), extensionRegistryLite);
                                        if (b10 != null) {
                                            b10.b((DeviceCountryCondition.Builder) this.f16266g);
                                            this.f16266g = b10.T();
                                        }
                                        this.f16265f = 9;
                                    case 82:
                                        OsTypeCondition.Builder b11 = this.f16265f == 10 ? ((OsTypeCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(OsTypeCondition.n(), extensionRegistryLite);
                                        if (b11 != null) {
                                            b11.b((OsTypeCondition.Builder) this.f16266g);
                                            this.f16266g = b11.T();
                                        }
                                        this.f16265f = 10;
                                    case 98:
                                        AnalyticsUserPropertyCondition.Builder b12 = this.f16265f == 12 ? ((AnalyticsUserPropertyCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(AnalyticsUserPropertyCondition.q(), extensionRegistryLite);
                                        if (b12 != null) {
                                            b12.b((AnalyticsUserPropertyCondition.Builder) this.f16266g);
                                            this.f16266g = b12.T();
                                        }
                                        this.f16265f = 12;
                                    case 106:
                                        TopicCondition.Builder b13 = this.f16265f == 13 ? ((TopicCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(TopicCondition.o(), extensionRegistryLite);
                                        if (b13 != null) {
                                            b13.b((TopicCondition.Builder) this.f16266g);
                                            this.f16266g = b13.T();
                                        }
                                        this.f16265f = 13;
                                    case 114:
                                        PercentCondition.Builder b14 = this.f16265f == 14 ? ((PercentCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(PercentCondition.o(), extensionRegistryLite);
                                        if (b14 != null) {
                                            b14.b((PercentCondition.Builder) this.f16266g);
                                            this.f16266g = b14.T();
                                        }
                                        this.f16265f = 14;
                                    case 122:
                                        PredictionsCondition.Builder b15 = this.f16265f == 15 ? ((PredictionsCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(PredictionsCondition.n(), extensionRegistryLite);
                                        if (b15 != null) {
                                            b15.b((PredictionsCondition.Builder) this.f16266g);
                                            this.f16266g = b15.T();
                                        }
                                        this.f16265f = 15;
                                    case 130:
                                        TrueCondition.Builder b16 = this.f16265f == 16 ? ((TrueCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(TrueCondition.n(), extensionRegistryLite);
                                        if (b16 != null) {
                                            b16.b((TrueCondition.Builder) this.f16266g);
                                            this.f16266g = b16.T();
                                        }
                                        this.f16265f = 16;
                                    case 138:
                                        FalseCondition.Builder b17 = this.f16265f == 17 ? ((FalseCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(FalseCondition.n(), extensionRegistryLite);
                                        if (b17 != null) {
                                            b17.b((FalseCondition.Builder) this.f16266g);
                                            this.f16266g = b17.T();
                                        }
                                        this.f16265f = 17;
                                    case 146:
                                        AbtExperimentCondition.Builder b18 = this.f16265f == 18 ? ((AbtExperimentCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(AbtExperimentCondition.o(), extensionRegistryLite);
                                        if (b18 != null) {
                                            b18.b((AbtExperimentCondition.Builder) this.f16266g);
                                            this.f16266g = b18.T();
                                        }
                                        this.f16265f = 18;
                                    case 154:
                                        FunctionCondition.Builder b19 = this.f16265f == 19 ? ((FunctionCondition) this.f16266g).b() : null;
                                        this.f16266g = codedInputStream.a(FunctionCondition.o(), extensionRegistryLite);
                                        if (b19 != null) {
                                            b19.b((FunctionCondition.Builder) this.f16266g);
                                            this.f16266g = b19.T();
                                        }
                                        this.f16265f = 19;
                                    default:
                                        if (!codedInputStream.f(x)) {
                                            z = true;
                                        }
                                }
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
                    if (f16264e == null) {
                        synchronized (Condition.class) {
                            if (f16264e == null) {
                                f16264e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16263d);
                            }
                        }
                    }
                    return f16264e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16263d;
        }
    }
}

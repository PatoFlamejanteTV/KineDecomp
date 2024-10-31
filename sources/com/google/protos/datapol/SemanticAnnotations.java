package com.google.protos.datapol;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import com.google.protos.datapol.RetentionAnnotations;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class SemanticAnnotations {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, SemanticType> f18808a = GeneratedMessageLite.a(DescriptorProtos.FieldOptions.q(), SemanticType.ST_NOT_SPECIFIED, (MessageLite) null, SemanticType.internalGetValueMap(), 40075780, WireFormat.FieldType.ENUM, SemanticType.class);

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Qualifier> f18809b = GeneratedMessageLite.a(DescriptorProtos.FieldOptions.q(), Qualifier.n(), Qualifier.n(), (Internal.EnumLiteMap<?>) null, 40270992, WireFormat.FieldType.MESSAGE, Qualifier.class);

    /* renamed from: c, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, LocationQualifier> f18810c = GeneratedMessageLite.a(DescriptorProtos.FieldOptions.q(), LocationQualifier.n(), LocationQualifier.n(), (Internal.EnumLiteMap<?>) null, 69646961, WireFormat.FieldType.MESSAGE, LocationQualifier.class);

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, FieldDetails> f18811d = GeneratedMessageLite.a(DescriptorProtos.FieldOptions.q(), FieldDetails.n(), FieldDetails.n(), (Internal.EnumLiteMap<?>) null, 40093572, WireFormat.FieldType.MESSAGE, FieldDetails.class);

    /* renamed from: e, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, DataFormat> f18812e = GeneratedMessageLite.a(DescriptorProtos.FieldOptions.q(), DataFormat.DF_NONE, (MessageLite) null, DataFormat.internalGetValueMap(), 40221563, WireFormat.FieldType.ENUM, DataFormat.class);

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, List<RetentionAnnotations.RetentionSpec>> f18813f = GeneratedMessageLite.a(DescriptorProtos.FieldOptions.q(), (MessageLite) RetentionAnnotations.RetentionSpec.o(), (Internal.EnumLiteMap<?>) null, 40223876, WireFormat.FieldType.MESSAGE, false, RetentionAnnotations.RetentionSpec.class);

    /* renamed from: g, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, SemanticType> f18814g = GeneratedMessageLite.a(DescriptorProtos.MessageOptions.q(), SemanticType.ST_NOT_SPECIFIED, (MessageLite) null, SemanticType.internalGetValueMap(), 41149386, WireFormat.FieldType.ENUM, SemanticType.class);

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, Qualifier> f18815h = GeneratedMessageLite.a(DescriptorProtos.MessageOptions.q(), Qualifier.n(), Qualifier.n(), (Internal.EnumLiteMap<?>) null, 41551199, WireFormat.FieldType.MESSAGE, Qualifier.class);
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, LocationQualifier> i = GeneratedMessageLite.a(DescriptorProtos.MessageOptions.q(), LocationQualifier.n(), LocationQualifier.n(), (Internal.EnumLiteMap<?>) null, 69646961, WireFormat.FieldType.MESSAGE, LocationQualifier.class);
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, MessageDetails> j = GeneratedMessageLite.a(DescriptorProtos.MessageOptions.q(), MessageDetails.n(), MessageDetails.n(), (Internal.EnumLiteMap<?>) null, 41744383, WireFormat.FieldType.MESSAGE, MessageDetails.class);
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, List<RetentionAnnotations.RetentionSpec>> k = GeneratedMessageLite.a(DescriptorProtos.MessageOptions.q(), (MessageLite) RetentionAnnotations.RetentionSpec.o(), (Internal.EnumLiteMap<?>) null, 41909987, WireFormat.FieldType.MESSAGE, false, RetentionAnnotations.RetentionSpec.class);
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FileOptions, Boolean> l = GeneratedMessageLite.a(DescriptorProtos.FileOptions.r(), false, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 43601160, WireFormat.FieldType.BOOL, Boolean.class);
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FileOptions, String> m = GeneratedMessageLite.a(DescriptorProtos.FileOptions.r(), "", (MessageLite) null, (Internal.EnumLiteMap<?>) null, 71304954, WireFormat.FieldType.STRING, String.class);

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum DataFormat implements Internal.EnumLite {
        DF_NONE(0),
        DF_HTTPHEADER(1),
        DF_COOKIE(2),
        DF_URL(3),
        DF_CGI_ARGS(4),
        DF_HOST_ORDER(5),
        DF_BYTE_SWAPPED(6),
        DF_LOGGING_ELEMENT_TYPE_ID(7);

        public static final int DF_BYTE_SWAPPED_VALUE = 6;
        public static final int DF_CGI_ARGS_VALUE = 4;
        public static final int DF_COOKIE_VALUE = 2;
        public static final int DF_HOST_ORDER_VALUE = 5;
        public static final int DF_HTTPHEADER_VALUE = 1;
        public static final int DF_LOGGING_ELEMENT_TYPE_ID_VALUE = 7;
        public static final int DF_NONE_VALUE = 0;
        public static final int DF_URL_VALUE = 3;
        private static final Internal.EnumLiteMap<DataFormat> internalValueMap = new d();
        private final int value;

        DataFormat(int i) {
            this.value = i;
        }

        public static DataFormat forNumber(int i) {
            switch (i) {
                case 0:
                    return DF_NONE;
                case 1:
                    return DF_HTTPHEADER;
                case 2:
                    return DF_COOKIE;
                case 3:
                    return DF_URL;
                case 4:
                    return DF_CGI_ARGS;
                case 5:
                    return DF_HOST_ORDER;
                case 6:
                    return DF_BYTE_SWAPPED;
                case 7:
                    return DF_LOGGING_ELEMENT_TYPE_ID;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<DataFormat> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DataFormat valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface FieldDetailsOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface LocationQualifierOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface MessageDetailsOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface QualifierOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum SemanticType implements Internal.EnumLite {
        ST_NOT_SPECIFIED(0),
        ST_NOT_REQUIRED(ST_NOT_REQUIRED_VALUE),
        ST_PSEUDONYMOUS_ID(1000),
        ST_ZWIEBACK_ID(1001),
        ST_PREF_ID(1002),
        ST_BISCOTTI_ID(1003),
        ST_ANALYTICS_ID(1004),
        ST_MANDELBREAD_ID(ST_MANDELBREAD_ID_VALUE),
        ST_ANDROID_LOGGING_ID2(1006),
        ST_ACSA_ID(1007),
        ST_HERREVAD_ID(1008),
        ST_IDENTIFYING_ID(ST_IDENTIFYING_ID_VALUE),
        ST_EMAIL_ID(ST_EMAIL_ID_VALUE),
        ST_NAME(ST_NAME_VALUE),
        ST_PHONE_NUMBER(ST_PHONE_NUMBER_VALUE),
        ST_GAIA_ID(ST_GAIA_ID_VALUE),
        ST_USERNAME(ST_USERNAME_VALUE),
        ST_GSERVICES_ANDROID_ID(ST_GSERVICES_ANDROID_ID_VALUE),
        ST_ARES_ID(ST_ARES_ID_VALUE),
        ST_MEDICAL_RECORD_NUMBER(ST_MEDICAL_RECORD_NUMBER_VALUE),
        ST_SPII_ID(ST_SPII_ID_VALUE),
        ST_GOVERNMENT_ID_NUMBER(ST_GOVERNMENT_ID_NUMBER_VALUE),
        ST_HEALTHCARE_INFO(ST_HEALTHCARE_INFO_VALUE),
        ST_SENSITIVE_BACKGROUND_INFO(ST_SENSITIVE_BACKGROUND_INFO_VALUE),
        ST_CARDHOLDER_DATA(ST_CARDHOLDER_DATA_VALUE),
        ST_CHD_PAN(ST_CHD_PAN_VALUE),
        ST_CHD_INFO(ST_CHD_INFO_VALUE),
        ST_PAYMENTS_INFO(ST_PAYMENTS_INFO_VALUE),
        ST_CRITICAL_PAYMENT_INFO(ST_CRITICAL_PAYMENT_INFO_VALUE),
        ST_PAYMENT_ID(ST_PAYMENT_ID_VALUE),
        ST_LIMITED_USE_PAYMENTS_INFO(ST_LIMITED_USE_PAYMENTS_INFO_VALUE),
        ST_PAYMENTS_TRANSACTION_INFO(ST_PAYMENTS_TRANSACTION_INFO_VALUE),
        ST_NETWORK_ENDPOINT(ST_NETWORK_ENDPOINT_VALUE),
        ST_IP_ADDRESS(ST_IP_ADDRESS_VALUE),
        ST_HARDWARE_ID(ST_HARDWARE_ID_VALUE),
        ST_ANDROID_LOGGING_ID(ST_ANDROID_LOGGING_ID_VALUE),
        ST_SOFTWARE_ID(ST_SOFTWARE_ID_VALUE),
        ST_USER_AGENT(ST_USER_AGENT_VALUE),
        ST_ANONYMOUS_DATA(ST_ANONYMOUS_DATA_VALUE),
        ST_DEMOGRAPHIC_INFO(ST_DEMOGRAPHIC_INFO_VALUE),
        ST_LOCATION(ST_LOCATION_VALUE),
        ST_PRECISE_LOCATION(ST_PRECISE_LOCATION_VALUE),
        ST_COARSE_LOCATION(ST_COARSE_LOCATION_VALUE),
        ST_GOOGLE_RELATIONSHIP_ID(ST_GOOGLE_RELATIONSHIP_ID_VALUE),
        ST_CUSTOMER_ID(ST_CUSTOMER_ID_VALUE),
        ST_PARTNER_ID(ST_PARTNER_ID_VALUE),
        ST_PUBLISHER_ID(ST_PUBLISHER_ID_VALUE),
        ST_USER_CONTENT(ST_USER_CONTENT_VALUE),
        ST_USER_QUERY(ST_USER_QUERY_VALUE),
        ST_THIRD_PARTY_DATA(ST_THIRD_PARTY_DATA_VALUE),
        ST_TIMESTAMP(ST_TIMESTAMP_VALUE),
        ST_SENSITIVE_TIMESTAMP(ST_SENSITIVE_TIMESTAMP_VALUE),
        ST_SESSION_ID(ST_SESSION_ID_VALUE),
        ST_PERSONAL_DATA(ST_PERSONAL_DATA_VALUE),
        ST_AVOCADO_ID(ST_AVOCADO_ID_VALUE),
        ST_SECURITY_MATERIAL(ST_SECURITY_MATERIAL_VALUE),
        ST_SECURITY_KEY(ST_SECURITY_KEY_VALUE),
        ST_ACCOUNT_CREDENTIAL(ST_ACCOUNT_CREDENTIAL_VALUE),
        ST_PAYMENTS_PCI_SAD(ST_PAYMENTS_PCI_SAD_VALUE),
        ST_CONTENT_DEPENDENT(ST_CONTENT_DEPENDENT_VALUE),
        ST_DEBUG_INFO(ST_DEBUG_INFO_VALUE),
        ST_KEY_VALUE_PAIR(ST_KEY_VALUE_PAIR_VALUE),
        ST_KEY(ST_KEY_VALUE),
        ST_VALUE(ST_VALUE_VALUE),
        ST_REFERER_URL(ST_REFERER_URL_VALUE);

        public static final int ST_ACCOUNT_CREDENTIAL_VALUE = 2602;
        public static final int ST_ACSA_ID_VALUE = 1007;
        public static final int ST_ANALYTICS_ID_VALUE = 1004;
        public static final int ST_ANDROID_LOGGING_ID2_VALUE = 1006;
        public static final int ST_ANDROID_LOGGING_ID_VALUE = 1401;
        public static final int ST_ANONYMOUS_DATA_VALUE = 1600;
        public static final int ST_ARES_ID_VALUE = 1108;
        public static final int ST_AVOCADO_ID_VALUE = 2500;
        public static final int ST_BISCOTTI_ID_VALUE = 1003;
        public static final int ST_CARDHOLDER_DATA_VALUE = 1202;
        public static final int ST_CHD_INFO_VALUE = 1212;
        public static final int ST_CHD_PAN_VALUE = 1211;
        public static final int ST_COARSE_LOCATION_VALUE = 1702;
        public static final int ST_CONTENT_DEPENDENT_VALUE = 9900;
        public static final int ST_CRITICAL_PAYMENT_INFO_VALUE = 1221;
        public static final int ST_CUSTOMER_ID_VALUE = 1801;
        public static final int ST_DEBUG_INFO_VALUE = 9901;
        public static final int ST_DEMOGRAPHIC_INFO_VALUE = 1601;
        public static final int ST_EMAIL_ID_VALUE = 1102;
        public static final int ST_GAIA_ID_VALUE = 1105;
        public static final int ST_GOOGLE_RELATIONSHIP_ID_VALUE = 1800;
        public static final int ST_GOVERNMENT_ID_NUMBER_VALUE = 1201;
        public static final int ST_GSERVICES_ANDROID_ID_VALUE = 1107;
        public static final int ST_HARDWARE_ID_VALUE = 1400;
        public static final int ST_HEALTHCARE_INFO_VALUE = 1203;
        public static final int ST_HERREVAD_ID_VALUE = 1008;
        public static final int ST_IDENTIFYING_ID_VALUE = 1100;
        public static final int ST_IP_ADDRESS_VALUE = 1301;
        public static final int ST_KEY_VALUE = 9903;
        public static final int ST_KEY_VALUE_PAIR_VALUE = 9902;
        public static final int ST_LIMITED_USE_PAYMENTS_INFO_VALUE = 1223;
        public static final int ST_LOCATION_VALUE = 1700;
        public static final int ST_MANDELBREAD_ID_VALUE = 1005;
        public static final int ST_MEDICAL_RECORD_NUMBER_VALUE = 1109;
        public static final int ST_NAME_VALUE = 1103;
        public static final int ST_NETWORK_ENDPOINT_VALUE = 1300;
        public static final int ST_NOT_REQUIRED_VALUE = 999;
        public static final int ST_NOT_SPECIFIED_VALUE = 0;
        public static final int ST_PARTNER_ID_VALUE = 1802;
        public static final int ST_PAYMENTS_INFO_VALUE = 1220;
        public static final int ST_PAYMENTS_PCI_SAD_VALUE = 2603;
        public static final int ST_PAYMENTS_TRANSACTION_INFO_VALUE = 1240;
        public static final int ST_PAYMENT_ID_VALUE = 1222;
        public static final int ST_PERSONAL_DATA_VALUE = 2400;
        public static final int ST_PHONE_NUMBER_VALUE = 1104;
        public static final int ST_PRECISE_LOCATION_VALUE = 1701;
        public static final int ST_PREF_ID_VALUE = 1002;
        public static final int ST_PSEUDONYMOUS_ID_VALUE = 1000;
        public static final int ST_PUBLISHER_ID_VALUE = 1803;
        public static final int ST_REFERER_URL_VALUE = 9905;
        public static final int ST_SECURITY_KEY_VALUE = 2601;
        public static final int ST_SECURITY_MATERIAL_VALUE = 2600;
        public static final int ST_SENSITIVE_BACKGROUND_INFO_VALUE = 1204;
        public static final int ST_SENSITIVE_TIMESTAMP_VALUE = 2101;
        public static final int ST_SESSION_ID_VALUE = 2300;
        public static final int ST_SOFTWARE_ID_VALUE = 1500;
        public static final int ST_SPII_ID_VALUE = 1200;
        public static final int ST_THIRD_PARTY_DATA_VALUE = 2000;
        public static final int ST_TIMESTAMP_VALUE = 2100;
        public static final int ST_USERNAME_VALUE = 1106;
        public static final int ST_USER_AGENT_VALUE = 1501;
        public static final int ST_USER_CONTENT_VALUE = 1900;
        public static final int ST_USER_QUERY_VALUE = 1901;
        public static final int ST_VALUE_VALUE = 9904;
        public static final int ST_ZWIEBACK_ID_VALUE = 1001;
        private static final Internal.EnumLiteMap<SemanticType> internalValueMap = new g();
        private final int value;

        SemanticType(int i) {
            this.value = i;
        }

        public static SemanticType forNumber(int i) {
            if (i != 0) {
                if (i == 1211) {
                    return ST_CHD_PAN;
                }
                if (i == 1212) {
                    return ST_CHD_INFO;
                }
                if (i == 1300) {
                    return ST_NETWORK_ENDPOINT;
                }
                if (i == 1301) {
                    return ST_IP_ADDRESS;
                }
                if (i == 1400) {
                    return ST_HARDWARE_ID;
                }
                if (i == 1401) {
                    return ST_ANDROID_LOGGING_ID;
                }
                if (i == 1500) {
                    return ST_SOFTWARE_ID;
                }
                if (i == 1501) {
                    return ST_USER_AGENT;
                }
                if (i == 1600) {
                    return ST_ANONYMOUS_DATA;
                }
                if (i != 1601) {
                    switch (i) {
                        case 0:
                            break;
                        case ST_NOT_REQUIRED_VALUE:
                            return ST_NOT_REQUIRED;
                        case 1000:
                            return ST_PSEUDONYMOUS_ID;
                        case 1001:
                            return ST_ZWIEBACK_ID;
                        case 1002:
                            return ST_PREF_ID;
                        case 1003:
                            return ST_BISCOTTI_ID;
                        case 1004:
                            return ST_ANALYTICS_ID;
                        case ST_MANDELBREAD_ID_VALUE:
                            return ST_MANDELBREAD_ID;
                        case 1006:
                            return ST_ANDROID_LOGGING_ID2;
                        case 1007:
                            return ST_ACSA_ID;
                        case 1008:
                            return ST_HERREVAD_ID;
                        case ST_IDENTIFYING_ID_VALUE:
                            return ST_IDENTIFYING_ID;
                        case ST_PAYMENTS_TRANSACTION_INFO_VALUE:
                            return ST_PAYMENTS_TRANSACTION_INFO;
                        case ST_GOOGLE_RELATIONSHIP_ID_VALUE:
                            return ST_GOOGLE_RELATIONSHIP_ID;
                        case ST_CUSTOMER_ID_VALUE:
                            return ST_CUSTOMER_ID;
                        case ST_PARTNER_ID_VALUE:
                            return ST_PARTNER_ID;
                        case ST_PUBLISHER_ID_VALUE:
                            return ST_PUBLISHER_ID;
                        case ST_USER_CONTENT_VALUE:
                            return ST_USER_CONTENT;
                        case ST_USER_QUERY_VALUE:
                            return ST_USER_QUERY;
                        case ST_THIRD_PARTY_DATA_VALUE:
                            return ST_THIRD_PARTY_DATA;
                        case ST_TIMESTAMP_VALUE:
                            return ST_TIMESTAMP;
                        case ST_SENSITIVE_TIMESTAMP_VALUE:
                            return ST_SENSITIVE_TIMESTAMP;
                        case ST_SESSION_ID_VALUE:
                            return ST_SESSION_ID;
                        case ST_PERSONAL_DATA_VALUE:
                            return ST_PERSONAL_DATA;
                        case ST_AVOCADO_ID_VALUE:
                            return ST_AVOCADO_ID;
                        case ST_SECURITY_MATERIAL_VALUE:
                            return ST_SECURITY_MATERIAL;
                        case ST_SECURITY_KEY_VALUE:
                            return ST_SECURITY_KEY;
                        case ST_ACCOUNT_CREDENTIAL_VALUE:
                            return ST_ACCOUNT_CREDENTIAL;
                        case ST_PAYMENTS_PCI_SAD_VALUE:
                            return ST_PAYMENTS_PCI_SAD;
                        case ST_CONTENT_DEPENDENT_VALUE:
                            return ST_CONTENT_DEPENDENT;
                        case ST_DEBUG_INFO_VALUE:
                            return ST_DEBUG_INFO;
                        case ST_KEY_VALUE_PAIR_VALUE:
                            return ST_KEY_VALUE_PAIR;
                        case ST_KEY_VALUE:
                            return ST_KEY;
                        case ST_VALUE_VALUE:
                            return ST_VALUE;
                        case ST_REFERER_URL_VALUE:
                            return ST_REFERER_URL;
                        default:
                            switch (i) {
                                case ST_EMAIL_ID_VALUE:
                                    return ST_EMAIL_ID;
                                case ST_NAME_VALUE:
                                    return ST_NAME;
                                case ST_PHONE_NUMBER_VALUE:
                                    return ST_PHONE_NUMBER;
                                case ST_GAIA_ID_VALUE:
                                    return ST_GAIA_ID;
                                case ST_USERNAME_VALUE:
                                    return ST_USERNAME;
                                case ST_GSERVICES_ANDROID_ID_VALUE:
                                    return ST_GSERVICES_ANDROID_ID;
                                case ST_ARES_ID_VALUE:
                                    return ST_ARES_ID;
                                case ST_MEDICAL_RECORD_NUMBER_VALUE:
                                    return ST_MEDICAL_RECORD_NUMBER;
                                default:
                                    switch (i) {
                                        case ST_SPII_ID_VALUE:
                                            return ST_SPII_ID;
                                        case ST_GOVERNMENT_ID_NUMBER_VALUE:
                                            return ST_GOVERNMENT_ID_NUMBER;
                                        case ST_CARDHOLDER_DATA_VALUE:
                                            return ST_CARDHOLDER_DATA;
                                        case ST_HEALTHCARE_INFO_VALUE:
                                            return ST_HEALTHCARE_INFO;
                                        case ST_SENSITIVE_BACKGROUND_INFO_VALUE:
                                            return ST_SENSITIVE_BACKGROUND_INFO;
                                        default:
                                            switch (i) {
                                                case ST_PAYMENTS_INFO_VALUE:
                                                    return ST_PAYMENTS_INFO;
                                                case ST_CRITICAL_PAYMENT_INFO_VALUE:
                                                    return ST_CRITICAL_PAYMENT_INFO;
                                                case ST_PAYMENT_ID_VALUE:
                                                    return ST_PAYMENT_ID;
                                                case ST_LIMITED_USE_PAYMENTS_INFO_VALUE:
                                                    return ST_LIMITED_USE_PAYMENTS_INFO;
                                                default:
                                                    switch (i) {
                                                        case ST_LOCATION_VALUE:
                                                            return ST_LOCATION;
                                                        case ST_PRECISE_LOCATION_VALUE:
                                                            return ST_PRECISE_LOCATION;
                                                        case ST_COARSE_LOCATION_VALUE:
                                                            return ST_COARSE_LOCATION;
                                                        default:
                                                            return null;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    return ST_DEMOGRAPHIC_INFO;
                }
            }
            return ST_NOT_SPECIFIED;
        }

        public static Internal.EnumLiteMap<SemanticType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static SemanticType valueOf(int i) {
            return forNumber(i);
        }
    }

    private SemanticAnnotations() {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class FieldDetails extends GeneratedMessageLite<FieldDetails, Builder> implements FieldDetailsOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Internal.ListAdapter.Converter<Integer, SemanticType> f18816d = new e();

        /* renamed from: e, reason: collision with root package name */
        private static final FieldDetails f18817e = new FieldDetails();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<FieldDetails> f18818f;

        /* renamed from: g, reason: collision with root package name */
        private Internal.IntList f18819g = GeneratedMessageLite.i();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldDetails, Builder> implements FieldDetailsOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(FieldDetails.f18817e);
            }
        }

        static {
            f18817e.l();
        }

        private FieldDetails() {
        }

        public static FieldDetails n() {
            return f18817e;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f18819g.size(); i++) {
                codedOutputStream.e(1, this.f18819g.getInt(i));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18819g.size(); i3++) {
                i2 += CodedOutputStream.a(this.f18819g.getInt(i3));
            }
            int size = 0 + i2 + (this.f18819g.size() * 1) + this.f18583b.c();
            this.f18584c = size;
            return size;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            c cVar = null;
            switch (c.f18835a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldDetails();
                case 2:
                    return f18817e;
                case 3:
                    this.f18819g.L();
                    return null;
                case 4:
                    return new Builder(cVar);
                case 5:
                    this.f18819g = ((GeneratedMessageLite.Visitor) obj).a(this.f18819g, ((FieldDetails) obj2).f18819g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    if (!this.f18819g.M()) {
                                        this.f18819g = GeneratedMessageLite.a(this.f18819g);
                                    }
                                    int f2 = codedInputStream.f();
                                    if (SemanticType.forNumber(f2) == null) {
                                        super.a(1, f2);
                                    } else {
                                        this.f18819g.i(f2);
                                    }
                                } else if (x != 10) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    if (!this.f18819g.M()) {
                                        this.f18819g = GeneratedMessageLite.a(this.f18819g);
                                    }
                                    int d2 = codedInputStream.d(codedInputStream.o());
                                    while (codedInputStream.a() > 0) {
                                        int f3 = codedInputStream.f();
                                        if (SemanticType.forNumber(f3) == null) {
                                            super.a(1, f3);
                                        } else {
                                            this.f18819g.i(f3);
                                        }
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
                    if (f18818f == null) {
                        synchronized (FieldDetails.class) {
                            if (f18818f == null) {
                                f18818f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18817e);
                            }
                        }
                    }
                    return f18818f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18817e;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class MessageDetails extends GeneratedMessageLite<MessageDetails, Builder> implements MessageDetailsOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Internal.ListAdapter.Converter<Integer, SemanticType> f18825d = new f();

        /* renamed from: e, reason: collision with root package name */
        private static final MessageDetails f18826e = new MessageDetails();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<MessageDetails> f18827f;

        /* renamed from: g, reason: collision with root package name */
        private Internal.IntList f18828g = GeneratedMessageLite.i();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MessageDetails, Builder> implements MessageDetailsOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(MessageDetails.f18826e);
            }
        }

        static {
            f18826e.l();
        }

        private MessageDetails() {
        }

        public static MessageDetails n() {
            return f18826e;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f18828g.size(); i++) {
                codedOutputStream.e(1, this.f18828g.getInt(i));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18828g.size(); i3++) {
                i2 += CodedOutputStream.a(this.f18828g.getInt(i3));
            }
            int size = 0 + i2 + (this.f18828g.size() * 1) + this.f18583b.c();
            this.f18584c = size;
            return size;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            c cVar = null;
            switch (c.f18835a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MessageDetails();
                case 2:
                    return f18826e;
                case 3:
                    this.f18828g.L();
                    return null;
                case 4:
                    return new Builder(cVar);
                case 5:
                    this.f18828g = ((GeneratedMessageLite.Visitor) obj).a(this.f18828g, ((MessageDetails) obj2).f18828g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    if (!this.f18828g.M()) {
                                        this.f18828g = GeneratedMessageLite.a(this.f18828g);
                                    }
                                    int f2 = codedInputStream.f();
                                    if (SemanticType.forNumber(f2) == null) {
                                        super.a(1, f2);
                                    } else {
                                        this.f18828g.i(f2);
                                    }
                                } else if (x != 10) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    if (!this.f18828g.M()) {
                                        this.f18828g = GeneratedMessageLite.a(this.f18828g);
                                    }
                                    int d2 = codedInputStream.d(codedInputStream.o());
                                    while (codedInputStream.a() > 0) {
                                        int f3 = codedInputStream.f();
                                        if (SemanticType.forNumber(f3) == null) {
                                            super.a(1, f3);
                                        } else {
                                            this.f18828g.i(f3);
                                        }
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
                    if (f18827f == null) {
                        synchronized (MessageDetails.class) {
                            if (f18827f == null) {
                                f18827f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18826e);
                            }
                        }
                    }
                    return f18827f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18826e;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class LocationQualifier extends GeneratedMessageLite<LocationQualifier, Builder> implements LocationQualifierOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final LocationQualifier f18820d = new LocationQualifier();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<LocationQualifier> f18821e;

        /* renamed from: f, reason: collision with root package name */
        private int f18822f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f18823g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18824h;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LocationQualifier, Builder> implements LocationQualifierOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(LocationQualifier.f18820d);
            }
        }

        static {
            f18820d.l();
        }

        private LocationQualifier() {
        }

        public static LocationQualifier n() {
            return f18820d;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18822f & 1) == 1) {
                codedOutputStream.b(1, this.f18823g);
            }
            if ((this.f18822f & 2) == 2) {
                codedOutputStream.b(2, this.f18824h);
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18822f & 1) == 1 ? 0 + CodedOutputStream.a(1, this.f18823g) : 0;
            if ((this.f18822f & 2) == 2) {
                a2 += CodedOutputStream.a(2, this.f18824h);
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public boolean o() {
            return (this.f18822f & 1) == 1;
        }

        public boolean p() {
            return (this.f18822f & 2) == 2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            c cVar = null;
            switch (c.f18835a[methodToInvoke.ordinal()]) {
                case 1:
                    return new LocationQualifier();
                case 2:
                    return f18820d;
                case 3:
                    return null;
                case 4:
                    return new Builder(cVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    LocationQualifier locationQualifier = (LocationQualifier) obj2;
                    this.f18823g = visitor.a(o(), this.f18823g, locationQualifier.o(), locationQualifier.f18823g);
                    this.f18824h = visitor.a(p(), this.f18824h, locationQualifier.p(), locationQualifier.f18824h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18822f |= locationQualifier.f18822f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f18822f |= 1;
                                    this.f18823g = codedInputStream.c();
                                } else if (x != 16) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    this.f18822f |= 2;
                                    this.f18824h = codedInputStream.c();
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
                    if (f18821e == null) {
                        synchronized (LocationQualifier.class) {
                            if (f18821e == null) {
                                f18821e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18820d);
                            }
                        }
                    }
                    return f18821e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18820d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Qualifier extends GeneratedMessageLite<Qualifier, Builder> implements QualifierOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Qualifier f18829d = new Qualifier();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Qualifier> f18830e;

        /* renamed from: f, reason: collision with root package name */
        private int f18831f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f18832g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18833h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private int n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        private boolean s;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Qualifier, Builder> implements QualifierOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(Qualifier.f18829d);
            }
        }

        static {
            f18829d.l();
        }

        private Qualifier() {
        }

        public static Qualifier n() {
            return f18829d;
        }

        public boolean A() {
            return (this.f18831f & 128) == 128;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18831f & 1) == 1) {
                codedOutputStream.b(1, this.f18832g);
            }
            if ((this.f18831f & 2) == 2) {
                codedOutputStream.b(2, this.f18833h);
            }
            if ((this.f18831f & 4) == 4) {
                codedOutputStream.b(3, this.i);
            }
            if ((this.f18831f & 8) == 8) {
                codedOutputStream.b(4, this.j);
            }
            if ((this.f18831f & 16) == 16) {
                codedOutputStream.b(5, this.k);
            }
            if ((this.f18831f & 32) == 32) {
                codedOutputStream.b(6, this.l);
            }
            if ((this.f18831f & 64) == 64) {
                codedOutputStream.b(7, this.m);
            }
            if ((this.f18831f & 128) == 128) {
                codedOutputStream.g(8, this.n);
            }
            if ((this.f18831f & 256) == 256) {
                codedOutputStream.b(9, this.o);
            }
            if ((this.f18831f & 512) == 512) {
                codedOutputStream.b(10, this.p);
            }
            if ((this.f18831f & 1024) == 1024) {
                codedOutputStream.b(11, this.q);
            }
            if ((this.f18831f & 4096) == 4096) {
                codedOutputStream.b(12, this.s);
            }
            if ((this.f18831f & 2048) == 2048) {
                codedOutputStream.b(13, this.r);
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18831f & 1) == 1 ? 0 + CodedOutputStream.a(1, this.f18832g) : 0;
            if ((this.f18831f & 2) == 2) {
                a2 += CodedOutputStream.a(2, this.f18833h);
            }
            if ((this.f18831f & 4) == 4) {
                a2 += CodedOutputStream.a(3, this.i);
            }
            if ((this.f18831f & 8) == 8) {
                a2 += CodedOutputStream.a(4, this.j);
            }
            if ((this.f18831f & 16) == 16) {
                a2 += CodedOutputStream.a(5, this.k);
            }
            if ((this.f18831f & 32) == 32) {
                a2 += CodedOutputStream.a(6, this.l);
            }
            if ((this.f18831f & 64) == 64) {
                a2 += CodedOutputStream.a(7, this.m);
            }
            if ((this.f18831f & 128) == 128) {
                a2 += CodedOutputStream.c(8, this.n);
            }
            if ((this.f18831f & 256) == 256) {
                a2 += CodedOutputStream.a(9, this.o);
            }
            if ((this.f18831f & 512) == 512) {
                a2 += CodedOutputStream.a(10, this.p);
            }
            if ((this.f18831f & 1024) == 1024) {
                a2 += CodedOutputStream.a(11, this.q);
            }
            if ((this.f18831f & 4096) == 4096) {
                a2 += CodedOutputStream.a(12, this.s);
            }
            if ((this.f18831f & 2048) == 2048) {
                a2 += CodedOutputStream.a(13, this.r);
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public boolean o() {
            return (this.f18831f & 2048) == 2048;
        }

        public boolean p() {
            return (this.f18831f & 1024) == 1024;
        }

        public boolean q() {
            return (this.f18831f & 32) == 32;
        }

        public boolean r() {
            return (this.f18831f & 4096) == 4096;
        }

        public boolean s() {
            return (this.f18831f & 64) == 64;
        }

        public boolean t() {
            return (this.f18831f & 2) == 2;
        }

        public boolean u() {
            return (this.f18831f & 8) == 8;
        }

        public boolean v() {
            return (this.f18831f & 1) == 1;
        }

        public boolean w() {
            return (this.f18831f & 16) == 16;
        }

        public boolean x() {
            return (this.f18831f & 512) == 512;
        }

        public boolean y() {
            return (this.f18831f & 256) == 256;
        }

        public boolean z() {
            return (this.f18831f & 4) == 4;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            c cVar = null;
            switch (c.f18835a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Qualifier();
                case 2:
                    return f18829d;
                case 3:
                    return null;
                case 4:
                    return new Builder(cVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Qualifier qualifier = (Qualifier) obj2;
                    this.f18832g = visitor.a(v(), this.f18832g, qualifier.v(), qualifier.f18832g);
                    this.f18833h = visitor.a(t(), this.f18833h, qualifier.t(), qualifier.f18833h);
                    this.i = visitor.a(z(), this.i, qualifier.z(), qualifier.i);
                    this.j = visitor.a(u(), this.j, qualifier.u(), qualifier.j);
                    this.k = visitor.a(w(), this.k, qualifier.w(), qualifier.k);
                    this.l = visitor.a(q(), this.l, qualifier.q(), qualifier.l);
                    this.m = visitor.a(s(), this.m, qualifier.s(), qualifier.m);
                    this.n = visitor.a(A(), this.n, qualifier.A(), qualifier.n);
                    this.o = visitor.a(y(), this.o, qualifier.y(), qualifier.o);
                    this.p = visitor.a(x(), this.p, qualifier.x(), qualifier.p);
                    this.q = visitor.a(p(), this.q, qualifier.p(), qualifier.q);
                    this.r = visitor.a(o(), this.r, qualifier.o(), qualifier.r);
                    this.s = visitor.a(r(), this.s, qualifier.r(), qualifier.s);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18831f |= qualifier.f18831f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            switch (x) {
                                case 0:
                                    z = true;
                                case 8:
                                    this.f18831f |= 1;
                                    this.f18832g = codedInputStream.c();
                                case 16:
                                    this.f18831f |= 2;
                                    this.f18833h = codedInputStream.c();
                                case 24:
                                    this.f18831f |= 4;
                                    this.i = codedInputStream.c();
                                case 32:
                                    this.f18831f |= 8;
                                    this.j = codedInputStream.c();
                                case 40:
                                    this.f18831f |= 16;
                                    this.k = codedInputStream.c();
                                case 48:
                                    this.f18831f |= 32;
                                    this.l = codedInputStream.c();
                                case 56:
                                    this.f18831f |= 64;
                                    this.m = codedInputStream.c();
                                case 64:
                                    this.f18831f |= 128;
                                    this.n = codedInputStream.j();
                                case 72:
                                    this.f18831f |= 256;
                                    this.o = codedInputStream.c();
                                case 80:
                                    this.f18831f |= 512;
                                    this.p = codedInputStream.c();
                                case 88:
                                    this.f18831f |= 1024;
                                    this.q = codedInputStream.c();
                                case 96:
                                    this.f18831f |= 4096;
                                    this.s = codedInputStream.c();
                                case 104:
                                    this.f18831f |= 2048;
                                    this.r = codedInputStream.c();
                                default:
                                    if (!a(x, codedInputStream)) {
                                        z = true;
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
                    if (f18830e == null) {
                        synchronized (Qualifier.class) {
                            if (f18830e == null) {
                                f18830e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18829d);
                            }
                        }
                    }
                    return f18830e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18829d;
        }
    }
}

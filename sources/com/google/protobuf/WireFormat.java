package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class WireFormat {

    /* renamed from: a */
    static final int f18737a = a(1, 3);

    /* renamed from: b */
    static final int f18738b = a(1, 4);

    /* renamed from: c */
    static final int f18739c = a(2, 0);

    /* renamed from: d */
    static final int f18740d = a(3, 2);

    /* loaded from: classes2.dex */
    public static class FieldType extends java.lang.Enum<FieldType> {
        private final JavaType javaType;
        private final int wireType;
        public static final FieldType DOUBLE = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
        public static final FieldType FLOAT = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
        public static final FieldType INT64 = new FieldType("INT64", 2, JavaType.LONG, 0);
        public static final FieldType UINT64 = new FieldType("UINT64", 3, JavaType.LONG, 0);
        public static final FieldType INT32 = new FieldType("INT32", 4, JavaType.INT, 0);
        public static final FieldType FIXED64 = new FieldType("FIXED64", 5, JavaType.LONG, 1);
        public static final FieldType FIXED32 = new FieldType("FIXED32", 6, JavaType.INT, 5);
        public static final FieldType BOOL = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
        public static final FieldType STRING = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: com.google.protobuf.WireFormat.FieldType.1
            AnonymousClass1(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType GROUP = new FieldType("GROUP", 9, JavaType.MESSAGE, 3) { // from class: com.google.protobuf.WireFormat.FieldType.2
            AnonymousClass2(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType MESSAGE = new FieldType("MESSAGE", 10, JavaType.MESSAGE, 2) { // from class: com.google.protobuf.WireFormat.FieldType.3
            AnonymousClass3(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType BYTES = new FieldType("BYTES", 11, JavaType.BYTE_STRING, 2) { // from class: com.google.protobuf.WireFormat.FieldType.4
            AnonymousClass4(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType UINT32 = new FieldType("UINT32", 12, JavaType.INT, 0);
        public static final FieldType ENUM = new FieldType("ENUM", 13, JavaType.ENUM, 0);
        public static final FieldType SFIXED32 = new FieldType("SFIXED32", 14, JavaType.INT, 5);
        public static final FieldType SFIXED64 = new FieldType("SFIXED64", 15, JavaType.LONG, 1);
        public static final FieldType SINT32 = new FieldType("SINT32", 16, JavaType.INT, 0);
        public static final FieldType SINT64 = new FieldType("SINT64", 17, JavaType.LONG, 0);
        private static final /* synthetic */ FieldType[] $VALUES = {DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64};

        /* renamed from: com.google.protobuf.WireFormat$FieldType$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends FieldType {
            AnonymousClass1(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$FieldType$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends FieldType {
            AnonymousClass2(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$FieldType$3 */
        /* loaded from: classes2.dex */
        enum AnonymousClass3 extends FieldType {
            AnonymousClass3(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$FieldType$4 */
        /* loaded from: classes2.dex */
        enum AnonymousClass4 extends FieldType {
            AnonymousClass4(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* synthetic */ FieldType(String str, int i, JavaType javaType, int i2, ka kaVar) {
            this(str, i, javaType, i2);
        }

        public static FieldType valueOf(String str) {
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) $VALUES.clone();
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        private FieldType(String str, int i, JavaType javaType, int i2) {
            super(str, i);
            this.javaType = javaType;
            this.wireType = i2;
        }
    }

    /* loaded from: classes2.dex */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);

        private final Object defaultDefault;

        JavaType(Object obj) {
            this.defaultDefault = obj;
        }

        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Utf8Validation {
        LOOSE { // from class: com.google.protobuf.WireFormat.Utf8Validation.1
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.v();
            }
        },
        STRICT { // from class: com.google.protobuf.WireFormat.Utf8Validation.2
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.w();
            }
        },
        LAZY { // from class: com.google.protobuf.WireFormat.Utf8Validation.3
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.d();
            }
        };

        /* renamed from: com.google.protobuf.WireFormat$Utf8Validation$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends Utf8Validation {
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.v();
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$Utf8Validation$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends Utf8Validation {
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.w();
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$Utf8Validation$3 */
        /* loaded from: classes2.dex */
        enum AnonymousClass3 extends Utf8Validation {
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.d();
            }
        }

        abstract Object readString(CodedInputStream codedInputStream) throws IOException;

        /* synthetic */ Utf8Validation(ka kaVar) {
            this();
        }
    }

    private WireFormat() {
    }

    public static int a(int i) {
        return i >>> 3;
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static Object a(CodedInputStream codedInputStream, FieldType fieldType, Utf8Validation utf8Validation) throws IOException {
        switch (ka.f18789a[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.e());
            case 2:
                return Float.valueOf(codedInputStream.i());
            case 3:
                return Long.valueOf(codedInputStream.k());
            case 4:
                return Long.valueOf(codedInputStream.z());
            case 5:
                return Integer.valueOf(codedInputStream.j());
            case 6:
                return Long.valueOf(codedInputStream.h());
            case 7:
                return Integer.valueOf(codedInputStream.g());
            case 8:
                return Boolean.valueOf(codedInputStream.c());
            case 9:
                return codedInputStream.d();
            case 10:
                return Integer.valueOf(codedInputStream.y());
            case 11:
                return Integer.valueOf(codedInputStream.r());
            case 12:
                return Long.valueOf(codedInputStream.s());
            case 13:
                return Integer.valueOf(codedInputStream.t());
            case 14:
                return Long.valueOf(codedInputStream.u());
            case 15:
                return utf8Validation.readString(codedInputStream);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int b(int i) {
        return i & 7;
    }
}

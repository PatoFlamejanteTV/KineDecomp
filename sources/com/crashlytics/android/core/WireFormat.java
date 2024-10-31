package com.crashlytics.android.core;

/* loaded from: classes.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;
    static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FieldType extends Enum<FieldType> {
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
        public static final FieldType STRING = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: com.crashlytics.android.core.WireFormat.FieldType.1
            AnonymousClass1(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType GROUP = new FieldType("GROUP", 9, JavaType.MESSAGE, 3) { // from class: com.crashlytics.android.core.WireFormat.FieldType.2
            AnonymousClass2(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType MESSAGE = new FieldType("MESSAGE", 10, JavaType.MESSAGE, 2) { // from class: com.crashlytics.android.core.WireFormat.FieldType.3
            AnonymousClass3(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType BYTES = new FieldType("BYTES", 11, JavaType.BYTE_STRING, 2) { // from class: com.crashlytics.android.core.WireFormat.FieldType.4
            AnonymousClass4(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
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

        /* renamed from: com.crashlytics.android.core.WireFormat$FieldType$1 */
        /* loaded from: classes.dex */
        enum AnonymousClass1 extends FieldType {
            AnonymousClass1(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.crashlytics.android.core.WireFormat$FieldType$2 */
        /* loaded from: classes.dex */
        enum AnonymousClass2 extends FieldType {
            AnonymousClass2(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.crashlytics.android.core.WireFormat$FieldType$3 */
        /* loaded from: classes.dex */
        enum AnonymousClass3 extends FieldType {
            AnonymousClass3(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.crashlytics.android.core.WireFormat$FieldType$4 */
        /* loaded from: classes.dex */
        enum AnonymousClass4 extends FieldType {
            AnonymousClass4(String str, int i, JavaType javaType, int i2) {
                super(str, i, javaType, i2);
            }

            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* synthetic */ FieldType(String str, int i, JavaType javaType, int i2, AnonymousClass1 anonymousClass1) {
            this(str, i, javaType, i2);
        }

        public static FieldType valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
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

    /* loaded from: classes.dex */
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

    private WireFormat() {
    }

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    static int getTagWireType(int i) {
        return i & 7;
    }

    public static int makeTag(int i, int i2) {
        return (i << 3) | i2;
    }
}

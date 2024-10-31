package com.squareup.wire;

import com.facebook.share.internal.ShareConstants;
import com.squareup.wire.MessageAdapter;
import com.squareup.wire.q;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class Message implements Serializable {
    private static final s WIRE = new s((Class<?>[]) new Class[0]);
    private static final long serialVersionUID = 0;
    private transient int cachedSerializedSize;
    protected transient int hashCode = 0;
    private transient boolean haveCachedSerializedSize;
    private transient q unknownFields;

    /* loaded from: classes.dex */
    public enum Datatype {
        INT32(1),
        INT64(2),
        UINT32(3),
        UINT64(4),
        SINT32(5),
        SINT64(6),
        BOOL(7),
        ENUM(8),
        STRING(9),
        BYTES(10),
        MESSAGE(11),
        FIXED32(12),
        SFIXED32(13),
        FIXED64(14),
        SFIXED64(15),
        FLOAT(16),
        DOUBLE(17);

        private final int value;
        public static final Comparator<Datatype> ORDER_BY_NAME = new i();
        private static final Map<String, Datatype> TYPES_BY_NAME = new LinkedHashMap();

        static {
            TYPES_BY_NAME.put("int32", INT32);
            TYPES_BY_NAME.put("int64", INT64);
            TYPES_BY_NAME.put("uint32", UINT32);
            TYPES_BY_NAME.put("uint64", UINT64);
            TYPES_BY_NAME.put("sint32", SINT32);
            TYPES_BY_NAME.put("sint64", SINT64);
            TYPES_BY_NAME.put("bool", BOOL);
            TYPES_BY_NAME.put("enum", ENUM);
            TYPES_BY_NAME.put("string", STRING);
            TYPES_BY_NAME.put("bytes", BYTES);
            TYPES_BY_NAME.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, MESSAGE);
            TYPES_BY_NAME.put("fixed32", FIXED32);
            TYPES_BY_NAME.put("sfixed32", SFIXED32);
            TYPES_BY_NAME.put("fixed64", FIXED64);
            TYPES_BY_NAME.put("sfixed64", SFIXED64);
            TYPES_BY_NAME.put("float", FLOAT);
            TYPES_BY_NAME.put("double", DOUBLE);
        }

        Datatype(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public WireType wireType() {
            switch (h.f4860a[ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return WireType.VARINT;
                case 9:
                case 10:
                case 11:
                    return WireType.FIXED32;
                case 12:
                case 13:
                case 14:
                    return WireType.FIXED64;
                case 15:
                case 16:
                case 17:
                    return WireType.LENGTH_DELIMITED;
                default:
                    throw new AssertionError("No wiretype for datatype " + this);
            }
        }

        public static Datatype of(String str) {
            return TYPES_BY_NAME.get(str);
        }
    }

    /* loaded from: classes.dex */
    public enum Label {
        REQUIRED(32),
        OPTIONAL(64),
        REPEATED(128),
        PACKED(256);

        public static final Comparator<Label> ORDER_BY_NAME = new j();
        private final int value;

        Label(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        public boolean isPacked() {
            return this == PACKED;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBuilder(a aVar) {
        if (aVar.unknownFieldMap != null) {
            this.unknownFields = new q(aVar.unknownFieldMap);
        }
    }

    protected Collection<List<q.a>> unknownFields() {
        return this.unknownFields == null ? Collections.emptySet() : this.unknownFields.f4863a.values();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> List<T> copyOf(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> List<T> immutableCopyOf(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return !(list instanceof MessageAdapter.ImmutableList) ? Collections.unmodifiableList(new ArrayList(list)) : list;
    }

    public static <E extends Enum & m> int intFromEnum(E e) {
        return WIRE.c(e.getClass()).a((c) e);
    }

    public static <E extends Enum & m> E enumFromInt(Class<E> cls, int i) {
        return (E) ((Enum) WIRE.c(cls).a(i));
    }

    public byte[] toByteArray() {
        return WIRE.a(getClass()).b((MessageAdapter) this);
    }

    public void writeTo(byte[] bArr) {
        writeTo(bArr, 0, bArr.length);
    }

    public void writeTo(byte[] bArr, int i, int i2) {
        write(v.a(bArr, i, i2));
    }

    private void write(v vVar) {
        try {
            WIRE.a(getClass()).a((MessageAdapter) this, vVar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeUnknownFieldMap(v vVar) throws IOException {
        if (this.unknownFields != null) {
            this.unknownFields.a(vVar);
        }
    }

    public int getSerializedSize() {
        if (!this.haveCachedSerializedSize) {
            this.cachedSerializedSize = WIRE.a(getClass()).a((MessageAdapter) this);
            this.haveCachedSerializedSize = true;
        }
        return this.cachedSerializedSize;
    }

    public int getUnknownFieldsSerializedSize() {
        if (this.unknownFields == null) {
            return 0;
        }
        return this.unknownFields.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean equals(List<?> list, List<?> list2) {
        if (list != null && list.isEmpty()) {
            list = null;
        }
        if (list2 != null && list2.isEmpty()) {
            list2 = null;
        }
        return list == list2 || (list != null && list.equals(list2));
    }

    public String toString() {
        return WIRE.a(getClass()).c((MessageAdapter) this);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(this, getClass());
    }

    /* loaded from: classes.dex */
    public static abstract class a<T extends Message> {
        q unknownFieldMap;

        public abstract T build();

        public a() {
        }

        public a(Message message) {
            if (message != null && message.unknownFields != null) {
                this.unknownFieldMap = new q(message.unknownFields);
            }
        }

        public void addVarint(int i, long j) {
            try {
                ensureUnknownFieldMap().a(i, Long.valueOf(j));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addFixed32(int i, int i2) {
            try {
                ensureUnknownFieldMap().a(i, Integer.valueOf(i2));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addFixed64(int i, long j) {
            try {
                ensureUnknownFieldMap().b(i, Long.valueOf(j));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addLengthDelimited(int i, ByteString byteString) {
            try {
                ensureUnknownFieldMap().a(i, byteString);
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public q ensureUnknownFieldMap() {
            if (this.unknownFieldMap == null) {
                this.unknownFieldMap = new q();
            }
            return this.unknownFieldMap;
        }

        public void checkRequiredFields() {
            Message.WIRE.b(getClass()).a(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static <T> List<T> checkForNulls(List<T> list) {
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) == null) {
                        throw new NullPointerException("Element at index " + i + " is null");
                    }
                }
            }
            return list;
        }
    }
}

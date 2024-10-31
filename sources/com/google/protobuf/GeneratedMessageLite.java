package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {

    /* renamed from: b, reason: collision with root package name */
    protected UnknownFieldSetLite f18583b = UnknownFieldSetLite.b();

    /* renamed from: c, reason: collision with root package name */
    protected int f18584c = -1;

    /* loaded from: classes2.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        private final MessageType f18585a;

        /* renamed from: b, reason: collision with root package name */
        protected MessageType f18586b;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f18587c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType messagetype) {
            this.f18585a = messagetype;
            this.f18586b = (MessageType) messagetype.a(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b() {
            if (this.f18587c) {
                MessageType messagetype = (MessageType) this.f18586b.a(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                messagetype.a(MergeFromVisitor.f18600a, this.f18586b);
                this.f18586b = messagetype;
                this.f18587c = false;
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public MessageType T() {
            if (this.f18587c) {
                return this.f18586b;
            }
            this.f18586b.l();
            this.f18587c = true;
            return this.f18586b;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public final MessageType build() {
            MessageType T = T();
            if (T.isInitialized()) {
                return T;
            }
            throw AbstractMessageLite.Builder.b(T);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BuilderType mo17clone() {
            BuilderType buildertype = (BuilderType) a().e();
            buildertype.b(T());
            return buildertype;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public BuilderType a(MessageType messagetype) {
            return b((Builder<MessageType, BuilderType>) messagetype);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MessageType a() {
            return this.f18585a;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            b();
            try {
                this.f18586b.a(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, extensionRegistryLite);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        public BuilderType b(MessageType messagetype) {
            b();
            this.f18586b.a(MergeFromVisitor.f18600a, messagetype);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: b, reason: collision with root package name */
        private T f18588b;

        public DefaultInstanceBasedParser(T t) {
            this.f18588b = t;
        }

        @Override // com.google.protobuf.Parser
        public T b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.a(this.f18588b, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    static class EqualsVisitor implements Visitor {

        /* renamed from: a, reason: collision with root package name */
        static final EqualsVisitor f18589a = new EqualsVisitor();

        /* renamed from: b, reason: collision with root package name */
        static final NotEqualsException f18590b = new NotEqualsException();

        /* loaded from: classes2.dex */
        static final class NotEqualsException extends RuntimeException {
            NotEqualsException() {
            }
        }

        private EqualsVisitor() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object b(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object c(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object d(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object e(boolean z, Object obj, Object obj2) {
            if (z && ((GeneratedMessageLite) obj).a(this, (MessageLite) obj2)) {
                return obj;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int a(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double a(boolean z, double d2, boolean z2, double d3) {
            if (z == z2 && d2 == d3) {
                return d2;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float a(boolean z, float f2, boolean z2, float f3) {
            if (z == z2 && f2 == f3) {
                return f2;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long a(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String a(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString a(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            if (z == z2 && byteString.equals(byteString2)) {
                return byteString;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object a(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void a(boolean z) {
            if (z) {
                throw f18590b;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T a(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t != null && t2 != null) {
                ((GeneratedMessageLite) t).a(this, t2);
                return t;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> a(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            if (protobufList.equals(protobufList2)) {
                return protobufList;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList a(Internal.IntList intList, Internal.IntList intList2) {
            if (intList.equals(intList2)) {
                return intList;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList a(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            if (doubleList.equals(doubleList2)) {
                return doubleList;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList a(Internal.LongList longList, Internal.LongList longList2) {
            if (longList.equals(longList2)) {
                return longList;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<a> a(FieldSet<a> fieldSet, FieldSet<a> fieldSet2) {
            if (fieldSet.equals(fieldSet2)) {
                return fieldSet;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite a(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            if (unknownFieldSetLite.equals(unknownFieldSetLite2)) {
                return unknownFieldSetLite;
            }
            throw f18590b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> a(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (mapFieldLite.equals(mapFieldLite2)) {
                return mapFieldLite;
            }
            throw f18590b;
        }
    }

    /* loaded from: classes2.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        final ContainingType f18596a;

        /* renamed from: b, reason: collision with root package name */
        final Type f18597b;

        /* renamed from: c, reason: collision with root package name */
        final MessageLite f18598c;

        /* renamed from: d, reason: collision with root package name */
        final a f18599d;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, a aVar, Class cls) {
            if (containingtype != null) {
                if (aVar.w() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f18596a = containingtype;
                this.f18597b = type;
                this.f18598c = messageLite;
                this.f18599d = aVar;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public MessageLite a() {
            return this.f18598c;
        }

        public int b() {
            return this.f18599d.getNumber();
        }

        Object a(Object obj) {
            return this.f18599d.z() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class MergeFromVisitor implements Visitor {

        /* renamed from: a, reason: collision with root package name */
        public static final MergeFromVisitor f18600a = new MergeFromVisitor();

        private MergeFromVisitor() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double a(boolean z, double d2, boolean z2, double d3) {
            return z2 ? d3 : d2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float a(boolean z, float f2, boolean z2, float f3) {
            return z2 ? f3 : f2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int a(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long a(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString a(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            return z2 ? byteString2 : byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T a(T t, T t2) {
            if (t == null || t2 == null) {
                return t != null ? t : t2;
            }
            return (T) t.b().a(t2).build();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object a(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String a(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void a(boolean z) {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object b(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object c(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object d(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object e(boolean z, Object obj, Object obj2) {
            return z ? a((MessageLite) obj, (MessageLite) obj2) : obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> a(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.M()) {
                    protobufList = protobufList.h2(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            return size > 0 ? protobufList : protobufList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList a(Internal.IntList intList, Internal.IntList intList2) {
            int size = intList.size();
            int size2 = intList2.size();
            Internal.IntList intList3 = intList;
            intList3 = intList;
            if (size > 0 && size2 > 0) {
                boolean M = intList.M();
                Internal.ProtobufList<Integer> protobufList = intList;
                if (!M) {
                    protobufList = intList.h2(size2 + size);
                }
                protobufList.addAll(intList2);
                intList3 = protobufList;
            }
            return size > 0 ? intList3 : intList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList a(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            int size = doubleList.size();
            int size2 = doubleList2.size();
            Internal.DoubleList doubleList3 = doubleList;
            doubleList3 = doubleList;
            if (size > 0 && size2 > 0) {
                boolean M = doubleList.M();
                Internal.ProtobufList<Double> protobufList = doubleList;
                if (!M) {
                    protobufList = doubleList.h2(size2 + size);
                }
                protobufList.addAll(doubleList2);
                doubleList3 = protobufList;
            }
            return size > 0 ? doubleList3 : doubleList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList a(Internal.LongList longList, Internal.LongList longList2) {
            int size = longList.size();
            int size2 = longList2.size();
            Internal.LongList longList3 = longList;
            longList3 = longList;
            if (size > 0 && size2 > 0) {
                boolean M = longList.M();
                Internal.ProtobufList<Long> protobufList = longList;
                if (!M) {
                    protobufList = longList.h2(size2 + size);
                }
                protobufList.addAll(longList2);
                longList3 = protobufList;
            }
            return size > 0 ? longList3 : longList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<a> a(FieldSet<a> fieldSet, FieldSet<a> fieldSet2) {
            if (fieldSet.b()) {
                fieldSet = fieldSet.m18clone();
            }
            fieldSet.a(fieldSet2);
            return fieldSet;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite a(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            return unknownFieldSetLite2 == UnknownFieldSetLite.b() ? unknownFieldSetLite : UnknownFieldSetLite.a(unknownFieldSetLite, unknownFieldSetLite2);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> a(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (!mapFieldLite2.isEmpty()) {
                if (!mapFieldLite.isMutable()) {
                    mapFieldLite = mapFieldLite.mutableCopy();
                }
                mapFieldLite.mergeFrom(mapFieldLite2);
            }
            return mapFieldLite;
        }
    }

    /* loaded from: classes2.dex */
    public enum MethodToInvoke {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* loaded from: classes2.dex */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final String messageClassName;

        SerializedForm(MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        @Deprecated
        private Object a() throws ObjectStreamException {
            try {
                java.lang.reflect.Field declaredField = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).e().b(this.asBytes).T();
            } catch (InvalidProtocolBufferException e2) {
                throw new RuntimeException("Unable to understand proto buffer", e2);
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (NoSuchFieldException e5) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e5);
            } catch (SecurityException e6) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e6);
            }
        }

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                java.lang.reflect.Field declaredField = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).e().b(this.asBytes).T();
            } catch (InvalidProtocolBufferException e2) {
                throw new RuntimeException("Unable to understand proto buffer", e2);
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (NoSuchFieldException unused) {
                return a();
            } catch (SecurityException e5) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface Visitor {
        double a(boolean z, double d2, boolean z2, double d3);

        float a(boolean z, float f2, boolean z2, float f3);

        int a(boolean z, int i, boolean z2, int i2);

        long a(boolean z, long j, boolean z2, long j2);

        ByteString a(boolean z, ByteString byteString, boolean z2, ByteString byteString2);

        FieldSet<a> a(FieldSet<a> fieldSet, FieldSet<a> fieldSet2);

        Internal.DoubleList a(Internal.DoubleList doubleList, Internal.DoubleList doubleList2);

        Internal.IntList a(Internal.IntList intList, Internal.IntList intList2);

        Internal.LongList a(Internal.LongList longList, Internal.LongList longList2);

        <T> Internal.ProtobufList<T> a(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2);

        <K, V> MapFieldLite<K, V> a(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2);

        <T extends MessageLite> T a(T t, T t2);

        UnknownFieldSetLite a(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2);

        Object a(boolean z, Object obj, Object obj2);

        String a(boolean z, String str, boolean z2, String str2);

        void a(boolean z);

        boolean a(boolean z, boolean z2, boolean z3, boolean z4);

        Object b(boolean z, Object obj, Object obj2);

        Object c(boolean z, Object obj, Object obj2);

        Object d(boolean z, Object obj, Object obj2);

        Object e(boolean z, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a implements FieldSet.FieldDescriptorLite<a> {

        /* renamed from: a, reason: collision with root package name */
        final Internal.EnumLiteMap<?> f18601a;

        /* renamed from: b, reason: collision with root package name */
        final int f18602b;

        /* renamed from: c, reason: collision with root package name */
        final WireFormat.FieldType f18603c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f18604d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f18605e;

        a(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.f18601a = enumLiteMap;
            this.f18602b = i;
            this.f18603c = fieldType;
            this.f18604d = z;
            this.f18605e = z2;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean A() {
            return this.f18605e;
        }

        public Internal.EnumLiteMap<?> a() {
            return this.f18601a;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.f18602b;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean v() {
            return this.f18604d;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType w() {
            return this.f18603c;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType z() {
            return this.f18603c.getJavaType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder a(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).b((Builder) messageLite);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f18602b - aVar.f18602b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Visitor {

        /* renamed from: a, reason: collision with root package name */
        private int f18606a;

        private b() {
            this.f18606a = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object b(boolean z, Object obj, Object obj2) {
            this.f18606a = (this.f18606a * 53) + Internal.a(Double.doubleToLongBits(((Double) obj).doubleValue()));
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object c(boolean z, Object obj, Object obj2) {
            this.f18606a = (this.f18606a * 53) + ((Integer) obj).intValue();
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object d(boolean z, Object obj, Object obj2) {
            this.f18606a = (this.f18606a * 53) + Internal.a(((Boolean) obj).booleanValue());
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object e(boolean z, Object obj, Object obj2) {
            MessageLite messageLite = (MessageLite) obj;
            a(messageLite, (MessageLite) obj2);
            return messageLite;
        }

        /* synthetic */ b(B b2) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
            this.f18606a = (this.f18606a * 53) + Internal.a(z2);
            return z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int a(boolean z, int i, boolean z2, int i2) {
            this.f18606a = (this.f18606a * 53) + i;
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double a(boolean z, double d2, boolean z2, double d3) {
            this.f18606a = (this.f18606a * 53) + Internal.a(Double.doubleToLongBits(d2));
            return d2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float a(boolean z, float f2, boolean z2, float f3) {
            this.f18606a = (this.f18606a * 53) + Float.floatToIntBits(f2);
            return f2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long a(boolean z, long j, boolean z2, long j2) {
            this.f18606a = (this.f18606a * 53) + Internal.a(j);
            return j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String a(boolean z, String str, boolean z2, String str2) {
            this.f18606a = (this.f18606a * 53) + str.hashCode();
            return str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString a(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            this.f18606a = (this.f18606a * 53) + byteString.hashCode();
            return byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object a(boolean z, Object obj, Object obj2) {
            this.f18606a = (this.f18606a * 53) + obj.hashCode();
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void a(boolean z) {
            if (z) {
                throw new IllegalStateException();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T a(T t, T t2) {
            int i;
            if (t == null) {
                i = 37;
            } else if (t instanceof GeneratedMessageLite) {
                i = ((GeneratedMessageLite) t).a(this);
            } else {
                i = t.hashCode();
            }
            this.f18606a = (this.f18606a * 53) + i;
            return t;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> a(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            this.f18606a = (this.f18606a * 53) + protobufList.hashCode();
            return protobufList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList a(Internal.IntList intList, Internal.IntList intList2) {
            this.f18606a = (this.f18606a * 53) + intList.hashCode();
            return intList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList a(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            this.f18606a = (this.f18606a * 53) + doubleList.hashCode();
            return doubleList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList a(Internal.LongList longList, Internal.LongList longList2) {
            this.f18606a = (this.f18606a * 53) + longList.hashCode();
            return longList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<a> a(FieldSet<a> fieldSet, FieldSet<a> fieldSet2) {
            this.f18606a = (this.f18606a * 53) + fieldSet.hashCode();
            return fieldSet;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite a(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            this.f18606a = (this.f18606a * 53) + unknownFieldSetLite.hashCode();
            return unknownFieldSetLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> a(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            this.f18606a = (this.f18606a * 53) + mapFieldLite.hashCode();
            return mapFieldLite;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.DoubleList h() {
        return C1661o.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.IntList i() {
        return E.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.LongList j() {
        return H.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> k() {
        return O.b();
    }

    private final void m() {
        if (this.f18583b == UnknownFieldSetLite.b()) {
            this.f18583b = UnknownFieldSetLite.e();
        }
    }

    protected abstract Object a(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!a().getClass().isInstance(obj)) {
            return false;
        }
        try {
            a((Visitor) EqualsVisitor.f18589a, (EqualsVisitor) obj);
            return true;
        } catch (EqualsVisitor.NotEqualsException unused) {
            return false;
        }
    }

    @Override // com.google.protobuf.MessageLite
    public final Parser<MessageType> f() {
        return (Parser) a(MethodToInvoke.GET_PARSER);
    }

    public int hashCode() {
        if (this.f18370a == 0) {
            b bVar = new b(null);
            a((Visitor) bVar, (b) this);
            this.f18370a = bVar.f18606a;
        }
        return this.f18370a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return a(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        a(MethodToInvoke.MAKE_IMMUTABLE);
        this.f18583b.d();
    }

    public String toString() {
        return J.a(this, super.toString());
    }

    /* loaded from: classes2.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
            MessageType messagetype2 = this.f18586b;
            ((ExtendableMessage) messagetype2).f18591d = ((ExtendableMessage) messagetype2).f18591d.m18clone();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public void b() {
            if (this.f18587c) {
                super.b();
                MessageType messagetype = this.f18586b;
                ((ExtendableMessage) messagetype).f18591d = ((ExtendableMessage) messagetype).f18591d.m18clone();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public final MessageType T() {
            if (this.f18587c) {
                return (MessageType) this.f18586b;
            }
            ((ExtendableMessage) this.f18586b).f18591d.e();
            return (MessageType) super.T();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo17clone() {
            return (BuilderType) super.mo17clone();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {

        /* renamed from: d, reason: collision with root package name */
        protected FieldSet<a> f18591d = FieldSet.f();

        /* loaded from: classes2.dex */
        protected class ExtensionWriter {

            /* renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<a, Object>> f18592a;

            /* renamed from: b, reason: collision with root package name */
            private Map.Entry<a, Object> f18593b;

            /* renamed from: c, reason: collision with root package name */
            private final boolean f18594c;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, B b2) {
                this(z);
            }

            public void a(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<a, Object> entry = this.f18593b;
                    if (entry == null || entry.getKey().getNumber() >= i) {
                        return;
                    }
                    a key = this.f18593b.getKey();
                    if (this.f18594c && key.z() == WireFormat.JavaType.MESSAGE && !key.v()) {
                        codedOutputStream.d(key.getNumber(), (MessageLite) this.f18593b.getValue());
                    } else {
                        FieldSet.a(key, this.f18593b.getValue(), codedOutputStream);
                    }
                    if (this.f18592a.hasNext()) {
                        this.f18593b = this.f18592a.next();
                    } else {
                        this.f18593b = null;
                    }
                }
            }

            private ExtensionWriter(boolean z) {
                this.f18592a = ExtendableMessage.this.f18591d.d();
                if (this.f18592a.hasNext()) {
                    this.f18593b = this.f18592a.next();
                }
                this.f18594c = z;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite a() {
            return super.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder b() {
            return super.b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder e() {
            return super.e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public final void l() {
            super.l();
            this.f18591d.e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean m() {
            return this.f18591d.c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int n() {
            return this.f18591d.a();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o() {
            return new ExtensionWriter(this, false, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.GeneratedMessageLite
        public final void a(Visitor visitor, MessageType messagetype) {
            super.a(visitor, (Visitor) messagetype);
            this.f18591d = visitor.a(this.f18591d, messagetype.f18591d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public <MessageType extends com.google.protobuf.MessageLite> boolean a(MessageType r7, com.google.protobuf.CodedInputStream r8, com.google.protobuf.ExtensionRegistryLite r9, int r10) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableMessage.a(com.google.protobuf.MessageLite, com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite, int):boolean");
        }
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final MessageType a() {
        return (MessageType) a(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType b() {
        BuilderType buildertype = (BuilderType) a(MethodToInvoke.NEW_BUILDER);
        buildertype.b(this);
        return buildertype;
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType e() {
        return (BuilderType) a(MethodToInvoke.NEW_BUILDER);
    }

    int a(b bVar) {
        if (this.f18370a == 0) {
            int i = bVar.f18606a;
            bVar.f18606a = 0;
            a((Visitor) bVar, (b) this);
            this.f18370a = bVar.f18606a;
            bVar.f18606a = i;
        }
        return this.f18370a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean a(EqualsVisitor equalsVisitor, MessageLite messageLite) {
        if (this == messageLite) {
            return true;
        }
        if (!a().getClass().isInstance(messageLite)) {
            return false;
        }
        a((Visitor) equalsVisitor, (EqualsVisitor) messageLite);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.b(i) == 4) {
            return false;
        }
        m();
        return this.f18583b.a(i, codedInputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2) {
        m();
        this.f18583b.a(i, i2);
    }

    protected Object a(MethodToInvoke methodToInvoke, Object obj) {
        return a(methodToInvoke, obj, (Object) null);
    }

    protected Object a(MethodToInvoke methodToInvoke) {
        return a(methodToInvoke, (Object) null, (Object) null);
    }

    void a(Visitor visitor, MessageType messagetype) {
        a(MethodToInvoke.VISIT, visitor, messagetype);
        this.f18583b = visitor.a(this.f18583b, messagetype.f18583b);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> a(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new a(enumLiteMap, i, fieldType, false, false), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> a(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new a(enumLiteMap, i, fieldType, true, z), cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(java.lang.reflect.Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$IntList] */
    public static Internal.IntList a(Internal.IntList intList) {
        int size = intList.size();
        return intList.h2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$LongList] */
    public static Internal.LongList a(Internal.LongList longList) {
        int size = longList.size();
        return longList.h2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$DoubleList] */
    public static Internal.DoubleList a(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.h2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> a(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.h2(size == 0 ? 10 : size * 2);
    }

    static <T extends GeneratedMessageLite<T, ?>> T a(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) t.a(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            t2.a(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, extensionRegistryLite);
            t2.l();
            return t2;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        }
    }
}

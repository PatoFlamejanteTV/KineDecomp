package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Types {

    /* renamed from: a, reason: collision with root package name */
    private static final Function<Type, String> f2941a = new i();
    private static final Joiner b = Joiner.a(", ").b("null");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type a(Type type) {
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Preconditions.a(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return c(a(lowerBounds[0]));
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            Preconditions.a(upperBounds.length == 1, "Wildcard should have only one upper bound.");
            return b(a(upperBounds[0]));
        }
        return JavaVersion.CURRENT.newArrayType(type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParameterizedType a(@Nullable Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return a(cls, typeArr);
        }
        Preconditions.a(typeArr);
        Preconditions.a(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParameterizedType a(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            @Nullable
            Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            @Nullable
            Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };

        static final ClassOwnership JVM_BEHAVIOR = a();

        @Nullable
        abstract Class<?> getOwnerType(Class<?> cls);

        /* synthetic */ ClassOwnership(i iVar) {
            this();
        }

        private static ClassOwnership a() {
            ParameterizedType parameterizedType = (ParameterizedType) new k().getClass().getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(j.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <D extends GenericDeclaration> TypeVariable<D> a(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return new a(d, str, typeArr);
    }

    @VisibleForTesting
    static WildcardType b(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    @VisibleForTesting
    static WildcardType c(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Type e(Type type) {
        Preconditions.a(type);
        if (type instanceof Class) {
            return ((Class) type).getComponentType();
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        if (type instanceof WildcardType) {
            return a(((WildcardType) type).getUpperBounds());
        }
        if (type instanceof TypeVariable) {
            return a(((TypeVariable) type).getBounds());
        }
        return null;
    }

    @Nullable
    private static Type a(Type[] typeArr) {
        for (Type type : typeArr) {
            Type e = e(type);
            if (e != null) {
                if (e instanceof Class) {
                    Class cls = (Class) e;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return b(e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(@Nullable Type type) {
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            return f(((GenericArrayType) type).getGenericComponentType());
        }
        if (type instanceof ParameterizedType) {
            return b(((ParameterizedType) type).getActualTypeArguments());
        }
        if (!(type instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) type;
        return b(wildcardType.getUpperBounds()) || b(wildcardType.getLowerBounds());
    }

    private static boolean b(Type[] typeArr) {
        for (Type type : typeArr) {
            if (f(type)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public String toString() {
            return Types.d(this.componentType) + "[]";
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return Objects.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(@Nullable Type type, Class<?> cls, Type[] typeArr) {
            Preconditions.a(cls);
            Preconditions.a(typeArr.length == cls.getTypeParameters().length);
            Types.b(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.b((Collection<Type>) this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.ownerType != null) {
                sb.append(Types.d(this.ownerType)).append('.');
            }
            sb.append(this.rawType.getName()).append('<').append(Types.b.a(Iterables.a((Iterable) this.argumentsList, Types.f2941a))).append('>');
            return sb.toString();
        }

        public int hashCode() {
            return ((this.ownerType == null ? 0 : this.ownerType.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && Objects.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }
    }

    /* loaded from: classes2.dex */
    private static final class a<D extends GenericDeclaration> implements TypeVariable<D> {

        /* renamed from: a, reason: collision with root package name */
        private final D f2942a;
        private final String b;
        private final ImmutableList<Type> c;

        a(D d, String str, Type[] typeArr) {
            Types.b(typeArr, "bound for type variable");
            this.f2942a = (D) Preconditions.a(d);
            this.b = (String) Preconditions.a(str);
            this.c = ImmutableList.copyOf(typeArr);
        }

        @Override // java.lang.reflect.TypeVariable
        public Type[] getBounds() {
            return Types.b((Collection<Type>) this.c);
        }

        @Override // java.lang.reflect.TypeVariable
        public D getGenericDeclaration() {
            return this.f2942a;
        }

        @Override // java.lang.reflect.TypeVariable
        public String getName() {
            return this.b;
        }

        public String toString() {
            return this.b;
        }

        public int hashCode() {
            return this.f2942a.hashCode() ^ this.b.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TypeVariable)) {
                return false;
            }
            TypeVariable typeVariable = (TypeVariable) obj;
            return this.b.equals(typeVariable.getName()) && this.f2942a.equals(typeVariable.getGenericDeclaration());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.b(typeArr, "lower bound for wildcard");
            Types.b(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.b((Collection<Type>) this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.b((Collection<Type>) this.upperBounds);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            Iterator it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                sb.append(" super ").append(Types.d((Type) it.next()));
            }
            Iterator it2 = Types.b((Iterable<Type>) this.upperBounds).iterator();
            while (it2.hasNext()) {
                sb.append(" extends ").append(Types.d((Type) it2.next()));
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] b(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Type> b(Iterable<Type> iterable) {
        return Iterables.a((Iterable) iterable, Predicates.a(Predicates.a(Object.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                Preconditions.a(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                Preconditions.a(type);
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    if (cls.isArray()) {
                        return new GenericArrayTypeImpl(cls.getComponentType());
                    }
                    return type;
                }
                return type;
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.common.reflect.Types.JavaVersion
            Type newArrayType(Type type) {
                return type instanceof Class ? Types.a((Class<?>) type) : new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                return (Type) Preconditions.a(type);
            }
        };

        static final JavaVersion CURRENT;

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Type newArrayType(Type type);

        abstract Type usedInGenericType(Type type);

        /* synthetic */ JavaVersion(i iVar) {
            this();
        }

        static {
            CURRENT = new l().capture() instanceof Class ? JAVA7 : JAVA6;
        }

        final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.b((ImmutableList.Builder) usedInGenericType(type));
            }
            return builder.a();
        }
    }
}

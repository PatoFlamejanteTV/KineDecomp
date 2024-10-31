package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Types {

    /* renamed from: a */
    private static final Function<Type, String> f16079a = new s();

    /* renamed from: b */
    private static final Joiner f16080b = Joiner.a(", ").b("null");

    /* loaded from: classes2.dex */
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

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends ClassOwnership {
            @Override // com.google.common.reflect.Types.ClassOwnership
            @Nullable
            Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        }

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends ClassOwnership {
            @Override // com.google.common.reflect.Types.ClassOwnership
            @Nullable
            Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        private static ClassOwnership a() {
            new v();
            ParameterizedType parameterizedType = (ParameterizedType) v.class.getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(u.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        @Nullable
        abstract Class<?> getOwnerType(Class<?> cls);

        /* synthetic */ ClassOwnership(s sVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return Objects.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.e(this.componentType) + "[]";
        }
    }

    /* loaded from: classes2.dex */
    public enum JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                Preconditions.a(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.a((Class<?>) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                Preconditions.a(type);
                return type;
            }
        },
        JAVA8 { // from class: com.google.common.reflect.Types.JavaVersion.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        };

        static final JavaVersion CURRENT;

        /* renamed from: com.google.common.reflect.Types$JavaVersion$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends JavaVersion {
            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                Preconditions.a(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends JavaVersion {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.a((Class<?>) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                Preconditions.a(type);
                return type;
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$3 */
        /* loaded from: classes2.dex */
        enum AnonymousClass3 extends JavaVersion {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        }

        static {
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                CURRENT = JAVA8;
            } else if (new w().capture() instanceof Class) {
                CURRENT = JAVA7;
            } else {
                CURRENT = JAVA6;
            }
        }

        public abstract Type newArrayType(Type type);

        public String typeName(Type type) {
            return Types.e(type);
        }

        final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.a((ImmutableList.Builder) usedInGenericType(type));
            }
            return builder.a();
        }

        abstract Type usedInGenericType(Type type);

        /* synthetic */ JavaVersion(s sVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
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

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && Objects.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.b((Collection<Type>) this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Type type = this.ownerType;
            if (type != null) {
                sb.append(JavaVersion.CURRENT.typeName(type));
                sb.append('.');
            }
            sb.append(this.rawType.getName());
            sb.append('<');
            sb.append(Types.f16080b.a(Iterables.a((Iterable) this.argumentsList, Types.f16079a)));
            sb.append('>');
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.b(typeArr, "lower bound for wildcard");
            Types.b(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.b((Collection<Type>) this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.b((Collection<Type>) this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            Iterator it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                Type type = (Type) it.next();
                sb.append(" super ");
                sb.append(JavaVersion.CURRENT.typeName(type));
            }
            for (Type type2 : Types.b((Iterable<Type>) this.upperBounds)) {
                sb.append(" extends ");
                sb.append(JavaVersion.CURRENT.typeName(type2));
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<X> {

        /* renamed from: a */
        static final boolean f16081a = !a.class.getTypeParameters()[0].equals(Types.a(a.class, "X", new Type[0]));

        a() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<D extends GenericDeclaration> {

        /* renamed from: a */
        private final D f16082a;

        /* renamed from: b */
        private final String f16083b;

        /* renamed from: c */
        private final ImmutableList<Type> f16084c;

        b(D d2, String str, Type[] typeArr) {
            Types.b(typeArr, "bound for type variable");
            Preconditions.a(d2);
            this.f16082a = d2;
            Preconditions.a(str);
            this.f16083b = str;
            this.f16084c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.f16082a;
        }

        public String b() {
            return this.f16083b;
        }

        public boolean equals(Object obj) {
            if (a.f16081a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof c)) {
                    return false;
                }
                b bVar = ((c) Proxy.getInvocationHandler(obj)).f16086b;
                return this.f16083b.equals(bVar.b()) && this.f16082a.equals(bVar.a()) && this.f16084c.equals(bVar.f16084c);
            }
            if (!(obj instanceof TypeVariable)) {
                return false;
            }
            TypeVariable typeVariable = (TypeVariable) obj;
            return this.f16083b.equals(typeVariable.getName()) && this.f16082a.equals(typeVariable.getGenericDeclaration());
        }

        public int hashCode() {
            return this.f16082a.hashCode() ^ this.f16083b.hashCode();
        }

        public String toString() {
            return this.f16083b;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements InvocationHandler {

        /* renamed from: a */
        private static final ImmutableMap<String, Method> f16085a;

        /* renamed from: b */
        private final b<?> f16086b;

        static {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            for (Method method : b.class.getMethods()) {
                if (method.getDeclaringClass().equals(b.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.a(method.getName(), method);
                }
            }
            f16085a = builder.a();
        }

        c(b<?> bVar) {
            this.f16086b = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f16085a.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.f16086b, objArr);
                } catch (InvocationTargetException e2) {
                    throw e2.getCause();
                }
            }
            throw new UnsupportedOperationException(name);
        }
    }

    @VisibleForTesting
    static WildcardType c(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    @VisibleForTesting
    static WildcardType d(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    public static String e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type b(Type type) {
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Preconditions.a(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return d(b(lowerBounds[0]));
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            Preconditions.a(upperBounds.length == 1, "Wildcard should have only one upper bound.");
            return c(b(upperBounds[0]));
        }
        return JavaVersion.CURRENT.newArrayType(type);
    }

    public static ParameterizedType a(@Nullable Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return a(cls, typeArr);
        }
        Preconditions.a(typeArr);
        Preconditions.a(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    static ParameterizedType a(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> a(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return b(d2, str, typeArr);
    }

    @Nullable
    public static Type a(Type type) {
        Preconditions.a(type);
        AtomicReference atomicReference = new AtomicReference();
        new t(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    @Nullable
    public static Type b(Type[] typeArr) {
        for (Type type : typeArr) {
            Type a2 = a(type);
            if (a2 != null) {
                if (a2 instanceof Class) {
                    Class cls = (Class) a2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return c(a2);
            }
        }
        return null;
    }

    public static Class<?> a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    private static <D extends GenericDeclaration> TypeVariable<D> b(D d2, String str, Type[] typeArr) {
        return (TypeVariable) Reflection.a(TypeVariable.class, new c(new b(d2, str, typeArr)));
    }

    public static Type[] b(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    public static Iterable<Type> b(Iterable<Type> iterable) {
        return Iterables.c(iterable, Predicates.a(Predicates.a(Object.class)));
    }

    public static void b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Preconditions.a(!r2.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }
}

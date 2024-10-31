package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

@Beta
/* loaded from: classes2.dex */
public abstract class Invokable<T, R> extends com.google.common.reflect.b implements GenericDeclaration {

    /* loaded from: classes2.dex */
    static class a<T> extends Invokable<T, T> {

        /* renamed from: c, reason: collision with root package name */
        final Constructor<?> f16054c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Constructor<?> constructor) {
            super(constructor);
            this.f16054c = constructor;
        }

        private boolean c() {
            Class<?> declaringClass = this.f16054c.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            if (declaringClass.getEnclosingMethod() != null) {
                return !Modifier.isStatic(r1.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Type[] b() {
            Type[] genericParameterTypes = this.f16054c.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f16054c.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f16054c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    /* loaded from: classes2.dex */
    static class b<T> extends Invokable<T, Object> {

        /* renamed from: c, reason: collision with root package name */
        final Method f16055c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Method method) {
            super(method);
            this.f16055c = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f16055c.getTypeParameters();
        }
    }

    <M extends AccessibleObject & Member> Invokable(M m) {
        super(m);
    }

    @Override // com.google.common.reflect.b
    public TypeToken<T> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    @Override // com.google.common.reflect.b
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.reflect.b, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    @Override // com.google.common.reflect.b
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.reflect.b
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}

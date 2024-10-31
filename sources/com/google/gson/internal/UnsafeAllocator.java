package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes2.dex */
public abstract class UnsafeAllocator {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$1 */
    /* loaded from: classes2.dex */
    public static class AnonymousClass1 extends UnsafeAllocator {
        final /* synthetic */ Method val$allocateInstance;
        final /* synthetic */ Object val$unsafe;

        AnonymousClass1(Method method, Object obj) {
            method = method;
            obj = obj;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return (T) method.invoke(obj, cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$2 */
    /* loaded from: classes2.dex */
    public static class AnonymousClass2 extends UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ Method val$newInstance;

        AnonymousClass2(Method method, int i) {
            declaredMethod2 = method;
            intValue = i;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return (T) declaredMethod2.invoke(null, cls, Integer.valueOf(intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$3 */
    /* loaded from: classes2.dex */
    public static class AnonymousClass3 extends UnsafeAllocator {
        final /* synthetic */ Method val$newInstance;

        AnonymousClass3(Method method) {
            declaredMethod3 = method;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return (T) declaredMethod3.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$4 */
    /* loaded from: classes2.dex */
    public static class AnonymousClass4 extends UnsafeAllocator {
        AnonymousClass4() {
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void assertInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public static UnsafeAllocator create() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                final /* synthetic */ Method val$allocateInstance;
                final /* synthetic */ Object val$unsafe;

                AnonymousClass1(Method method, Object obj) {
                    method = method;
                    obj = obj;
                }

                @Override // com.google.gson.internal.UnsafeAllocator
                public <T> T newInstance(Class<T> cls2) throws Exception {
                    UnsafeAllocator.assertInstantiable(cls2);
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                        final /* synthetic */ int val$constructorId;
                        final /* synthetic */ Method val$newInstance;

                        AnonymousClass2(Method declaredMethod22, int intValue2) {
                            declaredMethod2 = declaredMethod22;
                            intValue = intValue2;
                        }

                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls2) throws Exception {
                            UnsafeAllocator.assertInstantiable(cls2);
                            return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(intValue));
                        }
                    };
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                        final /* synthetic */ Method val$newInstance;

                        AnonymousClass3(Method declaredMethod32) {
                            declaredMethod3 = declaredMethod32;
                        }

                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls2) throws Exception {
                            UnsafeAllocator.assertInstantiable(cls2);
                            return (T) declaredMethod3.invoke(null, cls2, Object.class);
                        }
                    };
                }
            } catch (Exception unused3) {
                return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.4
                    AnonymousClass4() {
                    }

                    @Override // com.google.gson.internal.UnsafeAllocator
                    public <T> T newInstance(Class<T> cls2) {
                        throw new UnsupportedOperationException("Cannot allocate " + cls2);
                    }
                };
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}

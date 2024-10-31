package com.google.api.client.json;

import com.google.api.client.util.Beta;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Beta
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonPolymorphicTypeMap {

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface TypeDef {
        String a();

        Class<?> b();
    }

    TypeDef[] a();
}

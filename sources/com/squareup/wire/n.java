package com.squareup.wire;

import com.squareup.wire.Message;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: ProtoField.java */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface n {
    int a();

    Message.Datatype b() default Message.Datatype.MESSAGE;

    Message.Label c() default Message.Label.OPTIONAL;

    Class<? extends Message> d() default Message.class;

    Class<? extends Enum> e() default Enum.class;

    boolean f() default false;
}

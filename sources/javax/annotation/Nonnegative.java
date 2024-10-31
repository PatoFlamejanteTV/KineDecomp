package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;

@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Nonnegative {

    /* loaded from: classes.dex */
    public static class Checker implements TypeQualifierValidator<Nonnegative> {
    }
}

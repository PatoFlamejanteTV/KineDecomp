package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Nonnegative {

    /* loaded from: classes3.dex */
    public static class Checker implements TypeQualifierValidator<Nonnegative> {
    }
}

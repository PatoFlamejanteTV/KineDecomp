package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.TypeQualifierValidator;

@Syntax
@TypeQualifierNickname
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface RegEx {

    /* loaded from: classes.dex */
    public static class Checker implements TypeQualifierValidator<RegEx> {
    }
}

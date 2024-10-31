package com.google.ads.mediation;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public abstract class MediationServerParameters {

    /* loaded from: classes.dex */
    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    protected @interface Parameter {
        String a();

        boolean b() default true;
    }

    protected void a() {
    }

    public void a(Map<String, String> map) throws MappingException {
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzb.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    zzb.e("Server option \"" + entry.getKey() + "\" could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    zzb.e("Server option \"" + entry.getKey() + "\" could not be set: Bad Type");
                }
            } else {
                zzb.a("Unexpected server option: " + entry.getKey() + " = \"" + entry.getValue() + "\"");
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).b()) {
                zzb.e("Required server option missing: " + ((Parameter) field3.getAnnotation(Parameter.class)).a());
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(((Parameter) field3.getAnnotation(Parameter.class)).a());
            }
        }
        if (sb.length() > 0) {
            throw new MappingException("Required server option(s) missing: " + sb.toString());
        }
        a();
    }
}

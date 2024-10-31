package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class zza {
    public static Scope a(Scope scope) {
        return scope.equals(new Scope("https://www.googleapis.com/auth/fitness.activity.read")) ? new Scope("https://www.googleapis.com/auth/fitness.activity.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.location.read")) ? new Scope("https://www.googleapis.com/auth/fitness.location.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.body.read")) ? new Scope("https://www.googleapis.com/auth/fitness.body.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.nutrition.read")) ? new Scope("https://www.googleapis.com/auth/fitness.nutrition.write") : scope;
    }

    public static Set<Scope> a(Collection<Scope> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (Scope scope : collection) {
            Scope a2 = a(scope);
            if (a2.equals(scope) || !collection.contains(a2)) {
                hashSet.add(scope);
            }
        }
        return hashSet;
    }
}

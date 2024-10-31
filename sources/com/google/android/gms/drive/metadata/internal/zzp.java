package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public class zzp extends zzj<UserMetadata> {
    public zzp(String str, int i) {
        super(str, b(str), Collections.emptyList(), i);
    }

    private String a(String str) {
        return a(getName(), str);
    }

    private static String a(String str, String str2) {
        return str + "." + str2;
    }

    private static Collection<String> b(String str) {
        return Arrays.asList(a(str, "permissionId"), a(str, "displayName"), a(str, "picture"), a(str, "isAuthenticatedUser"), a(str, "emailAddress"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UserMetadata zzc(DataHolder dataHolder, int i, int i2) {
        String c = dataHolder.c(a("permissionId"), i, i2);
        if (c == null) {
            return null;
        }
        String c2 = dataHolder.c(a("displayName"), i, i2);
        String c3 = dataHolder.c(a("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.d(a("isAuthenticatedUser"), i, i2));
        return new UserMetadata(c, c2, c3, valueOf.booleanValue(), dataHolder.c(a("emailAddress"), i, i2));
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.a(a("permissionId")) && !dataHolder.h(a("permissionId"), i, i2);
    }
}

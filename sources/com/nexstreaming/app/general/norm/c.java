package com.nexstreaming.app.general.norm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: NormTable.java */
/* loaded from: classes2.dex */
public abstract class c {
    public static final String DEFAULT_ASSET_LEVEL = "1";
    boolean addedOrUpdatedToDb = false;
    private final com.nexstreaming.app.general.norm.e tableInfo = com.nexstreaming.app.general.norm.e.a((Class<? extends c>) getClass());

    /* compiled from: NormTable.java */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface a {
        int value() default 11;
    }

    /* compiled from: NormTable.java */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface b {
    }

    /* compiled from: NormTable.java */
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.nexstreaming.app.general.norm.c$c */
    /* loaded from: classes.dex */
    public @interface InterfaceC0098c {
    }

    /* compiled from: NormTable.java */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface d {
    }

    /* compiled from: NormTable.java */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface e {
    }

    /* compiled from: NormTable.java */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface f {
    }

    /* compiled from: NormTable.java */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface g {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        c cVar = (c) obj;
        return cVar.getTableInfo().f().equals(getTableInfo().f()) && getDbRowID() == cVar.getDbRowID();
    }

    public long getDbRowID() {
        try {
            return getTableInfo().e().f19642b.getLong(this);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public com.nexstreaming.app.general.norm.e getTableInfo() {
        return this.tableInfo;
    }

    public int hashCode() {
        return (int) (getDbRowID() * getTableInfo().f().hashCode());
    }

    public boolean wasAddedToDb() {
        return this.addedOrUpdatedToDb;
    }
}

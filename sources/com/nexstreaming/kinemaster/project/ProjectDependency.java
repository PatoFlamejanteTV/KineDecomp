package com.nexstreaming.kinemaster.project;

import android.content.Context;

/* loaded from: classes.dex */
public class ProjectDependency {

    /* renamed from: a, reason: collision with root package name */
    private Type f21157a;

    /* renamed from: b, reason: collision with root package name */
    private String f21158b;

    /* loaded from: classes.dex */
    public enum Type {
        ThemeMusic,
        AssetMusic,
        Effect,
        Font
    }

    private ProjectDependency() {
    }

    public static ProjectDependency a(String str) {
        ProjectDependency projectDependency = new ProjectDependency();
        projectDependency.f21157a = Type.AssetMusic;
        projectDependency.f21158b = str;
        return projectDependency;
    }

    public static ProjectDependency b(String str) {
        ProjectDependency projectDependency = new ProjectDependency();
        projectDependency.f21157a = Type.Effect;
        projectDependency.f21158b = str;
        return projectDependency;
    }

    public static ProjectDependency c(String str) {
        ProjectDependency projectDependency = new ProjectDependency();
        projectDependency.f21157a = Type.Font;
        projectDependency.f21158b = str;
        return projectDependency;
    }

    public static ProjectDependency d(String str) {
        ProjectDependency projectDependency = new ProjectDependency();
        projectDependency.f21157a = Type.ThemeMusic;
        projectDependency.f21158b = str;
        return projectDependency;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProjectDependency)) {
            return false;
        }
        ProjectDependency projectDependency = (ProjectDependency) obj;
        if (projectDependency.f21157a == this.f21157a) {
            String str = projectDependency.f21158b;
            String str2 = this.f21158b;
            if (str == str2) {
                return true;
            }
            if (str2 != null && str != null && str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Type type = this.f21157a;
        int hashCode = type == null ? 0 : type.hashCode();
        String str = this.f21158b;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String a(Context context) {
        return String.valueOf(this.f21157a) + ": " + String.valueOf(this.f21158b);
    }

    public boolean b() {
        return com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(a()) != null;
    }

    public int a() {
        int indexOf;
        String str = this.f21158b;
        if (str != null && (indexOf = str.indexOf(47)) > 0) {
            try {
                return Integer.parseInt(this.f21158b.substring(0, indexOf));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }
}

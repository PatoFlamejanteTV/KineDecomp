package com.nexstreaming.kinemaster.project;

import android.content.Context;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* loaded from: classes.dex */
public class ProjectDependency {

    /* renamed from: a */
    private Type f3615a;
    private String b;

    /* loaded from: classes.dex */
    public enum Type {
        ThemeMusic,
        Effect,
        Font
    }

    private ProjectDependency() {
    }

    public static ProjectDependency a(String str) {
        ProjectDependency projectDependency = new ProjectDependency();
        projectDependency.f3615a = Type.ThemeMusic;
        projectDependency.b = str;
        return projectDependency;
    }

    public static ProjectDependency b(String str) {
        ProjectDependency projectDependency = new ProjectDependency();
        projectDependency.f3615a = Type.Effect;
        projectDependency.b = str;
        return projectDependency;
    }

    public String a(Context context) {
        return String.valueOf(this.f3615a) + ": " + String.valueOf(this.b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProjectDependency)) {
            return false;
        }
        ProjectDependency projectDependency = (ProjectDependency) obj;
        if (projectDependency.f3615a == this.f3615a) {
            if (projectDependency.b == this.b) {
                return true;
            }
            if (this.b != null && projectDependency.b != null && projectDependency.b.equals(this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f3615a == null ? 0 : this.f3615a.hashCode()) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean a() {
        EffectLibrary e = KineMasterApplication.a().e();
        switch (this.f3615a) {
            case Effect:
                return e.c(this.b) != null;
            case Font:
                return e.f(this.b) != null;
            case ThemeMusic:
                return e.a(this.b, true) != null;
            default:
                return false;
        }
    }

    public boolean a(Theme theme) {
        switch (this.f3615a) {
            case Effect:
                return this.b != null && this.b.startsWith(theme.i());
            case Font:
                return false;
            case ThemeMusic:
                return this.b != null && this.b.equals(theme.i());
            default:
                return false;
        }
    }

    public boolean a(Font font) {
        switch (this.f3615a) {
            case Effect:
            case ThemeMusic:
            default:
                return false;
            case Font:
                return this.b != null && font.m().equals(this.b);
        }
    }
}

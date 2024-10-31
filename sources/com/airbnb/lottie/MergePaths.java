package com.airbnb.lottie;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class MergePaths {

    /* renamed from: a */
    private final String f7658a;

    /* renamed from: b */
    private final MergePathsMode f7659b;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode f(int i) {
            if (i == 1) {
                return Merge;
            }
            if (i == 2) {
                return Add;
            }
            if (i == 3) {
                return Subtract;
            }
            if (i == 4) {
                return Intersect;
            }
            if (i != 5) {
                return Merge;
            }
            return ExcludeIntersections;
        }
    }

    /* loaded from: classes.dex */
    static class a {
        public static MergePaths a(JSONObject jSONObject) {
            return new MergePaths(jSONObject.optString("nm"), MergePathsMode.f(jSONObject.optInt("mm", 1)));
        }
    }

    /* synthetic */ MergePaths(String str, MergePathsMode mergePathsMode, C0670ra c0670ra) {
        this(str, mergePathsMode);
    }

    public MergePathsMode a() {
        return this.f7659b;
    }

    public String b() {
        return this.f7658a;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f7659b + '}';
    }

    private MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f7658a = str;
        this.f7659b = mergePathsMode;
    }
}

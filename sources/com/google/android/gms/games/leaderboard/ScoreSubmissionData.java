package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ScoreSubmissionData {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f1384a = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String b;
    private int c;
    private HashMap<Integer, Result> d;

    /* loaded from: classes.dex */
    public static final class Result {

        /* renamed from: a, reason: collision with root package name */
        public final long f1385a;
        public final String b;
        public final String c;
        public final boolean d;

        public String toString() {
            return zzw.a(this).a("RawScore", Long.valueOf(this.f1385a)).a("FormattedScore", this.b).a("ScoreTag", this.c).a("NewBest", Boolean.valueOf(this.d)).toString();
        }
    }

    public String toString() {
        zzw.zza a2 = zzw.a(this).a("PlayerId", this.b).a("StatusCode", Integer.valueOf(this.c));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return a2.toString();
            }
            Result result = this.d.get(Integer.valueOf(i2));
            a2.a("TimesSpan", TimeSpan.a(i2));
            a2.a("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}

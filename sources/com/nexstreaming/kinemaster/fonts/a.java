package com.nexstreaming.kinemaster.fonts;

import android.graphics.Typeface;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BuiltInFonts.java */
/* loaded from: classes.dex */
public class a {
    public static List<Font> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new Font("system.robotothin", "android", Typeface.create("sans-serif-thin", 0), "Roboto Thin"), new Font("system.robotolight", "android", Typeface.create("sans-serif-light", 0), "Roboto Light"), new Font("system.droidsans", "android", Typeface.create("sans-serif", 0), "Roboto Regular"), new Font("system.droidsansb", "android", Typeface.create("sans-serif", 1), "Roboto Bold"), new Font("system.robotonthini", "android", Typeface.create("sans-serif-thin", 2), "Roboto Thin Italic"), new Font("system.robotolighti", "android", Typeface.create("sans-serif-light", 2), "Roboto Light Italic"), new Font("system.robotoi", "android", Typeface.create("sans-serif", 2), "Roboto Regular Italic"), new Font("system.robotobi", "android", Typeface.create("sans-serif", 3), "Roboto Bold Italic"), new Font("system.robotocond", "android", Typeface.create("sans-serif-condensed", 0), "Roboto Condensed Regular"), new Font("system.robotocondi", "android", Typeface.create("sans-serif-condensed", 2), "Roboto Condensed Italic"), new Font("system.robotocondb", "android", Typeface.create("sans-serif-condensed", 1), "Roboto Condensed Bold"), new Font("system.robotocondbi", "android", Typeface.create("sans-serif-condensed", 3), "Roboto Condensed Bold Italic"), new Font("system.droidserif", "android", Typeface.create(Typeface.SERIF, 0), "Noto Serif Regular"), new Font("system.droidserifb", "android", Typeface.create(Typeface.SERIF, 1), "Noto Serif Bold"), new Font("system.droidserifi", "android", Typeface.create(Typeface.SERIF, 2), "Noto Serif Italic"), new Font("system.droidserifbi", "android", Typeface.create(Typeface.SERIF, 3), "Noto Serif Bold Italic"), new Font("builtin.font.bevan", "latin", "bevan.ttf", "Bevan"), new Font("builtin.font.creepster", "latin", "creepster-regular.ttf", "Creepster"), new Font("builtin.font.sortsmillgoudyital", "latin", "goudy_stm_italic.ttf", "Sorts Mill Goudy Italic"), new Font("builtin.font.greatvibes", "latin", "greatvibes-regular.ttf", "Great Vibes"), new Font("builtin.font.junction", "latin", "junction.ttf", "Junction"), new Font("builtin.font.knewave", "latin", "knewave.ttf", "Knewave"), new Font("builtin.font.latobold", "latin", "lato-bold.ttf", "Lato Bold"), new Font("builtin.font.leaguegothic", "latin", "leaguegothic.ttf", "League Gothic"), new Font("builtin.font.leaguescriptthin", "latin", "leaguescript.ttf", "League Script"), new Font("builtin.font.lindenhillregular", "latin", "lindenhill.ttf", "Linden Hill"), new Font("builtin.font.orbitronbold", "latin", "orbitron-bold.ttf", "Orbitron Bold"), new Font("builtin.font.orbitronmedium", "latin", "orbitron-medium.ttf", "Orbitron Medium"), new Font("builtin.font.ralewaythin", "latin", "raleway_thin.ttf", "Raleway Thin"), new Font("builtin.font.redressedregular", "latin", "redressed.ttf", "Redressed"), new Font("builtin.font.sniglet", "latin", "sniglet.ttf", "Sniglet")));
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.addAll(Arrays.asList(new Font("system.robotomed", "android", Typeface.create("sans-serif-medium", 0), "Roboto Medium"), new Font("system.robotomedi", "android", Typeface.create("sans-serif-medium", 2), "Roboto Medium Italic"), new Font("system.robotoblk", "android", Typeface.create("sans-serif-black", 0), "Roboto Black"), new Font("system.robotoblki", "android", Typeface.create("sans-serif-black", 2), "Roboto Black Italic")));
            arrayList.addAll(Arrays.asList(new Font("system.cursive", "android", Typeface.create("cursive", 0), "Dancing Script Regular"), new Font("system.cursiveb", "android", Typeface.create("cursive", 1), "Dancing Script Bold"), new Font("system.mono", "android", Typeface.create("monospace", 0), "Droid Sans Mono")));
        }
        return arrayList;
    }
}

package com.nextreaming.nexvideoeditor;

import android.graphics.Typeface;
import com.nexstreaming.kinemaster.kmpackage.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: EffectResourceLoader.java */
/* loaded from: classes.dex */
public interface a {
    Typeface a(String str) throws Font.TypefaceLoadException;

    InputStream a(String str, String str2) throws IOException;

    File b(String str, String str2) throws IOException;
}

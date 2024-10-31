package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class PatternFilenameFilter implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    private final Pattern f2916a;

    @Override // java.io.FilenameFilter
    public boolean accept(@Nullable File file, String str) {
        return this.f2916a.matcher(str).matches();
    }
}

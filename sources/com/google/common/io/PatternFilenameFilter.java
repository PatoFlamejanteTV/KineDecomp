package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class PatternFilenameFilter implements FilenameFilter {

    /* renamed from: a */
    private final Pattern f15974a;

    @Override // java.io.FilenameFilter
    public boolean accept(@Nullable File file, String str) {
        return this.f15974a.matcher(str).matches();
    }
}

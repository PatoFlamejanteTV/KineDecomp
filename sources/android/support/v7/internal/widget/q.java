package android.support.v7.internal.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesWrapper.java */
/* loaded from: classes.dex */
class q extends Resources {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f184a;

    public q(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f184a = resources;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        return this.f184a.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        return this.f184a.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        return this.f184a.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        return this.f184a.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f184a.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        return this.f184a.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f184a.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        return this.f184a.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        return this.f184a.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        return this.f184a.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.f184a.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        return this.f184a.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        return this.f184a.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        return this.f184a.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        return this.f184a.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        return this.f184a.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f184a.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        return this.f184a.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return this.f184a.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        return this.f184a.getMovie(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return this.f184a.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return this.f184a.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.f184a.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        return this.f184a.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        return this.f184a.getLayout(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        return this.f184a.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.f184a.getXml(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        return this.f184a.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f184a.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        return this.f184a.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f184a.getValue(i, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f184a.getValueForDensity(i, i2, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f184a.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f184a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.f184a != null) {
            this.f184a.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f184a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f184a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f184a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.f184a.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.f184a.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.f184a.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.f184a.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f184a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f184a.parseBundleExtra(str, attributeSet, bundle);
    }
}

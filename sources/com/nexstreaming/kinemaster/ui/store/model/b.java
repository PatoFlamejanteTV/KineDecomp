package com.nexstreaming.kinemaster.ui.store.model;

import com.nexstreaming.app.general.nexasset.assetpackage.InstallSourceType;
import com.nexstreaming.app.general.nexasset.assetpackage.p;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import java.io.File;
import java.util.Map;

/* compiled from: Asset.java */
/* loaded from: classes2.dex */
public class b implements com.nexstreaming.app.general.nexasset.assetpackage.b {

    /* renamed from: a */
    private int f23643a;

    /* renamed from: b */
    private String f23644b;

    /* renamed from: c */
    private String f23645c;

    /* renamed from: d */
    private String f23646d;

    /* renamed from: e */
    private String f23647e;

    /* renamed from: f */
    private File f23648f;

    /* renamed from: g */
    private String f23649g;

    /* renamed from: h */
    private String f23650h;
    private String i;
    private com.nexstreaming.app.general.nexasset.assetpackage.a j;
    private p k;
    private Map<String, String> l;
    private int m;
    private boolean n;
    private InterfaceC1821j o;

    public void a(InterfaceC1821j interfaceC1821j) {
        this.o = interfaceC1821j;
    }

    public InterfaceC1821j b() {
        return this.o;
    }

    public void c(String str) {
        this.f23650h = str;
    }

    public void d(String str) {
        this.i = str;
    }

    public void e(String str) {
        this.f23647e = str;
    }

    public void f(String str) {
        this.f23646d = str;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getAssetId() {
        return this.f23644b;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public int getAssetIdx() {
        return this.f23643a;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public Map<String, String> getAssetName() {
        return this.l;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public int getAssetSize() {
        return this.m;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public p getAssetSubCategory() {
        return this.k;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getAssetUrl() {
        return this.f23645c;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public int getAssetVersion() {
        return 0;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public InstallSourceType getInstallSourceType() {
        return null;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public File getLocalPath() {
        return this.f23648f;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getPackageURI() {
        return this.f23649g;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getPriceType() {
        return this.f23650h;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getThumbPath() {
        return this.f23647e;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getThumbUrl() {
        return this.f23646d;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public boolean hasUpdate() {
        return false;
    }

    public String toString() {
        return "Asset{index=" + this.f23643a + ", id='" + this.f23644b + "', downloadURL='" + this.f23645c + "', thumbURL='" + this.f23646d + "', thumbPath='" + this.f23647e + "', localPath=" + this.f23648f + ", packageURI='" + this.f23649g + "', priceType='" + this.f23650h + "', productId='" + this.i + "', category=" + this.j + ", subCategory=" + this.k + ", name=" + this.l + ", size=" + this.m + ", isInstalled=" + this.n + ", storeAssetInfo=" + this.o + '}';
    }

    public void a(int i) {
        this.f23643a = i;
    }

    public void b(String str) {
        this.f23644b = str;
    }

    public boolean c() {
        return this.n;
    }

    public void a(String str) {
        this.f23645c = str;
    }

    public void b(int i) {
        this.m = i;
    }

    public void a(Map<String, String> map) {
        this.l = map;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public String a() {
        return this.i;
    }
}

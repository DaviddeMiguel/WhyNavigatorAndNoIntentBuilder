package com.meslize.whynavigatorandnointentbuilder.util;

import android.content.Context;

public class DexmakerDexcache {

    private static final String DEX_MAKER_DEX_CACHE = "dexmaker.dexcache";

    public void prepareEnvironment(Context context) {
        System.setProperty(DEX_MAKER_DEX_CACHE, context.getCacheDir().getPath());
    }
}

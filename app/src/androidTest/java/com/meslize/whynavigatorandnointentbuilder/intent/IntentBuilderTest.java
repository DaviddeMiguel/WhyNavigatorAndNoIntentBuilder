package com.meslize.whynavigatorandnointentbuilder.intent;

import android.app.Activity;
import android.content.Intent;
import android.test.AndroidTestCase;

import com.meslize.whynavigatorandnointentbuilder.next.MyNextActivity_;
import com.meslize.whynavigatorandnointentbuilder.util.DexmakerDexcache;

import static org.mockito.Mockito.mock;

public class IntentBuilderTest extends AndroidTestCase {

    private IntentBuilderImpl mBuilder;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        DexmakerDexcache dexmakerDexcache = new DexmakerDexcache();
        dexmakerDexcache.prepareEnvironment(getContext());

        mBuilder = new IntentBuilderImpl();
        mBuilder.mActivity = mock(Activity.class);
    }

    public void testBuildMyNextIntentReturnsIntentWithExtras() {
        String text = "Text";

        Intent result = mBuilder.buildMyNextIntent(text);

        assertEquals(text, result.getStringExtra(MyNextActivity_.M_TEXT_EXTRA));
    }
}

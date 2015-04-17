package com.meslize.whynavigatorandnointentbuilder.main;

import android.test.AndroidTestCase;

import com.meslize.whynavigatorandnointentbuilder.navigator.Navigator;
import com.meslize.whynavigatorandnointentbuilder.util.DexmakerDexcache;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class MainActivityTest extends AndroidTestCase {

    private MainActivity mActivity;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        DexmakerDexcache dexmakerDexcache = new DexmakerDexcache();
        dexmakerDexcache.prepareEnvironment(getContext());

        mActivity = new MainActivity();
        mActivity.mNavigator = mock(Navigator.class);
    }

    public void testClickNextInvokesNavigatorStartMyNextActivity() {
        mActivity.clickNext();

        verify(mActivity.mNavigator).startMyNextActivity(eq(mActivity.mExtraText));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mActivity.mNavigator);
    }
}

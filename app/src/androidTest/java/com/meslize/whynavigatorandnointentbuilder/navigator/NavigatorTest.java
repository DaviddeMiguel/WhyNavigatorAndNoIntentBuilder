package com.meslize.whynavigatorandnointentbuilder.navigator;

import android.app.Activity;
import android.content.Intent;
import android.test.AndroidTestCase;

import com.meslize.whynavigatorandnointentbuilder.next.MyNextActivity_;
import com.meslize.whynavigatorandnointentbuilder.util.DexmakerDexcache;

import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class NavigatorTest extends AndroidTestCase {

    private NavigatorImpl mNavigator;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        DexmakerDexcache dexmakerDexcache = new DexmakerDexcache();
        dexmakerDexcache.prepareEnvironment(getContext());

        mNavigator = new NavigatorImpl();
        mNavigator.mActivity = mock(Activity.class);
    }

    public void testFinishViewInvokesActivityFinish() {
        mNavigator.finishView();

        verify(mNavigator.mActivity).finish();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mNavigator.mActivity);
    }

    public void testStartMyNextActivityBuildIntentThenStartActivity() {
        String text = "Text";

        mNavigator.startMyNextActivity(text);

        ArgumentCaptor<Intent> captor = ArgumentCaptor.forClass(Intent.class);
        verify(mNavigator.mActivity).startActivity(captor.capture());

        assertEquals(text, captor.getValue().getStringExtra(MyNextActivity_.M_TEXT_EXTRA));
    }
}

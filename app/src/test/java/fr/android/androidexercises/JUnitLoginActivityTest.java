package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

@RunWith(CustomRobolectricTestRunner.class)
public class JUnitLoginActivityTest {

    LoginActivity activity;

    @Before
    public void setUp() throws Exception{
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_set__logged_state() throws Exception{
        activity.logged();
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void should_set__unlogged_state() throws Exception{
        activity.notLogged();
        Assertions.assertThat(activity.loginLayout).isVisible();
    }

}
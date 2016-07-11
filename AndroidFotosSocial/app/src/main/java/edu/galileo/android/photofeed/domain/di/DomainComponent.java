package edu.galileo.android.photofeed.domain.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.photofeed.PhotoFeedAppModule;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {DomainModule.class, PhotoFeedAppModule.class})
public interface DomainComponent {
}

package uansari.moviester.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uansari.moviester.api.TMDBApi
import uansari.moviester.repositories.ApiRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun getRepository(tmdbApi: TMDBApi) = ApiRepository(tmdbApi)
}
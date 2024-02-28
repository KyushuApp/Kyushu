package app.kyushu.kyushu.di

import app.kyushu.kyushu.domain.repository.AppRepository
import app.kyushu.kyushu.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppUseCases(repository: AppRepository): AppUseCases {
        return AppUseCases(
            getListOfData = GetListOfData(repository),
            deleteData = DeleteData(repository),
            addData = AddData(repository),
            getData = GetData(repository)
        )
    }
}
package app.kyushu.kyushu.di

import android.app.Application
import androidx.room.Room
import app.kyushu.kyushu.data.data_source.local.AppDatabase
import app.kyushu.kyushu.data.data_source.local.AppEntityMapper
import app.kyushu.kyushu.data.data_source.remote.AppDtoMapper
import app.kyushu.kyushu.data.data_source.remote.RetrofitService
import app.kyushu.kyushu.data.repository.AppRepositoryImpl
import app.kyushu.kyushu.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideAppDtoMapper() = AppDtoMapper()


    @Provides
    @Singleton
    fun provideAppEntityMapper() = AppEntityMapper()


    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideEntityRepository(
        db: AppDatabase,
        retrofitService: RetrofitService,
        dtoMapper: AppDtoMapper,
        entityMapper: AppEntityMapper,
    ): AppRepository {
        return AppRepositoryImpl(db.appDao, retrofitService, dtoMapper, entityMapper)
    }

}
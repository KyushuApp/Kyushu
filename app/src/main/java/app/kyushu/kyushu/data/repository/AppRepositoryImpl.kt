package app.kyushu.kyushu.data.repository

import app.kyushu.kyushu.data.data_source.local.AppDao
import app.kyushu.kyushu.data.data_source.local.AppEntityMapper
import app.kyushu.kyushu.data.data_source.remote.AppDtoMapper
import app.kyushu.kyushu.data.data_source.remote.RetrofitService
import app.kyushu.kyushu.domain.model.AppDomainModel
import app.kyushu.kyushu.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl(
    private val dao: AppDao,
    private val retrofitService: RetrofitService,
    private val dtoMapper: AppDtoMapper,
    private val entityMapper: AppEntityMapper,
) : AppRepository {

    override fun getData(): Flow<List<AppDomainModel>> = flow {
        val response = dao.getEntities()
        emit(entityMapper.fromEntityList(response.first()))
    }

    override suspend fun getDataById(id: Int): AppDomainModel? {
        dao.getEntityById(id)?.let {
            return entityMapper.mapToDomainModel(it)
        } ?: return null
    }

    override suspend fun insertData(data: AppDomainModel) {
        dao.insertEntity(entityMapper.mapFromDomainModel(data))
    }

    override suspend fun deleteData(data: AppDomainModel) {
        dao.deleteEntity(entityMapper.mapFromDomainModel(data))
    }
}
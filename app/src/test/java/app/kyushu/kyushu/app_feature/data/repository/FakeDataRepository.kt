package app.kyushu.kyushu.app_feature.data.repository

import app.kyushu.kyushu.data.data_source.remote.RetrofitService
import app.kyushu.kyushu.domain.model.AppDomainModel
import app.kyushu.kyushu.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeDataRepository(
    private val retrofitService: RetrofitService
) : AppRepository {

    private val data = mutableListOf<AppDomainModel>()

    override fun getData(): Flow<List<AppDomainModel>> = flowOf(data)

    override suspend fun getDataById(id: Int): AppDomainModel? {
        return data.find { it.id == id }
    }

    override suspend fun insertData(data: AppDomainModel) {
        this.data.add(data)
    }

    override suspend fun deleteData(data: AppDomainModel) {
        this.data.remove(data)
    }
}
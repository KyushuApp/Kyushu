package app.kyushu.kyushu.domain.repository

import app.kyushu.kyushu.domain.model.AppDomainModel
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getData(): Flow<List<AppDomainModel>>

    suspend fun getDataById(id: Int): AppDomainModel?

    suspend fun insertData(data: AppDomainModel)

    suspend fun deleteData(data: AppDomainModel)
}
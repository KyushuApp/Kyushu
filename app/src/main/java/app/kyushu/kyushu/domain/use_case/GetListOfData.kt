package app.kyushu.kyushu.domain.use_case

import app.kyushu.kyushu.domain.model.AppDomainModel
import app.kyushu.kyushu.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class GetListOfData(
    private val repository: AppRepository
) {
    operator fun invoke(): Flow<List<AppDomainModel>> {
        return repository.getData()
    }
}
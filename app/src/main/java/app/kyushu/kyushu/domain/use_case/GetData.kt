package app.kyushu.kyushu.domain.use_case

import app.kyushu.kyushu.domain.model.AppDomainModel
import app.kyushu.kyushu.domain.repository.AppRepository

class GetData(
    private val repository: AppRepository
) {

    suspend operator fun invoke(id: Int): AppDomainModel? {
        return repository.getDataById(id)
    }
}
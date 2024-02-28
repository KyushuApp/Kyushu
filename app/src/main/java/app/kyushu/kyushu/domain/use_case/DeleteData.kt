package app.kyushu.kyushu.domain.use_case

import app.kyushu.kyushu.domain.model.AppDomainModel
import app.kyushu.kyushu.domain.repository.AppRepository

class DeleteData(
    private val repository: AppRepository
) {

    suspend operator fun invoke(data: AppDomainModel) {
        repository.deleteData(data)
    }
}
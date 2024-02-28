package app.kyushu.kyushu.domain.use_case

import app.kyushu.kyushu.data.data_source.local.InvalidDataException
import app.kyushu.kyushu.domain.model.AppDomainModel
import app.kyushu.kyushu.domain.repository.AppRepository

class AddData(
    private val repository: AppRepository
) {

    @Throws(InvalidDataException::class)
    suspend operator fun invoke(data: AppDomainModel) {
        if (data.title.isBlank()) {
            throw InvalidDataException("The title of the entity can't be empty.")
        }
        repository.insertData(data)
    }
}
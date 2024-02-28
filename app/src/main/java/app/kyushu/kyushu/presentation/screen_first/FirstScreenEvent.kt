package app.kyushu.kyushu.presentation.screen_first

import app.kyushu.kyushu.domain.model.AppDomainModel

sealed class FirstScreenEvent {
    data object GetData : FirstScreenEvent()
    data class DeleteData(val appEntity: AppDomainModel) : FirstScreenEvent()
}

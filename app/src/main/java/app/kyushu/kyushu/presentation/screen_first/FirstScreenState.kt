package app.kyushu.kyushu.presentation.screen_first

import app.kyushu.kyushu.domain.model.AppDomainModel

data class FirstScreenState(
    val data: List<AppDomainModel> = emptyList(),
)
package app.kyushu.kyushu.domain.use_case

data class AppUseCases(
    val getListOfData: GetListOfData,
    val deleteData: DeleteData,
    val addData: AddData,
    val getData: GetData
)

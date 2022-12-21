class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = if (value < 0) {
                0
            } else if (value > defaultPopulation) {
                defaultPopulation
            } else {
                value
            }
        }
    val defaultPopulation = 50_000_000

}
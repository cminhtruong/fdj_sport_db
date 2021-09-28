package app.el_even.fdj.domain.model

data class Team(
    val id: String,
    val name: String,
    val fullName: String,
    val league: String,
    val stadium: String,
    val nickname: String,
    val description: String,
    val banner: String,
    val location: String,
    val badge: String
)
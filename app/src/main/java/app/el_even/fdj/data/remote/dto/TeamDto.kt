package app.el_even.fdj.data.remote.dto

import app.el_even.fdj.domain.model.Team

data class TeamDto(
    val idAPIfootball: String,
    val idLeague: String,
    val idLeague2: String,
    val idLeague3: String,
    val idLeague4: Any,
    val idLeague5: Any,
    val idLeague6: Any,
    val idLeague7: Any,
    val idSoccerXML: String,
    val idTeam: String,
    val intFormedYear: String,
    val intLoved: String,
    val intStadiumCapacity: String,
    val strAlternate: String,
    val strCountry: String,
    val strDescriptionCN: Any,
    val strDescriptionDE: String,
    val strDescriptionEN: String,
    val strDescriptionES: String,
    val strDescriptionFR: String,
    val strDescriptionHU: Any,
    val strDescriptionIL: Any,
    val strDescriptionIT: String,
    val strDescriptionJP: String,
    val strDescriptionNL: Any,
    val strDescriptionNO: String,
    val strDescriptionPL: Any,
    val strDescriptionPT: String,
    val strDescriptionRU: String,
    val strDescriptionSE: Any,
    val strDivision: Any,
    val strFacebook: String,
    val strGender: String,
    val strInstagram: String,
    val strKeywords: String,
    val strLeague: String,
    val strLeague2: String,
    val strLeague3: String,
    val strLeague4: String,
    val strLeague5: String,
    val strLeague6: String,
    val strLeague7: String,
    val strLocked: String,
    val strManager: String,
    val strRSS: String,
    val strSport: String,
    val strStadium: String,
    val strStadiumDescription: String,
    val strStadiumLocation: String,
    val strStadiumThumb: String,
    val strTeam: String,
    val strTeamBadge: String,
    val strTeamBanner: String,
    val strTeamFanart1: String,
    val strTeamFanart2: String,
    val strTeamFanart3: String,
    val strTeamFanart4: String,
    val strTeamJersey: String,
    val strTeamLogo: String,
    val strTeamShort: String,
    val strTwitter: String,
    val strWebsite: String,
    val strYoutube: String
)

fun TeamDto.toTeam(): Team = Team(
    id = idAPIfootball,
    name = strTeam,
    fullName = strAlternate,
    league = strLeague,
    stadium = strStadium,
    nickname = strKeywords,
    description = strDescriptionEN,
    banner = strTeamBanner,
    location = strCountry,
    badge = strTeamBadge
)
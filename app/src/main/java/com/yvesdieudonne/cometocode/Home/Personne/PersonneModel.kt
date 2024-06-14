package com.yvesdieudonne.cometocode.Home.Personne

import java.time.LocalDateTime

data class PersonneModel(
    var nomPrenom: String,
    var DateDisparition: String,
    var displayText:String,
    var prime:Long,
    var Description: String,
    var Contact: String,
    var photoLists: MutableList<Int>,
    var DernierLieu:String = "Zone du bois, Ouagadougou"
)

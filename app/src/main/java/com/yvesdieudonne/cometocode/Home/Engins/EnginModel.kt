package com.yvesdieudonne.cometocode.Home.Engins

data class EnginModel(
    var Imatriculation: String,
    var DateDisparition: String,
    var displayText:String,
    var prime:Long,
    var Description: String,
    var Contact: String,
    var photoLists: MutableList<Int>,
    var DernierLieu: String = "Belle ville ,Bobo Dioulasso"
)

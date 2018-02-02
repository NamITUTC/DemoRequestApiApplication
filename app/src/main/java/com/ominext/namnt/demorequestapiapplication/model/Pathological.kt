package com.ominext.namnt.demorequestapiapplication.model

/**
 * Created by nam on 02/02/2018.
 */
data class Pathological(var id: Int?, var title: String?, var detail: String?) {
    override fun toString(): String {
        return "($id,$title,$detail)"
    }
}
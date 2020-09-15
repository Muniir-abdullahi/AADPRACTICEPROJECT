package com.example.aadpracticeproject.ApiServices.model

import com.google.gson.annotations.SerializedName

data class SkillIQLearnersResponse(
    @SerializedName("name") var name : String,
    @SerializedName("score") var score : Int,
    @SerializedName("country") var country : String,
    @SerializedName("badgeUrl") var badgeUrl : String
)


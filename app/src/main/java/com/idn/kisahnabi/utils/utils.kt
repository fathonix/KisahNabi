package com.idn.kisahnabi.utils

fun fromHttpToHttpsString(httpString: String?): String? {
    if (httpString == null || !httpString.startsWith("http")) return null

    return StringBuilder(httpString).insert(4, "s").toString();
}
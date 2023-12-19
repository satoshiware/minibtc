import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

class ExchangeRules(rules: String) {
    private val minOrder: Long // Minimum amount of satoshis that can be traded????????????? We need to add an extra two digits to this ?????????
    private val makerFee: Int // Maker fee rate (percent * 1000)
    private val takerFee: Int // Taker fee rate (percent * 1000)
    private val timeValid: Long // Maximum time (seconds) an order is valid?????????????????nah, let's remove this one
    private val tiers = ArrayList<Tier>()

    init { // May throw NullPointerException, IllegalArgumentException, IllegalStateException, JsonDecodingException, or NumberFormatException
        val jRules = Json.parseToJsonElement(rules)
        minOrder = jRules.jsonObject["minOrder"]!!.jsonPrimitive.long
        makerFee = jRules.jsonObject["makerFee"]!!.jsonPrimitive.int
        takerFee = jRules.jsonObject["takerFee"]!!.jsonPrimitive.int
        timeValid = jRules.jsonObject["timeValid"]!!.jsonPrimitive.long
        if (makerFee > 100000 || takerFee > 100000) throw IllegalArgumentException("Maker/Taker fee greater than 100000 (100%)!")
        if (minOrder <= 0 || makerFee < 0 || takerFee < 0 || timeValid < 0) throw IllegalArgumentException("Negative number not allowed!")

        val jTiers = jRules.jsonObject["tiers"]!!.jsonArray
        for (tier in jTiers) {
            val vol = tier.jsonObject["volume"]!!.jsonPrimitive.long
            val maker = tier.jsonObject["makerFee"]!!.jsonPrimitive.int
            val taker = tier.jsonObject["takerFee"]!!.jsonPrimitive.int

            if (maker > 100000 || taker > 100000) throw IllegalArgumentException("Maker/Taker fee greater than 100000 (100%)!")
            if (vol <= 0 || maker < 0 || taker < 0) throw IllegalArgumentException("Negative number not allowed!")
            if (tiers.size > 0 && tiers[tiers.size - 1].volume >= vol) throw IllegalStateException("The tier volumes are not in ascending order!")
            tiers.add(Tier(vol, maker, taker))
        }
    }

    fun getMinOrder(): Long {
        return minOrder
    }

    fun getMakerFee(volume: Long): Int {
        for (tier in tiers.reversed())
            if (volume >= tier.volume)
                return tier.makerFee
        return makerFee
    }

    fun getTakerFee(volume: Long): Int {
        for (tier in tiers.reversed())
            if (volume >= tier.volume)
                return tier.takerFee
        return takerFee
    }

    fun toJsonString(pretty: Boolean = false): String {
        val prettyJson = Json { // this returns the JsonBuilder
            prettyPrint = pretty
        }
        return prettyJson.encodeToString(thisJsonObject())
    }

    fun isEqual(other: ExchangeRules): Boolean {
        return this.toJsonString().compareTo(other.toJsonString()) == 0
    }

    private fun thisJsonObject(): JsonObject {
        return buildJsonObject() {
            put("minOrder", minOrder)
            put("makerFee", makerFee)
            put("takerFee", takerFee)
            putJsonArray("tiers") {
                for (tier in tiers)
                    addJsonObject {
                        put("volume", tier.volume)
                        put("makerFee", tier.makerFee)
                        put("takerFee", tier.takerFee)
                    }
            }
        }
    }
}

private data class Tier(val volume: Long, val makerFee: Int, val takerFee: Int)
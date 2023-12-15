import kotlinx.serialization.*
import kotlinx.serialization.json.*

class ExchangeRules(private val rules: String) {
    private var minOrder: Long = 0
    private var makerFee: Double = 0.0
    private var takerFee: Double = 0.0
    private var tiers: Tier

    init {
        val jRules = Json.parseToJsonElement(rules)
        val minOrder = jRules.jsonObject["minOrder"].jsonPrimitive?.long //!!null pointer exception in kotlin
        val makerFee = jRules.jsonObject["makerFee"]!!.jsonPrimitive?.double //!!null pointer exception in kotlin
        val takerFee = jRules.jsonObject["makerFee"]!!.jsonPrimitive?.double //!!null pointer exception in kotlin
        val tiers = jRules.jsonObject["tiers"]!!.jsonArray //!!null pointer exception in kotlin // what's the datatype here??


        tiers = Tier(0,0,0)
    }

    y = arrayOf("Nile", "Amazon", "Yangtze")
    Tier

    //So, I would like to do an array of the following
    //volume, makerFee, TakerFee.

    // okay, we can pass it with a datastructure and just store it.
    //ok what shall we do?

    // array
    //    index, 3 numbers... do we make it a sorted list
    // Long

    // volume, makerFee, takerFee
    // amount, makerFee, takerFee
    // amount, makerFee, takerFee
    // amount, makerFee, takerFee
    // amount, makerFee, takerFee
    // ..
    // ..
// This is just a dataset, but what does it look like

    fun getMinOrder(): Long {
        return minOrder
    }
    fun getMakerFee(volume: Long): Double {
        return makerFee
    }
    fun getTakerFee(volume: Long): Double {
        return takerFee
    }
}



private data class Tier(public val tierMinAmount: Long, public val tierMakerFee: Long, public val tierTakerFee: Long)
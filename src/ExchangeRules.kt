import kotlinx.serialization.json.*

class ExchangeRules(private val rules: String) {
    private var minOrder: Long
    private var makerFee: Double
    private var takerFee: Double
    private var tiers: Tier // <<<<<<<<<<<<<<<<<<<<< Make it an array.

    init {
        val jRules = Json.parseToJsonElement(rules)
        minOrder = jRules.jsonObject["minOrder"]!!.jsonPrimitive.long // We asked it to throw an exception.
        makerFee = jRules.jsonObject["makerFee"]!!.jsonPrimitive.double
        takerFee = jRules.jsonObject["takerFee"]!!.jsonPrimitive.double
        val _tiers = jRules.jsonObject["tiers"]!!.jsonArray

        // tiers an array todo
        for (tier in _tiers) {
            val min = tier.jsonObject["minVolume"]!!.jsonPrimitive.long,
            val maker = tier.jsonObject["makerFee"]!!.jsonPrimitive.long
            val taker = tier.jsonObject["takerFee"]!!.jsonPrimitive.long

            tiers =
            val hf = Tier(min, maker, taker)
        }

     //   tiers = Tier(0,0,0)
    }

    //y = arrayOf("Nile", "Amazon", "Yangtze")
    //Tier

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
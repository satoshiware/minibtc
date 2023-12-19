import java.sql.Connection
class UserFees(private val feesDB: Connection) {
    private var isReady: Boolean = false

    // So, there is a memory map that can pull where each user lies.
    // There's load mode
    // There's minus mode
    // There's audit mode.

//    var dData: HashMap<K, V>
    //Array
        // userID, total volumne
  //          Array // asset, data earliest time, sub_total volume.


  ///  [index][]


    // creating empty arraylist using constructor
//    var volu=ArrayList<Long><String>()

//    fun getMakerFee(userID: Long) {
//        isOn = false
 //   }

//    fun getTakerFee(userID: Long) {
//        isOn = false
//    }

//    fun addVolume(userID: Long, amount: Long) {
        // Well, we don't know what asset we are looking at. Yet, it get's it updated real quick.
        // maybe we better mark the asset it is .
    //   }


    // Ok, when I think of the database, we should add each trade.
    // The question, what if multiple trades get added.
    // Ok, we have the "rules" sheet. and rolling volumne is available in the exchange.


 }
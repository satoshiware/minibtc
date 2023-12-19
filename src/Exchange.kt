// Could we simply pass it the handle to the server with credentials and stuff already prepped????
// Not sure? Program a bugger or something.

import java.sql.Connection

class Exchange(private var minOrder: Int, private val exchDB: Connection, private val feesDB: Connection) {


    val rules = """
    {
        "minOrder": 1000,
        "makerFee": 160,
        "takerFee": 260,
        "timeValid": 31536000,
        "tiers": [
            {
                "volume": 50000,
                "makerFee": 140,
                "takerFee": 240
            },
            {
                "volume": 100000,
                "makerFee": 120,
                "takerFee": 220
            },
            {
                "volume": 250000,
                "makerFee": 100,
                "takerFee": 200
            },
            {
                "volume": 500000,
                "makerFee": 80,
                "takerFee": 180
            },
            {
                "volume": 1000000,
                "makerFee": 60,
                "takerFee": 160
            },
            {
                "volume": 2500000,
                "makerFee": 40,
                "takerFee": 140
            },
            {
                "volume": 5000000,
                "makerFee": 20,
                "takerFee": 120
            },
            {
                "volume": 10000000,
                "makerFee": 0,
                "takerFee": 100
            }
        ]
    } """

    val ddrules = ExchangeRules(rules)

    Orderbook

// New trades are added to your 30 day volume immediately, but trades older than 30 days are only removed every few hours. This means that sometimes you might temporarily get a lower fee than you should, but you won't get a higher fee than you should.
// Question, does it apply accross all assets??? Ok, we are doing it just for account. Now, they makes updating it a pain?
    // Well, How do we do it??

    init {
        // So, each exchange has an order book (buy, sell)
        // Each exchange has a Trade book.

        //minimumOrder
    }

    // What is the presicion?

    fun buy(id: Int, amount: Long, price: Long) {
//        isOn = false
    }

    fun sell(id: Int, amount: Long, price: Long) {
        //isOn = false
        // It could return the ID? How much was executed etc.
    }
}

// Well, they are float, but we need presicion. Everytime!! what do we do here?


//Bitcoin, for example
        // UTF8 defult charcter set for mariaDB. User: root, password: MariaDB
        // Servicee Name: MariaDB
        // TCP Port: 3306
        // Buffer pool size: 8155 MB
        // Page size: 16 KB


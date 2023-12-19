
import java.sql.Statement
import java.sql.Connection
import java.sql.DriverManager

////TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {

    val rules =
        """
            {
                "minOrder": 1000,
                "makerFee": 160,
                "takerFee": 260,
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
            }
        """

  val exRules = ExchangeRules(rules)

    println(exRules.getMinOrder())

    println(); println(0)
    println(exRules.getMakerFee(0))
    println(exRules.getTakerFee(0))

    println(); println(40000)
    println(exRules.getMakerFee(40000))
    println(exRules.getTakerFee(40000))

    println(); println(70000)
    println(exRules.getMakerFee(70000))
    println(exRules.getTakerFee(70000))

    println(); println(180000)
    println(exRules.getMakerFee(180000))
    println(exRules.getTakerFee(180000))

    println(); println(275000)
    println(exRules.getMakerFee(275000))
    println(exRules.getTakerFee(275000))

    println(); println(800000)
    println(exRules.getMakerFee(800000))
    println(exRules.getTakerFee(800000))

    println(); println(1800000)
    println(exRules.getMakerFee(1800000))
    println(exRules.getTakerFee(1800000))

    println(); println(3000000)
    println(exRules.getMakerFee(3000000))
    println(exRules.getTakerFee(3000000))

    println(); println(7000000)
    println(exRules.getMakerFee(7000000))
    println(exRules.getTakerFee(7000000))

    println(); println(17000000)
    println(exRules.getMakerFee(17000000))
    println(exRules.getTakerFee(17000000))

  println(); println(exRules.toJsonString())
  println(); println(exRules.toJsonString(true))

  println(); println(exRules.isEqual(ExchangeRules(exRules.toJsonString(true))))
  println(); println(exRules.isEqual(ExchangeRules(exRules.toJsonString())))

  println(); println(ExchangeRules(exRules.toJsonString()).isEqual(exRules))
  println(); println(ExchangeRules(exRules.toJsonString(true)).isEqual(exRules))



//    val name = "Kotlin"
//    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
//    println("Hello, " + name + "!")

//    //TIP click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    // To <b>Run</b> code, press <shortcut actionId="Run"/> or
//    for (i in 1..5) {
//        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        println("i = $i")
//    }

 ///   println("Hello World")

//    val jdbcUrl = "jdbc:mysql:3306//localhost:/exchanges"

/*
    val connection: Connection = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/exchange_usd",
        "root", "MariaDB"
    )

    //try {
        val connection2: Connection = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/exchange_usd",
            "root", "MariaDB"
        )

        val stmt: Statement = connection2.createStatement()

        val sql = "CREATE TABLE buy" +
                "(id UNSIGNED????? INTEGER not NULL, " +
                " customer_id INTEGER not NULL, " +
                " amount BIGINT not NULL, " +
                " price BIGINT, " +
                " price INTEGER, " +
                " PRIMARY KEY ( id ))"

        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");

   // } catch (SQLException e) {
  //      e.printStackTrace();
  //  }




    println(connection.clientInfo)
    println(connection2.clientInfo)

    connection.close();
*/
}
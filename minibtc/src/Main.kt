
import java.sql.Statement
import java.sql.Connection
import java.sql.DriverManager

////TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
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

    println("Hello World")

//    val jdbcUrl = "jdbc:mysql:3306//localhost:/exchanges"


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

}
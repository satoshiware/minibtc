// Philosophy: Order book is built assuming sufficient memory. is that ok?
// Philosophy: database is doubly linked, don't be afraid to add another column. more data the better.

class OrderBook() {
    val BUY: Boolean = true;
    val SELL: Boolean = false;

    var buyOrders: Order? = null; private set
    var sellOrders: Order? = null; private set

    var buyQTY: Long; private set
    var sellQTY: Long; private set

    init {
        buyQTY = 0
        sellQTY = 0
    }

    fun add(order: Order) {
        if(order.type == BUY) {
            try {
                buyOrders!!.insert(order)
                if(buyOrders!!.right === order)
                    buyOrders = order
            } catch (e: NullPointerException) {
                buyOrders = order
            }
        } else {
            try {
                sellOrders!!.insert(order)
                if(sellOrders!!.left === order)
                    sellOrders = order
            } catch (e: NullPointerException) {
                sellOrders = order
            }
        }
    }

    fun slippage(type: Boolean, amount: Long) {
        if(type == BUY) {
            //buyOrders.amount
        } else {

        }


    }

    // Remove an order
    fun remove(order_id: Long, price: Long = 0) {
      //  first
    }

    private fun search(price: Long) {


    //    return lastInsertion;
    }




    //: Boolean // what if we too full??
    // remove an order(Order_ID: Long, Price:Long = 0) // add price to make it fast
    // Contains_Order(order_id, Price: Long = 0): Boolean // add price to make it fast

    // Get orders(val limit, val amount: Long)




    class Order(val orderID: Long, val userID: Long, val type: Boolean, val price: Long, amount: Long) {
        var amount: Long; private set
        internal var left: Order? = null; private set
        internal var right: Order? = null; private set
        var offspring: Order? = null; private set

        init {
            this.amount = amount
        }

        internal fun insert(order: Order) {
            if (type.xor(order.price > this.price)) {
                if (this.right == null) {
                    this.right = order
                    order.left = this
                } else if (type.xor(order.price < this.right!!.price)) {
                    order.right = this.right
                    this.right = order
                    order.left = this
                    order.right = order
                } else {
                    this.right!!.insert(order)
                }
            } else if (type.xor(order.price < this.price)) {
                if (this.left == null) {
                    this.left = order
                    order.right = this
                } else if (type.xor(order.price > this.left!!.price)) {
                    order.left = this.left
                    this.left = order
                    order.right = this
                    order.left = order
                } else {
                    this.left!!.insert(order)
                }
            } else {
                this.amount += order.amount
                if (this.offspring == null) {
                    this.offspring = order
                } else {
                    this.offspring!!.insert(order)
                }
            }
        }

        internal fun remove() {
            if (this.offspring == null) {
                if (this.left != null) {
                    this.left!!.right = this.right
                }
                if (this.right != null) {
                    this.right!!.left = this.left
                }
            } else {
                this.offspring!!.left = this.left
                this.left?.right = this.offspring
                this.offspring!!.right = this.right
                this.right?.left = this.offspring
            }
        }

        //    fun find(price: Long): Order? = when {
//        this.price > price -> price?.findByPrice(price)
//        this.price < price -> right?.findByPrice(price)
//        else -> this
//    }

        internal fun find(orderID: Long): Order? {
            if (this.orderID == orderID)
                return this
            else if (if (this.type) this.left == null else this.right == null)
                return null
            else
                return if (this.type) this.left!!.find(orderID) else this.right!!.find(orderID)
        }

        internal fun slippage(amount: Long): Long {
            if (this.type) {
                if (amount > this.amount)
                    if (this.right != null)
                        return this.right?.slippage(price)
                    else
                        return
                else
                    return this.price
            } else {
                if (amount > this.amount)
                    if (this.right != null)
                        return this.right?.slippage(price)
                    else
                        return
                else
                    return this.price


            }


            this

            if (this.orderID == orderID)
                return this
            else if (if (this.type) this.left == null else this.right == null)
                return null
            else
                return if (this.type) this.left!!.find(orderID) else this.right!!.find(orderID)
        }
    }
}
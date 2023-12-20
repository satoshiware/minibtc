// Philosophy: Order book is built assuming sufficient memory. is that ok?
// Philosophy: database is doubly linked, don't be afraid to add another column. more data the better.

class OrderBook() {
    val BUY: Boolean = true;
    val SELL: Boolean = true;

    var buyOrders: Order? = null; private set
    var sellOrders: Order? = null; private set

    var buyQTY: Long; private set
    var sellQTY: Long; private set

    init {
        buyQTY = 0
        sellQTY = 0
    }

    fun add(order: Order, type: Boolean) {
        if(type == BUY) {
            try {
                buyOrders = buyOrders!!.insert(order)
            } catch (e: NullPointerException) {
                buyOrders = order
            }
        } else {
            try {
                sellOrders = sellOrders!!.insert(order)
            } catch (e: NullPointerException) {
                sellOrders = order
            }
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




    class Order(val orderID: Long, val userID: Long, val price: Long, amount: Long) {
        var amount: Long; private set
        private var left: Order? = null
        private var right: Order? = null
        var child: Order? = null; private set

        init {
            this.amount = amount
        }

        internal fun insert(order: Order) {
            if (order.price > this.price) {
                if (this.right == null) {
                    this.right = order
                    order.left = this
                } else if (order.price < this.right!!.price) {
                    order.right = this.right
                    this.right = order
                    order.left = this
                    order.right = order
                } else {
                    this.right!!.insert(order)
                }
            } else if (order.price < this.price) {
                if (this.left == null) {
                    this.left = order
                    order.right = this
                } else if (order.price > this.left!!.price) {
                    order.left = this.left
                    this.left = order
                    order.right = this
                    order.left = order
                } else {
                    this.left!!.insert(order)
                }
            } else {
                this.amount += order.amount
                if (this.child == null) {
                    this.child = order
                } else {
                    this.child!!.insert(order)
                }
            }
        }

        internal fun remove() {
            if (this.child == null) {
                if (this.left != null) {
                    this.left!!.right = this.right
                }
                if (this.right != null) {
                    this.right!!.left = this.left
                }
            } else {
                this.child!!.left = this.left
                this.left?.right = this.child
                this.child!!.right = this.right
                this.right?.left = this.child
            }
        }

        //    fun find(price: Long): Order? = when {
//        this.price > price -> price?.findByPrice(price)
//        this.price < price -> right?.findByPrice(price)
//        else -> this
//    }
        private fun find(orderID: Long): Order? {
            if (this.orderID == orderID)
                return this
            else if (this.right == null)
                return null
            else
                return this.right!!.find(orderID)
        }
    }
}
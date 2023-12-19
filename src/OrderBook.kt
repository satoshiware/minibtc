class OrderBook {

    // Add an order, execute an order




}



private class Order(val price: Long, var amount: Long, val id: Long) {
    var left: Order? = null
    var right: Order? = null
    var child: Order? = null

    fun insert(order: Order) {
        if (order.price > this.price) {
            if (this.right == null) {
                this.right = order
            } else {
                this.right!!.insert(order)
            }
        } else if (order.price < this.price) {
            if (this.left == null) {
                this.left = order
            } else {
                this.left!!.insert(order)
            }
        } else {
            this.amount += order.amount
            if (this.sibling == null) {
                this.sibling = order
            } else {
                this.sibling!!.insert(order)
            }
        }
    }

    fun delete(order: Order) {
        when {
            order.price > this.price -> scan(value, this.right, this)
            order.price < this.price -> scan(value, this.left, this)
            else -> removeOrder(this, null)
        }
    }

/*
    fun find(price: Long): Order? = when {
        this.price > price -> price?.findByPrice(price)
        this.price < price -> right?.findByPrice(price)
        else -> this
    }
*/




    // If both child nodes are null, this case is quite simple to handle and it is the only one in which we may fail to eliminate the node: if the node is a root one, we can not eliminate it. Otherwise, it is enough to set to null the parent’s corresponding child.
    private fun removeNoChildOrder(order: Order, parent: Order?) {
        if (parent == null) {
            throw IllegalStateException("Can not remove the root node without child nodes")
        }
        if (order == parent.left) {
            parent.left = null
        } else if (order == parent.right) {
            parent.right = null
        }
    }

    //One child is null, the other is not null In this case, we should always succeed as it is enough to “shift” the only child node into the node that we are removing:
    private fun removeSingleChildOrder(parent: Order, child: Order) {
        parent.price = child.price
        parent.left = child.left
        parent.right = child.right
    }

    //Both child nodes are not null
    //This case is more intricate as we should find a node that is to replace the node we want to remove. One way to find this “replacement” node is to pick a node in the left subtree with the biggest key (it for sure exists). Another way is a symmetric one: we should pick a node in the right subtree with the smallest key (it exists as well). Here, we choose the first one:
    private fun removeTwoChildOrder(order: Order) {
        val leftChild = order.left!!
        leftChild.right?.let {
            val maxParent = findParentOfMaxChild(leftChild)
            maxParent.right?.let {
                order.price = it.price
                maxParent.right = null
            } ?: throw IllegalStateException("Node with max child must have the right child!")
        } ?: run {
            order.price = leftChild.price
            order.left = leftChild.left
        }
    }
}
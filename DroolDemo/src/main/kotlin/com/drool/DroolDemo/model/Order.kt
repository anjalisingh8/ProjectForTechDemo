package com.drool.DroolDemo.model

class Order {

    private var name : String
    private var cardType :String
    private var price : Double
    private var discount : Double

    constructor(name :String , cardType :String,price:Double,discount : Double){
        this.name = name
        this.price = price
        this.cardType = cardType
        this.discount = discount
    }

    fun getName() :String = name
    fun setName(name : String){
        this.name = name
    }

    fun getCardType():String = cardType
    fun setCardType(cardType: String){
        this.cardType = cardType
    }

    fun getPrice():Double = price
    fun setPrice(price : Double){
        this.price = price
    }

    fun getDiscount():Double = discount
    fun setDiscount(discount: Double){
        this.discount = discount
    }


   override fun toString(): String {
        return "Order Details (name = '$name', cardType ='$cardType', price = '$price', discount ='$discount'"
    }

//    override fun toString(): String {
//        return super.toString()
//    }
}
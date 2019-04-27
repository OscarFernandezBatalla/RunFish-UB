package com.example.frponsll40alumnes.runfish.fish

class BlowFish(name: String = "BlowFish",
               life: Int = 20,
               capacity: Int = 20,
               ability: String = "shield",
               price: Int = 2000) :
    Fish(name, life, capacity, ability, price) {
    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var width: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var height: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override var x: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var y: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var speed: Float
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

}
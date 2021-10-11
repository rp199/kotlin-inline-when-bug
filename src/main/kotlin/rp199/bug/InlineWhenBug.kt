package rp199.bug

inline fun inlineEnumWhen(someEnum: SomeEnum) = when(someEnum){
    SomeEnum.A -> println("This should work")
    else -> println("Nothing wrong with this")
}

enum class SomeEnum{A, B}

